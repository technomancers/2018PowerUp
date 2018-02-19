package edu.frc.technomancers.robot.subsystems

import com.ctre.phoenix.motorcontrol.ControlMode
import com.ctre.phoenix.motorcontrol.FeedbackDevice
import com.ctre.phoenix.motorcontrol.can.TalonSRX
import edu.frc.technomancers.robot.RobotMap
import edu.frc.technomancers.robot.commands.CubeLift
import edu.wpi.first.wpilibj.command.Subsystem

class RobotLift: Subsystem(){
    private val robotLiftMotor = TalonSRX(RobotMap.ROBOT_LIFT)

    init {
        robotLiftMotor.configSelectedFeedbackSensor(FeedbackDevice.PulseWidthEncodedPosition,0,0)
    }

    override fun initDefaultCommand() {
        defaultCommand = CubeLift()
    }

    fun setLiftSpeed(Speed: Double){
        robotLiftMotor.set(ControlMode.PercentOutput, Speed)
    }

    fun liftToPosition(Position: Double){
        robotLiftMotor.set(ControlMode.Position, Position)
    }
}