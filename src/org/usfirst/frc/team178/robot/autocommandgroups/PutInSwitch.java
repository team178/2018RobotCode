package org.usfirst.frc.team178.robot.autocommandgroups;

import org.usfirst.frc.team178.robot.Robot;
import org.usfirst.frc.team178.robot.commands.*;
import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class PutInSwitch extends CommandGroup {

    String botLocation = (Robot.botLocation).getSelected();
    public PutInSwitch() {
    	addSequential(new DriveForwardPID(145, 0.5));
        addSequential(new Delay(1));
    	if(botLocation.equals("Left")) {
    		addSequential(new AutOTurnPID(45, 0.25));
    		addSequential(new ShootSwitch());
    	} else {
    		addSequential(new AutoTurnPID(-45, 0.25));
    		addSequential(new ShootSwitch());
    		}
    }
}
