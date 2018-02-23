package edu.frc.technomancers.robot.commands

import edu.frc.technomancers.robot.RobotMap
import edu.wpi.first.wpilibj.Timer
import org.apache.commons.math3.util.FastMath

class MoveForward() : CommandBase() {
    private var finished = true
    private val timer = Timer()

    init {
        finished = false
        requires(CommandBase.driveTrain)
        timer.start()
    }

    override fun execute() {
        if(!timer.hasPeriodPassed(RobotMap.TIME_TILL_SWITCH)){
            driveTrain.tankDrive(RobotMap.AUTO_SPEED, RobotMap.AUTO_SPEED)
        } else {
            finished = true
            timer.stop()
        }
    }

    override fun end() {
        driveTrain.tankDrive(0.0, 0.0)
    }

    override fun isFinished(): Boolean {
        return finished
    }
}
