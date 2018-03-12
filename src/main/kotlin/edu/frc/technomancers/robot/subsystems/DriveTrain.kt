package edu.frc.technomancers.robot.subsystems

import com.ctre.phoenix.motorcontrol.ControlMode
import com.ctre.phoenix.motorcontrol.can.TalonSRX
import edu.frc.technomancers.robot.RobotMap
import edu.frc.technomancers.robot.commands.DriveWithJoystick
import edu.frc.technomancers.utilities.I2C
import edu.frc.technomancers.utilities.SwerveTranslate
import edu.frc.technomancers.utilities.WheelDrive
import edu.wpi.first.wpilibj.AnalogInput
import edu.wpi.first.wpilibj.command.Subsystem
import org.apache.commons.math3.util.FastMath

class DriveTrain: Subsystem() {
    val frMotor = TalonSRX(RobotMap.FRONT_RIGHT_MOTOR_DIRECTIONAL)
    val flMotor = TalonSRX(RobotMap.FRONT_LEFT_MOTOR_DIRECTIONAL)
    val brMotor = TalonSRX(RobotMap.BACK_RIGHT_MOTOR_DIRECTIONAL)
    val blMotor = TalonSRX(RobotMap.BACK_LEFT_MOTOR_DIRECTIONAL)
    val frAngleMotor = TalonSRX(RobotMap.FRONT_RIGHT_MOTOR_ROTATIONAL)
    val flAngleMotor = TalonSRX(RobotMap.FRONT_LEFT_MOTOR_ROTATIONAL)
    val brAngleMotor = TalonSRX(RobotMap.BACK_RIGHT_MOTOR_ROTATIONAL)
    val blAngleMotor = TalonSRX(RobotMap.BACK_LEFT_MOTOR_ROTATIONAL)
    val frEncoder = AnalogInput(RobotMap.FRONT_RIGHT_ANALOG)
    val flEncoder = AnalogInput(RobotMap.FRONT_LEFT_ANALOG)
    val brEncoder = AnalogInput(RobotMap.BACK_RIGHT_ANALOG)
    val blEncoder = AnalogInput(RobotMap.BACK_LEFT_ANALOG)
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

    fun getFrontRightSonic(): Int {
        return (ultrasonics.read()[0]).toInt()
    }

    fun getFrontLeftSonic(): Int {
        return (ultrasonics.read()[4]).toInt()
    }

    fun getRightSonic(): Int {
        return (ultrasonics.read()[1]).toInt()
    }

    fun getBackSonic(): Int {
        return (ultrasonics.read()[2]).toInt()
    }

    fun getLeftSonic(): Int {
        return (ultrasonics.read()[3]).toInt()
    }

    fun tankDrive(left: Double, right: Double) {
        frMotor.set(ControlMode.PercentOutput, right)
        flMotor.set(ControlMode.PercentOutput, left)
        brMotor.set(ControlMode.PercentOutput, right)
        blMotor.set(ControlMode.PercentOutput, left)
        deepsAlgorithm(0.0, frAngleMotor, frEncoder, RobotMap.FRONT_RIGHT_ZERO)
        deepsAlgorithm(0.0, flAngleMotor, flEncoder, RobotMap.FRONT_LEFT_ZERO)
        deepsAlgorithm(0.0, blAngleMotor, blEncoder, RobotMap.BACK_LEFT_ZERO)
        deepsAlgorithm(0.0, brAngleMotor, brEncoder, RobotMap.BACK_RIGHT_ZERO)
    }

    fun deepsAlgorithm(angle: Double, motor: TalonSRX, encoder: AnalogInput, wheelZero: Int) {
        val current = ((encoder.voltage * RobotMap.ENCODER_TICKS_PER_REVOLUTION / 5.0 - wheelZero)) % RobotMap.ENCODER_TICKS_PER_REVOLUTION
        val convertedAngle = (angle + 1) * RobotMap.ENCODER_TICKS_PER_REVOLUTION / 2.0
        var delta = 0.0
        if (current > convertedAngle) {
            val distToTargetCCW = FastMath.abs(current - convertedAngle)
            val distToTargetCW = FastMath.abs(RobotMap.ENCODER_TICKS_PER_REVOLUTION - distToTargetCCW)
            val minDistance = FastMath.min(distToTargetCCW, distToTargetCW)
            when (minDistance) {
                distToTargetCCW -> {
                    delta -= distToTargetCCW
                }
                distToTargetCW -> {
                    delta += distToTargetCW
                }
            }
        }
        if (current < convertedAngle) {
            val distToTargetCW = FastMath.abs(convertedAngle - current)
            val distToTargetCCW = RobotMap.ENCODER_TICKS_PER_REVOLUTION - distToTargetCW
            val minDistance = FastMath.min(distToTargetCCW, distToTargetCW)
            when (minDistance) {
                distToTargetCW -> {
                    delta += distToTargetCW
                }
                distToTargetCCW -> {
                    delta -= distToTargetCCW
                }
            }
        }
        if (delta < -RobotMap.ENCODER_TICKS_PER_REVOLUTION / 4.0) {
            delta += RobotMap.ENCODER_TICKS_PER_REVOLUTION / 2.0
        } else if (delta > RobotMap.ENCODER_TICKS_PER_REVOLUTION / 4.0) {
            delta -= RobotMap.ENCODER_TICKS_PER_REVOLUTION / 2.0

        }
        motor.set(ControlMode.PercentOutput, delta * 2 / RobotMap.ENCODER_TICKS_PER_REVOLUTION)
    }
}
