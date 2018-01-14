package edu.frc.technomancers.robot

import edu.wpi.first.networktables.NetworkTableInstance

object RobotMap {
    private val ntTable = NetworkTableInstance.getDefault()
    private val table = ntTable.getTable("Configuration")

    private val frontLeftDir = table.getEntry("frontLeftDir")
    private val frontLeftRot = table.getEntry("frontLeftRot")

    private val frontRightDir = table.getEntry("frontRightDir")
    private val frontRightRot = table.getEntry("frontRightRot")

    private val backLeftDir = table.getEntry("backLeftDir")
    private val backLeftRot = table.getEntry("backLeftRot")

    private val backRightDir = table.getEntry("backRightDir")
    private val backRightRot = table.getEntry("backRightRot")

    private val robotWidth = table.getEntry("robotWidth")
    private val robotLength = table.getEntry("robotLength")

    val FRONT_LEFT_MOTOR_DIRECTIONAL : Int
    val FRONT_LEFT_MOTOR_ROTATIONAL : Int

    val FRONT_RIGHT_MOTOR_DIRECTIONAL : Int
    val FRONT_RIGHT_MOTOR_ROTATIONAL : Int

    val BACK_LEFT_MOTOR_DIRECTIONAL : Int
    val BACK_LEFT_MOTOR_ROTATIONAL : Int

    val BACK_RIGHT_MOTOR_DIRECTIONAL : Int
    val BACK_RIGHT_MOTOR_ROTATIONAL : Int

    val ROBOT_WIDTH: Double
    val ROBOT_LENGTH: Double

    init {
        initialize()
        FRONT_LEFT_MOTOR_DIRECTIONAL = frontLeftDir.getNumber(0).toInt()
        FRONT_LEFT_MOTOR_ROTATIONAL = frontLeftRot.getNumber(0).toInt()

        FRONT_RIGHT_MOTOR_DIRECTIONAL = frontRightDir.getNumber(0).toInt()
        FRONT_RIGHT_MOTOR_ROTATIONAL = frontRightRot.getNumber(0).toInt()

        BACK_LEFT_MOTOR_DIRECTIONAL = backLeftDir.getNumber(0).toInt()
        BACK_LEFT_MOTOR_ROTATIONAL = backLeftRot.getNumber(0).toInt()

        BACK_RIGHT_MOTOR_DIRECTIONAL = backRightDir.getNumber(0).toInt()
        BACK_RIGHT_MOTOR_ROTATIONAL = backRightRot.getNumber(0).toInt()

        ROBOT_LENGTH = robotLength.getNumber(0.0).toDouble()
        ROBOT_WIDTH = robotWidth.getNumber(0.0).toDouble()
    }

    private fun initialize()
    {
        if (!frontLeftDir.exists()){
            frontLeftDir.setNumber(0)
            frontLeftDir.setPersistent()
        }

        if (!frontRightDir.exists()){
            frontRightDir.setNumber(0)
            frontRightDir.setPersistent()
        }

        if (!backLeftDir.exists()){
            backLeftDir.setNumber(0)
            backLeftDir.setPersistent()
        }

        if(!backRightDir.exists()) {
            backRightDir.setNumber(0)
            backRightDir.setPersistent()
        }

        if (!backRightRot.exists()){
            backRightRot.setNumber(0)
            backRightRot.setPersistent()
        }

        if (!frontLeftRot.exists()){
            frontLeftRot.setNumber(0)
            frontLeftRot.setPersistent()
        }

        if (!frontRightRot.exists()){
            frontRightRot.setNumber(0)
            frontRightRot.setPersistent()
        }

        if (!backLeftRot.exists()){
            backLeftRot.setNumber(0)
            backLeftRot.setPersistent()
        }

        if (!backRightRot.exists()){
            backRightRot.setNumber(0)
            backRightRot.setPersistent()
        }

        if (!robotLength.exists()){
            robotLength.setNumber(0.0)
            robotLength.setPersistent()
        }

        if (!robotWidth.exists()){
            robotWidth.setNumber(0.0)
            robotWidth.setPersistent()
        }

    }
}
