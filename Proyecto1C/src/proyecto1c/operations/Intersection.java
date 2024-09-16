/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto1c.operations;

import proyecto1c.contracts.IOperation;
import proyecto1c.symbols.SymTable;
import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author info
 */
public class Intersection extends IOperation {
    public final IOperation op1, op2;

    public Intersection(IOperation op1, IOperation op2) {
        this.op1 = op1;
        this.op2 = op2;
    }
    
    @Override
    public Set<Comparable> eval(SymTable table) {
        Set<Comparable> result = new HashSet<>(op1.eval(table));
        result.retainAll(op2.eval(table));
        return result;
    }

    @Override
    public String graph() {
        StringBuilder str = new StringBuilder();
        str.append("O_")
                .append(id);
        
        str.append("[label=\"Intersec\"];\n");
        
        str.append("O_").append(id).append(" -> ")
                .append("O_").append(op1.getId()).append(";\n");
        
        str.append(op1.graph());
        
                str.append("O_").append(id).append(" -> ")
                .append("O_").append(op2.getId()).append(";\n");
        
        str.append(op2.graph());
        
        return str.toString();
    }
    
    @Override
    public String printEval() {
        return "(" + op1.printEval() + " & " + op2.printEval() + ")";
    }
}
