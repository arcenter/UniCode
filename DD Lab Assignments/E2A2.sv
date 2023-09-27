// Code by arcenter
// https://github.com/arcenter/UniCode/

// Testbench

module tb_oc;
  reg [7:0] in = 8'b00000000;
  wire [7:0] o;
  initial begin
    $dumpfile("dump.vcd");
    $dumpvars(1, tb_oc);
    for(int i = 0; i < 8; i+=1)
      #5 in = ((in<<1) + 1);
    #5 $stop;
  end
  onesCompliment U1(o, in);
endmodule

// Design

module onesCompliment(output [7:0] o, input [7:0] in);
  assign o = ~in;
endmodule

// Code by arcenter
// https://github.com/arcenter/UniCode/
