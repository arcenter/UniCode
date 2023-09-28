// Code by arcenter
// https://github.com/arcenter/UniCode/

// Testbench

module tb;
  reg in1, in2, in3;
  wire o;
  initial begin
    $dumpfile("dump.vcd");
    $dumpvars(1, tb);
    #00 in1 = 0; in2 = 0; in3 = 0;
    #10 in1 = 1; in2 = 0; in3 = 1;
    #10 in1 = 0; in2 = 1; in3 = 1;
    #10 in1 = 1; in2 = 1; in3 = 1;
    #10 $stop;
  end
  e3a2 U1(o, in1, in2, in3);
endmodule

// Design

module e3a2(output o, input i1, i2, i3);
  assign o = (i1 & i2 & i3) | (i1 & i2) | (i1 & i3);
endmodule

// Code by arcenter
// https://github.com/arcenter/UniCode/
