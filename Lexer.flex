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
[S|s][E|e][L|l][E|e][C|c][T|t] |
[F|f][R|r][O|o][M|m] |
[W|w][H|h][E|e][R|r][E|e] {lexeme=yytext(); return Reservada;}
{espacio} {/*Ignore*/}
"//".* {/*Ignore*/}
{L}({L}|{D})* {lexeme=yytext(); return Identificador;}
 . {return ERROR;}