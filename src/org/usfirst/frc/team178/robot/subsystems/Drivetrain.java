package org.usfirst.frc.team178.robot.subsystems;

import org.usfirst.frc.team178.robot.RobotMap;
import org.usfirst.frc.team178.robot.commands.*;


import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.AnalogGyro;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.GyroBase;
import edu.wpi.first.wpilibj.PIDController;

import com.ctre.phoenix.motorcontrol.ControlMode;
import edu.wpi.first.wpilibj.Talon;
/**
 *
 */
public class Drivetrain extends Subsystem {

   public static Talon left1;
   public static Talon left2;
   public static Talon left3;
   public static Talon right1;
   public static Talon right2;
   public static Talon right3;
   public static Encoder right;
   public static Encoder left;
   public static AnalogGyro gyro;
   public static PIDController straightAdj;
   
   
   public Drivetrain() {
	   left1 = new Talon(RobotMap.DMTopLeft);
	   left2 = new Talon(RobotMap.DMMiddleLeft);
	   left3 = new Talon(RobotMap.DMBottomLeft);
	   right1 = new Talon(RobotMap.DMTopRight);
	   right2 = new Talon(RobotMap.DMMiddleRight);
	   right3 = new Talon(RobotMap.DMBottomRight);
	   right = new Encoder(RobotMap.DRIVEencoderRA,RobotMap.DRIVEencoderRB, false, Encoder.EncodingType.k4X);
	   left = new Encoder(RobotMap.DRIVEencoderLA, RobotMap.DRIVEencoderLB, true, Encoder.EncodingType.k4X);
	   gyro = new AnalogGyro(RobotMap.DRIVEGyro);
	  
	   straightAdj = new PIDController(1,0,0, gyro , left1 );
	   
	   double dpp = 3 * ((6 * Math.PI) / 1024); // distance per pulse
		// gearRatio * (circumference/counts per revolution)
	   right.setDistancePerPulse(dpp); // must be changed for both right and left
	   left.setDistancePerPulse(dpp);   
   }
   
   public double getAngle() {
	   return gyro.pidGet();
   }
   
   public void resetGyro()
   {
	  gyro.reset();
   }
   
   public  void resetEncoders() {
	   right.reset();
	   left.reset();
	   
   }
   
   public void rightDrive(double speed) {
	   right1.set( speed);
	   right2.set( speed);
	   right3.set( speed);
 
   }
   
   public void leftDrive(double speed) {
	   left1.set( speed);
	   left2.set(speed);
	   left3.set( speed);
	   
   }
   
   public void drive(double leftMotors, double rightMotors) {
	   
	   left1.set( leftMotors);
	   left2.set( leftMotors);
	   left3.set( leftMotors);
	   right1.set( rightMotors);
	   right2.set( rightMotors);
	   right3.set( rightMotors);
   }
   
   public double getLeftDistance() {
	   return left.getDistance();
   }
   
   public double getRightDistance() {
	   return right.getDistance();
   }
   
   public double getLeftSpeed() {
	   return left.getRate();
   }
   
   public double getRightSpeed() {
	   return right.getRate();
   }

    public void initDefaultCommand() {
    	setDefaultCommand(new JoystickDrive());
    }
}

