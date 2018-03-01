using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace ProjetBank
{
    class Compte
    {

       protected int numero;
       protected double solde;
        
        public Compte()
        {

        }

        public Compte(int numero, double solde)
        {
            this.solde = solde;
            this.numero = numero;
        }

        public double getSolde()
        {
            return solde;
        }

        public int getNumero()
        {
            return numero;
        }

        public void setSolde(double solde)
        {
            this.solde = solde;
        }

        public void setNumero(int numero)
        {
            this.numero = numero;
        }  




        public void ajouter(double unMontant)
        {

            this.setSolde(this.getSolde()+unMontant);


        }

        public void retirer(double unMontant)
        {

            this.setSolde(this.getSolde() - unMontant);
            
        }

        public void Afficher()
        {
            Console.WriteLine("Le montant de votre solde est de " + this.solde);

        }

        public String toString()
        {
            StringBuilder s = new StringBuilder();

          
            s.Append(" Solde: ");
            s.Append(this.getSolde());
            s.Append(" Numero: ");
            s.Append(this.getNumero());
            s.Append("\n");           
            return s.ToString();
        }



    }
}
