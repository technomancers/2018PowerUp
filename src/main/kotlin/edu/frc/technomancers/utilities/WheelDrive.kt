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
        angleMotor.setSelectedSensorPosition(RobotMap.ENCODER_TICKS_PER_REVOLUTION/2,0,0)
    }

    fun drive(speed: Double, angle: Double) {
        val current = angleMotor.getSelectedSensorPosition(0)
        val midRelative = (FastMath.abs(current) % RobotMap.ENCODER_TICKS_PER_REVOLUTION) * current.sign
        val lowRelative = midRelative - RobotMap.ENCODER_TICKS_PER_REVOLUTION
        val highRelative = midRelative + RobotMap.ENCODER_TICKS_PER_REVOLUTION
        val target = (RobotMap.ENCODER_TICKS_PER_REVOLUTION/2) * angle
        val lowDelta = target - lowRelative
        val midDelta = target - midRelative
        val highDelta = target - highRelative
        val delta = displacementMin(doubleArrayOf(lowDelta, midDelta, highDelta))
        val next = delta + current
        angleMotor.set(ControlMode.Position, next)
        speedMotor.set(ControlMode.PercentOutput, speed)
    }

    private fun displacementMin(deltas : DoubleArray):Double{
        var min : Double? = null
        for (delta in deltas){
            if (min == null){
                min = delta
            }else {
                if (FastMath.abs(delta) < FastMath.abs(min)){
                    min = delta
                }
            }
        }

        return if (min == null) 0.0 else min
    }
}
