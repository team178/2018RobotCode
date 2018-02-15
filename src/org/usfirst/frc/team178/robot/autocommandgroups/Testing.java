package org.usfirst.frc.team178.robot.autocommandgroups;

import org.usfirst.frc.team178.robot.commands.AutoTurn;
import org.usfirst.frc.team178.robot.commands.AutoTurnPID;
import org.usfirst.frc.team178.robot.commands.AutoTurnPID2;
import org.usfirst.frc.team178.robot.commands.DriveForward;
import org.usfirst.frc.team178.robot.commands.DriveForwardDoublePID;
import org.usfirst.frc.team178.robot.commands.EncoderSlowDown;
import org.usfirst.frc.team178.robot.commands.GyroDriveForward;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class Testing extends CommandGroup {

    public Testing() {
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
    	//addSequential(new GyroDriveForward(50, .4));
    	//addSequential(new EncoderSlowDown(100, .5));
    	//addSequential(new DriveForwardDoublePID(150, .5));
    	addSequential(new AutoTurnPID2(-90, .3)); //keep at .3 speed, have not tested other speeds

    }
}
