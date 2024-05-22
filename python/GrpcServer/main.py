from concurrent import futures
import grpc
import myservice_pb2
import myservice_pb2_grpc


class MyServiceCall(myservice_pb2_grpc.MyServiceServicer):
    def MyMethod1(self, request, context):
        print('MyMethod1:' + request.request)
        response_message = 'MyMethod1 ' + request.request
        return myservice_pb2.myResponse(response=response_message)

    def MyMethod2(self, request, context):
        print('MyMethod2:' + request.request)
        response_message = 'MyMethod2 ' + request.request
        return myservice_pb2.myResponse(response=response_message)


def myServer():
    server = grpc.server(futures.ThreadPoolExecutor(max_workers=10))
    myservice_pb2_grpc.add_MyServiceServicer_to_server(MyServiceCall(), server)
    server.add_insecure_port('[::]:10011')
    server.start()
    server.wait_for_termination()


if __name__ == '__main__':
    myServer()

