package edu.frc.technomancers.robot.commands.Autonomous

import edu.frc.technomancers.robot.RobotMap
import edu.frc.technomancers.robot.commands.MoveForward
import edu.frc.technomancers.robot.commands.Turn
import edu.wpi.first.wpilibj.command.CommandGroup

class LeftSwitch: CommandGroup(){
    init {
        addSequential(MoveForward(RobotMap.DIST_SWITCH_SIDE_TO_WALL, 2))
        addSequential(Turn("Right"))
        addSequential(MoveForward(0.0, 0))
    }
}