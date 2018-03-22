package algorithmic_toolbox.week1

import scala.io.StdIn

object SumOfTwoDigits {
  def main(args: Array[String]): Unit = {
    val result: Int = StdIn.readLine()
      .split(" ")
      .foldLeft(0) {(acc, x) => acc + x.toInt}

    println(result)
  }
}
