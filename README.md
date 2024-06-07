## grpc_test

파이썬 : grpcio, grpcio-tools, protobuf, futures <br>
서비스 : python -m grpc_tools.protoc -Iprotos --python_out=. --grpc_python_out=. protos/myservice.proto
![server](https://github.com/ImDaeseong/grpc_test/assets/10001221/e318ab03-3185-4e6b-b188-6ce7a7a13e97)

### golang
Protocol Buffer 컴파일러 설치 - https://github.com/protocolbuffers/protobuf/releases/tag/v27.0-rc3 <br>
(제어판-시스템-고급 시스템 설정-환경 변수-시스템 변수 편집-Path 편집-새로 만들기-protoc.exe 파일 경로 입력) <br>

go install google.golang.org/protobuf/cmd/protoc-gen-go@latest <br>
go install google.golang.org/grpc/cmd/protoc-gen-go-grpc@latest <br>

go get -u google.golang.org/grpc <br>
go get -u google.golang.org/protobuf <br>

### grpc 서비스 생성
protoc -I ./protos myservice.proto --proto_path=. --go_out=. --go-grpc_out=. <br>

### Node.js
npm init -y <br>
npm install grpc @grpc/proto-loader <br>
npm install @grpc/grpc-js @grpc/proto-loader <br>

서버 시작 : node server.js

