using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.IO;
using WordChainLib;

namespace ConsoleUI
{
    public class PlayGame
    {
        public static void Game()
        {
            List<string> words = new List<string>();
            bool exit = false;
            string input;
            int score=0;
            do
            {
                Console.Write(StandardMessages.GetWord());
                input = Console.ReadLine().Trim();
                if(words.Contains(input))
                {
                    exit = true;
                    Console.WriteLine(StandardMessages.DisplayWordReusedErroer());
                    Console.WriteLine(StandardMessages.DisplayYouLose(score));
                }
                else
                {
                    words.Add(input);
                    score +=5;
                }
            } while (exit==false);
        }
        

        
    }
}
