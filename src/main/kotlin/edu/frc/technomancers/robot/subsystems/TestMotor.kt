package edu.frc.technomancers.robot.subsystems

import com.ctre.phoenix.motorcontrol.ControlMode
import com.ctre.phoenix.motorcontrol.can.TalonSRX
import edu.frc.technomancers.robot.commands.RunMotor
import edu.wpi.first.wpilibj.command.Subsystem

class TestMotor: Subsystem(){
    //val t = TalonSRX(0)
    override fun initDefaultCommand() {
        defaultCommand = RunMotor()
    }

    fun setSpeed(x: Double){
        //t.set(ControlMode.PercentOutput, x)
    }


}