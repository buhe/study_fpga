
import chiseltest._
import org.scalatest.flatspec.AnyFlatSpec
import chisel3._
import led_time.LedWithTime

class LedWithTimeTest extends AnyFlatSpec with ChiselScalatestTester {
  behavior of "LedTime"
  it should "pass" in {
    println("Start the blinking LED")
    test(new LedWithTime).withAnnotations(Seq(WriteVcdAnnotation)) { c =>
  
      println("\nEnd the blinking LED")
    }
  }
}