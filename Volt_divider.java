public class Volt_divider
{
	protected double vcc = 0, vref = 0, r1 = 0, r2 = 0;

	public Volt_divider(double vcc, double vref, double r1, double r2)
	{
		this.vcc = vcc;
		this.vref = vref;
		this.r1 = r1;
		this.r2 = r2;
	}

	public void calc_vcc()
	{
		this.vcc = this.vref * ((this.r1 + this.r2) / this.r2)
	}

	public void calc_vref()
	{
		this.vref = this.vcc * (this.r2 / (this.r1 + this.r2));
	}

	public void calc r1()
	{
		this.r1 = (this.vcc / this.vref - 1) * this.r2;
	}

	public void calc r2()
	{
		this.r2 = (this.r1 / (this.vcc / this.vref - 1))
	}

	public void set_vcc(double vcc)
	{
		this.vcc = vcc;
	}

	public void set_vref(double vref)
	{
		this.vref = vref;
	}

	public void set_r1(double r1)
	{
		this.r1 = r1;
	}

	public void set_r2(double r2)
	{
		this.r2 = r2;
	}

	public double get_vcc()
	{
		return this.vcc;
	}

	public double get_vref()
	{
		return this.vref;
	}

	public double get_r1()
	{
		return this.r1;
	}

	public double get_r2()
	{
		return this.r2;
	}
}