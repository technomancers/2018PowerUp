package edu.frc.technomancers.robot.subsystems

import com.ctre.phoenix.motorcontrol.ControlMode
import com.ctre.phoenix.motorcontrol.FeedbackDevice
import com.ctre.phoenix.motorcontrol.can.TalonSRX
import edu.frc.technomancers.robot.Robot
import edu.frc.technomancers.robot.RobotMap
import edu.frc.technomancers.robot.commands.DriveWithJoystick
import edu.frc.technomancers.utilities.SwerveTranslate
import edu.frc.technomancers.utilities.WheelDrive
import edu.wpi.first.wpilibj.AnalogInput
import edu.wpi.first.wpilibj.Encoder
import edu.wpi.first.wpilibj.command.Subsystem
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard


class DriveTrain: Subsystem() {
    val flMotor = TalonSRX(RobotMap.FRONT_LEFT_MOTOR_ROTATIONAL)
    val frMotor = TalonSRX(RobotMap.FRONT_RIGHT_MOTOR_ROTATIONAL)
    val blMotor = TalonSRX(RobotMap.BACK_LEFT_MOTOR_ROTATIONAL)
    val brMotor = TalonSRX(RobotMap.BACK_RIGHT_MOTOR_ROTATIONAL)
    var counter = 0.0
    private val frontLeftWheel = WheelDrive(RobotMap.FRONT_LEFT_MOTOR_DIRECTIONAL, RobotMap.FRONT_LEFT_MOTOR_ROTATIONAL, RobotMap.FRONT_LEFT_ZERO)
    private val frontRightWheel = WheelDrive(RobotMap.FRONT_RIGHT_MOTOR_DIRECTIONAL, RobotMap.FRONT_RIGHT_MOTOR_ROTATIONAL, RobotMap.FRONT_RIGHT_ZERO)
    private val backLeftWheel = WheelDrive(RobotMap.BACK_LEFT_MOTOR_DIRECTIONAL, RobotMap.BACK_LEFT_MOTOR_ROTATIONAL, RobotMap.BACK_LEFT_ZERO)
    private val backRightWheel = WheelDrive(RobotMap.BACK_RIGHT_MOTOR_DIRECTIONAL, RobotMap.BACK_RIGHT_MOTOR_ROTATIONAL, RobotMap.BACK_RIGHT_ZERO)
    val swerveTranslate = SwerveTranslate(RobotMap.ROBOT_LENGTH, RobotMap.ROBOT_WIDTH)
    init {
    }

    override fun initDefaultCommand() {
        defaultCommand = DriveWithJoystick()
    }


    fun swerveDrive() {
        frontLeftWheel.drive(swerveTranslate.frontLeftMag, swerveTranslate.frontLeftAngle, "Front Left")
        frontRightWheel.drive(swerveTranslate.frontRightMag, swerveTranslate.frontRightAngle, "Front Right")
        backLeftWheel.drive(swerveTranslate.backLeftMag, swerveTranslate.backLeftAngle, "Back Left")
        backRightWheel.drive(swerveTranslate.backRightMag, swerveTranslate.backRightAngle, "Back Right")
    }

    fun turnFrontLeft(){
        counter += 100.0
        flMotor.set(ControlMode.Position, counter)
        frMotor.set(ControlMode.Position, counter)
        blMotor.set(ControlMode.Position, counter)
        brMotor.set(ControlMode.Position, counter)
    }


}
