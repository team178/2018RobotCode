package org.usfirst.frc.team178.robot.autocommandgroups;


import org.usfirst.frc.team178.robot.commands.AutoTurnPID;
import org.usfirst.frc.team178.robot.commands.AutoVaultDrop;
import org.usfirst.frc.team178.robot.commands.DriveBackwards;
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
    	if(userChoice[0]) {
    		if (fieldConfig[2] == 'M')
    		{
    			if(userChoice[1])
    			{
    				addSequential(new DriveForwardPID(50, .5));
    				addSequential(new AutoTurnPID(-90, .3));
    				addSequential(new DriveForwardPID(25, .5));
    				addSequential(new AutoTurnPID(-90, .3));
    				addSequential(new DriveForwardPID(50, .5));
    				//addSequential(new AutoVaultDrop(.5));

    			}

    		}
    		else
    		{
    		
    			boolean sameAsSwitch = (fieldConfig[0] == fieldConfig[2]);
    			boolean sameAsScale = (fieldConfig[1] == fieldConfig[2]);
    			Command selection = null;
    			if (sameAsSwitch && userChoice[2]) {
    				selection = new PutInSwitch();
    			}
    			if (sameAsScale && userChoice[3])
    			{
    				selection = new PutInScale();
    				
    			}
    			addSequential(selection);
    			
    		}
    	}
    }
}
