/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.usfirst.frc997.BunnyBot2013.subsystems;

import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.command.Subsystem;
import org.usfirst.frc997.BunnyBot2013.RobotMap;

/**
 *
 * @author Spartan Robotics
 */
public class Kicker extends Subsystem {
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
    Solenoid extend = RobotMap.kickersolenoidextend;
    Solenoid retract = RobotMap.kickersolenoidretract;

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
    
    public void ExtendKicker(){
        extend.set(true);
        retract.set(false);
    }
    
    public void RetractKicker(){
        retract.set(true);
        extend.set(false);
    }
    
    public void KickerOff(){
        extend.set(false);
        retract.set(false);
    }
    
}
