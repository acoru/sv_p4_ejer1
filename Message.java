import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;


public class Message
{
	protected static int sequency;
	protected int receivedSequency;
	protected String message = "";
	protected Volt_divider voldi = null;


	public void Message(Volt_divider vd)
	{

		voldi=vd;

		message=sequency +" "+ vd.toString();
		sequency++;
	/*	this.vd = vd;
		this.vcc = Double.toString(this.vd.get_vcc());
		this.vref = Double.toString(this.vd.get_vref());
		this.r1 = Double.toString(this.vd.get_r1());
		this.r2 = Double.toString(this.vd.get_r2());
		message = "Vcc: " + this.vcc + " Vref: " + this.vref + " R1: " + this.r1 + " R2: " + this.r2;
*/
	}

	
	public byte[] toByteArray(){

		ByteArrayOutputStream bos = new ByteArrayOutputStream(2);
		DataOutputStream dos = new DataOutputStream(bos);

		try{
			dos.writeInt(sequency);
			vd.toByteArray(dos);
			dos.close();
			return bos.toByteArray();
		}catch (IOException e){
			e.printStackTrace();
			return null;
		}
	}



	public Message(String data, byte[] bytedata){
		ByteArrayInputStream bais = ByteArrayInputStream(bytedata);
		DataInputStream dis = new DataOutputStream(bais);
		try{
			this.receivedSequency=dis.readInt();

		}catch (IOException ex){
			ex.printStackTrace();
		}
		String[] fields = data.split(" ");
		if(fields.lengths == 5){
			receivedSequency = Integer.parseInt(fields[0]);
			voldi = new Volt_divider(fields[1], fields[2], fields[3], fields[4]); 
		}
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
