using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace WordChainLib
{
    public class StandardMessages
    {
        public static string DisplayWelcomeMessage()
        {
            return "Welcome to the word chain game";
        }
        public static string DisplayMenu()
        {
            return "1. Play Game" +
                "\n2. High Scores" +
                "\n3. Exit" +
                "\n--> ";
        }
        public static string DisplayMenuError()
        {
            return "Invalid input! Enter a number from the list.";
        }
        public static string GetWord()
        {
            return "Enter your word: ";
        }
        public static string DisplayWordError()
        {
            return "The word you entered does not start with the previously entered words last letter.";
        }
        public static string DisplayWordReusedErroer()
        {
            return "The word you entered has already been used";
        }
        public static string DisplayYouLose(int score)
        {
            return $"You have lost." +
                $"\nYour score is - {score}";
        }
    }
}
