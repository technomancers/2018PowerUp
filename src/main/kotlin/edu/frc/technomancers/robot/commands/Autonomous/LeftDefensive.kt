package edu.frc.technomancers.robot.commands.Autonomous

import edu.frc.technomancers.robot.RobotMap
import edu.frc.technomancers.robot.commands.MoveLeft
import edu.wpi.first.wpilibj.command.CommandGroup


class LeftDefensive: CommandGroup(){
    init {
        addSequential(MoveLeft(RobotMap.DIST_SWITCH_SIDE_TO_WALL,0))
        addSequential(MoveLeft(RobotMap.DIST_SCALE_TO_ROBOT, 1))
    }
}