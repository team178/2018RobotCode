package org.usfirst.frc.team178.robot.autocommandgroups;

import org.usfirst.frc.team178.robot.commands.AutoTurnBackup;
import org.usfirst.frc.team178.robot.commands.DriveForwardBackup;
import edu.wpi.first.wpilibj.command.CommandGroup;
import org.usfirst.frc.team178.robot.*;
import org.usfirst.frc.team178.robot.commands.*;
/**
 *
 */
public class PutInScale extends CommandGroup {

    public PutInScale() {
    	addSequential(new DriveForwardBackup(300, 0.25));
    	if((Robot.botLocation).getSelected().equals("Left")) {
    		addSequential(new AutoTurnBackup(45, 0.25));
    		addSequential(new ShootScale());
    	} else {
    		addSequential(new AutoTurnBackup(-45, 0.25));
    		addSequential(new ShootScale());
    		}
    	
    	
    }
}
