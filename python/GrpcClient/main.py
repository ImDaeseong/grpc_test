import grpc
import myservice_pb2
import myservice_pb2_grpc


def myClient():
    channel = grpc.insecure_channel('localhost:10011')
    stub = myservice_pb2_grpc.MyServiceStub(channel)
    request = myservice_pb2.myRequest(request='서버 프로시저 호출')

    try:
        response1 = stub.MyMethod1(request)
        print(response1.response)

        response2 = stub.MyMethod2(request)
        print(response2.response)
    except grpc.RpcError as e:
        print({e})


if __name__ == '__main__':
    myClient()
