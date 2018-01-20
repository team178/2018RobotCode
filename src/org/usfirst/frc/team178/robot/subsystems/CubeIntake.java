package org.usfirst.frc.team178.robot.subsystems;

import org.usfirst.frc.team178.robot.RobotMap;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class CubeIntake extends Subsystem {

    public static TalonSRX left1;
    public static TalonSRX left2;
    public static TalonSRX right1;
    public static TalonSRX right2;
    
    public CubeIntake() {
    	left1 = new TalonSRX(RobotMap.INTAKEleft1);
    	left2 = new TalonSRX(RobotMap.INTAKEleft2);
    	right1 = new TalonSRX(RobotMap.INTAKEright1);
    	right2 = new TalonSRX(RobotMap.INTAKEright2);
    	
    
    }
    
    public void collectCube(double speed) {
    	right1.set(ControlMode.PercentOutput, speed);
    	right2.set(ControlMode.PercentOutput, speed);
    	left1.set(ControlMode.PercentOutput, -speed);
    	left2.set(ControlMode.PercentOutput, -speed);
    }
    
    public void shootCube(double speed) {
    	right1.set(ControlMode.PercentOutput, -speed);
    	right2.set(ControlMode.PercentOutput, -speed);
    	left1.set(ControlMode.PercentOutput, speed);
    	left2.set(ControlMode.PercentOutput, speed);
    	
    }

    public void initDefaultCommand() {
    	
    }
}

