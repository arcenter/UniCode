%{
	#include <stdio.h>
	#include <string.h>
%}

%%

[0-9]*[02468] printf("Even number with length %d\n", yyleng);
[0-9]*[13579] printf("Odd  number with length %d\n", yyleng);

.
%%

int main() {
	yylex();
	return 0;
}

int yywrap() {
	return 1;
}
