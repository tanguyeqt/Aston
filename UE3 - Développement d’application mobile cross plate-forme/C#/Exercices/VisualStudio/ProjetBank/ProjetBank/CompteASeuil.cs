using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace ProjetBank
{
    class CompteASeuil:Compte
    {

        double seuil;


        public CompteASeuil(double seuil)
        {
            this.seuil = seuil;
        }



        public String toString()
        {
            return "Compte Epargne" + toString() + "seuil=" + seuil;
        }


        public void retirer(double uneValeur)
        {
            if(solde + uneValeur > seuil)
            {
                setSolde(getSolde() - uneValeur);
            }
            else
            {
                Console.WriteLine("Impossible de retirer");

            }
        }



    }
}
