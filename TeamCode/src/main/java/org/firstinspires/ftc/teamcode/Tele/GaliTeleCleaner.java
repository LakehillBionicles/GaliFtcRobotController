package org.firstinspires.ftc.teamcode.Tele;

import com.arcrobotics.ftclib.gamepad.GamepadEx;
import com.arcrobotics.ftclib.gamepad.GamepadKeys;
import static com.arcrobotics.ftclib.gamepad.GamepadKeys.Button.*;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.teamcode.GaliHardware;
import org.firstinspires.ftc.teamcode.Subsystems.ArmSubsystem;
import org.firstinspires.ftc.teamcode.Subsystems.ArmSubsystem.ArmPos;
import static org.firstinspires.ftc.teamcode.Subsystems.ArmSubsystem.ArmPos.*;


import org.firstinspires.ftc.teamcode.Subsystems.DriveSubsystem;
import org.firstinspires.ftc.teamcode.Subsystems.HandSubsystem;
import org.firstinspires.ftc.teamcode.Subsystems.HandSubsystem.HandPos;
import static org.firstinspires.ftc.teamcode.Subsystems.HandSubsystem.HandPos.*;

@TeleOp
public class GaliTeleCleaner extends LinearOpMode {
    GaliHardware robot = new GaliHardware();

    ArmSubsystem galiArm = new ArmSubsystem(robot.elbow, robot.shoulder, robot.wrist);
    HandSubsystem galiHand = new HandSubsystem(robot.handPort, robot.handStar);
    DriveSubsystem galiDrive = new DriveSubsystem(robot.fpd, robot.bpd, robot.fsd, robot.bsd);

    GamepadEx baseController = new GamepadEx(gamepad1);
    GamepadEx armController = new GamepadEx(gamepad2);
    public void runOpMode() {
        robot.init(hardwareMap);
        galiArm.resetArm();

        waitForStart();

        while (opModeIsActive()) {
            galiDrive.setDrivePowerTele(-baseController.getLeftY(), baseController.getLeftX(), baseController.getRightX());

            galiArm.setArmPos(getArmPos());

            galiHand.setHandPosPort(getHandPosPort());
            galiHand.setHandPosStar(getHandPosStar());
        }
    }
    public ArmPos getArmPos(){
        ArmPos armPos = null;
        if(armController.getButton(DPAD_DOWN)){ armPos = DOWN_FRONT;}
        if(armController.getButton(DPAD_LEFT)){ armPos = LOW_FRONT;}
        if(armController.getButton(DPAD_UP)){ armPos = HIGH_FRONT;}
        if(armController.getButton(DPAD_RIGHT)){ armPos = MID_FRONT;}
        if(armController.getButton(X)){ armPos = LOW_BACK;}
        if(armController.getButton(Y)){ armPos = HIGH_BACK; }
        if(armController.getButton(B)){ armPos = MID_BACK;}

        return armPos;
    }

    public HandPos getHandPosPort(){
        HandPos handPos = null;
        if(armController.getButton(LEFT_BUMPER)){
            handPos = CLOSED;
        } else if (armController.getTrigger(GamepadKeys.Trigger.LEFT_TRIGGER)>0){
            handPos = OPEN;
        }

        return handPos;
    }

    public HandPos getHandPosStar(){
        HandPos handPos = null;
        if(armController.getButton(RIGHT_BUMPER)){
            handPos = CLOSED;
        } else if (armController.getTrigger(GamepadKeys.Trigger.RIGHT_TRIGGER)>0){
            handPos = OPEN;
        }
        return handPos;
    }
}
