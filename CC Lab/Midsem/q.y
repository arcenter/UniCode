%{
    #include <stdio.h>
    #include <stdlib.h>
    #include <math.h>
    int yylex(void);
    void yyerror(char*);
%}

%union {
    float fval;
}

%type <fval> E
%token <fval> NUMBER

%token LB RB LOG SIN COS SQRT MINUS NEWLINE PI
%right MINUS

%%

program : E NEWLINE { printf("Result = %f\n", $1); }
        | program E NEWLINE { printf("Result = %f\n", $2); }
;

E : NUMBER { $$ = yylval.fval; }
  | PI { $$ = 3.1416; }
  | MINUS E { $$ = -1 * $2; }
  | LOG LB E RB { $$ = log($3); }
  | SIN LB E RB { $$ = sin($3); }
  | COS LB E RB { $$ = cos($3); }
  | SQRT LB E RB { $$ = sqrt($3); }
  | LB E RB { $$ = $2; }
;
%%

void yyerror(char *s) {
    fprintf(stderr, "Error: %s\n", s);
    exit(0);
}

int main() {
    yyparse();
    return 1;
}
