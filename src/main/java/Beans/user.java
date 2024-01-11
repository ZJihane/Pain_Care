package Beans;
import java.io.Serializable;
public class user implements Serializable {
     
	private static final long serialVersionUID = 1L;
    private int iduser;
    private String nomuser;
    private int role;
    private String email;
    private String password;

    public user() {
    }

    public int getIduser() {
        return iduser;
    }

    public void setIduser(int id_user ) {
        this.iduser = id_user ;
    }

    public String getNomuser() {
        return nomuser;
    }

    public void setNomuser(String nomUser) {
        this.nomuser = nomUser;
    }

    public int getRole() {
        return role;
    }

    public void setRole(int role) {
        this.role = role;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
