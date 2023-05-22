/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.iesiliberis.crudcentroeducativo.entidades;


public class FamiliaresAutorizados {
    int idalumno;
    int idautorizado;
    String dniAlumno;
    String dniAutorizado;
    
    public FamiliaresAutorizados() {
    }

    
    public FamiliaresAutorizados(int idalumno, int idautorizado) {
        this.idalumno = idalumno;
        this.idautorizado = idautorizado;
    }

    public String getDniAlumno() {
        return dniAlumno;
    }

    public void setDniAlumno(String dniAlumno) {
        this.dniAlumno = dniAlumno;
    }

    public String getDniAutorizado() {
        return dniAutorizado;
    }

    public void setDniAutorizado(String dniAutorizado) {
        this.dniAutorizado = dniAutorizado;
    }
    
    

    public int getIdalumno() {
        return idalumno;
    }

    public void setIdalumno(int idalumno) {
        this.idalumno = idalumno;
    }

    public int getIdautorizado() {
        return idautorizado;
    }

    public void setIdautorizado(int idautorizado) {
        this.idautorizado = idautorizado;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final FamiliaresAutorizados other = (FamiliaresAutorizados) obj;
        if (this.idalumno != other.idalumno) {
            return false;
        }
        return this.idautorizado == other.idautorizado;
    }
    
    

    @Override
    public String toString() {
        return "FamiliaresAutorizados{" + "idalumno=" + idalumno + ", idautorizado=" + idautorizado + '}';
    }
    
    
}
