package edu.frc.technomancers.robot.commands

class TurnOnCompressor: CommandBase(){
    private var finished = false
    init {
        requires(compressor)
    }
    override fun execute() {
        compressor.turnOnCompressor()
        finished = true
    }
    override fun isFinished(): Boolean {
        return finished
    }
}