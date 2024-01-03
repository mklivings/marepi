package com.marepi;


public class Main extends Component{
    public static void main(String[] args) {
        System.out.println("Hello world!");
        Servo servo = new Servo();
        servo.runServo();
    }
}