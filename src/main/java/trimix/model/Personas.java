/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trimix.model;

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
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author LuisMedina
 */
@Entity
@Table(name = "personas")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Personas.findAll", query = "SELECT p FROM Personas p"),
    @NamedQuery(name = "Personas.findByPerId", query = "SELECT p FROM Personas p WHERE p.perId = :perId"),
    @NamedQuery(name = "Personas.findByPerNombre", query = "SELECT p FROM Personas p WHERE p.perNombre like :perNombre"),
    @NamedQuery(name = "Personas.findByPerTipoDocumento", query = "SELECT p FROM Personas p WHERE p.idTipoDocumento = :idTipoDoc"),
    @NamedQuery(name = "Personas.findByPerApellido", query = "SELECT p FROM Personas p WHERE p.perApellido = :perApellido"),
    @NamedQuery(name = "Personas.findByPerNumeroDocumento", query = "SELECT p FROM Personas p WHERE p.perNumeroDocumento = :perNumeroDocumento"),
    @NamedQuery(name = "Personas.findByPerFechaNacimiento", query = "SELECT p FROM Personas p WHERE p.perFechaNacimiento = :perFechaNacimiento")})
public class Personas implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "perId")
    private Integer perId;
    @Basic(optional = false)
    @Column(name = "perNombre")
    private String perNombre;
    @Basic(optional = false)
    @Column(name = "perApellido")
    private String perApellido;
    @Basic(optional = false)
    @Column(name = "perNumeroDocumento")
    private int perNumeroDocumento;
    @Basic(optional = false)
    @Column(name = "perFechaNacimiento")
    @Temporal(TemporalType.DATE)
    private Date perFechaNacimiento;
    @JoinColumn(name = "IdTipoDocumento", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Tipodocumento idTipoDocumento;

    public Personas() {
    }

    public Personas(Integer perId) {
        this.perId = perId;
    }

    public Personas(Integer perId, String perNombre, String perApellido, int perNumeroDocumento, Date perFechaNacimiento) {
        this.perId = perId;
        this.perNombre = perNombre;
        this.perApellido = perApellido;
        this.perNumeroDocumento = perNumeroDocumento;
        this.perFechaNacimiento = perFechaNacimiento;
    }

    public Integer getPerId() {
        return perId;
    }

    public void setPerId(Integer perId) {
        this.perId = perId;
    }

    public String getPerNombre() {
        return perNombre;
    }

    public void setPerNombre(String perNombre) {
        this.perNombre = perNombre;
    }

    public String getPerApellido() {
        return perApellido;
    }

    public void setPerApellido(String perApellido) {
        this.perApellido = perApellido;
    }

    public int getPerNumeroDocumento() {
        return perNumeroDocumento;
    }

    public void setPerNumeroDocumento(int perNumeroDocumento) {
        this.perNumeroDocumento = perNumeroDocumento;
    }

    public Date getPerFechaNacimiento() {
        return perFechaNacimiento;
    }

    public void setPerFechaNacimiento(Date perFechaNacimiento) {
        this.perFechaNacimiento = perFechaNacimiento;
    }

    public Tipodocumento getIdTipoDocumento() {
        return idTipoDocumento;
    }

    public void setIdTipoDocumento(Tipodocumento idTipoDocumento) {
        this.idTipoDocumento = idTipoDocumento;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (perId != null ? perId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Personas)) {
            return false;
        }
        Personas other = (Personas) object;
        if ((this.perId == null && other.perId != null) || (this.perId != null && !this.perId.equals(other.perId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ar.com.trimix.model.Personas[ perId=" + perId + " ]";
    }
    
}
