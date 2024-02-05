package com.mycompany;

public class OfficeAddress extends Address {

	private String companyName;

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	@Override
	protected void showAddress() {
		System.out.println("--- Office Address ---");
		System.out.println("State : " + getState());
		System.out.println("City : " + getCity());
		System.out.println("Landmark : " + companyName);
	}

	@Override
	public String toString() {
		return String.format("OfficeAddress [city=%s, state=%s, companyName=%s]", getCity(), getState(), companyName);
	}
}
