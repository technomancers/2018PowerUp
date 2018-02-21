package edu.frc.technomancers.robot.commands.autonomous

import edu.frc.technomancers.robot.RobotMap
import edu.frc.technomancers.robot.commands.MoveForward
import edu.frc.technomancers.robot.commands.Turn
import edu.wpi.first.wpilibj.command.CommandGroup

class MiddleStartLeftMoveOff: CommandGroup(){
    init {
        addSequential(Turn("Left"))
        addSequential(MoveForward(RobotMap.MIDDLE_MOVEMENT, MoveForward.Sensor.FRONT))
        addSequential(Turn("Right"))
        addSequential(MoveForward(0.0,MoveForward.Sensor.FRONT))
    }
}
