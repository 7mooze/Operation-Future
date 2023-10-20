package Input;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.net.UnknownHostException;
import org.json.simple.*;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class OFSensor implements Runnable
{
	private static OFSensor _instance;
	private static Socket _socket;
	private static BufferedReader _reader;
	private static String _buffer = null;
	private static JSONParser _parser = new JSONParser();
	private volatile static boolean _isClosed; //Should we use volatile here?
	
	private OFSensor( String uri, int port ) throws UnknownHostException, IOException 
	{
		Thread _thread = new Thread( this );
		_socket = new Socket( uri, port ); //Start Socket and connect to uri:port
		_reader = new BufferedReader( new InputStreamReader( _socket.getInputStream() ) );
		_thread.start(); //Start Thread
	}
	
	public static synchronized OFSensor startClient( String uri, int port ) throws UnknownHostException, IOException 
	{
		if( _instance == null ) 
		{
			_instance = new OFSensor( uri, port );
		}
		
		_isClosed = false;
		return _instance;
	}

	public static synchronized void stopClient() throws IOException 
	{
		if( _instance != null ) 
		{
			_isClosed = true;
			_socket.close();
			_reader.close();
			_instance = null;
			_socket = null;
			_reader = null;
		}
	}
	
	public String read( String key ) throws ParseException, IOException
	{
		_buffer = _reader.readLine();
		JSONObject in = (JSONObject) _parser.parse( _buffer );
		String out = (String) in.get( key );
		return out;
	}
	
	public int readInt( String key ) throws ParseException, IOException
	{
		_buffer = _reader.readLine();
		JSONObject in = (JSONObject) _parser.parse( _buffer );
		int out = Integer.valueOf( (String) in.get( key ) );
		return out;
	}
	
	public double readDouble( String key ) throws ParseException, IOException
	{
		_buffer = _reader.readLine();
		JSONObject in = (JSONObject) _parser.parse( _buffer );
		double out = Double.valueOf( (String) in.get( key ) );
		return out;
	}
	
	public String readLine() throws ParseException, IOException
	{
		_buffer = _reader.readLine();
		return _buffer;
	}
	
	public void run()
	{
			while( !_isClosed );
	}
}
