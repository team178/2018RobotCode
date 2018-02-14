package org.usfirst.frc.team178.robot.commands;

import org.usfirst.frc.team178.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class FindAutonomous extends Command {
	char SwitchSide;
	char ScaleSide;
	char RobotPosition;
	
    public FindAutonomous() {
    	
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
			System.out.println("Elizabeth's hotspot, and this autonomous, will be turned off.");
		} else if (Robot.goForwardChoice) {
			if (!Robot.vaultChooser) {
				if(!Robot.switchChoice) {
					if (!Robot.scaleChoice) {
						new GyroDriveForward(125, 0.75);
					} else if (Robot.scaleChoice) {
						if(!Robot.secondBlock) {
							System.out.println("Will run scale code regardless of side");
							if (RobotPosition == 'L') {
								if (ScaleSide == 'L') {
									new GyroDriveForward(320, 0.75);
									//shoot cube
								} else if (ScaleSide == 'R') {
									new GyroDriveForward(200, 0.75);
									new AutoTurn(90, 0.75);
									new GyroDriveForward(240, 0.75);
									new AutoTurn(-90, 0.75);
									new GyroDriveForward(120, 0.75);
									//shoot cube
								}
							} else if (RobotPosition == 'M') {
								if(ScaleSide == 'L') {
									new GyroDriveForward(125, 0.75);
									new AutoTurn(-90, 0.75);
									new GyroDriveForward(120, 0.75);
									new AutoTurn(90, 0.75);
									new GyroDriveForward(195, 0.75);
									//shoot cube
								} else if (ScaleSide == 'R') {
									new GyroDriveForward(125, 0.75);
									new AutoTurn(90, 0.75);
									new GyroDriveForward(120, 0.75);
									new AutoTurn(-90, 0.75);
									new GyroDriveForward(195, 0.75);
									//shoot cube
								}
							} else if (RobotPosition == 'R') {
								if(ScaleSide == 'L') {
									new GyroDriveForward(200, 0.75);
									new AutoTurn(-90, 0.75);
									new GyroDriveForward(240, 0.75);
									new AutoTurn(90, 0.75);
									new GyroDriveForward(120, 0.75);
									//shoot cube
								} else if (ScaleSide == 'R') {
									new GyroDriveForward(320, 0.75);
									//shoot cube
								}
							}
						} else if (Robot.secondBlock) {
							System.out.println("Will run scale + 2nd block code regardless of side");
							// needs to implement 2nd block code
							if (RobotPosition == 'L') {
								if (ScaleSide == 'L') {
									new GyroDriveForward(320, 0.75);
									//shoot cube
								} else if (ScaleSide == 'R') {
									new GyroDriveForward(200, 0.75);
									new AutoTurn(90, 0.75);
									new GyroDriveForward(240, 0.75);
									new AutoTurn(-90, 0.75);
									new GyroDriveForward(120, 0.75);
									//shoot cube
								}
							} else if (RobotPosition == 'M') {
								if(ScaleSide == 'L') {
									new GyroDriveForward(125, 0.75);
									new AutoTurn(-90, 0.75);
									new GyroDriveForward(120, 0.75);
									new AutoTurn(90, 0.75);
									new GyroDriveForward(195, 0.75);
									//shoot cube
								} else if (ScaleSide == 'R') {
									new GyroDriveForward(125, 0.75);
									new AutoTurn(90, 0.75);
									new GyroDriveForward(120, 0.75);
									new AutoTurn(-90, 0.75);
									new GyroDriveForward(195, 0.75);
									//shoot cube
								}
							} else if (RobotPosition == 'R') {
								if(ScaleSide == 'L') {
									new GyroDriveForward(200, 0.75);
									new AutoTurn(-90, 0.75);
									new GyroDriveForward(240, 0.75);
									new AutoTurn(90, 0.75);
									new GyroDriveForward(120, 0.75);
									//shoot cube
								} else if (ScaleSide == 'R') {
									new GyroDriveForward(320, 0.75);
									//shoot cube
								}
						}
					}
				} else if (Robot.switchChoice) {
					if(!Robot.scaleChoice) {
						if(!Robot.secondBlock) {
							System.out.println("Will run switch code regardless of side");
							if (RobotPosition == 'L') {
								if (SwitchSide == 'L') {
									new GyroDriveForward(150, 0.75);
									//shoot cube
								} else if (SwitchSide == 'R') {
									new GyroDriveForward(125, 0.75);
									new AutoTurn(90, 0.75);
									new GyroDriveForward(240, 0.75);
									new AutoTurn(-90, 0.75);
									new GyroDriveForward(25, 0.75);
									//shoot cube
								}
							} else if (RobotPosition == 'M') {
								if(SwitchSide == 'L') {
									new GyroDriveForward(125, 0.75);
									new AutoTurn(-90, 0.75);
									new GyroDriveForward(25, 0.75);
									//shoot cube
								} else if (SwitchSide == 'R') {
									new GyroDriveForward(125, 0.75);
									new AutoTurn(90, 0.75);
									new GyroDriveForward(25, 0.75);
									//shoot cube
								}
							} else if (RobotPosition == 'R') {
								if(SwitchSide == 'L') {
									new GyroDriveForward(125, 0.75);
									new AutoTurn(-90, 0.75);
									new GyroDriveForward(240, 0.75);
									new AutoTurn(90, 0.75);
									new GyroDriveForward(25, 0.75);
									//shoot cube
								} else if (SwitchSide == 'R') {
									new GyroDriveForward(150, 0.75);
									//shoot cube
								}
						} else if (Robot.secondBlock) {
							//needs to implement 2nd block code
							if (RobotPosition == 'L') {
								if (ScaleSide == 'L') {
									new GyroDriveForward(320, 0.75);
									//shoot cube
								} else if (ScaleSide == 'R') {
									new GyroDriveForward(200, 0.75);
									new AutoTurn(90, 0.75);
									new GyroDriveForward(240, 0.75);
									new AutoTurn(-90, 0.75);
									new GyroDriveForward(120, 0.75);
									//shoot cube
								}
							} else if (RobotPosition == 'M') {
								if(ScaleSide == 'L') {
									new GyroDriveForward(125, 0.75);
									new AutoTurn(-90, 0.75);
									new GyroDriveForward(120, 0.75);
									new AutoTurn(90, 0.75);
									new GyroDriveForward(195, 0.75);
									//shoot cube
								} else if (ScaleSide == 'R') {
									new GyroDriveForward(125, 0.75);
									new AutoTurn(90, 0.75);
									new GyroDriveForward(120, 0.75);
									new AutoTurn(-90, 0.75);
									new GyroDriveForward(195, 0.75);
									//shoot cube
								}
							} else if (RobotPosition == 'R') {
								if(ScaleSide == 'L') {
									new GyroDriveForward(200, 0.75);
									new AutoTurn(-90, 0.75);
									new GyroDriveForward(240, 0.75);
									new AutoTurn(90, 0.75);
									new GyroDriveForward(120, 0.75);
									//shoot cube
								} else if (ScaleSide == 'R') {
									new GyroDriveForward(320, 0.75);
									//shoot cube
								}
						}
					} else if (Robot.scaleChoice) {
						if(!Robot.secondBlock) {
							if(ScaleSide == RobotPosition) {
								if(RobotPosition == 'L') {
									new GyroDriveForward(320,0.75);
									//turn slightly right and shoot
								} else if (RobotPosition == 'R') {
									new GyroDriveForward(320, 0.75);
									//turn slightly left and shoot
								}
							} else {
								if (RobotPosition == 'L') {
									if (ScaleSide == 'L') {
										new GyroDriveForward(320, 0.75);
										//shoot cube
									} else if (ScaleSide == 'R') {
										new GyroDriveForward(200, 0.75);
										new AutoTurn(90, 0.75);
										new GyroDriveForward(240, 0.75);
										new AutoTurn(-90, 0.75);
										new GyroDriveForward(120, 0.75);
										//shoot cube
									}
								} else if (RobotPosition == 'M') {
									if(ScaleSide == 'L') {
										new GyroDriveForward(125, 0.75);
										new AutoTurn(-90, 0.75);
										new GyroDriveForward(120, 0.75);
										new AutoTurn(90, 0.75);
										new GyroDriveForward(195, 0.75);
										//shoot cube
									} else if (ScaleSide == 'R') {
										new GyroDriveForward(125, 0.75);
										new AutoTurn(90, 0.75);
										new GyroDriveForward(120, 0.75);
										new AutoTurn(-90, 0.75);
										new GyroDriveForward(195, 0.75);
										//shoot cube
									}
								} else if (RobotPosition == 'R') {
									if(ScaleSide == 'L') {
										new GyroDriveForward(200, 0.75);
										new AutoTurn(-90, 0.75);
										new GyroDriveForward(240, 0.75);
										new AutoTurn(90, 0.75);
										new GyroDriveForward(120, 0.75);
										//shoot cube
									} else if (ScaleSide == 'R') {
										new GyroDriveForward(320, 0.75);
										//shoot cube
									}
							}
							}
						} else if (Robot.secondBlock) {
							if(ScaleSide == RobotPosition) {
								//needs to implement 2nd block code
								if(RobotPosition == 'L') {
									new GyroDriveForward(320,0.75);
									//turn slightly right and shoot
								} else if (RobotPosition == 'R') {
									new GyroDriveForward(320, 0.75);
									//turn slightly left and shoot
								}
							} else {
								//needs to implement 2nd block code
								if (RobotPosition == 'L') {
									if (ScaleSide == 'L') {
										new GyroDriveForward(320, 0.75);
										//shoot cube
									} else if (ScaleSide == 'R') {
										new GyroDriveForward(200, 0.75);
										new AutoTurn(90, 0.75);
										new GyroDriveForward(240, 0.75);
										new AutoTurn(-90, 0.75);
										new GyroDriveForward(120, 0.75);
										//shoot cube
									}
								} else if (RobotPosition == 'M') {
									if(ScaleSide == 'L') {
										new GyroDriveForward(125, 0.75);
										new AutoTurn(-90, 0.75);
										new GyroDriveForward(120, 0.75);
										new AutoTurn(90, 0.75);
										new GyroDriveForward(195, 0.75);
										//shoot cube
									} else if (ScaleSide == 'R') {
										new GyroDriveForward(125, 0.75);
										new AutoTurn(90, 0.75);
										new GyroDriveForward(120, 0.75);
										new AutoTurn(-90, 0.75);
										new GyroDriveForward(195, 0.75);
										//shoot cube
									}
								} else if (RobotPosition == 'R') {
									if(ScaleSide == 'L') {
										new GyroDriveForward(200, 0.75);
										new AutoTurn(-90, 0.75);
										new GyroDriveForward(240, 0.75);
										new AutoTurn(90, 0.75);
										new GyroDriveForward(120, 0.75);
										//shoot cube
									} else if (ScaleSide == 'R') {
										new GyroDriveForward(320, 0.75);
										//shoot cube
									}
							}
							}
						}
					}
				}
			} else if (Robot.vaultChooser) {
				if(!Robot.isOnSide) {
					new GyroDriveForward(125,0.75);
					new AutoTurn(180, 0.75);
					new GyroDriveForward(125,0.75);
					new DropCube();
				} else if (Robot.isOnSide) {
					if(!Robot.switchChoice) {
						if(!Robot.scaleChoice) {
							new GyroDriveForward(125,0.75);
						} else if (Robot.scaleChoice) {
							if(!Robot.secondBlock) {
								if (RobotPosition == 'L') {
									if (ScaleSide == 'L') {
										new GyroDriveForward(320, 0.75);
										//shoot cube
									} else if (ScaleSide == 'R') {
										new GyroDriveForward(200, 0.75);
										new AutoTurn(90, 0.75);
										new GyroDriveForward(240, 0.75);
										new AutoTurn(-90, 0.75);
										new GyroDriveForward(120, 0.75);
										//shoot cube
									}
								} else if (RobotPosition == 'M') {
									if(ScaleSide == 'L') {
										new GyroDriveForward(125, 0.75);
										new AutoTurn(-90, 0.75);
										new GyroDriveForward(120, 0.75);
										new AutoTurn(90, 0.75);
										new GyroDriveForward(195, 0.75);
										//shoot cube
									} else if (ScaleSide == 'R') {
										new GyroDriveForward(125, 0.75);
										new AutoTurn(90, 0.75);
										new GyroDriveForward(120, 0.75);
										new AutoTurn(-90, 0.75);
										new GyroDriveForward(195, 0.75);
										//shoot cube
									}
								} else if (RobotPosition == 'R') {
									if(ScaleSide == 'L') {
										new GyroDriveForward(200, 0.75);
										new AutoTurn(-90, 0.75);
										new GyroDriveForward(240, 0.75);
										new AutoTurn(90, 0.75);
										new GyroDriveForward(120, 0.75);
										//shoot cube
									} else if (ScaleSide == 'R') {
										new GyroDriveForward(320, 0.75);
										//shoot cube
									}
								}
							} else if (Robot.secondBlock) {
								// needs to implement 2nd block code
								if (RobotPosition == 'L') {
									if (ScaleSide == 'L') {
										new GyroDriveForward(320, 0.75);
										//shoot cube
									} else if (ScaleSide == 'R') {
										new GyroDriveForward(200, 0.75);
										new AutoTurn(90, 0.75);
										new GyroDriveForward(240, 0.75);
										new AutoTurn(-90, 0.75);
										new GyroDriveForward(120, 0.75);
										//shoot cube
									}
								} else if (RobotPosition == 'M') {
									if(ScaleSide == 'L') {
										new GyroDriveForward(125, 0.75);
										new AutoTurn(-90, 0.75);
										new GyroDriveForward(120, 0.75);
										new AutoTurn(90, 0.75);
										new GyroDriveForward(195, 0.75);
										//shoot cube
									} else if (ScaleSide == 'R') {
										new GyroDriveForward(125, 0.75);
										new AutoTurn(90, 0.75);
										new GyroDriveForward(120, 0.75);
										new AutoTurn(-90, 0.75);
										new GyroDriveForward(195, 0.75);
										//shoot cube
									}
								} else if (RobotPosition == 'R') {
									if(ScaleSide == 'L') {
										new GyroDriveForward(200, 0.75);
										new AutoTurn(-90, 0.75);
										new GyroDriveForward(240, 0.75);
										new AutoTurn(90, 0.75);
										new GyroDriveForward(120, 0.75);
										//shoot cube
									} else if (ScaleSide == 'R') {
										new GyroDriveForward(320, 0.75);
										//shoot cube
									}
							}
							}
						}
					} else if (Robot.switchChoice) {
						if (!Robot.scaleChoice) {
							if(!Robot.secondBlock) {
								if (RobotPosition == 'L') {
									if (SwitchSide == 'L') {
										new GyroDriveForward(150, 0.75);
										//shoot cube
									} else if (SwitchSide == 'R') {
										new GyroDriveForward(125, 0.75);
										new AutoTurn(90, 0.75);
										new GyroDriveForward(240, 0.75);
										new AutoTurn(-90, 0.75);
										new GyroDriveForward(25, 0.75);
										//shoot cube
									}
								} else if (RobotPosition == 'M') {
									if(SwitchSide == 'L') {
										new GyroDriveForward(125, 0.75);
										new AutoTurn(-90, 0.75);
										new GyroDriveForward(25, 0.75);
										//shoot cube
									} else if (SwitchSide == 'R') {
										new GyroDriveForward(125, 0.75);
										new AutoTurn(90, 0.75);
										new GyroDriveForward(25, 0.75);
										//shoot cube
									}
								} else if (RobotPosition == 'R') {
									if(SwitchSide == 'L') {
										new GyroDriveForward(125, 0.75);
										new AutoTurn(-90, 0.75);
										new GyroDriveForward(240, 0.75);
										new AutoTurn(90, 0.75);
										new GyroDriveForward(25, 0.75);
										//shoot cube
									} else if (SwitchSide == 'R') {
										new GyroDriveForward(150, 0.75);
										//shoot cube
									}
							} else if (Robot.secondBlock) {
								//needs to implement 2nd block code
								if (RobotPosition == 'L') {
									if (ScaleSide == 'L') {
										new GyroDriveForward(320, 0.75);
										//shoot cube
									} else if (ScaleSide == 'R') {
										new GyroDriveForward(200, 0.75);
										new AutoTurn(90, 0.75);
										new GyroDriveForward(240, 0.75);
										new AutoTurn(-90, 0.75);
										new GyroDriveForward(120, 0.75);
										//shoot cube
									}
								} else if (RobotPosition == 'M') {
									if(ScaleSide == 'L') {
										new GyroDriveForward(125, 0.75);
										new AutoTurn(-90, 0.75);
										new GyroDriveForward(120, 0.75);
										new AutoTurn(90, 0.75);
										new GyroDriveForward(195, 0.75);
										//shoot cube
									} else if (ScaleSide == 'R') {
										new GyroDriveForward(125, 0.75);
										new AutoTurn(90, 0.75);
										new GyroDriveForward(120, 0.75);
										new AutoTurn(-90, 0.75);
										new GyroDriveForward(195, 0.75);
										//shoot cube
									}
								} else if (RobotPosition == 'R') {
									if(ScaleSide == 'L') {
										new GyroDriveForward(200, 0.75);
										new AutoTurn(-90, 0.75);
										new GyroDriveForward(240, 0.75);
										new AutoTurn(90, 0.75);
										new GyroDriveForward(120, 0.75);
										//shoot cube
									} else if (ScaleSide == 'R') {
										new GyroDriveForward(320, 0.75);
										//shoot cube
									}
							}
						} else if (Robot.scaleChoice) {
							if(!Robot.secondBlock) {
								if(ScaleSide == RobotPosition) {
									if(RobotPosition == 'L') {
										new GyroDriveForward(320,0.75);
										//turn slightly right and shoot
									} else if (RobotPosition == 'R') {
										new GyroDriveForward(320, 0.75);
										//turn slightly left and shoot
									}
								} else {
									if (RobotPosition == 'L') {
										if (ScaleSide == 'L') {
											new GyroDriveForward(320, 0.75);
											//shoot cube
										} else if (ScaleSide == 'R') {
											new GyroDriveForward(200, 0.75);
											new AutoTurn(90, 0.75);
											new GyroDriveForward(240, 0.75);
											new AutoTurn(-90, 0.75);
											new GyroDriveForward(120, 0.75);
											//shoot cube
										}
									} else if (RobotPosition == 'M') {
										if(ScaleSide == 'L') {
											new GyroDriveForward(125, 0.75);
											new AutoTurn(-90, 0.75);
											new GyroDriveForward(120, 0.75);
											new AutoTurn(90, 0.75);
											new GyroDriveForward(195, 0.75);
											//shoot cube
										} else if (ScaleSide == 'R') {
											new GyroDriveForward(125, 0.75);
											new AutoTurn(90, 0.75);
											new GyroDriveForward(120, 0.75);
											new AutoTurn(-90, 0.75);
											new GyroDriveForward(195, 0.75);
											//shoot cube
										}
									} else if (RobotPosition == 'R') {
										if(ScaleSide == 'L') {
											new GyroDriveForward(200, 0.75);
											new AutoTurn(-90, 0.75);
											new GyroDriveForward(240, 0.75);
											new AutoTurn(90, 0.75);
											new GyroDriveForward(120, 0.75);
											//shoot cube
										} else if (ScaleSide == 'R') {
											new GyroDriveForward(320, 0.75);
											//shoot cube
										}
								}
								}
								}
							} else if (Robot.secondBlock) {
								if(ScaleSide == RobotPosition) {
									//needs to implement 2nd block code
									if(RobotPosition == 'L') {
										new GyroDriveForward(320,0.75);
										//turn slightly right and shoot
									} else if (RobotPosition == 'R') {
										new GyroDriveForward(320, 0.75);
										//turn slightly left and shoot
									}
								} else {
									//needs to implement 2nd block code
									if (RobotPosition == 'L') {
										if (ScaleSide == 'L') {
											new GyroDriveForward(320, 0.75);
											//shoot cube
										} else if (ScaleSide == 'R') {
											new GyroDriveForward(200, 0.75);
											new AutoTurn(90, 0.75);
											new GyroDriveForward(240, 0.75);
											new AutoTurn(-90, 0.75);
											new GyroDriveForward(120, 0.75);
											//shoot cube
										}
									} else if (RobotPosition == 'M') {
										if(ScaleSide == 'L') {
											new GyroDriveForward(125, 0.75);
											new AutoTurn(-90, 0.75);
											new GyroDriveForward(120, 0.75);
											new AutoTurn(90, 0.75);
											new GyroDriveForward(195, 0.75);
											//shoot cube
										} else if (ScaleSide == 'R') {
											new GyroDriveForward(125, 0.75);
											new AutoTurn(90, 0.75);
											new GyroDriveForward(120, 0.75);
											new AutoTurn(-90, 0.75);
											new GyroDriveForward(195, 0.75);
											//shoot cube
										}
									} else if (RobotPosition == 'R') {
										if(ScaleSide == 'L') {
											new GyroDriveForward(200, 0.75);
											new AutoTurn(-90, 0.75);
											new GyroDriveForward(240, 0.75);
											new AutoTurn(90, 0.75);
											new GyroDriveForward(120, 0.75);
											//shoot cube
										} else if (ScaleSide == 'R') {
											new GyroDriveForward(320, 0.75);
											//shoot cube
										}
								}
							}
						}
					}
				}
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
