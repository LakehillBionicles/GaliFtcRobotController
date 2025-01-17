package org.firstinspires.ftc.teamcode.RoadRunnerTest.NewRoadRunnerTest.Testing;

import com.acmerobotics.dashboard.config.Config;
import com.acmerobotics.roadrunner.geometry.Pose2d;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

import org.firstinspires.ftc.teamcode.RoadRunnerTest.NewRoadRunnerTest.drive.SampleMecanumDrive;
@Disabled
@Config
@Autonomous
public class Turn180 extends LinearOpMode {
    public TestHwMap robot = new TestHwMap();

    //public double xTarget = 23.5;
    //public double yTarget = 0;

    public void runOpMode(){
        robot.init(hardwareMap);
        SampleMecanumDrive drive = new SampleMecanumDrive(hardwareMap);

        Pose2d startPose = new Pose2d(0, 0, Math.toRadians(0));
        drive.setPoseEstimate(startPose);

        waitForStart();

        if(isStopRequested()) return;

        drive.turn(Math.toRadians(180));
    }

}
