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

    private val FORWARD_CHANNEL: Int
    private val REVERSE_CHANNEL: Int

    private val ULTRASONIC_VOLTAGE : Double
    private val VOLTS_PER_INCH : Double

    private val COMPRESSOR_NODE_ID: Int

    //Ultrasonics
    val FRONT_LEFT_SONIC_INPUT: Int
    val FRONT_LEFT_SONIC_OUTPUT: Int
    val FRONT_RIGHT_SONIC_INPUT: Int
    val FRONT_RIGHT_SONIC_OUTPUT: Int
    val RIGHT_SONIC_INPUT: Int
    val RIGHT_SONIC_OUTPUT: Int
    val BACK_SONIC_INPUT: Int
    val BACK_SONIC_OUTPUT: Int
    val LEFT_SONIC_INPUT: Int
    val LEFT_SONIC_OUTPUT: Int

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

        FORWARD_CHANNEL = pref.getInt("forwardChannel", 0)
        REVERSE_CHANNEL = pref.getInt("reverseChannel", 0)

        FRONT_LEFT_SONIC_INPUT = pref.getInt("frontLeftSonic", 0)
        FRONT_LEFT_SONIC_OUTPUT = pref.getInt("frontRightSonic", 0)
        FRONT_RIGHT_SONIC_INPUT = pref.getInt("frontRightSonic", 0)
        FRONT_RIGHT_SONIC_OUTPUT = pref.getInt("frontRightSonic", 0)
        LEFT_SONIC_INPUT = pref.getInt("leftSonic", 0)
        LEFT_SONIC_OUTPUT = pref.getInt("leftSonic", 0)
        RIGHT_SONIC_INPUT = pref.getInt("rightSonic", 0)
        RIGHT_SONIC_OUTPUT = pref.getInt("rightSonic", 0)
        BACK_SONIC_INPUT = pref.getInt("backSonic", 0)
        BACK_SONIC_OUTPUT = pref.getInt("backSonic", 0)

        COMPRESSOR_NODE_ID = pref.getInt("backSonic", 0)

        ULTRASONIC_VOLTAGE = pref.getDouble("ultrasonicVoltage", 0.0)
        VOLTS_PER_INCH = ULTRASONIC_VOLTAGE / 512
    }
}