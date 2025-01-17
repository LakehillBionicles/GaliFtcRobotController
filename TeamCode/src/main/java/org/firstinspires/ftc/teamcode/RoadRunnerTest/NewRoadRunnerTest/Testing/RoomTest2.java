package org.firstinspires.ftc.teamcode.RoadRunnerTest.NewRoadRunnerTest.Testing;

import com.acmerobotics.roadrunner.geometry.Pose2d;
import com.acmerobotics.roadrunner.geometry.Vector2d;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

import org.firstinspires.ftc.teamcode.RoadRunnerTest.NewRoadRunnerTest.drive.DriveConstants;
import org.firstinspires.ftc.teamcode.RoadRunnerTest.NewRoadRunnerTest.drive.SampleMecanumDrive;
import org.firstinspires.ftc.teamcode.RoadRunnerTest.NewRoadRunnerTest.trajectorysequence.TrajectorySequence;

@Autonomous
public class RoomTest2 extends LinearOpMode {
    @Override
    public void runOpMode() throws InterruptedException {
        SampleMecanumDrive drive = new SampleMecanumDrive(hardwareMap);

        TrajectorySequence traj1 = drive.trajectorySequenceBuilder(new Pose2d())
                .splineToConstantHeading(new Vector2d(25, 0), Math.toRadians(0))
                .splineToConstantHeading(new Vector2d(25, 22), Math.toRadians(1),
                        SampleMecanumDrive.getVelocityConstraint(20, DriveConstants.MAX_ANG_VEL, DriveConstants.TRACK_WIDTH),
                        SampleMecanumDrive.getAccelerationConstraint(15))
                .splineToConstantHeading(new Vector2d(46, 22), Math.toRadians(2),
                        SampleMecanumDrive.getVelocityConstraint(20, DriveConstants.MAX_ANG_VEL, DriveConstants.TRACK_WIDTH),
                        SampleMecanumDrive.getAccelerationConstraint(15))
                .splineToConstantHeading(new Vector2d(46, -3), Math.toRadians(5),
                        SampleMecanumDrive.getVelocityConstraint(20, DriveConstants.MAX_ANG_VEL, DriveConstants.TRACK_WIDTH),
                        SampleMecanumDrive.getAccelerationConstraint(15))
                .splineToConstantHeading(new Vector2d(67, -3), Math.toRadians(7),
                        SampleMecanumDrive.getVelocityConstraint(20, DriveConstants.MAX_ANG_VEL, DriveConstants.TRACK_WIDTH),
                        SampleMecanumDrive.getAccelerationConstraint(15))
                .splineToConstantHeading(new Vector2d(67, 17), Math.toRadians(9),
                        SampleMecanumDrive.getVelocityConstraint(20, DriveConstants.MAX_ANG_VEL, DriveConstants.TRACK_WIDTH),
                        SampleMecanumDrive.getAccelerationConstraint(15))
                .splineToConstantHeading(new Vector2d(117, 17), Math.toRadians(9),
                        SampleMecanumDrive.getVelocityConstraint(20, DriveConstants.MAX_ANG_VEL, DriveConstants.TRACK_WIDTH),
                        SampleMecanumDrive.getAccelerationConstraint(15))
                .build();

        waitForStart();

        if (isStopRequested()) return;

        drive.followTrajectorySequence(traj1);

    }
}
