package edu.frc.technomancers.robot.commands.autonomous

import edu.frc.technomancers.robot.RobotMap
import edu.frc.technomancers.robot.commands.MoveForward
import edu.frc.technomancers.robot.commands.Turn
import edu.wpi.first.wpilibj.command.CommandGroup

class LeftSwitch: CommandGroup(){
    init {
        addSequential(MoveForward(RobotMap.DIST_SWITCH_SIDE_TO_WALL, MoveForward.Sensor.BACK))
        addSequential(Turn("Right"))
        addSequential(MoveForward(0.0, MoveForward.Sensor.FRONT))
    }
}
