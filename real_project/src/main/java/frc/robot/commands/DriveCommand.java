package frc.robot.commands;


import edu.wpi.first.wpilibj.command.Command;
import frc.robot.subsystems.DriveTrainSubsystem;

public class DriveCommand extends Command {
    private final DriveTrainSubsystem driveTrainSubsystem;
    // private long lastTime


    public DriveCommand(DriveTrainSubsystem driveTrainSubsystem){
        requires(driveTrainSubsystem);
        this.driveTrainSubsystem = driveTrainSubsystem;
    }


}
