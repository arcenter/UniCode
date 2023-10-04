// Code by arcenter
// https://github.com/arcenter/UniCode/

// Testbench

module tb;
  reg [1:0]i;
  reg eP;
  wire [3:0]o;
  initial begin
    $dumpfile("dump.vcd");
    $dumpvars(1, tb);
    #00 eP = 0;
    #00 i = 8'b00;
    #10 i = 8'b01;
    #10 i = 8'b10;
    #10 i = 8'b11;
    #10 eP = 1;
    #00 i = 8'b00;
    #10 i = 8'b01;
    #10 i = 8'b10;
    #10 i = 8'b11;
    #10 $stop;
  end
  e5a2 U1(o, eP, i);
endmodule

// Design

module e5a2(output [3:0]o, input enablePin, [1:0]i);
  assign o[0] = (~i[0]&~i[1])^enablePin;
  assign o[1] = ( i[0]&~i[1])^enablePin;
  assign o[2] = (~i[0]& i[1])^enablePin;
  assign o[3] = ( i[0]& i[1])^enablePin;
endmodule

// Code by arcenter
// https://github.com/arcenter/UniCode/
