package design_patterns.composite

import scala.collection.mutable.{ArrayBuffer, ListBuffer}

class Container extends Instrument {
  private val instruments: ArrayBuffer[Instrument] = ArrayBuffer()

  override def play(): Unit = {
    println("Playing inside a container")
    instruments.foreach(instrument => {
      print("  ")
      instrument.play()
    })
  }

  def addInstrument(instrument: Instrument): Container = {
    instruments.append(instrument)
    this
  }
}
