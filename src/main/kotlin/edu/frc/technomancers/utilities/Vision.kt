package edu.frc.technomancers.utilities

import edu.wpi.first.wpilibj.CameraServer
class Vision{
    init {
        val camera = CameraServer.getInstance().startAutomaticCapture()
        camera.setFPS(30)
        camera.setResolution(320, 240)
    }
}