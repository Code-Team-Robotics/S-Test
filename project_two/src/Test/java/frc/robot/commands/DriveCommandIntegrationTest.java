package frc.robot.commands;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.VictorSPX;
import edu.wpi.first.wpilibj.command.SchedulerTestHelper;
import frc.robot.subsystems.DriveTrainSubsystem;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.concurrent.ExecutionException;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.mock;

/**
 * Integration tests that make sure that when our command acts on a subsystem,
 * that the hardware within the subsystem does what we expect. It is called
 * integration because we are testing the integration of classes together
 * to see if they act on each other as expected.
 */
public class DriveCommandIntegrationTest {
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
    public void itCanSetVictorSPXToMax() throws InterruptedException, ExecutionException {
        VictorSPX mockVictorSPX = mock(VictorSPX.class);
        System.out.println("Successfully Mocked VictorSPX");

        DriveTrainSubsystem classUnderTest = new DriveTrainSubsystem(mockVictorSPX);
        System.out.println("Successfully Declared DriveTrainSubsystem");
        DriveCommand driveCommand = new DriveCommand(classUnderTest);
        System.out.println("Successfully Declared DriveCommand");

        schedulerTestHelper.run(driveCommand).forDuration(3).get();

        Mockito.verify(mockVictorSPX, atLeast(7)).set(ControlMode.PercentOutput, 1);
    }
}
