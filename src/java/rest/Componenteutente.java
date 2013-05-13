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
import javax.persistence.JoinTable;
import javax.persistence.Lob;
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
@Table(name = "componenteutente")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Componenteutente.findAll", query = "SELECT c FROM Componenteutente c"),
    @NamedQuery(name = "Componenteutente.findByIdComponenteUtente", query = "SELECT c FROM Componenteutente c WHERE c.idComponenteUtente = :idComponenteUtente"),
    @NamedQuery(name = "Componenteutente.findByNomeComponente", query = "SELECT c FROM Componenteutente c WHERE c.nomeComponente = :nomeComponente"),
    @NamedQuery(name = "Componenteutente.findByIsApprovato", query = "SELECT c FROM Componenteutente c WHERE c.isApprovato = :isApprovato"),
    @NamedQuery(name = "Componenteutente.findByColore", query = "SELECT c FROM Componenteutente c WHERE c.colore = :colore"),
    @NamedQuery(name = "Componenteutente.findByMateriale", query = "SELECT c FROM Componenteutente c WHERE c.materiale = :materiale")})
public class Componenteutente implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idComponenteUtente")
    private Integer idComponenteUtente;
    @Size(max = 100)
    @Column(name = "nome_componente")
    private String nomeComponente;
    @Column(name = "isApprovato")
    private Character isApprovato;
    @Lob
    @Size(max = 2147483647)
    @Column(name = "descrizione")
    private String descrizione;
    @Size(max = 100)
    @Column(name = "colore")
    private String colore;
    @Size(max = 100)
    @Column(name = "materiale")
    private String materiale;
    @JoinTable(name = "componenteutente_has_schedatecnica", joinColumns = {
        @JoinColumn(name = "ComponenteUtente_idComponenteUtente", referencedColumnName = "idComponenteUtente")}, inverseJoinColumns = {
        @JoinColumn(name = "SchedaTecnica_idSchedaTecnica", referencedColumnName = "idSchedaTecnica")})
    @ManyToMany
    private Collection<Schedatecnica> schedatecnicaCollection;
    @JoinColumn(name = "Utente_id_utente", referencedColumnName = "id_utente")
    @ManyToOne(optional = false)
    private Utente utenteidutente;
    @JoinColumn(name = "Materiali_idMateriali", referencedColumnName = "idMateriali")
    @ManyToOne(optional = false)
    private Materiali materialiidMateriali;

    public Componenteutente() {
    }

    public Componenteutente(Integer idComponenteUtente) {
        this.idComponenteUtente = idComponenteUtente;
    }

    public Integer getIdComponenteUtente() {
        return idComponenteUtente;
    }

    public void setIdComponenteUtente(Integer idComponenteUtente) {
        this.idComponenteUtente = idComponenteUtente;
    }

    public String getNomeComponente() {
        return nomeComponente;
    }

    public void setNomeComponente(String nomeComponente) {
        this.nomeComponente = nomeComponente;
    }

    public Character getIsApprovato() {
        return isApprovato;
    }

    public void setIsApprovato(Character isApprovato) {
        this.isApprovato = isApprovato;
    }

    public String getDescrizione() {
        return descrizione;
    }

    public void setDescrizione(String descrizione) {
        this.descrizione = descrizione;
    }

    public String getColore() {
        return colore;
    }

    public void setColore(String colore) {
        this.colore = colore;
    }

    public String getMateriale() {
        return materiale;
    }

    public void setMateriale(String materiale) {
        this.materiale = materiale;
    }

    @XmlTransient
    public Collection<Schedatecnica> getSchedatecnicaCollection() {
        return schedatecnicaCollection;
    }

    public void setSchedatecnicaCollection(Collection<Schedatecnica> schedatecnicaCollection) {
        this.schedatecnicaCollection = schedatecnicaCollection;
    }

    public Utente getUtenteidutente() {
        return utenteidutente;
    }

    public void setUtenteidutente(Utente utenteidutente) {
        this.utenteidutente = utenteidutente;
    }

    public Materiali getMaterialiidMateriali() {
        return materialiidMateriali;
    }

    public void setMaterialiidMateriali(Materiali materialiidMateriali) {
        this.materialiidMateriali = materialiidMateriali;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idComponenteUtente != null ? idComponenteUtente.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Componenteutente)) {
            return false;
        }
        Componenteutente other = (Componenteutente) object;
        if ((this.idComponenteUtente == null && other.idComponenteUtente != null) || (this.idComponenteUtente != null && !this.idComponenteUtente.equals(other.idComponenteUtente))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "rest.Componenteutente[ idComponenteUtente=" + idComponenteUtente + " ]";
    }
    
}
