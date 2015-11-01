import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;



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
		vcc = vref * ((r1 + r2) / r2);
	}

	public void calc_vref()
	{
		vref = vcc * (r2 / (r1 + r2));
	}

	public void calc_r1()
	{
		r1 = (vcc / vref - 1) * r2;
	}

	public void calc_r2()
	{
		r2 = (r1 / (vcc / vref - 1));
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
		return vcc;
	}

	public double get_vref()
	{
		return vref;
	}

	public double get_r1()
	{
		return r1;
	}

	public double get_r2()
	{
		return r2;
	}

	//taking the values received from the network connection
	//this method is used for reading the content received from the network
	//it's similar to a buffer in
	public Volt_divider(DataInputStream dis)
	{
		try
		{
			//setting the content of the DataInputStream into the attributes of the class
			vcc=dis.readDouble();
			vref=dis.readDouble();
			r1=dis.readDouble();
			r2=dis.readDouble();
		}
		catch(IOException e)
		{
			vcc=0.0;
			vref=0.0;
			r1=0.0;
			r2=0.0;

			e.printStackTrace();
		}
	}

	//casting the content of the attributes into a array of bytes (DataOutputStream) (writting the content of the attributes into
	//the DataOutStream, it's similar to a buffer out)
	public void toByteArray (DataOutputStream dos)
	{
		try
		{
			dos.writeDouble(vcc);
			dos.writeDouble(vref);
			dos.writeDouble(r1);
			dos.writeDouble(r2);
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
	}
	
	//putting the attributes values into a string value (returning as String value)
	public String toString()
	{
		return vcc + " " + vref + " " + r1 + " " + r2;
	}
}	
