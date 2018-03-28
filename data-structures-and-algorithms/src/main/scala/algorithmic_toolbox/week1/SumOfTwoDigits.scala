package algorithmic_toolbox.week1

import algorithmic_toolbox.util.input.Reader

object SumOfTwoDigits {

  def generateResult(reader: Reader): String = reader.readLine.getOrElse("")
    .split(" ")
    .foldLeft(0) {(acc, x) => acc + x.toInt}
    .toString

  def main(args: Array[String]): Unit = {
    val reader = Reader() // configure reader to get the data from the standard input
    println(generateResult(reader))
  }
}
