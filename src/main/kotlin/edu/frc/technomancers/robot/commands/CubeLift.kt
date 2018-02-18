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
        //Multiply by .5 to slow it down
        speed -= .5 * Operator.drivingController.getNormalizedAxis(Controller.Axes.TRIGGER_LEFT)
        speed += .5 * Operator.drivingController.getNormalizedAxis(Controller.Axes.TRIGGER_RIGHT)
        robotLift.setLiftSpeed(speed)
    }

    override fun isFinished(): Boolean {
        return isFinished
    }
}