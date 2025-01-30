package org.firstinspires.ftc.teamcode.subsystems;



import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.hardware.DcMotor;

@TeleOp
public class NewClaw extends OpMode {
    //    public CRServo servo;
    public Servo servo2;
    public Servo servo1;

    @Override
    public void init() {
        servo2 = hardwareMap.get(Servo.class, "servo");
//      servo = hardwareMap.get(CRServo.class, "servo");
        servo1 = hardwareMap.get(Servo.class, "servoTwo");
//      servo = hardwareMap.get(CRServo.class, "servo");

    }

    @Override
    public void loop() {

        if(gamepad1.a){
            servo2.setPosition(0);
//            servo.setPower(1);
        }
        if(gamepad1.b){
            servo2.setPosition(1);
//            servo.setPower(-1);
        }
        if(gamepad1.y){
            servo1.setPosition(0);
//            servo.setPower(1);
        }
        if(gamepad1.x){
            servo1.setPosition(1);
//            servo.setPower(-1);
        } else {
            //servo2.setPower(0);
            //servo1.setPower(0);
        }

    }
}
