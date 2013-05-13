/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package rest;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;

/**
 *
 * @author Davide
 */
@Embeddable
public class CataloghiHasSchedatecnicaPK implements Serializable {
    @Basic(optional = false)
    @NotNull
    @Column(name = "Cataloghi_idCataloghi")
    private int cataloghiidCataloghi;
    @Basic(optional = false)
    @NotNull
    @Column(name = "SchedaTecnica_idSchedaTecnica")
    private int schedaTecnicaidSchedaTecnica;

    public CataloghiHasSchedatecnicaPK() {
    }

    public CataloghiHasSchedatecnicaPK(int cataloghiidCataloghi, int schedaTecnicaidSchedaTecnica) {
        this.cataloghiidCataloghi = cataloghiidCataloghi;
        this.schedaTecnicaidSchedaTecnica = schedaTecnicaidSchedaTecnica;
    }

    public int getCataloghiidCataloghi() {
        return cataloghiidCataloghi;
    }

    public void setCataloghiidCataloghi(int cataloghiidCataloghi) {
        this.cataloghiidCataloghi = cataloghiidCataloghi;
    }

    public int getSchedaTecnicaidSchedaTecnica() {
        return schedaTecnicaidSchedaTecnica;
    }

    public void setSchedaTecnicaidSchedaTecnica(int schedaTecnicaidSchedaTecnica) {
        this.schedaTecnicaidSchedaTecnica = schedaTecnicaidSchedaTecnica;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) cataloghiidCataloghi;
        hash += (int) schedaTecnicaidSchedaTecnica;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CataloghiHasSchedatecnicaPK)) {
            return false;
        }
        CataloghiHasSchedatecnicaPK other = (CataloghiHasSchedatecnicaPK) object;
        if (this.cataloghiidCataloghi != other.cataloghiidCataloghi) {
            return false;
        }
        if (this.schedaTecnicaidSchedaTecnica != other.schedaTecnicaidSchedaTecnica) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "rest.CataloghiHasSchedatecnicaPK[ cataloghiidCataloghi=" + cataloghiidCataloghi + ", schedaTecnicaidSchedaTecnica=" + schedaTecnicaidSchedaTecnica + " ]";
    }
    
}
