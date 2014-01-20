// RobotBuilder Version: 1.0
//
// This file was generated by RobotBuilder. It contains sections of
// code that are automatically generated and assigned by robotbuilder.
// These sections will be updated in the future when you export to
// Java from RobotBuilder. Do not put any code or make any change in
// the blocks indicating autogenerated code or it will be lost on an
// update. Deleting the comments indicating the section will prevent
// it from being updated in the future.
package org.usfirst.frc997.BunnyBot2013;
    
import edu.wpi.first.wpilibj.*;
import edu.wpi.first.wpilibj.CounterBase.EncodingType; import edu.wpi.first.wpilibj.PIDSource.PIDSourceParameter;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import java.util.Vector;
/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {
    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS
   public static final int compressorSpike = 1; 
   public static final int compressorpresureswitch = 1;
   public static int extenddumpersolenoid ; 
   public static final int retreactdumpersolenoid = 4;
    public static Gyro driveGyro;
    public final static double GyroKp = 0.03;
    public static AnalogChannel myUltrasonic;
    public static SpeedController driveTrainLeftMotor;
    public static SpeedController driveTrainRightMotor;
    public static RobotDrive driveTrainRobotDrive21;
    public static Encoder driveTrainLeftEncoder;
    public static Encoder driveTrainRightEncoder;
    public static Compressor mycompressor;
    public static Solenoid dumpersolenoidextend;
    public static Solenoid dumpersolenoidretract;
    public static Solenoid kickersolenoidextend;
    public static Solenoid kickersolenoidretract;
    public static double gyroFactor = .1;
    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS
    public static void init() {
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTORS
        driveTrainLeftMotor = new Victor(1, 9);
	LiveWindow.addActuator("DriveTrain", "LeftMotor", (Victor) driveTrainLeftMotor);
        
        driveTrainRightMotor = new Victor(1, 10);
	LiveWindow.addActuator("DriveTrain", "RightMotor", (Victor) driveTrainRightMotor);
        
        driveTrainRobotDrive21 = new RobotDrive(driveTrainLeftMotor, driveTrainRightMotor);
	
        
        driveTrainRobotDrive21.setSafetyEnabled(false);
        driveTrainRobotDrive21.setExpiration(0.1);
        driveTrainRobotDrive21.setSensitivity(0.5);
        driveTrainRobotDrive21.setMaxOutput(1.0);
        driveTrainRobotDrive21.setInvertedMotor(RobotDrive.MotorType.kRearRight, true);        
        driveTrainLeftEncoder = new Encoder(1, 5, 1, 6, false, EncodingType.k4X);
	LiveWindow.addSensor("DriveTrain", "LeftEncoder ", driveTrainLeftEncoder);
        driveTrainLeftEncoder.setDistancePerPulse(1.0);
        driveTrainLeftEncoder.setPIDSourceParameter(PIDSourceParameter.kDistance);
        driveTrainLeftEncoder.start();
        driveTrainRightEncoder = new Encoder(1, 3, 1, 4, false, EncodingType.k4X);
	LiveWindow.addSensor("DriveTrain", "RightEncoder", driveTrainRightEncoder);
        driveTrainRightEncoder.setDistancePerPulse(1.0);
        driveTrainRightEncoder.setPIDSourceParameter(PIDSourceParameter.kDistance);
        driveTrainRightEncoder.setReverseDirection(true);
        driveTrainRightEncoder.start();
        
        driveGyro = new Gyro(1 ,1 );
        driveGyro.setSensitivity(0.007);
        
        mycompressor = new Compressor(RobotMap.compressorSpike, RobotMap.compressorpresureswitch);
        
       dumpersolenoidextend = new Solenoid(1, 2);
        dumpersolenoidretract = new Solenoid(1, 4);
        kickersolenoidextend = new Solenoid(1,1);
        kickersolenoidretract = new Solenoid(1,3);
    
        //mysolenoid = new Solenoid(RobotMap.solenoidslot); 

        myUltrasonic = new AnalogChannel(1, 4);
        myUltrasonic.setAverageBits(8);
        
    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTORS
  
    }
}
