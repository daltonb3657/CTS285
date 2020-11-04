package dataman;

public class StandardMessages
{
    public static String DisplayMenu()
    {
        return "1.Answer Checker" +
                "\n2.Memory Bank" +
                "\n3.Exit" +
                "\n--> ";
    }

    public  static  String DisplayMenuError()
    {
        return "Invalid input! Please select a number from the list";
    }


    public  static  String GetProblem()
    {
        return "Enter your math problem." +
                "\n--> ";
    }

    public  static  String GetUserAnswer()
    {
        return "Enter your answer to the problem." +
                "\n--> ";
    }

    public  static  String DisplayWrongAnswer()
    {
        return "The answer you provided is incorrect." +
                "\nPlease try again.";
    }

    public  static  String DisplayCorrect()
    {
        return "You are correct!";
    }

    public  static  String DisplayUserAnswerAndCorrectAnswer(double input)
    {
        return "The answer you provided is incorrect." +
                "\nThe correct answer is: "+input;
    }
}
