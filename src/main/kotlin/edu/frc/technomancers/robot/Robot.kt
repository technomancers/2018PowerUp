package edu.frc.technomancers.robot

import edu.frc.technomancers.robot.commands.DriveWithJoystick
import edu.frc.technomancers.robot.commands.TurnWheels
import edu.frc.technomancers.robot.subsystems.DriveTrain
import edu.wpi.first.wpilibj.IterativeRobot
import edu.wpi.first.wpilibj.command.Scheduler
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard

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
        Scheduler.getInstance().run()
        Operator.drivingController.buttonB.whenActive(TurnWheels())
    }
}
