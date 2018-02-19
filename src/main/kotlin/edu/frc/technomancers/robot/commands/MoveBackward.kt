package edu.frc.technomancers.robot.commands

import edu.frc.technomancers.robot.RobotMap

class MoveBackward(private val Distance: Double) : CommandBase(){
    private var finished = true
    init {
        finished = false
        requires(driveTrain)
    }

    override fun execute() {
        if (CommandBase.driveTrain.getBackSonic() > Distance) {
            CommandBase.driveTrain.swerveTranslate.calculate(0.0, -1.0 * RobotMap.AUTO_SPEED, 0.0)
            CommandBase.driveTrain.swerveDrive()
        } else {
            finished = true
        }
    }

    override fun isFinished(): Boolean {
        return finished
    }
}
