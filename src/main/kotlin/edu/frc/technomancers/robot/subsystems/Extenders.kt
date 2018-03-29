package edu.frc.technomancers.robot.subsystems

import com.ctre.phoenix.motorcontrol.ControlMode
import com.ctre.phoenix.motorcontrol.can.TalonSRX
import edu.frc.technomancers.robot.RobotMap
import edu.frc.technomancers.robot.commands.ToggleExtender
import edu.wpi.first.wpilibj.command.Subsystem

class Extenders: Subsystem(){

    private val extenderMotor = TalonSRX(RobotMap.EXTENDER_MOTOR)

    enum class ExtenderState{
        UP, DOWN
    }

    override fun initDefaultCommand() {
        defaultCommand = ToggleExtender()
    }

    fun setSpeed(speed: Double){
        extenderMotor.set(ControlMode.PercentOutput, speed)
    }

    fun stopMotor(){
        extenderMotor.set(ControlMode.PercentOutput, 0.0)
    }
}