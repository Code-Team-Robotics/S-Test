package frc.robot.subsystems;

//import frc.robot.subsystem;

import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.command.Subsystem;


public class DriveTrainSubsystem extends Subsystem{
    private final Talon talon01;
    private final int number = 0;

    public DriveTrainSubSystem(Talon t){
        if (t == null){
            throw new IllegalArgumentException("ERror");
        }
        this.talon01 = t;
        
    }



}
