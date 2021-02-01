package programmes;

public class TestGeometricObject {

	public static void main(String[] args) {
		GeometricObject[] shapes = new GeometricObject[5];
		shapes[0] = new Square();
		shapes[1] = new Square(2,"yellow",true);
		shapes[2] = new Circle(2.5,"turquoise",false);
		shapes[3] = new Circle(3,"pink",true);
		shapes[4] = new Square(3,"blue",true);
		
		for(int i=0; i<5; i++) {
			
			shapes[i].howToColour();
			System.out.println("This shape's area is " + shapes[i].getArea() +".\n");
		}
	}

}
