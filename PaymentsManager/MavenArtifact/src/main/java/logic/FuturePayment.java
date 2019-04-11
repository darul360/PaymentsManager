package logic;

public class FuturePayment implements Payment {
	private int ID;
	private String name;
	private float price;
	private short type;
	private String description;
	
	public FuturePayment(int ID, String name, float price, short type, String description)
	{
		this.ID = ID;
		this.name = name;
		this.price = price;
		this.type = type;
		this.description = description;
	}
	
	@Override
	public String toString() 
	{
		String info;
		info = Integer.toString(ID) + "," +
		name + "," +
		Float.toString(price) + "," +
		Short.toString(type) + "," +
		description;
		
		return info;
	}
	
	@Override
	public String archive() 
	{
		// TODO archiving implementation
		return null;
	}
	
	@Override
	public int getPaymentID()
	{
		return ID;
	}

	@Override
	public String getPaymentName()
	{
		return name;
	}

	@Override
	public float getPaymentPrice()
	{
		return price;
	}

	@Override
	public short getPaymentType()
	{
		return type;
	}

	@Override
	public String getPaymentDescription()
	{
		return description;
	}

	//[SETTERS]


	@Override
	public void setPaymentID(int ID)
	{
		this.ID = ID;
	}

	@Override
	public void setPaymentName(String name)
	{
		this.name = name;
	}

	@Override
	public void setPaymentPrice(float price)
	{
		this.price= price;
	}

	@Override
	public void setPaymentType(short type)
	{
		this.type = type;

	}

	@Override
	public void setPaymentDescription(String description)
	{
		this.description = description;
	}

	public int getID() {
		return ID;
	}

	public String getName() {
		return name;
	}

	public float getPrice() {
		return price;
	}

	public short getType() {
		return type;
	}

	public String getDescription() {
		return description;
	}

	public void setID(int ID) {
		this.ID = ID;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public void setType(short type) {
		this.type = type;
	}

	public void setDescription(String description) {
		this.description = description;
	}
}
