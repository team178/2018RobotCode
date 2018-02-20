package org.usfirst.frc.team178.robot.autocommandgroups;

import org.usfirst.frc.team178.robot.commands.GhettoTurn;
import org.usfirst.frc.team178.robot.commands.GhettoDriveForward;
import edu.wpi.first.wpilibj.command.CommandGroup;
import org.usfirst.frc.team178.robot.*;
import org.usfirst.frc.team178.robot.commands.*;
/**
 *
 */
public class PutInScale extends CommandGroup {

    public PutInScale() {
    	addSequential(new GhettoDriveForward(300, 0.25));
    	if((Robot.botLocation).getSelected().equals("Left")) {
    		addSequential(new GhettoTurn(45, 0.25));
    		addSequential(new ShootScale());
    	} else {
    		addSequential(new GhettoTurn(-45, 0.25));
    		addSequential(new ShootScale());
    		}
    	
    	
    }
}
