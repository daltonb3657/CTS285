using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using WordChainLib;

namespace ConsoleUI
{
    class Program
    {
        static void Main(string[] args)
        {
            bool exit = false;

            do
            {
                Console.WriteLine(StandardMessages.DisplayWelcomeMessage());
                Console.Write(StandardMessages.DisplayMenu());

                switch (Console.ReadLine())
                {
                    case "1":
                        PlayGame.Game();
                        break;
                    case "2":
                        break;
                    case "3":
                        exit = true;
                        break;
                    default:
                        Console.WriteLine(StandardMessages.DisplayMenuError());
                        break;
                }


            } while (exit == false);
        }
    }
}
