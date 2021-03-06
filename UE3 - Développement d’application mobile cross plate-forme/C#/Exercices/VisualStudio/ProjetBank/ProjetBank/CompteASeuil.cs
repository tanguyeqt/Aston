﻿using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace ProjetBank
{
    class CompteASeuil: Compte,ICompteASeuil
    {

        double seuil;

        public CompteASeuil()
        {
            this.seuil = 0;
            this.numero = -1;
            this.solde = 0;
        }

        public CompteASeuil(double seuil, double unSoldeInitial, int numero)
        {
            this.seuil = seuil;
            this.solde = unSoldeInitial;
            this.numero = numero;
        }


        public double Seuil { get; private set;  }

        public String toString()
        {
            return "Compte Epargne" + toString() + "seuil=" + this.Seuil;
        }


        public void retirer(double unMontant) 
        {

        double simu = this.getSolde() - unMontant;
		if (simu <= this.Seuil) {
			
    } else {
			retirer(unMontant);
		}
	}



    }
}
