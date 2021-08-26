package com.example.PaySlip;

public class Employee {
	//User Entered
	private String firstName;
	private String lastName;
	private int annualSalary;
	private double superRate;
	private String fromDate;
	private String toDate;
	
	//Preset
	private int paymentPeriod; 
	
	//Calculated
	private int grossIncome;
	private int incomeTax;
	private int superannuation;
	private int netIncome;
	
	public Employee(String fName, String lName, int aSalary, String sRate, String pPeriod) 
	{
		firstName = fName;
		lastName = lName;
		annualSalary = aSalary;
		paymentPeriod = 1; //Assumption: Only One month will be given
		superRate = Double.parseDouble(sRate.replace("%", "")) / 100;
		
		String[] splitDate = pPeriod.replace('–', '-').split(" - ");
		fromDate = splitDate[0];
		toDate = splitDate[1];
		grossIncome = (int) Math.round(annualSalary / 12.0 * paymentPeriod);
		
		if (annualSalary >= 180001) //Assumption: Tax is based on annual Salary
		{
			incomeTax = (int) Math.round((54232 + ((annualSalary - 180000) * 0.45)) / 12 * paymentPeriod); //Assumption: Divide by 12 to give per month
		}
		else if (annualSalary >= 87001) 
		{
			incomeTax = (int) Math.round((19822 + ((annualSalary - 87000) * 0.37)) / 12 * paymentPeriod);
		}
		else if (annualSalary >= 37001) 
		{
			incomeTax = (int) Math.round((3572 + ((annualSalary - 37000) * 0.325)) / 12 * paymentPeriod);
		}
		else if (annualSalary >= 18201) 
		{
			incomeTax = (int) Math.round(((annualSalary - 18200) * 0.325) / 12 * paymentPeriod);
		}
		else 
		{
			incomeTax = 0;
		}
		
		netIncome = (int) Math.round(grossIncome - incomeTax); //--------Assumption: Income needs to be divided by 12 to match grossIncome
		superannuation = (int) Math.round(grossIncome * superRate);
	}

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public int getAnnualSalary() {
		return annualSalary;
	}

	public double getSuperRate() {
		return superRate;
	}

	public String getFromDate() {
		return fromDate;
	}

	public String getToDate() {
		return toDate;
	}

	public int getPaymentPeriod() {
		return paymentPeriod;
	}

	public int getGrossIncome() {
		return grossIncome;
	}

	public int getIncomeTax() {
		return incomeTax;
	}

	public int getSuperannuation() {
		return superannuation;
	}

	public int getNetIncome() {
		return netIncome;
	}

	
	
	/*public String Print() 
	{
		return firstName + " " + lastName + "," + fromDate + " - " + toDate + "," + grossIncome + "," + incomeTax + "," + netIncome + "," + superannuation;
	}*/
}
