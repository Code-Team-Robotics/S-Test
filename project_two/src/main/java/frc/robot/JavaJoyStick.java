package frc.robot;

import edu.wpi.first.wpilibj.*;

public class JavaJoyStick extends Joystick {

    boolean[] buttonState;
    String bigGuy;
    public RoboStick(int port) {
        super(port);
        buttonState = new boolean[12];
        for(int i = 0; i < buttonState.length; i++){
            buttonState[i] = false;
        }
    }

    public double deadZone(double input) {
        double dead = .30;
        if (input < dead && input > -dead)
            return 0;
        else
            return input;
    }

    public double getDX(){
        return deadZone(this.getRawAxis(0));
    }

    public double getDY(){
        return deadZone(this.getRawAxis(1));
    }

    public double getDZ(){
        return .7 * deadZone(this.getRawAxis(2));
    }


}