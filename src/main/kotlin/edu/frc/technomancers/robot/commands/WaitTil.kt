package edu.frc.technomancers.robot.commands

import edu.wpi.first.wpilibj.Timer

class WaitTil: CommandBase() {
    private var finished: Boolean = false
    private var timer = Timer()
    private var seconds: Double = 0.0 //0.0, false, and 0 are place holding values

    fun WaitTil(seconds: Double) {
        this.seconds = seconds
    }
    init {
        finished = false
        timer.start()
    }

    override fun execute() {
        if (timer.get() > seconds){
            finished = true
        }
    }

    override fun isFinished(): Boolean {
        return finished
    }
}