import java.sql.SQLException;
import java.util.List;

//PATTERN SKELETON --> solleva il server dalla gestione delle comunicazioni.
public interface SkeletonInterface {

	//inserisce il nuovo centro nel DB 
	public int registraCentroVaccinale(String nome, String qualificatore, String indirizzo, String numeroCivico, String comune, String provincia, String cap, String tipologia) throws SQLException;
	
	//inserisce vaccinato nel DB
	public int registraVaccinato(String nomeCentro, String nome, String cognome, String codiceFiscale, String dataSomministrazione, String tipoVaccino, String nDosi) throws SQLException ;
	
	//restituisce una lista contenente in posizione 0 il nome e in posizione 1 idUnivoco del vaccinato
	public List<String> IdUnivoco(String codiceFiscale) throws SQLException ; 
	
	//ritorna l'elenco dei centri vaccinali registrati nel DB
	public List<String> retElencoCentriVaccinali() throws SQLException ;
	
	//crea tabelle nel DB
	public void creazioneTabelle() throws SQLException;
	
}