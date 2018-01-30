package org.usfirst.frc.team178.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.AnalogInput;
import edu.wpi.first.wpilibj.Compressor;

import org.usfirst.frc.team178.robot.RobotMap;



/**
 *
 */
public class Pneumatics extends Subsystem {
	public static Compressor airCompressor;
	public static AnalogInput pressureTransducer;


  //identifies where the pneumatics are on the robot map
	
	public Pneumatics() {
		pressureTransducer = new AnalogInput(RobotMap.PRESSURETRANSDUCER);
		airCompressor = new Compressor();
		airCompressor.setClosedLoopControl(false);
		/*airCompressor.setClosedLoopControl(false);
		boolean enabled = airCompressor.enabled();
		boolean pressureSwitch = airCompressor.getPressureSwitchValue();
		double current = airCompressor.getCompressorCurrent();
		*/
	}
	//gets the average pressure from the pneumatics
	public double getPressure() {
		return pressureTransducer.getVoltage();
		
	}
	//Put methods for controlling this subsystem here. Call these from Commands.
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
}

