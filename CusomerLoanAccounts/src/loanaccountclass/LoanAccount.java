/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package loanaccountclass;

/**
 *
 * @author krishshah
 */

import java.util.ArrayList;

/**
 *
 * @author krishshah
 */

      class Customer{
          private String firstName;
          private String lastName;
          private String SSN;
          ArrayList<LoanAccount> loanAccounts = new ArrayList<LoanAccount>();
    
    boolean printMonthlyReport;
      

        public Customer(String firstName,String lastName,String SSN){
            this.firstName = firstName;
            this.lastName = lastName;
            this.SSN = SSN;   
        }
        
        public String getFirstName(){
          return firstName;
      }
        
        public String getLastName(){
          return lastName;
      }

        
        public String getSSN(){
          return SSN;
      }
        
        public void addLoanAccount(LoanAccount account) {
            loanAccounts.add(account);
        }
        
        public void printMonthlyReport(){
            System.out.println("Account Report for Customer: " + firstName + " " + lastName + " with SSN " + SSN);
            for (LoanAccount loanAccount : loanAccounts) {
                System.out.println();
                System.out.println(loanAccount);
  
        }
        
    }
      }
public class LoanAccount {

    /**
     * @param args the command line arguments
     */
    private double principal;
    private double annualInterestRate;
    private int months; 

    
    public LoanAccount(double principal, double annualInterestRate, int months){
        this.principal =  principal;
        this.annualInterestRate = annualInterestRate;
        this.months = months;
    }
    
        public double calculateMonthlyPayment() {
           double monthlyInterest = annualInterestRate/(12*100);
            double monthlyPayment = principal * ( monthlyInterest / (1 - Math.pow(1 + monthlyInterest, - months)));
            return Math.round(monthlyPayment*100.00)/100.00;
    }
        
    public double getPrincipal(){
        return principal;
    }
    
    public void SetPrincipal(double Principal){
        this.principal = principal;
    }
    
    public double getAnnualInterestRate(){
        return annualInterestRate;
    }
    
    public void setAnnualInterestRate(double AnnualInterestRate){
        this.annualInterestRate = annualInterestRate;
    }
    
    public int getMonths(){
        return months;
    }
    
    public void setMonths(int months){
        this.months = months;
    }
    @Override
    public String toString(){
        return 
                "\nPrinciple : $" + principal +
                "\nAnnual Interest Rate :" + annualInterestRate +
                "%\nTerm of Loan in Months : " + months+
                "\nMonthly Payments: $" + calculateMonthlyPayment();
                
                
    }
}

   class CarLoan extends LoanAccount{
       
       private String vehicleVIN;

    public CarLoan(double principal, double annualInterestRate, int Months, String vehicleVIN) {
        super(principal, annualInterestRate, Months);
        this.vehicleVIN =vehicleVIN;
    }


    public String toString() {
        return "Car Loan with:" + super.toString() + "\nVehicle VIN: " + vehicleVIN;
       
   }
   }

    class Address{
        private String street;
        private String state;
        private String zipcode;
        private String city;
        
        public Address(String street, String state, String zipcode, String city){
            this.street = street;
            this.state = state;
            this.zipcode = zipcode;
            this.city = city;
    }
        public String getStreet(){
            return street;
        }
        
        public void setStreet(String street){
            this.street = street;
        }
        
        public String getState(){
            return state;
        }
        
        public void setState(String state){
            this.state = state;
        }
        
        public String getZipcode(){
            return zipcode;
        }
        
        public void setZipcode(){
            this.zipcode = zipcode;
        }
       
        public String getCity(){
            return city;
        }
        
        public void setCity(String city){
            this.city = city;
        }

        public String toString(){
            String addr = String.format("  %s\n  %s, %s %s\n", street, city, state, zipcode);
            return addr;
        }
    }
      class PrimaryMortgage extends LoanAccount{
          private double PMIMonthlyAmount;
          private Address address;

        public PrimaryMortgage(double principal, double annualInterestRate, int months, double PMIMonthlyAmount, Address address) {
            super(principal, annualInterestRate, months);
            this.PMIMonthlyAmount = PMIMonthlyAmount;
            this.address = address;
        }

        public String toString(){

        return "\nPrimary Mortgage Loan with:" + super.toString() +
            String.format("\nPMI Monthly Amount: $%.2f\nProperty Address:\n%s", PMIMonthlyAmount, address);
        }
          
      }
      
      class UnsecuredLoan extends LoanAccount{
          public UnsecuredLoan(double principal, double annualInterestRate, int months){
              super(principal, annualInterestRate, months);
          }

          public String toString(){
            return "\nUnsecured Loan with:" + super.toString() + "\n";
          }
      }

public class Main {
  public static void main(String[] args) {
        CarLoan carLoan1 = new CarLoan(25000.00, 4.9, 72, "IRQ3458977");
        CarLoan carLoan2 = new CarLoan(12000.00, 5, 60, "NXK6767876");
        
        Address propertyAddress1 = new Address("321 Main Street", "State College", "PA", "16801");
        PrimaryMortgage propertyLoan1 = new PrimaryMortgage(250000.00, 3.75, 360, 35.12, propertyAddress1);
        Address propertyAddress2 = new Address("783 Maple Lane", "State College", "PA", "16801");
        PrimaryMortgage propertyLoan2 = new PrimaryMortgage(375000.00, 2.5, 360, 53.12, propertyAddress2);
        
        UnsecuredLoan unsecuredLoan = new UnsecuredLoan(5000.00, 10.75, 48);
        
        // create customers
        Customer customerA = new Customer("Tony", "Stark", "111-22-3333");
        Customer customerB = new Customer("Gal", "Gadot", "444-55-6666");
        
        // add loans for the customers.
        customerA.addLoanAccount(carLoan1);
        customerA.addLoanAccount(propertyLoan1);
        customerA.addLoanAccount(unsecuredLoan);
        
        customerB.addLoanAccount(carLoan2);
        customerB.addLoanAccount(propertyLoan2);
        
        // add the customers to an arraylist of customers.
        ArrayList<Customer> customers = new ArrayList<>();
        customers.add(customerA);
        customers.add(customerB);
        
        //Print out the loan information for each customer polymorhically.
        System.out.println("Monthly Report of Customers by Loan Account");
        for (Customer customer:customers)
        {
            customer.printMonthlyReport();
        }
    }
}

  
