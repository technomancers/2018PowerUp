package edu.frc.technomancers.robot.Utilities

import edu.wpi.first.wpilibj.GenericHID
import edu.wpi.first.wpilibj.Joystick
import edu.wpi.first.wpilibj.buttons.JoystickButton

class Controller(port: Int, private val threshold : Double = 0.1){
    private val joystick = Joystick(port);
    val buttonA = JoystickButton(joystick, 1)
    val buttonB = JoystickButton(joystick, 2)
    val buttonX = JoystickButton(joystick, 3)
    val buttonY = JoystickButton(joystick, 4)
    val buttonLb = JoystickButton(joystick, 5)
    val buttonRb = JoystickButton(joystick, 6)

    enum class Axes(val port : Int) {
        LEFT_X(0),
        RIGHT_X(4),
        LEFT_Y(1),
        RIGHT_Y(5),
        TRIGGER_LEFT(2),
        TRIGGER_RIGHT(3)
    }

    fun getNormalizedAxis(axes : Axes) : Double{
        val currentPos = joystick.getRawAxis(axes.port)
        if (Math.abs(currentPos) < threshold) {
            return 0.0
        }
        return currentPos
    }

    fun getTwist() : Double {
        return joystick.twist
    }

    fun getPov() : Int {
        return joystick.getPOV(0)
    }

    fun setRumble(value : Double) {
        joystick.setRumble(GenericHID.RumbleType.kLeftRumble, value)
        joystick.setRumble(GenericHID.RumbleType.kRightRumble, value)
    }
}