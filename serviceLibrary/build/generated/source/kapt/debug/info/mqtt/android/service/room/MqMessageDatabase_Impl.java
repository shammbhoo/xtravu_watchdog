package info.mqtt.android.service.room;

import androidx.annotation.NonNull;
import androidx.room.DatabaseConfiguration;
import androidx.room.InvalidationTracker;
import androidx.room.RoomOpenHelper;
import androidx.room.RoomOpenHelper.Delegate;
import androidx.room.RoomOpenHelper.ValidationResult;
import androidx.room.migration.AutoMigrationSpec;
import androidx.room.migration.Migration;
import androidx.room.util.DBUtil;
import androidx.room.util.TableInfo;
import androidx.room.util.TableInfo.Column;
import androidx.room.util.TableInfo.ForeignKey;
import androidx.room.util.TableInfo.Index;
import androidx.sqlite.db.SupportSQLiteDatabase;
import androidx.sqlite.db.SupportSQLiteOpenHelper;
import androidx.sqlite.db.SupportSQLiteOpenHelper.Callback;
import androidx.sqlite.db.SupportSQLiteOpenHelper.Configuration;
import java.lang.Class;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

@SuppressWarnings({"unchecked", "deprecation"})
public final class MqMessageDatabase_Impl extends MqMessageDatabase {
  private volatile MqMessageDao _mqMessageDao;

  private volatile PingDao _pingDao;

  @Override
  protected SupportSQLiteOpenHelper createOpenHelper(DatabaseConfiguration configuration) {
    final SupportSQLiteOpenHelper.Callback _openCallback = new RoomOpenHelper(configuration, new RoomOpenHelper.Delegate(2) {
      @Override
      public void createAllTables(SupportSQLiteDatabase _db) {
        _db.execSQL("CREATE TABLE IF NOT EXISTS `MqMessageEntity` (`messageId` TEXT NOT NULL, `clientHandle` TEXT NOT NULL, `topic` TEXT NOT NULL, `mqttMessage` TEXT NOT NULL, `qos` INTEGER NOT NULL, `retained` INTEGER NOT NULL, `duplicate` INTEGER NOT NULL, `timestamp` INTEGER NOT NULL, PRIMARY KEY(`messageId`))");
        _db.execSQL("CREATE INDEX IF NOT EXISTS `index_MqMessageEntity_clientHandle` ON `MqMessageEntity` (`clientHandle`)");
        _db.execSQL("CREATE TABLE IF NOT EXISTS `PingEntity` (`timestamp` INTEGER NOT NULL, `clientId` TEXT, `serverURI` TEXT, `success` INTEGER NOT NULL, `message` TEXT, PRIMARY KEY(`timestamp`))");
        _db.execSQL("CREATE INDEX IF NOT EXISTS `index_PingEntity_timestamp` ON `PingEntity` (`timestamp`)");
        _db.execSQL("CREATE TABLE IF NOT EXISTS room_master_table (id INTEGER PRIMARY KEY,identity_hash TEXT)");
        _db.execSQL("INSERT OR REPLACE INTO room_master_table (id,identity_hash) VALUES(42, '28d9483c66f87d7f10041b140dac8fe9')");
      }

      @Override
      public void dropAllTables(SupportSQLiteDatabase _db) {
        _db.execSQL("DROP TABLE IF EXISTS `MqMessageEntity`");
        _db.execSQL("DROP TABLE IF EXISTS `PingEntity`");
        if (mCallbacks != null) {
          for (int _i = 0, _size = mCallbacks.size(); _i < _size; _i++) {
            mCallbacks.get(_i).onDestructiveMigration(_db);
          }
        }
      }

      @Override
      public void onCreate(SupportSQLiteDatabase _db) {
        if (mCallbacks != null) {
          for (int _i = 0, _size = mCallbacks.size(); _i < _size; _i++) {
            mCallbacks.get(_i).onCreate(_db);
          }
        }
      }

      @Override
      public void onOpen(SupportSQLiteDatabase _db) {
        mDatabase = _db;
        internalInitInvalidationTracker(_db);
        if (mCallbacks != null) {
          for (int _i = 0, _size = mCallbacks.size(); _i < _size; _i++) {
            mCallbacks.get(_i).onOpen(_db);
          }
        }
      }

      @Override
      public void onPreMigrate(SupportSQLiteDatabase _db) {
        DBUtil.dropFtsSyncTriggers(_db);
      }

      @Override
      public void onPostMigrate(SupportSQLiteDatabase _db) {
      }

      @Override
      public RoomOpenHelper.ValidationResult onValidateSchema(SupportSQLiteDatabase _db) {
        final HashMap<String, TableInfo.Column> _columnsMqMessageEntity = new HashMap<String, TableInfo.Column>(8);
        _columnsMqMessageEntity.put("messageId", new TableInfo.Column("messageId", "TEXT", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsMqMessageEntity.put("clientHandle", new TableInfo.Column("clientHandle", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsMqMessageEntity.put("topic", new TableInfo.Column("topic", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsMqMessageEntity.put("mqttMessage", new TableInfo.Column("mqttMessage", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsMqMessageEntity.put("qos", new TableInfo.Column("qos", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsMqMessageEntity.put("retained", new TableInfo.Column("retained", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsMqMessageEntity.put("duplicate", new TableInfo.Column("duplicate", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsMqMessageEntity.put("timestamp", new TableInfo.Column("timestamp", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysMqMessageEntity = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesMqMessageEntity = new HashSet<TableInfo.Index>(1);
        _indicesMqMessageEntity.add(new TableInfo.Index("index_MqMessageEntity_clientHandle", false, Arrays.asList("clientHandle"), Arrays.asList("ASC")));
        final TableInfo _infoMqMessageEntity = new TableInfo("MqMessageEntity", _columnsMqMessageEntity, _foreignKeysMqMessageEntity, _indicesMqMessageEntity);
        final TableInfo _existingMqMessageEntity = TableInfo.read(_db, "MqMessageEntity");
        if (! _infoMqMessageEntity.equals(_existingMqMessageEntity)) {
          return new RoomOpenHelper.ValidationResult(false, "MqMessageEntity(info.mqtt.android.service.room.entity.MqMessageEntity).\n"
                  + " Expected:\n" + _infoMqMessageEntity + "\n"
                  + " Found:\n" + _existingMqMessageEntity);
        }
        final HashMap<String, TableInfo.Column> _columnsPingEntity = new HashMap<String, TableInfo.Column>(5);
        _columnsPingEntity.put("timestamp", new TableInfo.Column("timestamp", "INTEGER", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsPingEntity.put("clientId", new TableInfo.Column("clientId", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsPingEntity.put("serverURI", new TableInfo.Column("serverURI", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsPingEntity.put("success", new TableInfo.Column("success", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsPingEntity.put("message", new TableInfo.Column("message", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysPingEntity = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesPingEntity = new HashSet<TableInfo.Index>(1);
        _indicesPingEntity.add(new TableInfo.Index("index_PingEntity_timestamp", false, Arrays.asList("timestamp"), Arrays.asList("ASC")));
        final TableInfo _infoPingEntity = new TableInfo("PingEntity", _columnsPingEntity, _foreignKeysPingEntity, _indicesPingEntity);
        final TableInfo _existingPingEntity = TableInfo.read(_db, "PingEntity");
        if (! _infoPingEntity.equals(_existingPingEntity)) {
          return new RoomOpenHelper.ValidationResult(false, "PingEntity(info.mqtt.android.service.room.entity.PingEntity).\n"
                  + " Expected:\n" + _infoPingEntity + "\n"
                  + " Found:\n" + _existingPingEntity);
        }
        return new RoomOpenHelper.ValidationResult(true, null);
      }
    }, "28d9483c66f87d7f10041b140dac8fe9", "7da52c069a3cbc0057ed55a080456c33");
    final SupportSQLiteOpenHelper.Configuration _sqliteConfig = SupportSQLiteOpenHelper.Configuration.builder(configuration.context)
        .name(configuration.name)
        .callback(_openCallback)
        .build();
    final SupportSQLiteOpenHelper _helper = configuration.sqliteOpenHelperFactory.create(_sqliteConfig);
    return _helper;
  }

  @Override
  protected InvalidationTracker createInvalidationTracker() {
    final HashMap<String, String> _shadowTablesMap = new HashMap<String, String>(0);
    HashMap<String, Set<String>> _viewTables = new HashMap<String, Set<String>>(0);
    return new InvalidationTracker(this, _shadowTablesMap, _viewTables, "MqMessageEntity","PingEntity");
  }

  @Override
  public void clearAllTables() {
    super.assertNotMainThread();
    final SupportSQLiteDatabase _db = super.getOpenHelper().getWritableDatabase();
    try {
      super.beginTransaction();
      _db.execSQL("DELETE FROM `MqMessageEntity`");
      _db.execSQL("DELETE FROM `PingEntity`");
      super.setTransactionSuccessful();
    } finally {
      super.endTransaction();
      _db.query("PRAGMA wal_checkpoint(FULL)").close();
      if (!_db.inTransaction()) {
        _db.execSQL("VACUUM");
      }
    }
  }

  @Override
  protected Map<Class<?>, List<Class<?>>> getRequiredTypeConverters() {
    final HashMap<Class<?>, List<Class<?>>> _typeConvertersMap = new HashMap<Class<?>, List<Class<?>>>();
    _typeConvertersMap.put(MqMessageDao.class, MqMessageDao_Impl.getRequiredConverters());
    _typeConvertersMap.put(PingDao.class, PingDao_Impl.getRequiredConverters());
    return _typeConvertersMap;
  }

  @Override
  public Set<Class<? extends AutoMigrationSpec>> getRequiredAutoMigrationSpecs() {
    final HashSet<Class<? extends AutoMigrationSpec>> _autoMigrationSpecsSet = new HashSet<Class<? extends AutoMigrationSpec>>();
    return _autoMigrationSpecsSet;
  }

  @Override
  public List<Migration> getAutoMigrations(
      @NonNull Map<Class<? extends AutoMigrationSpec>, AutoMigrationSpec> autoMigrationSpecsMap) {
    return Arrays.asList();
  }

  @Override
  public MqMessageDao persistenceDao() {
    if (_mqMessageDao != null) {
      return _mqMessageDao;
    } else {
      synchronized(this) {
        if(_mqMessageDao == null) {
          _mqMessageDao = new MqMessageDao_Impl(this);
        }
        return _mqMessageDao;
      }
    }
  }

  @Override
  public PingDao pingDao() {
    if (_pingDao != null) {
      return _pingDao;
    } else {
      synchronized(this) {
        if(_pingDao == null) {
          _pingDao = new PingDao_Impl(this);
        }
        return _pingDao;
      }
    }
  }
}
