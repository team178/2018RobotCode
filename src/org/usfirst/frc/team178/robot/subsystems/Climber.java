package org.usfirst.frc.team178.robot.subsystems;

import edu.wpi.first.wpilibj.DoubleSolenoid;
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
	public static DoubleSolenoid armPiston;
	public static Talon winchMotor1;
	public static Talon winchMotor2;
	
	public Climber() {
		rotationMotor = new Talon(RobotMap.CLIMBER);
		winchMotor1 = new Talon(RobotMap.WINCH1);
		winchMotor2 = new Talon(RobotMap.WINCH2);
		armPiston = new DoubleSolenoid(RobotMap.PCM, RobotMap.climberArmOUT, RobotMap.climberArmIN);
	}
	
	public void rotate(double speed) {
		rotationMotor.set(-speed);
	}
	
	public void climb(double speed) {
		winchMotor1.set(speed);
		winchMotor2.set(speed);
	}
	
	public void retractArm() {
		armPiston.set(DoubleSolenoid.Value.kForward);
	}
	
	public void extendArm() {
		armPiston.set(DoubleSolenoid.Value.kReverse);
	}

    public void initDefaultCommand() {

    }
}

