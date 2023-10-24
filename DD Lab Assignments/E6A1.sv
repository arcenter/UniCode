// Code by arcenter
// https://github.com/arcenter/UniCode/

// Testbench

module tb;
  reg [3:0]d;
  reg [1:0]i;
  wire o;
  initial begin
    $dumpfile("dump.vcd");
    $dumpvars(1, tb);
    #00 d = 4'b0010;
    #00 i = 2'b00;
    #10 i = 2'b01;
    #10 i = 2'b10;
    #10 i = 2'b11;
    #10 d = 4'b0100;
    #00 i = 2'b00;
    #10 i = 2'b01;
    #10 i = 2'b10;
    #10 i = 2'b11;
    #10 $stop;
  end
  mux41 U1(o, d, i);
endmodule

// Design

module mux41(output o, input [3:0]d, [1:0]i);
  wire p, q, r, s;
  assign p = (~i[0]&~i[1]&d[0]);
  assign q = (i[0]&~i[1]&d[1]);
  assign r = (~i[0]&i[1]&d[2]);
  assign s = (i[0]&i[1]&d[3]);
  assign o = p|q|r|s;
endmodule

// Code by arcenter
// https://github.com/arcenter/UniCode/
