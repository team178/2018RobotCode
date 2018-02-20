package org.usfirst.frc.team178.robot.autocommandgroups;


import org.usfirst.frc.team178.robot.commands.AutoTurnPID;
import org.usfirst.frc.team178.robot.commands.AutoVaultDrop;
import org.usfirst.frc.team178.robot.commands.AutoTurn;

import org.usfirst.frc.team178.robot.commands.DriveForward;
import org.usfirst.frc.team178.robot.commands.DriveForwardPID;
import org.usfirst.frc.team178.robot.commands.GyroDriveForward;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class AutoDecisions extends CommandGroup {

    public AutoDecisions(boolean[] userChoice, char[] fieldConfig) {
    	System.out.println("auto descisions init");
    	//Everything dependent on if GoForward is selected
    	if(userChoice[0] && !(fieldConfig[2] == 'N')) {
    		if (fieldConfig[2] == 'M')
    		{
    			if(userChoice[1])
    			{
    				addSequential(new DriveForwardPID(100, .7));
    				addSequential(new AutoTurnPID(180, .3));
    				addSequential(new DriveForwardPID(100, .7));
    				addSequential(new PutInVault());

    			}

    		}
    		else
    		{
    		
    			boolean sameAsSwitch = (fieldConfig[0] == fieldConfig[2]);
    			Command selection = null;
    			if (sameAsSwitch && userChoice[2]) {
    				selection = new PutInSwitch();
    			}
    			
    			addSequential(selection);
    			
    		}
    	} else {
    		System.out.println("Something went wrong or you didn't want to run auto.");
    	}
    }
}
