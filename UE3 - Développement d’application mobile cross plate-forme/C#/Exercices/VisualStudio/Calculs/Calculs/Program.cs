using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Calculs
{
    class Program
    {
        static void Main(string[] args)
        {
            double CalculMoyenne(List<double> liste1)
            {
                double somme = 0;
                foreach (double valeur in liste1)
                {
                    somme += valeur;
                }
                return somme / liste1.Count;
            }
            List<double> liste = new List<double> { 1.0, 5.5, 9.9, 2.8, 9.6 };
            Console.WriteLine(CalculMoyenne(liste));
            
            Console.ReadLine();

          
        }

        
    }
}
