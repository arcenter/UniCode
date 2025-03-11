%{
	#include <stdio.h>
	#include <stdlib.h>
	int yylex(void);
	void yyerror(char*);
%}

%token NUMBER PLUS MINUS MULT DIV NEWLINE
%left PLUS MINUS
%left MULT DIV

%%
program : E NEWLINE { printf("Result = %d\n", $1); }
        | program E NEWLINE { printf("Result = %d\n", $2); }
;

E : NUMBER { $$ = $1; }
  | E PLUS E { $$ = $1 + $3; }
  | E MINUS E { $$ = $1 - $3; }
  | E MULT E { $$ = $1 * $3; }
  | E DIV E { $$ = $1 / $3; }
  ;
%%

void yyerror(char *s) {
	fprintf(stderr, "Error: %s\n", s);
	exit(1);
}

int main() {
	yyparse();
	return 0;
}
