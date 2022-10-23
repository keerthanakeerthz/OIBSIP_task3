package com.myAtm;
import java.util.*;
public class AtmInterface {
	 Scanner sc = new Scanner(System.in);
	 String Name;
	 String userName;
	 String password;
	 String Acc_Num;
	 String Transaction_History = "";
	 float balance;
	 int Transaction;
	 public static void main(String[] args)
	 {
		 AtmInterface atm = new AtmInterface();
		 Scanner sc = new Scanner(System.in);
		 System.out.println("~~~~~!!  WELCOME TO ATM INTERFACE  !!~~~~~");
	     System.out.println(" \t> Press 1 To Create a new account \n \t> Press 2 To Exit ");
	     System.out.println("-------------------------------------------------------------\n");
	     System.out.println("Enter Your Choice : ");
	     int choice = sc.nextInt();
	     switch (choice) {
	     	case 1: {
	     		atm.Acc_SignUp();
	            break;
	            	}
	     	case 2: {
	                System.exit(0);
	            	}
	        }
	     System.out.println(" \t => Press 1 To LOGIN \n \t => Press 2 TO EXIT ");
	     System.out.println("----------------------------------------------- \n");
	     System.out.println("Enter Your Choice : ");
	     int choice_1 = sc.nextInt();
	     switch (choice_1)
	        {
	        case 1: {
	                atm.Acc_Login();
	            }
	        case 2: {
	                System.exit(0);
	            }
	        }
	     }
	 void Acc_SignUp() {
		 System.out.println("Enter Your Name : ");
	     System.out.println("--------------------");
	     this.Name = sc.nextLine();
	     System.out.println("--------------------");
	     System.out.println("Enter Your UserName  : ");
	     System.out.println("---------------------");
	     this.userName = sc.nextLine();
	     System.out.println("----------------------\n");
	     System.out.println("Enter Your Password : ");
	     System.out.println("----------------------");
	     this.password = sc.nextLine();
	     System.out.println("----------------------\n");
	     System.out.println("Enter Your Account Number : ");
	     System.out.println("-----------------------");
	     this.Acc_Num = sc.nextLine();
	     System.out.println("------------------------\n");
	     System.out.println("*******!!Your account has been created successfully !!******* \n");


	    }
	 void Acc_Login() {
		 while (true)
	        {
	            System.out.println("Enter Your Username : ");
	            System.out.println("---------------------");
	            String username1 = sc.nextLine();
	            System.out.println("---------------------\n");

	            if (username1.equals(userName))
	            {
	                while (true)
	                {
	                    System.out.println("Enter Your Password : ");
	                    System.out.println("---------------------");
	                    String password1 = sc.nextLine();
	                    System.out.println("-----------------\n");

	                    if (password1.equals(password)) {
	                        System.out.println(" **** !! Login Successful !! ***** \n");
	                        atm_operations();
	                        break;
	                    } else {
	                        System.out.println(" *** !! Incorrect Password !! ***** \n");
	                    }
	                }
	            } else {
	                System.out.println(" **** !! Incorrect Username !! ***** \n");
	            }


	        }
	    }
	 void atm_operations()
	    {
	        	System.out.println(" ------ !! Welcome " + this.Name + " Please select the appropriate functionalities that you need------ \n ");
	        	System.out.println("---------------------------------------------------------------------------------------------------------");
	        while (true)
	        {
	            System.out.println(" --> Press 1 for TRANSACTION HISTORY ");
	            System.out.println(" --> Press 2 for WITHDRAW ");
	            System.out.println(" --> Press 3 for DEPOSIT");
	            System.out.println(" --> Press 4 for TRANSFER ");
	            System.out.println(" --> Press 5 for CHECK BALANCE ");
	            System.out.println(" --> Press 0 for EXIT");
	            System.out.println("---------------------------------------------------------------------------------------------------------");
	            System.out.println("Enter Your Choice : ");
	            int choice_2 = sc.nextInt();
	            System.out.println("");
	            switch (choice_2) {
	                case 1: {
	                    this.Transaction_History();
	                    break;
	                }
	                case 2: {
	                    this.withdraw();
	                    break;
	                }
	                case 3: {
	                    this.deposit();
	                    break;
	                }
	                case 4: {
	                    this.transfer();
	                    break;
	                }
	                case 5: {
	                    this.viewBalance();
	                    break;
	                }
	                case 0: {
	                    this.exit();

	                }
	                default: {
	                    System.out.println("Invalid Operation !! * !! Please Try Again !! * ");
	                }
	            }
	        }
	    }
	 void Transaction_History()
	    {
	        if (Transaction == 0) {
	            System.out.println(" * !! EMPTY TRANSACTION !! *");
	        }
	        else {
	            System.out.println(" \n " + Transaction_History + " \n ");
	        }
	    }

	    void withdraw() {
	        System.out.println("Enter the Amount to Withdraw : ");
	        System.out.println("----------------------------");
	        float Amount = sc.nextInt();
	        System.out.println("----------------------------\n");
	        System.out.println("");

	        try {

	            if (balance >= Amount) {
	                Transaction++;
	                balance = balance - Amount;
	                System.out.println(" ** !! Rs " + Amount + " Withdrawed Successfully !! **\n");
	                String str = Amount + "Rs Withdrawed";
	                Transaction_History = Transaction_History.concat(str);
	            } else {
	                System.out.println(" ** !!  Insufficient Balance !! ***\n");
	            }
	        } catch (Exception e) {

	        }
	    }
	    void deposit() {
	        System.out.println("Enter the Amount to be Deposited : ");
	        System.out.println("--------------------------------");
	        float Amount = sc.nextFloat();
	        System.out.println("--------------------------------");

	        try {
	            if (Amount <= 200000f) {
	                Transaction++;
	                balance = balance + Amount;
	                System.out.println(" ** !! Rs " + Amount + " Deposited Successfully !! **** \n");
	                String str = Amount + " Rs Deposited ";
	                Transaction_History = Transaction_History.concat(str);
	            } else {
	                System.out.println(" * !! Limit 200000.00 only .... !! ** ");
	            }
	        } catch (Exception e) {

	        }
	    }
	    public void transfer() {
	        Scanner sc = new Scanner(System.in);
	        System.out.println("Enter Account Holder Name : ");
	        System.out.println("--------------------------");
	        String Acc_Holder = sc.nextLine();
	        System.out.println("--------------------------");
	        System.out.println("Enter Amount to Transfer : ");
	        System.out.println("--------------------------");
	        float Amount = sc.nextFloat();
	        System.out.println("---------------------------");

	        try {
	            if (balance >= Amount) {
	                if (Amount <= 60000f) {
	                    Transaction++;
	                    balance = balance - Amount;
	                    System.out.println(" ** !! Successfully Transferred Rs " + Amount + " to " + Acc_Holder + " !! **");
	                    String str = Amount + " Rs Transferred To " + Acc_Holder;
	                    Transaction_History = Transaction_History.concat(str);
	                } else {
	                    System.out.println(" * !! Limit Exceeded ... !! ** ");

	                }
	            }
	            else {
	                System.out.println("* !! Insufficient Balance ... !! * ");
	            }
	        } catch (Exception e) {

	        }
	        
	    }
	    void viewBalance() {
	        System.out.println("------------------------------");
	        System.out.println("CURRENT BALANCE : " + balance);
	        System.out.println("------------------------------");
	        System.out.println("");
	    }

	   

	    void exit() {
	        System.exit(0);
	    }


	    
	}
	