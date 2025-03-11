%{
	#include <stdio.h>
	#include "y.tab.h"
%}

%%
#include<[a-z]+\.h> { return HEADER; }
int { return INT; }
main { return MAIN; }
\( { return LB; }
\) { return RB; }
\{ { return LCB; }
\} { return RCB; }

[a-z]+ { return VAR; }
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
