package edu.frc.technomancers.robot.commands.Autonomous

import edu.frc.technomancers.robot.commands.MoveLeft
import edu.wpi.first.wpilibj.command.CommandGroup

class LeftScale: CommandGroup(){
    init{
        addSequential(MoveLeft(,0))
        addSequential(MoveLeft(,1))
    }
}
