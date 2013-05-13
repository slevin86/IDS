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
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
@Table(name = "cataloghi")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Cataloghi.findAll", query = "SELECT c FROM Cataloghi c"),
    @NamedQuery(name = "Cataloghi.findByIdCataloghi", query = "SELECT c FROM Cataloghi c WHERE c.idCataloghi = :idCataloghi"),
    @NamedQuery(name = "Cataloghi.findByNomeCatalogo", query = "SELECT c FROM Cataloghi c WHERE c.nomeCatalogo = :nomeCatalogo"),
    @NamedQuery(name = "Cataloghi.findByLingua", query = "SELECT c FROM Cataloghi c WHERE c.lingua = :lingua"),
    @NamedQuery(name = "Cataloghi.findByPath", query = "SELECT c FROM Cataloghi c WHERE c.path = :path")})
public class Cataloghi implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idCataloghi")
    private Integer idCataloghi;
    @Size(max = 70)
    @Column(name = "nome_Catalogo")
    private String nomeCatalogo;
    @Size(max = 45)
    @Column(name = "lingua")
    private String lingua;
    @Size(max = 100)
    @Column(name = "path")
    private String path;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "cataloghi")
    private Collection<CataloghiHasSchedatecnica> cataloghiHasSchedatecnicaCollection;

    public Cataloghi() {
    }

    public Cataloghi(Integer idCataloghi) {
        this.idCataloghi = idCataloghi;
    }

    public Integer getIdCataloghi() {
        return idCataloghi;
    }

    public void setIdCataloghi(Integer idCataloghi) {
        this.idCataloghi = idCataloghi;
    }

    public String getNomeCatalogo() {
        return nomeCatalogo;
    }

    public void setNomeCatalogo(String nomeCatalogo) {
        this.nomeCatalogo = nomeCatalogo;
    }

    public String getLingua() {
        return lingua;
    }

    public void setLingua(String lingua) {
        this.lingua = lingua;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    @XmlTransient
    public Collection<CataloghiHasSchedatecnica> getCataloghiHasSchedatecnicaCollection() {
        return cataloghiHasSchedatecnicaCollection;
    }

    public void setCataloghiHasSchedatecnicaCollection(Collection<CataloghiHasSchedatecnica> cataloghiHasSchedatecnicaCollection) {
        this.cataloghiHasSchedatecnicaCollection = cataloghiHasSchedatecnicaCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idCataloghi != null ? idCataloghi.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Cataloghi)) {
            return false;
        }
        Cataloghi other = (Cataloghi) object;
        if ((this.idCataloghi == null && other.idCataloghi != null) || (this.idCataloghi != null && !this.idCataloghi.equals(other.idCataloghi))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "rest.Cataloghi[ idCataloghi=" + idCataloghi + " ]";
    }
    
}
