package org.firstinspires.ftc.teamcode.subsystems;



import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.CRServo;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.IMU;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.hardware.rev.RevHubOrientationOnRobot;
import org.firstinspires.ftc.robotcore.external.navigation.AngleUnit;

@TeleOp
public class servo extends OpMode {
    //    public CRServo servo;
    public Servo servo2;
    public Servo servo1;
    DcMotor motor;
    DcMotor mottor;
    DcMotor frontLeftMotor;
    DcMotor backLeftMotor;
    DcMotor frontRightMotor;
    DcMotor backRightMotor;

    @Override
    public void init() {
        servo2 = hardwareMap.get(Servo.class, "servo");
//      servo = hardwareMap.get(CRServo.class, "servo");
        servo1 = hardwareMap.get(Servo.class, "servoTwo");
//      servo = hardwareMap.get(CRServo.class, "servo");
        motor = hardwareMap.get(DcMotor.class, "motor");
        mottor = hardwareMap.get(DcMotor.class, "mottor");
        frontLeftMotor = hardwareMap.dcMotor.get("frontLeftMotor");
        backLeftMotor = hardwareMap.dcMotor.get("backLeftMotor");
        frontRightMotor = hardwareMap.dcMotor.get("frontRightMotor");
        backRightMotor = hardwareMap.dcMotor.get("backRightMotor");
        telemetry.addData("Hardware: ", "Initialized");
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
        //Drive Train
        //Drive Train

        frontRightMotor.setDirection(DcMotorSimple.Direction.REVERSE);
        backRightMotor.setDirection(DcMotorSimple.Direction.REVERSE);
        // Retrieve the IMU from the hardware map
        IMU imu = hardwareMap.get(IMU.class, "imu");
        // Adjust the orientation parameters to match your robot
        IMU.Parameters parameters = new IMU.Parameters(new RevHubOrientationOnRobot(
                RevHubOrientationOnRobot.LogoFacingDirection.UP,
                RevHubOrientationOnRobot.UsbFacingDirection.FORWARD));
        // Without this, the REV Hub's orientation is assumed to be logo up / USB forward
        imu.initialize(parameters);

            double y = -gamepad1.left_stick_y; // Remember, Y stick value is reversed
            double x = gamepad1.left_stick_x;
            double rx = gamepad1.right_stick_x;

            // This button choice was made so that it is hard to hit on accident,
            // it can be freely changed based on preference.
            // The equivalent button is start on Xbox-style controllers.
            if (gamepad1.options) {
                imu.resetYaw();
            }

            double botHeading = imu.getRobotYawPitchRollAngles().getYaw(AngleUnit.RADIANS);

            // Rotate the movement direction counter to the bot's rotation
            double rotX = x * Math.cos(-botHeading) - y * Math.sin(-botHeading);
            double rotY = x * Math.sin(-botHeading) + y * Math.cos(-botHeading);

            rotX = rotX * 1.1;  // Counteract imperfect strafing

            // Denominator is the largest motor power (absolute value) or 1
            // This ensures all the powers maintain the same ratio,
            // but only if at least one is out of the range [-1, 1]
            double denominator = Math.max(Math.abs(rotY) + Math.abs(rotX) + Math.abs(rx), 1);
            double frontLeftPower = (rotY + rotX + rx) / denominator;
            double backLeftPower = (rotY - rotX + rx) / denominator;
            double frontRightPower = (rotY - rotX - rx) / denominator;
            double backRightPower = (rotY + rotX - rx) / denominator;

            frontLeftMotor.setPower(frontLeftPower);
            backLeftMotor.setPower(backLeftPower);
            frontRightMotor.setPower(frontRightPower);
            backRightMotor.setPower(backRightPower);
        }
    }














   // }

   //     //servo.setPower(0);
    ///}
