package org.usfirst.frc.team178.robot.autocommandgroups;


import org.usfirst.frc.team178.robot.commands.*;
import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class AutoDecisions extends CommandGroup {
/*
 * userChoice[0] = go forward
 * userChoice[1] = vault
 * userChoice[2] = switch
 * fieldConfig[0] = switch position
 * fieldConfig[2] = robot position
 * 
 */
    public AutoDecisions(boolean[] userChoice, char[] fieldConfig) {
    	if (userChoice[0] || !(fieldConfig[2] == 'N')) {
    		if (userChoice[2]) {
    			if (fieldConfig[2] == 'M') {
    				addSequential(new AutoMiddleSwitch());
    			} else {
    				addSequential(new AutoSideSwitch());
    			}
    		} else {
    			if (userChoice[1] && (fieldConfig[2] == 'M')) { 
    				addSequential(new PutInVault());
    			} else {
    				addSequential(new DriveForwardPIDDebug(90, .3, true, false));
    			}
    		}
    	} else {
    		System.out.println("Something went wrong or you didn't want to run autonomous");
    	}
  }
}

