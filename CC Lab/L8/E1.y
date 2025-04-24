%{
	#include <stdio.h>
	#include <stdlib.h>
	#include <string.h>
	int yylex(void);
	void yyerror(char*);

	struct symbol_table {
		int used;
		char var_name[30];
	} var_list[52];

	int alphabet_count = 0;

	char alphabets[26];
%}

%token HEADER INT MAIN LB RB LCB RCB
%token SC COMA
%token <string> PLUS MINUS MULT DIV EQ
%token FLOAT DOUBLE CHARA

%token <string> VAR
%type <string> OP
%type <value> A_EXPN

%left PLUS MINUS
%left MULT DIV

%union {
	int value;
	char string[30];
}

%%

PROG_STMTS : PROG_STMT PROG_STMTS | PROG_STMT

DATATYPE : INT | FLOAT | DOUBLE | CHARA

VAR_LIST : VAR COMA VAR_LIST | VAR

PROG_STMT : VAR EQ A_EXPN SC { printf("%s := %s\n", $1, var_list[$3].var_name); }

A_EXPN : A_EXPN OP A_EXPN {
			int i = 0;
			for (i = 0; i < 52; i++) {
				if (var_list[i].used == 0) {
					break;
				}
			}

			char alphabet = alphabets[alphabet_count++];
			printf("%c := %s %s %s\n", alphabet, var_list[$1].var_name, $2, var_list[$3].var_name);

			var_list[i].used = 1;
			var_list[i].var_name[0] = alphabet;

			$$ = i;
		}
       | LB A_EXPN RB { $$ = $2; }
	   | VAR {
			int i = 0;
			for (i = 0; i < 26; i++) {
				if (var_list[i].used == 0) {
					break;
				}
			}
			strcpy(var_list[i].var_name, $1);
			var_list[i].used = 1;
			$$ = i;
	   }

OP : PLUS { strcpy($$, $1); }
   | MINUS { strcpy($$, $1); }
   | MULT { strcpy($$, $1); }
   | DIV { strcpy($$, $1); }

%%

void yyerror(char *s) {
	fprintf(stderr, "Error: %s\n", s);
	exit(1);
}

int main() {
	strcpy(alphabets, "ABCDEFGHIJKLMNOPQRSTUVWXYZ");
	yyparse();
	return 0;
}
