package edu.frc.technomancers.robot.commands

class MoveForward(private val Distance: Double, private val sensor: Int) : CommandBase(){
    private var finished = true

    init {
        finished = false
        requires(CommandBase.driveTrain)
    }

    override fun execute() {
        if(CommandBase.driveTrain.getFrontLeftSonic() > Distance && CommandBase.driveTrain.getFrontRightSonic() > Distance ){
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
