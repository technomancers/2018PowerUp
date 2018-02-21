package edu.frc.technomancers.robot.subsystems

import com.ctre.phoenix.motorcontrol.ControlMode
import com.ctre.phoenix.motorcontrol.can.TalonSRX
import edu.frc.technomancers.robot.RobotMap
import edu.frc.technomancers.robot.commands.DriveWithJoystick
import edu.frc.technomancers.utilities.I2C
import edu.frc.technomancers.utilities.SwerveTranslate
import edu.frc.technomancers.utilities.WheelDrive
import edu.wpi.first.wpilibj.command.Subsystem
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard

class DriveTrain: Subsystem()
{
    val frMotor = TalonSRX(RobotMap.FRONT_RIGHT_MOTOR_DIRECTIONAL)
    val flMotor = TalonSRX(RobotMap.FRONT_LEFT_MOTOR_DIRECTIONAL)
    val brMotor = TalonSRX(RobotMap.BACK_RIGHT_MOTOR_DIRECTIONAL)
    val blMotor = TalonSRX(RobotMap.BACK_LEFT_MOTOR_DIRECTIONAL)
    val ultrasonics = I2C()

    private val frontLeftWheel = WheelDrive(RobotMap.FRONT_LEFT_MOTOR_DIRECTIONAL,
            RobotMap.FRONT_LEFT_MOTOR_ROTATIONAL)
    private val frontRightWheel = WheelDrive(RobotMap.FRONT_RIGHT_MOTOR_DIRECTIONAL,
            RobotMap.FRONT_RIGHT_MOTOR_ROTATIONAL)
    private val backLeftWheel = WheelDrive(RobotMap.BACK_LEFT_MOTOR_DIRECTIONAL,
            RobotMap.BACK_LEFT_MOTOR_ROTATIONAL)
    private val backRightWheel = WheelDrive(RobotMap.BACK_RIGHT_MOTOR_DIRECTIONAL,
            RobotMap.BACK_RIGHT_MOTOR_ROTATIONAL)
    val swerveTranslate = SwerveTranslate(RobotMap.ROBOT_LENGTH, RobotMap.ROBOT_WIDTH)
    override fun initDefaultCommand() {
        defaultCommand = DriveWithJoystick()
    }

    init {
        frMotor.inverted = true
        brMotor.inverted = true
        flMotor.inverted = true
        blMotor.inverted = true
    }

    fun swerveDrive() {
        frontLeftWheel.drive(swerveTranslate.frontLeftMag, swerveTranslate.frontLeftAngle)
        frontRightWheel.drive(swerveTranslate.frontRightMag, swerveTranslate.frontRightAngle)
        backLeftWheel.drive(swerveTranslate.backLeftMag, swerveTranslate.backLeftAngle)
        backRightWheel.drive(swerveTranslate.backRightMag, swerveTranslate.backRightAngle)
    }

    fun getFrontRightSonic(): Int{
        return (ultrasonics.read()[0]).toInt()
    }

    fun getFrontLeftSonic(): Int{
        return (ultrasonics.read()[4]).toInt()
    }

    fun getRightSonic(): Int{
        return (ultrasonics.read()[1]).toInt()
    }

    fun getBackSonic(): Int{
        return (ultrasonics.read()[2]).toInt()
    }

    fun getLeftSonic(): Int{
        return (ultrasonics.read()[3]).toInt()
    }

    fun tankDrive(left: Double, right: Double){
        frMotor.set(ControlMode.PercentOutput, 1.25 * right)
        flMotor.set(ControlMode.PercentOutput, left)
        brMotor.set(ControlMode.PercentOutput, 1.25 * right)
        blMotor.set(ControlMode.PercentOutput, left)
        SmartDashboard.putNumber("FR", getFrontRightSonic().toDouble())
        SmartDashboard.putNumber("FL", getFrontLeftSonic().toDouble())
        SmartDashboard.putNumber("B", getBackSonic().toDouble())
        SmartDashboard.putNumber("L", getLeftSonic().toDouble())
        SmartDashboard.putNumber("R", getRightSonic().toDouble())
    }
}
