package Beans;
import java.util.Date;

public class PainTrack {
    private int idPainTrack;
    private int painSeverity;
    private String[] painLocations;
	public int getId_user() {
		return id_user;
	}

	public void setId_user(int id_user) {
		this.id_user = id_user;
	}

	private String[] painWorsen;
    private String[] feelings;
    private String[] symptomes ;
    private Date date;
    private int id_user ;

    // Constructeur par défaut
    public PainTrack() {
    }

    // Getters et Setters

    public int getIdPainTrack() {
        return idPainTrack;
    }

    public void setIdPainTrack(int idPainTrack) {
        this.idPainTrack = idPainTrack;
    }

    public int getPainSeverity() {
        return painSeverity;
    }

    public void setPainSeverity(int painSeverity) {
        this.painSeverity = painSeverity;
    }

    public String[] getPainLocations() {
        return painLocations;
    }

    public void setPainLocations(String[] painLocations2) {
        this.painLocations = painLocations2;
    }

    public String[] getPainWorsen() {
        return painWorsen;
    }

    public void setPainWorsen(String[] painWorsen) {
        this.painWorsen = painWorsen;
    }

    public String[] getFeelings() {
        return feelings;
    }

    public void setFeelings(String[] feelings) {
        this.feelings = feelings;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(java.util.Date date2) {
        this.date = (Date) date2;
    }

	public void setSymptoms(String join) {
		// TODO Auto-generated method stub
		
	}

	
	 public String[] getSymptomes() {
			return symptomes;
		}

		public void setSymptomes(String[] symptoms) {
			this.symptomes = symptoms;
		}

    
}
