package org.firstinspires.ftc.teamcode.TeleOp.BasicPreSeason;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.util.ElapsedTime;

public class RobotHardware {
    public ElapsedTime runtime = new ElapsedTime();

    public DcMotorEx bl,br,fl,fr;
    public DcMotorEx intake, ts, ts_g, flywheel;
    public HardwareMap hardwareMap;

    public RobotHardware() {

    }

    public void init (HardwareMap hardwareMap) {
        this.hardwareMap = hardwareMap;

        bl = hardwareMap.get(DcMotorEx.class, "chm2");
        br = hardwareMap.get(DcMotorEx.class, "chm3");
        fl = hardwareMap.get(DcMotorEx.class, "chm0");
        fr = hardwareMap.get(DcMotorEx.class, "chm1");
        intake = hardwareMap.get(DcMotorEx.class, "ehm1");
        ts = hardwareMap.get(DcMotorEx.class, "ehm2");
        flywheel = hardwareMap.get(DcMotorEx.class, "ehm0");
        ts_g = hardwareMap.get(DcMotorEx.class, "ehm3");

        bl.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        br.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        fl.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        fr.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);

        bl.setDirection(DcMotorEx.Direction.FORWARD);
        br.setDirection(DcMotorEx.Direction.REVERSE);
        fl.setDirection(DcMotorEx.Direction.FORWARD);
        fr.setDirection(DcMotorEx.Direction.REVERSE);

        flywheel.setDirection(DcMotorEx.Direction.REVERSE);
        flywheel.setZeroPowerBehavior(DcMotorEx.ZeroPowerBehavior.BRAKE);

    }
    public static double headingPos(double targetPoseX, double targetPoseY, double currX, double currY) {
        double deltaX = targetPoseX - currX;
        double deltaY = targetPoseY - currY;
        return Math.atan(deltaY / deltaX);
    }
}
