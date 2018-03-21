package edu.frc.technomancers.robot.subsystems

import com.ctre.phoenix.motorcontrol.ControlMode
import com.ctre.phoenix.motorcontrol.can.TalonSRX
import edu.frc.technomancers.robot.RobotMap
import edu.wpi.first.wpilibj.command.Subsystem

class Extenders: Subsystem(){

    private val extenderMotor = TalonSRX(RobotMap.EXTENDER_MOTOR)

    enum class ExtenderState{
        UP, DOWN
    }

    override fun initDefaultCommand() {
    }

    fun moveDown(){
        extenderMotor.set(ControlMode.PercentOutput, 1.0)
    }

    fun moveUp(){
        extenderMotor.set(ControlMode.PercentOutput, -1.0)
    }

    fun stopMotor(){
        extenderMotor.set(ControlMode.PercentOutput, 0.0)
    }
}