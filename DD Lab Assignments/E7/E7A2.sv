// Code by arcenter
// https://github.com/arcenter/UniCode/

// Testbench

module tb;
  reg A, B, C;
  wire D;
  initial begin 
    $dumpfile("dump.vcd");
    $dumpvars(1, tb);
    A = 0;
    B = 0;
    C = 1;
    #20 $stop;
  end 
  always #5 A = ~A;
  circuit U1(D, A, B, C);
endmodule

// Design

module circuit(output D, input A, B, C);
	assign D = A ? B : C;  
endmodule

// Code by arcenter
// https://github.com/arcenter/UniCode/