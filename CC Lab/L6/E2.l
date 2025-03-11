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

[a-zA-Z][a-zA-Z_0-9]* { return VAR; }
; { return SC; }
, { return COMA; }

= { return EQ; }

\+ { return PLUS; }
\- { return MINUS; }
\* { return MULT; }
\/ { return DIV; }

.
%%

int yywrap() {
	return 1;
}
