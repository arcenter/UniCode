// Code by arcenter
// https://github.com/arcenter/UniCode/

// Testbench

module tb;
  reg [3:0]D;
  reg [1:0]S;
  wire Q;
  initial begin
    $dumpfile("dump.vcd");
    $dumpvars(1, tb);
    #00 S = 2'b00;
    #00 D = 4'b0001;
    #10 D = 4'b0100;
    #10 S = 2'b01;
    #00 D = 4'b0100;
    #10 D = 4'b0010;
    #10 S = 2'b10;
    #00 D = 4'b1000;
    #10 D = 4'b0001;
    #10 S = 2'b11;
    #00 D = 4'b0100;
    #10 D = 4'b0001;
    #10 $stop;
  end
  mux2141 U1(Q, D, S);
endmodule

// Design

module mux21 (output Y, input D0, D1, S0);
  wire p, q;
  assign p = D0 & ~S0;
  assign q = D1 & S0;
  assign Y = p | q;
endmodule

module mux2141(output Q, input [3:0]D, [1:0]S);
  wire p, q;
  mux21 m1(p, D[0], D[1], S[0]);
  mux21 m2(q, D[2], D[3], S[0]);
  mux21 m3(Q, p, q, S[1]);
endmodule

// Code by arcenter
// https://github.com/arcenter/UniCode/
