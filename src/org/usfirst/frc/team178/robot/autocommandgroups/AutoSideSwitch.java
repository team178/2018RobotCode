package org.usfirst.frc.team178.robot.autocommandgroups;

import org.usfirst.frc.team178.robot.Robot;
import org.usfirst.frc.team178.robot.commands.AutoTurnPID;
import org.usfirst.frc.team178.robot.commands.Delay;
import org.usfirst.frc.team178.robot.commands.DriveBackwards;
import org.usfirst.frc.team178.robot.commands.DriveForwardPID;
import org.usfirst.frc.team178.robot.commands.GhettoDriveForward;
import org.usfirst.frc.team178.robot.commands.ShootSwitch;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class AutoSideSwitch extends CommandGroup {
 
    public AutoSideSwitch() {
    	if(Robot.fieldConfig[2] == 'R') {
    		if(Robot.fieldConfig[0] == 'R') {
    			addSequential(new DriveBackwards(-120, .5));
    			addSequential(new Delay(1));
    			addSequential(new AutoTurnPID(-90, .5, true));
    			addSequential(new Delay(1));
    			addSequential(new DriveBackwards(-20, .5));
    			addSequential(new ShootSwitch(true));
    		} else {
    			addSequential(new DriveBackwards(-120,.5));
    		}
    	} else if (Robot.fieldConfig[2] == 'L') {
    		if (Robot.fieldConfig[0] == 'L') {
    			addSequential(new DriveBackwards(-120, .5));
    			addSequential(new Delay(1));
    			addSequential(new AutoTurnPID(90, .5, true));
    			addSequential(new Delay(1));
    			addSequential(new DriveBackwards(-20, .5));
    			addSequential(new ShootSwitch(true));
    		}
    	}
    }
}