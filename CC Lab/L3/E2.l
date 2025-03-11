%{
	#include <stdio.h>
	#include <string.h>

	int words = 0;
	int lines = 0;
	int chars = 0;
%}

%%
\n {
	lines++;
}

[a-zA-Z]+ {
	words++;
	chars += yyleng;
}

. {
	chars++;
}
%%

int main() {
	yylex();
	printf("Words = %d, characters = %d, lines = %d\n", words, chars, lines);	
	return 0;
}

int yywrap() {
	return 1;
}
