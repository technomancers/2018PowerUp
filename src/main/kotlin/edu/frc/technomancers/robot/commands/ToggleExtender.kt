package edu.frc.technomancers.robot.commands

import edu.frc.technomancers.robot.RobotMap
import edu.frc.technomancers.robot.subsystems.Extenders
import edu.wpi.first.wpilibj.Timer


class ToggleExtender: CommandBase(){

    val extenderPosition = Extenders.ExtenderState.UP
    var finished = false
    val timer = Timer()

    init {
        requires(extenders)
        timer.reset()
        timer.start()
    }

    override fun execute() {
        when(extenderPosition){
            Extenders.ExtenderState.UP -> {
                if(!timer.hasPeriodPassed(RobotMap.EXTENSION_TIME)){
                    extenders.moveDown()
                } else {
                    timer.stop()
                    finished = true
                }
            }
            Extenders.ExtenderState.DOWN -> {
                if(!timer.hasPeriodPassed(RobotMap.EXTENSION_TIME)){
                    extenders.moveUp()
                } else {
                    timer.stop()
                    finished = true
                }
            }
        }
    }

    override fun end() {
        extenders.stopMotor()
    }

    override fun isFinished(): Boolean {
        return finished
    }
}