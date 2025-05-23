%{
        #include <stdio.h>
        #include "y.tab.h"
%}

%%
[0-9]+(\.[0-9]+)? {
        yylval.fval = atof(yytext);
        return NUMBER;
}
[a-z] {
        yylval.ival = *yytext;
        return IDENTIFIER;
}
= { return ASSIGN; }
\+ { return PLUS; }
\- { return MINUS; }
\* { return MULT; }
\/ { return DIV; }
\^ { return POWER; }
\n { return NEWLINE; }
.
%%

int yywrap() {
        return 1;
}