%{
	#include <stdio.h>
	#include "y.tab.h"
%}

%%
\= { return EQ; }
\+ { return PLUS; }
[0-9]+ { yylval.number = atoi(yytext); return NUM; }
nil { return NIL; }
e[a-f]x { yylval.variable = yytext[1]; return REGISTER; }
[a-zA-Z] { yylval.variable = yytext[0]; return CHAR; }
.
%%

int yywrap() {
	return 1;
}
