/**
* Set the correct package
*
* package edu.cvsu.dcit50.expression;
*
**/

/**
 *
 * @author rlvillacarlos
 */
public class ExpressionTester {

    public static void main(String[] args) {
   
        System.out.println("Test Constant");
        Constant c1 = new Constant(3);
        expectEquals(3, c1.getValue());
        expectEquals("3", c1.toString());

        System.out.println("\nTest Non-Null Variable");
        Variable v1 = new Variable("x", 5);
        expectEquals("x", v1.getName());
        expectEquals("x", v1.toString());
        expectEquals(5, v1.getValue());
        v1.setValue(10);
        expectEquals(10, v1.getValue());
        
        System.out.println("\nTest Null Variable");
        Variable v2 = new Variable("y");
        expectEquals("y", v2.getName());
        expectEquals("y", v2.toString());
        expectNull(v2.getValue());
        
        System.out.println("\nTest Non-Null Negation");
        Negation n1 = new Negation(c1);
        expectSame(c1, n1.getOperand());
        expectEquals(-3, n1.getValue());
        expectEquals("-3", n1.toString());
        
        System.out.println("\nTest Null Negation");
        Negation n2 = new Negation(v2);
        expectSame(v2, n2.getOperand());
        expectEquals("-y", n2.toString());
        expectNull(n2.getValue());

        System.out.println("\nTest Non-Null Addition");
        Addition a1 = new Addition(c1, n1);
        expectSame(c1, a1.getLeftOperand());
        expectSame(n1, a1.getRightOperand());
        expectEquals(0, a1.getValue());
        expectEquals("(3+-3)", a1.toString());
        
        System.out.println("\nTest Null Addition");
        Addition a2 = new Addition(c1, n2);
        expectEquals("(3+-y)", a2.toString());
        expectNull(a2.getValue());
        
        System.out.println("\nTest Non-Null Multiplication");
        Multiplication m1 = new Multiplication(c1, n1);
        expectSame(c1, m1.getLeftOperand());
        expectSame(n1, m1.getRightOperand());
        expectEquals(-9, m1.getValue());
        expectEquals("(3*-3)", m1.toString());
        
        System.out.println("\nTest Null Multiplication");
        Multiplication m2 = new Multiplication(c1, n2);
        expectEquals("(3*-y)", m2.toString());
        expectNull(m2.getValue());
        
        
        System.out.println("\nTest All-In-One");
        Constant c2 = new Constant(-15);
        Negation n3 = new Negation(c2);
        Variable v3 = new Variable("x1"), v4 = new Variable("x2", 4);
        v3.setValue(10);
        Addition a3 = new Addition(v3, n3);
        Multiplication m3 = new Multiplication(a3, v4);
        expectEquals(100, m3.getValue());
        expectEquals("((x1+15)*x2)", m3.toString());
        Multiplication m4 = new Multiplication(n3, v4);
        Addition a4 = new Addition(v3, m4);
        expectEquals(70, a4.getValue());
        expectEquals("(x1+(15*x2))", a4.toString());
    }
    
    private static void expectEquals(Object expected, Object given){
        boolean passed  = (expected == null && given == null) || 
                            (expected != null && expected.equals(given));
        if(!passed){
            System.out.printf("Failed: Expected is %s but given is %s%n", expected, given);
        }else{
            System.out.println("Passed");
        }
    }
    
    private static void expectSame(Object expected, Object given){
        boolean passed  = (expected == given);
        if(!passed){
            System.out.println("Failed: The expect object is not the same as the given object");
        }else{
            System.out.println("Passed");
        }
    }
    
    private static void expectNull(Object given){
        boolean passed  = (given == null);
        if(!passed){
            System.out.println("Failed: The given object is not null");
        }else{
            System.out.println("Passed");
        }
    }
}
