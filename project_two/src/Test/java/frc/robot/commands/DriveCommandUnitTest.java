package frc.robot.commands;

import edu.wpi.first.wpilibj.command.CommandHelper;
import edu.wpi.first.wpilibj.command.SchedulerTestHelper;
import frc.robot.subsystems.DriveTrainSubsystem;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.concurrent.ExecutionException;

import static org.mockito.Mockito.*;

public class DriveCommandUnitTest {
    private SchedulerTestHelper schedulerTestHelper;

    @Before
    public void setUpSchedulerHelper() {
        schedulerTestHelper = new SchedulerTestHelper(20);
    }
    @After
    public void cleanUpSchedulerHelper() {
        schedulerTestHelper.destroy();
    }

    @Test
    public void itCanSetVictorSPXToMaxSpeed() throws InterruptedException, ExecutionException {
        DriveTrainSubsystem mockDriveTrainSubsystem = mock(DriveTrainSubsystem.class);
        //JoystickButton mockButton = mock(JoystickButton.class);

        DriveCommand classUnderTest = new DriveCommand(mockDriveTrainSubsystem);

        schedulerTestHelper.run(classUnderTest).forDuration(1).get();

        verify(mockDriveTrainSubsystem, atLeast(1)).setVictorToMax();
    }

    @Test
    public void itTurnsOffVictorSPXWhenStopping() throws InterruptedException, ExecutionException {
        DriveTrainSubsystem mockDriveTrainSubsystem = mock(DriveTrainSubsystem.class);
        DriveCommand classUnderTest = new DriveCommand(mockDriveTrainSubsystem);

        schedulerTestHelper.run(classUnderTest).forDuration(1).get();

        verify(mockDriveTrainSubsystem, times(1)).setVictorToZero();
    }

    @Test
    public void itRegistersTheCorrectSubsystems() {
        DriveTrainSubsystem mockDriveTrainSubsystem = mock(DriveTrainSubsystem.class);

        DriveCommand classUnderTest = new DriveCommand(mockDriveTrainSubsystem);

        Assert.assertTrue(CommandHelper.doesRequire(classUnderTest, mockDriveTrainSubsystem));
    }
}
