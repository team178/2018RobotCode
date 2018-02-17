package org.usfirst.frc.team178.robot.autocommandgroups;

import org.usfirst.frc.team178.robot.commands.AutoTurnPID;
import org.usfirst.frc.team178.robot.commands.DriveForward;
import org.usfirst.frc.team178.robot.commands.DriveForwardPID;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class AutoDecisions extends CommandGroup {

    public AutoDecisions(boolean[] userChoice, char[] fieldConfig) {
     
    	//Everything dependent on if GoForward is selected
    	if(userChoice[0]) {
    		if (fieldConfig[2] == 'M')
    		{
    			if(userChoice[1])
    			{
    				//addSequential(new PutInVault());
    				addSequential(new AutoTurnPID(-90,.3));
    				//addSequential(new DriveForwardPID(100, .5));
    			}
    		//	addSequential(new CrossLine());

    		}
    		else
    		{
    			//not middle
    			boolean sameAsSwitch = (fieldConfig[0] == fieldConfig[2]);
    			boolean sameAsScale = (fieldConfig[1] == fieldConfig[2]);
    			Command selection = null; //Make a doNothing command
    			if (sameAsSwitch && userChoice[2]) {
    				selection = new PutInSwitch();
    			}
    			if (sameAsScale && userChoice[3])
    			{
    				selection = new PutInScale();
    				
    			}
    			addSequential(selection);
    			
    		}
    	} // I was thinking that maybe we could use Switch selection instead of if statements? That way we wouldn't have so many brackets and our code would be more organized -- Robbie
    	
    	/*if(fieldConfig[2] == 'L')
    	{
    		System.out.println("Go Forward!!!");
    		if (fieldConfig[1] == 'L') //if scale is on same side
    		{
    			
    		}
    		else // if scale is on oppostite side
    		{
    			
    		}
    		
    	} else if (fieldConfig[2] == 'M') {
    		
    		
    		
    	} else if (fieldConfig[2] == 'R') {
    		if (fieldConfig[1] == 'R') { //scale is on same side
    			
    		} else { //if scale is on opposite side
    			
    		}
    	} 
    	*/
    }
}
