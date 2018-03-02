using System;
using System.Collections.Generic;
using System.Data.Entity;
using System.Linq;
using System.Web;

namespace MonAppliWeb.Models
{
    public class Movie
    {

        public int ID { get; set; }
        public string Title { get; set; }
        public string Genre { get; set; }
        public int Price { get; set; }
        public DateTime RelaseDate { get; set; }


    }


    public class MovieDbContext : DBContext
    {
        public DBSet<Movie>Movies { get; set; }
    }
}