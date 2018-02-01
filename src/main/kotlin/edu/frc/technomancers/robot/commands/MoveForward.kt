package edu.frc.technomancers.robot.commands

class MoveForward(Distance: Double) : CommandBase(){
    private var finished = true
    private val distance = Distance
    init {
        finished = false
        requires(CommandBase.driveTrain)
    }

    override fun execute() {
        if(CommandBase.driveTrain.getFrontLeftSonic() > distance || CommandBase.driveTrain.getFrontRightSonic() > distance ){
            CommandBase.driveTrain.swerveTranslate.calculate(0.0,1.0,0.0)
            CommandBase.driveTrain.swerveDrive()
        } else{
            finished = true
        }
    }


    override fun isFinished(): Boolean {
        return finished
    }
}
