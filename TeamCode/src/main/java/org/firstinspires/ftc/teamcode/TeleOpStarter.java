package org.firstinspires.ftc.teamcode;

import com.acmerobotics.dashboard.config.Config;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import org.firstinspires.ftc.teamcode.Formula;
@Config
@TeleOp(name="TeleOpStarter", group="Linear OpMode")
public class TeleOpStarter extends OpMode {

    private Formula formula = new Formula(); //Cele mai bune formule
    public DcMotor LFMotor = null;
    public DcMotor LBMotor = null;
    public DcMotor RFMotor = null;
    public DcMotor RBMotor = null;
    public DcMotor Intake = null;

    public void init()
    {
        formula.init(hardwareMap, gamepad1);
        LFMotor = hardwareMap.get(DcMotor.class, "lf");
        LBMotor = hardwareMap.get(DcMotor.class, "lb");
        RFMotor = hardwareMap.get(DcMotor.class, "rf");
        RBMotor = hardwareMap.get(DcMotor.class, "rb");
        Intake = hardwareMap.get(DcMotor.class,"intake");
    }

    public void start()
    {

    }

    public void loop()
    {
        formula.driveJoystick(); //Face tot ce trebe baiatu


        if(gamepad1.x){
            Intake.setPower(1);
        }
        else if(gamepad1.circle){
            Intake.setPower(-1);
        }
        else{
            Intake.setPower(0);
        }
    }
}
