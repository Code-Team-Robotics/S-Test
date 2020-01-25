/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import edu.wpi.first.wpilibj.I2C;

/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap
{
    //PORTS
    public final static int Port_0 = 0;
    public final static int Port_1 = 1;
    public final static int Port_2 = 2;
    public final static int Port_3 = 3;
    public final static int Port_4 = 4;

    // Motor ID
    public final static int Motor_ID_1 = 1;
    public final static int Motor_ID_2 = 2;
    public final static int Motor_ID_3 = 3;
    public final static int Motor_ID_4 = 4;


    // Joystick IDs
    // Non-labeled elements are named to describe their location
    // Labeled elements describe their name on the joystick, NOT THEIR VALUE
    public final static int ID_TRIGGER = 0;
    public final static int ID_THUMB = 1;
    public final static int ID_3 = 2;
    public final static int ID_4 = 3;
    public final static int ID_5 = 4;
    public final static int ID_6 = 5;
    public final static int ID_7 = 6;
    public final static int ID_8 = 7;
    public final static int ID_9 = 8;
    public final static int ID_10 = 9;
    public final static int ID_11 = 10;
    public final static int ID_12 = 11;



    // I2C Ports
    public final static I2C.Port i2cPort = I2C.Port.kOnboard;

}