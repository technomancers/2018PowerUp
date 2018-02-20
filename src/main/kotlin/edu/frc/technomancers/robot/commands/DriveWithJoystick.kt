package edu.frc.technomancers.robot.commands

import edu.frc.technomancers.robot.Operator
import edu.frc.technomancers.utilities.Controller

class DriveWithJoystick: CommandBase(){

    private var isFinished = false

    init {
        requires(driveTrain)
    }

    override fun initialize() {
    }

    override fun execute() {
//        driveTrain.swerveTranslate.calculate(
//                Operator.drivingController.getNormalizedAxis(Controller.Axes.LEFT_X),
//                Operator.drivingController.getNormalizedAxis(Controller.Axes.LEFT_Y),
//                Operator.drivingController.getNormalizedAxis(Controller.Axes.RIGHT_X))
//        driveTrain.swerveDrive()
        driveTrain.tankDrive()
    }

    override fun end(){
    }

    override fun interrupted() {
    }

    override fun isFinished(): Boolean {
        return isFinished
    }
}
