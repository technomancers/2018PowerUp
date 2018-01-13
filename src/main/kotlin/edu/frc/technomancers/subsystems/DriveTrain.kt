package edu.frc.technomancers.subsystems

import com.ctre.phoenix.motorcontrol.can.TalonSRX
import edu.frc.technomancers.robot.RobotMap
import edu.frc.technomancers.robot.utilities.SwerveTranslate
import edu.frc.technomancers.utilities.WheelDrive
import edu.wpi.first.wpilibj.command.Subsystem

class DriveTrain: Subsystem()
{
    val rfMotorDir = TalonSRX(RobotMap.RFMOTOR_DIRECTIONAL)
    val rbMotorDir = TalonSRX(RobotMap.RBMOTOR_DIRECTIONAL)
    val lfMotorDir = TalonSRX(RobotMap.LFMOTOR_DIRECTIONAL)
    val lbMotorDir = TalonSRX(RobotMap.LBMOTOR_DIRECTIONAL)
    val rfMotorRot = TalonSRX(RobotMap.RFMOTOR_ROTATIONAL)
    val rbMotorRot = TalonSRX(RobotMap.RBMOTOR_ROTATIONAL)
    val lfMotorRot = TalonSRX(RobotMap.LFMOTOR_ROTATIONAL)
    val lbMotorRot = TalonSRX(RobotMap.LBMOTOR_ROTATIONAL)
    val frontLeftWheel = WheelDrive(lfMotorDir, lfMotorRot)
    val frontRightWheel = WheelDrive(rfMotorDir, rfMotorRot)
    val backLeftWheel = WheelDrive(lbMotorDir, lbMotorRot)
    val backRightWheel = WheelDrive(rbMotorDir,rbMotorRot)
    val swerveTranslate = SwerveTranslate(RobotMap.ROBOT_LENGTH, RobotMap.ROBOT_WIDTH)
    init {
        configEncoders()
    }

    override fun initDefaultCommand() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    public fun configEncoders() {
        rfMotorRot.configSelectedFeedbackSensor(com.ctre.phoenix.motorcontrol.FeedbackDevice.Analog, 1, 0)
        lfMotorRot.configSelectedFeedbackSensor(com.ctre.phoenix.motorcontrol.FeedbackDevice.Analog, 1, 0)
        lbMotorRot.configSelectedFeedbackSensor(com.ctre.phoenix.motorcontrol.FeedbackDevice.Analog, 1, 0)
        rbMotorRot.configSelectedFeedbackSensor(com.ctre.phoenix.motorcontrol.FeedbackDevice.Analog, 1, 0)
    }
    public fun SwerveDrive() {
        frontLeftWheel.drive(swerveTranslate.frontLeftMag, swerveTranslate.frontLeftAngle)
        frontRightWheel.drive(swerveTranslate.frontRightMag, swerveTranslate.frontRightAngle)
        backLeftWheel.drive(swerveTranslate.backLeftMag, swerveTranslate.backLeftAngle)
        backRightWheel.drive(swerveTranslate.backRightMag, swerveTranslate.backRightAngle)
    }


}
