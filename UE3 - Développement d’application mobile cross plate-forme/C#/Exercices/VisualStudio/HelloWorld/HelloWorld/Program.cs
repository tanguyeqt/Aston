using ClassLibrary1;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;


namespace HelloWorld
{
    class Program
    {
        static void Main(string[] args)
        {

            Class1 c1 = new Class1();               
            Console.WriteLine("Hello " + c1.hello);
            Console.ReadLine();

        }
    }
}
