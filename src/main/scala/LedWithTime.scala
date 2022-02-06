package led_time
 
import chisel3._
import chisel3.experimental._
 
class LedWithTime extends Module {
    val io = IO(new Bundle {
        val led = Output(Bool())
    })
    io.led := false.B
}

object LedWithTime extends App {
  chisel3.emitVerilog(new LedWithTime, Array("--target-dir", "output/"))
}