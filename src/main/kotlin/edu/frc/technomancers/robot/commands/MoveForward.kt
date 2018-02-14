package edu.frc.technomancers.robot.commands

class MoveForward(private val Distance: Double) : CommandBase(){
    private var finished = true

    init {
        finished = false
        requires(CommandBase.driveTrain)
    }

    override fun execute() {
        if(driveTrain.getBackSonic() < Distance){
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
