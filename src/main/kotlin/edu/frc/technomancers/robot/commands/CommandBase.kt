package edu.frc.technomancers.robot.commands

import edu.frc.technomancers.subsystems.DriveTrain
import edu.wpi.first.wpilibj.command.Command

abstract class CommandBase : Command() {
    protected val driveTrain = DriveTrain()
}