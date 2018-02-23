package edu.frc.technomancers.robot.commands

import edu.frc.technomancers.robot.RobotMap
import edu.wpi.first.wpilibj.Timer

class CubeLiftToPosition(): CommandBase(){
    private var finished = false
    private val timer = Timer()

    init {
        requires(robotLift)
        timer.start()
    }

    override fun execute() {
        if(!timer.hasPeriodPassed(RobotMap.TIME_CUBE_TO_TOP)){
            robotLift.setLiftSpeed(1.0)
        } else {
            finished = true
            timer.stop()
        }
    }

    override fun end(){
        robotLift.setLiftSpeed(0.0)
    }

    override fun isFinished(): Boolean {
        return finished
    }
}
