using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using Grpc.Core;
using Myservice;

namespace gRPCServer
{
    public class MyServiceImplementation : MyService.MyServiceBase
    {

        public override Task<myResponse> MyMethod1(myRequest request, ServerCallContext context)
        {
            Console.WriteLine(request.Request);
                        
            var response = new myResponse
            {
                Response = "MyMethod1: " + request.Request
            };
            return Task.FromResult(response);

            /*
            return Task.FromResult(new myResponse
            {
                Response = "MyMethod1: " + request.Request
            });
            */
        }

        public override Task<myResponse> MyMethod2(myRequest request, ServerCallContext context)
        {
            Console.WriteLine(request.Request);

            var response = new myResponse
            {
                Response = "MyMethod2: " + request.Request
            };
            return Task.FromResult(response);

            /*
            return Task.FromResult(new myResponse
            {
                Response = "MyMethod2: " + request.Request
            });
            */
        }
    }
}
