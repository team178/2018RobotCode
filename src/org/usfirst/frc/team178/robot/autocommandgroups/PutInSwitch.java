package org.usfirst.frc.team178.robot.autocommandgroups;

import edu.wpi.first.wpilibj.command.CommandGroup;
import org.usfirst.frc.team178.robot.*;
/**
 *
 */
public class PutInSwitch extends CommandGroup {

    public PutInSwitch() {
    	if (Robot.fieldConfig[0] == 'L') {
    		if (Robot.fieldConfig[2] == 'L') {
    			
    		} else if (Robot.fieldConfig[2] == 'R') {
    			
    		}
    	} else if (Robot.fieldConfig[0] == 'R') {
    			if (Robot.fieldConfig[2] == 'L') {
    			
    		} else if (Robot.fieldConfig[2] == 'R') {
    			
    		}
    	}
        // Add Commands here:
        // e.g. addSequential(new Command1());
        //      addSequential(new Command2());
        // these will run in order.

        // To run multiple commands at the same time,
        // use addParallel()
        // e.g. addParallel(new Command1());
        //      addSequential(new Command2());
        // Command1 and Command2 will run in parallel.

        // A command group will require all of the subsystems that each member
        // would require.
        // e.g. if Command1 requires chassis, and Command2 requires arm,
        // a CommandGroup containing them would require both the chassis and the
        // arm.
    }
}
