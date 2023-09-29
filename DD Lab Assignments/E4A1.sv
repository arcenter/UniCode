// Code by arcenter
// https://github.com/arcenter/UniCode/

// Testbench

module tb;
  reg [7:0] in;
  wire [7:0] o;
  initial begin
    $dumpfile("dump.vcd");
    $dumpvars(1, tb);
    #00 in = 8'b00000000;
    #10 in = 8'b11011101;
    #10 in = 8'b10101010;
    #10 in = 8'b01100110;
    #10 in = 8'b10011001;
    #10 in = 8'b10111011;
    #10 in = 8'b11111111;
    #10 $stop;
  end
  e4a1 U1(o, in);
endmodule

// Design

module e4a1(output [7:0]o, input [7:0]i);
  assign o[0] = i[1]^i[0];
  assign o[1] = i[2]^i[1];
  assign o[2] = i[3]^i[2];
  assign o[3] = i[4]^i[3];
  assign o[4] = i[5]^i[4];
  assign o[5] = i[6]^i[5];
  assign o[6] = i[7]^i[6];
  assign o[7] = i[7];
endmodule

// Code by arcenter
// https://github.com/arcenter/UniCode/
