%{
	#include <stdio.h>
	#include <stdlib.h>
	#include <string.h>
	int yylex(void);
	void yyerror(char*);
	
	extern FILE *yyin;
	FILE *output_file;
%}

%token NUM CHAR EQ PLUS REGISTER NIL

%type <variable> OPND

%union {
	int number;
	char variable;
}

%%

PROG_STMTS : PROG_STMT PROG_STMTS | PROG_STMT

PROG_STMT : OP OPND I_OPND OPND { fprintf(output_file, "\n"); }

OP : EQ { fprintf(output_file, "movl "); }
   | PLUS { fprintf(output_file, "addl "); }

OPND : NUM { fprintf(output_file, "$%d ", $$); }
     | CHAR { fprintf(output_file, "%c(%%rip) ", $$); }
	 | REGISTER { fprintf(output_file, "%%e%cx ", $$); }
	 | NIL

I_OPND : NUM { fprintf(output_file, ", "); }
     | CHAR { fprintf(output_file, ", "); }
	 | REGISTER { fprintf(output_file, ", "); }
	 | NIL { fprintf(output_file, ", "); }

%%

void yyerror(char *s) {
	fprintf(stderr, "Error: %c\n", s);
	exit(1);
}

int main() {
	output_file = fopen("quad.s", "w");
	fprintf(output_file, ".section .data\nmsg:\n    .string \"Final result of LHS var = %%d\\n\"\n.section .bss\n    .lcomm a, 4    \n    .lcomm b, 4\n    .lcomm c, 4\n    .lcomm d, 4\n    .lcomm e, 4\n    .lcomm f, 4\n    .lcomm z, 4\n.section .text\n.globl main\nmain:\n    pushq %%rbp\n    movq %%rsp, %%rbp\n\n");

	yyin = fopen("quad.in", "r");
	yyparse();
	fclose(yyin);

	fprintf(output_file, "\nmovl z(%%rip), %%esi\nleaq msg(%%rip), %%rdi\nmovl $0, %%eax\ncall printf\n\nmovl $0, %%eax\npopq %%rbp\nret");
	return 0;
}