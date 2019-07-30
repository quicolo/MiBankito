/*
 * This source file was generated by FireStorm/DAO.
 * 
 * If you purchase a full license for FireStorm/DAO you can customize this header file.
 * 
 * For more information please visit http://www.codefutures.com/products/firestorm
 */

package com.bankito.persistencia.dto;

import com.bankito.persistencia.dao.*;
import com.bankito.persistencia.factory.*;
import com.bankito.persistencia.exceptions.*;
import java.io.Serializable;
import java.util.*;

public class PerfilUsuarioEntidad implements Serializable
{
	/** 
	 * This attribute maps to the column id_perfil_usuario in the perfil_usuario table.
	 */
	protected int idPerfilUsuario;

	/** 
	 * This attribute represents whether the attribute idPerfilUsuario has been modified since being read from the database.
	 */
	protected boolean idPerfilUsuarioModified = false;

	/** 
	 * This attribute maps to the column nombre in the perfil_usuario table.
	 */
	protected String nombre;

	/** 
	 * This attribute represents whether the attribute nombre has been modified since being read from the database.
	 */
	protected boolean nombreModified = false;

	/** 
	 * This attribute maps to the column descripcion in the perfil_usuario table.
	 */
	protected String descripcion;

	/** 
	 * This attribute represents whether the attribute descripcion has been modified since being read from the database.
	 */
	protected boolean descripcionModified = false;

	/**
	 * Method 'PerfilUsuarioEntidad'
	 * 
	 */
	public PerfilUsuarioEntidad()
	{
	}

	/**
	 * Method 'getIdPerfilUsuario'
	 * 
	 * @return int
	 */
	public int getIdPerfilUsuario()
	{
		return idPerfilUsuario;
	}

	/**
	 * Method 'setIdPerfilUsuario'
	 * 
	 * @param idPerfilUsuario
	 */
	public void setIdPerfilUsuario(int idPerfilUsuario)
	{
		this.idPerfilUsuario = idPerfilUsuario;
		this.idPerfilUsuarioModified = true;
	}

	/** 
	 * Sets the value of idPerfilUsuarioModified
	 */
	public void setIdPerfilUsuarioModified(boolean idPerfilUsuarioModified)
	{
		this.idPerfilUsuarioModified = idPerfilUsuarioModified;
	}

	/** 
	 * Gets the value of idPerfilUsuarioModified
	 */
	public boolean isIdPerfilUsuarioModified()
	{
		return idPerfilUsuarioModified;
	}

	/**
	 * Method 'getNombre'
	 * 
	 * @return String
	 */
	public String getNombre()
	{
		return nombre;
	}

	/**
	 * Method 'setNombre'
	 * 
	 * @param nombre
	 */
	public void setNombre(String nombre)
	{
		this.nombre = nombre;
		this.nombreModified = true;
	}

	/** 
	 * Sets the value of nombreModified
	 */
	public void setNombreModified(boolean nombreModified)
	{
		this.nombreModified = nombreModified;
	}

	/** 
	 * Gets the value of nombreModified
	 */
	public boolean isNombreModified()
	{
		return nombreModified;
	}

	/**
	 * Method 'getDescripcion'
	 * 
	 * @return String
	 */
	public String getDescripcion()
	{
		return descripcion;
	}

	/**
	 * Method 'setDescripcion'
	 * 
	 * @param descripcion
	 */
	public void setDescripcion(String descripcion)
	{
		this.descripcion = descripcion;
		this.descripcionModified = true;
	}

	/** 
	 * Sets the value of descripcionModified
	 */
	public void setDescripcionModified(boolean descripcionModified)
	{
		this.descripcionModified = descripcionModified;
	}

	/** 
	 * Gets the value of descripcionModified
	 */
	public boolean isDescripcionModified()
	{
		return descripcionModified;
	}

	/**
	 * Method 'equals'
	 * 
	 * @param _other
	 * @return boolean
	 */
	public boolean equals(Object _other)
	{
		if (_other == null) {
			return false;
		}
		
		if (_other == this) {
			return true;
		}
		
		if (!(_other instanceof PerfilUsuarioEntidad)) {
			return false;
		}
		
		final PerfilUsuarioEntidad _cast = (PerfilUsuarioEntidad) _other;
		if (idPerfilUsuario != _cast.idPerfilUsuario) {
			return false;
		}
		
		if (idPerfilUsuarioModified != _cast.idPerfilUsuarioModified) {
			return false;
		}
		
		if (nombre == null ? _cast.nombre != nombre : !nombre.equals( _cast.nombre )) {
			return false;
		}
		
		if (nombreModified != _cast.nombreModified) {
			return false;
		}
		
		if (descripcion == null ? _cast.descripcion != descripcion : !descripcion.equals( _cast.descripcion )) {
			return false;
		}
		
		if (descripcionModified != _cast.descripcionModified) {
			return false;
		}
		
		return true;
	}

	/**
	 * Method 'hashCode'
	 * 
	 * @return int
	 */
	public int hashCode()
	{
		int _hashCode = 0;
		_hashCode = 29 * _hashCode + idPerfilUsuario;
		_hashCode = 29 * _hashCode + (idPerfilUsuarioModified ? 1 : 0);
		if (nombre != null) {
			_hashCode = 29 * _hashCode + nombre.hashCode();
		}
		
		_hashCode = 29 * _hashCode + (nombreModified ? 1 : 0);
		if (descripcion != null) {
			_hashCode = 29 * _hashCode + descripcion.hashCode();
		}
		
		_hashCode = 29 * _hashCode + (descripcionModified ? 1 : 0);
		return _hashCode;
	}

	/**
	 * Method 'createPk'
	 * 
	 * @return PerfilUsuarioEntidadPk
	 */
	public PerfilUsuarioEntidadPk createPk()
	{
		return new PerfilUsuarioEntidadPk(idPerfilUsuario);
	}

	/**
	 * Method 'toString'
	 * 
	 * @return String
	 */
	public String toString()
	{
		StringBuffer ret = new StringBuffer();
		ret.append( "com.bankito.persistencia.dto.PerfilUsuarioEntidad: " );
		ret.append( "idPerfilUsuario=" + idPerfilUsuario );
		ret.append( ", nombre=" + nombre );
		ret.append( ", descripcion=" + descripcion );
		return ret.toString();
	}

}