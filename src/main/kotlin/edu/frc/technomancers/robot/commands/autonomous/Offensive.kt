package edu.frc.technomancers.robot.commands.autonomous

import edu.frc.technomancers.robot.commands.ControlPickup
import edu.frc.technomancers.robot.commands.CubeLiftToPosition
import edu.frc.technomancers.robot.commands.MoveForward
import edu.frc.technomancers.robot.commands.ToggleExtender
import edu.wpi.first.wpilibj.command.CommandGroup

class Offensive: CommandGroup(){
    init {
        addParallel(ToggleExtender())
        addParallel(CubeLiftToPosition())
        addSequential(MoveForward())
        addSequential(ControlPickup())
    }
}
