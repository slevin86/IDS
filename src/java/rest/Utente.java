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
import javax.persistence.Lob;
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
@Table(name = "utente")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Utente.findAll", query = "SELECT u FROM Utente u"),
    @NamedQuery(name = "Utente.findByIdUtente", query = "SELECT u FROM Utente u WHERE u.idUtente = :idUtente"),
    @NamedQuery(name = "Utente.findByNome", query = "SELECT u FROM Utente u WHERE u.nome = :nome"),
    @NamedQuery(name = "Utente.findByCognome", query = "SELECT u FROM Utente u WHERE u.cognome = :cognome"),
    @NamedQuery(name = "Utente.findByAzienda", query = "SELECT u FROM Utente u WHERE u.azienda = :azienda"),
    @NamedQuery(name = "Utente.findByCfPIva", query = "SELECT u FROM Utente u WHERE u.cfPIva = :cfPIva"),
    @NamedQuery(name = "Utente.findByVia", query = "SELECT u FROM Utente u WHERE u.via = :via"),
    @NamedQuery(name = "Utente.findByCitta", query = "SELECT u FROM Utente u WHERE u.citta = :citta"),
    @NamedQuery(name = "Utente.findByEmail", query = "SELECT u FROM Utente u WHERE u.email = :email"),
    @NamedQuery(name = "Utente.findByFax", query = "SELECT u FROM Utente u WHERE u.fax = :fax"),
    @NamedQuery(name = "Utente.findByTelefono", query = "SELECT u FROM Utente u WHERE u.telefono = :telefono"),
    @NamedQuery(name = "Utente.findByCellulare", query = "SELECT u FROM Utente u WHERE u.cellulare = :cellulare"),
    @NamedQuery(name = "Utente.findByLivelloUtente", query = "SELECT u FROM Utente u WHERE u.livelloUtente = :livelloUtente"),
    @NamedQuery(name = "Utente.findByPassword", query = "SELECT u FROM Utente u WHERE u.password = :password")})
public class Utente implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_utente")
    private Integer idUtente;
    @Size(max = 70)
    @Column(name = "nome")
    private String nome;
    @Size(max = 70)
    @Column(name = "cognome")
    private String cognome;
    @Size(max = 100)
    @Column(name = "azienda")
    private String azienda;
    @Size(max = 20)
    @Column(name = "cf_p-iva")
    private String cfPIva;
    @Size(max = 70)
    @Column(name = "via")
    private String via;
    @Size(max = 70)
    @Column(name = "citta")
    private String citta;
    // @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="Invalid email")//if the field contains email address consider using this annotation to enforce field validation
    @Size(max = 50)
    @Column(name = "email")
    private String email;
    // @Pattern(regexp="^\\(?(\\d{3})\\)?[- ]?(\\d{3})[- ]?(\\d{4})$", message="Invalid phone/fax format, should be as xxx-xxx-xxxx")//if the field contains phone or fax number consider using this annotation to enforce field validation
    @Size(max = 20)
    @Column(name = "fax")
    private String fax;
    @Size(max = 20)
    @Column(name = "telefono")
    private String telefono;
    @Size(max = 20)
    @Column(name = "cellulare")
    private String cellulare;
    @Lob
    @Size(max = 2147483647)
    @Column(name = "note")
    private String note;
    @Column(name = "livello_utente")
    private Integer livelloUtente;
    @Size(max = 30)
    @Column(name = "password")
    private String password;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "utenteidutente")
    private Collection<Ordini> ordiniCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "utenteidutente")
    private Collection<Componenteutente> componenteutenteCollection;
    @OneToMany(mappedBy = "idutenteFK")
    private Collection<Modificheschedatecnica> modificheschedatecnicaCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "utenteidutente")
    private Collection<Gestionenote> gestionenoteCollection;

    public Utente() {
    }

    public Utente(Integer idUtente) {
        this.idUtente = idUtente;
    }

    public Integer getIdUtente() {
        return idUtente;
    }

    public void setIdUtente(Integer idUtente) {
        this.idUtente = idUtente;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCognome() {
        return cognome;
    }

    public void setCognome(String cognome) {
        this.cognome = cognome;
    }

    public String getAzienda() {
        return azienda;
    }

    public void setAzienda(String azienda) {
        this.azienda = azienda;
    }

    public String getCfPIva() {
        return cfPIva;
    }

    public void setCfPIva(String cfPIva) {
        this.cfPIva = cfPIva;
    }

    public String getVia() {
        return via;
    }

    public void setVia(String via) {
        this.via = via;
    }

    public String getCitta() {
        return citta;
    }

    public void setCitta(String citta) {
        this.citta = citta;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFax() {
        return fax;
    }

    public void setFax(String fax) {
        this.fax = fax;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getCellulare() {
        return cellulare;
    }

    public void setCellulare(String cellulare) {
        this.cellulare = cellulare;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public Integer getLivelloUtente() {
        return livelloUtente;
    }

    public void setLivelloUtente(Integer livelloUtente) {
        this.livelloUtente = livelloUtente;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @XmlTransient
    public Collection<Ordini> getOrdiniCollection() {
        return ordiniCollection;
    }

    public void setOrdiniCollection(Collection<Ordini> ordiniCollection) {
        this.ordiniCollection = ordiniCollection;
    }

    @XmlTransient
    public Collection<Componenteutente> getComponenteutenteCollection() {
        return componenteutenteCollection;
    }

    public void setComponenteutenteCollection(Collection<Componenteutente> componenteutenteCollection) {
        this.componenteutenteCollection = componenteutenteCollection;
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
        hash += (idUtente != null ? idUtente.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Utente)) {
            return false;
        }
        Utente other = (Utente) object;
        if ((this.idUtente == null && other.idUtente != null) || (this.idUtente != null && !this.idUtente.equals(other.idUtente))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "rest.Utente[ idUtente=" + idUtente + " ]";
    }
    
}
