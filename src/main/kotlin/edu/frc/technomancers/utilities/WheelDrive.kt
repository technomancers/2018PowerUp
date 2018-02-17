package edu.frc.technomancers.utilities

import com.ctre.phoenix.motorcontrol.ControlMode
import com.ctre.phoenix.motorcontrol.FeedbackDevice
import com.ctre.phoenix.motorcontrol.can.TalonSRX
import edu.frc.technomancers.robot.RobotMap
import edu.wpi.first.wpilibj.AnalogInput
import edu.wpi.first.wpilibj.PIDController
import org.apache.commons.math3.util.FastMath
import kotlin.math.sign

class WheelDrive(speedMotorPort: Int, angleMotorPort: Int)
{
    private val speedMotor = TalonSRX(speedMotorPort)
    private val angleMotor = TalonSRX(angleMotorPort)

    init{
        val configSelectedFeedbackSensor = angleMotor.configSelectedFeedbackSensor(FeedbackDevice.Analog, 0, 0)
        angleMotor.setSelectedSensorPosition(RobotMap.ENCODER_TICKS_PER_REVOLUTION/2,0,0)
    }

    fun drive(speed: Double, angle: Double) {
        val current = angleMotor.getSelectedSensorPosition(0)
        var speedOfWheel = speed
        val midRelative = (FastMath.abs(current) % RobotMap.ENCODER_TICKS_PER_REVOLUTION) * current.sign
        val lowRelative = midRelative - RobotMap.ENCODER_TICKS_PER_REVOLUTION
        val highRelative = midRelative + RobotMap.ENCODER_TICKS_PER_REVOLUTION
        var target = (RobotMap.ENCODER_TICKS_PER_REVOLUTION/2) * angle
        val lowDelta = target - lowRelative
        val midDelta = target - midRelative
        val highDelta = target - highRelative
        var delta = displacementMin(doubleArrayOf(lowDelta, midDelta, highDelta))
        if(delta < RobotMap.ENCODER_TICKS_PER_REVOLUTION/-4){
            delta += RobotMap.ENCODER_TICKS_PER_REVOLUTION/2
            speedOfWheel *= -1
        }
        if(delta > RobotMap.ENCODER_TICKS_PER_REVOLUTION/4){
            delta -= RobotMap.ENCODER_TICKS_PER_REVOLUTION/2
            speedOfWheel *= -1
        }
        val next = delta + current
        angleMotor.set(ControlMode.Position, next)
        speedMotor.set(ControlMode.PercentOutput, speedOfWheel)
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

    fun DeepsAlgorithm(angle: Double, speed: Double){
        val current = angleMotor.getSelectedSensorPosition(0)
        val convAngle = (angle + 1) * 180.0
        var finalTarget = convAngle
        var finalSpeed = speed
        val oppAngle = (convAngle + 180)%(360)
        if(current > convAngle){
            val distToTargetCCW = FastMath.abs(current - convAngle)
            val distToTargetCW = FastMath.abs(360 - distToTargetCCW)
            val distToOppTarget = FastMath.abs(current - oppAngle)
            val minDistance = FastMath.min(FastMath.min(distToTargetCCW,distToTargetCW), distToOppTarget)
            when(minDistance){
                distToTargetCCW -> {
                    finalTarget = convAngle
                }
                distToTargetCW -> {
                    finalTarget = convAngle + 360
                }
                distToOppTarget -> {
                    finalTarget = oppAngle
                    finalSpeed *= -1.0
                }
            }
        }
        if(current < convAngle){
            val distToTargetCW = FastMath.abs(convAngle - current)
            val distToTargetCCW = 360.0 - distToTargetCW
            val distToOppTarget = FastMath.abs(current - oppAngle)
            val minDistance = FastMath.min(FastMath.min(distToTargetCCW,distToTargetCW), distToOppTarget)
            when(minDistance){
                distToTargetCW -> {
                    finalTarget = convAngle
                }
                distToTargetCCW -> {
                    finalTarget = convAngle - 360
                }
                distToOppTarget -> {
                    finalTarget = oppAngle
                    finalSpeed *= -1.0
                }
            }
        }
        angleMotor.set(ControlMode.Position, finalTarget)
        speedMotor.set(ControlMode.PercentOutput, finalSpeed)
    }
}
