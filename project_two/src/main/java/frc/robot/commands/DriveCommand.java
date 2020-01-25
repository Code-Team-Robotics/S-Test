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
    @Override
    protected void initialize(){}

    @Override
    protected void execute(){
        driveTrainSubsystem.setVictorToMax();
    }

    @Override
    protected boolean isFinished(){
        return false;
    }

    @Override
    protected void end(){
        driveTrainSubsystem.setVictorToZero();
    }

    @Override
    protected void interrupted() {
        end();
    }

}
