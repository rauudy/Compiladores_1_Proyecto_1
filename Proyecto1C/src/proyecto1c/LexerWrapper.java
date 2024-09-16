/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto1c;


import java_cup.runtime.Scanner;
import java_cup.runtime.Symbol;

/**
 *
 * @author infor
 */
public class LexerWrapper implements Scanner {
    private Lexer lexer;
    private TokenReporter tokenReporter;

    public LexerWrapper(Lexer lexer) {
        this.lexer = lexer;
        this.tokenReporter = new TokenReporter();
    }

    @Override
    public Symbol next_token() throws Exception {
        Symbol symbol = lexer.next_token();
        if (symbol != null) {
            tokenReporter.addToken(symbol, lexer.yytext());
        }
        return symbol;
    }

    public TokenReporter getTokenReporter() {
        return tokenReporter;
    }

    
}