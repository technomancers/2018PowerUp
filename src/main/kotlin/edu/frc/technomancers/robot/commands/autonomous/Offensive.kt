package edu.frc.technomancers.robot.commands.autonomous

import edu.frc.technomancers.robot.commands.*
import edu.wpi.first.wpilibj.command.CommandGroup

class Offensive: CommandGroup(){
    init {
        addParallel(CubeLiftToPosition())
        addParallel(BringDownExtender())
        addSequential(MoveForward())
        addSequential(BringUpExtender())
        addSequential(ControlPickup())
    }
}
