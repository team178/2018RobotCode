package org.usfirst.frc.team178.robot.commands;

import org.usfirst.frc.team178.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class RemodeledAutonomous extends Command {

  	char SwitchSide;
	char ScaleSide;
	char RobotPosition;
	
    public RemodeledAutonomous() {
    	
    }

        // Called just before this Command runs the first time
    protected void initialize() {
    	SwitchSide = (Robot.gameData).charAt(0);
    	ScaleSide = (Robot.gameData).charAt(1);
    	RobotPosition = (Robot.position).charAt(0);
    }
    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	if(!Robot.goForwardChoice) {
    		System.out.println("Elizabeth's hotspot, and this autonomous, are turned off");
    	} else {
    		if (RobotPosition == 'M') {
    			if (Robot.vaultChooser) {
    				new GyroDriveForward(125, 0.75);
    				new AutoTurn(180, 0.75);
    				new GyroDriveForward(125,0.75);
    				//new AutoDropCube();
    			} else {
    				new GyroDriveForward(125,0.75);
    			}
    		} else {
    			if(!Robot.scaleChoice) {
    				if (!Robot.switchChoice) {
    					new GyroDriveForward(125, 0.75);
    				} else {
    					if(RobotPosition == SwitchSide) {
    						if(RobotPosition == 'L') {
    							new GyroDriveForward(320, 0.75);
    							new AutoTurn(45, 0.75);
    						} else {
    							new GyroDriveForward(320, 0.75);
    							new AutoTurn(-45, 0.75);
    						}
    						
    					} else {
    						new GyroDriveForward(125,0.75);
    					}
    				}
    			} else {
    				if(RobotPosition == ScaleSide) {
    					if(RobotPosition == 'L') {
    						new GyroDriveForward(125, 0.75);
    						new AutoTurn(45,0.75);
    					} else {
    						new GyroDriveForward(125, 0.75);
    						new AutoTurn(-45, 0.75);
    					}
    				} else {
    					new GyroDriveForward(125, 0.75);
    				}
    			}
    		}
    		
    	}
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
