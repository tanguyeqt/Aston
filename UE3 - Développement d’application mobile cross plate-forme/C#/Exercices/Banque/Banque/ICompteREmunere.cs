using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Banque
{
    interface ICompteRemunere
    {
        double Taux { get;  }

        double CalculerInterer();

        void VerserInteret();

    }
}
