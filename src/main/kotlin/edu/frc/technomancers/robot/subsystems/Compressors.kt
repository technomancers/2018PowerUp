package edu.frc.technomancers.robot.subsystems

import edu.wpi.first.wpilibj.command.Subsystem
import edu.wpi.first.wpilibj.Compressor

import edu.frc.technomancers.robot.RobotMap
import edu.frc.technomancers.robot.commands.ToggleCompressor


class Compressors: Subsystem() {
    var compressor = Compressor(RobotMap.COMPRESSOR_NODE_ID)
    
    init {
        compressor.closedLoopControl = false
    }
    override fun initDefaultCommand() {
        defaultCommand = ToggleCompressor()
    }

    fun toggleCompressor(){
        compressor.closedLoopControl = !compressor.pressureSwitchValue
    }
}
