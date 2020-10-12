package sample;

import java.util.HashMap;
import java.util.Map;

public class Controller {

    public static HashMap<String, Customer> customerMap = new HashMap<>();

    public static void printMap()   {
        for(Map.Entry<String,Customer> m :Controller.customerMap.entrySet()){
            System.out.println((m.getKey()+"="+m.getValue()));
        }
    }
}
