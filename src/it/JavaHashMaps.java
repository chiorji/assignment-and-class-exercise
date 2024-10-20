package it;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class JavaHashMaps {
    public static void main(String[] args) {
        nonParameterizedHashMap();
        System.out.println();
        parameterizedHashMap();
    }
    
    public static void nonParameterizedHashMap() {
        HashMap users = new HashMap<>();
        
        users.put("kealy", 32);
        users.put("hey", "always available");
        
        if (users.containsKey("hey")) {
            System.out.println("Contains hey key");
        } else {
            System.out.println("Does not contain hey key");
        }
        
        System.out.println(users.get("kealy"));
        System.out.println(users.get("hey"));
        
        System.out.println("Keys: " + users.keySet());
        System.out.println("Values: " + users.values());
        System.out.println("Entire set: " + users.entrySet());
        
        // iterate over key-value pairs
        Iterator it = users.entrySet().iterator();
        
        while (it.hasNext()) {
            Map.Entry pair = (Map.Entry) it.next();
            System.out.println(pair.getKey() + " = " + pair.getValue());
        }
        
        System.out.println("...using enhanced for-loop...");
        for (Object o : users.entrySet()) {
            Map.Entry pair = (Map.Entry) o;
            System.out.println(pair.getKey() + " = " + pair.getValue());
        }
    }
    
    public static void parameterizedHashMap() {
        System.out.println("...Parameterized HashMap...");
        HashMap<String, Object> objects = new HashMap<>();
        objects.put("age", 100);
        objects.put("gender", "Girl");
        
        for(Object o : objects.entrySet()) {
            Map.Entry<String, Integer> pair = (Map.Entry) o;
            System.out.println(pair.getKey() + " = " + pair.getValue());
        }
    }
}
