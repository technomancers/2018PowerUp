package edu.frc.technomancers.robot.commands

import edu.frc.technomancers.robot.subsystems.CubePickup

class ControlPickup : CommandBase() {
    private var finished = false
    private var pneumaticState = CubePickup.pneumaticStates.PICK_UP_READY

    init {
        requires(cubePickup)
    }

    override fun execute() {
        when(pneumaticState){
            CubePickup.pneumaticStates.PICK_UP_READY ->{
                cubePickup.closeGripper()
                pneumaticState = CubePickup.pneumaticStates.GRIP_CLOSED
            }
            CubePickup.pneumaticStates.GRIP_CLOSED ->{
                cubePickup.openGripper()
                cubePickup.shootOut()
                pneumaticState = CubePickup.pneumaticStates.BLOCK_SHOT_OUT
            }
            CubePickup.pneumaticStates.BLOCK_SHOT_OUT ->{
                cubePickup.shootIn()
                pneumaticState= CubePickup.pneumaticStates.PICK_UP_READY
            }
        }
        finished = true
    }

    override fun isFinished(): Boolean {
        return finished
    }
    override fun end() {}

    override fun interrupted() {}

}