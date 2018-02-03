package edu.frc.technomancers.robot.commands

class MoveBackward(Distance: Double) : CommandBase(){
    private var finished = true
    private val distance = Distance
    init {
        finished = false
        requires(driveTrain)
    }

    override fun execute() {
        if (driveTrain.getBackSonic() > distance) {
            driveTrain.swerveTranslate.calculate(0.0, -1.0, 0.0)
            driveTrain.swerveDrive()
        } else {
            finished = true
        }
    }

    override fun isFinished(): Boolean {
        return finished
    }
}
