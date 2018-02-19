package edu.frc.technomancers.robot

import edu.frc.technomancers.robot.commands.Autonomous.*
import edu.frc.technomancers.robot.commands.DriveWithJoystick
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
        val startPos = autoChooser.selected
        var autonomousCommand: Command? = null
        val platePositions = DriverStation.getInstance().gameSpecificMessage.toCharArray()
        System.out.println(platePositions[0])
        System.out.println(platePositions[1])
        System.out.println(platePositions[2])
        (RightSwitch()).start()
//        System.out.println(startPos)
//        when(startPos){
//            StartingPosition.LEFT -> {
//                if(platePositions[0] == 'L'){
//                    autonomousCommand = LeftSwitch()
//                } else if(platePositions[1] == ('L')){
//                    autonomousCommand = LeftScale()
//                } else{
//                    autonomousCommand = LeftDefensive()
//                }
//            }
//            StartingPosition.MIDDLE_DEFENSIVE -> {
//                if (platePositions[0] == 'L') {
//                    autonomousCommand = MiddleStartRightMoveDef()
//                } else if (platePositions[0] == 'R') {
//                    autonomousCommand = MiddleStartLeftMoveDef()
//                }
//            }
//            StartingPosition.MIDDLE_OFFENSIVE -> {
//                if (platePositions[0] == 'L') {
//                    autonomousCommand = MiddleStartLeftMoveOff()
//                } else if (platePositions[0] == 'R') {
//                    autonomousCommand = MiddleStartRightMoveOff()
//                }
//            }
//            StartingPosition.RIGHT -> {
//                if(platePositions[0] == 'R'){
//                    autonomousCommand = RightSwitch()
//                } else if(platePositions[1] == 'R'){
//                    autonomousCommand = RightScale()
//                } else{
//                    autonomousCommand = RightDefensive()
//                }
//            }
//        }
//        if(autonomousCommand != null){
//            autonomousCommand.start()
//        }
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
