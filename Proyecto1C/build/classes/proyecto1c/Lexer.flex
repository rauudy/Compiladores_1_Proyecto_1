package proyecto1c;

import java.util.LinkedList;
import java_cup.runtime.Symbol;

%%

%class Lexer
%public
%unicode
%cup
%line
%char
%ignorecase

%{
    public LinkedList<String> lexicalErrors = new LinkedList<>();

    public void reportError(String message) {
        lexicalErrors.add(String.format("Error léxico en línea %d, columna %d: %s", yyline + 1, yycolumn + 1, message));
    }

    public LinkedList<String> getLexicalErrors() {
        return lexicalErrors;
    }
%}

%state MULTILINE_COMMENT

%%

<YYINITIAL> {
    "CONJ"             { return new Symbol(sym.CONJ, yyline, (int) yychar, yytext()); }
    "OPERA"            { return new Symbol(sym.OPERATION, yyline, (int) yychar, yytext()); }
    "EVALUAR"          { return new Symbol(sym.EVALUATION, yyline, (int) yychar, yytext()); }
    "SCOPE"            { return new Symbol(sym.SCOPE, yyline, (int) yychar, yytext()); }

    "U"                { return new Symbol(sym.UNION, yyline, (int) yychar, yytext()); }
    "&"                { return new Symbol(sym.INTERSEC, yyline, (int) yychar, yytext()); }
    "-"                { return new Symbol(sym.DIFF, yyline, (int) yychar, yytext()); }
    "^"                { return new Symbol(sym.COMPLEMENT, yyline, (int) yychar, yytext()); }
    [0-9]+             { return new Symbol(sym.NUMBER, yyline, (int) yychar, yytext()); }
    [a-zA-Z]           { return new Symbol(sym.LETTER, yyline, (int) yychar, yytext()); }
    [A-Za-z][A-Za-z0-9_]* { return new Symbol(sym.VAR, yyline, (int) yychar, yytext()); }
    "{"                { return new Symbol(sym.LBRACE, yyline, (int) yychar, yytext()); }
    "}"                { return new Symbol(sym.RBRACE, yyline, (int) yychar, yytext()); }
    ":"                { return new Symbol(sym.COLON, yyline, (int) yychar, yytext()); }
    ","                { return new Symbol(sym.COMMA, yyline, (int) yychar, yytext()); }
    "("                { return new Symbol(sym.LPAREN, yyline, (int) yychar, yytext()); }
    ")"                { return new Symbol(sym.RPAREN, yyline, (int) yychar, yytext()); }
    "->"               { return new Symbol(sym.ARROW, yyline, (int) yychar, yytext()); }
    ";"                { return new Symbol(sym.SEMICOLON, yyline, (int) yychar, yytext()); }
    "~"                { return new Symbol(sym.RANGE, yyline, (int) yychar, yytext()); }

    [\x21-\x7E]        { return new Symbol(sym.ASCII_CHAR, yyline, (int) yychar, yytext()); }

    #([^\n]*)          { /* Ignorar comentario de una línea */ }
    "<!"               { yybegin(MULTILINE_COMMENT); }

    \n                 { yychar=0; }
    [ \t\r\f]+         { /* Ignorar espacios en blanco */ }

    .                  { lexicalErrors.add("Illegal character '" + yytext() + "' at line " + yyline + ", column " + yychar); 
                         return new Symbol(sym.error);  }
}

<MULTILINE_COMMENT> {
    "!>"               { yybegin(YYINITIAL); }
    [^]                { /* Ignorar todo dentro del comentario multilínea */ }
}