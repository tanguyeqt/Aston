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
            Console.WriteLine("***********Je crée mon premier Point*********");
            Point2D p1 = new Point2D();
            p1.SetX ( 10);
            p1.SetY (5);
            p1.Afficher();
            p1.Translater(45, 15);
            p1.Afficher();
            Console.WriteLine("***********Je crée mon deuxième Point*********");
            Point2D p2 = new Point2D();
            p2.SetX(15);
            p2.SetY(40);
            p2.Afficher();
            p2.Translater(45, 15);
            p2.Afficher();

            Console.WriteLine("vous avez créé " + Point2D.GetCompteur() + " point(s)");

            Console.WriteLine("************** Point2DBIs ***************");

            Console.WriteLine("***********Je crée mon premier Point*********");
            //Méthode Classique
            //Point2DBis p3 = new Point2DBis();
            //p3.X=10;
            //p3.Y=5;
            //Méthode du fainéantAlain avec intialiseur de classe
            Point2DBis p3 = new Point2DBis {X=10,Y=5 };
            p3.Afficher();
            p3.Translater(45, 15);
            p3.Afficher();
            Console.WriteLine("***********Je crée mon deuxième Point*********");
            Point2DBis p4 = new Point2DBis();
            p4.X=15;
            p4.Y=40;
            
            p4.Afficher();
            p4.Translater(45, 15);
            p4.Afficher();

            Console.WriteLine("vous avez créé " + Point2DBis.Compteur + " point(s)");

            Console.ReadLine();
        }
    }
}
