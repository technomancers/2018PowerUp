package edu.frc.technomancers.utilities

import edu.wpi.cscore.VideoMode
import edu.wpi.first.wpilibj.CameraServer
import kotlinx.coroutines.experimental.launch
import org.opencv.core.Mat
import org.opencv.imgproc.Imgproc
import kotlin.concurrent.thread

class Vision{
    init {
//        val camera = CameraServer.getInstance().startAutomaticCapture()
//        camera.setFPS(30)
//        camera.setResolution(320, 240)
        launch {
            val camera = CameraServer.getInstance().startAutomaticCapture()
            camera.setFPS(30)
            camera.setResolution(320,240)
            val cvSink = CameraServer.getInstance().video
            val cvSource = CameraServer.getInstance().putVideo("Grey",320,240)
            val source = Mat()
            val output = Mat()
            while (true) {
                cvSink.grabFrame(source)
                Imgproc.cvtColor(source, output, Imgproc.COLOR_BGR2GRAY)
                cvSource.putFrame(output)
            }
        }
    }
}