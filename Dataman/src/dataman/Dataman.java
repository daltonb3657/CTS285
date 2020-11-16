/*
* Brandon Dalton
* 11/4/20
* CTS 285
* A text based version of the old Data Man Calculators, including only the Answer Checker and Memory bank function
 */
package dataman;
import java.util.Scanner;
import java.util.Arrays;
import java.io.*;


public class Dataman 
{
    
    public static void main(String[] args) throws IOException
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
                    memoryBank();
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
        
        int answeredRight=0,attempted=0;
        boolean exit = false;
        

        do
        {
            System.out.print(StandardMessages.DisplayAnswerCheckerMenu());
            switch(k.nextLine())
            {
                case "1":
                    System.out.print(StandardMessages.GetProblem());
                    String[] problem = k.nextLine().split(" ");
                    double userAnswer=0, correctAnswer=0;
                    int count=0;
                    boolean correct = false;
                    boolean addition = Arrays.stream(problem).anyMatch("+"::equals);
                    boolean subtraction = Arrays.stream(problem).anyMatch("-"::equals);
                    boolean multiplication = Arrays.stream(problem).anyMatch("*"::equals);
                    boolean division = Arrays.stream(problem).anyMatch("/"::equals);


                    if(addition)
                    {
                        attempted++;
                        do
                        {
                            count++;
                            System.out.print(StandardMessages.GetUserAnswer());
                            userAnswer = k.nextDouble();
                            correctAnswer=Calculator.doAddition(Double.parseDouble(problem[0]),Double.parseDouble(problem[2]));
                            if(userAnswer == correctAnswer)
                            {
                                System.out.println(StandardMessages.DisplayCorrect());
                                correct = true;
                                answeredRight++;
                                
                            }
                            else if(userAnswer != correctAnswer && count ==2)
                            {
                                System.out.println(StandardMessages.DisplayUserAnswerAndCorrectAnswer(correctAnswer));
                            }
                            else
                            {
                                System.out.println(StandardMessages.DisplayWrongAnswer());

                            }
                        } while(count!=2 && correct==false);                        
                        k.nextLine();
                    }

                    else if (subtraction)
                    {
                        attempted++;
                        do
                        {
                            count++;
                            System.out.print(StandardMessages.GetUserAnswer());
                            userAnswer = k.nextDouble();
                            correctAnswer=Calculator.doSubtraction(Double.parseDouble(problem[0]),Double.parseDouble(problem[2]));
                            if(userAnswer == correctAnswer)
                            {
                                System.out.println(StandardMessages.DisplayCorrect());
                                correct = true;
                                answeredRight++;
                            }
                            else if(userAnswer != correctAnswer && count ==2)
                            {
                                System.out.println(StandardMessages.DisplayUserAnswerAndCorrectAnswer(correctAnswer));
                            }
                            else
                            {
                                System.out.println(StandardMessages.DisplayWrongAnswer());

                            }

                        } while(count!=2 && correct==false);
                        k.nextLine();
                    }

                    else if (multiplication)
                    {
                        attempted++;
                        do
                        {
                            count++;
                            System.out.print(StandardMessages.GetUserAnswer());
                            userAnswer = k.nextDouble();
                            correctAnswer=Calculator.doMultiplication(Double.parseDouble(problem[0]),Double.parseDouble(problem[2]));
                            if(userAnswer == correctAnswer)
                            {
                                System.out.println(StandardMessages.DisplayCorrect());
                                correct = true;
                                answeredRight++;
                            }
                            else if(userAnswer != correctAnswer && count ==2)
                            {
                                System.out.println(StandardMessages.DisplayUserAnswerAndCorrectAnswer(correctAnswer));
                            }
                            else
                            {
                                System.out.println(StandardMessages.DisplayWrongAnswer());

                            }

                        } while(count!=2 && correct==false);
                    }
                    else if (division && Double.parseDouble(problem[2])==0)
                    {
                        System.out.println("Invalid problem, cannot divide by 0;");
                    }
                    else if (division)
                    {
                        attempted++;
                        do
                        {
                            count++;
                            System.out.print(StandardMessages.GetUserAnswer());
                            userAnswer = k.nextDouble();
                            correctAnswer=Calculator.doDivision(Double.parseDouble(problem[0]),Double.parseDouble(problem[2]));
                            if(userAnswer == correctAnswer)
                            {
                                System.out.println(StandardMessages.DisplayCorrect());
                                correct = true;
                                answeredRight++;
                            }
                            else if(userAnswer != correctAnswer && count ==2)
                            {
                                System.out.println(StandardMessages.DisplayUserAnswerAndCorrectAnswer(correctAnswer));
                            }
                            else
                            {
                                System.out.println(StandardMessages.DisplayWrongAnswer());

                            }

                        } while(count!=2 && correct==false);
                        k.nextLine();
                    }
                    else
                    {
                        System.out.println("Invalid input. Please put spaces between the numbers and operator.");
                    }
                    break;
                case "2":
                    System.out.println(StandardMessages.DisplayAnswerCheckerScore(answeredRight, attempted));
                    break;
                case "3":
                    exit = true;
                    break;
                default:
                    System.out.println(StandardMessages.DisplayMenuError());
                    break;
            }
        }while(exit==false);
   }
    public static void memoryBank() throws IOException
    {
        Scanner k = new Scanner(System.in);        
        FileWriter fwriter = new FileWriter("Memory.txt", true);
        PrintWriter outputfile = new PrintWriter(fwriter);
        String problem;
        boolean exit=false;       
        
        
        do
        {
            System.out.println(StandardMessages.DisplayMemoryBankMenu());
            switch(k.nextLine())
            {
                case "1":
                    System.out.print(StandardMessages.GetProblem());
                    problem = k.nextLine();
                    outputfile.println(problem);
                    outputfile.close();
                    break;
                case "2":
                    //TODO make code to read file and pick a random line
                    break;
                case "3":
                    //TODO make score code
                    break;
                case "4":
                    exit = false;
                    break;
                default:
                    System.out.println(StandardMessages.DisplayMenuError());
                    break;
            }
        }while(exit==false);
        
    }
    
    
}