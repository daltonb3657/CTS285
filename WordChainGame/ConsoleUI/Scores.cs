using System;
using System.Collections.Generic;
using System.IO;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace ConsoleUI
{
    public class Scores
    {
        public static void ListScores()
        {
            StreamReader reader = File.OpenText(@"../../../WordChainLib/Docs/Scores.txt");

            while(!reader.EndOfStream)
            {
                Console.WriteLine(reader.ReadLine());
            }
        }
    }
}
