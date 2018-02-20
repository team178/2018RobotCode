package org.usfirst.frc.team178.robot.subsystems;

import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.command.Subsystem;

import org.usfirst.frc.team178.robot.RobotMap;

//import com.ctre.phoenix.motorcontrol.ControlMode;
//import com.ctre.phoenix.motorcontrol.can.TalonSRX;

/**
 *
 */
public class Climber extends Subsystem {

	public static Talon rotationMotor;
	public static Talon winchMotor1;
	public static Talon winchMotor2;
	
	public Climber() {
		rotationMotor = new Talon(RobotMap.CLIMBER);
		winchMotor1 = new Talon(RobotMap.WINCH1);
		winchMotor2 = new Talon(RobotMap.WINCH2);
	}
	
	public void rotate(double speed) {
		rotationMotor.set(-speed);
	}
	
	public void climb(double speed) {
		winchMotor1.set(speed);
		winchMotor2.set(speed);
	}
	

    public void initDefaultCommand() {

    }
}

