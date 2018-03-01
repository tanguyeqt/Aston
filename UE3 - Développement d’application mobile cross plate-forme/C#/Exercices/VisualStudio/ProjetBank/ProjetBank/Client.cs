using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace ProjetBank
{
    class Client
    {
        string nom;
        string prenom;
        int age;
        int numero;
        Compte[] tabCompte;




        public Client(string nom, string prenom, int age, int numero)
        {
            this.tabCompte = tabCompte;
            this.nom = nom;
            this.prenom = prenom;
            this.age = age;
            this.numero = numero;
        }


        public string getNom()
        {
            return nom;
        }

        public void setNom(string nom)
        {
            this.nom = nom;
        }


        public string getPrenom()
        {
            return prenom;
        }


        public void setPrenom(string prenom)
        {
            this.prenom = prenom;
        }


        public int getAge()
        {
            return age;
        }

        public void setAge()
        {
            this.age = age;
        }

        public int getNumero()
        {
            return numero;
        }

        public void setNumero(int numero)
        {
            this.numero = numero;
        }

        public Compte[] getTabCompte()
        {
            return tabCompte;
        }

        public void setTabCompte(Compte[] tabCompte)
        {
            this.tabCompte = tabCompte;

        }

        public String toString()
        {
            StringBuilder s = new StringBuilder();           

            s.Append(this.getNom());
            s.Append(" Prenom: ");
            s.Append(this.getPrenom());
            s.Append(" Age: ");
            s.Append(this.getAge());
            s.Append("\n");
            for (int i = 0; i < this.tabCompte.Length; i++)
            {
                if (this.tabCompte[i] != null)
                {
                    s.Append(this.tabCompte[i]);
                    s.Append("\n");
                }
            }
            return s.ToString();
        }


        public void ajouterCompte(Compte unCompte)
        {
            Boolean ajoute = false;

            for (int i = 0; !ajoute && i < this.tabCompte.Length; i++)
            {

                if (this.tabCompte[i] == null)
                {
                    this.tabCompte[i] = unCompte;
                    ajoute = true;
                }
            }
        }


        public Compte getCompte(int numeroCompte)
        {

            for (int i = 0; i <numeroCompte; i++)
            {
                if()
                {

                }
            }



        }


     
      



    }
}
