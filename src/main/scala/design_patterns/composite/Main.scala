package design_patterns.composite
object Main extends App {
  val sin1 = new Sin()
  val sin2 = new Sin()
  val saw1 = new Saw()
  val saw2 = new Saw()
  val firstContainer = new Container().addInstrument(sin1).addInstrument(saw1)
  val secondContainer = new Container().addInstrument(sin2).addInstrument(saw2).addInstrument(firstContainer)
  secondContainer.play()
}
