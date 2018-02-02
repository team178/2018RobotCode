package org.usfirst.frc.team178.robot.commands;

import org.usfirst.frc.team178.robot.Robot;
import org.usfirst.frc.team178.robot.subsystems.CubeIntake;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class CollectCube extends Command {

	CubeIntake cubeintake;
	
    public CollectCube() {
    	requires(Robot.cubeintake);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	cubeintake = Robot.cubeintake;
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	cubeintake.collectCube(/*.75*/);
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
    	if (true)//cubeintake.getIntake() == DoubleSolenoid.Value.kReverse)
    	{
    		return true;
    	}
    	else {
    		return false;
    	}
    }

    // Called once after isFinished returns true
    protected void end() {
    	/*cubeintake.foldIntake();*/
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
