/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package src;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author rafael
 */
@Entity
@Table(name = "acervo")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Acervo.findAll", query = "SELECT a FROM Acervo a")
    , @NamedQuery(name = "Acervo.findById", query = "SELECT a FROM Acervo a WHERE a.id = :id")
    , @NamedQuery(name = "Acervo.findByTitulo", query = "SELECT a FROM Acervo a WHERE a.titulo = :titulo")
    , @NamedQuery(name = "Acervo.findByAutor", query = "SELECT a FROM Acervo a WHERE a.autor = :autor")
    , @NamedQuery(name = "Acervo.findByAssunto", query = "SELECT a FROM Acervo a WHERE a.assunto = :assunto")
    , @NamedQuery(name = "Acervo.findByAno", query = "SELECT a FROM Acervo a WHERE a.ano = :ano")
    , @NamedQuery(name = "Acervo.findByEditora", query = "SELECT a FROM Acervo a WHERE a.editora = :editora")})
public class Acervo implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "ID")
    private Integer id;
    @Column(name = "titulo")
    private String titulo;
    @Column(name = "autor")
    private String autor;
    @Column(name = "assunto")
    private String assunto;
    @Column(name = "ano")
    private String ano;
    @Column(name = "editora")
    private String editora;

    public Acervo() {
    }

    public Acervo(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getAssunto() {
        return assunto;
    }

    public void setAssunto(String assunto) {
        this.assunto = assunto;
    }

    public String getAno() {
        return ano;
    }

    public void setAno(String ano) {
        this.ano = ano;
    }

    public String getEditora() {
        return editora;
    }

    public void setEditora(String editora) {
        this.editora = editora;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Acervo)) {
            return false;
        }
        Acervo other = (Acervo) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "src.Acervo[ id=" + id + " ]";
    }
    
}
