## grpc_test

파이썬 : grpcio, grpcio-tools, protobuf, futures <br>
서비스 : python -m grpc_tools.protoc -Iprotos --python_out=. --grpc_python_out=. protos/myservice.proto
![server](https://github.com/ImDaeseong/grpc_test/assets/10001221/e318ab03-3185-4e6b-b188-6ce7a7a13e97)

### golang
Protocol Buffer 컴파일러 설치 - https://github.com/protocolbuffers/protobuf/releases/tag/v27.0-rc3 <br>
(제어판 > 시스템 > 고급 시스템 설정 > 환경 변수 > 시스템 변수 편집 > Path 편집 > 새로 만들기 > protoc.exe 파일의 경로 입력) <br>

go get -u google.golang.org/grpc <br>
go get -u github.com/golang/protobuf/protoc-gen-go <br>
