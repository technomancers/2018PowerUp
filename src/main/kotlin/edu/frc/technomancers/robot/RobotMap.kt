package edu.frc.technomancers.robot

import edu.wpi.first.networktables.NetworkTableInstance

object RobotMap {
    val ntTable = NetworkTableInstance.getDefault()
    val table = ntTable.getTable("Configuration")

    private val frontLeftDir = table.getEntry("frontLeftDir")
    private val frontRightDir = table.getEntry("frontRightDir")
    private val backLeftDir = table.getEntry("backLeftDir")
    private val backRightDir = table.getEntry("backRightDir")
    private val frontLeftRot = table.getEntry("frontLeftRot")
    private val frontRightRot = table.getEntry("frontRightRot")
    private val backLeftRot = table.getEntry("backLeftRot")
    private val backRightRot = table.getEntry("backRightRot")
    private val robotWidth = table.getEntry("robotWidth")
    private val robotLength = table.getEntry("robotLength")

    val LFMOTOR_DIRECTIONAL : Int
    val RFMOTOR_DIRECTIONAL : Int
    val LBMOTOR_DIRECTIONAL : Int
    val RBMOTOR_DIRECTIONAL : Int
    val LFMOTOR_ROTATIONAL : Int
    val RFMOTOR_ROTATIONAL : Int
    val LBMOTOR_ROTATIONAL : Int
    val RBMOTOR_ROTATIONAL : Int
    val ROBOT_WIDTH: Double
    val ROBOT_LENGTH: Double

    init {
        initialize()
        LFMOTOR_DIRECTIONAL = frontLeftDir.getNumber(0) as Int
        RFMOTOR_DIRECTIONAL = frontRightDir.getNumber(0) as Int
        LBMOTOR_DIRECTIONAL = backLeftDir.getNumber(0) as Int
        RBMOTOR_DIRECTIONAL = backRightDir.getNumber(0) as Int
        LFMOTOR_ROTATIONAL = frontLeftRot.getNumber(0) as Int
        RFMOTOR_ROTATIONAL = frontRightRot.getNumber(0) as Int
        LBMOTOR_ROTATIONAL = backLeftRot.getNumber(0) as Int
        RBMOTOR_ROTATIONAL = backRightRot.getNumber(0) as Int
        ROBOT_LENGTH = robotLength.getNumber(0.0) as Double
        ROBOT_WIDTH = robotWidth.getNumber(0.0) as Double
    }

    private fun initialize()
    {
        if (!frontLeftDir.exists()){
            frontLeftDir.setNumber(0)
            frontLeftDir.setPersistent()
        }

        if (!frontRightDir.exists()){
            frontRightDir.setNumber(0)
            frontLeftDir.setPersistent()
        }

        if (!backLeftDir.exists()){
            backLeftDir.setNumber(0)
            backLeftDir.setPersistent()
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
            frontLeftRot.setPersistent()
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
            robotLength.setNumber(0)
            robotLength.setPersistent()
        }

        if (!robotWidth.exists()){
            robotWidth.setNumber(0)
            robotWidth.setPersistent()
        }

    }
}
