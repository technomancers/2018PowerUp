package edu.frc.technomancers.robot.commands

class MoveLeft(Distance: Double) : CommandBase(){
    private var finished = true
    private val distance = Distance
    init {
        finished = false
        requires(driveTrain)
    }

    override fun execute() {
        if(distance > driveTrain.getLeftSonic()){
            driveTrain.swerveTranslate.calculate(-1.0,0.0,0.0)
            driveTrain.swerveDrive()
        } else{
            finished = true
        }
    }


    override fun isFinished(): Boolean {
        return finished
    }
}