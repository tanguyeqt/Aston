using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Point2D
{
    class Point3D : Point2D
    {

        int z;
        

        public Point3D()
        {
            z = 0;
        }

        public Point3D(int x, int y , int z)
        {
            this.x = x;
            this.y = y;
            this.z = z;
        }

        public int Z { get; set; }

        public void Afficher()
        {

            Console.WriteLine(string.Format("Votre point à pour absicce {0} et pour ordonnée {1} et comme point z {2}", this.x, this.y, this.z));


        }


        public void Translate(int dX, int dY, int dZ)
        {
            this.x += dX;
            this.y += dY;
            this.z += dZ;
        }



    }

}

