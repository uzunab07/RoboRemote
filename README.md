# RoboRemote
## Description
RoboRemote is an Android application that allows users to remotely control a robot by sending velocity commands via WebSocket communication. The app uses OkHttp to connect to a ROS-based robot over WebSocket and send linear and angular velocity commands based on user input from sliders. This real-time control allows for precise maneuvering of the robot directly from an Android device.

## Features
- Connect to ROS Robot: Easily connect to a ROS-powered robot using the robot's IP address.
- Adjust Linear and Angular Velocity: Control the robot’s movement by adjusting the linear and angular velocity sliders.
- Real-Time Feedback: See the updated velocity values in the app interface.

# Requirements
- Android Device with API level 21 or higher
- OkHttp Library for WebSocket communication
- ROS (Robot Operating System) setup on the robot, with the rosbridge_server package installed and running

# Installation
- Open a terminal and clone the project
  - ` git clone https://github.com/yourusername/RoboRemote.git `
- Open the project in Android Studio.

- Add the OkHttp dependency in build.gradle:

  - ` implementation 'com.squareup.okhttp3:okhttp:4.9.1' `

- Build and run the app on your Android device.

# Usage

- Launch the App: Open RoboRemote on your Android device.
- Connect to the Robot:
        Enter the IP address of the ROS-based robot in the provided field.
        Press the Connect button to establish a WebSocket connection.
- Control the Robot:
        Adjust the Linear Velocity slider to control the forward/backward movement.
        Adjust the Angular Velocity slider to control the rotation.
        The velocity values will be displayed on the screen as they are updated.

# Code Structure
 * MainActivity: The main UI controller that handles user input and manages the connection to the robot.
 * RobotController: The communication controller, handling WebSocket connection setup, sending velocity commands, and receiving messages from the robot.
