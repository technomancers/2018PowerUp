package edu.frc.technomancers.robot.commands

import edu.frc.technomancers.robot.RobotMap
import edu.wpi.first.wpilibj.Timer

class Turn(private val direction: String): CommandBase(){
    private var finished = false
    val timer = Timer()

    override fun execute() {
        when(direction){
            "Left" -> {
                timer.start()
                if(!timer.hasPeriodPassed(RobotMap.TURN_TIME)){
                    driveTrain.tankDrive(-1.0 * RobotMap.AUTO_SPEED, RobotMap.AUTO_SPEED)
                } else {
                    finished = true
                    timer.stop()
                }
            }
            "Right" -> {
                timer.start()
                if(!timer.hasPeriodPassed(RobotMap.TURN_TIME)){
                    driveTrain.tankDrive(RobotMap.AUTO_SPEED, -1.0 * RobotMap.AUTO_SPEED)
                } else {
                    finished = true
                    timer.stop()
                }
            }
        }
    }

    override fun isFinished(): Boolean {
        return finished
    }
}