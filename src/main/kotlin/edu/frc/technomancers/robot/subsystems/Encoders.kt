package edu.frc.technomancers.robot.subsystems

import edu.wpi.first.wpilibj.DigitalInput
import edu.wpi.first.wpilibj.DigitalOutput
import edu.wpi.first.wpilibj.Encoder
import edu.wpi.first.wpilibj.command.Subsystem


class Encoders: Subsystem() {
    
    val i = DigitalOutput(0)
    override fun initDefaultCommand(){
    }

    fun banana() : Unit{
        val ret = i.pulse(1.0)
        return ret
    }
}