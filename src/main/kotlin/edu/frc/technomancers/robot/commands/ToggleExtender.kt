package edu.frc.technomancers.robot.commands

import edu.frc.technomancers.robot.Operator
import edu.frc.technomancers.robot.RobotMap
import edu.frc.technomancers.robot.subsystems.Extenders
import edu.frc.technomancers.utilities.Controller
import edu.wpi.first.wpilibj.Timer
import edu.wpi.first.wpilibj.smartdashboard.SendableBuilder


class ToggleExtender: CommandBase(){

    var finished = false

    init {
        requires(extenders)
    }

    override fun execute() {
        var speed = 0.0
        //Multiply by .5 to slow it down
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