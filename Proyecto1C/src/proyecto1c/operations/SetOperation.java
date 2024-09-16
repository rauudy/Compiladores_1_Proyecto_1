/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto1c.operations;

import org.json.JSONArray;
import org.json.JSONObject;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import proyecto1c.contracts.IOperation;
import proyecto1c.contracts.IStatement;
import proyecto1c.symbols.SymTable;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author info
 */
public class SetOperation extends IStatement {

    private final IOperation op;
    private final String operationName;
    private List<String> appliedLaws = new ArrayList<String>();
    private static LinkedHashMap<String, JSONObject> globalOperations = new LinkedHashMap<>();

    public SetOperation(String name, IOperation op) {
        this.operationName = name;
        this.op = op;
    }

    @Override
    public void execute(SymTable table) {
        // Evaluar la operacion original
        Set<Comparable> originalResult = op.eval(table);

        // Simplificar la operacion
        IOperation simplifiedOp = simplify(op);
        Set<Comparable> simplifiedResult = simplifiedOp.eval(table);

        // Imprimir resultados
        System.out.println("Resultado de la operacion original: " + originalResult);
        System.out.println("Resultado de la operacion simplificada: " + simplifiedResult);

        // Imprimir leyes aplicadas y generar JSON para esta operación
        JSONObject operationJson = new JSONObject();
        if (!appliedLaws.isEmpty()) {
            System.out.println("Leyes aplicadas:");
            for (String law : appliedLaws) {
                System.out.println("- " + law);
            }
            operationJson.put("leyes", new JSONArray(appliedLaws));
            operationJson.put("conjunto simplificado", simplifiedOp.printEval());
        } else {
            System.out.println("No se aplicaron leyes de simplificacion.");
            operationJson.put("","No se puede simplificar la operación");
        }

        // Guarda el resultado en la tabla de símbolos
        table.add(operationName, simplifiedResult);

        // Imprimir la operacion
        System.out.println("Operacion: " + op.printEval());
        
        try {
            generateDotFile("conjunto1 U conjunto2");
        } catch (IOException ex) {
            Logger.getLogger(SetOperation.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        globalOperations.put(operationName, operationJson);

        // Escribir JSON en un archivo
        writeJsonToFile();
    }

    private void writeJsonToFile() {
        try {
            JSONObject finalJson = new JSONObject(globalOperations);
            File file = new File("resultado.json");
            try (BufferedWriter writer = new BufferedWriter(new FileWriter(file))) {
                writer.write(finalJson.toString(4));
            }
            System.out.println("JSON guardado en: " + file.getAbsolutePath());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public String graph() {
        StringBuilder str = new StringBuilder();
        str.append("S_").append(id);
        str.append("[label=\"Operacion\"];\n");

        str.append("S_").append(id)
                .append(" -> ")
                .append("O_").append(op.getId())
                .append("\n");

        str.append(op.graph());

        return str.toString();
    }

    private IOperation simplify(IOperation operation) {
        // Idempotencia: A U A = A, A ∩ A = A
        if (operation instanceof Union opUnion) {
            if (opUnion.op1 instanceof SetReference ref1 && opUnion.op2 instanceof SetReference ref2) {
                if (ref1.name.equals(ref2.name)) {
                    appliedLaws.add("Idempotencia");
                    return opUnion.op1;
                }
            }
        } else if (operation instanceof Intersection opIntersection) {
            if (opIntersection.op1 instanceof SetReference ref1 && opIntersection.op2 instanceof SetReference ref2) {
                if (ref1.name.equals(ref2.name)) {
                    appliedLaws.add("Idempotencia");
                    return opIntersection.op1;
                }
            }
        }

        // Doble complemento: ^^A = A
        if (operation instanceof Complement opComplement) {
            if (opComplement.op instanceof Complement innerComplement) {
                appliedLaws.add("Doble complemento");
                return innerComplement.op;  // Simplifica a A
            }
        }

        // Leyes de De Morgan:
        // ¬(A U B) = ¬A ∩ ¬B
        // ¬(A ∩ B) = ¬A U ¬B
        if (operation instanceof Complement opComplement) {
            if (opComplement.op instanceof Union opUnion) {
                appliedLaws.add("Ley de De Morgan (¬(A U B) = ¬A ∩ ¬B)");
                return new Intersection(new Complement(opUnion.op1), new Complement(opUnion.op2));
            } else if (opComplement.op instanceof Intersection opIntersection) {
                appliedLaws.add("Ley de De Morgan (¬(A ∩ B) = ¬A U ¬B)");
                return new Union(new Complement(opIntersection.op1), new Complement(opIntersection.op2));
            }
        }

        // Propiedades conmutativas:
        // A U B = B U A
        if (operation instanceof Union opUnion) {
            if (opUnion.op1 instanceof SetReference ref1 && opUnion.op2 instanceof SetReference ref2) {
                if (ref1.name.equals(ref2.name)) {
                    appliedLaws.add("Propiedad Conmutativa de Union");
                    return new Union(opUnion.op2, opUnion.op1);
                }
            }
        } else if (operation instanceof Intersection opIntersection) {
            if (opIntersection.op1 instanceof SetReference ref1 && opIntersection.op2 instanceof SetReference ref2) {
                if (ref1.name.equals(ref2.name)) {
                    appliedLaws.add("Propiedad Conmutativa de Interseccion");
                    return new Intersection(opIntersection.op2, opIntersection.op1);
                }
            }
        }

        // Propiedades asociativas:
        // (A U B) U C = A U (B U C)
        // (A ∩ B) ∩ C = A ∩ (B ∩ C)
        if (operation instanceof Union opUnion) {
            if (opUnion.op1 instanceof Union innerUnion) {
                appliedLaws.add("Propiedad Asociativa de Union");
                return new Union(new Union(innerUnion.op1, innerUnion.op2), opUnion.op2);
            }
        } else if (operation instanceof Intersection opIntersection) {
            if (opIntersection.op1 instanceof Intersection innerIntersection) {
                appliedLaws.add("Propiedad Asociativa de Interseccion");
                return new Intersection(new Intersection(innerIntersection.op1, innerIntersection.op2), opIntersection.op2);
            }
        }

        // Propiedades distributivas:
        // A U (B ∩ C) = (A U B) ∩ (A U C)
        // A ∩ (B U C) = (A ∩ B) U (A ∩ C)
        if (operation instanceof Union opUnion) {
            if (opUnion.op2 instanceof Intersection opIntersection) {
                appliedLaws.add("Propiedad Distributiva de Union sobre Interseccion");
                return new Intersection(new Union(opUnion.op1, opIntersection.op1), new Union(opUnion.op1, opIntersection.op2));
            }
        } else if (operation instanceof Intersection opIntersection) {
            if (opIntersection.op2 instanceof Union opUnion) {
                appliedLaws.add("Propiedad Distributiva de Interseccion sobre Union");
                return new Union(new Intersection(opIntersection.op1, opUnion.op1), new Intersection(opIntersection.op1, opUnion.op2));
            }
        }

        // Propiedades de absorcion:
        // A U (A ∩ B) = A
        // A ∩ (A U B) = A
        if (operation instanceof Union opUnion) {
            if (opUnion.op2 instanceof Intersection opIntersection) {
                if (opUnion.op1 instanceof SetReference ref1 && opIntersection.op1 instanceof SetReference ref2 && ref1.name.equals(ref2.name)) {
                    appliedLaws.add("Propiedad de Absorcion (A U (A ∩ B) = A)");
                    return opUnion.op1;
                }
            }
        } else if (operation instanceof Intersection opIntersection) {
            if (opIntersection.op2 instanceof Union opUnion) {
                if (opIntersection.op1 instanceof SetReference ref1 && opUnion.op1 instanceof SetReference ref2 && ref1.name.equals(ref2.name)) {
                    appliedLaws.add("Propiedad de Absorcion (A ∩ (A U B) = A)");
                    return opIntersection.op1;
                }
            }
        }
        return operation;
    }

    // Método estático para reiniciar el mapa de operaciones global antes de procesar un nuevo conjunto de operaciones
    public static void resetGlobalOperations() {
        globalOperations.clear();
    }
    
    public static void generateDotFile(String operation) throws IOException {
        FileWriter fileWriter = new FileWriter("venn_diagram.dot");

        fileWriter.write("digraph G {\n");
        fileWriter.write("  node [shape=circle, style=filled];\n");

        if (operation.contains("U")) {
            fileWriter.write("  conjunto1 [label=\"Conjunto 1\", fillcolor=lightblue];\n");
            fileWriter.write("  conjunto2 [label=\"Conjunto 2\", fillcolor=lightgreen];\n");
            fileWriter.write("  conjunto1 -> conjunto2 [label=\"Union\"];\n");
        } else if (operation.contains("&")) {
            fileWriter.write("  conjunto1 [label=\"Conjunto 1\", fillcolor=lightblue];\n");
            fileWriter.write("  conjunto2 [label=\"Conjunto 2\", fillcolor=lightgreen];\n");
            fileWriter.write("  conjunto1 [label=\"Conjunto 1\\n(Intersección)\", fillcolor=yellow];\n");
            fileWriter.write("  conjunto2 [label=\"Conjunto 2\\n(Intersección)\", fillcolor=yellow];\n");
        }
        // Puedes añadir más casos para '-' y '^'

        fileWriter.write("}\n");
        fileWriter.close();
    }


}
