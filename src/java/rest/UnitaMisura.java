/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package rest;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Davide
 */
@Entity
@Table(name = "unita_misura")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "UnitaMisura.findAll", query = "SELECT u FROM UnitaMisura u"),
    @NamedQuery(name = "UnitaMisura.findByIdUnitaMisura", query = "SELECT u FROM UnitaMisura u WHERE u.idUnitaMisura = :idUnitaMisura"),
    @NamedQuery(name = "UnitaMisura.findByNomeUnitaMisura", query = "SELECT u FROM UnitaMisura u WHERE u.nomeUnitaMisura = :nomeUnitaMisura")})
public class UnitaMisura implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "idUnitaMisura")
    private Integer idUnitaMisura;
    @Size(max = 45)
    @Column(name = "nomeUnitaMisura")
    private String nomeUnitaMisura;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "unitaMisuraidUnitaMisura")
    private Collection<Materiali> materialiCollection;

    public UnitaMisura() {
    }

    public UnitaMisura(Integer idUnitaMisura) {
        this.idUnitaMisura = idUnitaMisura;
    }

    public Integer getIdUnitaMisura() {
        return idUnitaMisura;
    }

    public void setIdUnitaMisura(Integer idUnitaMisura) {
        this.idUnitaMisura = idUnitaMisura;
    }

    public String getNomeUnitaMisura() {
        return nomeUnitaMisura;
    }

    public void setNomeUnitaMisura(String nomeUnitaMisura) {
        this.nomeUnitaMisura = nomeUnitaMisura;
    }

    @XmlTransient
    public Collection<Materiali> getMaterialiCollection() {
        return materialiCollection;
    }

    public void setMaterialiCollection(Collection<Materiali> materialiCollection) {
        this.materialiCollection = materialiCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idUnitaMisura != null ? idUnitaMisura.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof UnitaMisura)) {
            return false;
        }
        UnitaMisura other = (UnitaMisura) object;
        if ((this.idUnitaMisura == null && other.idUnitaMisura != null) || (this.idUnitaMisura != null && !this.idUnitaMisura.equals(other.idUnitaMisura))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "rest.UnitaMisura[ idUnitaMisura=" + idUnitaMisura + " ]";
    }
    
}
