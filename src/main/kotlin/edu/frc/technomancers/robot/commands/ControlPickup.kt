package edu.frc.technomancers.robot.commands

import edu.frc.technomancers.robot.Operator
import edu.frc.technomancers.robot.RobotMap
import edu.frc.technomancers.robot.subsystems.CubePickup

class ControlPickup : CommandBase() {
    private var finished = false
    private var pneumaticState = CubePickup.PneumaticStates.PICK_UP_READY

    init {
        requires(cubePickup)
    }

    override fun execute() {
        when(pneumaticState){
            CubePickup.PneumaticStates.PICK_UP_READY ->{
                cubePickup.closeGripper()
                pneumaticState = CubePickup.PneumaticStates.BLOCK_SHOT_OUT
                Operator.drivingController.setRumble(.5
                )
            }
            CubePickup.PneumaticStates.BLOCK_SHOT_OUT ->{
                cubePickup.shootOut()
                Thread.sleep((RobotMap.SHOOTING_WAIT_TIME).toLong())
                cubePickup.openGripper()
                Thread.sleep((RobotMap.SHOOTING_WAIT_TIME).toLong())
                cubePickup.shootIn()
                Operator.drivingController.setRumble(0.0)
                pneumaticState = CubePickup.PneumaticStates.PICK_UP_READY
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
