
import chiseltest._
import org.scalatest.flatspec.AnyFlatSpec
import led.Led2
import chisel3._

class Led2Test extends AnyFlatSpec with ChiselScalatestTester {
  behavior of "Led2"
  it should "pass" in {
    println("Start the blinking LED")
    test(new Led2) { c =>
      c.io.key.poke(0.U)
      if(c.io.led.peek().litToBoolean == false) {
        println("open");
      } else {
        println("close");
      }
      println("\nEnd the blinking LED")
    }
  }
}