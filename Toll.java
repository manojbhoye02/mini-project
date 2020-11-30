import java.util.ArrayList;
import java.util.Scanner;
import java.util.UUID;
import java.io.*;
import java.time.format.DateTimeFormatter;
import java.time.LocalDateTime;  


interface Vechile {
    
	void car();

    void threeWheeler();

    void heavyDuty();
}


class test implements Vechile {
    private String No = "";

    test()
        {

	}

    test(String no)
        {
        this.No = no;
        }

    public void car() {
        final int priceCar = 60;

	System.out.println("Vehicle Number\t\t:\t"+ No);
	System.out.println("Amount of Transaction\t:\t"+priceCar +" RS");
	System.out.println("Thank You,Have A Great Journey Ahead .....!");
	System.out.println("\t*******************************************");
      
    }

    public void threeWheeler() {
       final int pricethreeWheeler = 100;
	System.out.println("Vehicle Number\t\t:\t"+ No);
	System.out.println("Amount of Transaction\t:\t"+pricethreeWheeler +" RS");
	System.out.println("Thank You,Have A Great Journey Ahead .....!");
	System.out.println("\t*******************************************");
    
    }

    public void heavyDuty() {
       final int priceHeeavyduty = 100;
	System.out.println("Vehicle Number\t\t:\t"+ No);
	System.out.println("Amount of Transaction\t:\t"+priceHeeavyduty  +" RS");
	System.out.println("Thank You,Have A Great Journey Ahead .....!");
	System.out.println("\t*******************************************");
     
    }
}

class payment {
    String no;
    String Id;
   


    payment() {
    }

    payment(String no, String Id) {
        this.no = no;
        this.Id = Id;
	

    }
    
    void cash(String no) {
System.out.println("\t*******************************************");
		System.out.println("\t  Welcome To Mumbai-Pune Express Highway");
		System.out.println("\t*******************************************");
		timeDate();
        System.out.println("\t\tTransaction Successful");
        System.out.println("Your Transaction Id \t: \t"+Id);
        this.no = no;
	
    }
    
    void card() {
        System.out.println("Enter your Card No ");

        Scanner obj = new Scanner(System.in);

        double cardNo = obj.nextDouble();
        System.out.println("Enter Your Pin");

    	    Console con=System.console();
            char[] chars=con.readPassword();
        String pin =new String(chars);
		System.out.println("\t*******************************************");
		System.out.println("\t   Welcome To Mumbai-Pune Express Highway");
		System.out.println("\t*******************************************");
		timeDate();
        System.out.println("Your Transaction Id\t : \t"+Id);
        System.out.println("\tTransaction Successful");
	
    }
 void  timeDate()
	  {
	  
		
		  DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss ");
	   
		  LocalDateTime now = LocalDateTime.now();

		   System.out.println("\t\tDate :"+dtf.format(now));

		
	  } 
}

public class Toll {
  
  

    public static void main(String[] args) throws IOException
    {		System.out.println("\t*******************************************");
		System.out.println("\t   Welcome To Mumbai-Pune Express Highway");
		System.out.println("\t*******************************************");
        String Username;
        String Password;


        Password = "manoj123";
        Username = "manoj123";

        Scanner input1 = new Scanner(System.in);
        System.out.println("Enter Username : ");
        String username = input1.next();

        Scanner input2 = new Scanner(System.in);
        System.out.println("Enter Password : ");
        		Console con=System.console();  //console() will proide console object 
        		char[] chars=con.readPassword(); // i/p will accept as array
        String password = new String(chars);
        

        if (username.equals(Username) && password.equals(Password)) {

            System.out.println("Access Granted! Welcome!");
        } else if (username.equals(Username)) {
            System.out.println("Invalid Password!");
            System.exit(0);
        } else if (password.equals(Password)) {
            System.out.println("Invalid Username!");
            System.exit(0);
        } else {
            System.out.println("Invalid Username & Password!");
            System.exit(0);
        }
    
        int choice;
        payment pa = new payment();
       
        Scanner obj = new Scanner(System.in);
        ArrayList<payment> paymentArrayList = new ArrayList<>();

	
        do {
            test ob =new test();

            System.out.println("Enter Type Of Vechicle  1. Car    2. Three Wheeler  3. Heavy Duty   4. VIP     5. Print Details   6. EXIT");
            choice = Integer.parseInt(obj.nextLine());

            if (choice == 1 || choice == 2 || choice == 3)

            {	
                System.out.println("Enter Vechile No");
                String no = obj.nextLine();
                ob = new test(no);
                System.out.println("Payment Method 1.  For Cash   2.  For Card");
                int pay = Integer.parseInt(obj.nextLine());
                String uniqueID = UUID.randomUUID().toString();
                payment obj1 = new payment(no, uniqueID);
		

                paymentArrayList.add(obj1);
                if (pay == 1) {
                    obj1.cash(no);
                } else {
                    obj1.card();
                }
            }
            switch (choice) {
            case 1:
                ob.car();
                break;
            case 2:
                ob.threeWheeler();
                break;
            case 3:
                ob.heavyDuty();
                break;
            case 4:
                System.out.println("\t\tVIP PASS");
                break;
            case 5:
                display(paymentArrayList);
                break;
            case 6:
                System.exit(0);
            }

        } while (choice != 5);
    }
    static void display(ArrayList<payment> paymentArrayList) {
	System.out.println("Vechile No\t"+ "\tTransition Id");

        for(payment pay : paymentArrayList) {

            System.out.println(pay.no + "    " + pay.Id);
        }
    }
}