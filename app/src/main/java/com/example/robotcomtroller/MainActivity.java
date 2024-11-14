package com.example.robotcomtroller;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RobotController controller = new RobotController();



        SeekBar linear = findViewById(R.id.linear_vel_slider);
        SeekBar angular = findViewById(R.id.angular_vel_slider);
        TextView linear_vel = findViewById(R.id.linear_velocity);
        TextView angular_vel = findViewById(R.id.angular_velocity);
        TextView textViewStatus = findViewById(R.id.textViewStatus);
        EditText editTextRobotIp = findViewById(R.id.editTextRobotIP);
        Button btnConnect = findViewById(R.id.btnconnect);


//        Connecting to the Server
        btnConnect.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String robotIp = editTextRobotIp.getText().toString();
                if(robotIp.isEmpty()){
                    Toast.makeText(MainActivity.this, "Enter a valid IP", Toast.LENGTH_SHORT).show();
                }else{
                    controller.connectToRobot(robotIp);
                }

            }
        });



        linear_vel.setText(String.valueOf(linear.getProgress()));
        angular_vel.setText(String.valueOf(angular.getProgress()));

        linear.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                linear_vel.setText(String.valueOf(progress));
                controller.sendVelocityCommand((double)progress,0.0);
            }
            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }
            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        angular.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                angular_vel.setText(String.valueOf(progress));
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
    }
}