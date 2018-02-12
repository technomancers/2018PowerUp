package edu.frc.technomancers.utilities

import edu.wpi.first.wpilibj.I2C
import java.nio.ByteBuffer
import java.nio.ByteOrder

class I2C{
    val wire = I2C(I2C.Port.kOnboard,0x2A)

    fun write(Input: String){
        val charArray = Input.toCharArray()
        val writeData = ByteArray(charArray.size, {i -> charArray[i].toByte()})
        wire.transaction(writeData, writeData.size, null, 0)
    }

    fun read(): ShortArray{
        val data = ByteArray(10) //10 is the max byte size
        wire.read(0x2A, 10, data)
        val shortArray = ShortArray(5)
        val buffer = ByteBuffer.wrap(data)
        buffer.order(ByteOrder.BIG_ENDIAN).asShortBuffer().get(shortArray)
        return shortArray
    }
}