package Beans;

import java.io.Serializable;

public class diagnostic implements Serializable {

    private static final long serialVersionUID = 1L;
    private int id_diagnostic;
    private double weight;
    private double height;
    private double bmi;
    private int id_user;
    private double resultat;

    public double getResultat() {
		return resultat;
	}

	public void setResultat(double resultat) {
		this.resultat = resultat;
	}

	public diagnostic() {
    }

    public int getId_diagnostic() {
        return id_diagnostic;
    }

    public void setId_diagnostic(int id_diagnostic) {
        this.id_diagnostic = id_diagnostic;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public double getBmi() {
        return bmi;
    }

    public void setBmi(double bmi) {
        this.bmi = bmi;
    }

    public int getId_user() {
        return id_user;
    }

    public void setId_user(int id_user) {
        this.id_user = id_user;
    }
}