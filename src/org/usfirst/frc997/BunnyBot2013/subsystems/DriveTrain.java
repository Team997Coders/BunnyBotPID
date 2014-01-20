// RobotBuilder Version: 1.0
//
// This file was generated by RobotBuilder. It contains sections of
// code that are automatically generated and assigned by robotbuilder.
// These sections will be updated in the future when you export to
// Java from RobotBuilder. Do not put any code or make any change in
// the blocks indicating autogenerated code or it will be lost on an
// update. Deleting the comments indicating the section will prevent
// it from being updated in the future.
package org.usfirst.frc997.BunnyBot2013.subsystems;
import org.usfirst.frc997.BunnyBot2013.RobotMap;
import org.usfirst.frc997.BunnyBot2013.commands.*;
import edu.wpi.first.wpilibj.*;
import edu.wpi.first.wpilibj.command.PIDSubsystem;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
/**
 *
 */
public class DriveTrain extends PIDSubsystem {
    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS
    double startError = 0.0;
    Gyro driveGyro = RobotMap.driveGyro; 
    SpeedController leftMotor = RobotMap.driveTrainLeftMotor;
    SpeedController rightMotor = RobotMap.driveTrainRightMotor;
    RobotDrive robotDrive21 = RobotMap.driveTrainRobotDrive21;
    Encoder leftEncoder = RobotMap.driveTrainLeftEncoder;
    Encoder rightEncoder = RobotMap.driveTrainRightEncoder;
    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS
    // Initialize your subsystem here
    public DriveTrain() {
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=PID
        super("DriveTrain", 0.002, 0.0, 0.001);
        setAbsoluteTolerance(0.2);
        getPIDController().setContinuous(false);
        LiveWindow.addActuator("DriveTrain", "PIDSubsystem Controller", getPIDController());
    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=PID
        // Use these to get going:
        // setSetpoint() -  Sets where the PID controller should move the system
        //                  to
        // enable() - Enables the PID controller.
    }
    
    public void initDefaultCommand() {
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DEFAULT_COMMAND
    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DEFAULT_COMMAND
    
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
        setDefaultCommand(new TankDrive());
    }
    
    protected double returnPIDInput() {
        // Return your input value for the PID loop
        // e.g. a sensor, like a potentiometer:
        // yourPot.getAverageVoltage() / kYourMaxVoltage;
	
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=SOURCE
        return leftEncoder.pidGet();
    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=SOURCE
    }
    
    protected void usePIDOutput(double output) {
        // Use output to drive your system, like a motor
        // e.g. yourMotor.set(output);
	
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=OUTPUT
        
    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=OUTPUT
        SmartDashboard.putNumber("SetMotor: ", output);
        leftMotor.pidWrite(output * (.5-GyroAdjustmentSaturation()));
        rightMotor.pidWrite(-output* (.5+GyroAdjustmentSaturation()));
    }
    public double ReadSensor(){
        double distance;
        distance = RobotMap.myUltrasonic.getVoltage()/.009766;
        SmartDashboard.putNumber("raw distance ", RobotMap.myUltrasonic.getVoltage());
        SmartDashboard.putNumber("Analog: ", distance);
        return RobotMap.myUltrasonic.getVoltage();
    }
    
    public void ResetSensers(){
        leftEncoder.reset();
        rightEncoder.reset();
        driveGyro.reset();
        
    }
    
    public double fmod(double a, double n){
        return (double) (a%n);
           
    }
    
    
    
    public void UpdateDashBoard(){
        double angle;
        angle = fmod(driveGyro.getAngle(), 360);
        SmartDashboard.putNumber("Gyro: ", angle);
        SmartDashboard.putNumber("leftEncoder: ", leftEncoder.getRaw());
        SmartDashboard.putNumber("rightEncoder: ", rightEncoder.getRaw());
        this.ReadSensor();
    }
  
 
    
     
     public void tankDrive(double left, double right){
         SetLeftspeed(left);
         SetRightspeed(right);
     }
    
   private void SetLeftspeed(double speed){
       SmartDashboard.putNumber("Left: ", speed);
      leftMotor.set(speed);
   } 
   
   private void SetRightspeed(double speed){
       SmartDashboard.putNumber("Right: ", speed);
      rightMotor.set(-speed);
   }

   public void reset(){
       this.disable();
       tankDrive(0, 0);
       ResetSensers();
   }
   
   private double GyroAdjustmentSaturation() {
       if (driveGyro.getAngle()*RobotMap.gyroFactor>.1) {
           return .1;
           
       } else if (driveGyro.getAngle()*RobotMap.gyroFactor<-.1) {
           return -.1;
       }else {
           return driveGyro.getAngle()*RobotMap.gyroFactor;
       }
    }

}