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
 * userChoice[3] = either side of switch
 * fieldConfig[0] = switch position
 * fieldConfig[2] = robot position
 * 
 */
    public AutoDecisions(boolean[] userChoice, char[] fieldConfig) {
    	if (userChoice[0] || !(fieldConfig[2] == 'N')) {
    		System.out.println("Go forward... ");
    		if (userChoice[2]) {
    			if (fieldConfig[2] == 'M') {
    				System.out.println("Going for middle switch");
    				addSequential(new AutoMiddleSwitch());
    			} else {
    				addSequential(new AutoSideSwitch());
    				System.out.println("Going for sidee switch");
    			}
    		} else {
    			if (userChoice[1] && (fieldConfig[2] == 'M')) { 
    				System.out.println("Going for valut because we are in the middle");
    				addSequential(new PutInVault());
    			} else {
    				System.out.println("Just going to drive forward");
    				addSequential(new DriveForwardPID(90, .3, true, false));
    			}
    		}
    	} else {
    		System.out.println("Something went wrong or you didn't want to run autonomous");
    	}
  }
}

