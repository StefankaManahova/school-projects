package programmes;

public class Square extends GeometricObject {

	private double side;
	
	public Square() {
		super();
		this.side = 1;
	}
	
	public Square(double side) {
		super();
		this.setSide(side);
	}
	public Square(double side,String colour, boolean filled) {
		super(colour,filled);
		this.setSide(side);
	}

	public double getSide() {
		return side;
	}

	public void setSide(double side) {
		this.side = side;
	}
	
	public double getArea() {
		return side*side;
	}
	@Override
	public void howToColour() {
		if(this.isFilled()) {
			System.out.println("Paint the area of the square "+this.getColour()+".");
		}
		else {
			if("white".equals(this.getColour())) {
				System.out.println("Paint all four sides black.");
			}
			else {
				System.out.println("Paint all four sides "+this.getColour()+".");
			}
		}
	}
}
