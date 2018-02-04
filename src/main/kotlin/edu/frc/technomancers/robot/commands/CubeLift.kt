package edu.frc.technomancers.robot.commands

import edu.frc.technomancers.robot.Operator
import edu.frc.technomancers.utilities.Controller


class CubeLift: CommandBase(){
    private var isFinished = false
    init {
        requires(robotLift)
    }

    override fun execute() {
        var speed = 0.0
        speed -= Operator.drivingController.getNormalizedAxis(Controller.Axes.TRIGGER_LEFT)
        speed += Operator.drivingController.getNormalizedAxis(Controller.Axes.TRIGGER_RIGHT)
        robotLift.setLiftSpeed(speed)
    }

    override fun isFinished(): Boolean {
        return isFinished
    }
}