package edu.frc.technomancers.robot.commands

class TurnLeft(private val Angle: Double) : CommandBase(){
    var finished = true

    init {
        finished = false
        requires(driveTrain)
        driveTrain.resetGyroAngle()
    }

    override fun execute() {
        if(driveTrain.getGyroValue() > Angle){
            driveTrain.swerveTranslate.calculate(0.0,0.0,-1.0)
            driveTrain.swerveDrive()
        } else{
            finished = true
        }
    }


    override fun isFinished(): Boolean {
        return finished
    }
}