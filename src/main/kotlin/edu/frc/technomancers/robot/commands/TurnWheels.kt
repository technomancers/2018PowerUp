package edu.frc.technomancers.robot.commands

class TurnWheels: CommandBase(){
    var finished = false
    init {
        requires(driveTrain)
    }
    override fun execute() {
        driveTrain.turnFrontLeft()
        finished = false
    }
    override fun isFinished(): Boolean {
        return finished
    }
}