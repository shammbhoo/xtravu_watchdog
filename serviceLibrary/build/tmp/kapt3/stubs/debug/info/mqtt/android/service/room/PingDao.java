package info.mqtt.android.service.room;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010\u0011\n\u0002\b\u0002\bg\u0018\u00002\u00020\u0001J\u001c\u0010\b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00040\u00032\u0006\u0010\t\u001a\u00020\nH\'J\u0010\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u0005H\'J\u0010\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\t\u001a\u00020\nH\'J\u0010\u0010\u0010\u001a\u00020\u00112\u0006\u0010\r\u001a\u00020\u0005H\'J\u0010\u0010\u0012\u001a\u00020\f2\u0006\u0010\u0013\u001a\u00020\u000fH\'J!\u0010\u0014\u001a\u00020\f2\u0012\u0010\u0015\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00050\u0016\"\u00020\u0005H\'\u00a2\u0006\u0002\u0010\u0017R \u0010\u0002\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00040\u00038gX\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007\u00a8\u0006\u0018"}, d2 = {"Linfo/mqtt/android/service/room/PingDao;", "", "all", "Landroidx/lifecycle/LiveData;", "", "Linfo/mqtt/android/service/room/entity/PingEntity;", "getAll", "()Landroidx/lifecycle/LiveData;", "allByState", "statePing", "", "delete", "", "pingEntity", "deleteState", "", "insert", "", "removeOldData", "keepCount", "updateAll", "pingEntities", "", "([Linfo/mqtt/android/service/room/entity/PingEntity;)V", "serviceLibrary_debug"})
@androidx.room.Dao()
public abstract interface PingDao {
    
    @androidx.room.Query(value = "SELECT * FROM PingEntity ORDER BY timestamp ASC")
    @org.jetbrains.annotations.NotNull()
    public abstract androidx.lifecycle.LiveData<java.util.List<info.mqtt.android.service.room.entity.PingEntity>> getAll();
    
    @androidx.room.Query(value = "SELECT * FROM PingEntity WHERE success = :statePing ORDER BY timestamp ASC")
    @org.jetbrains.annotations.NotNull()
    public abstract androidx.lifecycle.LiveData<java.util.List<info.mqtt.android.service.room.entity.PingEntity>> allByState(boolean statePing);
    
    @androidx.room.Insert(onConflict = 1)
    public abstract long insert(@org.jetbrains.annotations.NotNull()
    info.mqtt.android.service.room.entity.PingEntity pingEntity);
    
    @androidx.room.Update()
    public abstract void updateAll(@org.jetbrains.annotations.NotNull()
    info.mqtt.android.service.room.entity.PingEntity... pingEntities);
    
    @androidx.room.Delete()
    public abstract void delete(@org.jetbrains.annotations.NotNull()
    info.mqtt.android.service.room.entity.PingEntity pingEntity);
    
    @androidx.room.Query(value = "DELETE FROM PingEntity WHERE success = :statePing")
    public abstract int deleteState(boolean statePing);
    
    @androidx.room.Query(value = "DELETE FROM PingEntity WHERE timeStamp IN (SELECT timeStamp FROM PingEntity ORDER BY timeStamp DESC LIMIT 1 OFFSET :keepCount)")
    public abstract void removeOldData(int keepCount);
}