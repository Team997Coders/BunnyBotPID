/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.usfirst.frc997.BunnyBot2013.subsystems;

import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.command.Subsystem;
import org.usfirst.frc997.BunnyBot2013.RobotMap;

/**
 *
 * @author Spartan Robotics
 */
 


public class SubCompressor extends Subsystem {
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
    Compressor mycompressor1 = RobotMap.mycompressor;
    

      
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
   
    public void CompressorOn(){
        
        mycompressor1.start(); 
            
    }
    
    public void CompressorOff(){
        mycompressor1.stop();
    }
}
