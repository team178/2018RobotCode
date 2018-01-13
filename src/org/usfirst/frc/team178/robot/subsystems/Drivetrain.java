package org.usfirst.frc.team178.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.GyroBase;
/**
 *
 */
public class Drivetrain extends Subsystem {

   public static Victor left1;
   public static Victor left2;
   public static Victor left3;
   public static Victor right1;
   public static Victor right2;
   public static Victor right3;
   public static java.beans.Encoder right;
   public static java.beans.Encoder left;
   public static GyroBase gyro;
   
   
   public DriveTrain() {
	   left1 = new Victor(RobotMap.DMTOPleft);
	   left2 = new Victor(RobotMap.DMMIDDLEleft);
	   left3 = new Victor(RobotMap.DMBOTTOMleft);
	   right1 = new Victor(RobotMap.DMTOPright);
	   right2 = new Victor(RobotMap.DMMIDDLEright);
	   right3 = new Victor(RobotMap.DMBOTTOMright);
	   right = new Encoder(RobotMap.DRIVEencoderRA,RobotMap.DRIVEencoderRB, false, Encoder.EncodingType.k4X);
	   left = new Encoder(RobotMap.DRIVEencoderLA, RobottMap.DRIVEencoderLB, true, Encoder.EncodingType.k4X);
	   gyro = new GyroBase();
	   
	   
   }
   
   public double getAngle() {
	   return gyro.pidGet();
   }
   
   public  void resetEncoders() {
	   right.reset();
	   left.reset();
	   
   }
   
   public void rightDrive(double speed) {
	   right1.set(speed);
	   right2.set(speed);
	   right3.set(speed);
 
   }
   
   public void leftDrive(double speed) {
	   left1.set(speed);
	   left2.set(speed);
	   left3.set(speed);
	   
   }
   
   public void drive(double leftMotors, double rightMotors) {
	   left1.set(leftMotors);
	   left2.set(leftMotors);
	   left3.set(leftMotors);
	   right1.set(rightMotors);
	   right2.set(rightMotors);
	   right3.set(rightMotors);
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

