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
@Table(name = "gestionetestata")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Gestionetestata.findAll", query = "SELECT g FROM Gestionetestata g"),
    @NamedQuery(name = "Gestionetestata.findByIdTestata", query = "SELECT g FROM Gestionetestata g WHERE g.idTestata = :idTestata"),
    @NamedQuery(name = "Gestionetestata.findByNomeSchedaTecnica", query = "SELECT g FROM Gestionetestata g WHERE g.nomeSchedaTecnica = :nomeSchedaTecnica"),
    @NamedQuery(name = "Gestionetestata.findByAnteprima", query = "SELECT g FROM Gestionetestata g WHERE g.anteprima = :anteprima"),
    @NamedQuery(name = "Gestionetestata.findByVariante", query = "SELECT g FROM Gestionetestata g WHERE g.variante = :variante"),
    @NamedQuery(name = "Gestionetestata.findByTaglia", query = "SELECT g FROM Gestionetestata g WHERE g.taglia = :taglia"),
    @NamedQuery(name = "Gestionetestata.findByGenere", query = "SELECT g FROM Gestionetestata g WHERE g.genere = :genere")})
public class Gestionetestata implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_testata")
    private Integer idTestata;
    @Size(max = 100)
    @Column(name = "nome_scheda_tecnica")
    private String nomeSchedaTecnica;
    @Size(max = 100)
    @Column(name = "anteprima")
    private String anteprima;
    @Size(max = 45)
    @Column(name = "variante")
    private String variante;
    @Lob
    @Size(max = 2147483647)
    @Column(name = "descrizione_modello")
    private String descrizioneModello;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "taglia")
    private Double taglia;
    @Size(max = 70)
    @Column(name = "genere")
    private String genere;
    @JoinColumn(name = "SchedaTecnica_idSchedaTecnica", referencedColumnName = "idSchedaTecnica")
    @ManyToOne(optional = false)
    private Schedatecnica schedaTecnicaidSchedaTecnica;

    public Gestionetestata() {
    }

    public Gestionetestata(Integer idTestata) {
        this.idTestata = idTestata;
    }

    public Integer getIdTestata() {
        return idTestata;
    }

    public void setIdTestata(Integer idTestata) {
        this.idTestata = idTestata;
    }

    public String getNomeSchedaTecnica() {
        return nomeSchedaTecnica;
    }

    public void setNomeSchedaTecnica(String nomeSchedaTecnica) {
        this.nomeSchedaTecnica = nomeSchedaTecnica;
    }

    public String getAnteprima() {
        return anteprima;
    }

    public void setAnteprima(String anteprima) {
        this.anteprima = anteprima;
    }

    public String getVariante() {
        return variante;
    }

    public void setVariante(String variante) {
        this.variante = variante;
    }

    public String getDescrizioneModello() {
        return descrizioneModello;
    }

    public void setDescrizioneModello(String descrizioneModello) {
        this.descrizioneModello = descrizioneModello;
    }

    public Double getTaglia() {
        return taglia;
    }

    public void setTaglia(Double taglia) {
        this.taglia = taglia;
    }

    public String getGenere() {
        return genere;
    }

    public void setGenere(String genere) {
        this.genere = genere;
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
        hash += (idTestata != null ? idTestata.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Gestionetestata)) {
            return false;
        }
        Gestionetestata other = (Gestionetestata) object;
        if ((this.idTestata == null && other.idTestata != null) || (this.idTestata != null && !this.idTestata.equals(other.idTestata))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "rest.Gestionetestata[ idTestata=" + idTestata + " ]";
    }
    
}
