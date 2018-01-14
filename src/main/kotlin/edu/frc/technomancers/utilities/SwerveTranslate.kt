package edu.frc.technomancers.utilities

class SwerveTranslate(robotLength : Double, robotWidth : Double){
    private val robotDiagonal = Math.hypot(robotLength, robotWidth)
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
        val leftYVector = y1 - x2 * sine
        val rightYVector = y1 + x2 * sine

        backRightMag = Math.hypot(backXVector, rightYVector)
        backLeftMag = Math.hypot(backXVector, leftYVector)
        frontRightMag = Math.hypot(frontXVector, rightYVector)
        frontLeftMag = Math.hypot(frontXVector, leftYVector)

        backRightAngle = Math.atan2(backXVector, rightYVector) / Math.PI
        backLeftAngle = Math.atan2(backXVector, leftYVector) / Math.PI
        frontRightAngle = Math.atan2(frontXVector, rightYVector) / Math.PI
        frontLeftAngle = Math.atan2(frontXVector, leftYVector) / Math.PI
    }

    fun print() {
        println("Front Left  :$frontLeftMag:$frontLeftAngle")
        println("Front Right :$frontRightMag:$frontRightAngle")
        println("Back Left   :$backLeftMag:$backLeftAngle")
        println("Back Right  :$backRightMag:$backRightAngle")
    }
}
