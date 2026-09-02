package org.firstinspires.ftc.teamcode.TeleOp.BasicPreSeason;

import com.bylazar.configurables.annotations.Configurable;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.Servo;

@TeleOp (name = "DriveTele")
@Configurable
public class BasicTeleOp extends LinearOpMode {
    public DcMotorEx bl,br,fl,fr;
    public DcMotorEx intake, intake2, flywheel, turret;
    public Servo hood, hood2, ts_g;

    public static double flywheelvelocity = 1800;

    @Override
    public void runOpMode() throws InterruptedException {
        bl = hardwareMap.get(DcMotorEx.class, "..");
        br = hardwareMap.get(DcMotorEx.class, "..");
        fl = hardwareMap.get(DcMotorEx.class, "..");
        fr = hardwareMap.get(DcMotorEx.class, "..");
        intake = hardwareMap.get(DcMotorEx.class, "..");
        intake2 = hardwareMap.get(DcMotorEx.class, "..");
        flywheel = hardwareMap.get(DcMotorEx.class, "..");
        turret = hardwareMap.get(DcMotorEx.class, "..");

        hood = hardwareMap.get(Servo.class, "..");
        hood2 = hardwareMap.get(Servo.class, "..");
        ts_g = hardwareMap.get(Servo.class, "..");


        bl.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        br.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        fl.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        fr.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        bl.setDirection(DcMotorEx.Direction.REVERSE);
        br.setDirection(DcMotorEx.Direction.FORWARD);
        fl.setDirection(DcMotorEx.Direction.REVERSE);
        fr.setDirection(DcMotorEx.Direction.FORWARD);
        turret.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        turret.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        turret.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        flywheel.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        flywheel.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        flywheel.setZeroPowerBehavior(DcMotorEx.ZeroPowerBehavior.BRAKE);
        intake.setDirection(DcMotorEx.Direction.REVERSE);


        hood.setPosition(1);
        ts_g.setPosition(1);
        waitForStart();

        while (opModeIsActive()) {
            double max;

            // POV Mode uses left joystick to go forward & strafe, and right joystick to rotate.
            double axial = -gamepad1.left_stick_y;  // Note: pushing stick forward gives negative value
            double lateral = gamepad1.left_stick_x;
            double yaw = gamepad1.right_stick_x;

            // Calculate motor powers
            double frontLeftPower = axial + lateral + yaw;
            double frontRightPower = axial - lateral - yaw;
            double backLeftPower = axial - lateral + yaw;
            double backRightPower = axial + lateral - yaw;

            // Normalize powers if any exceed 1.0
            max = Math.max(Math.abs(frontLeftPower), Math.abs(frontRightPower));
            max = Math.max(max, Math.abs(backLeftPower));
            max = Math.max(max, Math.abs(backRightPower));

            if (max > 1.0) {
                frontLeftPower /= max;
                frontRightPower /= max;
                backLeftPower /= max;
                backRightPower /= max;
            }
            // Send calculated power to wheels every frame
            fl.setPower(frontLeftPower);
            fr.setPower(frontRightPower);
            bl.setPower(backLeftPower);
            br.setPower(backRightPower);

            if (gamepad1.cross) {
                intake.setPower(1);
            } else if (gamepad1.circle) {
                intake2.setPower(1);
            } else if (gamepad1.dpad_left) {
                turret.setPower(1);
            } else if (gamepad1.dpad_right) {
                turret.setPower(-1);
            } else if (gamepad1.square) {
                flywheel.setVelocity(flywheelvelocity);
            } else if (gamepad1.triangle) {
                ts_g.setPosition(0.1);
            } else {
                intake.setPower(0);
                intake2.setPower(0);
                turret.setPower(0);
                flywheel.setPower(0);
            }
            if (gamepad1.left_bumper) {
                ts_g.setPosition(1);
            } else if (gamepad1.right_bumper) {
                ts_g.setPosition(0);
            } else if (gamepad1.cross) {
                hood.setPosition(1);
            } else if (gamepad1.square) {
                hood.setPosition(0);
            }
            telemetry.addData("ticks of turret", turret.getCurrentPosition());
            telemetry.addData("ts_g position", ts_g.getPosition());
            telemetry.update();
        }
    }
}
