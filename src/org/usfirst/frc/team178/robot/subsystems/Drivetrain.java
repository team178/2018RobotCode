package org.usfirst.frc.team178.robot.subsystems;

import org.usfirst.frc.team178.robot.RobotMap;
import org.usfirst.frc.team178.robot.commands.*;

import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.GyroBase;
import com.ctre.phoenix.motorcontrol.ControlMode;
/**
 *
 */
public class Drivetrain extends Subsystem {

   public static TalonSRX left1;
   public static TalonSRX left2;
   public static TalonSRX left3;
   public static TalonSRX right1;
   public static TalonSRX right2;
   public static TalonSRX right3;
   public static Encoder right;
   public static Encoder left;
   public static GyroBase gyro;
   
   
   public Drivetrain() {
	   left1 = new TalonSRX(RobotMap.DMTopLeft);
	   left2 = new TalonSRX(RobotMap.DMMiddleLeft);
	   left3 = new TalonSRX(RobotMap.DMBottomLeft);
	   right1 = new TalonSRX(RobotMap.DMTopRight);
	   right2 = new TalonSRX(RobotMap.DMMiddleRight);
	   right3 = new TalonSRX(RobotMap.DMBottomRight);
	   right = new Encoder(RobotMap.DRIVEencoderRA,RobotMap.DRIVEencoderRB, false, Encoder.EncodingType.k4X);
	   left = new Encoder(RobotMap.DRIVEencoderLA, RobotMap.DRIVEencoderLB, true, Encoder.EncodingType.k4X);
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
	   right1.set(ControlMode.PercentOutput, speed);
	   right2.set(ControlMode.PercentOutput, speed);
	   right3.set(ControlMode.PercentOutput, speed);
 
   }
   
   public void leftDrive(double speed) {
	   left1.set(ControlMode.PercentOutput, speed);
	   left2.set(ControlMode.PercentOutput,speed);
	   left3.set(ControlMode.PercentOutput, speed);
	   
   }
   
   public void drive(double leftMotors, double rightMotors) {
	   left1.set(ControlMode.PercentOutput, leftMotors);
	   left2.set(ControlMode.PercentOutput, leftMotors);
	   left3.set(ControlMode.PercentOutput, leftMotors);
	   right1.set(ControlMode.PercentOutput, rightMotors);
	   right2.set(ControlMode.PercentOutput, rightMotors);
	   right3.set(ControlMode.PercentOutput, rightMotors);
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

