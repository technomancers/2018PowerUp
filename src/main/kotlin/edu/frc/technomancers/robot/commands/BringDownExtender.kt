package edu.frc.technomancers.robot.commands

import edu.frc.technomancers.robot.RobotMap
import edu.wpi.first.wpilibj.Timer

class BringDownExtender: CommandBase(){
    private var finished = false
    private val timer = Timer()

    init {
        requires(extenders)
        timer.start()
    }

    override fun execute() {
        if(!timer.hasPeriodPassed(RobotMap.EXTENSION_TIME)){
            extenders.setSpeed(-1.0 * RobotMap.EXTENDER_SPEED)
        } else {
            finished = true
            timer.stop()
        }
    }

    override fun end(){
        extenders.setSpeed(0.0)
    }

    override fun isFinished(): Boolean {
        return finished
    }
}