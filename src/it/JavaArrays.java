package it;

import java.util.ArrayList;
import java.util.Arrays;

public class JavaArrays {
    public static void main(String[] args) {
        ArrayList<String> animals = new ArrayList<>();
        animals.add("chihuahua");
        animals.add("pussy cat");
        animals.add("monkey");
        
        int size = animals.size();
        
        for (String animal : animals) {
            System.out.println("Animal: " + animal);
        }
        
        System.out.println("Size: " + size);
        
        System.out.println();
        
        ArrayList<Object> randomObjects = new ArrayList<>();
        randomObjects.add(12);
        randomObjects.add("Hello World!");
        randomObjects.add("Parrot");
        randomObjects.add(1, "Warthog");
        
        int objSize = randomObjects.size();
        
        for(Object object : randomObjects) {
            System.out.println(object);
        }
        
        System.out.println("Object size: " + objSize);
        System.out.println();
        // sorting arrays
        arraySort();
    }
    
    public static void arraySort() {
        String[] siblings = {"Alice", "Mark", "Joy", "Mr. Nice", "Juliana"};
        Arrays.sort(siblings);
        
        for(String sibling : siblings) {
            System.out.println(sibling);
        }
    }
}
