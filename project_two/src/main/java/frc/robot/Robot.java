
/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import com.ctre.phoenix.motorcontrol.can.VictorSPX;
import com.revrobotics.ColorSensorV3;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.util.Color;
import frc.robot.commands.DriveCommand;
import frc.robot.subsystems.DriveTrainSubsystem;


/**
 * The VM is configured to automatically run this class, and to call the
 * methods corresponding to each mode, as described in the TimedRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the build.gradle file in the
 * project.
 */
public class Robot extends TimedRobot
{
  // Declare hardware
  public final VictorSPX victorSPX_01;

  public final ColorSensorV3 colorSensorV3;

  // Declare subsystems
  private final DriveTrainSubsystem driveTrainSubsystem;
  // Declare commands
  private final DriveCommand driveCommand;
  // Declare command groups
  // private final CommandGroup exampleCommandGroup;
  // Declare Operator Interface (Joysticks, controllers)
  private final Joystick joystick;
  private final JoystickButton button;


  private Command autonomousCommand;
  private SendableChooser<Command> chooser = new SendableChooser<>();

  public Robot() {
    super();
    this.victorSPX_01 = new VictorSPX(RobotMap.ID_4);
    this.colorSensorV3 = new ColorSensorV3(RobotMap.i2cPort);

    this.joystick = new Joystick(RobotMap.Port_0);
    this.button = new JoystickButton(joystick, RobotMap.ID_1);

    this.driveTrainSubsystem = new DriveTrainSubsystem(victorSPX_01);
    this.driveCommand = new DriveCommand(driveTrainSubsystem);
    //this.exampleCommandGroup = new ExampleCommandGroup();
  }

  /**
   * Instead of using the OI class, this method contains that logic.
   * This allows all the hardware to be called in one place
   */
  public void wireUpOperatorInterface() {
    button.whileHeld(driveCommand);
  }


  /**
   * This method is run when the robot is first started up and should be
   * used for any initialization code.
   */
  @Override
  public void robotInit()
  {
    wireUpOperatorInterface();
    chooser.setDefaultOption("Default Auto", driveCommand);
    // chooser.addOption("My Auto", new MyAutoCommand());
    SmartDashboard.putData("Auto mode", chooser);
  }

  /**
   * This method is called every robot packet, no matter the mode. Use
   * this for items like diagnostics that you want ran during disabled,
   * autonomous, teleoperated and test.
   *
   * <p>This runs after the mode specific periodic methods, but before
   * LiveWindow and SmartDashboard integrated updating.
   */
  @Override
  public void robotPeriodic()
  {
    /**
     * The method GetColor() returns a normalized color value from the sensor and can be
     * useful if outputting the color to an RGB LED or similar. To
     * read the raw color, use GetRawColor().
     *
     * The color sensor works best when within a few inches from an object in
     * well lit conditions (the built in LED is a big help here!). The farther
     * an object is the more light from the surroundings will bleed into the
     * measurements and make it difficult to accurately determine its color.
     */
    Color detectedColor = colorSensorV3.getColor();

    /**
     * The sensor returns a raw IR value of the infrared light detected.
     */
    double IR = colorSensorV3.getIR();

    /**
     * Open Smart Dashboard or Shuffleboard to see the color detected by the
     * sensor.
     */
    SmartDashboard.putNumber("Red", detectedColor.red);
    SmartDashboard.putNumber("Green", detectedColor.green);
    SmartDashboard.putNumber("Blue", detectedColor.blue);
    SmartDashboard.putNumber("IR", IR);

    /**
     * In addition to RGB IR values, the color sensor can also return an
     * infrared proximity value. The chip contains an IR led which will emit
     * IR pulses and measure the intensity of the return. When an object is
     * close the value of the proximity will be large (max 2047 with default
     * settings) and will approach zero when the object is far away.
     *
     * Proximity can be used to roughly approximate the distance of an object
     * or provide a threshold for when an object is close enough to provide
     * accurate color values.
     */
    int proximity = colorSensorV3.getProximity();

    SmartDashboard.putNumber("Proximity", proximity);


  }

  /**
   * This method is called once each time the robot enters Disabled mode.
   * You can use it to reset any subsystem information you want to clear when
   * the robot is disabled.
   */
  @Override
  public void disabledInit()
  {

  }

  @Override
  public void disabledPeriodic()
  {
    Scheduler.getInstance().run();
  }

  /**
   * This autonomous (along with the chooser code above) shows how to select
   * between different autonomous modes using the dashboard. The sendable
   * chooser code works with the Java SmartDashboard. If you prefer the
   * LabVIEW Dashboard, remove all of the chooser code and uncomment the
   * getString code to get the auto name from the text box below the Gyro
   *
   * <p>You can add additional auto modes by adding additional commands to the
   * chooser code above (like the commented example) or additional comparisons
   * to the switch structure below with additional strings & commands.
   */
  @Override
  public void autonomousInit()
  {
    autonomousCommand = chooser.getSelected();

    /*
     * String autoSelected = SmartDashboard.getString("Auto Selector",
     * "Default"); switch(autoSelected) { case "My Auto": autonomousCommand
     * = new MyAutoCommand(); break; case "Default Auto": default:
     * autonomousCommand = new ExampleCommand(); break; }
     */

    // schedule the autonomous command (example)
    if (autonomousCommand != null)
    {
      autonomousCommand.start();
    }
  }

  /**
   * This method is called periodically during autonomous.
   */
  @Override
  public void autonomousPeriodic()
  {
    Scheduler.getInstance().run();
  }

  @Override
  public void teleopInit()
  {
    // This makes sure that the autonomous stops running when
    // teleop starts running. If you want the autonomous to
    // continue until interrupted by another command, remove
    // this line or comment it out.
    if (autonomousCommand != null)
    {
      autonomousCommand.cancel();
    }
  }

  /**
   * This method is called periodically during operator control.
   */
  @Override
  public void teleopPeriodic()
  {
    Scheduler.getInstance().run();
  }

  /**
   * This method is called periodically during test mode.
   */
  @Override
  public void testPeriodic()
  {

  }
}