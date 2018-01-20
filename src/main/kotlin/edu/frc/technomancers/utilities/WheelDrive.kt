package edu.frc.technomancers.utilities

import com.ctre.phoenix.motorcontrol.ControlMode
import com.ctre.phoenix.motorcontrol.FeedbackDevice
import com.ctre.phoenix.motorcontrol.can.TalonSRX
import kotlin.math.sign

class WheelDrive(speedMotorPort: Int, angleMotorPort: Int)
{
    private val speedMotor = TalonSRX(speedMotorPort)
    private val angleMotor = TalonSRX(angleMotorPort)

    init{2
        angleMotor.configSelectedFeedbackSensor(FeedbackDevice.QuadEncoder, 0, 0)
        angleMotor.setSelectedSensorPosition(0,0,0)
    }

     fun drive(speed: Double, angle: Double) {
        /* val target = 900 * (angle + 1)
         val current = angleMotor.getSelectedSensorPosition(0)
         val actual = current % 1800
         val delta = target - actual
         val next = delta + current
         angleMotor.set(ControlMode.Position, next)*/
         val current = angleMotor.getSelectedSensorPosition(0)
         val numRot = Math.floor(Math.abs(current)/900.0).toInt() * current.sign
         println("NumRotation: $numRot")
         val currentTarget = (900 * (angle + numRot)).toInt()
         val lowTarget = currentTarget - 1800
         val highTarget = currentTarget + 1800
         val lowDistance = Math.abs(current - lowTarget)
         val currentDistance = Math.abs(current - currentTarget)
         val highDistance = Math.abs(current - highTarget)
         val shortestDistance = Math.min(Math.min(lowDistance, currentDistance), highDistance)
         val target = when (shortestDistance) {
             lowDistance -> lowTarget.toDouble()
             currentDistance -> currentTarget.toDouble()
             else -> highTarget.toDouble()
         }
         println("Target: $target")
         angleMotor.set(ControlMode.Position, target)
         speedMotor.set(ControlMode.PercentOutput, speed)

    }
}
