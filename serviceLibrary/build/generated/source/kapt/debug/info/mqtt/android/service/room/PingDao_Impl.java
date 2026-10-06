package info.mqtt.android.service.room;

import android.database.Cursor;
import androidx.lifecycle.LiveData;
import androidx.room.EntityDeletionOrUpdateAdapter;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.SharedSQLiteStatement;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import info.mqtt.android.service.room.entity.PingEntity;
import java.lang.Class;
import java.lang.Exception;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Callable;

@SuppressWarnings({"unchecked", "deprecation"})
public final class PingDao_Impl implements PingDao {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter<PingEntity> __insertionAdapterOfPingEntity;

  private final EntityDeletionOrUpdateAdapter<PingEntity> __deletionAdapterOfPingEntity;

  private final EntityDeletionOrUpdateAdapter<PingEntity> __updateAdapterOfPingEntity;

  private final SharedSQLiteStatement __preparedStmtOfDeleteState;

  private final SharedSQLiteStatement __preparedStmtOfRemoveOldData;

  public PingDao_Impl(RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfPingEntity = new EntityInsertionAdapter<PingEntity>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR REPLACE INTO `PingEntity` (`timestamp`,`clientId`,`serverURI`,`success`,`message`) VALUES (?,?,?,?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, PingEntity value) {
        stmt.bindLong(1, value.getTimestamp());
        if (value.getClientId() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.getClientId());
        }
        if (value.getServerURI() == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, value.getServerURI());
        }
        final int _tmp = value.getSuccess() ? 1 : 0;
        stmt.bindLong(4, _tmp);
        if (value.getMessage() == null) {
          stmt.bindNull(5);
        } else {
          stmt.bindString(5, value.getMessage());
        }
      }
    };
    this.__deletionAdapterOfPingEntity = new EntityDeletionOrUpdateAdapter<PingEntity>(__db) {
      @Override
      public String createQuery() {
        return "DELETE FROM `PingEntity` WHERE `timestamp` = ?";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, PingEntity value) {
        stmt.bindLong(1, value.getTimestamp());
      }
    };
    this.__updateAdapterOfPingEntity = new EntityDeletionOrUpdateAdapter<PingEntity>(__db) {
      @Override
      public String createQuery() {
        return "UPDATE OR ABORT `PingEntity` SET `timestamp` = ?,`clientId` = ?,`serverURI` = ?,`success` = ?,`message` = ? WHERE `timestamp` = ?";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, PingEntity value) {
        stmt.bindLong(1, value.getTimestamp());
        if (value.getClientId() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.getClientId());
        }
        if (value.getServerURI() == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, value.getServerURI());
        }
        final int _tmp = value.getSuccess() ? 1 : 0;
        stmt.bindLong(4, _tmp);
        if (value.getMessage() == null) {
          stmt.bindNull(5);
        } else {
          stmt.bindString(5, value.getMessage());
        }
        stmt.bindLong(6, value.getTimestamp());
      }
    };
    this.__preparedStmtOfDeleteState = new SharedSQLiteStatement(__db) {
      @Override
      public String createQuery() {
        final String _query = "DELETE FROM PingEntity WHERE success = ?";
        return _query;
      }
    };
    this.__preparedStmtOfRemoveOldData = new SharedSQLiteStatement(__db) {
      @Override
      public String createQuery() {
        final String _query = "DELETE FROM PingEntity WHERE timeStamp IN (SELECT timeStamp FROM PingEntity ORDER BY timeStamp DESC LIMIT 1 OFFSET ?)";
        return _query;
      }
    };
  }

  @Override
  public long insert(final PingEntity pingEntity) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      long _result = __insertionAdapterOfPingEntity.insertAndReturnId(pingEntity);
      __db.setTransactionSuccessful();
      return _result;
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void delete(final PingEntity pingEntity) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __deletionAdapterOfPingEntity.handle(pingEntity);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void updateAll(final PingEntity... pingEntities) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __updateAdapterOfPingEntity.handleMultiple(pingEntities);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public int deleteState(final boolean statePing) {
    __db.assertNotSuspendingTransaction();
    final SupportSQLiteStatement _stmt = __preparedStmtOfDeleteState.acquire();
    int _argIndex = 1;
    final int _tmp = statePing ? 1 : 0;
    _stmt.bindLong(_argIndex, _tmp);
    __db.beginTransaction();
    try {
      final int _result = _stmt.executeUpdateDelete();
      __db.setTransactionSuccessful();
      return _result;
    } finally {
      __db.endTransaction();
      __preparedStmtOfDeleteState.release(_stmt);
    }
  }

  @Override
  public void removeOldData(final int keepCount) {
    __db.assertNotSuspendingTransaction();
    final SupportSQLiteStatement _stmt = __preparedStmtOfRemoveOldData.acquire();
    int _argIndex = 1;
    _stmt.bindLong(_argIndex, keepCount);
    __db.beginTransaction();
    try {
      _stmt.executeUpdateDelete();
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
      __preparedStmtOfRemoveOldData.release(_stmt);
    }
  }

  @Override
  public LiveData<List<PingEntity>> getAll() {
    final String _sql = "SELECT * FROM PingEntity ORDER BY timestamp ASC";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    return __db.getInvalidationTracker().createLiveData(new String[]{"PingEntity"}, false, new Callable<List<PingEntity>>() {
      @Override
      public List<PingEntity> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfTimestamp = CursorUtil.getColumnIndexOrThrow(_cursor, "timestamp");
          final int _cursorIndexOfClientId = CursorUtil.getColumnIndexOrThrow(_cursor, "clientId");
          final int _cursorIndexOfServerURI = CursorUtil.getColumnIndexOrThrow(_cursor, "serverURI");
          final int _cursorIndexOfSuccess = CursorUtil.getColumnIndexOrThrow(_cursor, "success");
          final int _cursorIndexOfMessage = CursorUtil.getColumnIndexOrThrow(_cursor, "message");
          final List<PingEntity> _result = new ArrayList<PingEntity>(_cursor.getCount());
          while(_cursor.moveToNext()) {
            final PingEntity _item;
            final long _tmpTimestamp;
            _tmpTimestamp = _cursor.getLong(_cursorIndexOfTimestamp);
            final String _tmpClientId;
            if (_cursor.isNull(_cursorIndexOfClientId)) {
              _tmpClientId = null;
            } else {
              _tmpClientId = _cursor.getString(_cursorIndexOfClientId);
            }
            final String _tmpServerURI;
            if (_cursor.isNull(_cursorIndexOfServerURI)) {
              _tmpServerURI = null;
            } else {
              _tmpServerURI = _cursor.getString(_cursorIndexOfServerURI);
            }
            final boolean _tmpSuccess;
            final int _tmp;
            _tmp = _cursor.getInt(_cursorIndexOfSuccess);
            _tmpSuccess = _tmp != 0;
            final String _tmpMessage;
            if (_cursor.isNull(_cursorIndexOfMessage)) {
              _tmpMessage = null;
            } else {
              _tmpMessage = _cursor.getString(_cursorIndexOfMessage);
            }
            _item = new PingEntity(_tmpTimestamp,_tmpClientId,_tmpServerURI,_tmpSuccess,_tmpMessage);
            _result.add(_item);
          }
          return _result;
        } finally {
          _cursor.close();
        }
      }

      @Override
      protected void finalize() {
        _statement.release();
      }
    });
  }

  @Override
  public LiveData<List<PingEntity>> allByState(final boolean statePing) {
    final String _sql = "SELECT * FROM PingEntity WHERE success = ? ORDER BY timestamp ASC";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    final int _tmp = statePing ? 1 : 0;
    _statement.bindLong(_argIndex, _tmp);
    return __db.getInvalidationTracker().createLiveData(new String[]{"PingEntity"}, false, new Callable<List<PingEntity>>() {
      @Override
      public List<PingEntity> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfTimestamp = CursorUtil.getColumnIndexOrThrow(_cursor, "timestamp");
          final int _cursorIndexOfClientId = CursorUtil.getColumnIndexOrThrow(_cursor, "clientId");
          final int _cursorIndexOfServerURI = CursorUtil.getColumnIndexOrThrow(_cursor, "serverURI");
          final int _cursorIndexOfSuccess = CursorUtil.getColumnIndexOrThrow(_cursor, "success");
          final int _cursorIndexOfMessage = CursorUtil.getColumnIndexOrThrow(_cursor, "message");
          final List<PingEntity> _result = new ArrayList<PingEntity>(_cursor.getCount());
          while(_cursor.moveToNext()) {
            final PingEntity _item;
            final long _tmpTimestamp;
            _tmpTimestamp = _cursor.getLong(_cursorIndexOfTimestamp);
            final String _tmpClientId;
            if (_cursor.isNull(_cursorIndexOfClientId)) {
              _tmpClientId = null;
            } else {
              _tmpClientId = _cursor.getString(_cursorIndexOfClientId);
            }
            final String _tmpServerURI;
            if (_cursor.isNull(_cursorIndexOfServerURI)) {
              _tmpServerURI = null;
            } else {
              _tmpServerURI = _cursor.getString(_cursorIndexOfServerURI);
            }
            final boolean _tmpSuccess;
            final int _tmp_1;
            _tmp_1 = _cursor.getInt(_cursorIndexOfSuccess);
            _tmpSuccess = _tmp_1 != 0;
            final String _tmpMessage;
            if (_cursor.isNull(_cursorIndexOfMessage)) {
              _tmpMessage = null;
            } else {
              _tmpMessage = _cursor.getString(_cursorIndexOfMessage);
            }
            _item = new PingEntity(_tmpTimestamp,_tmpClientId,_tmpServerURI,_tmpSuccess,_tmpMessage);
            _result.add(_item);
          }
          return _result;
        } finally {
          _cursor.close();
        }
      }

      @Override
      protected void finalize() {
        _statement.release();
      }
    });
  }

  public static List<Class<?>> getRequiredConverters() {
    return Collections.emptyList();
  }
}
