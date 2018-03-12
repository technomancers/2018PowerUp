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

    val ROBOT_LIFT: Int

    val ROBOT_WIDTH: Double
    val ROBOT_LENGTH: Double

    val ENCODER_TICKS_PER_REVOLUTION: Int

    val AUTO_SPEED: Double
    val TIME_TILL_SWITCH: Double
    val TIME_CUBE_TO_TOP: Double

    val FORWARD_CHANNEL_GRIPPER: Int
    val REVERSE_CHANNEL_GRIPPER: Int
    val FORWARD_CHANNEL_SHOOTER: Int
    val REVERSE_CHANNEL_SHOOTER: Int

    val COMPRESSOR_NODE_ID: Int

    val SHOOTING_WAIT_TIME: Int

    val SWERVE_TOLERANCE: Double

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

        ROBOT_LIFT = pref.getInt("robotLift",0)

        ROBOT_LENGTH = pref.getDouble("robotLength", 0.0)
        ROBOT_WIDTH = pref.getDouble("RobotWidth", 0.0)

        ENCODER_TICKS_PER_REVOLUTION = pref.getInt("encoderTicksPerRevolution", 0)

        AUTO_SPEED = pref.getDouble("autoSpeed" , 0.0)
        TIME_TILL_SWITCH = pref.getDouble("timeTillSwitch", 0.0)
        TIME_CUBE_TO_TOP = pref.getDouble("timeCubeToTop", 0.0)

        FORWARD_CHANNEL_GRIPPER = pref.getInt("forwardChannelGripper", 0)
        REVERSE_CHANNEL_GRIPPER = pref.getInt("reverseChannelGripper", 0)
        FORWARD_CHANNEL_SHOOTER = pref.getInt("forwardChannelShooter", 0)
        REVERSE_CHANNEL_SHOOTER = pref.getInt("reverseChannelShooter", 0)

        COMPRESSOR_NODE_ID = pref.getInt("CompressorNodeID", 0)

        SHOOTING_WAIT_TIME = pref.getInt("shootingWaitTime",0)

        FRONT_RIGHT_ANALOG = pref.getInt("frontRightAnalog", 1)
        FRONT_LEFT_ANALOG = pref.getInt("frontLeftAnalog", 0)
        BACK_RIGHT_ANALOG = pref.getInt("backRightAnalog", 3)
        BACK_LEFT_ANALOG = pref.getInt("backLeftAnalog", 2)

        BACK_LEFT_ZERO = pref.getInt("backLeftZero", 0)
        BACK_RIGHT_ZERO = pref.getInt("backRightZero", 0)
        FRONT_LEFT_ZERO = pref.getInt("frontLeftZero", 0)
        FRONT_RIGHT_ZERO = pref.getInt("frontRightZero", 0)

        SWERVE_TOLERANCE = pref.getDouble("swerveTolerance", 0.0)
    }
}
