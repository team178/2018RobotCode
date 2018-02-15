package org.usfirst.frc.team178.robot.autocommandgroups;

import edu.wpi.first.wpilibj.command.CommandGroup;
import org.usfirst.frc.team178.robot.*;
import org.usfirst.frc.team178.robot.commands.DriveForward;
import org.usfirst.frc.team178.robot.commands.AutoTurn;
/**
 *
 */
public class PutInSwitch extends CommandGroup {

    public PutInSwitch() {
    	addSequential(new DriveForward(140, .25));
    	
    	if(Robot.fieldConfig[2] == 'R')
    		addSequential(new AutoTurn(135, .25));
    	else if (Robot.fieldConfig[2] == 'L')
    		addSequential(new AutoTurn(-135, .25));
    	
    	addSequential(new AutoShootSequence());
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
