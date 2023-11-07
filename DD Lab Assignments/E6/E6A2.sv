// Code by arcenter
// https://github.com/arcenter/UniCode/

// Testbench

module tb;
  reg x, y;
  wire o;
  initial begin
    $dumpfile("dump.vcd");
    $dumpvars(1, tb);
    #00 x = 0; y = 0;
    #10 x = 0; y = 1;
    #10 x = 1; y = 0;
    #10 x = 1; y = 1;
    #10 $stop;
  end
  mux21 U1(o, y, ~y, x);
endmodule

// Design

module mux21 (output Y, input D0, D1, S0);
  wire p, q;
  assign p = D0 & ~S0;
  assign q = D1 & S0;
  assign Y = p | q;
endmodule

// Code by arcenter
// https://github.com/arcenter/UniCode/
