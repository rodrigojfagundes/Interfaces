package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

import entities.Contract;
import entities.Installment;
import services.ContractService;
import services.PaypalService;

public class Program {

	public static void main(String[] args) throws ParseException  {
		// TODO Auto-generated method stub
				
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		System.out.println("enter contract data");
		System.out.println("Number");
		Integer number = sc.nextInt();
		System.out.print("Date (dd/MM/yyyy): ");
		Date date = sdf.parse(sc.next());
		System.out.print("contract value: ");
		double totalValue = sc.nextDouble();
		
		Contract contract = new Contract(number, date, totalValue);
		
		System.out.print("enter number of installments: ");
		int N = sc.nextInt();
		
		ContractService cs = new ContractService(new PaypalService());
		cs.processContract(contract, N);
		
		System.out.println("installments: ");
		for(Installment it : contract.getInstallments()) {
			System.out.println(it);
			
		}
		sc.close();
	}
}
