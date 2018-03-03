package org.usfirst.frc.team178.robot.autocommandgroups;

import org.usfirst.frc.team178.robot.commands.AutoTurnPID;
import org.usfirst.frc.team178.robot.commands.Delay;
import org.usfirst.frc.team178.robot.commands.DriveBackwards;
import org.usfirst.frc.team178.robot.commands.DriveForwardPID;
import org.usfirst.frc.team178.robot.commands.GhettoDriveForward;
import org.usfirst.frc.team178.robot.commands.ShootSwitch;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class AutoLeftSwitch extends CommandGroup {

    public AutoLeftSwitch() {
    	addSequential(new GhettoDriveForward(50, .5));
    	/*addSequential(new DriveBackwards(-150, .5));
    	addSequential(new Delay(1));
    	addSequential(new AutoTurnPID(90, .5, false));
    	addSequential(new DriveBackwards(-10, .2));
    	addSequential(new ShootSwitch());
    	*/
    }
}
