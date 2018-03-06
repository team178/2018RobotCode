package org.usfirst.frc.team178.robot.autocommandgroups;


import org.usfirst.frc.team178.robot.commands.AutoControlRampIntake;
import org.usfirst.frc.team178.robot.commands.AutoTurnPID;
import org.usfirst.frc.team178.robot.commands.AutoVaultDrop;
import org.usfirst.frc.team178.robot.commands.CollectCube;
import org.usfirst.frc.team178.robot.commands.Delay;
import org.usfirst.frc.team178.robot.commands.DriveBackwardPID;
import org.usfirst.frc.team178.robot.commands.GhettoTurn;

import org.usfirst.frc.team178.robot.commands.GhettoDriveForward;
import org.usfirst.frc.team178.robot.commands.DriveForwardPID;
import org.usfirst.frc.team178.robot.commands.DropIntake;
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
    				if(!userChoice[2]) {
    				/*addSequential(new DropIntake(true));
    				addSequential(new DriveForwardPID(92, .5, true));
    				addSequential(new Delay(1));
    				addSequential(new AutoTurnPID(180, .35, false));
    				addSequential(new Delay(1));
    				addSequential(new DriveForwardPID(92, .5, true));
    				addSequential(new Delay(1));
    				addSequential(new AutoControlRampIntake(.4, 1));
    				addSequential(new AutoVaultDrop(.4));
    			*/
    				addSequential(new DriveBackwardPID(-50,-.5,true));
    				} else {
    					addSequential(new AutoMiddleSwitch());
    				}

    			}

    		}
    		else
    		{
    		
    			boolean sameAsSwitch = (fieldConfig[0] == fieldConfig[2]);
    			Command selection = new DriveForwardPID(120, .5, true);
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
