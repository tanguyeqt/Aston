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




        public Client()
        {
            this.prenom = null;
            this.nom = null;
            this.numero = -1;
            this.age = 0;

        }
          
        public Client(int unNumero, String unNom, String unPrenom, int unAge)
        {
           
            this.setNom(unNom);
            this.setPrenom(unPrenom);
            this.setAge(unAge);         
            this.tabCompte = new Compte[5];
            this.setNumero(unNumero);
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

        public void setAge(int age)
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

        public Compte getCompte(int unNumero)
        {
            for (int i = 0; i < this.tabCompte.Length; i++)
            {
                if (this.tabCompte[i] != null && this.tabCompte[i].getNumero() == unNumero)
                {
                    return this.tabCompte[i];
                }
            }
            return null;
        }









    }
}
