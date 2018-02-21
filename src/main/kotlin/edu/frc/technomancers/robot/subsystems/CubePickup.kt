package edu.frc.technomancers.robot.subsystems

import edu.frc.technomancers.robot.RobotMap
import edu.frc.technomancers.robot.commands.ControlPickup
import edu.wpi.first.wpilibj.DoubleSolenoid
import edu.wpi.first.wpilibj.command.Subsystem

class CubePickup: Subsystem() {
    val cubeGripper = DoubleSolenoid(RobotMap.FORWARD_CHANNEL_GRIPPER,RobotMap.REVERSE_CHANNEL_GRIPPER)
    val cubeShooter = DoubleSolenoid(RobotMap.FORWARD_CHANNEL_SHOOTER,RobotMap.REVERSE_CHANNEL_SHOOTER)

    enum class PneumaticStates {
        PICK_UP_READY, BLOCK_SHOT_OUT
    }
    override fun initDefaultCommand() {
    }
    fun openGripper(){
        cubeGripper.set(DoubleSolenoid.Value.kForward)
    }

    fun closeGripper() {
        cubeGripper.set(DoubleSolenoid.Value.kReverse)
    }

    fun shootOut() {
        cubeShooter.set(DoubleSolenoid.Value.kForward)
    }

    fun shootIn() {
        cubeShooter.set(DoubleSolenoid.Value.kReverse)
    }
}
