package algorithmic_toolbox.util.input

import java.io.ByteArrayInputStream

import org.scalatest._

class ReaderSpec extends FlatSpec with Matchers {

  "The Reader object " should "read the strings for the input List(\"hello\", \"there\") " in {
    val reader = Reader(List("hello", "there"))
    reader.readLine.get shouldBe "hello"
    reader.readLine.get shouldBe "there"
  }

  it should "read a string and then an int for the input List(\"string\", \"5\") " in {
    val reader = Reader(List("string", "5"))
    reader.readLine.get shouldBe "string"
    reader.readInt.get shouldBe 5
  }

  it should "read the string \"Hello World!\" in the standad input" in {
    val helloWorld = "Hello World!"
    Console.withIn(new ByteArrayInputStream(helloWorld.getBytes())) {
      val reader = Reader()
      reader.readLine.get shouldBe helloWorld
    }
  }

  it should "read an integer form the standard input" in {
    val input = "721"
    Console.withIn(new ByteArrayInputStream(input.getBytes())) {
      val reader = Reader()
      reader.readInt.get shouldBe input.toInt
    }
  }

}
