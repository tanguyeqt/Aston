using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Banque
{
    class CompteRemunere : Compte, ICompteRemunere
    {
        public double Taux { get ; private set ; }

        public CompteRemunere(int unNumero, int unSoldeInitial = 0, double taux=0) : base(unNumero, unSoldeInitial)
        { this.Taux = taux; }

        public virtual double CalculerInterer()
        {
            return this.Solde * this.Taux;
        }

        public void VerserInteret()
        {
            this.Solde += CalculerInterer();
        }
    }
}
