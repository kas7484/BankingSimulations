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
    private final double principal;
    private static double annualInterestRate;
    
    public LoanAccount(double newPrincipal){
        principal = newPrincipal;
    }
    
        public static void setAnnualInterestRate(double newAIR){
        annualInterestRate = newAIR;
    }
    
    public double calculateMonthlyPayment(int numberOfPayments){
        double monthlyInterest = annualInterestRate/12;
        double monthlyPayment = principal * (monthlyInterest/(1-Math.pow(1+monthlyInterest, -numberOfPayments)));
        return monthlyPayment;
    }
   
        
    public static void main(String[] args) {
        double principal1=5000;
        double principal2=31000;
        LoanAccount loan1 = new LoanAccount(principal1);
        LoanAccount loan2 = new LoanAccount(principal2);
        
        setAnnualInterestRate(0.01);
        System.out.printf("\nMonthly payment for loan1 of $%.2f and loan2 $%.2f for 3, 5, and 6 year loans at 1%% interest.",principal1, principal2);
        System.out.println("\nLoan\t3years\t5years\t6years");
        System.out.printf("Loan1\t%.2f\t%.2f\t%.2f",loan1.calculateMonthlyPayment(3*12), loan1.calculateMonthlyPayment(5*12),loan1.calculateMonthlyPayment(6*12));
        System.out.printf("\nLoan2\t%.2f\t%.2f\t%.2f",loan2.calculateMonthlyPayment(3*12),loan2.calculateMonthlyPayment(5*12),loan2.calculateMonthlyPayment(6*12));
        
        setAnnualInterestRate(0.05);
        System.out.printf("\n\nMonthly payment for loan1 of $%.2f and loan2 $%.2f for 3,5 and 6 year loans at 5%% interest.",principal1,principal2);
        System.out.printf("\nLoan\t3years\t5years\t6years");
        System.out.printf("Loan1\t%.2f\t%.2f\t%.2f",loan1.calculateMonthlyPayment(3*12), loan1.calculateMonthlyPayment(5*12),loan1.calculateMonthlyPayment(6*12));
        System.out.printf("\nLoan2\t%.2f\t%.2f\t%.2f",loan2.calculateMonthlyPayment(3*12),loan2.calculateMonthlyPayment(5*12),loan2.calculateMonthlyPayment(6*12));
        
        
        
    }
    
}
