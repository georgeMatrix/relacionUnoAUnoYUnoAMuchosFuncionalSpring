package com.formatoweb.relacionesunounoyunomuchos.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "datos_fiscales", schema = "producto-cliente-03052021", catalog = "")
public class DatosFiscales {
    private Long id;
    private String rfc;
    private String curp;
    private Cliente cliente;
    private Long bandera;

    @Id
    @Column(name = "id")
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Basic
    @Column(name = "bandera")
    public Long getBandera() {
        return bandera;
    }

    public void setBandera(Long bandera) {
        this.bandera = bandera;
    }

    @Basic
    @Column(name = "rfc")
    public String getRfc() {
        return rfc;
    }

    public void setRfc(String rfc) {
        this.rfc = rfc;
    }

    @Basic
    @Column(name = "curp")
    public String getCurp() {
        return curp;
    }

    public void setCurp(String curp) {
        this.curp = curp;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DatosFiscales that = (DatosFiscales) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(rfc, that.rfc) &&
                Objects.equals(curp, that.curp);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, rfc, curp);
    }

    @OneToOne
    @JsonBackReference
    @JoinColumn(name = "id", referencedColumnName = "id", nullable = false)
    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }
}
