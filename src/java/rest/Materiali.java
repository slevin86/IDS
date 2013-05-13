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
import javax.persistence.ManyToOne;
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
@Table(name = "materiali")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Materiali.findAll", query = "SELECT m FROM Materiali m"),
    @NamedQuery(name = "Materiali.findByIdMateriali", query = "SELECT m FROM Materiali m WHERE m.idMateriali = :idMateriali"),
    @NamedQuery(name = "Materiali.findByNome", query = "SELECT m FROM Materiali m WHERE m.nome = :nome"),
    @NamedQuery(name = "Materiali.findByTipoMateriale", query = "SELECT m FROM Materiali m WHERE m.tipoMateriale = :tipoMateriale"),
    @NamedQuery(name = "Materiali.findByColoreMateriale", query = "SELECT m FROM Materiali m WHERE m.coloreMateriale = :coloreMateriale"),
    @NamedQuery(name = "Materiali.findByCostoMateriale", query = "SELECT m FROM Materiali m WHERE m.costoMateriale = :costoMateriale"),
    @NamedQuery(name = "Materiali.findByQtaMateriale", query = "SELECT m FROM Materiali m WHERE m.qtaMateriale = :qtaMateriale")})
public class Materiali implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idMateriali")
    private Integer idMateriali;
    @Size(max = 70)
    @Column(name = "nome")
    private String nome;
    @Size(max = 70)
    @Column(name = "tipo_materiale")
    private String tipoMateriale;
    @Size(max = 70)
    @Column(name = "colore_materiale")
    private String coloreMateriale;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "costo_materiale")
    private Double costoMateriale;
    @Column(name = "qta_materiale")
    private Double qtaMateriale;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "materialiidMateriali")
    private Collection<Componenteutente> componenteutenteCollection;
    @OneToMany(mappedBy = "idMaterialeFK")
    private Collection<Componenteprimario> componenteprimarioCollection;
    @JoinColumn(name = "Unita_Misura_idUnitaMisura", referencedColumnName = "idUnitaMisura")
    @ManyToOne(optional = false)
    private UnitaMisura unitaMisuraidUnitaMisura;

    public Materiali() {
    }

    public Materiali(Integer idMateriali) {
        this.idMateriali = idMateriali;
    }

    public Integer getIdMateriali() {
        return idMateriali;
    }

    public void setIdMateriali(Integer idMateriali) {
        this.idMateriali = idMateriali;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTipoMateriale() {
        return tipoMateriale;
    }

    public void setTipoMateriale(String tipoMateriale) {
        this.tipoMateriale = tipoMateriale;
    }

    public String getColoreMateriale() {
        return coloreMateriale;
    }

    public void setColoreMateriale(String coloreMateriale) {
        this.coloreMateriale = coloreMateriale;
    }

    public Double getCostoMateriale() {
        return costoMateriale;
    }

    public void setCostoMateriale(Double costoMateriale) {
        this.costoMateriale = costoMateriale;
    }

    public Double getQtaMateriale() {
        return qtaMateriale;
    }

    public void setQtaMateriale(Double qtaMateriale) {
        this.qtaMateriale = qtaMateriale;
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

    public UnitaMisura getUnitaMisuraidUnitaMisura() {
        return unitaMisuraidUnitaMisura;
    }

    public void setUnitaMisuraidUnitaMisura(UnitaMisura unitaMisuraidUnitaMisura) {
        this.unitaMisuraidUnitaMisura = unitaMisuraidUnitaMisura;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idMateriali != null ? idMateriali.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Materiali)) {
            return false;
        }
        Materiali other = (Materiali) object;
        if ((this.idMateriali == null && other.idMateriali != null) || (this.idMateriali != null && !this.idMateriali.equals(other.idMateriali))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "rest.Materiali[ idMateriali=" + idMateriali + " ]";
    }
    
}
