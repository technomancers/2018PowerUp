package edu.frc.technomancers.robot.commands.Autonomous

import edu.frc.technomancers.robot.commands.MoveLeft
import edu.wpi.first.wpilibj.command.CommandGroup

class LeftSwitch: CommandGroup(){
    init {
        addSequential(MoveLeft(358.5,0))
    }
}