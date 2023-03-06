package entities;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Contract {
	
	private Integer number;
	private Date date;
	private Double totaValue;

	List<Installment> installments = new ArrayList<Installment>();
	
	public Contract() {
		
	}

public Contract(Integer number, Date date, Double totaValue) {
	super();
	this.number = number;
	this.date = date;
	this.totaValue = totaValue;
}

public Integer getNumber() {
	return number;
}


public void setNumber(Integer number) {
	this.number = number;
}


public Date getDate() {
	return date;
}


public void setDate(Date date) {
	this.date = date;
}


public Double getTotaValue() {
	return totaValue;
}


public void setTotaValue(Double totaValue) {
	this.totaValue = totaValue;
}


public List<Installment> getInstallments() {
	return installments;
}

}
