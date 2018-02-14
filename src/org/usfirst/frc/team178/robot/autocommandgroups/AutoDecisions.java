package org.usfirst.frc.team178.robot.autocommandgroups;

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
    				addSequential(new PutInVault());
    			}
    			addSequential(new CrossLine());

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
    	}
    	
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