
package led
 
import chisel3._
import chisel3.experimental._
 
class Led2 extends Module {
    val io = IO(new Bundle {
        val led = Output(Bool())
        val key = Input(UInt(1.W))
    })
    io.led := io.key
}

object Led2 extends App {
  chisel3.emitVerilog(new Led2, Array("--target-dir", "output/"))
}