package algorithmic_toolbox.week1

import algorithmic_toolbox.util.input.Reader

import java.io.ByteArrayInputStream
import scala.io.StdIn
import org.scalatest._


class SumOfTwoDigitsSpec extends FlatSpec with Matchers {

  def generateInputData(data: String) =
    new ByteArrayInputStream(data.getBytes())

  def generalRandomTest(): Unit = {
    val random = scala.util.Random
    val inputDataString: String = s"${random.nextInt.toString} ${random.nextInt.toString}"
    val inputData = generateInputData(inputDataString)
    val expectedResult: String = inputDataString.split(" ").map(_.toInt).sum.toString
    it should s"calculate $expectedResult with an input of $inputDataString" in {
      Console.withIn(inputData){
        val reader = Reader()
        SumOfTwoDigits.generateResult(reader) shouldEqual expectedResult
      }
    }
  }

  "The function generateInputData and StdIn.readLine()" should "work with an input of \"1 2 3\"" in {
    val inputData = generateInputData("1 2 3")
    Console.withIn(inputData) {
      StdIn.readLine() shouldEqual "1 2 3"
    }
  }

  "SumOfTwoDigits" should "return 3 as string with input \"1 2\"" in {
    val inputData = generateInputData("1 2")
    Console.withIn(inputData) {
      val reader = Reader()
      SumOfTwoDigits.generateResult(reader) shouldEqual "3"
    }
  }

  it should "calculate 14 as string for input \"7 7\"" in {
    val reader = Reader(List("7 7"))
    SumOfTwoDigits.generateResult(reader) shouldEqual "14"

  }

  // Random general tests
  for (i <- 1 to 10)
    generalRandomTest()

}
