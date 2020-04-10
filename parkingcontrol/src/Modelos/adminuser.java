package Modelos;

import java.io.Serializable;

public class adminuser implements Serializable {

    private String usuario;
    private String clave;
    private String papel;
    private String adcedula;
    private String nomapead;
    private String telefonoad;

    public String getAdcedula() {
        return adcedula;
    }

    public void setAdcedula(String adcedula) {
        this.adcedula = adcedula;
    }

    public String getNomapead() {
        return nomapead;
    }

    public void setNomapead(String nomapead) {
        this.nomapead = nomapead;
    }

    public String getTelefonoad() {
        return telefonoad;
    }

    public void setTelefonoad(String telefonoad) {
        this.telefonoad = telefonoad;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public String getPapel() {
        return papel;
    }

    public void setPapel(String papel) {
        this.papel = papel;
    }

}
