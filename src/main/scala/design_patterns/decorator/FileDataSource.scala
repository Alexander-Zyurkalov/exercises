package design_patterns.decorator

class FileDataSource(private val name: String) extends DataSource {
  override def writeData(data: String): Unit = {
    val file = File(this.name)
  }

  override def readData: String = ???
}
