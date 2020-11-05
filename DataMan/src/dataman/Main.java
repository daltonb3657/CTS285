/*
* Brandon Dalton
* 11/4/20
* CTS 285
* A text based version of the old Data Man Calculators, including only the Answer Checker and Memory bank function
 */
package dataman;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.io.*;


public class Main {

    public static void main(String[] args)
    {
        Scanner k = new Scanner(System.in);
        boolean exit = false;
        do
        {
            System.out.print(StandardMessages.DisplayMenu());

            switch (k.nextLine())
            {
                case "1":
                    answerChecker();
                    break;
                case "2":
                    System.out.println("Currently under development");
                    break;
                case "3":
                    exit=true;
                    break;
                default:
                    System.out.println(StandardMessages.DisplayMenuError());
                    break;
            }
        }while(exit==false);

    }

    public static void answerChecker()
    {

        Scanner k = new Scanner(System.in);
        double userAnswer=0, correctAnswer=0;
        int count=0;

        System.out.print(StandardMessages.GetProblem());
        String[] problem = k.nextLine().split(" ");
        boolean addition = Arrays.stream(problem).anyMatch("+"::equals);
        boolean subtraction = Arrays.stream(problem).anyMatch("-"::equals);
        boolean multiplication = Arrays.stream(problem).anyMatch("*"::equals);
        boolean division = Arrays.stream(problem).anyMatch("/"::equals);


        if(addition)
        {
            do
            {
                count++;
                System.out.print(StandardMessages.GetUserAnswer());
                userAnswer = k.nextDouble();
                correctAnswer=Calculator.doAddition(Double.parseDouble(problem[0]),Double.parseDouble(problem[2]));
                if(userAnswer == correctAnswer)
                {
                    System.out.println(StandardMessages.DisplayCorrect());
                }
                else if(userAnswer != correctAnswer && count ==2)
                {
                    System.out.println(StandardMessages.DisplayUserAnswerAndCorrectAnswer(correctAnswer));
                }
                else
                {
                    System.out.println(StandardMessages.DisplayWrongAnswer());

                }

            } while(count!=2);
        }

        else if (subtraction)
        {
            do
            {
                count++;
                System.out.print(StandardMessages.GetUserAnswer());
                userAnswer = k.nextDouble();
                correctAnswer=Calculator.doSubtraction(Double.parseDouble(problem[0]),Double.parseDouble(problem[2]));
                if(userAnswer == correctAnswer)
                {
                    System.out.println(StandardMessages.DisplayCorrect());
                }
                else if(userAnswer != correctAnswer && count ==2)
                {
                    System.out.println(StandardMessages.DisplayUserAnswerAndCorrectAnswer(correctAnswer));
                }
                else
                {
                    System.out.println(StandardMessages.DisplayWrongAnswer());

                }

            } while(count!=2);
        }

        else if (multiplication)
        {
            do
            {
                count++;
                System.out.print(StandardMessages.GetUserAnswer());
                userAnswer = k.nextDouble();
                correctAnswer=Calculator.doMultiplication(Double.parseDouble(problem[0]),Double.parseDouble(problem[2]));
                if(userAnswer == correctAnswer)
                {
                    System.out.println(StandardMessages.DisplayCorrect());
                }
                else if(userAnswer != correctAnswer && count ==2)
                {
                    System.out.println(StandardMessages.DisplayUserAnswerAndCorrectAnswer(correctAnswer));
                }
                else
                {
                    System.out.println(StandardMessages.DisplayWrongAnswer());

                }

            } while(count!=2);
        }
        else if (division && Double.parseDouble(problem[2])==0)
        {
            System.out.println("Invalid problem, cannot divide by 0;");
        }
        else if (division)
        {

            do
            {
                count++;
                System.out.print(StandardMessages.GetUserAnswer());
                userAnswer = k.nextDouble();
                correctAnswer=Calculator.doDivision(Double.parseDouble(problem[0]),Double.parseDouble(problem[2]));
                if(userAnswer == correctAnswer)
                {
                    System.out.println(StandardMessages.DisplayCorrect());
                }
                else if(userAnswer != correctAnswer && count ==2)
                {
                    System.out.println(StandardMessages.DisplayUserAnswerAndCorrectAnswer(correctAnswer));
                }
                else
                {
                    System.out.println(StandardMessages.DisplayWrongAnswer());

                }

            } while(count!=2);
        }
        else
        {
            System.out.println("Invalid input. Please put spaces between the numbers and operator.");
        }


    }
}