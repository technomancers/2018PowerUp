package edu.frc.technomancers.robot.commands

import edu.frc.technomancers.robot.Operator
import edu.frc.technomancers.robot.RobotMap


class ToggleExtender: CommandBase(){

    var finished = false

    init {
        requires(extenders)
    }

    override fun execute() {
        var speed = 0.0
        if(Operator.drivingController.buttonX.get()){
            speed += RobotMap.EXTENDER_SPEED
        }
        if(Operator.drivingController.buttonB.get()){
            speed -= RobotMap.EXTENDER_SPEED
        }
        extenders.setSpeed(speed)
    }

    override fun isFinished(): Boolean {
        return finished
    }
}
