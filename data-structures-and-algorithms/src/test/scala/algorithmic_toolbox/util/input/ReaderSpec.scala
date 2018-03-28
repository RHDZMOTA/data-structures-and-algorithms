package algorithmic_toolbox.util.input

import java.io.ByteArrayInputStream

import org.scalatest._

class ReaderSpec extends FlatSpec with Matchers {

  "The Reader object " should "read the strings for the input List(\"hello\", \"there\") " in {
    Reader(List("hello", "there"))
    Reader.readLine.get shouldBe "hello"
    Reader.readLine.get shouldBe "there"
  }

  it should "read a string and then an int for the input List(\"string\", \"5\") " in {
    Reader(List("string", "5"))
    Reader.readLine.get shouldBe "string"
    Reader.readInt.get shouldBe 5
  }

  it should "read the string \"Hello World!\" in the standad input" in {
    val helloWorld = "Hello World!"
    Console.withIn(new ByteArrayInputStream(helloWorld.getBytes())) {
      Reader()
      Reader.readLine.get shouldBe helloWorld
    }
  }

  it should "read an integer form the standard input" in {
    val input = "721"
    Console.withIn(new ByteArrayInputStream(input.getBytes())) {
      Reader()
      Reader.readInt.get shouldBe input.toInt
    }
  }

}
