package edu.frc.technomancers.robot.commands.autonomous

import edu.frc.technomancers.robot.commands.ControlPickup
import edu.frc.technomancers.robot.commands.CubeLiftToPosition
import edu.frc.technomancers.robot.commands.MoveForward
import edu.wpi.first.wpilibj.command.CommandGroup

class Offensive: CommandGroup(){
    init {
        addParallel(CubeLiftToPosition())
        addSequential(MoveForward())
        addSequential(ControlPickup())
    }
}