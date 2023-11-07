// Code by arcenter
// https://github.com/arcenter/UniCode/

// Testbench

module tb;
  reg t;
  wire q;
  reg clk = 0;
  always #2 clk = ~clk;
  initial begin 
    $dumpfile("dump.vcd");
    $dumpvars(1, tb);
    t=0;
    #2 t=1;
    #2 t=1;
    #5 t=0;
    #5 t=1;
    #5 $stop;
  end
  tff U1(q, t, clk);
endmodule

// Design

module tff(output reg q, input t, clk);
  initial q=0;
  always @ (posedge clk) begin
    if(t==1)
      q=~q;
    else 
      q=q;
  end 
endmodule

// Code by arcenter
// https://github.com/arcenter/UniCode/