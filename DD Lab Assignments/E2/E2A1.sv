// Code by arcenter
// https://github.com/arcenter/UniCode/

// Testbench

module testbench;
  reg i1, i2, i3;
  wire o1, o2;
  initial begin
    $dumpfile("dump.vcd");
    $dumpvars(1, testbench);
    #00 i1 = 0;
    #00 i2 = 0;
    #00 i3 = 0;
    #10 i1 = 1;
    #10 i2 = 1; i1 = 0;
    #10 i1 = 1;
    #10 i3 = 1; i2 = 0; i1 = 0;
    #10 i1 = 1;
    #10 i2 = 1;
    #10 $stop;
  end
  nand3Input U1(o1, i1, i2, i3);
  xor3Input U2(o2, i1, i2, i3);
endmodule

// Design

module nand3Input(output o, input i1, i2, i3);
  wire w1, w2;
  and #2 G1(w1, i1, i2);
  and #2 G2(w2, w1, i3);
  not #1 (o, w2);
endmodule

module xor3Input(output o, input i1, i2, i3);
  wire w1;
  xor #2 (w1, i1, i2);
  xor #2 (o, w1, i3);
endmodule

// Code by arcenter
// https://github.com/arcenter/UniCode/
