/*
 * AWS JDBC Proxy Driver
 * Copyright Amazon.com Inc. or affiliates.
 * See the LICENSE file in the project root for more information.
 */

package software.aws.rds.jdbc.proxydriver.wrapper;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLWarning;
import java.sql.Statement;
import org.checkerframework.checker.nullness.qual.NonNull;
import software.aws.rds.jdbc.proxydriver.ConnectionPluginManager;
import software.aws.rds.jdbc.proxydriver.util.WrapperUtils;

public class StatementWrapper implements Statement {

  protected Statement statement;
  protected ConnectionPluginManager pluginManager;

  public StatementWrapper(
      @NonNull Statement statement, @NonNull ConnectionPluginManager pluginManager) {
    this.statement = statement;
    this.pluginManager = pluginManager;
  }

  @Override
  public ResultSet executeQuery(String sql) throws SQLException {
    return WrapperUtils.executeWithPlugins(
        ResultSet.class,
        SQLException.class,
        this.pluginManager,
        this.statement,
        "Statement.executeQuery",
        () -> this.statement.executeQuery(sql),
        sql);
  }

  @Override
  public int executeUpdate(String sql) throws SQLException {
    return WrapperUtils.executeWithPlugins(
        int.class,
        SQLException.class,
        this.pluginManager,
        this.statement,
        "Statement.executeUpdate",
        () -> this.statement.executeUpdate(sql),
        sql);
  }

  @Override
  public int executeUpdate(String sql, int autoGeneratedKeys) throws SQLException {
    return WrapperUtils.executeWithPlugins(
        int.class,
        SQLException.class,
        this.pluginManager,
        this.statement,
        "Statement.executeUpdate",
        () -> this.statement.executeUpdate(sql, autoGeneratedKeys),
        sql,
        autoGeneratedKeys);
  }

  @Override
  public int executeUpdate(String sql, int[] columnIndexes) throws SQLException {
    return WrapperUtils.executeWithPlugins(
        int.class,
        SQLException.class,
        this.pluginManager,
        this.statement,
        "Statement.executeUpdate",
        () -> this.statement.executeUpdate(sql, columnIndexes),
        sql,
        columnIndexes);
  }

  @Override
  public int executeUpdate(String sql, String[] columnNames) throws SQLException {
    return WrapperUtils.executeWithPlugins(
        int.class,
        SQLException.class,
        this.pluginManager,
        this.statement,
        "Statement.executeUpdate",
        () -> this.statement.executeUpdate(sql, columnNames),
        sql,
        columnNames);
  }

  @Override
  public void close() throws SQLException {
    WrapperUtils.runWithPlugins(
        SQLException.class,
        this.pluginManager,
        this.statement,
        "Statement.close",
        () -> this.statement.close());
  }

  @Override
  public int getMaxFieldSize() throws SQLException {
    return WrapperUtils.executeWithPlugins(
        int.class,
        SQLException.class,
        this.pluginManager,
        this.statement,
        "Statement.getMaxFieldSize",
        () -> this.statement.getMaxFieldSize());
  }

  @Override
  public void setMaxFieldSize(int max) throws SQLException {
    WrapperUtils.runWithPlugins(
        SQLException.class,
        this.pluginManager,
        this.statement,
        "Statement.setMaxFieldSize",
        () -> this.statement.setMaxFieldSize(max),
        max);
  }

  @Override
  public int getMaxRows() throws SQLException {
    return WrapperUtils.executeWithPlugins(
        int.class,
        SQLException.class,
        this.pluginManager,
        this.statement,
        "Statement.getMaxRows",
        () -> this.statement.getMaxRows());
  }

  @Override
  public void setMaxRows(int max) throws SQLException {
    WrapperUtils.runWithPlugins(
        SQLException.class,
        this.pluginManager,
        this.statement,
        "Statement.setMaxRows",
        () -> this.statement.setMaxRows(max),
        max);
  }

  @Override
  public void setEscapeProcessing(boolean enable) throws SQLException {
    WrapperUtils.runWithPlugins(
        SQLException.class,
        this.pluginManager,
        this.statement,
        "Statement.setEscapeProcessing",
        () -> this.statement.setEscapeProcessing(enable),
        enable);
  }

  @Override
  public int getQueryTimeout() throws SQLException {
    return WrapperUtils.executeWithPlugins(
        int.class,
        SQLException.class,
        this.pluginManager,
        this.statement,
        "Statement.getQueryTimeout",
        () -> this.statement.getQueryTimeout());
  }

  @Override
  public void setQueryTimeout(int seconds) throws SQLException {
    WrapperUtils.runWithPlugins(
        SQLException.class,
        this.pluginManager,
        this.statement,
        "Statement.setQueryTimeout",
        () -> this.statement.setQueryTimeout(seconds),
        seconds);
  }

  @Override
  public void cancel() throws SQLException {
    WrapperUtils.runWithPlugins(
        SQLException.class,
        this.pluginManager,
        this.statement,
        "Statement.cancel",
        () -> this.statement.cancel());
  }

  @Override
  public SQLWarning getWarnings() throws SQLException {
    return WrapperUtils.executeWithPlugins(
        SQLWarning.class,
        SQLException.class,
        this.pluginManager,
        this.statement,
        "Statement.getWarnings",
        () -> this.statement.getWarnings());
  }

  @Override
  public void clearWarnings() throws SQLException {
    WrapperUtils.runWithPlugins(
        SQLException.class,
        this.pluginManager,
        this.statement,
        "Statement.clearWarnings",
        () -> this.statement.clearWarnings());
  }

  @Override
  public void setCursorName(String name) throws SQLException {
    WrapperUtils.runWithPlugins(
        SQLException.class,
        this.pluginManager,
        this.statement,
        "Statement.setCursorName",
        () -> this.statement.setCursorName(name),
        name);
  }

  @Override
  public boolean execute(String sql) throws SQLException {
    return WrapperUtils.executeWithPlugins(
        boolean.class,
        SQLException.class,
        this.pluginManager,
        this.statement,
        "Statement.execute",
        () -> this.statement.execute(sql),
        sql);
  }

  @Override
  public boolean execute(String sql, int autoGeneratedKeys) throws SQLException {
    return WrapperUtils.executeWithPlugins(
        boolean.class,
        SQLException.class,
        this.pluginManager,
        this.statement,
        "Statement.execute",
        () -> this.statement.execute(sql, autoGeneratedKeys),
        sql,
        autoGeneratedKeys);
  }

  @Override
  public boolean execute(String sql, int[] columnIndexes) throws SQLException {
    return WrapperUtils.executeWithPlugins(
        boolean.class,
        SQLException.class,
        this.pluginManager,
        this.statement,
        "Statement.execute",
        () -> this.statement.execute(sql, columnIndexes),
        sql,
        columnIndexes);
  }

  @Override
  public boolean execute(String sql, String[] columnNames) throws SQLException {
    return WrapperUtils.executeWithPlugins(
        boolean.class,
        SQLException.class,
        this.pluginManager,
        this.statement,
        "Statement.execute",
        () -> this.statement.execute(sql, columnNames),
        sql,
        columnNames);
  }

  @Override
  public ResultSet getResultSet() throws SQLException {
    return WrapperUtils.executeWithPlugins(
        ResultSet.class,
        SQLException.class,
        this.pluginManager,
        this.statement,
        "Statement.getResultSet",
        () -> this.statement.getResultSet());
  }

  @Override
  public int getUpdateCount() throws SQLException {
    return WrapperUtils.executeWithPlugins(
        int.class,
        SQLException.class,
        this.pluginManager,
        this.statement,
        "Statement.getUpdateCount",
        () -> this.statement.getUpdateCount());
  }

  @Override
  public boolean getMoreResults() throws SQLException {
    return WrapperUtils.executeWithPlugins(
        boolean.class,
        SQLException.class,
        this.pluginManager,
        this.statement,
        "Statement.getMoreResults",
        () -> this.statement.getMoreResults());
  }

  @Override
  public boolean getMoreResults(int current) throws SQLException {
    return WrapperUtils.executeWithPlugins(
        boolean.class,
        SQLException.class,
        this.pluginManager,
        this.statement,
        "Statement.getMoreResults",
        () -> this.statement.getMoreResults(current),
        current);
  }

  @Override
  public int getFetchDirection() throws SQLException {
    //noinspection MagicConstant
    return WrapperUtils.executeWithPlugins(
        int.class,
        SQLException.class,
        this.pluginManager,
        this.statement,
        "Statement.getFetchDirection",
        () -> this.statement.getFetchDirection());
  }

  @Override
  public void setFetchDirection(int direction) throws SQLException {
    WrapperUtils.runWithPlugins(
        SQLException.class,
        this.pluginManager,
        this.statement,
        "Statement.setFetchDirection",
        () -> this.statement.setFetchDirection(direction),
        direction);
  }

  @Override
  public int getFetchSize() throws SQLException {
    return WrapperUtils.executeWithPlugins(
        int.class,
        SQLException.class,
        this.pluginManager,
        this.statement,
        "Statement.getFetchSize",
        () -> this.statement.getFetchSize());
  }

  @Override
  public void setFetchSize(int rows) throws SQLException {
    WrapperUtils.runWithPlugins(
        SQLException.class,
        this.pluginManager,
        this.statement,
        "Statement.setFetchSize",
        () -> this.statement.setFetchSize(rows),
        rows);
  }

  @Override
  public int getResultSetConcurrency() throws SQLException {
    //noinspection MagicConstant
    return WrapperUtils.executeWithPlugins(
        int.class,
        SQLException.class,
        this.pluginManager,
        this.statement,
        "Statement.getResultSetConcurrency",
        () -> this.statement.getResultSetConcurrency());
  }

  @Override
  public int getResultSetType() throws SQLException {
    //noinspection MagicConstant
    return WrapperUtils.executeWithPlugins(
        int.class,
        SQLException.class,
        this.pluginManager,
        this.statement,
        "Statement.getResultSetType",
        () -> this.statement.getResultSetType());
  }

  @Override
  public void addBatch(String sql) throws SQLException {
    WrapperUtils.runWithPlugins(
        SQLException.class,
        this.pluginManager,
        this.statement,
        "Statement.addBatch",
        () -> this.statement.addBatch(sql),
        sql);
  }

  @Override
  public void clearBatch() throws SQLException {
    WrapperUtils.runWithPlugins(
        SQLException.class,
        this.pluginManager,
        this.statement,
        "Statement.clearBatch",
        () -> this.statement.clearBatch());
  }

  @Override
  public int[] executeBatch() throws SQLException {
    return WrapperUtils.executeWithPlugins(
        int[].class,
        SQLException.class,
        this.pluginManager,
        this.statement,
        "Statement.executeBatch",
        () -> this.statement.executeBatch());
  }

  @Override
  public Connection getConnection() throws SQLException {
    return WrapperUtils.executeWithPlugins(
        Connection.class,
        SQLException.class,
        this.pluginManager,
        this.statement,
        "Statement.getConnection",
        () -> this.statement.getConnection());
  }

  @Override
  public ResultSet getGeneratedKeys() throws SQLException {
    return WrapperUtils.executeWithPlugins(
        ResultSet.class,
        SQLException.class,
        this.pluginManager,
        this.statement,
        "Statement.getGeneratedKeys",
        () -> this.statement.getGeneratedKeys());
  }

  @Override
  public int getResultSetHoldability() throws SQLException {
    return WrapperUtils.executeWithPlugins(
        int.class,
        SQLException.class,
        this.pluginManager,
        this.statement,
        "Statement.getResultSetHoldability",
        () -> this.statement.getResultSetHoldability());
  }

  @Override
  public boolean isClosed() throws SQLException {
    return WrapperUtils.executeWithPlugins(
        boolean.class,
        SQLException.class,
        this.pluginManager,
        this.statement,
        "Statement.isClosed",
        () -> this.statement.isClosed());
  }

  @SuppressWarnings("SpellCheckingInspection")
  @Override
  public boolean isPoolable() throws SQLException {
    return WrapperUtils.executeWithPlugins(
        boolean.class,
        SQLException.class,
        this.pluginManager,
        this.statement,
        "Statement.isPoolable",
        () -> this.statement.isPoolable());
  }

  @SuppressWarnings("SpellCheckingInspection")
  @Override
  public void setPoolable(boolean poolable) throws SQLException {
    WrapperUtils.runWithPlugins(
        SQLException.class,
        this.pluginManager,
        this.statement,
        "Statement.setPoolable",
        () -> this.statement.setPoolable(poolable),
        poolable);
  }

  @Override
  public void closeOnCompletion() throws SQLException {
    WrapperUtils.runWithPlugins(
        SQLException.class,
        this.pluginManager,
        this.statement,
        "Statement.closeOnCompletion",
        () -> this.statement.closeOnCompletion());
  }

  @Override
  public boolean isCloseOnCompletion() throws SQLException {
    return WrapperUtils.executeWithPlugins(
        boolean.class,
        SQLException.class,
        this.pluginManager,
        this.statement,
        "Statement.isCloseOnCompletion",
        () -> this.statement.isCloseOnCompletion());
  }

  @Override
  public <T> T unwrap(Class<T> iface) throws SQLException {
    return this.statement.unwrap(iface);
  }

  @Override
  public boolean isWrapperFor(Class<?> iface) throws SQLException {
    return this.statement.isWrapperFor(iface);
  }
}
