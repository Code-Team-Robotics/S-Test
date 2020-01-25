package frc.robot.subsystems;

//import frc.robot.subsystem;

import com.ctre.phoenix.motorcontrol.can.VictorSPX;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.Talon;
import com.ctre.phoenix.motorcontrol.ControlMode;
import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.VictorSP;
import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.RobotMap;

import javax.naming.ldap.Control;


public class DriveTrainSubsystem extends Subsystem {

    private final int number = 0;
    public final VictorSPX frontLeft;
    public final VictorSPX frontRight;
    public final VictorSPX backLeft;
    public final VictorSPX backRight;
    public final Joystick joystick;

    public DriveTrainSubsystem(VictorSPX frontLeft, VictorSPX frontRight, VictorSPX backLeft, VictorSPX backRight, Joystick joystick){
        if (frontLeft == null || frontRight == null || backLeft == null || backRight == null || joystick == null){
            throw new IllegalAccessError("Constructor error, one or more arguments returned null, please check your arguments");
        }
        this.frontLeft = frontLeft;
        this.frontRight = frontRight;
        this.backLeft = backLeft;
        this.backRight = backRight;
        this.joystick = joystick;

    }


    /*public void setVictorToMax(){
        this.motor_1.set(ControlMode.PercentOutput, 1);
    }

    public void setVictorToZero() { this.motor_1.set(ControlMode.PercentOutput, 0); }
    */
    @Override
    protected void initDefaultCommand(){

    }

    public void driveForward(){
        this.frontLeft.set(ControlMode.PercentOutput, 1);
        this.backLeft.set(ControlMode.PercentOutput, -1);
        this.frontRight.set(ControlMode.PercentOutput, -1);
        this.backRight.set(ControlMode.PercentOutput, 1);
    }

    public void move(){
        frontRight.set(stickoBoyo.getDY() + stickoBoyo.getDX() + stickoBoyo.getDZ());
        frontLeft.set(-stickoBoyo.getDY() + stickoBoyo.getDX() + stickoBoyo.getDZ());
        backLeft.set(-stickoBoyo.getDY() - stickoBoyo.getDX() + stickoBoyo.getDZ());
        backRight.set(stickoBoyo.getDY() - stickoBoyo.getDX() + stickoBoyo.getDZ());
    }

    public void chillOut(){
        this.frontLeft.set(ControlMode.PercentOutput, 0);
        this.backLeft.set(ControlMode.PercentOutput, 0);
        this.frontRight.set(ControlMode.PercentOutput, 0);
        this.backRight.set(ControlMode.PercentOutput, 0);
    }




}


