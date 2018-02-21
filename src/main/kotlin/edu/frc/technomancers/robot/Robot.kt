package edu.frc.technomancers.robot

import edu.frc.technomancers.robot.commands.ControlPickup
import edu.frc.technomancers.robot.commands.DriveWithJoystick
import edu.frc.technomancers.robot.commands.autonomous.RightSwitch
import edu.wpi.first.wpilibj.DriverStation
import edu.wpi.first.wpilibj.IterativeRobot
import edu.wpi.first.wpilibj.command.Command
import edu.wpi.first.wpilibj.command.Scheduler
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard

class Robot : IterativeRobot() {
    enum class StartingPosition{
        LEFT, MIDDLE_OFFENSIVE, MIDDLE_DEFENSIVE, RIGHT
    }

    val autoChooser = SendableChooser<StartingPosition>()

    override fun robotInit() {
        Scheduler.getInstance().add(DriveWithJoystick())
        autoChooser.addObject("LEFT", StartingPosition.LEFT)
        autoChooser.addObject("MIDDLE OFFENSIVE", StartingPosition.MIDDLE_OFFENSIVE)
        autoChooser.addObject("MIDDLE DEFENSIVE", StartingPosition.MIDDLE_DEFENSIVE)
        autoChooser.addObject("RIGHT", StartingPosition.RIGHT)
        SmartDashboard.putData(autoChooser)
    }

    override fun robotPeriodic() {
    }

    override fun autonomousInit() {
    }

    override fun autonomousPeriodic() {
        Scheduler.getInstance().run()
    }

    override fun teleopInit() {
        Operator.drivingController.buttonA.whenPressed(ControlPickup())
    }

    override fun teleopPeriodic() {
        Scheduler.getInstance().run()
    }
}
