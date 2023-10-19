package org.firstinspires.ftc.teamcode.Testing;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.ColorSensor;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

public class TestColorSensor extends LinearOpMode {

    ColorSensor color;

    @Override
    public void runOpMode() {

        color = hardwareMap.get(ColorSensor.class, "ColorSensor");

        waitForStart();

        while (opModeIsActive()) {
            telemetry.addData("Red Value", color.red());
            telemetry.addData("Green Value", color.green());
            telemetry.addData("Blue Value", color.blue());
            telemetry.update();
        }
    }
}
