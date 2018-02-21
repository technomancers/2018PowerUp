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

    val DIST_SWITCH_SIDE_TO_WALL: Double
    val DIST_SWITCH_FRONT_TO_WALL: Double
    val DIST_SCALE_TO_ROBOT: Double
    val DIST_ROBOT_TO_SWITCH: Double
    val MIDDLE_MOVEMENT: Double

    val AUTO_SPEED: Double
    val AUTO_TOLERANCE: Double
    val TURN_TIME: Double

    val FORWARD_CHANNEL_GRIPPER: Int
    val REVERSE_CHANNEL_GRIPPER: Int
    val FORWARD_CHANNEL_SHOOTER: Int
    val REVERSE_CHANNEL_SHOOTER: Int

    val COMPRESSOR_NODE_ID: Int

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

        ROBOT_LIFT = pref.getInt("robotLift",0)

        ROBOT_LENGTH = pref.getDouble("robotLength", 0.0)
        ROBOT_WIDTH = pref.getDouble("RobotWidth", 0.0)

        ENCODER_TICKS_PER_REVOLUTION = pref.getInt("encoderTicksPerRevolution", 0)

        //Field Dimensions
        DIST_SWITCH_SIDE_TO_WALL = pref.getDouble("distSwitchSideToWall", 0.0)
        DIST_SWITCH_FRONT_TO_WALL = pref.getDouble("distSwitchFrontToWall", 0.0)
        DIST_SCALE_TO_ROBOT = pref.getDouble("distScaleToRobot", 0.0)
        DIST_ROBOT_TO_SWITCH = pref.getDouble("distRobotToSwitch", 0.0)
        MIDDLE_MOVEMENT = pref.getDouble("middleMovement",0.0)

        TURN_TIME = pref.getDouble("turnTime", 0.0)
        AUTO_SPEED = pref.getDouble("autoSpeed" , 0.0)
        AUTO_TOLERANCE = pref.getDouble("autoTolerance" , 0.0)

        FORWARD_CHANNEL_GRIPPER = pref.getInt("forwardChannelGripper", 0)
        REVERSE_CHANNEL_GRIPPER = pref.getInt("reverseChannelGripper", 0)
        FORWARD_CHANNEL_SHOOTER = pref.getInt("forwardChannelShooter", 0)
        REVERSE_CHANNEL_SHOOTER = pref.getInt("reverseChannelShooter", 0)

        COMPRESSOR_NODE_ID = pref.getInt("CompressorNodeID", 0)

        SHOOTING_WAIT_TIME = pref.getInt("shootingWaitTime",0)
    }
}
