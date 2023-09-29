// Code by arcenter
// https://github.com/arcenter/UniCode/

// Testbench

module tb;
  reg a, b, bI;
  wire o, bO;
  initial begin
    $dumpfile("dump.vcd");
    $dumpvars(1, tb);
    #00 a = 0; b = 0; bI = 0;
    #10 a = 0; b = 1; bI = 0;
    #10 a = 0; b = 1; bI = 1;
    #10 $stop;
  end
  e4a2 U1(o, bO, a, b, bI);
endmodule

// Design

module e4a2(output sum, bO, input a, b, bI);
  assign sum = a ^ b ^ bI;
  assign bO  = ((~a&(b|bI))|(b&bI));
endmodule

// Code by arcenter
// https://github.com/arcenter/UniCode/
