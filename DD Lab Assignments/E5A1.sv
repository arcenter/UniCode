// Code by arcenter
// https://github.com/arcenter/UniCode/

// Testbench

module tb;
  reg [7:0]i;
  wire [2:0]o;
  initial begin
    $dumpfile("dump.vcd");
    $dumpvars(1, tb);
    #00 i = 8'b10000000;
    #10 i = 8'b01000000;
    #10 i = 8'b00100000;
    #10 i = 8'b00010000;
    #10 i = 8'b00001000;
    #10 i = 8'b00000100;
    #10 i = 8'b00000010;
    #10 i = 8'b00000001;
    #10 $stop;
  end
  e5a1 U1(o, i);
endmodule

// Design

module e5a1(output reg [2:0]o, input [7:0]i);
  always @ (*) begin
    if (i[7] == 1) o = 3'b000;
    else if (i[6] == 1) o = 3'b001;
    else if (i[5] == 1) o = 3'b010;
    else if (i[4] == 1) o = 3'b011;
    else if (i[3] == 1) o = 3'b100;
    else if (i[2] == 1) o = 3'b101;
    else if (i[1] == 1) o = 3'b110;
    else if (i[0] == 1) o = 3'b111;
    else o = 3'bxxx;
  end
endmodule

// Code by arcenter
// https://github.com/arcenter/UniCode/
