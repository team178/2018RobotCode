package org.usfirst.frc.team178.robot.commands;

import org.usfirst.frc.team178.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class FindAutonomous extends Command {
	char ScaleSide = (Robot.gameData).charAt(1);
	char RobotPosition = (Robot.position).charAt(0);
	
    public FindAutonomous() {
    	
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	if(!Robot.goForwardChoice) {
			System.out.println("No Autonomous will be run.");
		} else if (Robot.goForwardChoice) {
			if (!Robot.vaultChooser) {
				if(!Robot.switchChoice) {
					if (!Robot.scaleChoice) {
						System.out.println("The robot will cross the line");
					} else if (Robot.scaleChoice) {
						if(!Robot.secondBlock) {
							System.out.println("Will run scale code regardless of side");
						} else if (Robot.secondBlock) {
							System.out.println("Will run scale + 2nd block code regardless of side");
						}
					}
				} else if (Robot.switchChoice) {
					if(!Robot.scaleChoice) {
						if(!Robot.secondBlock) {
							System.out.println("Will run switch code regardless of side");
						} else if (Robot.secondBlock) {
							System.out.println("Will run switch + 2nd block code regardless of side");
						}
					} else if (Robot.scaleChoice) {
						if(!Robot.secondBlock) {
							if(ScaleSide == RobotPosition) {
								System.out.println("Will run scale and 2nd block code");
							} else {
								System.out.println("Will run switch and 2nd block code regardless of position");
							}
						} else if (Robot.secondBlock) {
							if(ScaleSide == RobotPosition) {
								System.out.println("Will run scale and 2nd block code");
							} else {
								System.out.println("Will run switch and 2nd block code regardless of position");
							}
						}
					}
				}
			} else if (Robot.vaultChooser) {
				if(!Robot.isOnSide) {
					System.out.println("Will run vault code");
				} else if (Robot.isOnSide) {
					if(!Robot.switchChoice) {
						if(!Robot.scaleChoice) {
							System.out.println("The robot will cross the line");
						} else if (Robot.scaleChoice) {
							if(!Robot.secondBlock) {
								System.out.println("Will run scale code regardless of side");
							} else if (Robot.secondBlock) {
								System.out.println("Will run scale + 2nd block code regardless of side");
							}
						}
					} else if (Robot.switchChoice) {
						if (!Robot.scaleChoice) {
							if(!Robot.secondBlock) {
								System.out.println("Will run switch code regardless of side");
							} else if (Robot.secondBlock) {
								System.out.println("Will run switch + 2nd block code regardless of side");
							}
						} else if (Robot.scaleChoice) {
							if(!Robot.secondBlock) {
								if(ScaleSide == RobotPosition) {
									System.out.println("Will run scale code");
								} else {
									System.out.println("Will run switch code regardless of side");
								}
							} else if (Robot.secondBlock) {
								if(ScaleSide == RobotPosition) {
									System.out.println("Will run scale + 2nd block code");
								} else {
									System.out.println("Will run switch + 2nd block code regardless of side");
								}
							}
						}
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
