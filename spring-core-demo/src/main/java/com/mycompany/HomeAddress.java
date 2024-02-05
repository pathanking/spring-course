package com.mycompany;

public class HomeAddress extends Address {

	private String landmark;
	
	public void setLandmark(String landmark) {
		this.landmark = landmark;
	}

	@Override
	protected void showAddress() {
		System.out.println("--- Home Address ---");
		System.out.println("State : " + getState());
		System.out.println("City : " + getCity());
		System.out.println("Landmark : " + landmark);
	}
	
	@Override
	public String toString() {
		return String.format("HomeAddress [city=%s, state=%s, landmark=%s]", getCity(), getState(), landmark);
	}
}
