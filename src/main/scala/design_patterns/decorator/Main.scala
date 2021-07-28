package design_patterns.decorator

object Main extends App {
  val salaryRecords = "Name,Salary\nJohn Smith,100000\nSteven Jobs,912000"
  var encodedDataSource = new CompressionDecorator(
    new EncryptionDecorator(
      new FileDataSource("out/OutputDemo.txt")
    )
  )

}
