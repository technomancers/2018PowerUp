package edu.frc.technomancers.robot.commands

class TurnRight(private val Angle: Double) : CommandBase(){
    var finished = true

    init {
        finished = false
        requires(driveTrain)
        driveTrain.resetGyroAngle()
    }

    override fun execute() {
        if(driveTrain.getGyroValue() < Angle){
            CommandBase.driveTrain.swerveTranslate.calculate(0.0,0.0,1.0)
            CommandBase.driveTrain.swerveDrive()
        } else{
            finished = true
        }
    }


    override fun isFinished(): Boolean {
        return finished
    }
}
