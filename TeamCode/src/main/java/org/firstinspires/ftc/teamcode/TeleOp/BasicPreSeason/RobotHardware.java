//package org.firstinspires.ftc.teamcode.TeleOp.BasicPreSeason;
//
//import com.qualcomm.robotcore.hardware.DcMotor;
//import com.qualcomm.robotcore.hardware.DcMotorEx;
//import com.qualcomm.robotcore.hardware.DcMotorSimple;
//import com.qualcomm.robotcore.hardware.HardwareMap;
//import com.qualcomm.robotcore.hardware.Servo;
//import com.qualcomm.robotcore.util.ElapsedTime;
//
//public class RobotHardware {
//    public ElapsedTime runtime = new ElapsedTime();
//
//    public DcMotorEx bl,br,fl,fr;
//    public DcMotorEx intake, ts, flywheelN, flywheelP;
//    public Servo turret_turntableN, turret_turntableP, hood1, hood2, flowerHood1, flowerHood2;
//    public HardwareMap hardwareMap;
//
//    public RobotHardware() {
//
//    }
//
//    public void init (HardwareMap hardwareMap) {
//        this.hardwareMap = hardwareMap;
//
//        bl = hardwareMap.get(DcMotorEx.class, "chm2");
//        br = hardwareMap.get(DcMotorEx.class, "chm3");
//        fl = hardwareMap.get(DcMotorEx.class, "chm0");
//        fr = hardwareMap.get(DcMotorEx.class, "chm1");
//        intake = hardwareMap.get(DcMotorEx.class, "ehm0");
//        ts = hardwareMap.get(DcMotorEx.class, "ehm1");
//        flywheelN = hardwareMap.get(DcMotorEx.class, "ehm2");
//        flywheelP = hardwareMap.get(DcMotorEx.class, "ehm3");
//
//
//        turret_turntableN = hardwareMap.get(Servo.class, "chs0");
//        turret_turntableP = hardwareMap.get(Servo.class, "chs1");
//        hood1 = hardwareMap.get(Servo.class, "chs2");
//        hood2 = hardwareMap.get(Servo.class, "chs3");
//        flowerHood1 = hardwareMap.get(Servo.class, "ehs0");
//        flowerHood2 = hardwareMap.get(Servo.class, "ehs1");
//
//
//
//
//        bl.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
//        br.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
//        fl.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
//        fr.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
//
//        bl.setDirection(DcMotorEx.Direction.FORWARD);
//        br.setDirection(DcMotorEx.Direction.REVERSE);
//        fl.setDirection(DcMotorEx.Direction.FORWARD);
//        fr.setDirection(DcMotorEx.Direction.REVERSE);
//
//        flywheelP.setDirection(DcMotorEx.Direction.REVERSE);
//        flywheelP.setZeroPowerBehavior(DcMotorEx.ZeroPowerBehavior.BRAKE);
//
//        flywheelN.setDirection(DcMotorEx.Direction.FORWARD);
//        flywheelN.setZeroPowerBehavior(DcMotorEx.ZeroPowerBehavior.BRAKE);
//
//    }
//    public static double headingPos(double targetPoseX, double targetPoseY, double currX, double currY) {
//        double deltaX = targetPoseX - currX;
//        double deltaY = targetPoseY - currY;
//        return Math.atan(deltaY / deltaX);
//    }
//}
