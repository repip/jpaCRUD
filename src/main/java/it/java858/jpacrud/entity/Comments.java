/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.java858.jpacrud.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author tss
 */
@Entity
@Table(name = "comments")
@NamedQueries({
    @NamedQuery(name = "Comments.findAll", query = "SELECT c FROM Comments c"),
    @NamedQuery(name = "Comments.findById", query = "SELECT c FROM Comments c WHERE c.id = :id"),
    @NamedQuery(name = "Comments.findByMyuser", query = "SELECT c FROM Comments c WHERE c.myuser = :myuser"),
    @NamedQuery(name = "Comments.findByEmail", query = "SELECT c FROM Comments c WHERE c.email = :email"),
    @NamedQuery(name = "Comments.findByWebpage", query = "SELECT c FROM Comments c WHERE c.webpage = :webpage"),
    @NamedQuery(name = "Comments.findByDatum", query = "SELECT c FROM Comments c WHERE c.datum = :datum"),
    @NamedQuery(name = "Comments.findBySummary", query = "SELECT c FROM Comments c WHERE c.summary = :summary"),
    @NamedQuery(name = "Comments.findByComments", query = "SELECT c FROM Comments c WHERE c.comments = :comments")})
public class Comments implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @javax.validation.constraints.NotNull
    @javax.validation.constraints.Size(min = 1, max = 30)
    @Column(name = "MYUSER")
    private String myuser;
    // @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="Invalid email")//if the field contains email address consider using this annotation to enforce field validation
    @javax.validation.constraints.Size(max = 30)
    @Column(name = "EMAIL")
    private String email;
    @javax.validation.constraints.Size(max = 100)
    @Column(name = "WEBPAGE")
    private String webpage;
    @Column(name = "DATUM")
    @Temporal(TemporalType.DATE)
    private Date datum;
    @Basic(optional = false)
    @javax.validation.constraints.NotNull
    @javax.validation.constraints.Size(min = 1, max = 40)
    @Column(name = "SUMMARY")
    private String summary;
    @Basic(optional = false)
    @javax.validation.constraints.NotNull
    @javax.validation.constraints.Size(min = 1, max = 400)
    @Column(name = "COMMENTS")
    private String comments;

    public Comments() {
    }

    public Comments(Integer id) {
        this.id = id;
    }

    public Comments(Integer id, String myuser, String summary, String comments) {
        this.id = id;
        this.myuser = myuser;
        this.summary = summary;
        this.comments = comments;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getMyuser() {
        return myuser;
    }

    public void setMyuser(String myuser) {
        this.myuser = myuser;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getWebpage() {
        return webpage;
    }

    public void setWebpage(String webpage) {
        this.webpage = webpage;
    }

    public Date getDatum() {
        return datum;
    }

    public void setDatum(Date datum) {
        this.datum = datum;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Comments)) {
            return false;
        }
        Comments other = (Comments) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "it.java858.jpacrud.entity.Comments[ id=" + id + " ]";
    }
    
}
