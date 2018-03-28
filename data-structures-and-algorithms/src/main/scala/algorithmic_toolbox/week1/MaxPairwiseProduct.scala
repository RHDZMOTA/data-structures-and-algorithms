package algorithmic_toolbox.week1

import scala.io.StdIn

object MaxPairwiseProduct {

  def getMaxPairwiseProduct(numbers: Array[Int]): BigInt = {
    val nums = numbers.sorted
    val n = numbers.length - 1
    BigInt(nums(n)) * BigInt(nums(n-1))
  }

  def main(args: Array[String]): Unit = {
    val n: Int = StdIn.readInt()
    val numbers: Array[Int] = StdIn.readLine()
      .split(" ")
      .map(_.toInt)

    println(getMaxPairwiseProduct(numbers))
  }
}
