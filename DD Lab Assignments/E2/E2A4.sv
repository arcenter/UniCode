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

module notGate(output reg o, input i);
  always @ (i) begin
    if (i == 0)
      #1 o = 1;
    else
      #1 o = 0;
  end
endmodule

// Code by arcenter
// https://github.com/arcenter/UniCode/
