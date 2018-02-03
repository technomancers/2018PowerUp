package edu.frc.technomancers.robot.commands

class ControlPickup : CommandBase() {

    private var finished = false

    fun ControlPickup() {
        requires(cubePickup)
    }

    init {
        finished = false
    }


    override fun execute() {
        if (cubePickup.isOpen()) {
            cubePickup.close()
        } else {
            cubePickup.open()
        }
        finished = true
    }

    override fun isFinished(): Boolean {
        return finished
    }
    override fun end() {}

    override fun interrupted() {}

}