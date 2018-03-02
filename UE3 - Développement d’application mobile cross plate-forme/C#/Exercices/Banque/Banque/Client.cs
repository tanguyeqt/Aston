using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Banque
{
    class Client
    {
        public string Nom { get; private set; }

        public string Prenom { get; private set; }

        public DateTime DOB { get; private set; }

        public int Age
        {
            get
            {
                return (DateTime.Now - DOB).Days/365;
            }
        }

        public SortedList<int, Compte> Comptes { get; private set; }
        //public List<Compte> Comptes { get; private set; }

        public Client(string prenom, string nom, DateTime dob)
        {
            this.Prenom = prenom;
            this.Nom = nom;
            this.DOB = dob;
            //Comptes = new List<Compte>();
            Comptes = new SortedList<int, Compte>();
        }



        public void AjouterCompte(Compte compte)
        {
            if (Comptes.Count<5)
            {
                //compte.DepassSeuilEvent += Compte_DepassSeuilEvent;
                compte.DepassSeuilEvent += new SeuilEventHandler(Compte_DepassSeuilEvent);
                //Comptes.Add(compte);
                Comptes.Add(compte.Numero, compte);
            }
        }

        private void Compte_DepassSeuilEvent(object sender, EventArgs e)
        {
            Compte cpt= sender as Compte;
            Console.WriteLine("Dépassement de Seuil pour le compte n° {0}", cpt.Numero);
        }

        public Compte GetCompte(int numeroCompte)
        {
            //valable uniquement pour une Liste et pas la SortedList
            //var cpt = Comptes.Where(cpte => cpte.Numero == numeroCompte).FirstOrDefault();

            Compte cpt = Comptes[numeroCompte];

            return cpt;
        }

        public override string ToString()
        {
            return base.ToString();
        }
    }
}
