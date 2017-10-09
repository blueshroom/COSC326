package value;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Scanner;
import java.util.ArrayList;

/**
 * Read site and customer info from command argument filenames, and test bargain
 * finder on them.
 * 
 * @author Michael Albert
 */
public class App {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        //Scanner siteReader = new Scanner(new File(args[0]));
        HashMap<String, Integer> siteData = new HashMap<String, Integer>();
//        while (siteReader.hasNextLine()) {
//            Scanner sc = new Scanner(siteReader.nextLine());
//            String item = sc.next();
//            int cost = sc.nextInt();
//            siteData.put(item, cost);
//            System.out.println(item + " " + cost);
//        }
        //System.out.println();
        //Scanner customerReader = new Scanner(new File(args[1]));
        HashMap<String, Integer> customerData = new HashMap<String, Integer>();
//        while (customerReader.hasNextLine()) {
//            Scanner sc = new Scanner(customerReader.nextLine());
//            String item = sc.next();
//            int value = sc.nextInt();
//            customerData.put(item, value);
//            System.out.println(item + " " + value);
//        }
        customerData.put("cat", 5);
        customerData.put("dog", 11);
        customerData.put("frog", 8);
        customerData.put("sheep", 10);
        
        siteData.put("dog", 4);
        siteData.put("cat", 10);
        siteData.put("frog", 2);
        siteData.put("sheep", 1);
        SiteInfo site = new SimpleSite(siteData);
        CustomerInfo customer = new Customer(customerData);
        
//         ArrayList<String> items = new ArrayList<String>();
//        items.add("Cat");
//        System.out.println(items + " " + site.getCost(items));
//        items.add("Frog");
//        System.out.println(items + " " + site.getCost(items));
        
       
        
        BargainFinder bf = new BargainFinder(site, customer, 12);
        for(String s: bf.shoppingList()) System.out.println(s);
        
        
    }
    
}
