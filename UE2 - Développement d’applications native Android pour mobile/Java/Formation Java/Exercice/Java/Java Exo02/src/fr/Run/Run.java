package fr.Run;
import fr.dessin.Point2D.Point2D;
import fr.dessin.Point2D.Point3D;;

public class Run {

	public static void main(String[] args) {
	
			Point2D p1 = new Point2D();
			System.out.println(p1);			
			Point2D p2 = new Point2D();
			System.out.println(p2);

			if (p1 == p2) {
				System.out.println("p1 == p2");
			} else {
				
				System.out.println("p1 != p2");
			}
			
			p1 = p2;
			if (p1 == p2) {				
				System.out.println("p1 == p2");
			} else {
				System.out.println("p1 != p2");
			}

	
			Point3D p3 = new Point3D(5, 5, 5);
			System.out.println(p3);
		
			p3.setX(25);
			p3.setY(32);
			p3.translate(5, 8);	
			p3.setZ(55);
			p3.translater(10, 10, 5);
			
			System.out.println(p3);
		}

}
