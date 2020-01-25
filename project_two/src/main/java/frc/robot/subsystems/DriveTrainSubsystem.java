package frc.robot.subsystems;

//import frc.robot.subsystem;

import com.ctre.phoenix.motorcontrol.can.VictorSPX;
import edu.wpi.first.wpilibj.Talon;
import com.ctre.phoenix.motorcontrol.ControlMode;
import edu.wpi.first.wpilibj.command.Subsystem;


public class DriveTrainSubsystem extends Subsystem {
    private final VictorSPX motor_1;
    private final int number = 0;

    public DriveTrainSubsystem(VictorSPX t){
        if (t == null){
            throw new IllegalArgumentException("Null Exception, illegal argument error");
        }
        this.motor_1 = t;

    }

    public DriveTrainSubsystem(){
        throw new IllegalAccessError("Constructor error... please stop");
    }

    public void setVictorToMax(){
        this.motor_1.set(ControlMode.PercentOutput, 1);
    }

    public void setVictorToZero() { this.motor_1.set(ControlMode.PercentOutput, 0); }

    @Override
    protected void initDefaultCommand(){

    }

}


