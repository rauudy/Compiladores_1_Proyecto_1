/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto1c;

import java.util.ArrayList;
import java.util.List;
import java_cup.runtime.Symbol;

/**
 *
 * @author infor
 */
public class TokenReporter {
private List<TokenInfo> tokens = new ArrayList<>();

    public void addToken(Symbol symbol, String lexeme) {
        tokens.add(new TokenInfo(
            tokens.size() + 1,
            lexeme,
            sym.terminalNames[symbol.sym],
            symbol.left + 1,
            symbol.right + 1
        ));
    }

    public String generateHtmlReport() {
        StringBuilder html = new StringBuilder();
        html.append("<html><head>");
        html.append("<link rel=\"stylesheet\" href=\"estilo.css\">");
        html.append("</head><body>");
        html.append("<h2>Token Report</h2>");
        html.append("<table>");
        html.append("<tr><th>#</th><th>Lexema</th><th>Tipo</th><th>Línea</th><th>Columna</th></tr>");

        for (TokenInfo token : tokens) {
            html.append(String.format("<tr><td>%d</td><td>%s</td><td>%s</td><td>%d</td><td>%d</td></tr>",
                token.id, token.lexeme, token.type, token.line, token.column));
        }

        html.append("</table></body></html>");
        return html.toString();
    }

    private static class TokenInfo {
        int id;
        String lexeme;
        String type;
        int line;
        int column;

        TokenInfo(int id, String lexeme, String type, int line, int column) {
            this.id = id;
            this.lexeme = lexeme;
            this.type = type;
            this.line = line;
            this.column = column;
        }
    }
}