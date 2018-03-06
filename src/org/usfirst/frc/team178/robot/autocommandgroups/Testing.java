package org.usfirst.frc.team178.robot.autocommandgroups;


import org.usfirst.frc.team178.robot.commands.GhettoTurn;
import org.usfirst.frc.team178.robot.commands.AutoTurnPID;
import org.usfirst.frc.team178.robot.commands.DriveBackwards;
import org.usfirst.frc.team178.robot.commands.AutoTurnPID;
import org.usfirst.frc.team178.robot.commands.GhettoDriveForward;
//import org.usfirst.frc.team178.robot.commands.DriveForwardDoublePID;
import org.usfirst.frc.team178.robot.commands.EncoderSlowDown;
import org.usfirst.frc.team178.robot.commands.GyroDriveForward;


import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class Testing extends CommandGroup {

    public Testing() {
       addSequential(new DriveBackwards(-100, .5));
       //addSequential(new AutoTurnPID(90, .5));
       //addSequential(new AutoTurnPID(-90, .5));
       //addSequential(new AutoDecisions());
    }
}
