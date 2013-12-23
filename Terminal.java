/*
 * Each of the items are scanned in one at a time and then aggregated into a String representing everything that has been scanned in
 * The pricing plan is stored in a map with a product key and value of a list of the pricing plans
 * This solution is general enough that different pricing quantities can be inputed or changed with ease
 * 
 */ 
import java.util.*;

public class Terminal
{
  private Map<String, List<Product>> priceMap;
  private String scannedItems;
  
  public Terminal()
  {
    scannedItems = "";
  }
  
  public void setPricing(Map<String, List<Product>> priceMap)
  {
    this.priceMap = priceMap;
  }
  public void scan(String product)
  {
    scannedItems = scannedItems + product;
  }
  public double getTotal()
  {
    double total = 0; 
    
    //find out how many per product there are i.e. 7 A's, 4 B's, etc
    Map<String, Integer> scannedItemsMap = new TreeMap<String, Integer>();
    for(int i = 0; i<scannedItems.length(); i++)
    {
      String item = scannedItems.substring(i, i+1);
      Integer itemCount = scannedItemsMap.get(item);
      if(itemCount == null)
      {
        scannedItemsMap.put(item, new Integer(1));
      }
      else
      {
        scannedItemsMap.put(item, itemCount.intValue() + 1);
      }
    }
    
    //calculates the total cost of the scanned items
    Set<String> keys = scannedItemsMap.keySet();
    for(String key: keys)
    {
      List<Product> pricingList = priceMap.get(key);
      int productInstances = scannedItemsMap.get(key).intValue();
      
      for(int i = pricingList.size()-1; i>=0; i--)
      {
        Product product = pricingList.get(i);
        total = total + productInstances/product.getQuantity() * product.getPrice();
        productInstances = productInstances % product.getQuantity();
      }
    }
    return total;
  }
}