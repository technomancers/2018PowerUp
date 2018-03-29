package edu.frc.technomancers.robot.subsystems

import edu.frc.technomancers.robot.RobotMap
import edu.frc.technomancers.robot.commands.ControlPickup
import edu.wpi.first.wpilibj.DoubleSolenoid
import edu.wpi.first.wpilibj.command.Subsystem

class CubePickup: Subsystem() {
    val cubeGripper = DoubleSolenoid(RobotMap.FORWARD_CHANNEL_GRIPPER,RobotMap.REVERSE_CHANNEL_GRIPPER)

    enum class PneumaticStates {
        OPENED, CLOSED
    }
    override fun initDefaultCommand() {
    }
    fun openGripper(){
        cubeGripper.set(DoubleSolenoid.Value.kForward)
    }

    fun closeGripper() {
        cubeGripper.set(DoubleSolenoid.Value.kReverse)
    }
}
