package algorithmic_toolbox.week1

import scala.io.StdIn
import algorithmic_toolbox.util.input.Reader

object MaxPairwiseProduct {

  def getMaxPairwiseProduct(numbers: Array[Int]): BigInt = {
    val nums = numbers.sorted
    val n = numbers.length - 1
    BigInt(nums(n)) * BigInt(nums(n-1))
  }

  def generateResult: String = {
    val n: Int = Reader.readInt.get
    val numbers: Array[Int] = Reader.readLine.get
      .split(" ")
      .map(_.toInt)

    getMaxPairwiseProduct(numbers).toString
  }

  def main(args: Array[String]): Unit = {
    Reader() // configure reader to read the data from the standard input
    println(generateResult)
  }
}
