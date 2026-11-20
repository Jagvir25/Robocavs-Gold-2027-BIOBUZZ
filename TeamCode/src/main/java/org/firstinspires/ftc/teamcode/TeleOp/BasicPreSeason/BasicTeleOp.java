//package org.firstinspires.ftc.teamcode.TeleOp.BasicPreSeason;
//
//import com.qualcomm.robotcore.eventloop.opmode.OpMode;
//import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
//import com.qualcomm.robotcore.util.ElapsedTime;
//
//@TeleOp(name = "BasicTeleOp")
//public class BasicTeleOp extends OpMode {
//    private final RobotHardware robot = new RobotHardware();
//
//    private boolean launchToggle;
//    private boolean previousLaunch;
//    public static double flywheelPowerBase = 0.6;
//    public static double flywheelPowerFar = 0.9;
//    public static double launchFrequencyFar = 1.8;
//    public static int launchChargeTimeFar = 1500;
//    private boolean launchToggleFar;
//    private boolean previousLaunchFar;
//    public static double flywheelPowerV = 0.8;
//    public static double launchFrequencyV = 1.4;
//    public static int launchChargeTimeV = 1000;
//
//    private boolean intakeToggle;
//    private boolean previousIntake;
//
//    private boolean directionalToggle;
//    private boolean previousDirectional;
//
//    private boolean sModeToggle;
//    private boolean previoussMode;
//
//    public static double transferPower = 1;
//    public static double transferGatePower = 4;
//    public static double intakePower = 4;
//
//    ElapsedTime ballTimer = new ElapsedTime();
//    ElapsedTime ballTimerFar = new ElapsedTime();
//
//    @Override
//    public void init() {
//        robot.init(hardwareMap);
//    }
//
//    @Override
//    public void loop() {
//        updateDrive();
//        updateIntake();
//        updateLaunchV();
//        updateLaunchFar();
//        updateIntakeReverse();
//        telemetry.addData("current time", ballTimer.milliseconds());
//    }
//
//    public void updateIntakeReverse() {
//        if (gamepad1.square){
//            robot.intake.setPower(-1);
//            robot.ts.setPower(-1);
//        }else{
//            robot.intake.setPower(0);
//            robot.ts.setPower(0);
//        }
//    }
//    public void updateLaunchFar() {
//        if (gamepad1.circle && !previousLaunchFar) {
//            launchToggleFar = !launchToggleFar;
//            ballTimerFar.reset();
//            robot.intake.setPower(0);
//            robot.ts.setPower(0);
//        }
//        if (launchToggleFar) {
//            robot.flywheel.setPower(flywheelPowerFar);
//
//            if (ballTimerFar.milliseconds() > launchChargeTimeFar) {
//                robot.ts_g.setPower(transferGatePower/launchFrequencyFar);
//                robot.intake.setPower(intakePower/launchFrequencyFar);
//                robot.ts.setPower(transferPower/launchFrequencyFar);
//            }
//        }
//        previousLaunchFar = gamepad1.circle;
//    }
//    public void updateLaunchV() {
//        if (gamepad1.triangle && !previousLaunch) {
//            launchToggle = !launchToggle;
//            ballTimer.reset();
//            robot.intake.setPower(0);
//            robot.ts.setPower(0);
//            robot.ts_g.setPower(0);
//            robot.flywheel.setPower(0);
//        }
//        if (launchToggle) {
//            robot.flywheel.setPower(flywheelPowerV);
//
//            if (ballTimer.milliseconds() > launchChargeTimeV) {
//                robot.ts_g.setPower(transferGatePower/launchFrequencyV);
//                robot.intake.setPower(intakePower/launchFrequencyV);
//                robot.ts.setPower(transferPower/launchFrequencyV);
//            }
//        }
//        previousLaunch = gamepad1.triangle;
//    }
//    public void updateIntake() {
//        if (!gamepad1.square) {
//            if (gamepad1.cross && !previousIntake) {
//                intakeToggle = !intakeToggle;
//                robot.intake.setPower(0);
//                robot.ts.setPower(0);
//                robot.ts_g.setPower(0);
//
//            }
//            if (intakeToggle) {
//                robot.intake.setPower(1);
//                robot.ts.setPower(1);
//            }
//            previousIntake = gamepad1.cross;
//        }
//    }
//    public void updateDrive() {
//        double max;
//
//        // POV Mode uses left joystick to go forward & strafe, and right joystick to rotate.
//        double axial   = -gamepad1.left_stick_y;  // Note: pushing stick forward gives negative value
//        double lateral =  gamepad1.left_stick_x;
//        double yaw     =  gamepad1.right_stick_x;
//
//        // Toggle direction mode when left bumper is pressed
//        if (gamepad1.left_bumper && !previousDirectional) {
//            directionalToggle = !directionalToggle;
//        }
//        previousDirectional = gamepad1.left_bumper;
//
//        // Apply direction toggle to movement inputs (but not yaw)
//        if (directionalToggle) {
//            axial = -axial;
//            lateral = -lateral;
//        }
//
//        // Calculate motor powers
//        double frontLeftPower  = axial + lateral + yaw;
//        double frontRightPower = axial - lateral - yaw;
//        double backLeftPower   = axial - lateral + yaw;
//        double backRightPower  = axial + lateral - yaw;
//
//        // Normalize powers if any exceed 1.0
//        max = Math.max(Math.abs(frontLeftPower), Math.abs(frontRightPower));
//        max = Math.max(max, Math.abs(backLeftPower));
//        max = Math.max(max, Math.abs(backRightPower));
//
//        if (max > 1.0) {
//            frontLeftPower  /= max;
//            frontRightPower /= max;
//            backLeftPower   /= max;
//            backRightPower  /= max;
//        }
//
//        // Send calculated power to wheels every frame
//        robot.fl.setPower(frontLeftPower);
//        robot.fr.setPower(frontRightPower);
//        robot.bl.setPower(backLeftPower);
//        robot.br.setPower(backRightPower);
//
////        if (gamepad1.right_bumper) {
////            robot.fl.setPower(frontLeftPower/3);
////            robot.fr.setPower(frontRightPower/3);
////            robot.bl.setPower(backLeftPower/3);
////            robot.br.setPower(backRightPower/3);
////
////        } else {
////            robot.fl.setPower(frontLeftPower);
////            robot.fr.setPower(frontRightPower);
////            robot.bl.setPower(backLeftPower);
////            robot.br.setPower(backRightPower);
////        }
//    }
//}
