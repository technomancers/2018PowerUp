package edu.frc.technomancers.robot.commands

import edu.frc.technomancers.robot.RobotMap

class MoveRight(private val Distance: Double, private val sensor: Int) : CommandBase(){
    private var finished = true
    init {
        finished = false
        requires(driveTrain)
    }

    override fun execute() {
        when (sensor) {
            0 -> {
                if (Distance > driveTrain.getLeftSonic()) {
                    CommandBase.driveTrain.swerveTranslate.calculate(RobotMap.AUTO_SPEED, 0.0, 0.0)
                    CommandBase.driveTrain.swerveDrive()
                } else if(driveTrain.getLeftSonic() < 0) {
                    CommandBase.driveTrain.swerveTranslate.calculate(RobotMap.AUTO_SPEED, 0.0, 0.0)
                    CommandBase.driveTrain.swerveDrive()
                } else {
                    finished = true
                }
            }
            1 -> {
                if (Math.abs(Distance - driveTrain.getFrontLeftSonic()) < 20 && Math.abs(Distance - driveTrain.getFrontRightSonic()) < 20) {
                    CommandBase.driveTrain.swerveTranslate.calculate(RobotMap.AUTO_SPEED, 0.0, 0.0)
                    CommandBase.driveTrain.swerveDrive()
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