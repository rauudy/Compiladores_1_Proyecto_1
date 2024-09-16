/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto1c.operations;

import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import proyecto1c.contracts.IStatement;
import proyecto1c.symbols.SymTable;

/**
 *
 * @author infor
 */
public class SetEvaluation extends IStatement {

    private final Set<Comparable> elements;
    private final String operationName;

    public SetEvaluation(Set<Comparable> elements, String operationName) {
        this.elements = elements;
        this.operationName = operationName;
    }

    @Override
    public void execute(SymTable table) {
        Set<Comparable> operationResult = table.get(operationName);
        if (operationResult == null) {
            System.out.println("___________________________");
            System.out.println("Error: La operacion -> " + operationName + " NO esta definida.");
            System.out.println("___________________________");
            return;
        }
        /*
        System.out.println("Evaluando elementos " + elements + " en la operacion " + operationName);
        for (Comparable element : elements) {
            if (operationResult.contains(element)) {
                System.out.println("El elemento " + element + " SI esta en el resultado de " + operationName);
            } else {
                System.out.println("El elemento " + element + " NO esta en el resultado de " + operationName);
            }
        }
         */
        System.out.println("===========================");
        System.out.println("Evaluar: " + operationName);
        System.out.println("===========================");
        for (Comparable element : elements) {
            if (operationResult.contains(element)) {
                System.out.println(element + " -> EXITO");
            } else {
                System.out.println(element + " -> FALLO");
            }
        }
        System.out.println("");
        
        
        // Nombre del archivo en el que quieres guardar la salida
        String fileName = "consola.txt";
        
        // Abre el archivo para escribir en modo de anexado
        try (PrintWriter writer = new PrintWriter(new FileWriter(fileName, true))) {

            // Escribe en el archivo
            writer.println("===========================");
            writer.println("Evaluar: " + operationName);
            writer.println("===========================");
            for (Comparable element : elements) {
                if (operationResult.contains(element)) {
                    writer.println(element + " -> EXITO");
                } else {
                    writer.println(element + " -> FALLO");
                }
            }
            writer.println("");

            // Mensaje opcional para consola
            // System.out.println("La salida se ha guardado en " + fileName);

        } catch (IOException e) {
            System.err.println("Error al escribir en el archivo: " + e.getMessage());
        }

        
    }

    @Override
    public String graph() {
        return "";
    }

}
