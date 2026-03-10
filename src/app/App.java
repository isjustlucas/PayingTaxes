package app;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import util.Company;
import util.Individual;
import util.Payer;

public class App {
    public static void main(String[] args) throws Exception {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);
        List<Payer> list = new ArrayList<>();

        System.out.print("Enter the number of tax payers: ");
        int n = sc.nextInt();
        for (int i = 1; i <= n; i++) {
            System.out.println("Tax payer #" + i + " data:");
            System.out.print("Individual of company (i/c)? ");
            char type = sc.next().charAt(0);
            System.out.print("Name: ");
            sc.nextLine();
            String name = sc.nextLine();
            System.out.print("Anual income: ");
            Double income = sc.nextDouble();
            switch (type) {
                case 'i':
                    System.out.print("Health expenditures: ");
                    Double healthExpend = sc.nextDouble();
                    list.add(new Individual(name, income, healthExpend));
                    break;

                case 'c':
                    System.out.print("Number of employees: ");
                    Integer employeesNum = sc.nextInt();
                    list.add(new Company(name, income, employeesNum));
                    break;
                default:
                    System.out.println("Invalid account type.");
                    break;
            }
        }
        Double sum = 0.0;
        System.out.println();
        System.out.println("TAXES PAID:");
        for (Payer payer : list) {
            System.out.println(payer.getName() + ": $ " + String.format("%.2f", payer.calcTaxes()));
            sum += payer.calcTaxes();
        }
        System.out.println();
        System.out.println("TOTAL TAXES: $ " + String.format("%.2f", sum));
        System.out.println("End of application");
        sc.close();
    }
}