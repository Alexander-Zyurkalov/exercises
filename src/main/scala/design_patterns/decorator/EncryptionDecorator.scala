package design_patterns.decorator

case class EncryptionDecorator(wrappe: FileDataSource) extends DataSourceDecorator(wrappe = wrappe){
  override def writeData(data: String): Unit = super.writeData(encode(data))

  override def readData: String = decode(super.readData)

  import java.util.Base64

  private def encode(data: String): String = {
    val result: Array[Byte] = data.getBytes
    for (i <- result.indices) {
      result(i) = (result(i) + 1).toByte
    }
    Base64.getEncoder.encodeToString(result)
  }

  private def decode(data: String): String = {
    val result: Array[Byte] = Base64.getDecoder.decode(data)
    for (i <- result.indices) {
      result(i) = (result(i) - 1).toByte
    }
    new String(result)
  }
}
