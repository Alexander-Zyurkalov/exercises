package design_patterns.decorator

trait DataSource {
  def writeData(data: String)
  def readData: String
}
