%{
        #include <stdio.h>
        #include <stdlib.h>
        #include <string.h>
        int yylex(void);
        void yyerror(char*);

        float variables[26];
%}

%union {
        float fval;
        int ival;
}

%type <fval> E

%token <fval> NUMBER
%token <ival> IDENTIFIER

%token PLUS MINUS MULT DIV NEWLINE POWER ASSIGN

%left PLUS MINUS
%left MULT DIV
%right POWER

%%
program : E NEWLINE { printf("Result = %f\n", $1); }
        | IDENTIFIER ASSIGN E NEWLINE { variables[$1] = $3; }
        | program E NEWLINE { printf("Result = %f\n", $2); }
        | program IDENTIFIER ASSIGN E NEWLINE { variables[$2] = $4; }
;

E : NUMBER { $$ = $1; }
  | IDENTIFIER { $$ = variables[$1]; }
  | E PLUS E { $$ = $1 + $3; }
  | E MINUS E { $$ = $1 - $3; }
  | E MULT E { $$ = $1 * $3; }
  | E DIV E { $$ = $1 / $3; }
  | E POWER E {
        int _ = 1;
        for (int i = 0; i < $3; i++) {
                _ = _ * $1;
        }
        $$ = _;
    }
  | MINUS E { $$ = -1 * $2; }
  ;
%%

void yyerror(char *s) {
        fprintf(stderr, "Error: %s\n", s);
        exit(1);
}

int main() {
        memset(variables, 0, sizeof(variables));
        yyparse();
        return 0;
}