%{
	#include <stdio.h>
	#include <stdlib.h>
	#include <string.h>
	int yylex(void);
	int yyerror(const char *s);
	
	int success = 1;
	int current_data_type;
	int expn_type = -1;
	int temp;
	
	struct symbol_table {
		int used;
		char var_name[30];
		int type;
	} var_list[20];
	// you may associate an integer with a datatype (say var_list[i].type=1 may imply that variable var_list[i].var_name is of type int)
	// and store that integer against the variable whenever you deal with a declaration statement
	
	int var_count = -1;
	//number of entries in the symbol table
	
	extern int lookup_in_table(char var[30]);
	// returns the data type associated with the variable name being passed to
	// returns -1 if in case the variable is undeclared
	
	extern void insert_to_table(char var[30], int type);
	// adds a new variable along with its data type to the table and terminates with a "multiple declaration error message"
	// if in case the variable is already being defined

	extern FILE *yyin;
%}

%union {
	int data_type;
	char var_name[30];
}

%token HEADER MAIN LB RB LCB RCB SC COMA EQ OP

%token <var_name> VAR

%token <data_type> INT
%token <data_type> CHAR
%token <data_type> FLOAT
%token <data_type> DOUBLE

%type <data_type> DATA_TYPE
%start prm

%%
prm : HEADER INT MAIN LB RB LCB BODY RCB { printf("Parsing successful\n"); }

BODY : DECLARATION_STATEMENTS PROGRAM_STATEMENTS

DECLARATION_STATEMENTS : DECLARATION_STATEMENT DECLARATION_STATEMENTS { printf("Declaration section successfully parsed\n"); }
                       | DECLARATION_STATEMENT

PROGRAM_STATEMENTS : PROGRAM_STATEMENT PROGRAM_STATEMENTS { printf("Program statements successfully parsed\n"); }
                   | PROGRAM_STATEMENT

DECLARATION_STATEMENT: DATA_TYPE VAR_LIST SC

VAR_LIST : VAR COMA VAR_LIST { insert_to_table($1,current_data_type); }
         | VAR { insert_to_table($1,current_data_type); }

PROGRAM_STATEMENT : VAR EQ A_EXPN SC {
						if ((temp=lookup_in_table($1))!=-1) {
							if (expn_type==-1) {
								expn_type=temp;
							} else if (expn_type!=temp) {
								printf("Type mismatch in the expression\n");
								exit(0);
							}
						} else {
							printf("Variable \"%s\" undeclared\n",$1);
							exit(0);
						};
						expn_type=-1;
					}

A_EXPN : A_EXPN OP A_EXPN
		| LB A_EXPN RB
		| VAR {
			if ((temp=lookup_in_table($1))!=-1) {
				if (expn_type==-1) {
					expn_type=temp;
				} else if (expn_type!=temp) {
					printf("Type mismatch in the expression\n");
					exit(0);
				}
			} else {
				printf("Variable \"%s\" undeclared\n",$1);
				exit(0);
			}
		}

DATA_TYPE : INT { $$ = $1; current_data_type = $1; }
          | CHAR  { $$ = $1; current_data_type = $1; }
		  | FLOAT { $$ = $1; current_data_type = $1; }
		  | DOUBLE { $$ = $1; current_data_type = $1; }

%%

int lookup_in_table(char var[30]) {
	for (int i = 0; i <= 30; i++) {
		if (strcmp(var_list[i].var_name, var) == 0) {
			return var_list[i].type;
		}
	}
	return -1;
}

void insert_to_table(char var[30], int type) {
	if (lookup_in_table(var) == -1) {
		int i = 0;
		for (; i <= 30; i++) {
			if (var_list[i].used == 0)
				break;
		}

		var_list[i].used = 1;
		snprintf(var_list[i].var_name, 30, var);
		var_list[i].type = type;
	} else {
		printf("Variable %s already declared\n", var);
		exit(0);
	}
}


int main() {
	printf("Enter filename: ");
	char *filename[30];
	scanf("%30s", filename);
	printf("\nParsing file %s\n", filename);
	yyin = fopen(filename, "r");
	yyparse();
	if (success)
		printf("Parsed %s Successfully\n", filename);
	fclose(yyin);
	return 0;
}

int yyerror(const char *msg) {
	extern int yylineno;
	printf("Parsing Failed\nLine Number: %d %s\n",yylineno,msg);
	success = 0;
}

// flex project.l && bison project.y -d && "C:\Program Files\mingw64\bin\gcc.exe" lex.yy.c project.tab.c && cls && a.exe