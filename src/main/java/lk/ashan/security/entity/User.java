package lk.ashan.security.entity;

import jakarta.persistence.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.sql.Date;
import java.sql.Time;
import java.util.Collection;
import java.util.Objects;

@Entity
public class User{
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private Integer id;
    @Basic
    @Column(name = "username")
    private String username;
    @Basic
    @Column(name = "password")
    private String password;
    @Basic
    @Column(name = "docreated")
    private Date docreated;
    @Basic
    @Column(name = "tocreated")
    private Time tocreated;
    @Basic
    @Column(name = "description")
    private String description;
    @Basic
    @Column(name = "enabled")
    private Boolean  enabled;
    @Basic
    @Column(name = "accountnonlocked")
    private Boolean  accountnonlocked;
    @Basic
    @Column(name = "accountnonexpired")
    private Boolean  accountnonexpired;
    @Basic
    @Column(name = "credentialsnonexpired")
    private Boolean  credentialsnonexpired;
    @Basic
    @Column(name = "failedloginattempts")
    private Byte failedloginattempts;
    @ManyToOne
    @JoinColumn(name = "userstatus_id", referencedColumnName = "id", nullable = false)
    private Userstatus userstatus;
    @OneToMany(mappedBy = "user",fetch = FetchType.EAGER)
    private Collection<Userrole> userroles;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Date getDocreated() {
        return docreated;
    }

    public void setDocreated(Date docreated) {
        this.docreated = docreated;
    }

    public Time getTocreated() {
        return tocreated;
    }

    public void setTocreated(Time tocreated) {
        this.tocreated = tocreated;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Boolean  getEnabled() {
        return enabled;
    }

    public void setEnabled(Boolean  enabled) {
        this.enabled = enabled;
    }

    public Boolean  getAccountnonlocked() {
        return accountnonlocked;
    }

    public void setAccountnonlocked(Boolean  accountnonlocked) {
        this.accountnonlocked = accountnonlocked;
    }

    public Boolean  getAccountnonexpired() {
        return accountnonexpired;
    }

    public void setAccountnonexpired(Boolean  accountnonexpired) {
        this.accountnonexpired = accountnonexpired;
    }

    public Boolean  getCredentialsnonexpired() {
        return credentialsnonexpired;
    }

    public void setCredentialsnonexpired(Boolean  credentialsnonexpired) {
        this.credentialsnonexpired = credentialsnonexpired;
    }

    public Byte getFailedloginattempts() {
        return failedloginattempts;
    }

    public void setFailedloginattempts(Byte failedloginattempts) {
        this.failedloginattempts = failedloginattempts;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof User user)) return false;
        return Objects.equals(id, user.id)
                && Objects.equals(username, user.username)
                && Objects.equals(password, user.password)
                && Objects.equals(docreated, user.docreated)
                && Objects.equals(tocreated, user.tocreated)
                && Objects.equals(description, user.description)
                && Objects.equals(enabled, user.enabled)
                && Objects.equals(accountnonlocked, user.accountnonlocked)
                && Objects.equals(accountnonexpired, user.accountnonexpired)
                && Objects.equals(credentialsnonexpired, user.credentialsnonexpired)
                && Objects.equals(failedloginattempts, user.failedloginattempts);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, username, password, docreated, tocreated, description,
                enabled, accountnonlocked, accountnonexpired, credentialsnonexpired, failedloginattempts);
    }

    public Userstatus getUserstatus() {
        return userstatus;
    }

    public void setUserstatus(Userstatus userstatus) {
        this.userstatus = userstatus;
    }

    public Collection<Userrole> getUserroles() {
        return userroles;
    }

    public void setUserroles(Collection<Userrole> userroles) {
        this.userroles = userroles;
    }
}
