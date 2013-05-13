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
@Table(name = "ordini")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Ordini.findAll", query = "SELECT o FROM Ordini o"),
    @NamedQuery(name = "Ordini.findByIdOrdini", query = "SELECT o FROM Ordini o WHERE o.idOrdini = :idOrdini"),
    @NamedQuery(name = "Ordini.findByNomeSchedaTecnica", query = "SELECT o FROM Ordini o WHERE o.nomeSchedaTecnica = :nomeSchedaTecnica"),
    @NamedQuery(name = "Ordini.findByRichiedente", query = "SELECT o FROM Ordini o WHERE o.richiedente = :richiedente"),
    @NamedQuery(name = "Ordini.findByDestinatario", query = "SELECT o FROM Ordini o WHERE o.destinatario = :destinatario"),
    @NamedQuery(name = "Ordini.findByQtaPezzi", query = "SELECT o FROM Ordini o WHERE o.qtaPezzi = :qtaPezzi"),
    @NamedQuery(name = "Ordini.findByDataOrdine", query = "SELECT o FROM Ordini o WHERE o.dataOrdine = :dataOrdine")})
public class Ordini implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idOrdini")
    private Integer idOrdini;
    @Size(max = 100)
    @Column(name = "nome_scheda_tecnica")
    private String nomeSchedaTecnica;
    @Size(max = 100)
    @Column(name = "richiedente")
    private String richiedente;
    @Size(max = 100)
    @Column(name = "destinatario")
    private String destinatario;
    @Column(name = "qta_pezzi")
    private Integer qtaPezzi;
    @Column(name = "data_ordine")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dataOrdine;
    @JoinColumn(name = "Utente_id_utente", referencedColumnName = "id_utente")
    @ManyToOne(optional = false)
    private Utente utenteidutente;
    @JoinColumn(name = "SchedaTecnica_idSchedaTecnica", referencedColumnName = "idSchedaTecnica")
    @ManyToOne(optional = false)
    private Schedatecnica schedaTecnicaidSchedaTecnica;

    public Ordini() {
    }

    public Ordini(Integer idOrdini) {
        this.idOrdini = idOrdini;
    }

    public Integer getIdOrdini() {
        return idOrdini;
    }

    public void setIdOrdini(Integer idOrdini) {
        this.idOrdini = idOrdini;
    }

    public String getNomeSchedaTecnica() {
        return nomeSchedaTecnica;
    }

    public void setNomeSchedaTecnica(String nomeSchedaTecnica) {
        this.nomeSchedaTecnica = nomeSchedaTecnica;
    }

    public String getRichiedente() {
        return richiedente;
    }

    public void setRichiedente(String richiedente) {
        this.richiedente = richiedente;
    }

    public String getDestinatario() {
        return destinatario;
    }

    public void setDestinatario(String destinatario) {
        this.destinatario = destinatario;
    }

    public Integer getQtaPezzi() {
        return qtaPezzi;
    }

    public void setQtaPezzi(Integer qtaPezzi) {
        this.qtaPezzi = qtaPezzi;
    }

    public Date getDataOrdine() {
        return dataOrdine;
    }

    public void setDataOrdine(Date dataOrdine) {
        this.dataOrdine = dataOrdine;
    }

    public Utente getUtenteidutente() {
        return utenteidutente;
    }

    public void setUtenteidutente(Utente utenteidutente) {
        this.utenteidutente = utenteidutente;
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
        hash += (idOrdini != null ? idOrdini.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Ordini)) {
            return false;
        }
        Ordini other = (Ordini) object;
        if ((this.idOrdini == null && other.idOrdini != null) || (this.idOrdini != null && !this.idOrdini.equals(other.idOrdini))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "rest.Ordini[ idOrdini=" + idOrdini + " ]";
    }
    
}
