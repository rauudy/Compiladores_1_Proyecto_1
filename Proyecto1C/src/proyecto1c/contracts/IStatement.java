/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package proyecto1c.contracts;

import proyecto1c.symbols.SymTable;

/**
 *
 * @author xhuni
 */
public abstract class IStatement extends IGraphicable {
    public abstract void execute(SymTable table);
}
