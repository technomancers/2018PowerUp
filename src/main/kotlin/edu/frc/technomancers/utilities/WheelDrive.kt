package edu.frc.technomancers.utilities

import com.ctre.phoenix.motorcontrol.ControlMode
import com.ctre.phoenix.motorcontrol.can.TalonSRX
import edu.frc.technomancers.robot.RobotMap
import edu.wpi.first.wpilibj.AnalogInput
import edu.wpi.first.wpilibj.PIDController
import edu.wpi.first.wpilibj.PIDOutput
import org.apache.commons.math3.util.FastMath
import kotlin.math.sign

class WheelDrive(speedMotorPort: Int, angleMotorPort: Int, analogPos: Int, zeroState: Int, pos: WheelType) {


    private val speedMotor = TalonSRX(speedMotorPort)
    private val angleMotor = TalonSRX(angleMotorPort)
    private val encoder = AnalogInput(analogPos)
    private val wheelZero = zeroState
    private val position = pos

    enum class WheelType{
        FRONT, BACK
    }

    fun drive(speed: Double, angle: Double) {
        deepsAlgorithm(angle, speed)
    }


    fun deepsAlgorithm(angle: Double, speed: Double){
        val current = ((encoder.voltage * RobotMap.ENCODER_TICKS_PER_REVOLUTION / 5.0 - wheelZero)) % RobotMap.ENCODER_TICKS_PER_REVOLUTION
        val convertedAngle = (angle + 1) * RobotMap.ENCODER_TICKS_PER_REVOLUTION/2.0
        var finalSpeed = speed
        var delta = 0.0
        if(current > convertedAngle){
            val distToTargetCCW = FastMath.abs(current - convertedAngle)
            val distToTargetCW = FastMath.abs(RobotMap.ENCODER_TICKS_PER_REVOLUTION - distToTargetCCW)
            val minDistance = FastMath.min(distToTargetCCW,distToTargetCW)
            when(minDistance){
                distToTargetCCW -> {
                    delta -= distToTargetCCW
                }
                distToTargetCW -> {
                    delta += distToTargetCW
                }
            }
        }
        if(current < convertedAngle){
            val distToTargetCW = FastMath.abs(convertedAngle - current)
            val distToTargetCCW = RobotMap.ENCODER_TICKS_PER_REVOLUTION - distToTargetCW
            val minDistance = FastMath.min(distToTargetCCW,distToTargetCW)
            when(minDistance){
                distToTargetCW -> {
                    delta += distToTargetCW
                }
                distToTargetCCW -> {
                    delta -= distToTargetCCW
                }
            }
        }
        if(delta < -RobotMap.ENCODER_TICKS_PER_REVOLUTION/4.0){
            delta += RobotMap.ENCODER_TICKS_PER_REVOLUTION/2.0
            finalSpeed *= -1.0
        } else if (delta > RobotMap.ENCODER_TICKS_PER_REVOLUTION/4.0){
            delta -= RobotMap.ENCODER_TICKS_PER_REVOLUTION/2.0
            finalSpeed *= -1.0
        }
        if(position == WheelType.BACK){
            angleMotor.set(ControlMode.PercentOutput, (delta * 2 / RobotMap.ENCODER_TICKS_PER_REVOLUTION))
        } else {
            angleMotor.set(ControlMode.PercentOutput, delta * 2 / RobotMap.ENCODER_TICKS_PER_REVOLUTION)
        }
        speedMotor.set(ControlMode.PercentOutput, finalSpeed)
        System.out.println("ID" + angleMotor.deviceID)
        System.out.println(current)

    }
}
