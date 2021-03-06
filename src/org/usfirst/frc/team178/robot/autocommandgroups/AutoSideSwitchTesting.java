package org.usfirst.frc.team178.robot.autocommandgroups;

import org.usfirst.frc.team178.robot.Robot;
import org.usfirst.frc.team178.robot.commands.AutoTurnPID;
import org.usfirst.frc.team178.robot.commands.Delay;
import org.usfirst.frc.team178.robot.commands.DriveForwardPID;
import org.usfirst.frc.team178.robot.commands.GhettoDriveForward;
import org.usfirst.frc.team178.robot.commands.ShootSwitch;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class AutoSideSwitchTesting extends CommandGroup {
 
	boolean isSame;
	
	//As indicated, this is for testing, not actual competition
    public AutoSideSwitchTesting() {
    	isSame = false;
    	if(Robot.userChoice[3] == false) {
    		if(Robot.fieldConfig[2] == Robot.fieldConfig[0])
    			isSame = true;
    	
    		if(!isSame) {
    			addSequential(new DriveForwardPID(120, .5, true, false));
    		}
    	}
    	
    	System.out.println("Auto side switch: same side=" + isSame);
    	if(Robot.fieldConfig[2] == 'R') {
    		if(Robot.fieldConfig[0] == 'R') {
    			System.out.println("Going for RIGHT side");
    			addSequential(new DriveForwardPID(135, .5, true, false));
    			addSequential(new Delay(1));
    			addSequential(new AutoTurnPID(-90, .435, true)); // false? so we dont reset  the gyro
    			addSequential(new DriveForwardPID(20, .3, true, false));
    			addSequential(new ShootSwitch(true));
    		} else if ((Robot.fieldConfig[0] == 'L') && Robot.userChoice[3]) {
    			addSequential(new DriveForwardPID(243.5, .5, true, false));
    			addSequential(new AutoTurnPID(-90, .435, true));
    			addSequential(new DriveForwardPID(176, .5, true, false));
    			addSequential(new AutoTurnPID(-90, .435, true));
    			addSequential(new DriveForwardPID(50, .3, true, false));
    			addSequential(new ShootSwitch(true));
    		}
    	} else if (Robot.fieldConfig[2] == 'L') {
    		if (Robot.fieldConfig[0] == 'L') {
    			System.out.println("Going for LEFT side");
    			addSequential(new DriveForwardPID(135, .5, true, false)); //was 146
    			addSequential(new AutoTurnPID(90, .435, true));
    			addSequential(new DriveForwardPID(20, .3, true, false)); //was 15
    			addSequential(new ShootSwitch(true));
    		} else if ((Robot.fieldConfig[0] == 'R') && Robot.userChoice[3]) {
    			addSequential(new DriveForwardPID(243.5, .5, true, false));
    			addSequential(new AutoTurnPID(90, .435, true));
    			addSequential(new DriveForwardPID(176, .5, true, false));
    			addSequential(new AutoTurnPID(90, .435, true));
    			addSequential(new DriveForwardPID(50, .3, true, false));
    			addSequential(new ShootSwitch(true));
    		}
    	}
    }
}
