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

/**
case object Reader {
  var stack: List[InputData] = List.empty[InputData]

  def apply(): Unit =
    stack = List(StdInput)

  def apply(data: List[String]): Unit =
    stack = List(StringInput(data))

  def applyMethod[T](fn: InputData => (InputData, T)): T = {
    val (inputData, result) = fn(stack.head)
    stack = inputData :: stack
    result
  }

  def readInt: Int = applyMethod[Int](_.readInt)

  def readLine: String = applyMethod[String](_.readLine)

}
  **/