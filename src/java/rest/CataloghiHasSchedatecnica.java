/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package rest;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Davide
 */
@Entity
@Table(name = "cataloghi_has_schedatecnica")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CataloghiHasSchedatecnica.findAll", query = "SELECT c FROM CataloghiHasSchedatecnica c"),
    @NamedQuery(name = "CataloghiHasSchedatecnica.findByCataloghiidCataloghi", query = "SELECT c FROM CataloghiHasSchedatecnica c WHERE c.cataloghiHasSchedatecnicaPK.cataloghiidCataloghi = :cataloghiidCataloghi"),
    @NamedQuery(name = "CataloghiHasSchedatecnica.findBySchedaTecnicaidSchedaTecnica", query = "SELECT c FROM CataloghiHasSchedatecnica c WHERE c.cataloghiHasSchedatecnicaPK.schedaTecnicaidSchedaTecnica = :schedaTecnicaidSchedaTecnica"),
    @NamedQuery(name = "CataloghiHasSchedatecnica.findByCataloghihasSchedaTecnicacol", query = "SELECT c FROM CataloghiHasSchedatecnica c WHERE c.cataloghihasSchedaTecnicacol = :cataloghihasSchedaTecnicacol")})
public class CataloghiHasSchedatecnica implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected CataloghiHasSchedatecnicaPK cataloghiHasSchedatecnicaPK;
    @Size(max = 45)
    @Column(name = "Cataloghi_has_SchedaTecnicacol")
    private String cataloghihasSchedaTecnicacol;
    @JoinColumn(name = "SchedaTecnica_idSchedaTecnica", referencedColumnName = "idSchedaTecnica", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Schedatecnica schedatecnica;
    @JoinColumn(name = "Cataloghi_idCataloghi", referencedColumnName = "idCataloghi", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Cataloghi cataloghi;

    public CataloghiHasSchedatecnica() {
    }

    public CataloghiHasSchedatecnica(CataloghiHasSchedatecnicaPK cataloghiHasSchedatecnicaPK) {
        this.cataloghiHasSchedatecnicaPK = cataloghiHasSchedatecnicaPK;
    }

    public CataloghiHasSchedatecnica(int cataloghiidCataloghi, int schedaTecnicaidSchedaTecnica) {
        this.cataloghiHasSchedatecnicaPK = new CataloghiHasSchedatecnicaPK(cataloghiidCataloghi, schedaTecnicaidSchedaTecnica);
    }

    public CataloghiHasSchedatecnicaPK getCataloghiHasSchedatecnicaPK() {
        return cataloghiHasSchedatecnicaPK;
    }

    public void setCataloghiHasSchedatecnicaPK(CataloghiHasSchedatecnicaPK cataloghiHasSchedatecnicaPK) {
        this.cataloghiHasSchedatecnicaPK = cataloghiHasSchedatecnicaPK;
    }

    public String getCataloghihasSchedaTecnicacol() {
        return cataloghihasSchedaTecnicacol;
    }

    public void setCataloghihasSchedaTecnicacol(String cataloghihasSchedaTecnicacol) {
        this.cataloghihasSchedaTecnicacol = cataloghihasSchedaTecnicacol;
    }

    public Schedatecnica getSchedatecnica() {
        return schedatecnica;
    }

    public void setSchedatecnica(Schedatecnica schedatecnica) {
        this.schedatecnica = schedatecnica;
    }

    public Cataloghi getCataloghi() {
        return cataloghi;
    }

    public void setCataloghi(Cataloghi cataloghi) {
        this.cataloghi = cataloghi;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (cataloghiHasSchedatecnicaPK != null ? cataloghiHasSchedatecnicaPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CataloghiHasSchedatecnica)) {
            return false;
        }
        CataloghiHasSchedatecnica other = (CataloghiHasSchedatecnica) object;
        if ((this.cataloghiHasSchedatecnicaPK == null && other.cataloghiHasSchedatecnicaPK != null) || (this.cataloghiHasSchedatecnicaPK != null && !this.cataloghiHasSchedatecnicaPK.equals(other.cataloghiHasSchedatecnicaPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "rest.CataloghiHasSchedatecnica[ cataloghiHasSchedatecnicaPK=" + cataloghiHasSchedatecnicaPK + " ]";
    }
    
}
