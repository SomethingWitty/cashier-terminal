import junit.framework.*;
import java.util.*;

public class TerminalTest extends TestCase
{
  private Terminal terminal;
  protected void setUp() {
    terminal = new Terminal();
    Map<String, List<Product>> map = new TreeMap<String, List<Product>>();
    
    Product aOne = new Product("A", 1, 2);
    Product aTwo = new Product("A", 4, 7);
    List<Product> productA = new LinkedList<Product>();
    productA.add(aOne);
    productA.add(aTwo);
    
    Product b = new Product("B", 1, 12 );
    List<Product> productB = new LinkedList<Product>();
    productB.add(b);
    
    Product cOne = new Product("C", 1, 1.25);
    Product cTwo = new Product("C", 6, 6);
    List<Product> productC = new LinkedList<Product>();
    productC.add(cOne);
    productC.add(cTwo);
    
    Product d = new Product("D", 1, .15);
    List<Product> productD = new LinkedList<Product>();
    productD.add(d);
    
    map.put("A", productA);
    map.put("B", productB);
    map.put("C", productC);
    map.put("D", productD);
    
    terminal.setPricing(map);
  }
  //ABCDABAA
  public void testABCDABAA()
  {
    terminal.scan("A");
    terminal.scan("B");
    terminal.scan("C");
    terminal.scan("D");
    terminal.scan("A");
    terminal.scan("B");
    terminal.scan("A");
    terminal.scan("A");

    assertEquals(terminal.getTotal(), 32.40);
  }
  //CCCCCC
  public void testCCCCCCC() 
  {
    terminal.scan("C");
    terminal.scan("C");
    terminal.scan("C");
    terminal.scan("C");
    terminal.scan("C");
    terminal.scan("C");
    terminal.scan("C");
    assertEquals(terminal.getTotal(), 7.25);
  }
  //ABCD
  public void testABCD()
  {
    terminal.scan("A");
    terminal.scan("B");
    terminal.scan("C");
    terminal.scan("D");
    assertEquals(terminal.getTotal(), 15.40);
  }
  //AAAA
  public void testAAAA()
  {
    terminal.scan("A");
    terminal.scan("A");
    terminal.scan("A");
    terminal.scan("A");
    assertEquals(terminal.getTotal(), 7.0);
  }
  //A
  public void testA()
  {
    terminal.scan("A");
    assertEquals(terminal.getTotal(), 2.0);
  }
  //B
  public void testB()
  {
    terminal.scan("B");
    assertEquals(terminal.getTotal(), 12.0);
  }
  //C
  public void testC()
  {
    terminal.scan("C");
    assertEquals(terminal.getTotal(), 1.25);
  }
  //D
  public void testD()
  {
    terminal.scan("D");
    assertEquals(terminal.getTotal(), .15);
  }
  //AAAAA
  public void testAAAAA()
  {
    terminal.scan("A");
    terminal.scan("A");
    terminal.scan("A");
    terminal.scan("A");
    terminal.scan("A");
    assertEquals(terminal.getTotal(), 9.0);
  }
  //CCCCCC
  public void testCCCCCC()
  {
    terminal.scan("C");
    terminal.scan("C");
    terminal.scan("C");
    terminal.scan("C");
    terminal.scan("C");
    terminal.scan("C");
    assertEquals(terminal.getTotal(), 6.0);
  }
}