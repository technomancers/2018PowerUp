package edu.frc.technomancers.robot.commands.Autonomous

import edu.frc.technomancers.robot.RobotMap
import edu.frc.technomancers.robot.commands.MoveForward
import edu.frc.technomancers.robot.commands.Turn
import edu.wpi.first.wpilibj.command.CommandGroup


class RightSwitch: CommandGroup(){
    init {
        addSequential(MoveForward(RobotMap.DIST_SWITCH_SIDE_TO_WALL, 2))
        addSequential(MoveForward(RobotMap.DIST_ROBOT_TO_SWITCH, 3))
        addSequential(Turn("Left"))
        addSequential(MoveForward(0.0, 0))
    }
}