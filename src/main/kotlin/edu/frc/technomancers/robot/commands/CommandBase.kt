package edu.frc.technomancers.robot.commands

import edu.frc.technomancers.robot.subsystems.*
import edu.wpi.first.wpilibj.command.Command
abstract class CommandBase : Command() {
    companion object {
        val driveTrain = DriveTrain()
        val compressor = Compressors()
        val cubePickup = CubePickup()
        val robotLift = RobotLift()
        val extenders = Extenders()
    }
}
