package algorithmic_toolbox.util.input

class Reader(var dataSource: List[InputData] = List.empty[InputData]) {

  private def applyMethod[T](fn: InputData => (InputData, T)): Option[T] = dataSource match {
    case Nil => None
    case List(head, _*) =>
      val (inputData, result) = fn(head)
      dataSource = inputData :: dataSource
      Some(result)
  }

  def readInt: Option[Int] = applyMethod[Int](_.readInt)

  def readLine: Option[String] = applyMethod[String](_.readLine)
}

object Reader {

  def apply(): Reader =
    new Reader(List(StdInput))

  def apply(data: List[String]): Reader =
    new Reader(List(StringInput(data)))

}
