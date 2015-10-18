public class Message
{
	protected String message = "";
	protected Volt_divider vd = null;
	private String vcc = "";
	private String vref = "";
	private String r1 = "";
	private String r2 = "";

	public void Message(Volt_divider vd)
	{
		this.vd = vd;
		this.vcc = Double.toString(this.vd.get_vcc());
		this.vref = Double.toString(this.vd.get_vref());
		this.r1 = Double.toString(this.vd.get_r1());
		this.r2 = Double.toString(this.vd.get_r2());
		message = "Vcc: " + this.vcc + " Vref: " + this.vref + " R1: " + this.r1 + " R2: " + this.r2;
	}

	public String getMessage()
	{
		return this.message;
	}

	public void setMessage(String message)
	{
		this.message = message;
	}
}
