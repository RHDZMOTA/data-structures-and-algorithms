package algorithmic_toolbox.week1

import algorithmic_toolbox.util.input.Reader

object SumOfTwoDigits {

  def generateResult: String = Reader.readLine.getOrElse("")
    .split(" ")
    .foldLeft(0) {(acc, x) => acc + x.toInt}
    .toString

  def main(args: Array[String]): Unit = {
    Reader() // configure reader to get the data from the standard input
    println(generateResult)
  }
}
