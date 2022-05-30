package main;
import static main.Tokens.*;
%%
%class Lexer
%type Tokens
L=[a-zA-Z]+
D=[0-9]+
espacio=[ ,\t,\r,\n]+
%{
    public String lexeme;
%}
%%
(?i:select) |
(?i:from) |
(?i:where) {lexeme=yytext(); return Reservada;}
{espacio} {/*Ignore*/}
"//".* {/*Ignore*/}
{L}({L}|{D})* {lexeme=yytext(); return Identificador;}
 . {return ERROR;}