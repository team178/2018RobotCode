package org.usfirst.frc.team178.robot.autocommandgroups;

import edu.wpi.first.wpilibj.command.CommandGroup;
import org.usfirst.frc.team178.robot.*;
import org.usfirst.frc.team178.robot.commands.AutoTurn;

import org.usfirst.frc.team178.robot.commands.GyroDriveForward;


/**
 *
 */
public class Autonomous extends CommandGroup {
	char SwitchSide = (Robot.gameData).charAt(0);
	char ScaleSide = (Robot.gameData).charAt(1);
	char RobotPosition = (Robot.position).charAt(0);

	
    public Autonomous() {
    	System.out.println("Hi");
    	if(!Robot.goForwardChoice) {
    		System.out.println("Elizabeth's hotspot, and this autonomous, are turned off");
    	} else if (Robot.goForwardChoice) {
    		if (RobotPosition == 'M') {
    			if (Robot.vaultChooser) {
    				addSequential(new GyroDriveForward(125, 0.75));
    				addSequential(new AutoTurn(180, 0.75));
    				addSequential(new GyroDriveForward(125,0.75));
    				//new AutoDropCube();
    			} else {
    				addSequential(new GyroDriveForward(125,0.75));
    			}
    		} else {
    			if(!Robot.scaleChoice) {
    				if (!Robot.switchChoice) {
    					addSequential(new GyroDriveForward(125, 0.75));
    				} else {
    					if(RobotPosition == SwitchSide) {
    						if(RobotPosition == 'L') {
    							addSequential(new GyroDriveForward(320, 0.75));
    							addSequential(new AutoTurn(45, 0.75));
    						} else {
    							addSequential(new GyroDriveForward(320, 0.75));
    							addSequential(new AutoTurn(-45, 0.75));
    						}
    						
    					} else {
    						addSequential(new GyroDriveForward(125,0.75));
    					}
    				}
    			} else {
    				if(RobotPosition == ScaleSide) {
    					if(RobotPosition == 'L') {
    						addSequential(new GyroDriveForward(125, 0.75));
    						addSequential(new AutoTurn(45,0.75));
    					} else {
    						addSequential(new GyroDriveForward(125, 0.75));
    						addSequential(new AutoTurn(-45, 0.75));
    					}
    				} else {
    					addSequential(new GyroDriveForward(125, 0.75));
    				}
    			}
    		}
    		
    	}
    }
    	
    	
    	
    	
        // Add Commands here:
        // e.g. addSequential(new Command1());
        //      addSequential(new Command2());
        // these will run in order.

        // To run multiple commands at the same time,
        // use addParallel()
        // e.g. addParallel(new Command1());
        //      addSequential(new Command2());
        // Command1 and Command2 will run in parallel.

        // A command group will require all of the subsystems that each member
        // would require.
        // e.g. if Command1 requires chassis, and Command2 requires arm,
        // a CommandGroup containing them would require both the chassis and the
        // arm.
    }

