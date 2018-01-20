package org.usfirst.frc.team178.robot.autocommandgroups;

import edu.wpi.first.wpilibj.command.CommandGroup;

import org.usfirst.frc.team178.robot.commands.*;
import org.usfirst.frc.team178.robot.subsystems.*;


/**
 *
 */
public class AutoLeftScale extends CommandGroup {

    public AutoLeftScale() {
    	addSequential(new DriveForward(20.0, 1.0));  //placeholders
    	
 //   	if (/*our alliance color == the scale's color*/) {
    	addSequential(new AutoTurn(90.0, 1.0)); //placeholders
    	addSequential(new ShootCube());
   // 	}
    	
    	

    }
}
