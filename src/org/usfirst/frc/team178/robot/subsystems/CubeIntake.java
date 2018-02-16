package org.usfirst.frc.team178.robot.subsystems;
import org.usfirst.frc.team178.robot.subsystems.*;
import org.usfirst.frc.team178.robot.RobotMap;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.DoubleSolenoid;

/**
 *
 */
public class CubeIntake extends Subsystem {

    static TalonSRX left1;
    static TalonSRX right1;
    DoubleSolenoid leftPiston;
    DoubleSolenoid rightPiston;
    
    public CubeIntake() {
    	left1 = new TalonSRX(RobotMap.INTAKEleft1);
    	//left2 = new TalonSRX(RobotMap.INTAKEleft2);
    	right1 = new TalonSRX(RobotMap.INTAKEright1);
    	//right2 = new TalonSRX(RobotMap.INTAKEright2);  
    	rightPiston = new DoubleSolenoid(RobotMap.PCM, RobotMap.INTAKErightin, RobotMap.INTAKErightout);
    	leftPiston = new DoubleSolenoid(RobotMap.PCM, RobotMap.INTAKEleftout, RobotMap.INTAKEleftin);
    }
    
    public void collectCube(double speed) {
    	right1.set(ControlMode.PercentOutput, speed);
    	left1.set(ControlMode.PercentOutput, -speed);
    	leftPiston.set(DoubleSolenoid.Value.kReverse); 
    }
    
    public void ejectCube(double speed) {
    	right1.set(ControlMode.PercentOutput, -speed);
    	//right2.set(ControlMode.PercentOutput, -speed);
    	left1.set(ControlMode.PercentOutput, speed);
    	//left2.set(ControlMode.PercentOutput, speed);
    	rightPiston.set(DoubleSolenoid.Value.kReverse); //kReverse subject to change
    	leftPiston.set(DoubleSolenoid.Value.kReverse); 
    }

    public void foldIntake() {
    	rightPiston.set(DoubleSolenoid.Value.kForward);
    	leftPiston.set(DoubleSolenoid.Value.kForward);
    }
    
    public DoubleSolenoid.Value getIntake(){
    	return leftPiston.get();
    }
    
    public void initDefaultCommand() {
    	
    }
}
