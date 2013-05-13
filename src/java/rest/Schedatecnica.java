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
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
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
@Table(name = "schedatecnica")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Schedatecnica.findAll", query = "SELECT s FROM Schedatecnica s"),
    @NamedQuery(name = "Schedatecnica.findByIdSchedaTecnica", query = "SELECT s FROM Schedatecnica s WHERE s.idSchedaTecnica = :idSchedaTecnica"),
    @NamedQuery(name = "Schedatecnica.findByFotoModello", query = "SELECT s FROM Schedatecnica s WHERE s.fotoModello = :fotoModello"),
    @NamedQuery(name = "Schedatecnica.findByStato", query = "SELECT s FROM Schedatecnica s WHERE s.stato = :stato"),
    @NamedQuery(name = "Schedatecnica.findByFotoCampione", query = "SELECT s FROM Schedatecnica s WHERE s.fotoCampione = :fotoCampione"),
    @NamedQuery(name = "Schedatecnica.findByGenere", query = "SELECT s FROM Schedatecnica s WHERE s.genere = :genere"),
    @NamedQuery(name = "Schedatecnica.findByPrezzo", query = "SELECT s FROM Schedatecnica s WHERE s.prezzo = :prezzo"),
    @NamedQuery(name = "Schedatecnica.findByFinalizzata", query = "SELECT s FROM Schedatecnica s WHERE s.finalizzata = :finalizzata")})
public class Schedatecnica implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idSchedaTecnica")
    private Integer idSchedaTecnica;
    @Size(max = 100)
    @Column(name = "foto_modello")
    private String fotoModello;
    @Size(max = 100)
    @Column(name = "stato")
    private String stato;
    @Size(max = 100)
    @Column(name = "foto_campione")
    private String fotoCampione;
    @Size(max = 50)
    @Column(name = "genere")
    private String genere;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "prezzo")
    private Double prezzo;
    @Column(name = "finalizzata")
    private Boolean finalizzata;
    @ManyToMany(mappedBy = "schedatecnicaCollection")
    private Collection<Componenteutente> componenteutenteCollection;
    @JoinTable(name = "schedatecnica_has_componenteprimario", joinColumns = {
        @JoinColumn(name = "SchedaTecnica_idSchedaTecnica", referencedColumnName = "idSchedaTecnica")}, inverseJoinColumns = {
        @JoinColumn(name = "ComponentePrimario_idComponentePrimario", referencedColumnName = "idComponentePrimario")})
    @ManyToMany
    private Collection<Componenteprimario> componenteprimarioCollection;
    @JoinTable(name = "schedatecnica_has_componentesemilavorato", joinColumns = {
        @JoinColumn(name = "SchedaTecnica_idSchedaTecnica", referencedColumnName = "idSchedaTecnica")}, inverseJoinColumns = {
        @JoinColumn(name = "ComponenteSemilavorato_idComponenteSemilavorato", referencedColumnName = "idComponenteSemilavorato")})
    @ManyToMany
    private Collection<Componentesemilavorato> componentesemilavoratoCollection;
    @JoinTable(name = "schedatecnica_has_gestionelineeprodotto", joinColumns = {
        @JoinColumn(name = "SchedaTecnica_idSchedaTecnica", referencedColumnName = "idSchedaTecnica")}, inverseJoinColumns = {
        @JoinColumn(name = "GestioneLineeProdotto_idLineaProd", referencedColumnName = "idLineaProd")})
    @ManyToMany
    private Collection<Gestionelineeprodotto> gestionelineeprodottoCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "schedaTecnicaidSchedaTecnica")
    private Collection<Ordini> ordiniCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "schedaTecnicaidSchedaTecnica")
    private Collection<Gestionelineeprodotto> gestionelineeprodottoCollection1;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "schedaTecnicaidSchedaTecnica")
    private Collection<Gestionetestata> gestionetestataCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "schedatecnica")
    private Collection<CataloghiHasSchedatecnica> cataloghiHasSchedatecnicaCollection;
    @OneToMany(mappedBy = "idSchedaTecnicaFK")
    private Collection<Modificheschedatecnica> modificheschedatecnicaCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "schedaTecnicaidSchedaTecnica")
    private Collection<Gestionenote> gestionenoteCollection;

    public Schedatecnica() {
    }

    public Schedatecnica(Integer idSchedaTecnica) {
        this.idSchedaTecnica = idSchedaTecnica;
    }

    public Integer getIdSchedaTecnica() {
        return idSchedaTecnica;
    }

    public void setIdSchedaTecnica(Integer idSchedaTecnica) {
        this.idSchedaTecnica = idSchedaTecnica;
    }

    public String getFotoModello() {
        return fotoModello;
    }

    public void setFotoModello(String fotoModello) {
        this.fotoModello = fotoModello;
    }

    public String getStato() {
        return stato;
    }

    public void setStato(String stato) {
        this.stato = stato;
    }

    public String getFotoCampione() {
        return fotoCampione;
    }

    public void setFotoCampione(String fotoCampione) {
        this.fotoCampione = fotoCampione;
    }

    public String getGenere() {
        return genere;
    }

    public void setGenere(String genere) {
        this.genere = genere;
    }

    public Double getPrezzo() {
        return prezzo;
    }

    public void setPrezzo(Double prezzo) {
        this.prezzo = prezzo;
    }

    public Boolean getFinalizzata() {
        return finalizzata;
    }

    public void setFinalizzata(Boolean finalizzata) {
        this.finalizzata = finalizzata;
    }

    @XmlTransient
    public Collection<Componenteutente> getComponenteutenteCollection() {
        return componenteutenteCollection;
    }

    public void setComponenteutenteCollection(Collection<Componenteutente> componenteutenteCollection) {
        this.componenteutenteCollection = componenteutenteCollection;
    }

    @XmlTransient
    public Collection<Componenteprimario> getComponenteprimarioCollection() {
        return componenteprimarioCollection;
    }

    public void setComponenteprimarioCollection(Collection<Componenteprimario> componenteprimarioCollection) {
        this.componenteprimarioCollection = componenteprimarioCollection;
    }

    @XmlTransient
    public Collection<Componentesemilavorato> getComponentesemilavoratoCollection() {
        return componentesemilavoratoCollection;
    }

    public void setComponentesemilavoratoCollection(Collection<Componentesemilavorato> componentesemilavoratoCollection) {
        this.componentesemilavoratoCollection = componentesemilavoratoCollection;
    }

    @XmlTransient
    public Collection<Gestionelineeprodotto> getGestionelineeprodottoCollection() {
        return gestionelineeprodottoCollection;
    }

    public void setGestionelineeprodottoCollection(Collection<Gestionelineeprodotto> gestionelineeprodottoCollection) {
        this.gestionelineeprodottoCollection = gestionelineeprodottoCollection;
    }

    @XmlTransient
    public Collection<Ordini> getOrdiniCollection() {
        return ordiniCollection;
    }

    public void setOrdiniCollection(Collection<Ordini> ordiniCollection) {
        this.ordiniCollection = ordiniCollection;
    }

    @XmlTransient
    public Collection<Gestionelineeprodotto> getGestionelineeprodottoCollection1() {
        return gestionelineeprodottoCollection1;
    }

    public void setGestionelineeprodottoCollection1(Collection<Gestionelineeprodotto> gestionelineeprodottoCollection1) {
        this.gestionelineeprodottoCollection1 = gestionelineeprodottoCollection1;
    }

    @XmlTransient
    public Collection<Gestionetestata> getGestionetestataCollection() {
        return gestionetestataCollection;
    }

    public void setGestionetestataCollection(Collection<Gestionetestata> gestionetestataCollection) {
        this.gestionetestataCollection = gestionetestataCollection;
    }

    @XmlTransient
    public Collection<CataloghiHasSchedatecnica> getCataloghiHasSchedatecnicaCollection() {
        return cataloghiHasSchedatecnicaCollection;
    }

    public void setCataloghiHasSchedatecnicaCollection(Collection<CataloghiHasSchedatecnica> cataloghiHasSchedatecnicaCollection) {
        this.cataloghiHasSchedatecnicaCollection = cataloghiHasSchedatecnicaCollection;
    }

    @XmlTransient
    public Collection<Modificheschedatecnica> getModificheschedatecnicaCollection() {
        return modificheschedatecnicaCollection;
    }

    public void setModificheschedatecnicaCollection(Collection<Modificheschedatecnica> modificheschedatecnicaCollection) {
        this.modificheschedatecnicaCollection = modificheschedatecnicaCollection;
    }

    @XmlTransient
    public Collection<Gestionenote> getGestionenoteCollection() {
        return gestionenoteCollection;
    }

    public void setGestionenoteCollection(Collection<Gestionenote> gestionenoteCollection) {
        this.gestionenoteCollection = gestionenoteCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idSchedaTecnica != null ? idSchedaTecnica.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Schedatecnica)) {
            return false;
        }
        Schedatecnica other = (Schedatecnica) object;
        if ((this.idSchedaTecnica == null && other.idSchedaTecnica != null) || (this.idSchedaTecnica != null && !this.idSchedaTecnica.equals(other.idSchedaTecnica))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "rest.Schedatecnica[ idSchedaTecnica=" + idSchedaTecnica + " ]";
    }
    
}
