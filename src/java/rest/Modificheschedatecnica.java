/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package rest;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Davide
 */
@Entity
@Table(name = "modificheschedatecnica")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Modificheschedatecnica.findAll", query = "SELECT m FROM Modificheschedatecnica m"),
    @NamedQuery(name = "Modificheschedatecnica.findByIdModificheSchedaTecnica", query = "SELECT m FROM Modificheschedatecnica m WHERE m.idModificheSchedaTecnica = :idModificheSchedaTecnica"),
    @NamedQuery(name = "Modificheschedatecnica.findByData", query = "SELECT m FROM Modificheschedatecnica m WHERE m.data = :data"),
    @NamedQuery(name = "Modificheschedatecnica.findByTipoOperazione", query = "SELECT m FROM Modificheschedatecnica m WHERE m.tipoOperazione = :tipoOperazione")})
public class Modificheschedatecnica implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idModificheSchedaTecnica")
    private Integer idModificheSchedaTecnica;
    @Column(name = "data")
    @Temporal(TemporalType.TIMESTAMP)
    private Date data;
    @Size(max = 45)
    @Column(name = "tipo_operazione")
    private String tipoOperazione;
    @JoinColumn(name = "id_utente_FK", referencedColumnName = "id_utente")
    @ManyToOne
    private Utente idutenteFK;
    @JoinColumn(name = "idSchedaTecnica_FK", referencedColumnName = "idSchedaTecnica")
    @ManyToOne
    private Schedatecnica idSchedaTecnicaFK;

    public Modificheschedatecnica() {
    }

    public Modificheschedatecnica(Integer idModificheSchedaTecnica) {
        this.idModificheSchedaTecnica = idModificheSchedaTecnica;
    }

    public Integer getIdModificheSchedaTecnica() {
        return idModificheSchedaTecnica;
    }

    public void setIdModificheSchedaTecnica(Integer idModificheSchedaTecnica) {
        this.idModificheSchedaTecnica = idModificheSchedaTecnica;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public String getTipoOperazione() {
        return tipoOperazione;
    }

    public void setTipoOperazione(String tipoOperazione) {
        this.tipoOperazione = tipoOperazione;
    }

    public Utente getIdutenteFK() {
        return idutenteFK;
    }

    public void setIdutenteFK(Utente idutenteFK) {
        this.idutenteFK = idutenteFK;
    }

    public Schedatecnica getIdSchedaTecnicaFK() {
        return idSchedaTecnicaFK;
    }

    public void setIdSchedaTecnicaFK(Schedatecnica idSchedaTecnicaFK) {
        this.idSchedaTecnicaFK = idSchedaTecnicaFK;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idModificheSchedaTecnica != null ? idModificheSchedaTecnica.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Modificheschedatecnica)) {
            return false;
        }
        Modificheschedatecnica other = (Modificheschedatecnica) object;
        if ((this.idModificheSchedaTecnica == null && other.idModificheSchedaTecnica != null) || (this.idModificheSchedaTecnica != null && !this.idModificheSchedaTecnica.equals(other.idModificheSchedaTecnica))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "rest.Modificheschedatecnica[ idModificheSchedaTecnica=" + idModificheSchedaTecnica + " ]";
    }
    
}
