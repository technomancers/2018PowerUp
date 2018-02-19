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

    val FORWARD_CHANNEL_GRIPPER: Int
    val REVERSE_CHANNEL_GRIPPER: Int
    val FORWARD_CHANNEL_SHOOTER: Int
    val REVERSE_CHANNEL_SHOOTER: Int


    val ULTRASONIC_VOLTAGE : Double
    val VOLTS_PER_INCH : Double

    val COMPRESSOR_NODE_ID: Int

    //Ultrasonics
    val FRONT_LEFT_SONIC: Int
    val FRONT_RIGHT_SONIC: Int
    val RIGHT_SONIC: Int
    val BACK_SONIC: Int
    val LEFT_SONIC: Int

    val SHOOTING_WAIT_TIME: Int

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

        FORWARD_CHANNEL_GRIPPER = pref.getInt("forwardChannelGripper", 0)
        REVERSE_CHANNEL_GRIPPER = pref.getInt("reverseChannelGripper", 0)
        FORWARD_CHANNEL_SHOOTER = pref.getInt("forwardChannelShooter", 0)
        REVERSE_CHANNEL_SHOOTER = pref.getInt("reverseChannelShooter", 0)

        FRONT_LEFT_SONIC = pref.getInt("frontLeftSonic", 0)
        FRONT_RIGHT_SONIC = pref.getInt("frontRightSonic", 0)
        LEFT_SONIC = pref.getInt("leftSonic", 0)
        RIGHT_SONIC = pref.getInt("rightSonic", 0)
        BACK_SONIC = pref.getInt("backSonic", 0)

        ULTRASONIC_VOLTAGE = pref.getDouble("ultrasonicVoltage", 0.0)
        VOLTS_PER_INCH = ULTRASONIC_VOLTAGE / 512

        COMPRESSOR_NODE_ID = pref.getInt("CompressorNodeID", 0)

        SHOOTING_WAIT_TIME = pref.getInt("shootingWaitTime",0)
    }
}