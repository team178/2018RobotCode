package org.usfirst.frc.team178.robot.commands;
import org.usfirst.frc.team178.robot.subsystems.*;
import org.usfirst.frc.team178.robot.OI;
import org.usfirst.frc.team178.robot.Robot;
import org.usfirst.frc.team178.robot.RobotMap.SubsystemIndex;
import org.usfirst.frc.team178.robot.subsystems.CubeIntake;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class CollectCube extends Command {

	CubeIntake cubeintake;
	Ramp ramp;
	OI oi;
	LightsSubsystem  lights; 
	double rightStickY, leftStickY;
	
    public CollectCube() {
    	requires(Robot.cubeintake);
    	requires(Robot.ramp);
   // 	requires(Robot.lights);
    	
    }

    //Called just before this Command runs for the first time
    protected void initialize() {
    	oi = Robot.oi;
    	cubeintake = Robot.cubeintake;
    	ramp = Robot.ramp;
   // 	lights = Robot.lights;
    	
   // 	lights.sendMessage(SubsystemIndex.ALL, "c");
    	
    	
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    //	System.out.println("L  " + cubeintake.getLeftUltrasonic());
    	//System.out.println("R  " + cubeintake.getRightUltrasonic());
    	rightStickY = oi.getXboxRightY();
    	leftStickY = oi.getXboxLeftY();
    	//if(cubeintake.getLeftUltrasonic() < 1.0 || cubeintake.getRightUltrasonic() < 1.0) {
    		//cubeintake.collectCubeLeft(leftStickY);
    	//} else {
    		//cubeintake.collectCubeRight(rightStickY);
    		cubeintake.collectCubeLeft(-leftStickY);
    		cubeintake.collectCubeRight(-rightStickY);
    		ramp.bringCubeIn(leftStickY);
    	}
//    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
    	
    
    		return false;
    	
    }

    // Called once after isFinished returns true
    protected void end() {
    	ramp.bringCubeIn(0);
    	cubeintake.collectCubeLeft(0);
    	cubeintake.collectCubeRight(0);
    }
    
    protected void interrupted() {
    	ramp.bringCubeIn(0);
    	cubeintake.collectCubeLeft(0);
    	cubeintake.collectCubeRight(0);
    }
}
