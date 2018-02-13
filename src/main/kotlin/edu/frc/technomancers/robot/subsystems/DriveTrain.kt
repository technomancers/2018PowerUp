package edu.frc.technomancers.robot.subsystems

import edu.frc.technomancers.robot.RobotMap
import edu.frc.technomancers.robot.commands.DriveWithJoystick
import edu.frc.technomancers.utilities.SwerveTranslate
import edu.frc.technomancers.utilities.WheelDrive
import edu.wpi.first.wpilibj.AnalogInput
import edu.wpi.first.wpilibj.Encoder
import edu.wpi.first.wpilibj.command.Subsystem


class DriveTrain: Subsystem() {
    private val frontLeftWheel = WheelDrive(RobotMap.FRONT_LEFT_MOTOR_DIRECTIONAL, RobotMap.FRONT_LEFT_MOTOR_ROTATIONAL)
    private val frontRightWheel = WheelDrive(RobotMap.FRONT_RIGHT_MOTOR_DIRECTIONAL, RobotMap.FRONT_RIGHT_MOTOR_ROTATIONAL)
    private val backLeftWheel = WheelDrive(RobotMap.BACK_LEFT_MOTOR_DIRECTIONAL, RobotMap.BACK_LEFT_MOTOR_ROTATIONAL)
    private val backRightWheel = WheelDrive(RobotMap.BACK_RIGHT_MOTOR_DIRECTIONAL, RobotMap.BACK_RIGHT_MOTOR_ROTATIONAL)
    val swerveTranslate = SwerveTranslate(RobotMap.ROBOT_LENGTH, RobotMap.ROBOT_WIDTH)
    val test = AnalogInput(0)
    init {
    }

    override fun initDefaultCommand() {
        defaultCommand = DriveWithJoystick()
    }


    fun swerveDrive() {
        frontLeftWheel.drive(swerveTranslate.frontLeftMag, swerveTranslate.frontLeftAngle)
        frontRightWheel.drive(swerveTranslate.frontRightMag, swerveTranslate.frontRightAngle)
        backLeftWheel.drive(swerveTranslate.backLeftMag, swerveTranslate.backLeftAngle)
        backRightWheel.drive(swerveTranslate.backRightMag, swerveTranslate.backRightAngle)
    }

    fun speak() {
        System.out.println(test.voltage / 5.0 * 360.0)
    }
}
