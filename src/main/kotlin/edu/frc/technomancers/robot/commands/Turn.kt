package edu.frc.technomancers.robot.commands

import edu.frc.technomancers.robot.RobotMap
import edu.wpi.first.wpilibj.Timer

class Turn(private val direction: String): CommandBase(){
    private var finished = false
    val timer = Timer()
    init {
        timer.start()
    }
    override fun execute() {
        when(direction){
            "Left" -> {
                if(!timer.hasPeriodPassed(RobotMap.TURN_TIME)){
                    driveTrain.tankDrive(-1.0 * RobotMap.AUTO_SPEED, RobotMap.AUTO_SPEED)
                } else {
                    finished = true
                    timer.stop()
                }
            }
            "Right" -> {
                if(!timer.hasPeriodPassed(RobotMap.TURN_TIME)){
                    driveTrain.tankDrive(RobotMap.AUTO_SPEED, -1.0 * RobotMap.AUTO_SPEED)
                } else {
                    finished = true
                    timer.stop()
                }
            }
        }
    }

    override fun end() {
        driveTrain.tankDrive(0.0,0.0)
    }

    override fun isFinished(): Boolean {
        return finished
    }
}
