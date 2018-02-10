package edu.frc.technomancers.robot.subsystems

import edu.frc.technomancers.robot.RobotMap
import edu.frc.technomancers.robot.commands.ControlPickup
import edu.wpi.first.wpilibj.DoubleSolenoid
import edu.wpi.first.wpilibj.command.Subsystem

class CubePickup: Subsystem() {
    val cubeGripper = DoubleSolenoid(RobotMap.FORWARD_CHANNEL,RobotMap.REVERSE_CHANNEL)
    val cubeShooter = DoubleSolenoid(RobotMap.FORWARD_CHANNEL,RobotMap.REVERSE_CHANNEL)

    enum class pneumaticStates{
        PICK_UP_READY, GRIP_CLOSED, BLOCK_SHOT_OUT
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