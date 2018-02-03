package edu.frc.technomancers.robot.subsystems

import edu.wpi.first.wpilibj.command.Subsystem
import edu.wpi.first.wpilibj.Compressor

import edu.frc.technomancers.robot.RobotMap


class Compressors: Subsystem() {
    var compressor = Compressor(RobotMap.COMPRESSOR_NODE_ID)
    init {
        compressor.closedLoopControl = false
    }
    override fun initDefaultCommand() {}

    fun turnOnCompressor() {
        compressor.closedLoopControl = true
    }
    fun turnOffCompressor() {
        compressor.closedLoopControl = false
    }
}

