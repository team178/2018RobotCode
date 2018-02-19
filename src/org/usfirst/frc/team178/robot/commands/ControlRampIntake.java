package org.usfirst.frc.team178.robot.commands;
import org.usfirst.frc.team178.robot.subsystems.*;
import org.usfirst.frc.team178.robot.OI;
import org.usfirst.frc.team178.robot.Robot;
import org.usfirst.frc.team178.robot.RobotMap.SubsystemIndex;
import org.usfirst.frc.team178.robot.subsystems.Ramp;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class ControlRampIntake extends Command {
	OI oi;
	Ramp ramp;
	double speed;
	LightsSubsystem lights;
	
    public ControlRampIntake() {
        requires(Robot.ramp);   
        requires(Robot.lights);
        }

    // Called just before this Command runs the first time
    protected void initialize() {
    	oi =  Robot.oi;
    	ramp = Robot.ramp;
    	lights = Robot.lights;
    	lights.sendMessage(SubsystemIndex.ALL, "s");
    			
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	speed = oi.getXboxY();
    	ramp.bringCubeIn(-speed);
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    	ramp.bringCubeIn(0);
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {

    	ramp.bringCubeIn(0);
    }
}
