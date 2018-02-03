package edu.frc.technomancers.robot.commands

import edu.frc.technomancers.robot.subsystems.Compressors
import edu.frc.technomancers.robot.subsystems.CubePickup
import edu.frc.technomancers.robot.subsystems.DriveTrain
import edu.wpi.first.wpilibj.command.Command

abstract class CommandBase : Command() {
    companion object {
        val driveTrain = DriveTrain()
        val compressor = Compressors()
        val cubePickup = CubePickup()
    }
}
