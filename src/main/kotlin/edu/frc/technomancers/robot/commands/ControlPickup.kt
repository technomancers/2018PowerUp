package edu.frc.technomancers.robot.commands

import edu.frc.technomancers.robot.Operator
import edu.frc.technomancers.robot.RobotMap
import edu.frc.technomancers.robot.subsystems.CubePickup

class ControlPickup : CommandBase() {
    private var finished = false
    private var pneumaticState = CubePickup.PneumaticStates.CLOSED

    init {
        requires(cubePickup)
    }

    override fun execute() {
        when(pneumaticState){
            CubePickup.PneumaticStates.CLOSED ->{
                cubePickup.openGripper()
                pneumaticState = CubePickup.PneumaticStates.OPENED
            }
            CubePickup.PneumaticStates.OPENED ->{
                cubePickup.closeGripper()
                pneumaticState = CubePickup.PneumaticStates.CLOSED
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
