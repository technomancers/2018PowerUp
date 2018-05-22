package edu.frc.technomancers.utilities

import edu.wpi.first.wpilibj.CameraServer
class Vision{
    init {
        val camera = CameraServer.getInstance().startAutomaticCapture()
        @Suppress("MagicNumber")
        camera.setFPS(30)
        camera.setResolution(160, 120)
    }
}
