/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.Size;

/**
 *
 * @author Duvan
 */
@Entity
@Table(name = "ultrabook")
@NamedQueries({
    @NamedQuery(name = "Ultrabook.findAll", query = "SELECT u FROM Ultrabook u"),
    @NamedQuery(name = "Ultrabook.findByIndice", query = "SELECT u FROM Ultrabook u WHERE u.indice = :indice")})
public class Ultrabook implements Serializable {

    private static final long serialVersionUID = 1L;
    @Lob
    @Size(max = 65535)
    @Column(name = "Product")
    private String product;
    @Lob
    @Size(max = 65535)
    @Column(name = "Weight")
    private String weight;
    @Lob
    @Size(max = 65535)
    @Column(name = "Inches")
    private String inches;
    @Lob
    @Size(max = 65535)
    @Column(name = "OpSys")
    private String opSys;
    @Lob
    @Size(max = 65535)
    @Column(name = "Company")
    private String company;
    @Lob
    @Size(max = 65535)
    @Column(name = "Ram")
    private String ram;
    @Lob
    @Size(max = 65535)
    @Column(name = "Memory")
    private String memory;
    @Lob
    @Size(max = 65535)
    @Column(name = "Gpu")
    private String gpu;
    @Lob
    @Size(max = 65535)
    @Column(name = "ScreenResolution")
    private String screenResolution;
    @Lob
    @Size(max = 65535)
    @Column(name = "Cpu")
    private String cpu;
    @Lob
    @Size(max = 65535)
    @Column(name = "Price_euros")
    private String priceeuros;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "Indice")
    private Integer indice;

    public Ultrabook() {
    }

    public Ultrabook(Integer indice) {
        this.indice = indice;
    }

    public String getProduct() {
        return product;
    }

    public void setProduct(String product) {
        this.product = product;
    }

    public String getWeight() {
        return weight;
    }

    public void setWeight(String weight) {
        this.weight = weight;
    }

    public String getInches() {
        return inches;
    }

    public void setInches(String inches) {
        this.inches = inches;
    }

    public String getOpSys() {
        return opSys;
    }

    public void setOpSys(String opSys) {
        this.opSys = opSys;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getRam() {
        return ram;
    }

    public void setRam(String ram) {
        this.ram = ram;
    }

    public String getMemory() {
        return memory;
    }

    public void setMemory(String memory) {
        this.memory = memory;
    }

    public String getGpu() {
        return gpu;
    }

    public void setGpu(String gpu) {
        this.gpu = gpu;
    }

    public String getScreenResolution() {
        return screenResolution;
    }

    public void setScreenResolution(String screenResolution) {
        this.screenResolution = screenResolution;
    }

    public String getCpu() {
        return cpu;
    }

    public void setCpu(String cpu) {
        this.cpu = cpu;
    }

    public String getPriceeuros() {
        return priceeuros;
    }

    public void setPriceeuros(String priceeuros) {
        this.priceeuros = priceeuros;
    }

    public Integer getIndice() {
        return indice;
    }

    public void setIndice(Integer indice) {
        this.indice = indice;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (indice != null ? indice.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Ultrabook)) {
            return false;
        }
        Ultrabook other = (Ultrabook) object;
        if ((this.indice == null && other.indice != null) || (this.indice != null && !this.indice.equals(other.indice))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.Ultrabook[ indice=" + indice + " ]";
    }
    
}
