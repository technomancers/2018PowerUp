package edu.frc.technomancers.robot.commands

import edu.frc.technomancers.robot.Operator
import edu.frc.technomancers.robot.subsystems.CubePickup

class CubeRumble: CommandBase() {
    private var finished = false
    private var pneumaticState = CubePickup.pneumaticStates.PICK_UP_READY

    init {
        requires(cubePickup)
    }

    init {
        finished = false
    }

    override fun execute() {
        when (pneumaticState) {
            CubePickup.pneumaticStates.PICK_UP_READY -> {
                Operator.drivingController.setRumble(1.0)
            }
            CubePickup.pneumaticStates.GRIP_CLOSED -> {
            }
            CubePickup.pneumaticStates.BLOCK_SHOT_OUT -> {
                Operator.drivingController.setRumble(0.0)
            }
        }
        finished = true
    }

    override fun isFinished(): Boolean {
        return finished
    }

    override fun end() {
    }

    override fun interrupted() {
    }
}
