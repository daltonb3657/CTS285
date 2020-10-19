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
            int score=0, count=0;
            char firstLetter, lastLetter;

            Console.Write(StandardMessages.GetWord());
            input = Console.ReadLine().Trim();
            words.Add(input);
            do
            {
                Console.Write(StandardMessages.GetWord());
                input = Console.ReadLine().Trim();
                if(!words.Contains(input))
                {
                    words.Add(input);
                    count++;
                    lastLetter = words[count-1].Last();
                    firstLetter = words[count].First();
                    if (firstLetter.Equals(lastLetter))
                    {
                        
                        score += 5;
                         
                    }else
                    {
                        exit = true;
                        Console.WriteLine(StandardMessages.DisplayWordError());
                        Console.WriteLine(StandardMessages.DisplayYouLose(score));
                        

                    }
                    
                }
                else
                {
                    exit = true;
                    Console.WriteLine(StandardMessages.DisplayWordReusedErroer());
                    Console.WriteLine(StandardMessages.DisplayYouLose(score));
                                        
                }
            } while (exit==false);

            if(score!=0)
            {
                SaveScore(score);
            }
        }
        
        public static void SaveScore(int score)
        {
            StreamWriter writer;
            string input;
            Console.Write(StandardMessages.GetScoreName());
            input = Console.ReadLine().Trim();
            try
            {
                writer = File.AppendText(@"../../../WordChainLib/Docs/Scores.txt");
                writer.WriteLine($"Name - {input}, score - {score}");
                writer.Close();
            }
            catch (Exception ex)
            {
                Console.WriteLine(ex);                
            }
        }
        
    }
}
