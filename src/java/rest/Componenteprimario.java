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
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Davide
 */
@Entity
@Table(name = "componenteprimario")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Componenteprimario.findAll", query = "SELECT c FROM Componenteprimario c"),
    @NamedQuery(name = "Componenteprimario.findByIdComponentePrimario", query = "SELECT c FROM Componenteprimario c WHERE c.idComponentePrimario = :idComponentePrimario"),
    @NamedQuery(name = "Componenteprimario.findByNome", query = "SELECT c FROM Componenteprimario c WHERE c.nome = :nome"),
    @NamedQuery(name = "Componenteprimario.findByColore", query = "SELECT c FROM Componenteprimario c WHERE c.colore = :colore")})
public class Componenteprimario implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idComponentePrimario")
    private Integer idComponentePrimario;
    @Size(max = 70)
    @Column(name = "nome")
    private String nome;
    @Size(max = 70)
    @Column(name = "colore")
    private String colore;
    @ManyToMany(mappedBy = "componenteprimarioCollection")
    private Collection<Schedatecnica> schedatecnicaCollection;
    @OneToMany(mappedBy = "idComponentePrimarioFK")
    private Collection<Componentesemilavorato> componentesemilavoratoCollection;
    @JoinColumn(name = "idMateriale_FK", referencedColumnName = "idMateriali")
    @ManyToOne
    private Materiali idMaterialeFK;

    public Componenteprimario() {
    }

    public Componenteprimario(Integer idComponentePrimario) {
        this.idComponentePrimario = idComponentePrimario;
    }

    public Integer getIdComponentePrimario() {
        return idComponentePrimario;
    }

    public void setIdComponentePrimario(Integer idComponentePrimario) {
        this.idComponentePrimario = idComponentePrimario;
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

    @XmlTransient
    public Collection<Schedatecnica> getSchedatecnicaCollection() {
        return schedatecnicaCollection;
    }

    public void setSchedatecnicaCollection(Collection<Schedatecnica> schedatecnicaCollection) {
        this.schedatecnicaCollection = schedatecnicaCollection;
    }

    @XmlTransient
    public Collection<Componentesemilavorato> getComponentesemilavoratoCollection() {
        return componentesemilavoratoCollection;
    }

    public void setComponentesemilavoratoCollection(Collection<Componentesemilavorato> componentesemilavoratoCollection) {
        this.componentesemilavoratoCollection = componentesemilavoratoCollection;
    }

    public Materiali getIdMaterialeFK() {
        return idMaterialeFK;
    }

    public void setIdMaterialeFK(Materiali idMaterialeFK) {
        this.idMaterialeFK = idMaterialeFK;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idComponentePrimario != null ? idComponentePrimario.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Componenteprimario)) {
            return false;
        }
        Componenteprimario other = (Componenteprimario) object;
        if ((this.idComponentePrimario == null && other.idComponentePrimario != null) || (this.idComponentePrimario != null && !this.idComponentePrimario.equals(other.idComponentePrimario))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "rest.Componenteprimario[ idComponentePrimario=" + idComponentePrimario + " ]";
    }
    
}
