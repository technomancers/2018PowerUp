package edu.frc.technomancers.robot.subsystems

import edu.frc.technomancers.robot.commands.RunCamera
import edu.wpi.cscore.CvSink
import edu.wpi.cscore.CvSource
import edu.wpi.cscore.UsbCamera
import edu.wpi.cscore.VideoMode
import edu.wpi.first.wpilibj.CameraServer
import edu.wpi.first.wpilibj.command.Subsystem
import org.opencv.core.Mat
import kotlin.concurrent.thread

class Vision : Subsystem(){
    override fun initDefaultCommand() {
        defaultCommand = RunCamera()

    }

   fun startCameraStream(){
       @Suppress("MagicNumber")
       val camera = UsbCamera("cam0",0)
       camera.videoMode = VideoMode(VideoMode.PixelFormat.kMJPEG, 160,120,30)
       CameraServer.getInstance().addCamera(camera)
       CameraServer.getInstance().startAutomaticCapture(camera)
       System.out.println("Camera is tarting")
   }

}