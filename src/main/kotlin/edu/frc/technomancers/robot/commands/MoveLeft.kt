package edu.frc.technomancers.robot.commands

import edu.frc.technomancers.robot.RobotMap

class MoveLeft(private val Distance: Double, private val sensor: Int) : CommandBase(){
    private var finished = true
    init {
        finished = false
        requires(driveTrain)
    }

    override fun execute() {
        when(sensor) {
            0-> {
                if (Distance < driveTrain.getRightSonic()) {
                    CommandBase.driveTrain.swerveTranslate.calculate(-1.0 * RobotMap.AUTO_SPEED, 0.0, 0.0)
                    CommandBase.driveTrain.swerveDrive()
                } else if(driveTrain.getRightSonic() < 0){
                    CommandBase.driveTrain.swerveTranslate.calculate(-1.0 * RobotMap.AUTO_SPEED, 0.0, 0.0)
                    CommandBase.driveTrain.swerveDrive()
                } else {
                    finished = true
                }
            }
            1 -> {
                if (Math.abs(Distance - driveTrain.getFrontLeftSonic()) < 20 && Math.abs(Distance - driveTrain.getFrontRightSonic()) < 20) {
                    CommandBase.driveTrain.swerveTranslate.calculate(-1.0 * RobotMap.AUTO_SPEED, 0.0, 0.0)
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