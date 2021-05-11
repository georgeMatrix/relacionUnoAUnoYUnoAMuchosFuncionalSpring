package com.formatoweb.relacionesunounoyunomuchos.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "provedor", schema = "producto-cliente-03052021", catalog = "")
public class Provedor {
    private Long id;
    private String nombre;
    private String apellido;
    private Integer edad;
    private String email;
    private DatosFiscales datosFiscales;
    private List<Producto> productos;

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Basic
    @Column(name = "nombre")
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Basic
    @Column(name = "apellido")
    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    @Basic
    @Column(name = "edad")
    public Integer getEdad() {
        return edad;
    }

    public void setEdad(Integer edad) {
        this.edad = edad;
    }

    @Basic
    @Column(name = "email")
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Provedor provedor = (Provedor) o;
        return Objects.equals(id, provedor.id) &&
                Objects.equals(nombre, provedor.nombre) &&
                Objects.equals(apellido, provedor.apellido) &&
                Objects.equals(edad, provedor.edad) &&
                Objects.equals(email, provedor.email);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nombre, apellido, edad, email);
    }

    @OneToOne(mappedBy = "provedor")
    @JsonManagedReference
    public DatosFiscales getDatosFiscales() {
        return datosFiscales;
    }

    public void setDatosFiscales(DatosFiscales datosFiscales) {
        this.datosFiscales = datosFiscales;
    }

    @OneToMany(mappedBy = "provedor")
    @JsonManagedReference
    public List<Producto> getProductos() {
        return productos;
    }

    public void setProductos(List<Producto> productos) {
        this.productos = productos;
    }
}
