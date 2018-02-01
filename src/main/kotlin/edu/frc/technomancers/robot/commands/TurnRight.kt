package edu.frc.technomancers.robot.commands

class TurnRight(Angle: Double) : CommandBase(){
    var finished = true
    val angle = Angle
    init {
        finished = false
        requires(driveTrain)
        driveTrain.resetGyroAngle()
    }

    override fun execute() {
        if(driveTrain.getGyroValue() < angle){
            driveTrain.swerveTranslate.calculate(0.0,0.0,1.0)
            driveTrain.swerveDrive()
        } else{
            finished = true
        }
    }


    override fun isFinished(): Boolean {
        return finished
    }
}
