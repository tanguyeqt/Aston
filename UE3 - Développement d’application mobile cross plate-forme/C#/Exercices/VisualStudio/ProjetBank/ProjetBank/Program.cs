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

            Client client = new Client(1, "Dupont", "Henry", 28);
            // Creation des comptes
            Compte c0 = new Compte(0, 200);
            Compte c1 = new Compte(1, 1000);
            CompteASeuil c2 = new CompteASeuil(2, 4600, 100);
            CompteRemunere c3 = new CompteRemunere(3, 400, 0.10);
            CompteRemunere c4 = new CompteRemunere(4, 600, 0.50);
            
                client.ajouterCompte(c0);
                client.ajouterCompte(c1);
                client.ajouterCompte(c2);
                client.ajouterCompte(c3);
                client.ajouterCompte(c4);


            
           
                
          

        }

    }





}
 
