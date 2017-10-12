package value;

import java.util.ArrayList;

/**
 * The class for bargain finders.
 * 
 * @author MichaelAlbert
 */
public class BargainFinder {
    
    private SiteInfo site;
    private CustomerInfo customer;
    private int budget;
    private ArrayList<String> bestList;
    private int bestValue;

    public BargainFinder(SiteInfo site, CustomerInfo customer, int budget) {
        this.site = site;
        this.customer = customer;
        this.budget = budget;
    }
    
    public ArrayList<String> shoppingList() {
      bestList = new ArrayList<String>();
      findItems(bestList, customer.getItems().size());
      if(bestList.isEmpty()){
        int currentValue = 0;
        for(String s: customer.getItems()){
          bestList.add(s);
          currentValue += customer.getValue(s);
        }
        bestValue = currentValue;
      }
      System.out.println(bestValue);
      return bestList;
    }
    
    public void findItems(ArrayList<String> items, int pos){
      for(int i = pos; i < customer.getItems().size(); i++){
        if(!items.contains(customer.getItems().get(i))){
          items.add(customer.getItems().get(i));
          //if we have blown our budget
          if(site.getCost(items) > budget){
            items.remove(customer.getItems().get(i));
            
            //if the bestList is empty.
            if(bestList.size() == 0){
              int currentValue = 0;
              for(int j = 0; j < items.size(); j++){
                currentValue += customer.getValue(items.get(j));
                bestList.add(items.get(j));
              }
              bestValue = currentValue;
            } else {
              int currentValue = 0;
              for(int j = 0; j < items.size(); j++){
                currentValue += customer.getValue(items.get(j));
              }
              if(currentValue > bestValue){
                bestList = new ArrayList<String>();
                for(int j = 0; j < items.size(); j++){
                  bestList.add(items.get(j));
                }
                bestValue = currentValue;
              }              
            }
            //if we still have money to spend  
          } else {
            findItems(items, pos+1);
            items.remove(customer.getItems().get(i));                        
          }
        }
      }
      
    }
    
}
