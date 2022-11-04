import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

//implmenta pattern singleton 

public class DataBaseConnessione {
	
	private final static String protocol = "jdbc:postgresql" + "://";
	private static String host = "localhost/";
	private static String resource = "LabB";
	private static String url = protocol + host + resource;
	private static String porta = "";
	
	private static String username = "postgres";
	private static String password = "admin";
	
	private static Connection connection = null;
	private static Statement statement = null;
	
	/**
	 * Costruttore vuoto, dato che la classe implementa il pattern Singleton
	 * */
	
	private DataBaseConnessione() {
	}
	
	/**
	 * Metodo che restituisce la Connection del database
	 * 
	 * @param user username con cui accedere al database
	 * @param pass password con cui accedere al database
	 * @param host2 indirizzo della macchina su cui &egrave; presente il database
	 * @param port porta su cui gira il database
	 * @param name nome del database
	 * 
	 * @throws SQLException se ci sono problemi nella connessione al database
	 * 
	 * @return un oggetto Connection, il quale si riferisce alla connessione appena istanziata
	 * */
	
	public static Connection getConnection(String user, String pass, String host2, String port, String name) throws SQLException {
		resource = name;
		username = user;
		password = pass;
		porta = port;
		host = host2 + "/";
		url = protocol + host + resource;
		if (connection == null) {
			connection = DriverManager.getConnection(url, username, password);
		}
		return connection;
	}
	
	/**
	 * Metodo che chiude la connessione verso il database istanziato con getConnection
	 * 
	 * @throws SQLException se ci sono problemi di chiusura della connessione, come ad esempio la chiusura di una connessione non ancora aperta
	 * */
	public static void closeConnection() throws SQLException {
		connection.close();
		connection = null;
	}
	
	/**
	 * Metodo che restituisce un oggetto Statement dell'oggetto Connection istanziato con il metodo getConnection
	 * 
	 * @throws SQLException se ci sono problemi di connessione al database
	 */		
	public static Statement getStatement() throws SQLException {
		if (statement == null) {
			Connection connection = getConnection(username, password, host, porta, resource);
			statement = connection.createStatement();
		}
		return statement; //lo statement è quello che esegue le query
	}
	
	/**
	 * Metodo che chiude la connessione verso il database istanziato con getConnection
	 * 
	 * @throws SQLException se ci sono problemi di chiusura della connessione, come ad esempio la chiusura di una connessione non ancora aperta
	 * */
	public static void closeStatement() throws SQLException {
		((Connection) statement).close();
		statement = null;
	}

}
