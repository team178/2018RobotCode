package org.usfirst.frc.team178.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;

import org.usfirst.frc.team178.robot.RobotMap;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import edu.wpi.first.wpilibj.DoubleSolenoid;
/**
 *
 */
public class CubeShooter extends Subsystem {

    static TalonSRX left;
    static TalonSRX right;
    static DoubleSolenoid leftpiston;
    static DoubleSolenoid rightPiston;
    
    public CubeShooter () {
    	left = new TalonSRX(RobotMap.SHOOTERleft);
    	right = new TalonSRX(RobotMap.SHOOTERright);
    	leftpiston = new DoubleSolenoid(RobotMap.PCM, RobotMap.SHOOTERout);
    	//rightPiston = new DoubleSolenoid(RobotMap.PCM, RobotMap.SHOOTERin);
    	//I DONT THINK I DID THIS RIGHT NOOOOOOOOOOOOOOOOOOO -- Robbie
    	
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

