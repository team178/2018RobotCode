package org.usfirst.frc.team178.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;

import org.usfirst.frc.team178.robot.RobotMap;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
/**
 *
 */
public class CubeShooter extends Subsystem {

    static TalonSRX left;
    static TalonSRX right;
    
    public CubeShooter () {
    	left = new TalonSRX(RobotMap.SHOOTERleft);
    	right = new TalonSRX(RobotMap.SHOOTERright);
    	
    }
    
    public void shootCube (double speed) {
    	left.set(ControlMode.PercentOutput, -speed);
    	right.set(ControlMode.PercentOutput, speed);
    	
    	
    }

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
}

