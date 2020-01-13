package frc.robot.subsystems;

//import frc.robot.subsystem;

import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.command.Subsystem;


public class DriveTrainSubsystem extends Subsystem {
    private final Talon talon01;
    private final int number = 0;

    public DriveTrainSubsystem(Talon t){
        if (t == null){
            throw new IllegalArgumentException("ERror");
        }
        this.talon01 = t;

    }

    public DriveTrainSubsystem(){
        throw new IllegalAccessError("Constructor error... please stop");
    }

    /*public void turnOnLED(){
        if (number == 5){
            led.set(true);
        }*/
    public void setTalon01ToMaxPower(){
        talon01.setSpeed(69);
    }

    @Override
    public void initDefaultCommand(){

    }
}


