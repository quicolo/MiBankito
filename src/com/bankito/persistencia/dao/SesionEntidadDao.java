/*
 * This source file was generated by FireStorm/DAO.
 * 
 * If you purchase a full license for FireStorm/DAO you can customize this header file.
 * 
 * For more information please visit http://www.codefutures.com/products/firestorm
 */

package com.bankito.persistencia.dao;

import java.util.Date;
import com.bankito.persistencia.dto.*;
import com.bankito.persistencia.exceptions.*;

public interface SesionEntidadDao
{
	/** 
	 * Inserts a new row in the sesion table.
	 */
	public SesionEntidadPk insert(SesionEntidad dto) throws SesionEntidadDaoException;

	/** 
	 * Updates a single row in the sesion table.
	 */
	public void update(SesionEntidadPk pk, SesionEntidad dto) throws SesionEntidadDaoException;

	/** 
	 * Deletes a single row in the sesion table.
	 */
	public void delete(SesionEntidadPk pk) throws SesionEntidadDaoException;

	/** 
	 * Returns the rows from the sesion table that matches the specified primary-key value.
	 */
	public SesionEntidad findByPrimaryKey(SesionEntidadPk pk) throws SesionEntidadDaoException;

	/** 
	 * Returns all rows from the sesion table that match the criteria 'id_sesion = :idSesion'.
	 */
	public SesionEntidad findByPrimaryKey(int idSesion) throws SesionEntidadDaoException;

	/** 
	 * Returns all rows from the sesion table that match the criteria ''.
	 */
	public SesionEntidad[] findAll() throws SesionEntidadDaoException;

	/** 
	 * Returns all rows from the sesion table that match the criteria 'usuario_id_usuario = :usuarioIdUsuario'.
	 */
	public SesionEntidad[] findByUsuario(int usuarioIdUsuario) throws SesionEntidadDaoException;

	/** 
	 * Returns all rows from the sesion table that match the criteria 'id_sesion = :idSesion'.
	 */
	public SesionEntidad[] findWhereIdSesionEquals(int idSesion) throws SesionEntidadDaoException;

	/** 
	 * Returns all rows from the sesion table that match the criteria 'accion = :accion'.
	 */
	public SesionEntidad[] findWhereAccionEquals(String accion) throws SesionEntidadDaoException;

	/** 
	 * Returns all rows from the sesion table that match the criteria 'fecha_creacion = :fechaCreacion'.
	 */
	public SesionEntidad[] findWhereFechaCreacionEquals(Date fechaCreacion) throws SesionEntidadDaoException;

	/** 
	 * Returns all rows from the sesion table that match the criteria 'usuario_id_usuario = :usuarioIdUsuario'.
	 */
	public SesionEntidad[] findWhereUsuarioIdUsuarioEquals(int usuarioIdUsuario) throws SesionEntidadDaoException;
        
        public SesionEntidad findLastSesionByUsuario(int usuarioIdUsuario) throws SesionEntidadDaoException;
        
	/** 
	 * Sets the value of maxRows
	 */
	public void setMaxRows(int maxRows);

	/** 
	 * Gets the value of maxRows
	 */
	public int getMaxRows();

	/** 
	 * Returns all rows from the sesion table that match the specified arbitrary SQL statement
	 */
	public SesionEntidad[] findByDynamicSelect(String sql, Object[] sqlParams) throws SesionEntidadDaoException;

	/** 
	 * Returns all rows from the sesion table that match the specified arbitrary SQL statement
	 */
	public SesionEntidad[] findByDynamicWhere(String sql, Object[] sqlParams) throws SesionEntidadDaoException;

}