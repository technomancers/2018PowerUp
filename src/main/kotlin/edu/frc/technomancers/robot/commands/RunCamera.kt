package edu.frc.technomancers.robot.commands

class RunCamera: CommandBase(){
    var finished = false

    init {
        requires(vision)
    }

    override fun execute() {
        vision.startCameraStream()
        finished = true
    }

    override fun isFinished(): Boolean {
        return finished
    }
}
