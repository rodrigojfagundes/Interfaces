package services;

public interface OnlinePaymentService {
	
	double paymentFee(double amount);
	double interest(double amont, int months);

}
