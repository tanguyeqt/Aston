using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace ProjetBank
{
    interface ICompteASeuil
    {


        void retirer(double unMontant);
        
        double getSeuil();

        void setSeuil(double unSeuil);


    }
}
