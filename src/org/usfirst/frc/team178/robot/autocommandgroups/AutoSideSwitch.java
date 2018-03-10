package org.usfirst.frc.team178.robot.autocommandgroups;

import org.usfirst.frc.team178.robot.Robot;
import org.usfirst.frc.team178.robot.commands.AutoTurnPID;
import org.usfirst.frc.team178.robot.commands.Delay;
import org.usfirst.frc.team178.robot.commands.DriveForwardPIDDebug;
import org.usfirst.frc.team178.robot.commands.DriveForwardPID;
import org.usfirst.frc.team178.robot.commands.GhettoDriveForward;
import org.usfirst.frc.team178.robot.commands.ShootSwitch;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class AutoSideSwitch extends CommandGroup {
 
	boolean isSame;
	
    public AutoSideSwitch() {
    	isSame = false;
    	if(Robot.fieldConfig[2] == Robot.fieldConfig[0])
    		isSame = true;
    	
    	if(!isSame) {
    		addSequential(new DriveForwardPIDDebug(120, .3, true, false));
    	}
    	
    	if(Robot.fieldConfig[2] == 'R') {
    		if(Robot.fieldConfig[0] == 'R') {
    			addSequential(new DriveForwardPIDDebug(146, .5, true, false));
    			addSequential(new AutoTurnPID(-90, .435, true));
    			addSequential(new DriveForwardPIDDebug(15, .3, true, false));
    			addSequential(new ShootSwitch(true));
    		}
    	} else if (Robot.fieldConfig[2] == 'L') {
    		if (Robot.fieldConfig[0] == 'L') {
    			addSequential(new DriveForwardPIDDebug(146, .5, true, false));
    			addSequential(new AutoTurnPID(90, .435, true));
    			addSequential(new DriveForwardPIDDebug(10, .3, true, false));
    			addSequential(new ShootSwitch(true));
    		}
    	}
    }
}
