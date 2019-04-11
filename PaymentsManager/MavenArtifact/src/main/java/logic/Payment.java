package logic;

public interface Payment {
	
	public int getPaymentID();
	public String getPaymentName();
	public float getPaymentPrice();
	public short getPaymentType();
	public String getPaymentDescription();
	
	public void setPaymentID(int ID);
	public void setPaymentName(String name);
	public void setPaymentPrice(float price);
	public void setPaymentType(short type);
	public void setPaymentDescription(String description);
	
	public String archive();
	public String toString();
	
}
