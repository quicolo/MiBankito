/*
 * This source file was generated by FireStorm/DAO.
 * 
 * If you purchase a full license for FireStorm/DAO you can customize this header file.
 * 
 * For more information please visit http://www.codefutures.com/products/firestorm
 */

package com.bankito.persistencia.dto;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/** 
 * This class represents the primary key of the perfil_usuario_operacion table.
 */
public class PerfilUsuarioOperacionEntidadPk implements Serializable
{
	protected int perfilUsuarioIdPerfil;

	protected int operacionIdOperacion;

	/** 
	 * This attribute represents whether the primitive attribute perfilUsuarioIdPerfil is null.
	 */
	protected boolean perfilUsuarioIdPerfilNull;

	/** 
	 * This attribute represents whether the primitive attribute operacionIdOperacion is null.
	 */
	protected boolean operacionIdOperacionNull;

	/** 
	 * Sets the value of perfilUsuarioIdPerfil
	 */
	public void setPerfilUsuarioIdPerfil(int perfilUsuarioIdPerfil)
	{
		this.perfilUsuarioIdPerfil = perfilUsuarioIdPerfil;
	}

	/** 
	 * Gets the value of perfilUsuarioIdPerfil
	 */
	public int getPerfilUsuarioIdPerfil()
	{
		return perfilUsuarioIdPerfil;
	}

	/** 
	 * Sets the value of operacionIdOperacion
	 */
	public void setOperacionIdOperacion(int operacionIdOperacion)
	{
		this.operacionIdOperacion = operacionIdOperacion;
	}

	/** 
	 * Gets the value of operacionIdOperacion
	 */
	public int getOperacionIdOperacion()
	{
		return operacionIdOperacion;
	}

	/**
	 * Method 'PerfilUsuarioOperacionEntidadPk'
	 * 
	 */
	public PerfilUsuarioOperacionEntidadPk()
	{
	}

	/**
	 * Method 'PerfilUsuarioOperacionEntidadPk'
	 * 
	 * @param perfilUsuarioIdPerfil
	 * @param operacionIdOperacion
	 */
	public PerfilUsuarioOperacionEntidadPk(final int perfilUsuarioIdPerfil, final int operacionIdOperacion)
	{
		this.perfilUsuarioIdPerfil = perfilUsuarioIdPerfil;
		this.operacionIdOperacion = operacionIdOperacion;
	}

	/** 
	 * Sets the value of perfilUsuarioIdPerfilNull
	 */
	public void setPerfilUsuarioIdPerfilNull(boolean perfilUsuarioIdPerfilNull)
	{
		this.perfilUsuarioIdPerfilNull = perfilUsuarioIdPerfilNull;
	}

	/** 
	 * Gets the value of perfilUsuarioIdPerfilNull
	 */
	public boolean isPerfilUsuarioIdPerfilNull()
	{
		return perfilUsuarioIdPerfilNull;
	}

	/** 
	 * Sets the value of operacionIdOperacionNull
	 */
	public void setOperacionIdOperacionNull(boolean operacionIdOperacionNull)
	{
		this.operacionIdOperacionNull = operacionIdOperacionNull;
	}

	/** 
	 * Gets the value of operacionIdOperacionNull
	 */
	public boolean isOperacionIdOperacionNull()
	{
		return operacionIdOperacionNull;
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
		
		if (!(_other instanceof PerfilUsuarioOperacionEntidadPk)) {
			return false;
		}
		
		final PerfilUsuarioOperacionEntidadPk _cast = (PerfilUsuarioOperacionEntidadPk) _other;
		if (perfilUsuarioIdPerfil != _cast.perfilUsuarioIdPerfil) {
			return false;
		}
		
		if (operacionIdOperacion != _cast.operacionIdOperacion) {
			return false;
		}
		
		if (perfilUsuarioIdPerfilNull != _cast.perfilUsuarioIdPerfilNull) {
			return false;
		}
		
		if (operacionIdOperacionNull != _cast.operacionIdOperacionNull) {
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
		_hashCode = 29 * _hashCode + perfilUsuarioIdPerfil;
		_hashCode = 29 * _hashCode + operacionIdOperacion;
		_hashCode = 29 * _hashCode + (perfilUsuarioIdPerfilNull ? 1 : 0);
		_hashCode = 29 * _hashCode + (operacionIdOperacionNull ? 1 : 0);
		return _hashCode;
	}

	/**
	 * Method 'toString'
	 * 
	 * @return String
	 */
	public String toString()
	{
		StringBuffer ret = new StringBuffer();
		ret.append( "com.bankito.persistencia.dto.PerfilUsuarioOperacionEntidadPk: " );
		ret.append( "perfilUsuarioIdPerfil=" + perfilUsuarioIdPerfil );
		ret.append( ", operacionIdOperacion=" + operacionIdOperacion );
		return ret.toString();
	}

}
