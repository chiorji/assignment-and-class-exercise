package manual;

public class Rectangle {
    protected double length;
    protected double width;
    
    public Rectangle(double length, double width){
        this.setDimensions(length, width);
    }
    
    public double findArea() {
        return this.length * this.width;
    }
    
    public double findPerimeter() {
        return (2 * this.length) + (2 * this.width);
    }
    
    public void showDimensions() {
        System.out.println("Length: " + this.length + ", Width: " + this.width);
    }
    
    public void setDimensions(double length, double width) {
        this.length = length;
        this.width = width;
    }
}
