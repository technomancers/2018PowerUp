package edu.frc.technomancers.robot.commands.autonomous

import edu.frc.technomancers.robot.RobotMap
import edu.frc.technomancers.robot.commands.MoveForward
import edu.wpi.first.wpilibj.command.CommandGroup


class LeftDefensive: CommandGroup(){
    init {
        addSequential(MoveForward(RobotMap.DIST_SWITCH_SIDE_TO_WALL,MoveForward.Sensor.BACK))
        addSequential(MoveForward(RobotMap.DIST_SCALE_TO_ROBOT, MoveForward.Sensor.RIGHT))
    }
}
