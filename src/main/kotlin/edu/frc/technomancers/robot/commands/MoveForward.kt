package edu.frc.technomancers.robot.commands

import edu.frc.technomancers.robot.RobotMap
import org.apache.commons.math3.util.FastMath

class MoveForward(private val Distance: Double, private val sensor: Int) : CommandBase(){
    private var finished = true

    init {
        finished = false
        requires(CommandBase.driveTrain)
    }

    override fun execute() {
        when(sensor) {
            0 -> {
                if(driveTrain.getFrontRightSonic() > Distance || driveTrain.getFrontLeftSonic() > Distance){
                    driveTrain.tankDrive(RobotMap.AUTO_SPEED, RobotMap.AUTO_SPEED)
                } else {
                    finished = true
                }
            }
            1 -> {
                if(FastMath.abs(driveTrain.getRightSonic() - Distance) < RobotMap.AUTO_TOLERANCE){
                    driveTrain.tankDrive(RobotMap.AUTO_SPEED, RobotMap.AUTO_SPEED)
                } else {
                    finished = true
                }
            }
            2 -> {
                if (driveTrain.getBackSonic() < Distance) {
                    driveTrain.tankDrive(RobotMap.AUTO_SPEED, RobotMap.AUTO_SPEED)
                } else {
                    finished = true
                }
            }
            3 -> {
                if(FastMath.abs(driveTrain.getLeftSonic() - Distance) < RobotMap.AUTO_TOLERANCE){
                    driveTrain.tankDrive(RobotMap.AUTO_SPEED, RobotMap.AUTO_SPEED)
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
