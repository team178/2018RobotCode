package org.usfirst.frc.team178.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;

import org.usfirst.frc.team178.robot.RobotMap;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

/**
 *
 */
public class Climber extends Subsystem {

	public static TalonSRX climbMotor;
	
	public Climber() {
		climbMotor = new TalonSRX(RobotMap.ClimberPort);
	}
	
	public void climb(double speed) {
		climbMotor.set(ControlMode.PercentOutput, speed);
	}

    public void initDefaultCommand() {

    }
}

