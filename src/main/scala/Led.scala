package test
 
import chisel3._
import chisel3.experimental._
 
class Led extends RawModule {
    val io = IO(new Bundle {
        val led = Output(Bool())
    })
    io.led := false.B
}
