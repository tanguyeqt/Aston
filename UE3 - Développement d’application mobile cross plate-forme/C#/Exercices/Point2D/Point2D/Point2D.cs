using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Point2D
{
    class Point2D
    {
        private static int compteur;

        public Point2D()
        {
            compteur++;
        }

        int x, y;

        public void Afficher()
        {
            Console.WriteLine(string.Format("Votre point N° {2} à pour abcisse {0} et pour ordonnée {1}", this.x, this.y, GetCompteur()));
        }

        public void SetX(int x)
        {
            this.x = x;
        }

        public void SetY(int y)
        {
            this.y = y;
        }

        public int GetX()
        {
            return this.x;
        }

        public int GetY()
        {
            return this.y;
        }


        public static int GetCompteur()
        {
            return compteur;
        }

        public void Translater(int dX, int dY)
        {
            this.x += dX;
            this.y += dY;
        }
    }

}
