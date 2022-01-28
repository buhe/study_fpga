
// ANDtest.scala
package test
 
import chisel3._
 
object testMain extends App {
  val verilogString = chisel3.emitVerilog(new AND, Array("--target-dir", "output/"))
}