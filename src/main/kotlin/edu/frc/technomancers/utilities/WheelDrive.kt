package edu.frc.technomancers.utilities

import com.ctre.phoenix.motorcontrol.ControlMode
import com.ctre.phoenix.motorcontrol.can.TalonSRX
import edu.wpi.first.wpilibj.PIDController
import edu.wpi.first.wpilibj.PIDOutput
import edu.wpi.first.wpilibj.PIDSource

public class WheelDrive(val speedMotor: TalonSRX, val angleMotor: TalonSRX)
{
    public fun drive(speed: Double, angle: Double) {
        this.speedMotor.set(ControlMode.PercentOutput, speed)
        this.angleMotor.set(ControlMode.Position, angle)
    }

}
