import java.io.IOException;
import java.net.*;
import java.util.Enumeration;
import java.util.List;
import java.util.ArrayList;
import java.util.Objects;
  
public class ProjectComm {
	private final DatagramSocket socket;
	private final InetAddress destIP;
	private final int destPort;

	public ProjectComm(String hostname) throws IOException{
		List<InetAddress> broadcastList = discoverBroadcastAddresses();
		socket = new DatagramSocket();
        socket.setBroadcast(true);
		socket.setSoTimeout(3000);
		String ipPortPair = "";
		int index = 0;
		boolean isDone = false;
		while(index < broadcastList.size() && !isDone){
			InetAddress bcastaddr = broadcastList.get(index);
			ipPortPair = getIpAndPort(hostname, bcastaddr, 13000);
			if (ipPortPair.length() > 0){
				isDone = true;
			}
			index++;
		}

		if (isDone) {
			String[] netInfo = ipPortPair.split(":");
			destIP = InetAddress.getByName(netInfo[0]);
			destPort = Integer.parseInt(netInfo[1]);
		} else {
			throw new SocketException("Unable to find a server!");
		}
	}

	public static List<InetAddress> discoverBroadcastAddresses() throws SocketException {
		List<InetAddress> broadcastList = new ArrayList<>();
		Enumeration<NetworkInterface> interfaces = NetworkInterface.getNetworkInterfaces();
		while(interfaces.hasMoreElements()){
			NetworkInterface iface = interfaces.nextElement();
			if (iface.isLoopback() | !iface.isUp()) continue;
			iface.getInterfaceAddresses().stream()
					.map(InterfaceAddress::getBroadcast)
					.filter(Objects::nonNull)
					.forEach(broadcastList::add);
		}
		return broadcastList;
	}

	private void send(DatagramPacket packet) throws IOException{
		boolean isDone = false;
		int index = 3;
		while (!isDone){
			try {
				socket.send(packet);
				isDone = true;
			} catch (SocketTimeoutException soe){
				index--;
				isDone = index < 1;
			}
		}
	}

	private void receive(DatagramPacket response) throws IOException{
		boolean isDone = false;
		int index = 3;
		while(!isDone) {
			try {
				socket.receive(response);
				isDone = true;
			} catch (SocketTimeoutException ioe) {
				index--;
				isDone = index < 1;
			}
		}
		if (index < 1) {
			response.setData(new byte[0]);
		}
	}
	
	public String getIpAndPort(String message,InetAddress bcastAddress, int port)
			throws IOException{
		byte[] buffer = message.getBytes();
		String ipPortPair;
		DatagramPacket packet = new DatagramPacket(buffer, buffer.length, bcastAddress, port);
		send(packet);
		DatagramPacket response = new DatagramPacket(new byte[2048], 2048);
		receive(response);
		ipPortPair = new String(response.getData(),0,response.getLength());
		return ipPortPair;
	}

	public String sendCommand(String message) throws IOException{
		byte[] command = message.getBytes();
		DatagramPacket packet = new DatagramPacket(command, command.length, destIP, destPort);
		send(packet);
		DatagramPacket response = new DatagramPacket(new byte[2048], 2048);
		receive(response);
		return new String(response.getData(),0,response.getLength());
	}
	
	public void close(){
       	socket.close();	
	}
	
	public static void main(String[] args) throws IOException{
		if (args.length < 1){
			System.out.println("SYNOPSIS: java ProjectComm "+" <hostname>");
			System.exit(1);
		}
		ProjectComm comm = new ProjectComm(args[0]);
		System.out.println("Sending hello ...");
		System.out.println(comm.sendCommand("hello"));

		comm.close();
	}  
}  