package edu.frc.technomancers.robot.subsystems

import edu.frc.technomancers.robot.RobotMap
import edu.frc.technomancers.robot.commands.DriveWithJoystick
import edu.frc.technomancers.robot.utilities.SwerveTranslate
import edu.frc.technomancers.utilities.WheelDrive
import edu.wpi.first.wpilibj.command.Subsystem

class DriveTrain: Subsystem()
{
    private val frontLeftWheel = WheelDrive(RobotMap.LFMOTOR_DIRECTIONAL, RobotMap.LFMOTOR_ROTATIONAL)
    private val frontRightWheel = WheelDrive(RobotMap.RFMOTOR_DIRECTIONAL, RobotMap.RFMOTOR_ROTATIONAL)
    private val backLeftWheel = WheelDrive(RobotMap.LBMOTOR_DIRECTIONAL, RobotMap.LBMOTOR_ROTATIONAL)
    private val backRightWheel = WheelDrive(RobotMap.RBMOTOR_DIRECTIONAL,RobotMap.RBMOTOR_ROTATIONAL)
    val swerveTranslate = SwerveTranslate(RobotMap.ROBOT_LENGTH, RobotMap.ROBOT_WIDTH)

    override fun initDefaultCommand() {
        defaultCommand = DriveWithJoystick()
    }


    fun swerveDrive() {
        frontLeftWheel.drive(swerveTranslate.frontLeftMag, swerveTranslate.frontLeftAngle)
        frontRightWheel.drive(swerveTranslate.frontRightMag, swerveTranslate.frontRightAngle)
        backLeftWheel.drive(swerveTranslate.backLeftMag, swerveTranslate.backLeftAngle)
        backRightWheel.drive(swerveTranslate.backRightMag, swerveTranslate.backRightAngle)
    }


}
