package edu.frc.technomancers.robot.commands

import edu.frc.technomancers.robot.Operator
import edu.frc.technomancers.robot.utilities.Controller
import edu.wpi.first.wpilibj.command.Subsystem

public class DriveWithJoystick: CommandBase(){

    private var isFinished = false

    override fun requires(subsystem: Subsystem?) {
        super.requires(getDriveTrain())
    }

    override fun initialize() {
        isFinished = false
    }

    override fun execute() {
        getDriveTrain().swerveTranslate.Calculate(Operator.drivingController.getNormalizedAxis(Controller.Axes.LEFT_X),
                Operator.drivingController.getNormalizedAxis(Controller.Axes.LEFT_Y),
                Operator.drivingController.getNormalizedAxis(Controller.Axes.RIGHT_X))
        getDriveTrain().SwerveDrive()
        isFinished = true
    }

    override fun end(){

    }

    override fun interrupted() {

    }

    override fun isFinished(): Boolean {
        return isFinished
    }
}