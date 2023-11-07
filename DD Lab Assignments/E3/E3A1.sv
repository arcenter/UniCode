// Code by arcenter
// https://github.com/arcenter/UniCode/

// Testbench

module tb;
  reg in1;
  wire o;
  initial begin
    $dumpfile("dump.vcd");
    $dumpvars(1, tb);
    #00 in1 = 0;
    #10 in1 = 1;
    #10 $stop;
  end
  nandOnlyNot U1(o, in1);
endmodule

// Design

module nandOnlyNot(output o, input i1);
  nand n1(o, i1, i1);
endmodule

// Code by arcenter
// https://github.com/arcenter/UniCode/
