using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Point2D
{
    class Program
    {
        static void Main(string[] args)
        {

            Console.WriteLine("Je crée mon premier point");
            Point2D p1 = new Point2D();
            p1.SetX(10);
            p1.SetY(5);
            p1.Afficher();
            p1.Translate(45,15);
            p1.Afficher();


            Console.WriteLine("Je crée mon deuxieme point");
            Point2D p2 = new Point2D(23, 26);            
            p2.Afficher();
            p2.Translate(10, 60);
            p2.Afficher();


            Console.WriteLine("Je crée mon troisieme point");
            Point3D p3 = new Point3D(23, 26, 65);
            p3.Afficher();
            p3.Translate(10, 60, 65);
            p3.Afficher();

            Console.ReadLine();





        }
    }
}
