package edu.frc.technomancers.utilities

import org.apache.commons.math3.util.FastMath

class SwerveTranslate(robotLength : Double, robotWidth : Double){
    private val robotDiagonal = FastMath.hypot(robotLength, robotWidth)
    private val cosine = robotLength / robotDiagonal
    private val sine = robotWidth / robotDiagonal
    var backRightMag = 0.0
    var backRightAngle = 0.0
    var backLeftMag = 0.0
    var backLeftAngle = 0.0
    var frontRightMag = 0.0
    var frontRightAngle = 0.0
    var frontLeftMag = 0.0
    var frontLeftAngle = 0.0

    fun calculate(x1 : Double, y1 : Double, x2 : Double) {
        val backXVector = x1 - x2 * cosine
        val frontXVector = x1 + x2 * cosine
        val leftYVector = -y1 - x2 * sine
        val rightYVector = -y1 + x2 * sine

        backRightMag = FastMath.hypot(backXVector, rightYVector)
        backLeftMag = FastMath.hypot(backXVector, leftYVector)
        frontRightMag = FastMath.hypot(frontXVector, rightYVector)
        frontLeftMag = FastMath.hypot(frontXVector, leftYVector)

        if (backRightMag > 1 || backLeftMag > 1 || frontRightMag > 1 || frontLeftMag > 1) {
            val max = FastMath.max(FastMath.max(FastMath.max(frontRightMag, frontLeftMag), backLeftMag), backRightMag)
            backRightMag /= max
            backLeftMag /= max
            frontRightMag /= max
            frontLeftMag /= max
        }

        backRightAngle = FastMath.atan2(backXVector, rightYVector) / FastMath.PI
        backLeftAngle = FastMath.atan2(backXVector, leftYVector) / FastMath.PI
        frontRightAngle = FastMath.atan2(frontXVector, rightYVector) / FastMath.PI
        frontLeftAngle = FastMath.atan2(frontXVector, leftYVector) / FastMath.PI
    }
}
