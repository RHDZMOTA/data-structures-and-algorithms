package algorithmic_toolbox.week1

import algorithmic_toolbox.util.input.Reader

object MaxPairwiseProduct {

  def getMaxPairwiseProduct(numbers: Array[Int]): BigInt = {
    val nums = numbers.sorted
    val n = numbers.length - 1
    BigInt(nums(n)) * BigInt(nums(n-1))
  }

  def generateResult(reader: Reader): String = {
    val n: Int = reader.readInt.get
    val numbers: Array[Int] = reader.readLine.get
      .split(" ")
      .map(_.toInt)

    getMaxPairwiseProduct(numbers).toString
  }

  def main(args: Array[String]): Unit = {
    val reader = Reader() // configure reader to get the data from the standard input
    println(generateResult(reader))
  }
}
