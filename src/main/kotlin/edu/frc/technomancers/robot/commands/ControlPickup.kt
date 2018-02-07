package edu.frc.technomancers.robot.commands

class ControlPickup : CommandBase() {

    private var finished = false

    init {
        fun ControlPickup() {
            requires(cubePickup)
        }
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