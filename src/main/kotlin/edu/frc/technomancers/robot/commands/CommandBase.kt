package edu.frc.technomancers.robot.commands

import edu.frc.technomancers.subsystems.DriveTrain
import edu.wpi.first.wpilibj.command.Command

abstract class CommandBase : Command() {
    private val driveTrain = DriveTrain()

    public fun getDriveTrain() : DriveTrain{
        return driveTrain
    }


}