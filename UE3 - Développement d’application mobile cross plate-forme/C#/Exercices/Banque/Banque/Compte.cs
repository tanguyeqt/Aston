using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Banque
{
    //Par convention  la méthode qui gère un événement est de type void
    //reçoit 2 arguments:
    //Object sender, qui représente l'objet qui a levé/généré l'événement
    //EventArgs e, qui représente les Argumants de l'événements, pour 
    //donner un complément d'infos sur l'événement
    public delegate void SeuilEventHandler(object sender, EventArgs e);

   public  class Compte
    {
        private static int compteur;

        public double Solde { get; protected set; }
        public int Numero { get; private set; }
        public event SeuilEventHandler DepassSeuilEvent;

        public Compte():this(0)
        { }

        public Compte(int unNumero, int unSoldeInitial = 0)
        {
            compteur++;
            this.Numero = unNumero;
            this.Solde = unSoldeInitial;
            DepassSeuilEvent = null;
        }

        public virtual void Ajouter(double unMontant)
        { this.Solde += unMontant; }

        public virtual void Retirer(double unMontant)
        {
            if ((Solde - unMontant) < 0)
            {
                if (DepassSeuilEvent != null)
                {
                    EventArgs e = new EventArgs();
                    DepassSeuilEvent(this, e);
                }
            }
            else
            {
                this.Solde -= unMontant;
            }
        }

        public override string ToString()
        {
            return string.Format("Je suis le Compte N°{0} et mon solde est de {1}",
                this.Numero, this.Solde);
        }
    }
}
