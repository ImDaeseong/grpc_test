package com.daeseong.grpcclient_test

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import io.grpc.ManagedChannel
import io.grpc.ManagedChannelBuilder
import io.grpc.stub.StreamObserver
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {

    private val tag = MainActivity::class.java.simpleName

    private lateinit var button1: Button
    private lateinit var button2: Button

    private lateinit var channel: ManagedChannel
    private lateinit var stub: MyServiceGrpc.MyServiceStub

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        button1 = findViewById(R.id.button1)
        button2 = findViewById(R.id.button2)

        button1.setOnClickListener {

            GlobalScope.launch(Dispatchers.IO) {
                myMethod1("서버 프로시저 button1 호출")
            }
        }

        button2.setOnClickListener {
            GlobalScope.launch(Dispatchers.IO) {
                myMethod1("서버 프로시저 button2 호출")
            }
        }


        //gRPC 채널 초기화
        //channel = ManagedChannelBuilder.forAddress("아이피", 10011)
        channel = ManagedChannelBuilder.forAddress("localhost", 10011)
            .usePlaintext()
            .build()
        stub = MyServiceGrpc.newStub(channel)


        GlobalScope.launch(Dispatchers.IO) {
            myMethod1("서버 프로시저 호출")
            myMethod2("서버 프로시저 호출")
        }
    }

    private fun myMethod1(requestMessage: String) {
        val request = myRequest.newBuilder().setRequest(requestMessage).build()
        stub.myMethod1(request, object : StreamObserver<myResponse> {
            override fun onNext(response: myResponse) {
                Log.e(tag, response.response)
            }

            override fun onError(t: Throwable) {
                Log.e(tag, "Error: ${t.message}")
            }

            override fun onCompleted() {
                Log.e(tag, "myMethod1 완료")
            }
        })
    }

    private fun myMethod2(requestMessage: String) {
        val request = myRequest.newBuilder().setRequest(requestMessage).build()
        stub.myMethod2(request, object : StreamObserver<myResponse> {
            override fun onNext(response: myResponse) {
                Log.e(tag, response.response)
            }

            override fun onError(t: Throwable) {
                Log.e(tag, "Error: ${t.message}")
            }

            override fun onCompleted() {
                Log.e(tag, "myMethod2 완료")
            }
        })
    }

    override fun onDestroy() {
        super.onDestroy()

        channel.shutdown()
    }
}