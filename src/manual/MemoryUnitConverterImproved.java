package manual;
import java.util.*;

public class MemoryUnitConverterImproved {
    static Scanner s = new Scanner(System.in);
    
    public static void main(String[] args) {
        int ops;
        System.out.println("What operation do you want to perform? ");
        System.out.println("0: Exit program");
        System.out.println("1: Convert bits to bytes");
        System.out.println("2: Convert bytes to bits");
        System.out.println("3: Convert kilobits to kilobytes");
        
        ops = s.nextInt();
        
        switch (ops) {
            case 1:
                System.out.print("Provide a value in bits: ");
                double v = s.nextDouble();
                double bytesValue = bitsToBytes(v);
                System.out.print(v + " bits = " + bytesValue + " bytes");
                break;
            
            case 2:
                System.out.print("Provide a value bytes: ");
                double n = s.nextDouble();
                double bitValue = bytesToBits(n);
                System.out.print(n + " bytes = " + bitValue + " bits");
                break;
            
            case 3:
                System.out.print("Provide a value kilobits: ");
                double m = s.nextDouble();
                double kilobyteValue = kilobitsToKiloBytes(m);
                System.out.print(m + " kilobits = " + kilobyteValue + " kilobytes");
                break;
            
            default:
                System.out.print("Program terminated: " + ops);
                System.exit(0);
        }
        
        s.close();
    }
    
    public static double bitsToBytes(double bits) {
        return bits / 8;
    }
    
    public static double bytesToBits(double bits) {
        return bits * 8;
    }
    
    public static double kilobitsToKiloBytes(double kilobits) {
        double basebit = kilobits * 1000;
        double basebyte = basebit / 8;
        return basebyte / 1024;
    }
}
