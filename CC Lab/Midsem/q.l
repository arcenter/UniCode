%{
    #include <stdio.h>
    #include "y.tab.h"
%}

%%
[0-9]+ { yylval.fval = atof(yytext); return NUMBER; }
pi { return PI; }

\( { return LB; }
\) { return RB; }

log { return LOG; }
sin { return SIN; }
cos { return COS; }
sqrt { return SQRT; }

\- { return MINUS; }

\n { return NEWLINE; }
%%

int yywrap() {
    return 1;
}
