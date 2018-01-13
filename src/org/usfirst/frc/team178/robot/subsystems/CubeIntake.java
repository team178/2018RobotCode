package org.usfirst.frc.team178.robot.subsystems;

import org.usfirst.frc.team178.robot.RobotMap;
import com.ctre.CANTalon;

import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class CubeIntake extends Subsystem {

    public static CANTalon left;
    public static CANTalon right;
    
    public CubeIntake() {
    	left = new CANTalon(RobotMap.INTAKEleft);
    	right = new CANTalon(RobotMap.INTAKEright);
    	
    
    }
    
    public void collectCube(double speed) {
    	right.set(speed);
    	left.set(-speed);
    }
    
    public void dropCube(double speed) {
    	right.set(-speed);
    	left.set(speed);
    	
    }

    public void initDefaultCommand() {
    	
    }
}

