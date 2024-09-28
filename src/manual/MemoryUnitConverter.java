package manual;

public class MemoryUnitConverter {
    
    public static void main(String[] args) {
        double baseValue = 512;
        double bitToByteValue = convertBitToByte(baseValue);
        double byteToBitValue = convertByteToBit(baseValue);
        
        double megaByteValueToKilobits = convertMegaBytesToKilobits(baseValue);
        double kilobitsToMegabytes = convertKilobitsToMegabytes(baseValue);
        
        System.out.println(baseValue + " bits --> " + bitToByteValue + " Bytes");
        System.out.println(baseValue + " Bytes --> " + byteToBitValue + " bits");
        
        System.out.println(baseValue + " MegaByte --> " + megaByteValueToKilobits + " Kilobits");
        System.out.println(baseValue + " Kilobits --> " + kilobitsToMegabytes + " MegaBytes");
    }
    
    public static double convertBitToByte(double bits) {
        return bits / 8;
    }
    
    public static double convertByteToBit(double bytes) {
        return bytes * 8;
    }
    
    public static double convertMegaBytesToKilobits(double megabyte) {
        double byteBaseValue = megabyte * 1024 * 1024;
        return byteBaseValue * 8 / 1000;
    }
    
    
    public static double convertKilobitsToMegabytes(double kilobits) {
        double bitBaseValue = kilobits * 1000;
        double bitsToBytes = bitBaseValue / 8;
        return bitsToBytes / 1024 / 1024;
    }
}
