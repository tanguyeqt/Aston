using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace ProjetBank
{
    class Program
    {
        static void Main(string[] args)
        {

            Compte c1 = new Compte(1, 100);
            c1.Afficher();
            c1.ajouter(1500);
            c1.Afficher();


            Client cl1 = new Client("Equinet", "Tanguy", 21, 1);


            CompteRemunere cr1 = new CompteRemunere(1.2, 1, 100);

            cr1.calculInterets();
            cr1.verserInterets();

            


            Console.ReadLine();

            
          



        }
    }
}
