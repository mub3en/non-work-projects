import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.*;

public class TestShapes {

	interface Shape {
		double area();
		double perimeter();
	}

	class Circle implements Shape {
		private double radius;
		final double pi = Math.PI;

		public Circle() {
			this(1);
		}

		public Circle(double radius) {
			this.radius = radius;
		}

		@Override
		public double area() {
			// A = π r^2
			return pi * (radius * radius);
		}

		public double perimeter() {
			// P = 2πr
			return 2 * pi * radius;
		}
	}

	class Rectangle implements Shape {
		private double width, length; 

		public Rectangle() {
			this(1, 1);
		}

		public Rectangle(double width, double length) {
			// implement me
			this.width = width;
			this.length = length;
		}

		@Override
		public double area() {
			// A = w * l
			return width * length;
		}

		@Override
		public double perimeter() {
			// P = 2(w + l)
			return 2 * (width + length);
		}

	}

	class Triangle implements Shape {
		private final double a, b, c; // sides

		public Triangle() {
			this(1, 1, 1);
		}

		public Triangle(double a, double b, double c) {
			this.a = a;
			this.b = b;
			this.c = c;
		}

		@Override
		public double area() {
			// Heron's formula:
			// A = SquareRoot(s * (s - a) * (s - b) * (s - c))
			// where s = (a + b + c) / 2, or 1/2 of the perimeter of the triangle
			double s = (a + b + c) / 2;
			return Math.sqrt(s * (s - a) * (s - b) * (s - c));
		}

		@Override
		public double perimeter() {
			// P = a + b + c
			return a + b + c;
		}
	}
	
	class Octagon implements Shape {
		private double sides; // sides

		public Octagon() {
			this(1);
		}

		public Octagon(double sides) {
			this.sides = sides;
		}

		@Override
		public double area() {
			// Area of an Octagon =  2a^2(1+SquareRoot(2))
			return 2 * ( sides * sides) * (1 + Math.sqrt(2));
		}

		@Override
		public double perimeter() {
			// P = a + b + c
			return 8 * sides;
		}
	}

	public void testShapes() {
		double radius = 7;
		double width = 5, length = 7;
		double a = 3, b = 4, c = 2;
		double side = 35; 
		Shape circle = new Circle(radius);
		Shape rectangle = new Rectangle(width, length);
		Shape triangle = new Triangle(a, b, c);
		Shape octagon = new Octagon(side);

		ArrayList<Shape> shapes = new ArrayList<>();
		shapes.add(circle);
		shapes.add(rectangle);
		shapes.add(triangle);
		shapes.add(octagon);

		// Limit precision to two or three decimal points.
		DecimalFormat df = new DecimalFormat();
		df.setMaximumFractionDigits(2);

		System.out.println("\n");
		ListIterator<Shape> iterator = shapes.listIterator();
		while (iterator.hasNext()) {
			Shape shape = iterator.next();
			System.out.println(shape.getClass().getSimpleName() + " area: " + df.format(shape.area()));
			System.out.println(shape.getClass().getSimpleName() + " perimeter " + df.format(shape.perimeter()));
		}
		
		//OR 
		
//		for (Shape shape:shapes) {
//		    System.out.println(shape.getClass().getSimpleName() + " area: " + df.format(shape.area()));
//		      System.out.println(shape.getClass().getSimpleName() + " perimeter " + df.format(shape.perimeter()));
//		}



	}

	public static void main(String[] args) {
		TestShapes ts = new TestShapes();
		ts.testShapes();
	}
}
