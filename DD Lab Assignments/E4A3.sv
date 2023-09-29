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
    #10 a = 0; b = 0; bI = 1;
    #10 a = 0; b = 1; bI = 0;
    #10 a = 0; b = 1; bI = 1;
    #01 a = 1; b = 0; bI = 0;
    #10 a = 1; b = 0; bI = 1;
    #10 a = 1; b = 1; bI = 0;
    #10 a = 1; b = 1; bI = 1;
    #10 $stop;
  end
  e4a3 U1(o, bO, a, b, bI);
endmodule

// Design

module e4a3(output reg sum, reg bO, input a, b, bI);
  always @ (a or b or bI) begin
    if (b == bI)
      #0 sum = a;
    else
      #0 sum = ~a;
    if (a == 0) begin
      if (b | bI)
        #0 bO = 1;
      else
        #0 bO = 0;
    end else begin
      if (b & bI)
        #0 bO = 1;
      else
        #0 bO = 0;
    end
  end
endmodule

// Code by arcenter
// https://github.com/arcenter/UniCode/
