package edu.frc.technomancers.robot.commands

import edu.frc.technomancers.robot.Operator
import edu.frc.technomancers.utilities.Controller

class RunMotor: CommandBase(){

    var finished = false
    init {
        requires(testmotor)
    }

    override fun execute() {
        var speed = 0.0
        //Multiply by .5 to slow it down
        speed -= Operator.drivingController.getNormalizedAxis(Controller.Axes.TRIGGER_LEFT)
        speed += Operator.drivingController.getNormalizedAxis(Controller.Axes.TRIGGER_RIGHT)
        testmotor.setSpeed(speed)
    }

    override fun isFinished(): Boolean {
        return finished
    }
}