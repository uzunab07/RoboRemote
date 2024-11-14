package com.example.robotcomtroller;

import android.util.Log;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import okhttp3.*;
import org.json.JSONObject;
public class RobotController {

    public  WebSocket webSocket;
    public OkHttpClient client = new OkHttpClient();

    final String  TAG = "ROBOTTIK";

    public void connectToRobot(String ip){
        Request request = new Request.Builder()
                .url("ws://"+ip+":9090")
                .build();

        webSocket = client.newWebSocket(request, new WebSocketListener() {
            @Override
            public void onFailure(@NonNull WebSocket webSocket, @NonNull Throwable t, @Nullable Response response) {
                Log.d(TAG, "Connection failed: "+ t.getMessage()) ;

            }

            @Override
            public void onMessage(@NonNull WebSocket webSocket, @NonNull String text) {
                Log.d(TAG, "Message from robot: " + text);
            }

            @Override
            public void onOpen(@NonNull WebSocket webSocket, @NonNull Response response) {
                Log.d(TAG, "onOpen: Connected to robot");
            }
        });
    }

    public void sendVelocityCommand(double linear, double angular){
//        creating the json format object to send
        try {
            JSONObject json = new JSONObject();
            json.put("op","publish");
            json.put("topic","/cmd_vel");

            JSONObject msg = new JSONObject();
            JSONObject linearObj = new JSONObject();
            linearObj.put("x",linear);
            linearObj.put("y",0);
            linearObj.put("z",0);
            msg.put("linear",linearObj);


            JSONObject angularObj = new JSONObject();
            angularObj.put("x",0);
            angularObj.put("y",0);
            angularObj.put("z",angular);
            msg.put("angular",angularObj);

            json.put("msg",msg);

            webSocket.send(json.toString());


        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

}
