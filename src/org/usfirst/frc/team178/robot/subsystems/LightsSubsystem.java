package org.usfirst.frc.team178.robot.subsystems;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.DriverStation.Alliance;
import edu.wpi.first.wpilibj.I2C;
import edu.wpi.first.wpilibj.command.Subsystem;

import org.usfirst.frc.team178.robot.RobotMap.SubsystemIndex;

/**
 *
 */
public class LightsSubsystem extends Subsystem {

   private I2C arduino;
   private DriverStation ds;
   
   public LightsSubsystem () {
	   arduino = new I2C(I2C.Port.kOnboard, 8);
	   ds = DriverStation.getInstance();
	   setBaseColor(SubsystemIndex.ALL);
   }
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
    public void setBaseColor(SubsystemIndex subsystem) {
 	   if (ds.getAlliance() == Alliance.Blue) {
 		   sendMessage(subsystem, "b");
 	   }
 	   else if (ds.getAlliance() == Alliance.Red){
 		   sendMessage(subsystem, "r");
 	   }
    }
     
     public void sendMessage(SubsystemIndex subsystem, String pattern) {
     	String message = subsystem.ordinal() + pattern;
     	message = message.toLowerCase();
     	System.out.println(message);
     	arduino.writeBulk(message.getBytes());
     }
 }

