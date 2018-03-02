using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Banque
{
    class CompteASeuilRemunere : CompteRemunere, ICompteASeuil
    {
        public double Seuil {get;private set;}

        public CompteASeuilRemunere(int unNumero, int unSoldeInitial = 0, double taux=0) : base(unNumero, unSoldeInitial,taux)
        { }


        public override void Retirer(double unMontant)
        {
            if ((Solde-unMontant)>=Seuil)
            {
                base.Retirer(unMontant);
            }
            
        }

    }
}
