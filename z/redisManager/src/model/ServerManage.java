//负责杀死、启动进程，直接给定的代码。
//通过ssh
package model;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.text.SimpleDateFormat;
import java.util.Date;

import ch.ethz.ssh2.Connection;
import ch.ethz.ssh2.Session;
import ch.ethz.ssh2.StreamGobbler;

//暂时将地址写死！！！！！！！！！！！！！！！！！
//通过ssh操作Ubuntu，关闭/打开 redis 服务
public class ServerManage {
	private String hostname="10.9.1.25";
	private String username="tyler";
	private String password="xdlxl";
	private String port;
	private String ip;
	public ServerManage(){
		
	}
	public ServerManage(String lo){
		String[] s=lo.split(":");
		this.ip=s[0];
		this.port=s[1];
		}
	//开启redis服务
	public void setServer(){
		
		try
		{
			/* Create a connection instance */

			Connection conn = new Connection(hostname);
			conn.setTCPNoDelay(true);
			/* Now connect */

			conn.connect();
			

			/* Authenticate.
			 * If you get an IOException saying something like
			 * "Authentication method password not supported by the server at this stage."
			 * then please check the FAQ.
			 */

			boolean isAuthenticated = conn.authenticateWithPassword(username, password);

			if (isAuthenticated == false)
				throw new IOException("Authentication failed.");

			/* Create a session */

			Session sess = conn.openSession();
			
		
			sess.execCommand("cd ~/Documents/clu/"+port+";redis-server redis.conf");
			
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
	
	//杀死redis服务
	public void killServer(){
		try
		{
			/* Create a connection instance */

			Connection conn = new Connection(hostname);
			conn.setTCPNoDelay(true);
			/* Now connect */

			conn.connect();

			/* Authenticate.
			 * If you get an IOException saying something like
			 * "Authentication method password not supported by the server at this stage."
			 * then please check the FAQ.
			 */

			boolean isAuthenticated = conn.authenticateWithPassword(username, password);

			if (isAuthenticated == false)
				throw new IOException("Authentication failed.");

			/* Create a session */

			Session sess = conn.openSession();

			sess.execCommand("redis-cli -h "+ip+" -p "+port+" shutdown");
		
			//System.out.println("完成");
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
	public void exec(String s){
		try
		{
			/* Create a connection instance */

			Connection conn = new Connection(hostname);

			/* Now connect */

			conn.connect();

			/* Authenticate.
			 * If you get an IOException saying something like
			 * "Authentication method password not supported by the server at this stage."
			 * then please check the FAQ.
			 */

			boolean isAuthenticated = conn.authenticateWithPassword(username, password);

			if (isAuthenticated == false)
				throw new IOException("Authentication failed.");

			/* Create a session */

			Session sess = conn.openSession();
			System.out.println(s);
			sess.execCommand(s);
		
			//System.out.println("完成");
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
	public void execAndRe(String s){
		try
		{
			/* Create a connection instance */

			Connection conn = new Connection(hostname);

			/* Now connect */

			conn.connect();

			/* Authenticate.
			 * If you get an IOException saying something like
			 * "Authentication method password not supported by the server at this stage."
			 * then please check the FAQ.
			 */

			boolean isAuthenticated = conn.authenticateWithPassword(username, password);

			if (isAuthenticated == false)
				throw new IOException("Authentication failed.");

			/* Create a session */

			Session sess = conn.openSession();

			sess.execCommand(s);
			
			 InputStream stdout = new StreamGobbler(sess.getStdout());  
	         InputStream stderr = new StreamGobbler(sess.getStderr());  
	         BufferedReader stdoutReader = new BufferedReader(  
	                    new InputStreamReader(stdout));  
	         BufferedReader stderrReader = new BufferedReader(  
	                    new InputStreamReader(stderr));  
	              
	         System.out.println("Here is the output from stdout:");  
	            while (true) {  
	            	System.out.println("11");
	                String line = stdoutReader.readLine();
	                System.out.println("22");
	                if (line == null){
	                    System.out.println("line为null");
	                    break;
	                }
	                System.out.println("完成");
	                System.out.println(line);  
	            }  
	  
	          System.out.println("Here is the output from stderr:");  
	            while (true) {  
	                String line = stderrReader.readLine();
	                if (line == null)  
	                    break;  
	                System.out.println(line);  
	         }  
		
			System.out.println("完成");
			/* Close this session */

			sess.close();

			/* Close the connection */
			stdoutReader.close();
			stderrReader.close();
			conn.close();

		}
		catch (IOException e)
		{
			e.printStackTrace(System.err);
			System.exit(2);
		}
	}
	public static void main(String args[]){
		SimpleDateFormat sdf=new SimpleDateFormat("YYYY-MM-dd HH:MM:ss");

		try{
			System.out.println("开始时间："+sdf.format(new Date()));
			Connection conn = new Connection("10.9.1.25");
			System.out.println("连接结束："+sdf.format(new Date()));
			conn.setTCPNoDelay(true);

			conn.connect();
			System.out.println("connect："+sdf.format(new Date()));
			

			boolean isAuthenticated = conn.authenticateWithPassword("tyler","xdlxl");

			if (isAuthenticated == false)
				throw new IOException("Authentication failed.");
			System.out.println("isAuthenticated："+sdf.format(new Date()));
			/* Create a session */
			System.out.println("开始关闭："+sdf.format(new Date()));
			Session sess = conn.openSession();

			sess.execCommand("cd  /etc");
			System.out.println("关闭结束："+sdf.format(new Date()));

			sess.close();

			conn.close();
			System.out.println("完成时间："+sdf.format(new Date()));
		}
		catch (IOException e)
		{
			e.printStackTrace(System.err);
			System.exit(2);
		}
	}
}
