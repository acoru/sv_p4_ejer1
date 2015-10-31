public class Server
{
	/*	Login class that will be use for authentication in the system.
	*	It contains multiples attributes:
	*	user: an attribute that will contain the user name
	*	pass: it'll contain the password of the user
	*	domain_l: it'll will contain the domain in which the user is connecting
	*	port: the port of the domain
	*/
	protected String user = "";
	protected String pass = "";
	protected String domain_l = "";
	protected int port = 0;

	//this is the constructor that must be called first for creating the session
	public Server(String user, String pass)
	{
		this.user = user;
		this.pass = pass;
	}

	//once the user is authenticated on the system, it can be set a domain and a port
	public void setDomain(String domain_l)
	{
		this.domain_l = domain_l;
	}

	public void setPort(int port)
	{
		this.port = port;
	}

	//if it's necessary, user can obtain the login data.
	public String getUser()
	{
		return this.user;
	}

	public String getPass()
	{
		return this.pass;
	}

	public String domain_l()
	{
		return domain_l;
	}

	//for closing the session
	public void closeSession()
	{
		user = "";
		pass = "";
		domain_l = "";
		port = 0;
	}

	
}
