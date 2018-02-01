package edu.frc.technomancers.robot.subsystems

import edu.frc.technomancers.robot.RobotMap
import edu.wpi.first.wpilibj.DoubleSolenoid
import edu.wpi.first.wpilibj.command.Subsystem

class CubePickup: Subsystem() {
    val cubeSolenoid = DoubleSolenoid(RobotMap.FORWARD_CHANNEL,RobotMap.REVERSE_CHANNEL)
    override fun initDefaultCommand() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
    fun open(){
        cubeSolenoid.set(   DoubleSolenoid.Value.kForward)
    }

    fun close() {
        cubeSolenoid.set(   DoubleSolenoid.Value.kReverse)
    }

    fun isOpen() : Boolean{
        return (cubeSolenoid.get() == DoubleSolenoid.Value.kReverse)
    }
}