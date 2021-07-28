package design_patterns.decorator

abstract class DataSource {
  def writeData(data: String)
  def readData: String
}
