package edu.frc.technomancers.robot.commands.Autonomous

import edu.frc.technomancers.robot.RobotMap
import edu.frc.technomancers.robot.commands.MoveRight
import edu.wpi.first.wpilibj.command.CommandGroup


class RightDefensive: CommandGroup(){
    init {
        addSequential(MoveRight(RobotMap.DIST_SWITCH_SIDE_TO_WALL,0))
        addSequential(MoveRight(RobotMap.DIST_SCALE_TO_ROBOT, 1))
    }
}