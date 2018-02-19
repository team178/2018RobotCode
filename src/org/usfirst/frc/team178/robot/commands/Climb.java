package org.usfirst.frc.team178.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc.team178.robot.*;
import org.usfirst.frc.team178.robot.RobotMap.SubsystemIndex;
import org.usfirst.frc.team178.robot.subsystems.Climber;
import org.usfirst.frc.team178.robot.subsystems.LightsSubsystem;
/**
 *
 */
public class Climb extends Command {

    Climber climber;
    LightsSubsystem lights;
	
	public Climb() {
    	requires(Robot.climber);
    	requires(Robot.lights);
    	
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	climber = Robot.climber;
    	lights = Robot.lights;
    	lights.sendMessage(SubsystemIndex.ALL, "c");
    	
    	
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	climber.rotate(0.75);
    	climber.climb(1);
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    	climber.climb(0);
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
