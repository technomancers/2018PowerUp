package edu.frc.technomancers.robot.commands

class MoveForward(Distance: Int) : CommandBase(){
    var finished = true
    val distance = Distance
    init {
        finished = false
        requires(driveTrain)
    }

    override fun execute() {
        if(ultra < distance){
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