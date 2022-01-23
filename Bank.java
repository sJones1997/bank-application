import java.util.Scanner;

public class Bank {

    private double balance = 100;
    Scanner scanner;
    String input;

    Bank(){
        scanner = new Scanner(System.in);
        printBalance();
        getUserInput();
    }

    public void printBalance(){
        System.out.println("You currently have £"+ this.balance);      
    }

    public void getUserInput(){
        System.out.println("What would you like to do? (deposit/withdraw/exit)");
        input = scanner.nextLine();
        input = input.toLowerCase().trim();
        switch(input){
            case "deposit":
                deposit();
                break;
            case "withdraw": 
                withdraw();
                break;
            case "exit":
                System.out.println("Bye");
                break;
            default:
                System.out.println(input + " is not valid");
            
        }
    }

    public void withdraw(){
        System.out.println("How much would you like to withdraw?");
        try{
            double amount = Double.parseDouble(scanner.nextLine());
            if(amount > balance){
                System.out.println("You don't have enough funds");
                getUserInput();
            } else {
                balance = balance - amount;
                printBalance();
                getUserInput();
            }            
        } catch (NumberFormatException e){
            System.out.println("Value is not numeric");
            getUserInput();
        }
    }   
    
    public void deposit(){
        System.out.println("How much would you like to deposit?");
        try {
            double amount = Double.parseDouble(scanner.nextLine());
            balance = balance + amount;
            printBalance();
            getUserInput();
        } catch (NumberFormatException e){
            System.out.println("Value is not numberic");
            getUserInput();
        }
    }
}