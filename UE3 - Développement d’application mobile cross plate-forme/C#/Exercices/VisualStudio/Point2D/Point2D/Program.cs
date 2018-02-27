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


            Console.WriteLine("Je crée mon premier point");
            Point2D p2 = new Point2D();
            p2.SetX(23);
            p2.SetY(25);
            p2.Afficher();
            p2.Translate(10, 60);
            p2.Afficher();



            Point2DBis p3 = new Point2DBis();
            p3.Y = 110;

            Console.ReadLine();





        }
    }
}
