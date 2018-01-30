package org.usfirst.frc.team178.robot.autocommandgroups;

import org.usfirst.frc.team178.robot.commands.AutoTurn;
import org.usfirst.frc.team178.robot.commands.DriveForward;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class AutoLeftSwitch extends CommandGroup {

    public AutoLeftSwitch() {
addSequential(new DriveForward(10.0, 1.0));  //placeholders
    	/*
    	if (our alliance color == the switch's color) {
    	addSequential(new AutoTurn(90.0, 1.0)); //placeholders
    	addSequential(new ShootCube());
    	} */
    	}
    }
