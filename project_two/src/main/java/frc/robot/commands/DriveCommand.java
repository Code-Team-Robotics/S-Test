package frc.robot.commands;


import edu.wpi.first.wpilibj.command.Command;
import frc.robot.subsystems.DriveTrainSubsystem;
import edu.wpi.first.wpilibj.Joystick;

public class DriveCommand extends Command {
    private final DriveTrainSubsystem driveTrainSubsystem;
    private final Joystick joystick;
    // private long lastTime


    public DriveCommand(DriveTrainSubsystem driveTrainSubsystem, Joystick joystick){
        requires(driveTrainSubsystem);
        this.driveTrainSubsystem = driveTrainSubsystem;
        this.joystick = joystick;
    }
    @Override
    protected void initialize() {}

    @Override
    protected void execute(){
        //driveTrainSubsystem.setVictorToMax();
        driveTrainSubsystem.move();
    }

    @Override
    protected boolean isFinished(){
        return false;
    }

    @Override
    protected void end(){
        // Stop the motors by setting them to zero
        driveTrainSubsystem.chillOut();
    }

    @Override
    protected void interrupted() {
        end();
    }

}
