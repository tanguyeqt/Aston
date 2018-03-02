using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Banque
{
    class Program
    {
        static void Main(string[] args)
        {
            Client cAlain = new Client("Alain", "Bastardie", new DateTime(1990, 08, 01));
            cAlain.AjouterCompte(new Compte(1, 10000));
            cAlain.AjouterCompte(new CompteASeuil(2, 500));
            cAlain.AjouterCompte(new CompteRemunere(3, 100,0.1));
            cAlain.AjouterCompte(new CompteASeuilRemunere(4, 300,0.05));
            cAlain.AjouterCompte(new Compte(5, 50));

            Console.WriteLine(cAlain.Comptes[1].ToString());
            cAlain.Comptes[1].Retirer(5000);
            Console.WriteLine(cAlain.Comptes[1].ToString());

            Console.WriteLine(cAlain.Comptes[1].ToString());
            cAlain.Comptes[1].Ajouter(1000);
            Console.WriteLine(cAlain.Comptes[1].ToString());

            Console.WriteLine(cAlain.Comptes[3].ToString());
            cAlain.Comptes[2].Ajouter(1000);
            ((CompteRemunere)cAlain.Comptes[3]).VerserInteret();
            Console.WriteLine(cAlain.Comptes[3].ToString());

            Compte cpt = cAlain.GetCompte(5);
            cpt.Retirer(200);

            Console.WriteLine("C'est fini");
            Console.ReadLine();
        }
    }
}
