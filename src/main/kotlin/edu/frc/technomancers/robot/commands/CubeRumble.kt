package edu.frc.technomancers.robot.commands

import edu.frc.technomancers.robot.Operator

    class CubeRumble: CommandBase() {
    private var finished: Boolean = false

    init {
        fun CubeRumble() {
            requires(cubePickup)
        }

        finished = false
    }

    override fun execute() {
        if (cubePickup.isOpen()) {
            Operator.drivingController.setRumble(1.0)
        } else {
            Operator.drivingController.setRumble(0.0)
        }
    }

    override fun isFinished(): Boolean {
        return finished
    }

    override fun end() {
    }

    override fun interrupted() {
    }
}
