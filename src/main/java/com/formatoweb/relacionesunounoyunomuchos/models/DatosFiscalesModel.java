package com.formatoweb.relacionesunounoyunomuchos.models;

public class DatosFiscalesModel {
    private Long id;
    private String rfc;
    private String curp;
    private Long bandera;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getBandera() {
        return bandera;
    }

    public void setBandera(Long bandera) {
        this.bandera = bandera;
    }

    public String getRfc() {
        return rfc;
    }

    public void setRfc(String rfc) {
        this.rfc = rfc;
    }

    public String getCurp() {
        return curp;
    }

    public void setCurp(String curp) {
        this.curp = curp;
    }
}
