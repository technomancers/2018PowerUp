package edu.frc.technomancers.robot.commands

import edu.frc.technomancers.robot.subsystems.Compressors

class ToggleCompressor: CommandBase() {
    private var engaged: Boolean = false
    private var finished: Boolean = false

    init {
        fun ToggleCompressor() {
            requires(compressor)
            engaged = false
        }
        finished = false
    }

    override fun execute() {
        if (engaged){
            compressor.turnOffCompressor()
        }
        else{
            compressor.turnOnCompressor()
        }
        finished = true
    }

    override fun isFinished(): Boolean {
        return finished
    }

    override fun end() {
    }

    override fun interrupted() {
    }
}