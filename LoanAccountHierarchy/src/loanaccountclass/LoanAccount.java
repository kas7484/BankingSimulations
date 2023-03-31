/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package loanaccountclass;

/**
 *
 * @author krishshah
 */
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
                "%\nMonthly Payments: $" + calculateMonthlyPayment();
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
            return street + "\n" + city + ", " + state + " " + zipcode;
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
            String.format("\nPMI Monthly Amount: $%.2f\nProperty Address:\n%s\n", PMIMonthlyAmount, address);
        }
          
      }
      
      class UnsecuredLoan extends LoanAccount{
          public UnsecuredLoan(double principal, double annualInterestRate, int months){
              super(principal, annualInterestRate, months);
          }

          public String toString(){
            return "\nUnsecured Loan with:" + super.toString();
          }
      }

public class Main {
    public static void main(String[] args) {
        // Create three different loan objects, one of each type.
        CarLoan carLoan = new CarLoan(25000.00, 4.25, 72, "IRQ3458977\n");
        
        Address propertyAddress = new Address("321 Main Street", "State College", "PA", "16801");
        PrimaryMortgage propertyLoan = new PrimaryMortgage(250000.00, 3.1, 360, 35.12, propertyAddress);
        
        UnsecuredLoan unsecuredLoan = new UnsecuredLoan(5000.00, 10.75, 48);
        
        //Print out the load information for each loan using the toString() method.
        System.out.format("%n%s%s%s%n", carLoan, propertyLoan, unsecuredLoan);

    }
}

  
