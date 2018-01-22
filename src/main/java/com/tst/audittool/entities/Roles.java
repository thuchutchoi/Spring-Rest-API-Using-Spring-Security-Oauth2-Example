package com.tps.device_management.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity

@Table(name = "ROLES")
public class Roles {

  public Roles() {
    super();
  }

  public Roles(Integer id, String roleName) {
    super();
    this.id = id;
    this.roleName = roleName;
  }

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "role_id", nullable = false)
  private Integer id;

  @Column(name = "ROLE_NAME", length = 15, unique = true, nullable = false)
  private String roleName;

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public String getRole() {
    return roleName;
  }

  public void setRole(String roleName) {
    this.roleName = roleName;
  }

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((id == null) ? 0 : id.hashCode());
    result = prime * result + ((roleName == null) ? 0 : roleName.hashCode());
    return result;
  }

  @Override
  public String toString() {
    return "UserProfile [id=" + id + ", role_name=" + roleName + "]";
  }

}
