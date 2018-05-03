package org.usfirst.frc.team178.robot.subsystems;

import org.usfirst.frc.team178.robot.RobotMap;

import edu.wpi.first.wpilibj.AnalogInput;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.Ultrasonic;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Ramp extends Subsystem {
	
	public static Talon left1;
	public static Talon left2;
	public static Talon right1;
	public static Talon right2;
	public static DoubleSolenoid shootingPiston;
	//public static DoubleSolenoid extendingArm;
	public static AnalogInput ultrasonic;
    // Put methods for controlling this subsystem
    // here. Call these from Commands.

	public Ramp() {
		left1 = new Talon(RobotMap.RAMPleft1);
		left2 = new Talon(RobotMap.RAMPleft2);
		right1 = new Talon(RobotMap.RAMPright1);
		right2 = new Talon(RobotMap.RAMPright2);
		shootingPiston = new DoubleSolenoid(RobotMap.PCM, RobotMap.shootingPistonOUT, RobotMap.shootingPistonIN);
		//extendingArm = new DoubleSolenoid(RobotMap.PCM, RobotMap.extendArm, RobotMap.retractArm);
	}
	
	public void bringCubeIn(double speed) {
		left1.set(-speed);
		right1.set(-speed);
	}
	
	public void shootCube(double speed) {
		left2.set(-speed);
		right2.set(-speed);
	}
	public void stopLoading() {
		left1.set(0);
		right1.set(0);
	}
	
	public void stopShooting() {
		left2.set(0);
		right2.set(0);
	}
	
	public double getDistance() {
		return ultrasonic.getVoltage();
	}
	//Stuff to go for scale, do not delete
	
	public void punchCube() {
		shootingPiston.set(DoubleSolenoid.Value.kReverse);
	}
	
	public void resetPiston() {
		shootingPiston.set(DoubleSolenoid.Value.kForward);
	}
	
	/* public void retractArm() {
		extendingArm.set(DoubleSolenoid.Value.kForward);
	}
	
	public void extendArm() {
		extendingArm.set(DoubleSolenoid.Value.kReverse);
	}
	*/	
	
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
}

