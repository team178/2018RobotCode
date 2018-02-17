package org.usfirst.frc.team178.robot.autocommandgroups;

import org.usfirst.frc.team178.robot.Robot;
import org.usfirst.frc.team178.robot.commands.*;
import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class PutInSwitch extends CommandGroup {

    public PutInSwitch() {
    	addSequential(new DriveForward(145, 0.25));
    	if((Robot.botLocation).getSelected().equals("Left")) {
    		addSequential(new AutoTurn(45, 0.25));
    		addSequential(new ShootSwitch());
    	} else {
    		addSequential(new AutoTurn(-45, 0.25));
    		addSequential(new ShootSwitch());
    		}
    }
}
