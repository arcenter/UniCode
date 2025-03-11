%{
	#include <stdio.h>
	#include <string.h>
%}

%%
\+ printf("Operator PLUS found\n");
\- printf("Operator MINUS found\n");
\* printf("Operator MUL found\n");
\/ printf("Operator DIV found\n");
\| printf("Operator ABS found\n");
[0-9]+ printf("Operator NUMBER found\n");
\n printf("Operator NEWLINE found\n");
. printf("Operator MYSTERY CHAR found\n");
%%

int main() {
	yylex();
	return 1;
}

int yywrap() {
	return 1;
}
