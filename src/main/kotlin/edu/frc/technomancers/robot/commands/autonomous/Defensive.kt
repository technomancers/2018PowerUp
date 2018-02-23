package edu.frc.technomancers.robot.commands.autonomous

import edu.frc.technomancers.robot.commands.MoveForward
import edu.wpi.first.wpilibj.command.CommandGroup

class Defensive: CommandGroup(){
    init {
        addSequential(MoveForward())
    }
}