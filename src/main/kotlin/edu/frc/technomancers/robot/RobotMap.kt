package edu.frc.technomancers.robot

import edu.wpi.first.wpilibj.Preferences

object RobotMap {
    private val pref = Preferences.getInstance()
    val FRONT_LEFT_MOTOR_DIRECTIONAL: Int
    val FRONT_LEFT_MOTOR_ROTATIONAL: Int

    val FRONT_RIGHT_MOTOR_DIRECTIONAL: Int
    val FRONT_RIGHT_MOTOR_ROTATIONAL: Int

    val BACK_LEFT_MOTOR_DIRECTIONAL: Int
    val BACK_LEFT_MOTOR_ROTATIONAL: Int

    val BACK_RIGHT_MOTOR_DIRECTIONAL: Int
    val BACK_RIGHT_MOTOR_ROTATIONAL: Int

    val ROBOT_WIDTH: Double
    val ROBOT_LENGTH: Double

    val ENCODER_TICKS_PER_REVOLUTION: Int

    val FRONT_RIGHT_ANALOG: Int
    val FRONT_LEFT_ANALOG: Int
    val BACK_RIGHT_ANALOG: Int
    val BACK_LEFT_ANALOG: Int

    val FRONT_RIGHT_ZERO: Int
    val FRONT_LEFT_ZERO: Int
    val BACK_RIGHT_ZERO: Int
    val BACK_LEFT_ZERO: Int

    init {
        FRONT_LEFT_MOTOR_DIRECTIONAL = pref.getInt("frontLeftDir", 0)
        FRONT_LEFT_MOTOR_ROTATIONAL = pref.getInt("frontLeftRot", 0)

        FRONT_RIGHT_MOTOR_DIRECTIONAL = pref.getInt("frontRightDir", 0)
        FRONT_RIGHT_MOTOR_ROTATIONAL = pref.getInt("frontRightRot", 0)

        BACK_LEFT_MOTOR_DIRECTIONAL = pref.getInt("backLeftDir", 0)
        BACK_LEFT_MOTOR_ROTATIONAL = pref.getInt("backLeftRot", 0)

        BACK_RIGHT_MOTOR_DIRECTIONAL = pref.getInt("backRightDir", 0)
        BACK_RIGHT_MOTOR_ROTATIONAL = pref.getInt("backRightRot", 0)

        ROBOT_LENGTH = pref.getDouble("robotLength", 0.0)
        ROBOT_WIDTH = pref.getDouble("RobotWidth", 0.0)

        ENCODER_TICKS_PER_REVOLUTION = pref.getInt("encoderTicksPerRevolution", 0)
        FRONT_RIGHT_ANALOG = pref.getInt("frontRightAnalog", 0)
        FRONT_LEFT_ANALOG = pref.getInt("frontLeftAnalog", 0)
        BACK_RIGHT_ANALOG = pref.getInt("backRightAnalog", 0)
        BACK_LEFT_ANALOG = pref.getInt("backLeftAnalog", 0)

        BACK_LEFT_ZERO = pref.getInt("backLeftZero", 0)
        BACK_RIGHT_ZERO = pref.getInt("backRightZero", 0)
        FRONT_LEFT_ZERO = pref.getInt("frontLeftZero", 0)
        FRONT_RIGHT_ZERO = pref.getInt("frontRightZero", 0)
    }
}
