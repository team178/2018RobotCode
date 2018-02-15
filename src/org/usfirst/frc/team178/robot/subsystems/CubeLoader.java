package org.usfirst.frc.team178.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;

import org.usfirst.frc.team178.robot.RobotMap;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

/**
 *
 */
public class CubeLoader extends Subsystem {

    static TalonSRX left;
    static TalonSRX right;
    
    public CubeLoader () {
    	left = new TalonSRX(RobotMap.LOADERleft);
    	right = new TalonSRX(RobotMap.LOADERright);
    }
    
    public void loadCube(double speed) {
    	left.set(ControlMode.PercentOutput, -speed);
    	right.set(ControlMode.PercentOutput, speed);
    }

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
}

