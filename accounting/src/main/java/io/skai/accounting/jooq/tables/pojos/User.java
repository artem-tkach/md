/*
 * This file is generated by jOOQ.
 */
package io.skai.accounting.jooq.tables.pojos;


import java.io.Serializable;


/**
 * This class is generated by jOOQ.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class User implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long id;
    private String name;
    private String email;
    private String phone;
    private String password;

    public User() {}

    public User(User value) {
        this.id = value.id;
        this.name = value.name;
        this.email = value.email;
        this.phone = value.phone;
        this.password = value.password;
    }

    public User(
        Long id,
        String name,
        String email,
        String phone,
        String password
    ) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.password = password;
    }

    /**
     * Getter for <code>mobile_accounting.user.id</code>.
     */
    public Long getId() {
        return this.id;
    }

    /**
     * Setter for <code>mobile_accounting.user.id</code>.
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Getter for <code>mobile_accounting.user.name</code>.
     */
    public String getName() {
        return this.name;
    }

    /**
     * Setter for <code>mobile_accounting.user.name</code>.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Getter for <code>mobile_accounting.user.email</code>.
     */
    public String getEmail() {
        return this.email;
    }

    /**
     * Setter for <code>mobile_accounting.user.email</code>.
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Getter for <code>mobile_accounting.user.phone</code>.
     */
    public String getPhone() {
        return this.phone;
    }

    /**
     * Setter for <code>mobile_accounting.user.phone</code>.
     */
    public void setPhone(String phone) {
        this.phone = phone;
    }

    /**
     * Getter for <code>mobile_accounting.user.password</code>.
     */
    public String getPassword() {
        return this.password;
    }

    /**
     * Setter for <code>mobile_accounting.user.password</code>.
     */
    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        final User other = (User) obj;
        if (this.id == null) {
            if (other.id != null)
                return false;
        }
        else if (!this.id.equals(other.id))
            return false;
        if (this.name == null) {
            if (other.name != null)
                return false;
        }
        else if (!this.name.equals(other.name))
            return false;
        if (this.email == null) {
            if (other.email != null)
                return false;
        }
        else if (!this.email.equals(other.email))
            return false;
        if (this.phone == null) {
            if (other.phone != null)
                return false;
        }
        else if (!this.phone.equals(other.phone))
            return false;
        if (this.password == null) {
            if (other.password != null)
                return false;
        }
        else if (!this.password.equals(other.password))
            return false;
        return true;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((this.id == null) ? 0 : this.id.hashCode());
        result = prime * result + ((this.name == null) ? 0 : this.name.hashCode());
        result = prime * result + ((this.email == null) ? 0 : this.email.hashCode());
        result = prime * result + ((this.phone == null) ? 0 : this.phone.hashCode());
        result = prime * result + ((this.password == null) ? 0 : this.password.hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("User (");

        sb.append(id);
        sb.append(", ").append(name);
        sb.append(", ").append(email);
        sb.append(", ").append(phone);
        sb.append(", ").append(password);

        sb.append(")");
        return sb.toString();
    }
}
