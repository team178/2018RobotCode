package org.usfirst.frc.team178.robot.autocommandgroups;

import edu.wpi.first.wpilibj.command.CommandGroup;
import org.usfirst.frc.team178.robot.*;
import org.usfirst.frc.team178.robot.commands.AutoTurnPID;
import org.usfirst.frc.team178.robot.commands.Delay;
import org.usfirst.frc.team178.robot.commands.DriveForwardPIDDebug;
import org.usfirst.frc.team178.robot.commands.DriveForwardPID;
import org.usfirst.frc.team178.robot.commands.ShootSwitch;

/**
 *
 */
public class AutoMiddleSwitch extends CommandGroup {
	char switchSide = Robot.switchSide;
    public AutoMiddleSwitch() {
    	if(switchSide == 'L') {
    		addSequential(new DriveForwardPIDDebug(-90, .5, true, false));
    		addSequential(new Delay(1));
    		addSequential(new AutoTurnPID(-90, .5, true));
    		addSequential(new Delay(1));
    		addSequential(new DriveForwardPIDDebug(-25, .5, true, false));
    		addSequential(new Delay(1));
    		addSequential(new AutoTurnPID(90, .5, true));
    		addSequential(new Delay(1));
    		addSequential(new DriveForwardPIDDebug(-30, .5, true, false));
    		addSequential(new ShootSwitch(true));
    	} else if (switchSide == 'R') {
    		addSequential(new DriveForwardPIDDebug(-90, .5, true, false));
    		addSequential(new Delay(1));
    		addSequential(new AutoTurnPID(90, .5, true));
    		addSequential(new Delay(1));
    		addSequential(new DriveForwardPIDDebug(-25, .5, true, false));
    		addSequential(new Delay(1));
    		addSequential(new AutoTurnPID(-90, .5, true));
    		addSequential(new Delay(1));
    		addSequential(new DriveForwardPIDDebug(-30, .5, true, false));
    		addSequential(new ShootSwitch(true));
    	}
      
    }
}
