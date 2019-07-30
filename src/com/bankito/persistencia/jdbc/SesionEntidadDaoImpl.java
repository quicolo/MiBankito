/*
 * This source file was generated by FireStorm/DAO.
 * 
 * If you purchase a full license for FireStorm/DAO you can customize this header file.
 * 
 * For more information please visit http://www.codefutures.com/products/firestorm
 */
package com.bankito.persistencia.jdbc;

import com.bankito.persistencia.dao.*;
import com.bankito.persistencia.factory.*;
import java.util.Date;
import com.bankito.persistencia.dto.*;
import com.bankito.persistencia.exceptions.*;
import java.sql.Connection;
import java.util.Collection;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

public class SesionEntidadDaoImpl extends AbstractDAO implements SesionEntidadDao {

    /**
     * The factory class for this DAO has two versions of the create() method -
     * one that takes no arguments and one that takes a Connection argument. If
     * the Connection version is chosen then the connection will be stored in
     * this attribute and will be used by all calls to this DAO, otherwise a new
     * Connection will be allocated for each operation.
     */
    protected java.sql.Connection userConn;

    /**
     * All finder methods in this class use this SELECT constant to build their
     * queries
     */
    protected final String SQL_SELECT = "SELECT id_sesion, accion, fecha_creacion, usuario_id_usuario FROM " + getTableName() + "";

    protected final String SQL_SELECT_MAX_ID_SESION = "SELECT max(id_sesion) FROM " + getTableName() + "";

    /**
     * Finder methods will pass this value to the JDBC setMaxRows method
     */
    protected int maxRows;

    /**
     * SQL INSERT statement for this table
     */
    protected final String SQL_INSERT = "INSERT INTO " + getTableName() + " ( id_sesion, accion, fecha_creacion, usuario_id_usuario ) VALUES ( ?, ?, ?, ? )";

    /**
     * SQL UPDATE statement for this table
     */
    protected final String SQL_UPDATE = "UPDATE " + getTableName() + " SET id_sesion = ?, accion = ?, fecha_creacion = ?, usuario_id_usuario = ? WHERE id_sesion = ?";

    /**
     * SQL DELETE statement for this table
     */
    protected final String SQL_DELETE = "DELETE FROM " + getTableName() + " WHERE id_sesion = ?";

    /**
     * Index of column id_sesion
     */
    protected static final int COLUMN_ID_SESION = 1;

    /**
     * Index of column accion
     */
    protected static final int COLUMN_ACCION = 2;

    /**
     * Index of column fecha_creacion
     */
    protected static final int COLUMN_FECHA_CREACION = 3;

    /**
     * Index of column usuario_id_usuario
     */
    protected static final int COLUMN_USUARIO_ID_USUARIO = 4;

    /**
     * Number of columns
     */
    protected static final int NUMBER_OF_COLUMNS = 4;

    /**
     * Index of primary-key column id_sesion
     */
    protected static final int PK_COLUMN_ID_SESION = 1;

    /**
     * Inserts a new row in the sesion table.
     */
    public SesionEntidadPk insert(SesionEntidad dto) throws SesionEntidadDaoException {
        long t1 = System.currentTimeMillis();
        // declare variables
        final boolean isConnSupplied = (userConn != null);
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {
            // get the user-specified connection or get a connection from the ResourceManager
            conn = isConnSupplied ? userConn : ResourceManager.getConnection();

            StringBuffer sql = new StringBuffer();
            StringBuffer values = new StringBuffer();
            sql.append("INSERT INTO " + getTableName() + " (");
            int modifiedCount = 0;
            if (dto.isIdSesionModified()) {
                if (modifiedCount > 0) {
                    sql.append(", ");
                    values.append(", ");
                }

                sql.append("id_sesion");
                values.append("?");
                modifiedCount++;
            }

            if (dto.isAccionModified()) {
                if (modifiedCount > 0) {
                    sql.append(", ");
                    values.append(", ");
                }

                sql.append("accion");
                values.append("?");
                modifiedCount++;
            }

            if (dto.isFechaCreacionModified()) {
                if (modifiedCount > 0) {
                    sql.append(", ");
                    values.append(", ");
                }

                sql.append("fecha_creacion");
                values.append("?");
                modifiedCount++;
            }

            if (dto.isUsuarioIdUsuarioModified()) {
                if (modifiedCount > 0) {
                    sql.append(", ");
                    values.append(", ");
                }

                sql.append("usuario_id_usuario");
                values.append("?");
                modifiedCount++;
            }

            if (modifiedCount == 0) {
                // nothing to insert
                throw new IllegalStateException("Nothing to insert");
            }

            sql.append(") VALUES (");
            sql.append(values);
            sql.append(")");
            stmt = conn.prepareStatement(sql.toString(), Statement.RETURN_GENERATED_KEYS);
            int index = 1;
            if (dto.isIdSesionModified()) {
                stmt.setInt(index++, dto.getIdSesion());
            }

            if (dto.isAccionModified()) {
                stmt.setString(index++, dto.getAccion());
            }

            if (dto.isFechaCreacionModified()) {
                stmt.setTimestamp(index++, dto.getFechaCreacion() == null ? null : new java.sql.Timestamp(dto.getFechaCreacion().getTime()));
            }

            if (dto.isUsuarioIdUsuarioModified()) {
                if (dto.isUsuarioIdUsuarioNull()) {
                    stmt.setNull(index++, java.sql.Types.INTEGER);
                } else {
                    stmt.setInt(index++, dto.getUsuarioIdUsuario());
                }

            }

            int rows = stmt.executeUpdate();
            long t2 = System.currentTimeMillis();

            // retrieve values from auto-increment columns
            rs = stmt.getGeneratedKeys();
            if (rs != null && rs.next()) {
                dto.setIdSesion(rs.getInt(1));
            }

            reset(dto);
            return dto.createPk();
        } catch (Exception _e) {
            throw new SesionEntidadDaoException("Exception: " + _e.getMessage(), _e);
        } finally {
            ResourceManager.close(stmt);
            if (!isConnSupplied) {
                ResourceManager.close(conn);
            }

        }

    }

    /**
     * Updates a single row in the sesion table.
     */
    public void update(SesionEntidadPk pk, SesionEntidad dto) throws SesionEntidadDaoException {
        long t1 = System.currentTimeMillis();
        // declare variables
        final boolean isConnSupplied = (userConn != null);
        Connection conn = null;
        PreparedStatement stmt = null;

        try {
            // get the user-specified connection or get a connection from the ResourceManager
            conn = isConnSupplied ? userConn : ResourceManager.getConnection();

            stmt = conn.prepareStatement(SQL_UPDATE);
            int index = 1;
            stmt.setInt(index++, dto.getIdSesion());
            stmt.setString(index++, dto.getAccion());
            stmt.setTimestamp(index++, dto.getFechaCreacion() == null ? null : new java.sql.Timestamp(dto.getFechaCreacion().getTime()));
            if (dto.isUsuarioIdUsuarioNull()) {
                stmt.setNull(index++, java.sql.Types.INTEGER);
            } else {
                stmt.setInt(index++, dto.getUsuarioIdUsuario());
            }

            stmt.setInt(5, pk.getIdSesion());
            int rows = stmt.executeUpdate();
            reset(dto);
            long t2 = System.currentTimeMillis();
        } catch (Exception _e) {
            throw new SesionEntidadDaoException("Exception: " + _e.getMessage(), _e);
        } finally {
            ResourceManager.close(stmt);
            if (!isConnSupplied) {
                ResourceManager.close(conn);
            }

        }

    }

    /**
     * Deletes a single row in the sesion table.
     */
    public void delete(SesionEntidadPk pk) throws SesionEntidadDaoException {
        long t1 = System.currentTimeMillis();
        // declare variables
        final boolean isConnSupplied = (userConn != null);
        Connection conn = null;
        PreparedStatement stmt = null;

        try {
            // get the user-specified connection or get a connection from the ResourceManager
            conn = isConnSupplied ? userConn : ResourceManager.getConnection();

            stmt = conn.prepareStatement(SQL_DELETE);
            stmt.setInt(1, pk.getIdSesion());
            int rows = stmt.executeUpdate();
            long t2 = System.currentTimeMillis();
        } catch (Exception _e) {
            throw new SesionEntidadDaoException("Exception: " + _e.getMessage(), _e);
        } finally {
            ResourceManager.close(stmt);
            if (!isConnSupplied) {
                ResourceManager.close(conn);
            }

        }

    }

    /**
     * Returns the rows from the sesion table that matches the specified
     * primary-key value.
     */
    public SesionEntidad findByPrimaryKey(SesionEntidadPk pk) throws SesionEntidadDaoException {
        return findByPrimaryKey(pk.getIdSesion());
    }

    /**
     * Returns all rows from the sesion table that match the criteria 'id_sesion
     * = :idSesion'.
     */
    public SesionEntidad findByPrimaryKey(int idSesion) throws SesionEntidadDaoException {
        SesionEntidad ret[] = findByDynamicSelect(SQL_SELECT + " WHERE id_sesion = ?", new Object[]{new Integer(idSesion)});
        return ret.length == 0 ? null : ret[0];
    }

    /**
     * Returns all rows from the sesion table that match the criteria ''.
     */
    public SesionEntidad[] findAll() throws SesionEntidadDaoException {
        return findByDynamicSelect(SQL_SELECT + " ORDER BY id_sesion", null);
    }

    /**
     * Returns all rows from the sesion table that match the criteria
     * 'usuario_id_usuario = :usuarioIdUsuario'.
     */
    public SesionEntidad[] findByUsuario(int usuarioIdUsuario) throws SesionEntidadDaoException {
        return findByDynamicSelect(SQL_SELECT + " WHERE usuario_id_usuario = ?", new Object[]{new Integer(usuarioIdUsuario)});
    }

    /**
     * Returns all rows from the sesion table that match the criteria
     * 'usuario_id_usuario = :usuarioIdUsuario'.
     */
    public SesionEntidad findLastSesionByUsuario(int usuarioIdUsuario) throws SesionEntidadDaoException {
        int maxId = 0;
        maxId = findLastIdSesionByDynamicSelect(SQL_SELECT_MAX_ID_SESION + " WHERE usuario_id_usuario = ?", new Object[]{new Integer(usuarioIdUsuario)});
        if (maxId == 0) {
            return null;
        } else {
            return this.findByPrimaryKey(maxId);
        }
    }

    /**
     * Returns all rows from the sesion table that match the criteria 'id_sesion
     * = :idSesion'.
     */
    public SesionEntidad[] findWhereIdSesionEquals(int idSesion) throws SesionEntidadDaoException {
        return findByDynamicSelect(SQL_SELECT + " WHERE id_sesion = ? ORDER BY id_sesion", new Object[]{new Integer(idSesion)});
    }

    /**
     * Returns all rows from the sesion table that match the criteria 'accion =
     * :accion'.
     */
    public SesionEntidad[] findWhereAccionEquals(String accion) throws SesionEntidadDaoException {
        return findByDynamicSelect(SQL_SELECT + " WHERE accion = ? ORDER BY accion", new Object[]{accion});
    }

    /**
     * Returns all rows from the sesion table that match the criteria
     * 'fecha_creacion = :fechaCreacion'.
     */
    public SesionEntidad[] findWhereFechaCreacionEquals(Date fechaCreacion) throws SesionEntidadDaoException {
        return findByDynamicSelect(SQL_SELECT + " WHERE fecha_creacion = ? ORDER BY fecha_creacion", new Object[]{fechaCreacion == null ? null : new java.sql.Timestamp(fechaCreacion.getTime())});
    }

    /**
     * Returns all rows from the sesion table that match the criteria
     * 'usuario_id_usuario = :usuarioIdUsuario'.
     */
    public SesionEntidad[] findWhereUsuarioIdUsuarioEquals(int usuarioIdUsuario) throws SesionEntidadDaoException {
        return findByDynamicSelect(SQL_SELECT + " WHERE usuario_id_usuario = ? ORDER BY usuario_id_usuario", new Object[]{new Integer(usuarioIdUsuario)});
    }

    /**
     * Method 'SesionEntidadDaoImpl'
     *
     */
    public SesionEntidadDaoImpl() {
    }

    /**
     * Method 'SesionEntidadDaoImpl'
     *
     * @param userConn
     */
    public SesionEntidadDaoImpl(final java.sql.Connection userConn) {
        this.userConn = userConn;
    }

    /**
     * Sets the value of maxRows
     */
    public void setMaxRows(int maxRows) {
        this.maxRows = maxRows;
    }

    /**
     * Gets the value of maxRows
     */
    public int getMaxRows() {
        return maxRows;
    }

    /**
     * Method 'getTableName'
     *
     * @return String
     */
    public String getTableName() {
        return "bankito.sesion";
    }

    /**
     * Fetches a single row from the result set
     */
    protected SesionEntidad fetchSingleResult(ResultSet rs) throws SQLException {
        if (rs.next()) {
            SesionEntidad dto = new SesionEntidad();
            populateDto(dto, rs);
            return dto;
        } else {
            return null;
        }

    }

    /**
     * Fetches multiple rows from the result set
     */
    protected SesionEntidad[] fetchMultiResults(ResultSet rs) throws SQLException {
        Collection resultList = new ArrayList();
        while (rs.next()) {
            SesionEntidad dto = new SesionEntidad();
            populateDto(dto, rs);
            resultList.add(dto);
        }

        SesionEntidad ret[] = new SesionEntidad[resultList.size()];
        resultList.toArray(ret);
        return ret;
    }

    /**
     * Populates a DTO with data from a ResultSet
     */
    protected void populateDto(SesionEntidad dto, ResultSet rs) throws SQLException {
        dto.setIdSesion(rs.getInt(COLUMN_ID_SESION));
        dto.setAccion(rs.getString(COLUMN_ACCION));
        dto.setFechaCreacion(rs.getTimestamp(COLUMN_FECHA_CREACION));
        dto.setUsuarioIdUsuario(rs.getInt(COLUMN_USUARIO_ID_USUARIO));
        if (rs.wasNull()) {
            dto.setUsuarioIdUsuarioNull(true);
        }

        reset(dto);
    }

    /**
     * Resets the modified attributes in the DTO
     */
    protected void reset(SesionEntidad dto) {
        dto.setIdSesionModified(false);
        dto.setAccionModified(false);
        dto.setFechaCreacionModified(false);
        dto.setUsuarioIdUsuarioModified(false);
    }

    /**
     * Returns all rows from the sesion table that match the specified arbitrary
     * SQL statement
     */
    public SesionEntidad[] findByDynamicSelect(String sql, Object[] sqlParams) throws SesionEntidadDaoException {
        // declare variables
        final boolean isConnSupplied = (userConn != null);
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {
            // get the user-specified connection or get a connection from the ResourceManager
            conn = isConnSupplied ? userConn : ResourceManager.getConnection();

            // construct the SQL statement
            final String SQL = sql;

            // prepare statement
            stmt = conn.prepareStatement(SQL);
            stmt.setMaxRows(maxRows);

            // bind parameters
            for (int i = 0; sqlParams != null && i < sqlParams.length; i++) {
                stmt.setObject(i + 1, sqlParams[i]);
            }

            rs = stmt.executeQuery();

            // fetch the results
            return fetchMultiResults(rs);
        } catch (Exception _e) {
            throw new SesionEntidadDaoException("Exception: " + _e.getMessage(), _e);
        } finally {
            ResourceManager.close(rs);
            ResourceManager.close(stmt);
            if (!isConnSupplied) {
                ResourceManager.close(conn);
            }

        }

    }

    /**
     * Returns all rows from the sesion table that match the specified arbitrary
     * SQL statement
     */
    public int findLastIdSesionByDynamicSelect(String sql, Object[] sqlParams) throws SesionEntidadDaoException {
        // declare variables
        final boolean isConnSupplied = (userConn != null);
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {
            // get the user-specified connection or get a connection from the ResourceManager
            conn = isConnSupplied ? userConn : ResourceManager.getConnection();

            // construct the SQL statement
            final String SQL = sql;

            // prepare statement
            stmt = conn.prepareStatement(SQL);
            stmt.setMaxRows(maxRows);

            // bind parameters
            for (int i = 0; sqlParams != null && i < sqlParams.length; i++) {
                stmt.setObject(i + 1, sqlParams[i]);
            }

            rs = stmt.executeQuery();

            if (rs.next()) {
                return rs.getInt(1);
            } else {
                return 0;
            }
        } catch (Exception _e) {
            throw new SesionEntidadDaoException("Exception: " + _e.getMessage(), _e);
        } finally {
            ResourceManager.close(rs);
            ResourceManager.close(stmt);
            if (!isConnSupplied) {
                ResourceManager.close(conn);
            }

        }

    }

    /**
     * Returns all rows from the sesion table that match the specified arbitrary
     * SQL statement
     */
    public SesionEntidad[] findByDynamicWhere(String sql, Object[] sqlParams) throws SesionEntidadDaoException {
        // declare variables
        final boolean isConnSupplied = (userConn != null);
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {
            // get the user-specified connection or get a connection from the ResourceManager
            conn = isConnSupplied ? userConn : ResourceManager.getConnection();

            // construct the SQL statement
            final String SQL = SQL_SELECT + " WHERE " + sql;

            // prepare statement
            stmt = conn.prepareStatement(SQL);
            stmt.setMaxRows(maxRows);

            // bind parameters
            for (int i = 0; sqlParams != null && i < sqlParams.length; i++) {
                stmt.setObject(i + 1, sqlParams[i]);
            }

            rs = stmt.executeQuery();

            // fetch the results
            return fetchMultiResults(rs);
        } catch (Exception _e) {
            throw new SesionEntidadDaoException("Exception: " + _e.getMessage(), _e);
        } finally {
            ResourceManager.close(rs);
            ResourceManager.close(stmt);
            if (!isConnSupplied) {
                ResourceManager.close(conn);
            }

        }

    }

}
