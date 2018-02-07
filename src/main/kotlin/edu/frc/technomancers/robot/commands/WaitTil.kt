package edu.frc.technomancers.robot.commands

import edu.wpi.first.wpilibj.Timer

class WaitTil(seconds: Double): CommandBase() {
    private var finished: Boolean = false
    private var timer = Timer()
    private var seconds: Double = 0.0 //0.0, false, and 0 are place holding values

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