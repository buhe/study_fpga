
import chiseltest._
import org.scalatest.flatspec.AnyFlatSpec
import led.Led
import chisel3._

class LedTest extends AnyFlatSpec with ChiselScalatestTester {
  behavior of "Led"
  it should "pass" in {
    println("Start the blinking LED")
    test(new Led) { c =>
      if(c.io.led.peek().litToBoolean == false) {
        println("open");
      } else {
        println("close");
      }
      println("\nEnd the blinking LED")
    }
  }
}