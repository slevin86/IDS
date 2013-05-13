/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package rest;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Davide
 */
@Entity
@Table(name = "componentesemilavorato")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Componentesemilavorato.findAll", query = "SELECT c FROM Componentesemilavorato c"),
    @NamedQuery(name = "Componentesemilavorato.findByIdComponenteSemilavorato", query = "SELECT c FROM Componentesemilavorato c WHERE c.idComponenteSemilavorato = :idComponenteSemilavorato"),
    @NamedQuery(name = "Componentesemilavorato.findByNome", query = "SELECT c FROM Componentesemilavorato c WHERE c.nome = :nome"),
    @NamedQuery(name = "Componentesemilavorato.findByColore", query = "SELECT c FROM Componentesemilavorato c WHERE c.colore = :colore"),
    @NamedQuery(name = "Componentesemilavorato.findByComponenteSemilavoratocol", query = "SELECT c FROM Componentesemilavorato c WHERE c.componenteSemilavoratocol = :componenteSemilavoratocol")})
public class Componentesemilavorato implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idComponenteSemilavorato")
    private Integer idComponenteSemilavorato;
    @Size(max = 70)
    @Column(name = "nome")
    private String nome;
    @Size(max = 70)
    @Column(name = "colore")
    private String colore;
    @Size(max = 45)
    @Column(name = "ComponenteSemilavoratocol")
    private String componenteSemilavoratocol;
    @ManyToMany(mappedBy = "componentesemilavoratoCollection")
    private Collection<Schedatecnica> schedatecnicaCollection;
    @JoinColumn(name = "idComponentePrimario_FK", referencedColumnName = "idComponentePrimario")
    @ManyToOne
    private Componenteprimario idComponentePrimarioFK;

    public Componentesemilavorato() {
    }

    public Componentesemilavorato(Integer idComponenteSemilavorato) {
        this.idComponenteSemilavorato = idComponenteSemilavorato;
    }

    public Integer getIdComponenteSemilavorato() {
        return idComponenteSemilavorato;
    }

    public void setIdComponenteSemilavorato(Integer idComponenteSemilavorato) {
        this.idComponenteSemilavorato = idComponenteSemilavorato;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getColore() {
        return colore;
    }

    public void setColore(String colore) {
        this.colore = colore;
    }

    public String getComponenteSemilavoratocol() {
        return componenteSemilavoratocol;
    }

    public void setComponenteSemilavoratocol(String componenteSemilavoratocol) {
        this.componenteSemilavoratocol = componenteSemilavoratocol;
    }

    @XmlTransient
    public Collection<Schedatecnica> getSchedatecnicaCollection() {
        return schedatecnicaCollection;
    }

    public void setSchedatecnicaCollection(Collection<Schedatecnica> schedatecnicaCollection) {
        this.schedatecnicaCollection = schedatecnicaCollection;
    }

    public Componenteprimario getIdComponentePrimarioFK() {
        return idComponentePrimarioFK;
    }

    public void setIdComponentePrimarioFK(Componenteprimario idComponentePrimarioFK) {
        this.idComponentePrimarioFK = idComponentePrimarioFK;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idComponenteSemilavorato != null ? idComponenteSemilavorato.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Componentesemilavorato)) {
            return false;
        }
        Componentesemilavorato other = (Componentesemilavorato) object;
        if ((this.idComponenteSemilavorato == null && other.idComponenteSemilavorato != null) || (this.idComponenteSemilavorato != null && !this.idComponenteSemilavorato.equals(other.idComponenteSemilavorato))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "rest.Componentesemilavorato[ idComponenteSemilavorato=" + idComponenteSemilavorato + " ]";
    }
    
}
