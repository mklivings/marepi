package com.marepi;

import java.time.Duration;

import com.pi4j.Pi4J;

public class Servo extends Component{

    public void runServo() {

        var pi4j = Pi4J.newAutoContext();

        final var servoMotor = new ServoMotor(pi4j, PIN.D22, 50, -90.0f, 90.0f, 2.0f, 12f);

        // Demonstrate the percentage mapping on the servo
        System.out.println("In 2 seconds, the servo motor will move to the left-most position which is 0%");
        delay(Duration.ofSeconds(2));
        servoMotor.setPercent(0);

        System.out.println("In another 2 seconds, the servo motor will show 100% by moving to the right-most position");
        delay(Duration.ofSeconds(2));
        servoMotor.setPercent(100);

        System.out.println("Last but not least, in 2 more seconds the servo will be centered to display 50%");
        delay(Duration.ofSeconds(2));
        servoMotor.setPercent(50);
        
        // Sweep once from left to right using the setAngle function
        System.out.println("We will sweep once to the left in 2 seconds...");
        delay(Duration.ofSeconds(2));
        servoMotor.setAngle(-45);

        System.out.println("... and now to the right in 2 more seconds!");
        delay(Duration.ofSeconds(2));
        servoMotor.setAngle(45);

        // Use a custom range for displaying the data
        System.out.println("Imagine a pointer on the servo positioned above a label between -20ºC and +40ºC");
        System.out.println("By using the setRange() method, we can automatically map our temperature range to the servo range!");
        System.out.println("As an example, in five seconds the servo will show -10º which should be on the far left of the servo.");
        delay(Duration.ofSeconds(2));

        servoMotor.setRange(-20, +40); // This will define our range as values between -20 and +40
        servoMotor.moveOnRange(-10); // This will map -10 based on the previously defined range

        servoMotor.reset();
    }
    
}
