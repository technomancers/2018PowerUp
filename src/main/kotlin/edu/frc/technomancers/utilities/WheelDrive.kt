package edu.frc.technomancers.utilities

import com.ctre.phoenix.motorcontrol.ControlMode
import com.ctre.phoenix.motorcontrol.FeedbackDevice
import com.ctre.phoenix.motorcontrol.can.TalonSRX
import edu.frc.technomancers.robot.RobotMap
import org.apache.commons.math3.util.FastMath
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
         val halfEncoder = RobotMap.ENCODER_TICKS_PER_REVOLUTION / 2
         val current = angleMotor.getSelectedSensorPosition(0)
         val numRot = FastMath.floor(FastMath.abs(current)/halfEncoder.toDouble()).toInt() * current.sign
         val currentTarget = (halfEncoder * (angle + numRot)).toInt()
         val lowTarget = currentTarget - RobotMap.ENCODER_TICKS_PER_REVOLUTION
         val highTarget = currentTarget + RobotMap.ENCODER_TICKS_PER_REVOLUTION
         val lowDistance = FastMath.abs(current - lowTarget)
         val currentDistance = FastMath.abs(current - currentTarget)
         val highDistance = FastMath.abs(current - highTarget)
         val shortestDistance = FastMath.min(FastMath.min(lowDistance, currentDistance), highDistance)
         val target = when (shortestDistance) {
             lowDistance -> lowTarget.toDouble()
             currentDistance -> currentTarget.toDouble()
             else -> highTarget.toDouble()
         }
         angleMotor.set(ControlMode.Position, target)
         speedMotor.set(ControlMode.PercentOutput, speed)

    }
}
