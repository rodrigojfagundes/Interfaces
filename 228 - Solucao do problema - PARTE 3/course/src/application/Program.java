package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

import model.entities.CarRental;
import model.entities.Vehicle;
import model.services.BrazilTaxService;
import model.services.RentalService;

public class Program {

	public static void main(String[] args) throws ParseException{
		// TODO Auto-generated method stub
		
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		//criando um simple date format para por a data em formato
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:ss");
		
		//pedindo para digitar os dados do aluguel
		System.out.println("Enter rental data");
		System.out.println("car model: ");
		String carModel = sc.nextLine();
		System.out.println("pickup (dd/MM/yyyy hh:ss)");
		Date start = sdf.parse(sc.nextLine());
		System.out.println("return (dd/MM/yyyy hh:ss)");
		Date finish = sdf.parse(sc.nextLine());
		
		CarRental cr = new CarRental(start, finish, new Vehicle(carModel));
		
		System.out.print("enter price per hour");
		double pricePerHour = sc.nextDouble();
		System.out.print("enter price per day");
		double pricePerDay = sc.nextDouble();
		
		RentalService rentalService = new RentalService(pricePerDay, pricePerHour, new BrazilTaxService());
		
		rentalService.processInvoice(cr);
		
		System.out.println("INVOICE");
		System.out.println("Basica payment " + String.format("%,2f", cr.getInvoice().getBasicPayment()));
		System.out.println("tax " + String.format("%,2f", cr.getInvoice().getTax()));
		System.out.println("total payment " + String.format("%,2f", cr.getInvoice().getTotalPayment()));
		
		
		sc.close();
	}
}
