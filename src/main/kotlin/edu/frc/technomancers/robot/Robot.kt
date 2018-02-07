package edu.frc.technomancers.robot

import edu.frc.technomancers.robot.commands.ControlPickup
import edu.frc.technomancers.robot.commands.DriveWithJoystick
import edu.wpi.first.wpilibj.IterativeRobot
import edu.wpi.first.wpilibj.command.Scheduler

class Robot : IterativeRobot() {
    override fun robotInit() {
        Scheduler.getInstance().add(DriveWithJoystick())
    }

    override fun robotPeriodic() {
    }

    override fun autonomousInit() {
    }

    override fun autonomousPeriodic() {
        Scheduler.getInstance().run()
    }

    override fun teleopInit() {
    }

    override fun teleopPeriodic() {
        Operator.drivingController.buttonA.whenPressed(ControlPickup())
        Scheduler.getInstance().run()
    }
}
