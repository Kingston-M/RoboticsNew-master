package org.firstinspires.ftc.teamcode.subsystems;



import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.hardware.DcMotor;

@TeleOp
public class NewMotorArm extends OpMode {
    //    public CRServo servo;

    DcMotor motor;
    DcMotor mottor;


    @Override
    public void init() {

        motor = hardwareMap.get(DcMotor.class, "motor");
        mottor = hardwareMap.get(DcMotor.class, "mottor");

    }

    @Override
    public void loop() {


        if(gamepad1.left_trigger > 0){
            motor.setPower(0.5);
            motor.setDirection(DcMotorSimple.Direction.FORWARD);
        } else {
            motor.setPower(0);
            motor.setDirection(DcMotorSimple.Direction.REVERSE);
        }
        if(gamepad1.right_trigger > 0) {
            motor.setPower(0.5);
            motor.setDirection(DcMotorSimple.Direction.REVERSE);
        } else {
            motor.setPower(0);
            motor.setDirection(DcMotorSimple.Direction.FORWARD);
        }


        if (gamepad1.right_bumper){
            mottor.setPower(1);
            mottor.setDirection(DcMotorSimple.Direction.REVERSE);
        } else {
            mottor.setPower(0);
            mottor.setDirection(DcMotorSimple.Direction.REVERSE);
        }
        if (gamepad1.right_bumper) {
            mottor.setPower(1);
            mottor.setDirection(DcMotorSimple.Direction.REVERSE);
        } else {
            mottor.setPower(0);
            mottor.setDirection(DcMotorSimple.Direction.REVERSE);
        }

    }
}
