%{
	#include <stdio.h>
	#include "y.tab.h"
%}

%%
[0-9]+ {
	yylval = atoi(yytext);
	return NUMBER;
}
\+ { return PLUS; }
\- { return MINUS; }
\* { return MULT; }
\/ { return DIV; }
\n { return NEWLINE; }
.
%%

int yywrap() {
	return 1;
}
