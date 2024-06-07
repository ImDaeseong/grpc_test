using Grpc.Core;
using Myservice;
using System;


namespace gRPCServer
{
    internal class Program
    {
        static void Main(string[] args)
        {

            Server server = new Server
            {
                Services = { MyService.BindService(new MyServiceImplementation()) },
                Ports = { new ServerPort("localhost", 10011, ServerCredentials.Insecure) }
            };
            server.Start();

            Console.WriteLine("Press any key to stop the server...");
            Console.ReadKey();

            server.ShutdownAsync().Wait();
        }
    }
}
