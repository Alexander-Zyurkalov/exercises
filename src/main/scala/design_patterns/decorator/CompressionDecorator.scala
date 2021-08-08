package design_patterns.decorator

import java.io.ByteArrayOutputStream

case class CompressionDecorator(wrappe: DataSource) extends DataSourceDecorator(wrappe){
  override def writeData(data: String): Unit = {
    super.writeData(compress(data))
  }

  override def readData: String = decompress(super.readData)


  import java.io.{ByteArrayInputStream, IOException}
  import java.util.Base64
  import java.util.zip.{Deflater, DeflaterOutputStream, InflaterInputStream}

  private val compLevel: Int = 6

  private def compress(stringData: String) = {
    val data = stringData.getBytes
    try {
      val bout = new ByteArrayOutputStream(512)
      val dos = new DeflaterOutputStream(bout, new Deflater(compLevel))
      dos.write(data)
      dos.close()
      bout.close()
      Base64.getEncoder.encodeToString(bout.toByteArray)
    }
  }

  private def decompress(stringData: String) = {
    val data = Base64.getDecoder.decode(stringData)
    try {
      val in = new ByteArrayInputStream(data)
      val iin = new InflaterInputStream(in)
      val bout = new ByteArrayOutputStream(512)
      def readIt: LazyList[Int] = iin.read() #:: readIt
      readIt.takeWhile(b => b >= 0).foreach(b => bout.write(b))
      in.close()
      iin.close()
      bout.close()
      new String(bout.toByteArray)
    } catch {
      case ex: IOException =>
        null
    }
  }
}

