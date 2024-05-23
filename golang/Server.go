// Server
package main

import (
	"context"
	"fmt"
	"net"

	pb "src/ImDaeseong/myservice"

	"google.golang.org/grpc"
)

type server struct {
	pb.UnimplementedMyServiceServer
}

func (s *server) MyMethod1(ctx context.Context, in *pb.MyRequest) (*pb.MyResponse, error) {
	return &pb.MyResponse{Response: "MyMethod1: " + in.Request}, nil
}

func (s *server) MyMethod2(ctx context.Context, in *pb.MyRequest) (*pb.MyResponse, error) {
	return &pb.MyResponse{Response: "MyMethod2: " + in.Request}, nil
}

func main() {

	lis, err := net.Listen("tcp", ":10011")
	if err != nil {
		fmt.Printf(err.Error())
	}
	s := grpc.NewServer()
	pb.RegisterMyServiceServer(s, &server{})

	sMsg := fmt.Sprintf("서버 대기중 %v", lis.Addr())
	fmt.Println(sMsg)

	if err := s.Serve(lis); err != nil {
		fmt.Printf(err.Error())
	}
}
