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

    val LFMOTOR_DIRECTIONAL : Number
    val RFMOTOR_DIRECTIONAL : Number
    val LBMOTOR_DIRECTIONAL : Number
    val RBMOTOR_DIRECTIONAL : Number
    val LFMOTOR_ROTATIONAL : Number
    val RFMOTOR_ROTATIONAL : Number
    val LBMOTOR_ROTATIONAL : Number
    val RBMOTOR_ROTATIONAL : Number
    val ROBOT_WIDTH: Number
    val ROBOT_LENGTH: Number

    init {
        initialize()
        LFMOTOR_DIRECTIONAL = frontLeftDir.getNumber(0)
        RFMOTOR_DIRECTIONAL = frontRightDir.getNumber(0)
        LBMOTOR_DIRECTIONAL = backLeftDir.getNumber(0)
        RBMOTOR_DIRECTIONAL = backRightDir.getNumber(0)
        LFMOTOR_ROTATIONAL = frontLeftRot.getNumber(0)
        RFMOTOR_ROTATIONAL = frontRightRot.getNumber(0)
        LBMOTOR_ROTATIONAL = backLeftRot.getNumber(0)
        RBMOTOR_ROTATIONAL = backRightRot.getNumber(0)
        ROBOT_LENGTH = robotLength.getNumber(0)
        ROBOT_WIDTH = robotWidth.getNumber(0)
    }

    public fun initialize()
    {
        if (!frontLeftDir.exists()){
            frontLeftDir.setNumber(0)
            frontLeftDir.setPersistent()
        }

        if(!frontRightDir.exists()){
            frontRightDir.setNumber(0)
            frontLeftDir.setPersistent()
        }

        if (!backLeftDir.exists()){
            backLeftDir.setNumber(0)
            backLeftDir.setPersistent()
        }

        if(!backRightRot.exists()){
            backRightRot.setNumber(0)
            backRightRot.setPersistent()
        }

        if (!frontLeftRot.exists()){
            frontLeftRot.setNumber(0)
            frontLeftRot.setPersistent()
        }

        if(!frontRightRot.exists()){
            frontRightRot.setNumber(0)
            frontLeftRot.setPersistent()
        }

        if (!backLeftRot.exists()){
            backLeftRot.setNumber(0)
            backLeftRot.setPersistent()
        }

        if(!backRightRot.exists()){
            backRightRot.setNumber(0)
            backRightRot.setPersistent()
        }

        if(!robotLength.exists()){
            robotLength.setNumber(0)
            robotLength.setPersistent()
        }

        if(!robotWidth.exists()){
            robotWidth.setNumber(0)
            robotWidth.setPersistent()
        }

    }
}