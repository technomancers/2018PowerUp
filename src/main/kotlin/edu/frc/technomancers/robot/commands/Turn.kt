package edu.frc.technomancers.robot.commands

import edu.frc.technomancers.robot.RobotMap
import org.apache.commons.math3.util.FastMath

class Turn(private val direction: String, private val Distance: Double): CommandBase(){
    private var finished = false

    override fun execute() {
        when(direction){
            "Left" -> {
                if(FastMath.abs(Distance - driveTrain.getFrontRightSonic()) > RobotMap.AUTO_TOLERANCE &&
                        FastMath.abs(Distance - driveTrain.getFrontLeftSonic()) > RobotMap.AUTO_TOLERANCE){
                    driveTrain.tankDrive(-1.0 * RobotMap.AUTO_SPEED, RobotMap.AUTO_SPEED)
                } else {
                    finished = true
                }
            }
            "Right" -> {
                if(FastMath.abs(Distance - driveTrain.getFrontRightSonic()) > RobotMap.AUTO_TOLERANCE &&
                        FastMath.abs(Distance - driveTrain.getFrontLeftSonic()) > RobotMap.AUTO_TOLERANCE){
                    driveTrain.tankDrive(RobotMap.AUTO_SPEED, -1.0 * RobotMap.AUTO_SPEED)
                } else {
                    finished = true
                }
            }
        }
    }

    override fun isFinished(): Boolean {
        return finished
    }
}