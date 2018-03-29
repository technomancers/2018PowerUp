package edu.frc.technomancers.robot

import edu.frc.technomancers.robot.commands.ControlPickup
import edu.frc.technomancers.robot.commands.DriveWithJoystick
import edu.frc.technomancers.robot.commands.autonomous.Defensive
import edu.frc.technomancers.robot.commands.autonomous.Offensive
import edu.wpi.first.wpilibj.DriverStation
import edu.wpi.first.wpilibj.IterativeRobot
import edu.wpi.first.wpilibj.command.Scheduler
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard

class Robot : IterativeRobot() {
    enum class StartingPosition{
        LEFT, RIGHT, DEFAULT
    }

    val autoChooser = SendableChooser<StartingPosition>()

    override fun robotInit() {
        Scheduler.getInstance().add(DriveWithJoystick())
        autoChooser.addDefault("Default", StartingPosition.DEFAULT)
        autoChooser.addObject("Left", StartingPosition.LEFT)
        autoChooser.addObject("Right", StartingPosition.RIGHT)
        SmartDashboard.putData("Autonomous", autoChooser)
    }

    override fun robotPeriodic() {
    }

    override fun autonomousInit() {
        val input = autoChooser.selected
        val side = DriverStation.getInstance().gameSpecificMessage.toCharArray()
        if(input == StartingPosition.LEFT && side[0] == 'L'){
            Offensive().start()
        } else if(input == StartingPosition.RIGHT && side[0]== 'R'){
            Offensive().start()
        } else {
            Defensive().start()
        }
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
