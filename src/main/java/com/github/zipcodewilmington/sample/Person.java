package com.github.zipcodewilmington.sample;
import java.util.Random;
import java.util.Scanner;
public class Person {
    private String[] listofwords = {"fork", "zipcode", "java", "maven", "ide", "intellij", "idea", "github"};
    Random rand = new Random();
   private int choice = rand.nextInt(listofwords.length-1);
    private String word =listofwords[choice];
    private int guess = 0;
    private boolean finished = false;
    private int tries = word.length();
    Scanner scan = new Scanner(System.in);
    private String show;

    public static void main(String[] args)
    {
        Person person = new Person();
        person.initialize();
        person.gameflow();
    }
    public void  initialize() {
        String f = "";
        for (int i = 0; i < getWord().length(); i++)
        {
            f+="_";

        }
    setShow(f);

    }

    public void drawmenu()
    {

       System.out.println("Current Guesses:  " + getGuess());
        System.out.println(getShow());
       System.out.println("You have " + getTries() +" left.");




    }

    public int getGuess() {
        return guess;
    }

    public void setGuess(int guess) {
        this.guess = guess;
    }


    public String getWord()
    {
        return word;
    }

    public void setShow(String show) {
        this.show = show;
    }


public String[] getarray()
    {
        return listofwords;
    }

    public int getTries() {
        return tries;
    }
    public Scanner getScan() {
        return scan;
    }


    public boolean isFinished() {
        return finished;
    }

    public void setFinished(boolean finished) {
        this.finished = finished;
    }




    public String checkguess()
    {
        String guess = getScan().nextLine();
        int i = 0;
        boolean changed = false;
        String newString = getShow();
        StringBuilder sb = new StringBuilder(newString);

        for (int j = 0; j < getWord().length(); j++) {
            if (guess.charAt(0) == getWord().charAt(j)) {
                sb.setCharAt(j, guess.charAt(0));
            }
            if(guess.charAt(0)==getWord().charAt(j))
            {changed = true;
            }

        }
        if(changed==false)
        { setTries(getTries()-1);
        }
        setGuess(getGuess()+1);
        newString = sb.toString();
        setShow(newString);
        return newString;
    }

    public  void checkword()
    {




        if(getShow().contains("_")==true)
        {
        setFinished(false);
        }
        else setFinished(true);
    }

    public void gameflow()
    {
        System.out.println("Let's Play Wordguess version 1.0");
        do {
            drawmenu();
            checkguess();
            checkword();

        }
        while(getTries()>0  && isFinished()==false);
        if(getTries()>0 && isFinished()==true)
        {
            System.out.println("Congratulations! You guessed " + getWord() + " with " + getTries() + " tries left.");
        }
        else
        {
            System.out.println("Sorry, the word was: " + getWord());
            System.out.println("Better luck next time!");

        }



    }
    public void setTries(int tries) {
        this.tries = tries;
    }
    public String getShow() {
        return show;
    }



            }











