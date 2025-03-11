%{
	#include <stdio.h>
	#include <stdlib.h>
	int yylex(void);
	void yyerror(char*);
%}

%token HEADER INT MAIN LB RB LCB RCB
%token SC COMA VAR
%token PLUS MINUS MULT DIV EQ
%token FLOAT DOUBLE CHARA

%%

PGM : HEADER INT MAIN LB RB LCB BODY RCB { printf("Success\n"); }

BODY : DECL_STMTS PROG_STMTS

DECL_STMTS : DECL_STMT DECL_STMTS | DECL_STMT
PROG_STMTS : PROG_STMT PROG_STMTS | PROG_STMT

DECL_STMT : DATATYPE VAR_LIST SC

DATATYPE : INT | FLOAT | DOUBLE | CHARA

VAR_LIST : VAR COMA VAR_LIST | VAR

PROG_STMT : VAR EQ A_EXPN SC

A_EXPN : A_EXPN OP A_EXPN | LB A_EXPN RB | VAR

OP : PLUS | MINUS | MULT | DIV

%%

void yyerror(char *s) {
	fprintf(stderr, "Error: %s\n", s);
	exit(1);
}

int main() {
	yyparse();
	return 0;
}
