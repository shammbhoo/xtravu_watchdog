package info.mqtt.android.service.room;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0002\bg\u0018\u00002\u00020\u0001J\u0016\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0006\u0010\b\u001a\u00020\tH\'J\u0010\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u0004H\'J\u0010\u0010\r\u001a\u00020\u000e2\u0006\u0010\b\u001a\u00020\tH\'J\u0018\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\u0010\u001a\u00020\tH\'J\u0010\u0010\u0011\u001a\u00020\u00122\u0006\u0010\f\u001a\u00020\u0004H\'J!\u0010\u0013\u001a\u00020\u000b2\u0012\u0010\f\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00040\u0014\"\u00020\u0004H\'\u00a2\u0006\u0002\u0010\u0015R\u001a\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00038gX\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006\u00a8\u0006\u0016"}, d2 = {"Linfo/mqtt/android/service/room/MqMessageDao;", "", "all", "", "Linfo/mqtt/android/service/room/entity/MqMessageEntity;", "getAll", "()Ljava/util/List;", "allArrived", "clientHandle", "", "delete", "", "mqMessageEntity", "deleteClientHandle", "", "deleteId", "id", "insert", "", "updateAll", "", "([Linfo/mqtt/android/service/room/entity/MqMessageEntity;)V", "serviceLibrary_debug"})
@androidx.room.Dao()
public abstract interface MqMessageDao {
    
    @androidx.room.Query(value = "SELECT * FROM MQMessageEntity")
    @org.jetbrains.annotations.NotNull()
    public abstract java.util.List<info.mqtt.android.service.room.entity.MqMessageEntity> getAll();
    
    @androidx.room.Query(value = "SELECT * FROM MQMessageEntity WHERE clientHandle = :clientHandle ORDER BY timestamp ASC")
    @org.jetbrains.annotations.NotNull()
    public abstract java.util.List<info.mqtt.android.service.room.entity.MqMessageEntity> allArrived(@org.jetbrains.annotations.NotNull()
    java.lang.String clientHandle);
    
    @androidx.room.Insert(onConflict = 1)
    public abstract long insert(@org.jetbrains.annotations.NotNull()
    info.mqtt.android.service.room.entity.MqMessageEntity mqMessageEntity);
    
    @androidx.room.Update()
    public abstract void updateAll(@org.jetbrains.annotations.NotNull()
    info.mqtt.android.service.room.entity.MqMessageEntity... mqMessageEntity);
    
    @androidx.room.Delete()
    public abstract void delete(@org.jetbrains.annotations.NotNull()
    info.mqtt.android.service.room.entity.MqMessageEntity mqMessageEntity);
    
    @androidx.room.Query(value = "DELETE FROM MqMessageEntity WHERE clientHandle = :clientHandle AND messageId = :id")
    public abstract int deleteId(@org.jetbrains.annotations.NotNull()
    java.lang.String clientHandle, @org.jetbrains.annotations.NotNull()
    java.lang.String id);
    
    @androidx.room.Query(value = "DELETE FROM MqMessageEntity WHERE clientHandle = :clientHandle")
    public abstract int deleteClientHandle(@org.jetbrains.annotations.NotNull()
    java.lang.String clientHandle);
}