package edu.frc.technomancers.robot.commands

class MoveLeft(private val Distance: Double) : CommandBase(){
    private var finished = true
    init {
        finished = false
        requires(driveTrain)
    }

    override fun execute() {
        if(Distance > CommandBase.driveTrain.getLeftSonic()){
            CommandBase.driveTrain.swerveTranslate.calculate(-1.0,0.0,0.0)
            CommandBase.driveTrain.swerveDrive()
        } else{
            finished = true
        }
    }

    override fun isFinished(): Boolean {
        return finished
    }
}