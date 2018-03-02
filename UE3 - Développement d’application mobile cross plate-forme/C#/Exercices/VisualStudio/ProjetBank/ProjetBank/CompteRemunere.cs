using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace ProjetBank
{
    class CompteRemunere : Compte, ICompteRemunere 
    {


        double taux;
        public CompteRemunere()
        {
            this.solde = 0;
            this.numero = -1;
            this.taux = 0;
        }

        public CompteRemunere(double taux, int numero, double unSoldeInitial)
        {
            this.taux = taux;
            this.solde = unSoldeInitial;
            this.numero = numero;

        }


        public double getTaux()
        {
            return this.taux;
        }

        
        public void setTaux(double taux)
        {
           
            this.taux = taux;
        }

        public double calculInterets()
        {
            return getSolde() * this.getTaux();
        }


        public void verserInterets()
        {
            ajouter(this.calculInterets());
        }


        public String toString()
        {
            return "Compte Epargne" + toString() + "taux=" + this.getTaux();
        }


    }
}
