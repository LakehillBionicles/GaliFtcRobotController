package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;

public class GaliHardware extends LinearOpMode {
    public DcMotor fpd = null, bpd = null, fsd = null, bsd = null;
    public DcMotor elbow = null, shoulder = null;
    public Servo handPort = null, handStar = null, wrist = null;

    public double handPortOpen = 0, handPortClosed = 0;
    public double handStarOpen = 0, handStarClosed = 0;

    public double wristScore = 0, wristPickup = 0;

    HardwareMap hwMap = null;

    public GaliHardware() {
    }

    @Override
    public void runOpMode() {
    }

    public void init(HardwareMap ahwMap) {
        hwMap = ahwMap;

        fpd = hwMap.get(DcMotorEx.class, "fpd" );
        bpd = hwMap.get(DcMotor.class, "bpd");
        fsd = hwMap.get(DcMotor.class, "fsd");
        bsd = hwMap.get(DcMotor.class, "bsd");

        elbow = hwMap.get(DcMotor.class, "elbow");
        shoulder = hwMap.get(DcMotor.class,"shoulder");

        handPort = hwMap.get(Servo.class, "handPort");
        handStar = hwMap.get(Servo.class, "handStar");
        wrist = hwMap.get(Servo.class, "wrist");

        fpd.setDirection(DcMotorSimple.Direction.FORWARD);
        bpd.setDirection(DcMotorSimple.Direction.FORWARD);
        fsd.setDirection(DcMotorSimple.Direction.FORWARD);
        bsd.setDirection(DcMotorSimple.Direction.FORWARD);

        elbow.setDirection(DcMotorSimple.Direction.FORWARD);
        shoulder.setDirection(DcMotorSimple.Direction.FORWARD);

        fpd.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        bpd.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        fsd.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        bsd.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);

        elbow.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        shoulder.setMode(DcMotor.RunMode.RUN_USING_ENCODER);

        fpd.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        bpd.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        fsd.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        bsd.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);

        elbow.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        shoulder.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);


    }
}
