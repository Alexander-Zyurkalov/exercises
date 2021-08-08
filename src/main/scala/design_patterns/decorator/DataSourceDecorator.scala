package design_patterns.decorator

abstract class DataSourceDecorator(private val wrappe: DataSource) extends DataSource {
  override def writeData(data: String): Unit = wrappe.writeData(data)

  override def readData: String = wrappe.readData
}
