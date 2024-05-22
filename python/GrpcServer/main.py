from concurrent import futures
import grpc
import myservice_pb2
import myservice_pb2_grpc


class MyServiceCall(myservice_pb2_grpc.MyServiceServicer):
    def MyMethod(self, request, context):
        print('MyMethod:' + request.request)
        response_message = 'daeseong ' + request.request
        return myservice_pb2.myResponse(response=response_message)


def myserver():
    server = grpc.server(futures.ThreadPoolExecutor(max_workers=10))
    myservice_pb2_grpc.add_MyServiceServicer_to_server(MyServiceCall(), server)
    server.add_insecure_port('[::]:10011')
    server.start()
    server.wait_for_termination()


if __name__ == '__main__':
    myserver()

