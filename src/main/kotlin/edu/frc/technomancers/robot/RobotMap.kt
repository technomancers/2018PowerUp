package edu.frc.technomancers.robot

import edu.wpi.first.networktables.NetworkTableInstance

object RobotMap {
    val ntTable = NetworkTableInstance.getDefault()
    val table = ntTable.getTable("Configuration")

    private val frontLeftMag = table.getEntry("frontLeftMag")
    val FRONT_LEFT_MAG : Number

    init {
        frontLeftMag.setPersistent()

        if (!frontLeftMag.exists()){
            frontLeftMag.setNumber(0)
        }

        FRONT_LEFT_MAG = frontLeftMag.getNumber(0)
    }
}