package Beans;

import java.io.Serializable;

public class period implements Serializable {

    private static final long serialVersionUID = 1L;
    private int id_period;
    private int first_period;
    private int cycle_length;
    private int period_duration;
    private String nature_period;
    private String period_pattern;
    private int id_user;

    public period() {
    }

    public int getId_period() {
        return id_period;
    }

    public void setId_period(int id_period) {
        this.id_period = id_period;
    }

    public int getFirst_period() {
        return first_period;
    }

    public void setFirst_period(int first_period) {
        this.first_period = first_period;
    }

    public int getCycle_length() {
        return cycle_length;
    }

    public void setCycle_length(int cycle_length) {
        this.cycle_length = cycle_length;
    }

    public int getPeriod_duration() {
        return period_duration;
    }

    public void setPeriod_duration(int period_duration) {
        this.period_duration = period_duration;
    }

    public String getNature_period() {
        return nature_period;
    }

    public void setNature_period(String nature_period) {
        this.nature_period = nature_period;
    }

    public String getPeriod_pattern() {
        return period_pattern;
    }

    public void setPeriod_pattern(String period_pattern) {
        this.period_pattern = period_pattern;
    }

    public int getId_user() {
        return id_user;
    }

    public void setId_user(int id_user) {
        this.id_user = id_user;
    }
}
