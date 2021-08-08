package design_patterns.decorator

object Main extends App {
  val salaryRecords: String = "Name,Salary\nJohn Smith,100000\nSteven Jobs,912000"
  println(salaryRecords)
  val encoded:DataSource = // new CompressioDecorator(
//    new EncriptionDecorator(
      new FileDataSource("out/OutputDemo.txt")
//    )
//  )
  encoded.writeData(data = salaryRecords)
  val plain: DataSource = new FileDataSource("out/OutputDemo.txt")
  println("- Input ----------------")
  println(salaryRecords)
  println("- Encoded --------------")
  println(plain.readData)
  println("- Decoded --------------")
  println(encoded.readData)
}
