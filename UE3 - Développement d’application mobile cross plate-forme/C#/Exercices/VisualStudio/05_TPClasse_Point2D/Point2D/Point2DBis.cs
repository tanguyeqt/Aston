using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Point2D
{
    class Point2DBis
    {
        public static int Compteur { get; private set; }

        public Point2DBis()
        {
            Compteur++;
        }

        private int x;
        public int X
        {
            get { return x; }
            set { x = value; }
        }
   
        public int Y { get; set; }

        public void Afficher()
        {
            Console.WriteLine(string.Format("Votre point à pour abcisse {0} et pour ordonnée {1}", this.X, this.Y));
        }

        public void Translater(int dX, int dY)
        {
            this.x += dX;
            this.Y += dY;
        }
    }
}
