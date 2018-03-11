package org.usfirst.frc.team178.robot.autocommandgroups;

import edu.wpi.first.wpilibj.command.CommandGroup;

import org.usfirst.frc.team178.robot.*;
import org.usfirst.frc.team178.robot.commands.AutoTurnPID;
import org.usfirst.frc.team178.robot.commands.Delay;
import org.usfirst.frc.team178.robot.commands.DriveForwardPID;
import org.usfirst.frc.team178.robot.commands.ShootSwitch;

/**
 *
 */
public class AutoMiddleSwitch extends CommandGroup {
	char switchSide = Robot.fieldConfig[0];
	
    public AutoMiddleSwitch() {
    	System.out.println("Middle ");
    	if(switchSide == 'L') {
        	System.out.println("L");
    		addSequential(new DriveForwardPID(90, .5, true, false));
    	//	addSequential(new AutoTurnPID(-90, .435, true));
    	//	addSequential(new DriveForwardPIDDebug(80, .5, true, false));
    	//	addSequential(new AutoTurnPID(90, .435, true));
    	//	addSequential(new DriveForwardPIDDebug(25, .3, true, false));
    	//	addSequential(new ShootSwitch(true));
    	} else if (switchSide == 'R') {
        	System.out.println("R");
    		addSequential(new DriveForwardPID(92, .5, true, false));
    		addSequential(new ShootSwitch(true));
    	}
      
    }
}
