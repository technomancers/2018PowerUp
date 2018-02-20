package edu.frc.technomancers.robot.commands.Autonomous

import edu.frc.technomancers.robot.RobotMap
import edu.frc.technomancers.robot.commands.MoveForward
import edu.wpi.first.wpilibj.command.CommandGroup


class RightDefensive: CommandGroup(){
    init {
        addSequential(MoveForward(RobotMap.DIST_SWITCH_SIDE_TO_WALL,2))
        addSequential(MoveForward(RobotMap.DIST_SCALE_TO_ROBOT, 3))
    }
}