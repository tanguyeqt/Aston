using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Point2D
{
    class Point2D
    {
        int x, y;

        public void Afficher()
        {

            Console.WriteLine(string.Format("Votre point à pour absicce {0} et pour ordonnée {1}", this.x, this.y));


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


        public void Translate(int dX, int dY)
        {
            this.x += dX;
            this.y += dY;
        }


    }
}

