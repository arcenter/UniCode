// Code by arcenter
// https://github.com/arcenter/UniCode/

// Testbench

module tb;
  reg [3:0] in;
  wire [4:0]o;
  initial begin
    $dumpfile("dump.vcd");
    $dumpvars(1, tb);
    #00 in = 4'b0000;
    #10 in = 4'b1101;
    #10 in = 4'b1010;
    #10 in = 4'b0110;
    #10 in = 4'b1001;
    #10 in = 4'b1011;
    #10 in = 4'b1111;
    #10 $stop;
  end
  e3a4 U1(o, in);
endmodule

// Design

module e3a4(output [4:0]o, input [3:0]i);
  assign o[0] = i[0];
  assign o[1] = i[1];
  assign o[2] = i[2];
  assign o[3] = i[3];
  assign o[4] = (((i[0] ^ i[1]) ^ i[2]) ^ i[3]);
endmodule

// Code by arcenter
// https://github.com/arcenter/UniCode/
