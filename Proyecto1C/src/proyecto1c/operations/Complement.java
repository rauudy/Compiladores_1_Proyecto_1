/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto1c.operations;

import proyecto1c.contracts.IOperation;
import proyecto1c.symbols.SymTable;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author info
 */
public class Complement extends IOperation {
    public final IOperation op;

    public Complement(IOperation op) {
        this.op = op;
    }
    
    @Override
    public Set<Comparable> eval(SymTable table) {
        //Set<Comparable> result = new HashSet<>(Arrays.asList(0,1,2,3,4,5,6,7,8,9));
        Set<Comparable> result = new HashSet<>(Arrays.asList(
            'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z',
            'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z',
            0, 1, 2, 3, 4, 5, 6, 7, 8, 9,                
            '!', '"', '#', '$', '%', '&', '\'', '(', ')', '*', '+', ',', '-', '.', '/', 
            ':', ';', '<', '=', '>', '?', '@', '[', '\\', ']', '^', '_', '`', '{', '|', '}', '~'
        ));
        result.removeAll(op.eval(table));
        return result;
    }


    @Override
    public String graph() {
        StringBuilder str = new StringBuilder();
        str.append("O_")
                .append(id);
        
        str.append("[label=\"Complemento\"];\n");
        
        str.append("O_").append(id).append(" -> ")
                .append("O_").append(op.getId()).append(";\n");
        
        str.append(op.graph());
        return str.toString();
    }
    
    @Override
    public String printEval() {
        return "( ^ " + op.printEval() + ")";
    }
}