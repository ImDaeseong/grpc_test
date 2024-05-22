import grpc
import myservice_pb2
import myservice_pb2_grpc


def myClient():
    channel = grpc.insecure_channel('localhost:10011')
    stub = myservice_pb2_grpc.MyServiceStub(channel)
    request = myservice_pb2.myRequest(request='서버 프로시저 호출')

    try:
        response = stub.MyMethod(request)
        print('MyMethod:' + response.response)
    except grpc.RpcError as e:
        print({e})


if __name__ == '__main__':
    myClient()
