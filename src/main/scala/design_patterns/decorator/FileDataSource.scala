package design_patterns.decorator

import java.io.{File, FileOutputStream, FileReader}

case class FileDataSource(path: String) extends DataSource {
  override def writeData(data: String): Unit = {
    val file = new File(path)
    val outputStream = new FileOutputStream(file)
    outputStream.write(data.getBytes(), 0, data.length)
    outputStream.close()
  }

  override def readData: String = {
    val file = new File(path)
    var buffer: Array[Char] = new Array[Char](file.length.toInt)
    val reader = new FileReader(file)
    reader.read(buffer)
    reader.close()
    new String(buffer)
  }
}
