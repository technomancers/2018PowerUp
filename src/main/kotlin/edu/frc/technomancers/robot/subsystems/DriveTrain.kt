package edu.frc.technomancers.robot.subsystems

import edu.frc.technomancers.robot.RobotMap
import edu.frc.technomancers.robot.commands.DriveWithJoystick
import edu.frc.technomancers.utilities.SwerveTranslate
import edu.frc.technomancers.utilities.WheelDrive
import edu.wpi.first.wpilibj.ADXRS450_Gyro
import edu.wpi.first.wpilibj.AnalogInput
import edu.wpi.first.wpilibj.Ultrasonic
import edu.wpi.first.wpilibj.command.Command
import edu.wpi.first.wpilibj.command.Subsystem
import org.apache.commons.math3.util.FastMath
import kotlin.math.exp

class DriveTrain: Subsystem()
{
    private var frontLeftSonic = Ultrasonic(RobotMap.FRONT_LEFT_SONIC_OUTPUT, RobotMap.FRONT_LEFT_SONIC_INPUT)
    private var frontRightSonic = Ultrasonic(RobotMap.FRONT_RIGHT_SONIC_OUTPUT, RobotMap.FRONT_RIGHT_SONIC_INPUT)
    private var leftSonic =  Ultrasonic(RobotMap.LEFT_SONIC_OUTPUT, RobotMap.LEFT_SONIC_INPUT)
    private var rightSonic =  Ultrasonic(RobotMap.RIGHT_SONIC_OUTPUT, RobotMap.RIGHT_SONIC_INPUT)
    private var backSonic =  Ultrasonic(RobotMap.BACK_SONIC_OUTPUT, RobotMap.BACK_SONIC_INPUT)
    private var gyro = ADXRS450_Gyro()

    private val frontLeftWheel = WheelDrive(RobotMap.FRONT_LEFT_MOTOR_DIRECTIONAL, RobotMap.FRONT_LEFT_MOTOR_ROTATIONAL)
    private val frontRightWheel = WheelDrive(RobotMap.FRONT_RIGHT_MOTOR_DIRECTIONAL, RobotMap.FRONT_RIGHT_MOTOR_ROTATIONAL)
    private val backLeftWheel = WheelDrive(RobotMap.BACK_LEFT_MOTOR_DIRECTIONAL, RobotMap.BACK_LEFT_MOTOR_ROTATIONAL)
    private val backRightWheel = WheelDrive(RobotMap.BACK_RIGHT_MOTOR_DIRECTIONAL,RobotMap.BACK_RIGHT_MOTOR_ROTATIONAL)
    val swerveTranslate = SwerveTranslate(RobotMap.ROBOT_LENGTH, RobotMap.ROBOT_WIDTH)

    override fun initDefaultCommand() {
        defaultCommand = DriveWithJoystick()
    }

    init {
        frontLeftSonic.setAutomaticMode(true)
        frontRightSonic.setAutomaticMode(true)
        leftSonic.setAutomaticMode(true)
        rightSonic.setAutomaticMode(true)
        backSonic.setAutomaticMode(true)
    }

    fun swerveDrive() {
        frontLeftWheel.drive(swerveTranslate.frontLeftMag, swerveTranslate.frontLeftAngle)
        frontRightWheel.drive(swerveTranslate.frontRightMag, swerveTranslate.frontRightAngle)
        backLeftWheel.drive(swerveTranslate.backLeftMag, swerveTranslate.backLeftAngle)
        backRightWheel.drive(swerveTranslate.backRightMag, swerveTranslate.backRightAngle)
    }

    fun getFrontRightSonic(): Double{
        return frontRightSonic.rangeInches
    }

    fun getFrontLeftSonic(): Double{
        return frontLeftSonic.rangeInches
    }

    fun getRightSonic(): Double{
        return rightSonic.rangeInches
    }

    fun getLeftSonic(): Double{
        return leftSonic.rangeInches
    }

    fun getBackSonic(): Double{
        return backSonic.rangeInches
    }

    fun resetGyroAngle(){
        gyro.reset()
    }

    fun getGyroValue(): Double{
        return gyro.angle
    }

}
