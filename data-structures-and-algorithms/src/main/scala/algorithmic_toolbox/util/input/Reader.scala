package algorithmic_toolbox.util.input

object Reader {

  var stack: List[InputData] = List.empty[InputData]

  def apply(): Unit =
    stack = List(StdInput)

  def apply(data: List[String]): Unit =
    stack = List(StringInput(data))

  def applyMethod[T](fn: InputData => (InputData, T)): Option[T] = stack match {
    case Nil => None
    case List(head, _*) =>
      val (inputData, result) = fn(head)
      stack = inputData :: stack
      Some(result)
  }

  def applyMethod2[T](fn: InputData => (InputData, T)): T = {
    val (inputData, result) = fn(stack.head)
    stack = inputData :: stack
    result
  }

  def readInt: Option[Int] = applyMethod[Int](_.readInt)

  def readLine: Option[String] = applyMethod[String](_.readLine)

}
