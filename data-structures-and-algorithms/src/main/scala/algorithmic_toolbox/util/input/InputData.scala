package algorithmic_toolbox.util.input

import scala.io.StdIn

sealed trait InputData {

  def readInt: (InputData, Int) = this match {
    case StdInput => (StdInput, StdIn.readInt())
    case StringInput(data) => (StringInput(data.tail), data.head.toInt)
  }

  def readLine: (InputData, String) = this match {
    case StdInput => (StdInput, StdIn.readLine)
    case StringInput(data) => (StringInput(data.tail), data.head)
  }
}

final case object StdInput extends InputData

final case class StringInput(inputList: List[String]) extends InputData

