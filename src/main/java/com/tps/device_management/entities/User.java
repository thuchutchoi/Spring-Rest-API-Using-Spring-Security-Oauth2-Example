package com.tps.device_management.entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "users")
public class User {

  public User() {
    super();
  }

  public User(Integer id, String username, String password, String firstName, String lastName, String firstName1,
      String lastName1, boolean isDeleted, Date createdAt, Date updatedAt, int createdBy, int updatedBy) {
    super();
    this.id = id;
    this.username = username;
    this.password = password;
    this.firstName = firstName;
    this.lastName = lastName;
    this.firstName1 = firstName1;
    this.lastName1 = lastName1;
    this.isDeleted = isDeleted;
    this.createdAt = createdAt;
    this.updatedAt = updatedAt;
    this.createdBy = createdBy;
    this.updatedBy = updatedBy;
  }

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "user_id", nullable = false)
  private Integer id;

  @Column(name = "username", unique = true, nullable = false)
  private String username;

  @Column(name = "password", nullable = false)
  private String password;

  @Column(name = "firstname_kanji", nullable = false)
  private String firstName;

  @Column(name = "lastname_kanji", nullable = false)
  private String lastName;

  @Column(name = "firstname_katakana", nullable = false)
  private String firstName1;

  @Column(name = "lastname_katakana", nullable = false)
  private String lastName1;

  @Column(name = "is_deleted", nullable = false)
  private boolean isDeleted;

  @ManyToOne(fetch = FetchType.EAGER)
  @JoinColumn(name = "role_id", nullable = false)
  private Roles role;

  @Column(name = "created_at", nullable = false)
  private Date createdAt;

  @Column(name = "updated_at", nullable = false)
  private Date updatedAt;

  @Column(name = "created_by", nullable = false)
  private Integer createdBy;

  @Column(name = "updated_by", nullable = false)
  private Integer updatedBy;

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public String getUsername() {
    return username;
  }

  public void setUsername(String username) {
    this.username = username;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public String getFirstName() {
    return firstName;
  }

  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  public String getLastName() {
    return lastName;
  }

  public void setLastName(String lastName) {
    this.lastName = lastName;
  }

  public String getFirstName1() {
    return firstName1;
  }

  public void setFirstName1(String firstName1) {
    this.firstName1 = firstName1;
  }

  public String getLastName1() {
    return lastName1;
  }

  public void setLastName1(String lastName1) {
    this.lastName1 = lastName1;
  }

  public boolean isDeleted() {
    return isDeleted;
  }

  public void setDeleted(boolean isDeleted) {
    this.isDeleted = isDeleted;
  }

  public Roles getRole() {
    return role;
  }

  public void setRole(Roles role) {
    this.role = role;
  }

  public Date getCreatedAt() {
    return createdAt;
  }

  public void setCreatedAt(Date createdAt) {
    this.createdAt = createdAt;
  }

  public Date getUpdatedAt() {
    return updatedAt;
  }

  public void setUpdatedAt(Date updatedAt) {
    this.updatedAt = updatedAt;
  }

  public int getCreatedBy() {
    return createdBy;
  }

  public void setCreatedBy(int createdBy) {
    this.createdBy = createdBy;
  }

  public int getUpdatedBy() {
    return updatedBy;
  }

  public void setUpdatedBy(int updatedBy) {
    this.updatedBy = updatedBy;
  }

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((id == null) ? 0 : id.hashCode());
    result = prime * result + ((username == null) ? 0 : username.hashCode());
    return result;
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj) {
      return true;
    }
    if (obj == null) {
      return false;
    }
    if (!(obj instanceof User)) {
      return false;
    }
    User other = (User) obj;
    if (id == null) {
      if (other.id != null) {
        return false;
      }
    } else if (!id.equals(other.id)) {
      return false;
    }
    if (username == null) {
      if (other.username != null) {
        return false;
      }
    } else if (!username.equals(other.username)) {
      return false;
    }
    return true;
  }

  @Override
  public String toString() {
    return "User [id=" + id + ", username=" + username + ", password=" + password + ", firstName=" + firstName
        + ", lastName=" + lastName + ", firstName1=" + firstName1 + ", lastName1=" + lastName1 + ", isDeleted="
        + isDeleted + ", createdAt=" + createdAt + ", updatedAt=" + updatedAt + ", createdBy=" + createdBy
        + ", updatedBy=" + updatedBy + "]";
  }
}
