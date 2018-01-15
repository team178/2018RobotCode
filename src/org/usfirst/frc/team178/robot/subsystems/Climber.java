package org.usfirst.frc.team178.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
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
		climbMotor.set(speed);
	}

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
}

