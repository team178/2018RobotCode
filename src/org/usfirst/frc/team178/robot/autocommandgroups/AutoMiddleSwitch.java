package org.usfirst.frc.team178.robot.autocommandgroups;

import edu.wpi.first.wpilibj.command.CommandGroup;

import org.usfirst.frc.team178.robot.commands.*;

/**
 *
 */
public class AutoMiddleSwitch extends CommandGroup {

    public AutoMiddleSwitch() {
      if (/*Left switch color == our color  */) {
    	  addSequential(new DriveForward(5.0, 1.0)); //placeholders
    	  addSequential(new AutoTurn(-90.0, 1.0)); //placeholders
    	  addSequential(new DriveForward(5.0, 1.0)); //placeholders
    	  addSequential(new AutoTurn(90.0, 1.0)); //placeholders
    	  addSequential(new DriveForward(5.0, 1.0)); //placeholders
    	  addSequential(new AutoTurn(90.0, 1.0)); //placeholders
    	  addSequential(new ShootCube());
    	  
      } else if (/* right switch color == our color */) {
    		  addSequential(new DriveForward(5.0, 1.0));
    		  addSequential(new AutoTurn(90.0, 1.0));
    		  addSequential(new DriveForward(5.0, 1.0));
    		  addSequential(new AutoTurn(-90.0, 1.0));
    		  addSequential(new DriveForward(5.0, 1.0));
    		  addSequential(new AutoTurn(-90.0, 1.0));
    		  addSequential(new ShootCube());
    	  }
      }
    }
