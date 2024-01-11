package Beans;

public class recette {
    
    private int id_recette;
    private String nom_recette;

    private String description;
    private byte[] picture;
    private String pictureBase64;

    public int getId_recette() {
		return id_recette;
	}

	public void setId_recette(int id_recette) {
		this.id_recette = id_recette;
	}

	public String getNom_recette() {
		return nom_recette;
	}

	public void setNom_recette(String nom_recette) {
		this.nom_recette = nom_recette;
	}

	public byte[] getPicture() {
		return picture;
	}

	public void setPicture(byte[] picture) {
		this.picture = picture;
	}

	public recette() {
    }

    public int getIdRecette() {
        return id_recette;
    }

    public void setIdRecette(int idRecette) {
        this.id_recette = idRecette;
    }

    public String getNomRecette() {
        return nom_recette;
    }

    public void setNomRecette(String nomRecette) {
        this.nom_recette = nomRecette;
    }

   

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPictureBase64() {
        return pictureBase64;
    }

    public void setPictureBase64(String pictureBase64) {
        this.pictureBase64 = pictureBase64;
    }
}
