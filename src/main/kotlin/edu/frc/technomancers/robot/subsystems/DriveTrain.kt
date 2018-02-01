package edu.frc.technomancers.robot.subsystems

import edu.frc.technomancers.robot.RobotMap
import edu.frc.technomancers.robot.commands.DriveWithJoystick
import edu.frc.technomancers.utilities.SwerveTranslate
import edu.frc.technomancers.utilities.WheelDrive
import edu.wpi.first.wpilibj.ADXRS450_Gyro
import edu.wpi.first.wpilibj.AnalogInput
import edu.wpi.first.wpilibj.Ultrasonic
import edu.wpi.first.wpilibj.command.Subsystem

class DriveTrain: Subsystem()
{
    private var frontLeftSonic = AnalogInput(RobotMap.FRONT_LEFT_SONIC)
    private var frontRightSonic = AnalogInput(RobotMap.FRONT_RIGHT_SONIC)
    private var leftSonic = AnalogInput(RobotMap.LEFT_SONIC)
    private var rightSonic = AnalogInput(RobotMap.RIGHT_SONIC)
    private var backSonic = AnalogInput(RobotMap.BACK_SONIC)
    private var gyro = ADXRS450_Gyro()


    private val frontLeftWheel = WheelDrive(RobotMap.FRONT_LEFT_MOTOR_DIRECTIONAL, RobotMap.FRONT_LEFT_MOTOR_ROTATIONAL)
    private val frontRightWheel = WheelDrive(RobotMap.FRONT_RIGHT_MOTOR_DIRECTIONAL, RobotMap.FRONT_RIGHT_MOTOR_ROTATIONAL)
    private val backLeftWheel = WheelDrive(RobotMap.BACK_LEFT_MOTOR_DIRECTIONAL, RobotMap.BACK_LEFT_MOTOR_ROTATIONAL)
    private val backRightWheel = WheelDrive(RobotMap.BACK_RIGHT_MOTOR_DIRECTIONAL,RobotMap.BACK_RIGHT_MOTOR_ROTATIONAL)
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

    fun getFrontRightSonic(): Double{
        return frontRightSonic.voltage
    }

    fun getFrontLeftSonic(): Double{
        return frontLeftSonic.voltage
    }

    fun getRightSonic(): Double{
        return rightSonic.voltage
    }

    fun getLeftSonic(): Double{
        return leftSonic.voltage
    }

    fun getBackSonic(): Double{
        return backSonic.voltage
    }

    fun resetGyroAngle(){
        gyro.reset()
    }

    fun getGyroValue(): Double{
        return gyro.angle
    }
}
