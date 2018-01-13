package org.usfirst.frc.team178.robot.subsystems;

import org.usfirst.frc.team178.robot.RobotMap;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class CubeIntake extends Subsystem {

    public static TalonSRX left;
    public static TalonSRX right;
    
    public CubeIntake() {
    	left = new TalonSRX(RobotMap.INTAKEleft);
    	right = new TalonSRX(RobotMap.INTAKEright);
    	
    
    }
    
    public void collectCube(double speed) {
    	right.set(ControlMode.PercentOutput, speed);
    	left.set(ControlMode.PercentOutput, -speed);
    }
    
    public void dropCube(double speed) {
    	right.set(ControlMode.PercentOutput, -speed);
    	left.set(ControlMode.PercentOutput, speed);
    	
    }

    public void initDefaultCommand() {
    	
    }
}

