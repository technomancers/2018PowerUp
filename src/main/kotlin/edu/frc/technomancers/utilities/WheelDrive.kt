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
        angleMotor.configSelectedFeedbackSensor(FeedbackDevice.Analog, 1, 0)
    }

     fun drive(speed: Double, angle: Double) {
        speedMotor.set(ControlMode.PercentOutput, speed)
        angleMotor.set(ControlMode.Position, angle)
    }

}
