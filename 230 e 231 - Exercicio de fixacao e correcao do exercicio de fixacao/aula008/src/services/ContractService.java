package services;

import java.util.Calendar;
import java.util.Date;

import entities.Contract;
import entities.Installment;


public class ContractService {
	

	private OnlinePaymentService onlinePaymentService;
	
	public ContractService(OnlinePaymentService onlinePaymentService) {
	
		this.onlinePaymentService = onlinePaymentService;
	}
	
	public void processContract(Contract contract, int months) {
	
		double basicQuota = contract.getTotaValue() / months;
		for (int i = 1; i <= months; i++) {
			double updateQuota = basicQuota + onlinePaymentService.interest(basicQuota, i);
			double fullQuota = updateQuota + onlinePaymentService.paymentFee(updateQuota);
			Date dueDate = addMonths(contract.getDate() , i);
			contract.getInstallments().add(new Installment(dueDate, fullQuota));
		}
	}
	private Date addMonths(Date date, int N) {
		//instanciando um calendario
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.add(Calendar.MONTH, N);
		return calendar.getTime();
	}
}
