
//----------------------------------------------------
// The following code was generated by CUP v0.11b 20160615 (GIT 4ac7450)
//----------------------------------------------------

package proyecto1c;

import java_cup.runtime.Symbol;
import java.util.*;
import java.io.FileWriter;
import java.io.IOException;
import proyecto1c.contracts.IOperation;
import proyecto1c.contracts.IStatement;
import proyecto1c.operations.*;
import java.util.LinkedHashSet;
import java_cup.runtime.XMLElement;

/** CUP v0.11b 20160615 (GIT 4ac7450) generated parser.
  */
@SuppressWarnings({"rawtypes"})
public class Parser extends java_cup.runtime.lr_parser {

 public final Class getSymbolContainer() {
    return sym.class;
}

  /** Default constructor. */
  @Deprecated
  public Parser() {super();}

  /** Constructor which sets the default scanner. */
  @Deprecated
  public Parser(java_cup.runtime.Scanner s) {super(s);}

  /** Constructor which sets the default scanner. */
  public Parser(java_cup.runtime.Scanner s, java_cup.runtime.SymbolFactory sf) {super(s,sf);}

  /** Production table. */
  protected static final short _production_table[][] = 
    unpackFromStrings(new String[] {
    "\000\037\000\002\002\004\000\002\002\005\000\002\002" +
    "\003\000\002\003\004\000\002\003\003\000\002\004\003" +
    "\000\002\004\003\000\002\004\003\000\002\004\013\000" +
    "\002\004\004\000\002\011\007\000\002\011\005\000\002" +
    "\005\010\000\002\005\006\000\002\012\005\000\002\012" +
    "\003\000\002\013\005\000\002\013\003\000\002\013\003" +
    "\000\002\014\003\000\002\014\003\000\002\014\003\000" +
    "\002\006\003\000\002\010\010\000\002\010\010\000\002" +
    "\007\005\000\002\007\005\000\002\007\005\000\002\007" +
    "\005\000\002\007\004\000\002\007\003" });

  /** Access to production table. */
  public short[][] production_table() {return _production_table;}

  /** Parse-action table. */
  protected static final short[][] _action_table = 
    unpackFromStrings(new String[] {
    "\000\113\000\006\003\006\024\004\001\002\000\014\003" +
    "\017\004\010\012\013\015\021\026\015\001\002\000\004" +
    "\002\007\001\002\000\004\002\uffff\001\002\000\004\002" +
    "\001\001\002\000\004\016\103\001\002\000\016\003\017" +
    "\004\010\012\013\015\021\025\102\026\015\001\002\000" +
    "\020\003\ufffd\004\ufffd\012\ufffd\015\ufffd\021\ufffd\025\ufffd" +
    "\026\ufffd\001\002\000\004\020\063\001\002\000\020\003" +
    "\ufffc\004\ufffc\012\ufffc\015\ufffc\021\ufffc\025\ufffc\026\ufffc" +
    "\001\002\000\006\003\055\013\054\001\002\000\020\003" +
    "\ufffb\004\ufffb\012\ufffb\015\ufffb\021\ufffb\025\ufffb\026\ufffb" +
    "\001\002\000\004\023\053\001\002\000\020\003\ufffa\004" +
    "\ufffa\012\ufffa\015\ufffa\021\ufffa\025\ufffa\026\ufffa\001\002" +
    "\000\004\016\022\001\002\000\006\003\024\013\023\001" +
    "\002\000\004\022\030\001\002\000\004\022\025\001\002" +
    "\000\004\003\026\001\002\000\004\023\027\001\002\000" +
    "\020\003\uffe9\004\uffe9\012\uffe9\015\uffe9\021\uffe9\025\uffe9" +
    "\026\uffe9\001\002\000\016\003\034\005\036\006\035\007" +
    "\033\010\032\024\031\001\002\000\004\013\050\001\002" +
    "\000\016\003\034\005\036\006\035\007\033\010\032\024" +
    "\031\001\002\000\016\003\034\005\036\006\035\007\033" +
    "\010\032\024\031\001\002\000\020\003\uffe3\005\uffe3\006" +
    "\uffe3\007\uffe3\010\uffe3\023\uffe3\024\uffe3\001\002\000\016" +
    "\003\034\005\036\006\035\007\033\010\032\024\031\001" +
    "\002\000\016\003\034\005\036\006\035\007\033\010\032" +
    "\024\031\001\002\000\004\023\040\001\002\000\020\003" +
    "\uffea\004\uffea\012\uffea\015\uffea\021\uffea\025\uffea\026\uffea" +
    "\001\002\000\016\003\034\005\036\006\035\007\033\010" +
    "\032\024\031\001\002\000\020\003\uffe7\005\uffe7\006\uffe7" +
    "\007\uffe7\010\uffe7\023\uffe7\024\uffe7\001\002\000\016\003" +
    "\034\005\036\006\035\007\033\010\032\024\031\001\002" +
    "\000\020\003\uffe6\005\uffe6\006\uffe6\007\uffe6\010\uffe6\023" +
    "\uffe6\024\uffe6\001\002\000\016\003\034\005\036\006\035" +
    "\007\033\010\032\024\031\001\002\000\020\003\uffe5\005" +
    "\uffe5\006\uffe5\007\uffe5\010\uffe5\023\uffe5\024\uffe5\001\002" +
    "\000\020\003\uffe4\005\uffe4\006\uffe4\007\uffe4\010\uffe4\023" +
    "\uffe4\024\uffe4\001\002\000\004\025\uffeb\001\002\000\004" +
    "\025\052\001\002\000\020\003\uffe8\005\uffe8\006\uffe8\007" +
    "\uffe8\010\uffe8\023\uffe8\024\uffe8\001\002\000\020\003\ufff8" +
    "\004\ufff8\012\ufff8\015\ufff8\021\ufff8\025\ufff8\026\ufff8\001" +
    "\002\000\004\020\057\001\002\000\004\021\056\001\002" +
    "\000\020\003\ufff6\004\ufff6\012\ufff6\015\ufff6\021\ufff6\025" +
    "\ufff6\026\ufff6\001\002\000\014\003\017\004\010\012\013" +
    "\015\021\026\015\001\002\000\016\003\017\004\010\012" +
    "\013\015\021\021\062\026\015\001\002\000\020\003\ufffe" +
    "\004\ufffe\012\ufffe\015\ufffe\021\ufffe\025\ufffe\026\ufffe\001" +
    "\002\000\020\003\ufff7\004\ufff7\012\ufff7\015\ufff7\021\ufff7" +
    "\025\ufff7\026\ufff7\001\002\000\004\024\064\001\002\000" +
    "\012\003\070\014\072\027\071\030\066\001\002\000\006" +
    "\017\ufff0\025\ufff0\001\002\000\012\011\uffec\017\uffec\023" +
    "\uffec\025\uffec\001\002\000\006\017\073\025\074\001\002" +
    "\000\010\017\uffef\023\uffef\025\uffef\001\002\000\012\011" +
    "\uffed\017\uffed\023\uffed\025\uffed\001\002\000\012\011\uffee" +
    "\017\uffee\023\uffee\025\uffee\001\002\000\010\014\072\027" +
    "\071\030\066\001\002\000\004\017\075\001\002\000\004" +
    "\013\076\001\002\000\004\021\077\001\002\000\004\023" +
    "\100\001\002\000\020\003\ufff9\004\ufff9\012\ufff9\015\ufff9" +
    "\021\ufff9\025\ufff9\026\ufff9\001\002\000\010\017\ufff1\023" +
    "\ufff1\025\ufff1\001\002\000\004\002\000\001\002\000\006" +
    "\003\105\013\104\001\002\000\004\022\107\001\002\000" +
    "\004\023\106\001\002\000\020\003\ufff4\004\ufff4\012\ufff4" +
    "\015\ufff4\021\ufff4\025\ufff4\026\ufff4\001\002\000\012\003" +
    "\070\014\072\027\071\030\066\001\002\000\010\011\114" +
    "\017\ufff0\023\ufff0\001\002\000\006\017\073\023\ufff2\001" +
    "\002\000\004\023\113\001\002\000\020\003\ufff5\004\ufff5" +
    "\012\ufff5\015\ufff5\021\ufff5\025\ufff5\026\ufff5\001\002\000" +
    "\010\014\072\027\071\030\066\001\002\000\004\023\ufff3" +
    "\001\002" });

  /** Access to parse-action table. */
  public short[][] action_table() {return _action_table;}

  /** <code>reduce_goto</code> table. */
  protected static final short[][] _reduce_table = 
    unpackFromStrings(new String[] {
    "\000\113\000\004\002\004\001\001\000\014\003\010\004" +
    "\011\005\013\010\015\011\017\001\001\000\002\001\001" +
    "\000\002\001\001\000\002\001\001\000\002\001\001\000" +
    "\012\004\060\005\013\010\015\011\017\001\001\000\002" +
    "\001\001\000\002\001\001\000\002\001\001\000\002\001" +
    "\001\000\002\001\001\000\002\001\001\000\002\001\001" +
    "\000\002\001\001\000\002\001\001\000\002\001\001\000" +
    "\002\001\001\000\002\001\001\000\002\001\001\000\002" +
    "\001\001\000\004\007\036\001\001\000\004\006\050\001" +
    "\001\000\004\007\046\001\001\000\004\007\044\001\001" +
    "\000\002\001\001\000\004\007\042\001\001\000\004\007" +
    "\040\001\001\000\002\001\001\000\002\001\001\000\004" +
    "\007\041\001\001\000\002\001\001\000\004\007\043\001" +
    "\001\000\002\001\001\000\004\007\045\001\001\000\002" +
    "\001\001\000\002\001\001\000\002\001\001\000\002\001" +
    "\001\000\002\001\001\000\002\001\001\000\002\001\001" +
    "\000\002\001\001\000\002\001\001\000\014\003\057\004" +
    "\011\005\013\010\015\011\017\001\001\000\012\004\060" +
    "\005\013\010\015\011\017\001\001\000\002\001\001\000" +
    "\002\001\001\000\002\001\001\000\006\013\066\014\064" +
    "\001\001\000\002\001\001\000\002\001\001\000\002\001" +
    "\001\000\002\001\001\000\002\001\001\000\002\001\001" +
    "\000\004\014\100\001\001\000\002\001\001\000\002\001" +
    "\001\000\002\001\001\000\002\001\001\000\002\001\001" +
    "\000\002\001\001\000\002\001\001\000\002\001\001\000" +
    "\002\001\001\000\002\001\001\000\002\001\001\000\010" +
    "\012\111\013\110\014\107\001\001\000\002\001\001\000" +
    "\002\001\001\000\002\001\001\000\002\001\001\000\004" +
    "\014\114\001\001\000\002\001\001" });

  /** Access to <code>reduce_goto</code> table. */
  public short[][] reduce_table() {return _reduce_table;}

  /** Instance of action encapsulation class. */
  protected CUP$Parser$actions action_obj;

  /** Action encapsulation object initializer. */
  protected void init_actions()
    {
      action_obj = new CUP$Parser$actions(this);
    }

  /** Invoke a user supplied parse action. */
  public java_cup.runtime.Symbol do_action(
    int                        act_num,
    java_cup.runtime.lr_parser parser,
    java.util.Stack            stack,
    int                        top)
    throws java.lang.Exception
  {
    /* call code in generated class */
    return action_obj.CUP$Parser$do_action(act_num, parser, stack, top);
  }

  /** Indicates start state. */
  public int start_state() {return 0;}
  /** Indicates start production. */
  public int start_production() {return 0;}

  /** <code>EOF</code> Symbol index. */
  public int EOF_sym() {return 0;}

  /** <code>error</code> Symbol index. */
  public int error_sym() {return 1;}



    public LinkedList<IStatement> AST = new LinkedList<>();
    public LinkedList<String> syntaxErrors = new LinkedList<>();
    private int errorCount = 0;

    @Override
    public void syntax_error(Symbol cur_token) {
        report_error("Syntax error", cur_token);
    }

    @Override
    public void report_error(String message, Object info) {
        Symbol s = (Symbol) info;
        errorCount++;
        syntaxErrors.add(String.format("Error sintáctico en línea %d, columna %d: %s", s.left, s.right, message));
    }

    @Override
    public void report_fatal_error(String message, Object info) throws Exception {
        Symbol s = (Symbol) info;
        errorCount++;
        syntaxErrors.add(String.format("Error fatal en línea %d, columna %d: %s", s.left, s.right, message));
        
        // Modo pánico: Descartar tokens hasta encontrar un punto de sincronización
        while (true) {
            try {
                Symbol token = scan();
                if (token.sym == sym.SEMICOLON || token.sym == sym.EOF) {
                    break;
                }
            } catch (Exception e) {
                break;
            }
        }
    }

    @Override
    public void unrecovered_syntax_error(Symbol s) throws Exception {
        errorCount++;
        syntaxErrors.add(String.format("Error de sintaxis no recuperable en línea %d, columna %d", s.left, s.right));
    }

    public void generateErrorReport(String filename) {
        try (FileWriter writer = new FileWriter(filename)) {
            writer.write("<html><head><title>Reporte de Errores</title><link rel=\"stylesheet\" href=\"style.css\"></head><body>");
            writer.write("<h1>Reporte de Errores</h1>");
            writer.write("<table border='1'><tr><th>#</th><th>Descripción</th></tr>");
            
            for (int i = 0; i < syntaxErrors.size(); i++) {
                writer.write(String.format("<tr><td>%d</td><td>%s</td></tr>", i+1, syntaxErrors.get(i)));
            }
            
            writer.write("</table></body></html>");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


/** Cup generated class to encapsulate user supplied action code.*/
@SuppressWarnings({"rawtypes", "unchecked", "unused"})
class CUP$Parser$actions {
  private final Parser parser;

  /** Constructor */
  CUP$Parser$actions(Parser parser) {
    this.parser = parser;
  }

  /** Method 0 with the actual generated action code for actions 0 to 300. */
  public final java_cup.runtime.Symbol CUP$Parser$do_action_part00000000(
    int                        CUP$Parser$act_num,
    java_cup.runtime.lr_parser CUP$Parser$parser,
    java.util.Stack            CUP$Parser$stack,
    int                        CUP$Parser$top)
    throws java.lang.Exception
    {
      /* Symbol object for return from actions */
      java_cup.runtime.Symbol CUP$Parser$result;

      /* select the action based on the action number */
      switch (CUP$Parser$act_num)
        {
          /*. . . . . . . . . . . . . . . . . . . .*/
          case 0: // $START ::= ini EOF 
            {
              Object RESULT =null;
		int start_valleft = ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-1)).left;
		int start_valright = ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-1)).right;
		Object start_val = (Object)((java_cup.runtime.Symbol) CUP$Parser$stack.elementAt(CUP$Parser$top-1)).value;
		RESULT = start_val;
              CUP$Parser$result = parser.getSymbolFactory().newSymbol("$START",0, ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-1)), ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), RESULT);
            }
          /* ACCEPT */
          CUP$Parser$parser.done_parsing();
          return CUP$Parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 1: // ini ::= LBRACE instrucciones RBRACE 
            {
              Object RESULT =null;
		int ileft = ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-1)).left;
		int iright = ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-1)).right;
		LinkedList<IStatement> i = (LinkedList<IStatement>)((java_cup.runtime.Symbol) CUP$Parser$stack.elementAt(CUP$Parser$top-1)).value;
		 parser.AST = i; 
              CUP$Parser$result = parser.getSymbolFactory().newSymbol("ini",0, ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-2)), ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), RESULT);
            }
          return CUP$Parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 2: // ini ::= error 
            {
              Object RESULT =null;
		 parser.report_error("Error en la estructura principal del programa", cur_token); 
              CUP$Parser$result = parser.getSymbolFactory().newSymbol("ini",0, ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), RESULT);
            }
          return CUP$Parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 3: // instrucciones ::= instrucciones instruccion 
            {
              LinkedList<IStatement> RESULT =null;
		int ileft = ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-1)).left;
		int iright = ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-1)).right;
		LinkedList<IStatement> i = (LinkedList<IStatement>)((java_cup.runtime.Symbol) CUP$Parser$stack.elementAt(CUP$Parser$top-1)).value;
		int jleft = ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()).left;
		int jright = ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()).right;
		IStatement j = (IStatement)((java_cup.runtime.Symbol) CUP$Parser$stack.peek()).value;
		 RESULT = i; RESULT.add(j); 
              CUP$Parser$result = parser.getSymbolFactory().newSymbol("instrucciones",1, ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-1)), ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), RESULT);
            }
          return CUP$Parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 4: // instrucciones ::= instruccion 
            {
              LinkedList<IStatement> RESULT =null;
		int ileft = ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()).left;
		int iright = ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()).right;
		IStatement i = (IStatement)((java_cup.runtime.Symbol) CUP$Parser$stack.peek()).value;
		 RESULT = new LinkedList<IStatement>(); RESULT.add(i); 
              CUP$Parser$result = parser.getSymbolFactory().newSymbol("instrucciones",1, ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), RESULT);
            }
          return CUP$Parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 5: // instruccion ::= conjunto_def 
            {
              IStatement RESULT =null;
		int sleft = ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()).left;
		int sright = ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()).right;
		SetDefine s = (SetDefine)((java_cup.runtime.Symbol) CUP$Parser$stack.peek()).value;
		 RESULT = s; 
              CUP$Parser$result = parser.getSymbolFactory().newSymbol("instruccion",2, ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), RESULT);
            }
          return CUP$Parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 6: // instruccion ::= statement 
            {
              IStatement RESULT =null;
		int sleft = ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()).left;
		int sright = ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()).right;
		SetOperation s = (SetOperation)((java_cup.runtime.Symbol) CUP$Parser$stack.peek()).value;
		 RESULT = s; 
              CUP$Parser$result = parser.getSymbolFactory().newSymbol("instruccion",2, ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), RESULT);
            }
          return CUP$Parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 7: // instruccion ::= scope_block 
            {
              IStatement RESULT =null;
		int sleft = ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()).left;
		int sright = ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()).right;
		IStatement s = (IStatement)((java_cup.runtime.Symbol) CUP$Parser$stack.peek()).value;
		 RESULT = s; 
              CUP$Parser$result = parser.getSymbolFactory().newSymbol("instruccion",2, ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), RESULT);
            }
          return CUP$Parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 8: // instruccion ::= EVALUATION LPAREN LBRACE lista_elementos RBRACE COMMA VAR RPAREN SEMICOLON 
            {
              IStatement RESULT =null;
		int elementsleft = ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-5)).left;
		int elementsright = ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-5)).right;
		Set<Comparable> elements = (Set<Comparable>)((java_cup.runtime.Symbol) CUP$Parser$stack.elementAt(CUP$Parser$top-5)).value;
		int operationNameleft = ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-2)).left;
		int operationNameright = ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-2)).right;
		String operationName = (String)((java_cup.runtime.Symbol) CUP$Parser$stack.elementAt(CUP$Parser$top-2)).value;
		 RESULT = new SetEvaluation(new LinkedHashSet<>(elements), operationName); 
              CUP$Parser$result = parser.getSymbolFactory().newSymbol("instruccion",2, ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-8)), ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), RESULT);
            }
          return CUP$Parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 9: // instruccion ::= error SEMICOLON 
            {
              IStatement RESULT =null;
		 
                    parser.report_error("Error en la instrucción", cur_token);
                    parser.report_fatal_error("Recuperando desde el siguiente punto y coma", cur_token);
                    RESULT = null; 
                
              CUP$Parser$result = parser.getSymbolFactory().newSymbol("instruccion",2, ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-1)), ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), RESULT);
            }
          return CUP$Parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 10: // scope_block ::= SCOPE VAR LPAREN instrucciones RPAREN 
            {
              IStatement RESULT =null;
		int nleft = ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-3)).left;
		int nright = ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-3)).right;
		String n = (String)((java_cup.runtime.Symbol) CUP$Parser$stack.elementAt(CUP$Parser$top-3)).value;
		int ileft = ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-1)).left;
		int iright = ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-1)).right;
		LinkedList<IStatement> i = (LinkedList<IStatement>)((java_cup.runtime.Symbol) CUP$Parser$stack.elementAt(CUP$Parser$top-1)).value;
		 
        RESULT = new ScopeStatement(n, i); 
    
              CUP$Parser$result = parser.getSymbolFactory().newSymbol("scope_block",7, ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-4)), ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), RESULT);
            }
          return CUP$Parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 11: // scope_block ::= SCOPE error RPAREN 
            {
              IStatement RESULT =null;
		 
        parser.report_error("Error en la definición del scope", cur_token);
        RESULT = null; 
    
              CUP$Parser$result = parser.getSymbolFactory().newSymbol("scope_block",7, ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-2)), ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), RESULT);
            }
          return CUP$Parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 12: // conjunto_def ::= CONJ COLON VAR ARROW conjunto_elements SEMICOLON 
            {
              SetDefine RESULT =null;
		int nleft = ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-3)).left;
		int nright = ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-3)).right;
		String n = (String)((java_cup.runtime.Symbol) CUP$Parser$stack.elementAt(CUP$Parser$top-3)).value;
		int cleft = ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-1)).left;
		int cright = ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-1)).right;
		Set<Comparable> c = (Set<Comparable>)((java_cup.runtime.Symbol) CUP$Parser$stack.elementAt(CUP$Parser$top-1)).value;
		 RESULT = new SetDefine(n, c); 
              CUP$Parser$result = parser.getSymbolFactory().newSymbol("conjunto_def",3, ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-5)), ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), RESULT);
            }
          return CUP$Parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 13: // conjunto_def ::= CONJ COLON error SEMICOLON 
            {
              SetDefine RESULT =null;
		 
                    parser.report_error("Error en la definición del conjunto", cur_token);
                    RESULT = new SetDefine("error", new HashSet<>()); 
                
              CUP$Parser$result = parser.getSymbolFactory().newSymbol("conjunto_def",3, ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-3)), ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), RESULT);
            }
          return CUP$Parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 14: // conjunto_elements ::= elemento RANGE elemento 
            {
              Set<Comparable> RESULT =null;
		int startleft = ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-2)).left;
		int startright = ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-2)).right;
		Comparable start = (Comparable)((java_cup.runtime.Symbol) CUP$Parser$stack.elementAt(CUP$Parser$top-2)).value;
		int endleft = ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()).left;
		int endright = ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()).right;
		Comparable end = (Comparable)((java_cup.runtime.Symbol) CUP$Parser$stack.peek()).value;
		 
                        Set<Comparable> range = new LinkedHashSet<>();
                        int startValue = (start instanceof Integer) ? (Integer)start : (int)((Character)start).charValue();
                        int endValue = (end instanceof Integer) ? (Integer)end : (int)((Character)end).charValue();
                        for (int i = startValue; i <= endValue; i++) {
                            if (start instanceof Integer) {
                                range.add(i);
                            } else {
                                range.add((char)i);
                            }
                        }
                        RESULT = range;
                    
              CUP$Parser$result = parser.getSymbolFactory().newSymbol("conjunto_elements",8, ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-2)), ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), RESULT);
            }
          return CUP$Parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 15: // conjunto_elements ::= lista_elementos 
            {
              Set<Comparable> RESULT =null;
		int lleft = ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()).left;
		int lright = ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()).right;
		Set<Comparable> l = (Set<Comparable>)((java_cup.runtime.Symbol) CUP$Parser$stack.peek()).value;
		 RESULT = l; 
              CUP$Parser$result = parser.getSymbolFactory().newSymbol("conjunto_elements",8, ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), RESULT);
            }
          return CUP$Parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 16: // lista_elementos ::= lista_elementos COMMA elemento 
            {
              Set<Comparable> RESULT =null;
		int lleft = ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-2)).left;
		int lright = ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-2)).right;
		Set<Comparable> l = (Set<Comparable>)((java_cup.runtime.Symbol) CUP$Parser$stack.elementAt(CUP$Parser$top-2)).value;
		int eleft = ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()).left;
		int eright = ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()).right;
		Comparable e = (Comparable)((java_cup.runtime.Symbol) CUP$Parser$stack.peek()).value;
		 RESULT = l; RESULT.add(e); 
              CUP$Parser$result = parser.getSymbolFactory().newSymbol("lista_elementos",9, ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-2)), ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), RESULT);
            }
          return CUP$Parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 17: // lista_elementos ::= elemento 
            {
              Set<Comparable> RESULT =null;
		int eleft = ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()).left;
		int eright = ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()).right;
		Comparable e = (Comparable)((java_cup.runtime.Symbol) CUP$Parser$stack.peek()).value;
		 RESULT = new LinkedHashSet<>(); RESULT.add(e); 
              CUP$Parser$result = parser.getSymbolFactory().newSymbol("lista_elementos",9, ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), RESULT);
            }
          return CUP$Parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 18: // lista_elementos ::= error 
            {
              Set<Comparable> RESULT =null;
		 
                        parser.report_error("Error en la lista de elementos", cur_token);
                        RESULT = new LinkedHashSet<>(); 
                    
              CUP$Parser$result = parser.getSymbolFactory().newSymbol("lista_elementos",9, ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), RESULT);
            }
          return CUP$Parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 19: // elemento ::= NUMBER 
            {
              Comparable RESULT =null;
		int nleft = ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()).left;
		int nright = ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()).right;
		String n = (String)((java_cup.runtime.Symbol) CUP$Parser$stack.peek()).value;
		 RESULT = Integer.parseInt(n); 
              CUP$Parser$result = parser.getSymbolFactory().newSymbol("elemento",10, ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), RESULT);
            }
          return CUP$Parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 20: // elemento ::= LETTER 
            {
              Comparable RESULT =null;
		int lleft = ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()).left;
		int lright = ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()).right;
		String l = (String)((java_cup.runtime.Symbol) CUP$Parser$stack.peek()).value;
		 RESULT = l.charAt(0); 
              CUP$Parser$result = parser.getSymbolFactory().newSymbol("elemento",10, ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), RESULT);
            }
          return CUP$Parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 21: // elemento ::= ASCII_CHAR 
            {
              Comparable RESULT =null;
		int cleft = ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()).left;
		int cright = ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()).right;
		String c = (String)((java_cup.runtime.Symbol) CUP$Parser$stack.peek()).value;
		 RESULT = c.charAt(0); 
              CUP$Parser$result = parser.getSymbolFactory().newSymbol("elemento",10, ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), RESULT);
            }
          return CUP$Parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 22: // conjunto ::= VAR 
            {
              SetReference RESULT =null;
		int cleft = ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()).left;
		int cright = ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()).right;
		String c = (String)((java_cup.runtime.Symbol) CUP$Parser$stack.peek()).value;
		 RESULT = new SetReference(c); 
              CUP$Parser$result = parser.getSymbolFactory().newSymbol("conjunto",4, ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), RESULT);
            }
          return CUP$Parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 23: // statement ::= OPERATION COLON VAR ARROW expr SEMICOLON 
            {
              SetOperation RESULT =null;
		int nleft = ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-3)).left;
		int nright = ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-3)).right;
		String n = (String)((java_cup.runtime.Symbol) CUP$Parser$stack.elementAt(CUP$Parser$top-3)).value;
		int eleft = ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-1)).left;
		int eright = ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-1)).right;
		IOperation e = (IOperation)((java_cup.runtime.Symbol) CUP$Parser$stack.elementAt(CUP$Parser$top-1)).value;
		 RESULT = new SetOperation(n, e); 
              CUP$Parser$result = parser.getSymbolFactory().newSymbol("statement",6, ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-5)), ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), RESULT);
            }
          return CUP$Parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 24: // statement ::= OPERATION COLON error ARROW error SEMICOLON 
            {
              SetOperation RESULT =null;
		 
                parser.report_error("Error en la definición de la operación", cur_token);
                RESULT = null; 
             
              CUP$Parser$result = parser.getSymbolFactory().newSymbol("statement",6, ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-5)), ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), RESULT);
            }
          return CUP$Parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 25: // expr ::= LBRACE conjunto RBRACE 
            {
              IOperation RESULT =null;
		int cleft = ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-1)).left;
		int cright = ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-1)).right;
		SetReference c = (SetReference)((java_cup.runtime.Symbol) CUP$Parser$stack.elementAt(CUP$Parser$top-1)).value;
		 RESULT = c; 
              CUP$Parser$result = parser.getSymbolFactory().newSymbol("expr",5, ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-2)), ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), RESULT);
            }
          return CUP$Parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 26: // expr ::= UNION expr expr 
            {
              IOperation RESULT =null;
		int e1left = ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-1)).left;
		int e1right = ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-1)).right;
		IOperation e1 = (IOperation)((java_cup.runtime.Symbol) CUP$Parser$stack.elementAt(CUP$Parser$top-1)).value;
		int e2left = ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()).left;
		int e2right = ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()).right;
		IOperation e2 = (IOperation)((java_cup.runtime.Symbol) CUP$Parser$stack.peek()).value;
		 RESULT = new Union(e1, e2); 
              CUP$Parser$result = parser.getSymbolFactory().newSymbol("expr",5, ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-2)), ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), RESULT);
            }
          return CUP$Parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 27: // expr ::= INTERSEC expr expr 
            {
              IOperation RESULT =null;
		int e1left = ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-1)).left;
		int e1right = ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-1)).right;
		IOperation e1 = (IOperation)((java_cup.runtime.Symbol) CUP$Parser$stack.elementAt(CUP$Parser$top-1)).value;
		int e2left = ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()).left;
		int e2right = ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()).right;
		IOperation e2 = (IOperation)((java_cup.runtime.Symbol) CUP$Parser$stack.peek()).value;
		 RESULT = new Intersection(e1, e2); 
              CUP$Parser$result = parser.getSymbolFactory().newSymbol("expr",5, ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-2)), ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), RESULT);
            }
          return CUP$Parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 28: // expr ::= DIFF expr expr 
            {
              IOperation RESULT =null;
		int e1left = ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-1)).left;
		int e1right = ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-1)).right;
		IOperation e1 = (IOperation)((java_cup.runtime.Symbol) CUP$Parser$stack.elementAt(CUP$Parser$top-1)).value;
		int e2left = ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()).left;
		int e2right = ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()).right;
		IOperation e2 = (IOperation)((java_cup.runtime.Symbol) CUP$Parser$stack.peek()).value;
		 RESULT = new Difference(e1, e2); 
              CUP$Parser$result = parser.getSymbolFactory().newSymbol("expr",5, ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-2)), ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), RESULT);
            }
          return CUP$Parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 29: // expr ::= COMPLEMENT expr 
            {
              IOperation RESULT =null;
		int eleft = ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()).left;
		int eright = ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()).right;
		IOperation e = (IOperation)((java_cup.runtime.Symbol) CUP$Parser$stack.peek()).value;
		 RESULT = new Complement(e); 
              CUP$Parser$result = parser.getSymbolFactory().newSymbol("expr",5, ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-1)), ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), RESULT);
            }
          return CUP$Parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 30: // expr ::= error 
            {
              IOperation RESULT =null;
		 
            parser.report_error("Error en la expresión", cur_token);
            RESULT = null; 
         
              CUP$Parser$result = parser.getSymbolFactory().newSymbol("expr",5, ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), RESULT);
            }
          return CUP$Parser$result;

          /* . . . . . .*/
          default:
            throw new Exception(
               "Invalid action number "+CUP$Parser$act_num+"found in internal parse table");

        }
    } /* end of method */

  /** Method splitting the generated action code into several parts. */
  public final java_cup.runtime.Symbol CUP$Parser$do_action(
    int                        CUP$Parser$act_num,
    java_cup.runtime.lr_parser CUP$Parser$parser,
    java.util.Stack            CUP$Parser$stack,
    int                        CUP$Parser$top)
    throws java.lang.Exception
    {
              return CUP$Parser$do_action_part00000000(
                               CUP$Parser$act_num,
                               CUP$Parser$parser,
                               CUP$Parser$stack,
                               CUP$Parser$top);
    }
}

}
