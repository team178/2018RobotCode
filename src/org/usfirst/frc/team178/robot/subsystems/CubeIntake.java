package org.usfirst.frc.team178.robot.subsystems;
import org.usfirst.frc.team178.robot.subsystems.*;
import org.usfirst.frc.team178.robot.RobotMap;

//import com.ctre.phoenix.motorcontrol.ControlMode;
//import com.ctre.phoenix.motorcontrol.can.TalonSRX;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.AnalogInput;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj.Talon;

/**
 *
 */
public class CubeIntake extends Subsystem {

    static Talon left;
    static Talon right;
    DoubleSolenoid piston;
    AnalogInput ultrasonicleft;
    AnalogInput ultrasonicright;
    
    public CubeIntake() {
    	left = new Talon(RobotMap.INTAKEleft);
    	right = new Talon(RobotMap.INTAKEright); 
    	piston = new DoubleSolenoid(RobotMap.PCM, RobotMap.INTAKEin, RobotMap.INTAKEout);
    	ultrasonicleft = new AnalogInput(RobotMap.ULTRASONICLEFTINPUT);
    	ultrasonicright = new AnalogInput(RobotMap.ULTRASONICRIGHTINPUT);
    }
    
    public void dropIntake(){
    	piston.set(DoubleSolenoid.Value.kReverse); //kReverse subject to change
    }
    
    public DoubleSolenoid.Value getIntake()
    {
    	return piston.get();
    }
    
    public void collectCubeLeft(double speed) {
    	left.set(speed);
    }
    
    public void collectCubeRight(double speed)
    {
    	right.set(-speed);
    }
    
    public void ejectCube(double speed) {
    	left.set(speed);
    	right.set(-speed);
    }
    
 

    public void foldIntake() {
    	piston.set(DoubleSolenoid.Value.kForward);

    }
    
    public double getLeftUltrasonic () {
    	return ultrasonicleft.getVoltage();
    }
    
    public double getRightUltrasonic () {
    	return ultrasonicright.getVoltage();
    }
    
  
    
    public void initDefaultCommand() {
    	
    }
}
