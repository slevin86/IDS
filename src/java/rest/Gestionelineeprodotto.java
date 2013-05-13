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
@Table(name = "gestionelineeprodotto")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Gestionelineeprodotto.findAll", query = "SELECT g FROM Gestionelineeprodotto g"),
    @NamedQuery(name = "Gestionelineeprodotto.findByIdLineaProd", query = "SELECT g FROM Gestionelineeprodotto g WHERE g.idLineaProd = :idLineaProd"),
    @NamedQuery(name = "Gestionelineeprodotto.findByNomeLinea", query = "SELECT g FROM Gestionelineeprodotto g WHERE g.nomeLinea = :nomeLinea")})
public class Gestionelineeprodotto implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idLineaProd")
    private Integer idLineaProd;
    @Size(max = 45)
    @Column(name = "nome_linea")
    private String nomeLinea;
    @ManyToMany(mappedBy = "gestionelineeprodottoCollection")
    private Collection<Schedatecnica> schedatecnicaCollection;
    @JoinColumn(name = "SchedaTecnica_idSchedaTecnica", referencedColumnName = "idSchedaTecnica")
    @ManyToOne(optional = false)
    private Schedatecnica schedaTecnicaidSchedaTecnica;

    public Gestionelineeprodotto() {
    }

    public Gestionelineeprodotto(Integer idLineaProd) {
        this.idLineaProd = idLineaProd;
    }

    public Integer getIdLineaProd() {
        return idLineaProd;
    }

    public void setIdLineaProd(Integer idLineaProd) {
        this.idLineaProd = idLineaProd;
    }

    public String getNomeLinea() {
        return nomeLinea;
    }

    public void setNomeLinea(String nomeLinea) {
        this.nomeLinea = nomeLinea;
    }

    @XmlTransient
    public Collection<Schedatecnica> getSchedatecnicaCollection() {
        return schedatecnicaCollection;
    }

    public void setSchedatecnicaCollection(Collection<Schedatecnica> schedatecnicaCollection) {
        this.schedatecnicaCollection = schedatecnicaCollection;
    }

    public Schedatecnica getSchedaTecnicaidSchedaTecnica() {
        return schedaTecnicaidSchedaTecnica;
    }

    public void setSchedaTecnicaidSchedaTecnica(Schedatecnica schedaTecnicaidSchedaTecnica) {
        this.schedaTecnicaidSchedaTecnica = schedaTecnicaidSchedaTecnica;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idLineaProd != null ? idLineaProd.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Gestionelineeprodotto)) {
            return false;
        }
        Gestionelineeprodotto other = (Gestionelineeprodotto) object;
        if ((this.idLineaProd == null && other.idLineaProd != null) || (this.idLineaProd != null && !this.idLineaProd.equals(other.idLineaProd))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "rest.Gestionelineeprodotto[ idLineaProd=" + idLineaProd + " ]";
    }
    
}
