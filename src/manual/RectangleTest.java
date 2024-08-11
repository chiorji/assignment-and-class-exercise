package manual;

public class RectangleTest {
    public static void main(String[] args) {
        Rectangle rect = new Rectangle(3.5, 6);
        rect.showDimensions();
        double area = rect.findArea();
        System.out.println("Area1:" + area);
        double perimeter = rect.findPerimeter();
        System.out.println("Perimeter1: " + perimeter);
        
        rect.setDimensions(5, 5);
        rect.showDimensions();
        area = rect.findArea();
        System.out.println("Area2: " + area);
        
        perimeter = rect.findPerimeter();
        System.out.println("Perimeter2: " + perimeter);
    }
}
