package edu.frc.technomancers.utilities

import com.ctre.phoenix.motorcontrol.ControlMode
import com.ctre.phoenix.motorcontrol.FeedbackDevice
import com.ctre.phoenix.motorcontrol.can.TalonSRX
import edu.wpi.first.wpilibj.PIDController
import edu.wpi.first.wpilibj.PIDOutput
import edu.wpi.first.wpilibj.PIDSource

class WheelDrive(speedMotorPort: Int, angleMotorPort: Int)
{
    private val speedMotor = TalonSRX(speedMotorPort)
    private val angleMotor = TalonSRX(angleMotorPort)

    init{
        angleMotor.configSelectedFeedbackSensor(FeedbackDevice.QuadEncoder, 0, 0)
        angleMotor.setSelectedSensorPosition(0,0,0)
    }

     fun drive(speed: Double, angle: Double) {
         /*val target = 900 * (angle + 1)
         val current = angleMotor.getSelectedSensorPosition(0)
         val actual = current % 1800
         val delta = target - actual
         val next = delta + current*/
         val current = angleMotor.getSelectedSensorPosition(0)
         val target = 900 * angle
         val lowBound = Math.floor((current-900.0)/1800.0) * 1800 + 900
         val highBound = lowBound + 1800
         val lowTarget = lowBound - 1800 + target + 900
         val mediumTarget = lowBound + target + 900
         val highTarget = highBound + target + 900
         val firstDistance = Math.abs(current - lowTarget)
         val secondDistance = Math.abs(current - mediumTarget)
         val thirdDistance = Math.abs(current - highTarget)
         val shortestDistance = Math.min(Math.min(firstDistance, secondDistance), thirdDistance)
         if(shortestDistance == firstDistance){
             angleMotor.set(ControlMode.Position, lowTarget)
         } else if(shortestDistance == secondDistance){
             angleMotor.set(ControlMode.Position, mediumTarget)
         } else {
             angleMotor.set(ControlMode.Position, highTarget)
         }
         speedMotor.set(ControlMode.PercentOutput, speed)

    }
}
