package org.usfirst.frc.team178.robot.autocommandgroups;

import edu.wpi.first.wpilibj.command.CommandGroup;

import org.usfirst.frc.team178.robot.Robot;

import edu.wpi.first.wpilibj.DriverStation;
/**
 *
 */
public class Autonomous extends CommandGroup {

    public Autonomous() {
    	System.out.println("Hotspot?");
    //	String gameData = DriverStation.getInstance().getGameSpecificMessage();
    	if (((Robot.temp).getSelected()).equals("Left"))
    		System.out.println("Left");
    	else if ((Robot.temp).getSelected().equals("Middle"))
    		System.out.println("Middle");
    	else if ((Robot.temp).getSelected().equals("Right"))
    		System.out.println("Right");
            }
}
