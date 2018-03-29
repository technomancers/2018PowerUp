package edu.frc.technomancers.robot

import edu.frc.technomancers.utilities.Vision
import edu.wpi.first.wpilibj.IterativeRobot

class Robot : IterativeRobot() {

    override fun robotInit() {
        println("Robo Init")
        Vision()
    }

    override fun robotPeriodic() {
    }

    override fun autonomousInit() {
    }

    override fun autonomousPeriodic() {
    }

    override fun teleopInit() {
    }

    override fun teleopPeriodic() {
    }
}
