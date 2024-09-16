package proyecto1c.contracts;


import proyecto1c.symbols.SymTable;
import java.util.Set;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */

/**
 *
 * @author xhuni
 */
public abstract class IOperation extends IGraphicable{
    public abstract Set<Comparable> eval(SymTable table);
    public abstract String printEval();
}
