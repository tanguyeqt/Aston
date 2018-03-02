using MonAppliWeb.Models;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.Mvc;

namespace MonAppliWeb.Controllers
{
    public class HelloWorldController : Controller
    {
        // GET: HelloWorld
        public ActionResult Index()
        {
            List<Movie> Movies = new List<Movie>();
            Movies.Add(
                new Movie { ID = 1, Title = "Harry Potter", Genre = "Fantastique", Price = 10, RelaseDate = new DateTime(2001, 11, 11) });
            Movies.Add(
               new Movie { ID = 1, Title = "Star Wars", Genre = "SF", Price = 10, RelaseDate = new DateTime(1977, 11, 11) });

            ViewBag.Title = "Mes Films";
            return View(Movies);
        }

        public string MonAction()
        {
            return "<h1>C'est mon Action à moi que j'ai faite</h1>";
        }

        public ActionResult Coucou(string id)
        {
            ViewBag.MessageCoucou = "Coucou" + id;
            return View();
        }
    }
}