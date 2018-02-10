package edu.frc.technomancers.robot.commands

class MoveBackward(private val Distance: Double) : CommandBase(){
    private var finished = true
    init {
        finished = false
        requires(driveTrain)
    }

    override fun execute() {
        if (driveTrain.getBackSonic() > Distance) {
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
