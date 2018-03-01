using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace ProjetBank
{
    class CompteRemunere : Compte
    {


        double taux;


        public CompteRemunere(double taux, int numero, double solde)
        {
            this.taux = taux;
            this.solde = solde;
            this.numero = numero;

        }

        public void calculInterets()
        {
            solde = solde * (1 + taux / 100);
        }


        public void verserInterets()
        {
            this.setSolde(this.getSolde() + solde);
        }


        public String toString()
        {
            return "Compte Epargne" + toString() + "taux=" + taux;
        }


    }
}
