//
//import ch.ethz.ssh2.Connection;
//import ch.ethz.ssh2.ConnectionMonitor;
//import ch.ethz.ssh2.SFTPv3Client;
//import ch.ethz.ssh2.SFTPv3DirectoryEntry;
//import ch.ethz.ssh2.SFTPv3FileHandle;
//public class S{
//	public static void main(String args[]){
//		Connection conn = new Connection("10.9.1.25");
//		conn.addConnectionMonitor(new ConnectionMonitor() {
//			public void connectionLost(Throwable reason) {
//				reason.getStackTrace();
//				throw new RuntimeException(reason);
//			}
//		});
//		conn.connect();
//		
//		File keyfile = new File(privKeyPath);
//		boolean isAuthenticated = conn.authenticateWithPublicKey(sshUsername, keyfile, sshPassword);
//		if (isAuthenticated == false) {
//			throw new IOException("Connect SSH Authentication failed.");
//		}
//		log.info("Connecting to " + sshHostname + "successful !");
//	
//		SFTPv3Client client = new SFTPv3Client(conn);
//		client.setCharset("GBK");
//		Vector<SFTPv3DirectoryEntry> fileList = client.ls(sourceFile);
//		if (fileList.size() == 0) {
//			log.info("No file existed in the sourceFolder ["+sourceFile+"]");
//			return;
//		}
//	
//		for (SFTPv3DirectoryEntry entry : fileList) {
//			log.debug("Capture the file "+entry.filename+" in the sourceFolder ["+"]");
//			if (".".equals(entry.filename) || "..".equals(entry.filename)) {
//				continue;
//			}
//			if (!entry.filename.startsWith("atcc")) {
//				continue;
//			}
//			CaptureDataTrack captureDataTrack = captureDataTrackService.captureChecker(entry.filename);
//			if (captureDataTrack != null) {
//				continue;
//			}
//			log.info(entry.filename + " " + entry.longEntry);
//			SFTPv3FileHandle fileHandle = client.openFileRO(sourceFile + entry.filename);
//	
//			File myFile = new File(targetFile + entry.filename);
//			OutputStream out = new FileOutputStream(myFile);
//	
//			long numread = 0;
//			int length = 0;
//			Long len = entry.attributes.size;
//			int readSize = len.compareTo(Long.valueOf(loadSize)) > 0 ? loadSize : len.intValue();
//			byte[] bytes = new byte[readSize];
//			while (readSize > 0 && (numread = client.read(fileHandle, length, bytes, 0, readSize)) != -1) {
//				length += numread;
//				out.write(bytes);
//				readSize = len.compareTo(Long.valueOf(length + loadSize)) > 0 ? loadSize : (int) (len - length);
//				bytes = new byte[readSize];
//			}
//	
//			out.close();
//		}
//	}
//}