package edu.frc.technomancers.robot.commands

class CubeLiftToPosition(Position: Double): CommandBase(){
    var finished = false
    val position = Position

    init {
        requires(robotLift)
    }

    override fun execute() {
        robotLift.liftToPosition(position)
        finished = true
    }

    override fun isFinished(): Boolean {
        return finished
    }
}
