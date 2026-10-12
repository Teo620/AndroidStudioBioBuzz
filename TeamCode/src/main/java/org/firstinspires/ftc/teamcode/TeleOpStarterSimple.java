package org.firstinspires.ftc.teamcode;

import com.acmerobotics.dashboard.config.Config;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;

@Config
@TeleOp(name="TeleOpStarter", group="Linear OpMode")
public class TeleOpStarterSimple extends OpMode {

    public DcMotor LFMotor = null;
    public DcMotor LBMotor = null;
    public DcMotor RFMotor = null;
    public DcMotor RBMotor = null;
    public DcMotor Intake = null;

    public void init()
    {
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
        double axial   = -gamepad1.left_stick_y;
        double lateral =  gamepad1.left_stick_x;
        double yaw     =  gamepad1.right_stick_x;

        double lfPow = axial + lateral + yaw;
        double rfPow = axial - lateral - yaw;
        double lbPow = axial - lateral + yaw;
        double rbPow = axial + lateral - yaw;

        double max = get_Max(lfPow,lbPow,rfPow,rbPow);

        if (max > 1.0) {
            lfPow /= max;
            rfPow /= max;
            lbPow /= max;
            rbPow /= max;
        }

        LFMotor.setPower(lfPow);
        RFMotor.setPower(rfPow);
        LBMotor.setPower(lbPow);
        RBMotor.setPower(rbPow);

    }
    public double get_Max(double p1,double p2, double p3, double p4){
        double max=0;
        max = Math.max(Math.abs(p1), Math.abs(p2));
        max = Math.max(max, Math.abs(p3));
        max = Math.max(max, Math.abs(p4));
        return max;
    }
}
