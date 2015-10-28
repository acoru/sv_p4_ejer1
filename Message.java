import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;


public class Message
{
	//static int squence for managing a global sequence number for all the object of this Message class
	protected static int sequence;
	protected int receivedSequence;
	protected String message = "";
	protected Volt_divider voldi = null;


	public void Message(Volt_divider vd)
	{
		//it'll construct the message from an internal sequence number and a Volt_divider object
		voldi=vd;
		message=sequence +" "+ vd.toString();	//calling toString method from the Volt_divider class for
												//taking the attibutes content of Volt_divider class
		sequence++;
		/*	
		this.vd = vd;
		this.vcc = Double.toString(this.vd.get_vcc());
		this.vref = Double.toString(this.vd.get_vref());
		this.r1 = Double.toString(this.vd.get_r1());
		this.r2 = Double.toString(this.vd.get_r2());
		message = "Vcc: " + this.vcc + " Vref: " + this.vref + " R1: " + this.r1 + " R2: " + this.r2;
		*/
	}

	//trying to create a "buffer out" method, it'll be used for sending
	//the data throw the net
	public byte[] toByteArray()
	{
		ByteArrayOutputStream bos = new ByteArrayOutputStream(8);
		DataOutputStream dos = new DataOutputStream(bos);

		try
		{
			dos.writeInt(sequence);
			voldi.toByteArray(dos);
			dos.close();
			return bos.toByteArray();
		}
		catch (IOException e)
		{
			e.printStackTrace();
			return null;
		}
	}


	//it works as a buffer in, the String data is the recieved data from the net
	//it'll split the data variable and will get the values for setting inside
	//the receivedSecuence attribute and a Volt_divider "voldi" attribute
	public Message(String data, byte[] bytedata)
	{
		ByteArrayInputStream bais = new ByteArrayInputStream(bytedata);
		DataInputStream dis = new DataInputStream(bais);
		try
		{
			this.receivedSequence=dis.readInt();

		}
		catch (IOException ex)
		{
			ex.printStackTrace();
		}
		String[] fields = data.split(" ");
		if(fields.length == 5)
		{
			receivedSequence = Integer.parseInt(fields[0]);
			voldi = new Volt_divider(Double.parseDouble(fields[1]), Double.parseDouble(fields[2]), Double.parseDouble(fields[3]), Double.parseDouble(fields[4])); 
		}
	}
	//just for getting the message
	public String getMessage()
	{
		return this.message;
	}
	//just for setting a message
	public void setMessage(String message)
	{
		this.message = message;
	}
}
