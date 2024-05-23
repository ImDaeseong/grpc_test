// Client
package main

import (
	"context"
	"fmt"
	pb "src/ImDaeseong/myservice"

	"google.golang.org/grpc"
)

func main() {

	conn, err := grpc.Dial("localhost:10011", grpc.WithInsecure())
	if err != nil {
		fmt.Printf(err.Error())
	}
	defer conn.Close()

	c := pb.NewMyServiceClient(conn)

	myMethod1, err := c.MyMethod1(context.Background(), &pb.MyRequest{Request: "Hello from client"})
	if err != nil {
		fmt.Printf(err.Error())
	}
	fmt.Println("MyMethod1: ", myMethod1.GetResponse())

	myMethod2, err := c.MyMethod2(context.Background(), &pb.MyRequest{Request: "Hello again from client"})
	if err != nil {
		fmt.Printf(err.Error())
	}
	fmt.Println("MyMethod2: ", myMethod2.GetResponse())
}
