package org.usfirst.frc.team178.robot.autocommandgroups;

import org.usfirst.frc.team178.robot.commands.DriveForward;
import org.usfirst.frc.team178.robot.Robot;
import org.usfirst.frc.team178.robot.commands.AutoTurn;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.CommandGroup;
import org.usfirst.frc.team178.robot.commands.DropCube;

/**
 *
 */
public class AutoDecisions extends CommandGroup {
	
	String startPos = Robot.startPos;

    public AutoDecisions(boolean[] userChoice, char[] fieldConfig) {
    	System.out.println("Heyo");
     
    	//Everything dependent on if GoForward is selected
    	if(userChoice[0]) {
    		if (startPos.equals("Middle"))
    		{
    			if(userChoice[1])
    			{
    				System.out.println("HI");
    				//addSequential(new PutInVault());
    				addSequential(new DriveForward(120, .25));
    				addSequential(new AutoTurn(180,.25));
    				addSequential(new DriveForward(120,.25));
    				addSequential(new DropCube());
    				
    			}
    		//	addSequential(new CrossLine());

    		}
    		else
    		{
    			//not middle
    			boolean sameAsSwitch = (fieldConfig[0] == fieldConfig[2]);
    			boolean sameAsScale = (fieldConfig[1] == fieldConfig[2]);
    			Command selection = new CrossLine();
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
    		else // if scale is on opposite side
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
