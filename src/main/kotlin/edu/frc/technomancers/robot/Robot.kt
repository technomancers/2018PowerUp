package edu.frc.technomancers.robot

import edu.wpi.first.wpilibj.IterativeRobot
import edu.wpi.first.wpilibj.command.Scheduler

class Robot : IterativeRobot() {
    override fun robotInit() {
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
    }
}
