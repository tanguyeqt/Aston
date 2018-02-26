using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace HelloTime
{
    class Program
    {
        static void Main(string[] args)
        {
            

            string hello = "Bonjour {0}";

            if (DateTime.Now.DayOfWeek.ToString().Equals("Saturday") || DateTime.Now.DayOfWeek.ToString().Equals("Sunday"))
            {

                hello = "Bon week-end {0}";
            }
            else
            {               
                if (DateTime.Now.DayOfWeek.ToString().Equals("Monday") && DateTime.Now.Hour < 9)
                {

                    hello = "Bon week-end {0}";
                }
                else
                {
                    if (DateTime.Now.Hour >= 9 && DateTime.Now.Hour < 18)
                    {

                        hello = "Bonjour {0}";
                    }
                    else
                    {
                       

                        if (DateTime.Now.DayOfWeek.ToString().Equals("Friday") && DateTime.Now.Hour >= 18)
                        { 

                            hello = "Bon week-end {0}";
                        }
                        else
                        {
                            hello = "Bonsoir {0}";
                        }
                    }
                }
            }
            Console.WriteLine(hello, "Tanguy");
            Console.ReadLine();
        }
    }    
}
