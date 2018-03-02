using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Banque
{
    public class CompteASeuil : Compte, ICompteASeuil
    {
        

        public CompteASeuil(int unNumero, int unSoldeInitial = 0) : base(unNumero, unSoldeInitial) { }

        public double Seuil { get; private set; }

        public override void Retirer(double unMontant)
        {
            if ((Solde - unMontant) >= Seuil)
            {
                base.Retirer(unMontant);
            }
        }
    }
}
