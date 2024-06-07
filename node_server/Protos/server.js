const grpc = require('@grpc/grpc-js');
const protoLoader = require('@grpc/proto-loader');
const PATH = './Protos/myservice.proto';

const packageDefinition = protoLoader.loadSync(PATH, {
    keepCase: true,
    longs: String,
    enums: String,
    defaults: true,
    oneofs: true
  });
  const myservice_proto = grpc.loadPackageDefinition(packageDefinition).myservice;
 
  function myMethod1(call, callback) {
    callback(null, { response: 'MyMethod1:' + call.request.request });
  }
  
  function myMethod2(call, callback) {
    callback(null, { response: 'MyMethod2:' + call.request.request });
  }

  function main() {
    const server = new grpc.Server();
    server.addService(myservice_proto.MyService.service, {
      MyMethod1: myMethod1,
      MyMethod2: myMethod2
    });
    const address = 'localhost:10011';
    server.bindAsync(address, grpc.ServerCredentials.createInsecure(), () => {
      console.log(`Server running at ${address}`);
      server.start();
    });
  }

  main();