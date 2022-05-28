`timescale 1ns / 1ns
//Import the main code into the testbench
`include "sample.v"
module sample_tb;
//Inputs as registers
reg A;
reg B;
reg C;
//Ouputs as wires
wire D;
wire E;
//Initialiastion
sample uut (A,B, C,D, E);
initial begin
//Name of the graph file that gets generated after we run
*dumpfile("sample_tb.vcd");
$dumpvars(0, sample tb);
#10
0
0.
C
#10
0:
1:
0
C
#10:
= 0;
B=1:
C=1•
#10;
$display("Test complete");
end
endmodule