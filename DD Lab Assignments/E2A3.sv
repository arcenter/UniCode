// Code by arcenter
// https://github.com/arcenter/UniCode/

// Testbench

module tb_not;
  reg i;
  wire o;
  initial begin
    $dumpfile("dump.vcd");
    $dumpvars(1, tb_not);
    #00 i = 0;
    #10 i = 1;
    #10 i = 0;
    #10 i = 1;
    #10 $stop;
  end
  notGate U1(o, i);
endmodule

// Design

module notGate(output o, input i);
  assign #1 o = ~i;
endmodule

// Code by arcenter
// https://github.com/arcenter/UniCode/
