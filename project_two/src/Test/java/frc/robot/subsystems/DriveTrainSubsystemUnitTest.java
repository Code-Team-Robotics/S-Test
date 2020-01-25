package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.VictorSPX;
import edu.wpi.first.hal.HAL;
import frc.robot.RobotMap;
import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;

import static org.mockito.Mockito.mock;

public class DriveTrainSubsystemUnitTest {
    /**
     * A test to make sure no one has cross-wired dependencies such
     * that our class is no longer testable.
     */
    @Test(expected = Test.None.class )
    public void itShouldInstantiateGivenAnSPX() {
        // Assemble
        VictorSPX victorSPX_01 = mock(VictorSPX.class);

        // Act
        DriveTrainSubsystem classUnderTest = new DriveTrainSubsystem(victorSPX_01);


        //Assert
        // Our test Decorator contains the assertion
    }

    @Test(expected = IllegalArgumentException.class)
    public void itShouldNotInstantiateWithANullSPX() {
        // Assemble

        // Act
        DriveTrainSubsystem classUnderTest = new DriveTrainSubsystem(null);
    }

    @Test(expected = IllegalAccessError.class)
    public void itShouldNotInstantiateWithNoSPX() {
        // Assemble

        // Act
        DriveTrainSubsystem classUnderTest = new DriveTrainSubsystem();
    }

    @Test
    public void itShouldSetVictorToMax() {
        // Assemble
        VictorSPX victorSPX_01 = mock(VictorSPX.class);
        DriveTrainSubsystem classUnderTest = new DriveTrainSubsystem(victorSPX_01);

        // Act
        classUnderTest.setVictorToMax();

        // Assert
        Mockito.verify(victorSPX_01, Mockito.times(1)).set(ControlMode.PercentOutput, 1);
    }

    @Test
    public void itShouldSetVictorToZero() {
        VictorSPX victorSPX_01 = mock(VictorSPX.class);
        DriveTrainSubsystem classUnderTest = new DriveTrainSubsystem(victorSPX_01);

        classUnderTest.setVictorToZero();

        Mockito.verify(victorSPX_01, Mockito.times(1)).set(ControlMode.PercentOutput, 0);
    }

    @Test
    public void itShouldReferenceID_4forVictorSPX() {
        Assert.assertEquals("Tell electrical team that the VictorSPX has changed, and update this test.", 4, RobotMap.ID_4);
    }


}
