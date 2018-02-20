package edu.frc.technomancers.robot.commands.Autonomous

import edu.frc.technomancers.robot.RobotMap
import edu.frc.technomancers.robot.commands.MoveForward
import edu.frc.technomancers.robot.commands.Turn
import edu.wpi.first.wpilibj.command.CommandGroup

class MiddleStartLeftMoveOff: CommandGroup(){
    init {
        addSequential(Turn("Left"))
        addSequential(MoveForward(RobotMap.MIDDLE_MOVEMENT, 0))
        addSequential(Turn("Right"))
        addSequential(MoveForward(0.0,0))
    }
}