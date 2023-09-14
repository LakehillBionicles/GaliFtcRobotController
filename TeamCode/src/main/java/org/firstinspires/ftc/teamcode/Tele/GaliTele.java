package org.firstinspires.ftc.teamcode.Tele;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.teamcode.GaliHardware;

@TeleOp
public class GaliTele extends LinearOpMode {
    GaliHardware robot = new GaliHardware();
    public void runOpMode() {
        robot.init(hardwareMap);

        waitForStart();

        while (opModeIsActive()) {
            robot.fpd.setPower(-gamepad1.left_stick_y + gamepad1.left_stick_x + gamepad1.right_stick_x);
            robot.bpd.setPower(-gamepad1.left_stick_y - gamepad1.left_stick_x + gamepad1.right_stick_x);
            robot.fsd.setPower(-gamepad1.left_stick_y - gamepad1.left_stick_x - gamepad1.right_stick_x);
            robot.bsd.setPower(-gamepad1.left_stick_y + gamepad1.left_stick_x - gamepad1.right_stick_x);

            robot.shoulder.setPower(-gamepad2.left_stick_y);
            robot.elbow.setPower(-gamepad2.right_stick_y);

            if(gamepad2.left_bumper){
                robot.handPort.setPosition(robot.handPortOpen);
            }
            if (gamepad2.right_bumper){
                robot.handStar.setPosition(robot.handStarOpen);
            }
            if (gamepad2.left_trigger > 0){
                robot.handPort.setPosition(robot.handPortClosed);
            }
            if (gamepad2.right_trigger > 0){
                robot.handStar.setPosition(robot.handStarClosed);
            }
            if (gamepad2.a){
                robot.wrist.setPosition(robot.wristPickup);
            }
            if (gamepad2.b){
                robot.wrist.setPosition(robot.wristScore);
            }
        }

    }
}

