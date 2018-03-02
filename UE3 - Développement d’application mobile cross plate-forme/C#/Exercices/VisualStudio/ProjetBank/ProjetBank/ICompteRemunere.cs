using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace ProjetBank
{
    interface ICompteRemunere
    {



        double calculInterets();        
        
        void verserInterets();

        double getTaux();
       
        void setTaux(double taux);

    }
}
