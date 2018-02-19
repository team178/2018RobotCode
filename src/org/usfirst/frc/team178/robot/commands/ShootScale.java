package org.usfirst.frc.team178.robot.commands;
import org.usfirst.frc.team178.robot.commands.*;
import org.usfirst.frc.team178.robot.OI;
import org.usfirst.frc.team178.robot.Robot;
import org.usfirst.frc.team178.robot.RobotMap.SubsystemIndex;
import org.usfirst.frc.team178.robot.subsystems.Ramp;

import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc.team178.robot.subsystems.*;
/**
 *
 */
public class ShootScale extends Command {
	Ramp ramp;	
	double time;
	OI oi;
	LightsSubsystem lights; 
    public ShootScale() {
    	time = 100000000;
    	requires(Robot.ramp);
    	requires(Robot.lights);
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	ramp = Robot.ramp;
    	oi = Robot.oi;
    	lights = Robot.lights;
    	lights.sendMessage(SubsystemIndex.ALL, "s");
//    	ultrasonic = Robot.ultrasonic;
    }
    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	ramp.bringCubeIn(.75);
   // 	if (ultrasonic.getDistance() <= 1) {
    		ramp.shootCube(1);
    	//}
    //		ramp.punchCube();
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
    	double passedTime = timeSinceInitialized();
    	if (passedTime >= time) {
    		return true;
    	}
    	else {
    		return false;
    	}
    }

    // Called once after isFinished returns true
    protected void end() {
    	ramp.stopLoading();
    	ramp.stopShooting();
    	ramp.resetPiston();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	ramp.stopLoading();
    	ramp.stopShooting();
    	ramp.resetPiston();
    }
}
