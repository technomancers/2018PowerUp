package edu.frc.technomancers.robot.commands

class MoveLeft(private val Distance: Double) : CommandBase(){
    private var finished = true
    init {
        finished = false
        requires(driveTrain)
    }

    override fun execute() {
        if(Distance > driveTrain.getLeftSonic()){
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