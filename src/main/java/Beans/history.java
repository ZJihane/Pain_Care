package Beans;

import java.io.Serializable;

public class history implements Serializable {

    private static final long serialVersionUID = 1L;
    private int id_history;
    private boolean endo_history;
    private boolean birth;
    private boolean trouble_pregnant;
    private boolean sexual_abuse;
    private int id_user;

    public history() {
    }

    public int getId_history() {
        return id_history;
    }

    public void setId_history(int id_history) {
        this.id_history = id_history;
    }

    public boolean isEndo_history() {
        return endo_history;
    }

    public void setEndo_history(boolean endo_history) {
        this.endo_history = endo_history;
    }

    public boolean isBirth() {
        return birth;
    }

    public void setBirth(boolean birth) {
        this.birth = birth;
    }

    public boolean isTrouble_pregnant() {
        return trouble_pregnant;
    }

    public void setTrouble_pregnant(boolean trouble_pregnant) {
        this.trouble_pregnant = trouble_pregnant;
    }

    public boolean isSexual_abuse() {
        return sexual_abuse;
    }

    public void setSexual_abuse(boolean sexual_abuse) {
        this.sexual_abuse = sexual_abuse;
    }

    public int getId_user() {
        return id_user;
    }

    public void setId_user(int id_user) {
        this.id_user = id_user;
    }
}
