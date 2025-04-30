%{
	#include <stdio.h>
	#include "y.tab.h"
%}

%%
#include<[a-z]+\.h> { return HEADER; }
int { return INT; }
float { return FLOAT; }
double { return DOUBLE; }
char { return CHARA; }

main { return MAIN; }
\( { return LB; }
\) { return RB; }
\{ { return LCB; }
\} { return RCB; }

if
while
do
for

if.+ { return VAR; }
while.+ { return VAR; }
do.+ { return VAR; }
for.+ { return VAR; }

[a-zA-Z] { strcpy(yylval.string, yytext); return VAR; }
; { return SC; }
, { return COMA; }

= { return EQ; }

\+ { strcpy(yylval.string, "+"); return PLUS; }
\- { strcpy(yylval.string, "-"); return MINUS; }
\* { strcpy(yylval.string, "*"); return MULT; }
\/ { strcpy(yylval.string, "/"); return DIV; }

.
%%

int yywrap() {
	return 1;
}
