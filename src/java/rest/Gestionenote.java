/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package rest;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
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
@Table(name = "gestionenote")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Gestionenote.findAll", query = "SELECT g FROM Gestionenote g"),
    @NamedQuery(name = "Gestionenote.findByIdGestioneNote", query = "SELECT g FROM Gestionenote g WHERE g.idGestioneNote = :idGestioneNote")})
public class Gestionenote implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idGestioneNote")
    private Integer idGestioneNote;
    @Lob
    @Size(max = 2147483647)
    @Column(name = "note")
    private String note;
    @JoinColumn(name = "Utente_id_utente", referencedColumnName = "id_utente")
    @ManyToOne(optional = false)
    private Utente utenteidutente;
    @JoinColumn(name = "SchedaTecnica_idSchedaTecnica", referencedColumnName = "idSchedaTecnica")
    @ManyToOne(optional = false)
    private Schedatecnica schedaTecnicaidSchedaTecnica;

    public Gestionenote() {
    }

    public Gestionenote(Integer idGestioneNote) {
        this.idGestioneNote = idGestioneNote;
    }

    public Integer getIdGestioneNote() {
        return idGestioneNote;
    }

    public void setIdGestioneNote(Integer idGestioneNote) {
        this.idGestioneNote = idGestioneNote;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
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
        hash += (idGestioneNote != null ? idGestioneNote.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Gestionenote)) {
            return false;
        }
        Gestionenote other = (Gestionenote) object;
        if ((this.idGestioneNote == null && other.idGestioneNote != null) || (this.idGestioneNote != null && !this.idGestioneNote.equals(other.idGestioneNote))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "rest.Gestionenote[ idGestioneNote=" + idGestioneNote + " ]";
    }
    
}
