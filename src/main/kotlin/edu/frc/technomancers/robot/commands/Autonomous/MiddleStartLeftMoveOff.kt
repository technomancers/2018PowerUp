package edu.frc.technomancers.robot.commands.Autonomous

import edu.frc.technomancers.robot.RobotMap
import edu.frc.technomancers.robot.commands.MoveForward
import edu.frc.technomancers.robot.commands.MoveLeft
import edu.wpi.first.wpilibj.command.CommandGroup

class MiddleStartLeftMoveOff: CommandGroup(){
    init {
        addSequential(MoveLeft(RobotMap.DIST_SWITCH_FRONT_TO_WALL,1))
        addSequential(MoveForward(RobotMap.DIST_SWITCH_FRONT_TO_WALL))
    }
}