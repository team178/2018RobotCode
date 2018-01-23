package org.usfirst.frc.team178.robot.subsystems;
import org.usfirst.frc.team178.robot.subsystems.*;
import org.usfirst.frc.team178.robot.RobotMap;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.TalonSRX;
import edu.wpi.first.wpilibj.DoubleSolenoid;

/**
 *
 */
public class CubeIntake extends Subsystem {

    static TalonSRX left1;
    static TalonSRX left2;
    static TalonSRX right1;
    static TalonSRX right2;
    DoubleSolenoid doublesolenoid;
    
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
    	doublesolenoid.set(DoubleSolenoid.Value.kReverse);
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
