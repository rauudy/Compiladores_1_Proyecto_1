/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package proyecto1c;

import java.io.FileWriter;
import proyecto1c.contracts.IStatement;
import proyecto1c.symbols.SymTable;
import java.io.StringReader;
import java.util.LinkedList;
import java.util.logging.Level;
import java.util.logging.Logger;
import java_cup.runtime.Scanner;
import vistasprimer.Analyzer;

/**
 *
 * @author infor
 */
public class Proyecto1C {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        Analyzer an = new Analyzer();
        an.setVisible(true);
        an.setLocationRelativeTo(null);
        
        
        /*
        String input1 = """
                            {
                            	# Definimos conjuntos
                            	CONJ : conjA -> 0~4;
                            	CONJ : conjB -> 2,4,5,a,A;
                            	
                            	# Creamos operaciones
                            	OPERA : operacion1 -> & {conjA}{conjB};
                            	OPERA : operacion2 -> ^^^{conjA};
                            	
                            	# Evaluamos elementos
                            	EVALUAR({1,5}, operacion1);
                            	EVALUAR({5,A}, operacion2);
                            	
                            }
                            
                            # Salida en consola
                            <!
                            ====================
                            Evaluar: operacion1
                            ====================
                            1 -> fallo
                            2 -> fallo
                            
                            ====================
                            Evaluar: operacion2
                            ====================
                            5 -> exitoso
                            A -> exitoso
                            !>
                            
                            # JSON de salida
                            <!
                            
                            {
                            	"operacion1":"No se puede simplificar la operacion",
                            	"operacion2":{
                            		"leyes":[
                            			"Ley de doble complemento"
                            		],
                            		"conjunto simplificado": "^{conjA}"
                            	}
                            }
                            !>
                        """;

        //****************************************
        try {
            Lexer lexer = new Lexer(new StringReader(input1));
            Parser parser = new Parser(lexer);
            parser.parse();

            // Combinar errores léxicos y sintácticos
            parser.syntaxErrors.addAll(lexer.getLexicalErrors());

            // Generar reporte de errores
            parser.generateErrorReport("error_report.html");

        } catch (Exception e) {
            e.printStackTrace();
        }
        //****************************************

        //----------------------------------------------------
        try {
            Lexer lexer = new Lexer(new StringReader(input1));
            LexerWrapper lexerWrapper = new LexerWrapper(lexer);

            Parser parser = new Parser(lexerWrapper);  // Ya no es necesario el casting
            parser.parse();

            // Generar y guardar el reporte HTML
            String htmlReport = lexerWrapper.getTokenReporter().generateHtmlReport();
            try (FileWriter writer = new FileWriter("token_report.html")) {
                writer.write(htmlReport);
            }

            System.out.println("Analisis completado. El reporte de tokens se ha guardado en 'token_report.html'.");

        } catch (Exception e) {
            e.printStackTrace();
        }

        //----------------------------------------------------
        Lexer scanner = new Lexer(new StringReader(input1));
        Parser parser = new Parser(scanner);
        LinkedList<IStatement> AST = null;
        SymTable environment = new SymTable();

        try {
            parser.parse();
            AST = parser.AST;
        } catch (Exception ex) {
            // Capturar cualquier excepción durante el proceso de parsing
            System.out.println("Excepción capturada: " + ex.getMessage());
            System.out.println("\n\n");
        } finally {
            // Ahora se imprime tanto errores léxicos como sintácticos al final del parsing
            if (!scanner.lexicalErrors.isEmpty()) {
                System.out.println("Errores lexicos:");
                for (String err : scanner.lexicalErrors) {
                    System.out.println(err); // Usar System.out en lugar de System.err
                }
                System.out.println("\n\n");

            }

            if (!parser.syntaxErrors.isEmpty()) {
                System.out.println("Errores sintacticos:");
                for (String err : parser.syntaxErrors) {
                    System.out.println(err); // Usar System.out en lugar de System.err
                }
                System.out.println("\n\n");

            }

            // Si no hubo errores fatales, ejecutar los AST
            if (AST != null && parser.syntaxErrors.isEmpty()) {
                System.out.println("Console:\n");
                for (IStatement s : AST) {
                    s.execute(environment);
                }
                //System.out.println("\n\n");

                //System.out.println("Tablas de simbolos:");
                // Imprime todas las tablas de símbolos creadas
                //environment.printAllScopes();
                //System.out.println("\n\n");
                StringBuilder str = new StringBuilder();
                str.append("""
                           digraph G {
                           rootNode [label="Raiz"];
                           node[shape="rectangle"];
                           splines=polyline;
                           concentrate=true;
                           """);

                for (IStatement s : AST) {

                    str.append(s.graph());
                    str.append("rootNode -> S_").append(s.getId()).append(";\n");
                }

                str.append("}");

                //System.out.println("Graphviz:");
                //System.out.println(str);
            }
        }
        */
    }
    

}
