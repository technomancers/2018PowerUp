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
        angleMotor.setSelectedSensorPosition(900,0,0)
    }

     fun drive(speed: Double, angle: Double) {
         /*val target = 900 * (angle + 1)
         val current = angleMotor.getSelectedSensorPosition(0)
         val actual = current % 1800
         val delta = target - actual
         val next = delta + current*/
         val current = angleMotor.getSelectedSensorPosition(0)
         val currentDivided = current/1800
         val kInterval = (currentDivided.toInt()) * 1800 - 900
         val nextKInterval = (currentDivided.toInt() + 1) * 1800 - 900
         val firstDistance = current - (angle + kInterval)
         val secondDistance = (angle + nextKInterval) - current
         if(firstDistance <= secondDistance){
             angleMotor.set(ControlMode.Position, angle + kInterval)
         } else {
             angleMotor.set(ControlMode.Position, angle + nextKInterval)
         }
         speedMotor.set(ControlMode.PercentOutput, speed)

    }
}
