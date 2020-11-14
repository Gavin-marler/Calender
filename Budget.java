import java.util.Scanner;

public class Budget {
    
    public static void main(String args[]){
        display();
    }

    static double getIncome()
    {
        Scanner myObj = new Scanner(System.in);
        System.out.print("   Your monthly income: ");
        double income = myObj.nextDouble();
        return income;
    }

    static double getLivingBudget()
    {
        Scanner myObj = new Scanner(System.in);
        System.out.print("   Your budgeted living expenses: ");
        double livingBudget = myObj.nextDouble();
        return livingBudget;
    }

    static double getLivingActual()
    {
        Scanner myObj = new Scanner(System.in);
        System.out.print("   Your actual living expenses: ");
        double livingActual = myObj.nextDouble();
        return livingActual;
    }

    static double getTaxActual()
    {
        Scanner myObj = new Scanner(System.in);
        System.out.print("   Your actual taxes withheld: ");
        double taxActual = myObj.nextDouble();
        return taxActual;
    }

    static double getOther()
    {
        Scanner myObj = new Scanner(System.in);
        System.out.print("   Your actual other expenses: ");
        double other = myObj.nextDouble();
        return other;
    }

    static double computeTax(double income)
    {
        double incomeYear = income * 12;
      
        if (incomeYear >= 336550)
            return (((incomeYear - 336550) * .35) + 91043) / 12;
        else  if (incomeYear >= 188450)
            return (((incomeYear - 188450) * .33) + 42170) / 12;
        else  if (incomeYear >= 123700)
            return (((incomeYear - 123700) * .28) + 24040) / 12;
        else  if (incomeYear >= 61300)
            return (((incomeYear - 61300) * .25) + 8440) / 12;
        else  if (incomeYear >= 15100)
            return (((incomeYear - 15100) * .15) + 1510) / 12;
        else
            return (incomeYear * .10) / 12;
    }

    static void display()
    {
        System.out.println("This program keeps track of your monthly budget");
        System.out.println("Please enter the following:");
        double income = getIncome();
        double livingBudget = getLivingBudget();
        double livingActual = getLivingActual();
        double taxActual = getTaxActual();
        double other = getOther();
        String taxBudget = String.format("%.02f", computeTax(income));
        String otherBudget = String.format("%.02f", (income - Double.valueOf(taxBudget) - livingBudget));
        double differenceActual = income - taxActual - livingActual - other;
        double differenceBudget = 0;
   
        System.out.println("The following is a report on your monthly expenses");
        System.out.println("   Item                  Budget          Actual");
        System.out.println("   =============== =============== ===============");
        System.out.println("   Income          $" + income + "    $" + income);
        System.out.println("   Taxes           $" + taxBudget + "    $" + taxActual);
        System.out.println("   Living          $" + livingBudget + "    $" + livingActual);
        System.out.println("   Other           $" + otherBudget + "    $" + other);
        System.out.println("   =============== =============== ===============");
        System.out.println("   Difference      $" + differenceBudget + "    $" + differenceActual);
}

}
