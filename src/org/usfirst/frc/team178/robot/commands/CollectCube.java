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
	OI oi;
	LightsSubsystem  lights; 
	double rightStickY, leftStickY;
	
    public CollectCube() {
    	requires(Robot.cubeintake);
   // 	requires(Robot.lights);
    	
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	oi = Robot.oi;
    	cubeintake = Robot.cubeintake;
   // 	lights = Robot.lights;
    	
   // 	lights.sendMessage(SubsystemIndex.ALL, "c");
    	
    	
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	rightStickY = oi.getXboxRightY();
    	leftStickY = oi.getXboxLeftY();
    	cubeintake.collectCubeRight(rightStickY);
    	cubeintake.collectCubeLeft(leftStickY);
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
    	if (false)//cubeintake.getIntake() == DoubleSolenoid.Value.kReverse)
    	{
    		return true;
    	}
    	else {
    		return false;
    	}
    }

    // Called once after isFinished returns true
    protected void end() {

    	cubeintake.collectCubeLeft(0);
    	cubeintake.collectCubeRight(0);
    }
    
    protected void interrupted() {
    	cubeintake.collectCubeLeft(0);
    	cubeintake.collectCubeRight(0);
    }
}
