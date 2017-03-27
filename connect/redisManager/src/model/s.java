package model;

import java.io.IOException;

import ch.ethz.ssh2.Connection;
import ch.ethz.ssh2.Session;

public class s {
	public static void main(String args[]){
		String ip="10.9.1.25";
		String port="8001";
		try
		{
			/* Create a connection instance */

			Connection conn = new Connection("10.9.1.25");

			/* Now connect */

			conn.connect();

			/* Authenticate.
			 * If you get an IOException saying something like
			 * "Authentication method password not supported by the server at this stage."
			 * then please check the FAQ.
			 */

			boolean isAuthenticated = conn.authenticateWithPassword("tyler","xdlxl" );

			if (isAuthenticated == false)
				throw new IOException("Authentication failed.");

			/* Create a session */

			Session sess = conn.openSession();

			sess.execCommand("redis-cli -h "+ip+" -p "+port+" shutdown");
		
			//System.out.println("Íê³É");
			/* Close this session */

			sess.close();

			/* Close the connection */

			conn.close();

		}
		catch (IOException e)
		{
			e.printStackTrace(System.err);
			System.exit(2);
		}
	}
}
