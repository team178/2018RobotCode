package org.usfirst.frc.team178.robot.subsystems;
import org.usfirst.frc.team178.robot.subsystems.*;
import org.usfirst.frc.team178.robot.RobotMap;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj.Talon;

/**
 *
 */
public class CubeIntake extends Subsystem {

    static Talon left;
    static Talon right;
    DoubleSolenoid rightPiston;
    DoubleSolenoid leftPiston;
    
    public CubeIntake() {
    	left = new Talon(RobotMap.INTAKEleft);
    	right = new Talon(RobotMap.INTAKEright); 
    	rightPiston = new DoubleSolenoid(RobotMap.PCM, RobotMap.INTAKErightin, RobotMap.INTAKErightout);
    	leftPiston = new DoubleSolenoid(RobotMap.PCM, RobotMap.INTAKEleftout, RobotMap.INTAKEleftin);
    }
    

    public void dropIntake(){
    	rightPiston.set(DoubleSolenoid.Value.kReverse); //kReverse subject to change
    	leftPiston.set(DoubleSolenoid.Value.kReverse); 

    }
    
    public DoubleSolenoid.Value getIntake()
    {
    	return leftPiston.get();
    }
    
    public void collectCube(double speed) {
    	right.set(speed);
    	left.set(speed);
    }
    
    public void ejectCube(/*double speed*/) {
    	//right1.set(ControlMode.PercentOutput, -speed);
    	//right2.set(ControlMode.PercentOutput, -speed);
    	//left1.set(ControlMode.PercentOutput, speed);
    	//left2.set(ControlMode.PercentOutput, speed);
    	// rightPiston.set(DoubleSolenoid.Value.kReverse); //kReverse subject to change

    	leftPiston.set(DoubleSolenoid.Value.kReverse); //kReverse subject to change

    }
    
 

    public void foldIntake() {
    	rightPiston.set(DoubleSolenoid.Value.kForward);
    	leftPiston.set(DoubleSolenoid.Value.kForward);

    }
    
   
  
    
    public void initDefaultCommand() {
    	
    }
}
