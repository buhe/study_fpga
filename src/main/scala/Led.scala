package led
 
import chisel3._
import chisel3.experimental._
 
class Led extends Module {
    val io = IO(new Bundle {
        val led = Output(Bool())
    })
    io.led := false.B
}

object Led extends App {
  chisel3.emitVerilog(new Led, Array("--target-dir", "output/"))
}