
// ANDtest.scala
package test
 
import chisel3._
 
object testMain2 extends App {
  val verilogString = chisel3.emitVerilog(new Led, Array("--target-dir", "output/"))
}