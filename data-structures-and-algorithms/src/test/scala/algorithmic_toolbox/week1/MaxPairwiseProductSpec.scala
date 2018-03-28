package algorithmic_toolbox.week1

import org.scalatest._
import algorithmic_toolbox.util.input.Reader

class MaxPairwiseProductSpec extends FlatSpec with Matchers {


  def generateTest(shouldSentence: String, data: List[String], result: String): Unit = {
    it should shouldSentence in {
      val reader = Reader(data)
      MaxPairwiseProduct.generateResult(reader) shouldBe result
    }
  }

  "MaxPairwiseProduct object" should "calculate 35 with input 7 3 5 2 -7" in {
    val reader = Reader(List("5", "7 3 5 2 -7"))
    MaxPairwiseProduct.generateResult(reader) shouldBe "35"
  }

  generateTest("calculate 10000 with input 10000 1", List("2", "10000 1"), "10000")

  generateTest("calculate 10 with input -100 -5 -2", List("3", "-100 -5 -2"), "10")
}
