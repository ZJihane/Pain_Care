package Beans;

import java.io.Serializable;

public class pain implements Serializable {

    private static final long serialVersionUID = 1L;
    private int id_pain;
    private String[] pain_trigger;
    private boolean pain_rapport;
    private int severity_pain;
    private String other_symptom;
    private int id_user;

    public pain() {
    }

    public int getId_pain() {
        return id_pain;
    }

    public boolean isPain_rapport() {
		return pain_rapport;
	}

	public void setPain_rapport(boolean pain_rapport) {
		this.pain_rapport = pain_rapport;
	}

	public void setId_pain(int id_pain) {
        this.id_pain = id_pain;
    }

    public String[] getPain_trigger() {
        return pain_trigger;
    }

    public void setPain_trigger(String[] updatedPainTrigger) {
        this.pain_trigger = updatedPainTrigger;
    }

    public int getSeverity_pain() {
        return severity_pain;
    }

    public void setSeverity_pain(int severity_pain) {
        this.severity_pain = severity_pain;
    }

    public String getOther_symptom() {
        return other_symptom;
    }

    public void setOther_symptom(String other_symptom) {
        this.other_symptom = other_symptom;
    }

    public int getId_user() {
        return id_user;
    }

    public void setId_user(int id_user) {
        this.id_user = id_user;
    }
}
