package info.mqtt.android.service.room;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\b\'\u0018\u0000 \u00102\u00020\u0001:\u0001\u0010B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0016\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0006J\b\u0010\b\u001a\u00020\tH&J\b\u0010\n\u001a\u00020\u000bH&J\u001e\u0010\f\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\u000f\u00a8\u0006\u0011"}, d2 = {"Linfo/mqtt/android/service/room/MqMessageDatabase;", "Landroidx/room/RoomDatabase;", "()V", "discardArrived", "", "clientHandle", "", "id", "persistenceDao", "Linfo/mqtt/android/service/room/MqMessageDao;", "pingDao", "Linfo/mqtt/android/service/room/PingDao;", "storeArrived", "topic", "message", "Lorg/eclipse/paho/client/mqttv3/MqttMessage;", "Companion", "serviceLibrary_debug"})
@androidx.room.Database(entities = {info.mqtt.android.service.room.entity.MqMessageEntity.class, info.mqtt.android.service.room.entity.PingEntity.class}, version = 2)
@androidx.room.TypeConverters(value = {info.mqtt.android.service.room.Converters.class})
public abstract class MqMessageDatabase extends androidx.room.RoomDatabase {
    public static final int MQ_DB_VERSION = 2;
    @kotlin.jvm.Volatile()
    @org.jetbrains.annotations.Nullable()
    private static volatile info.mqtt.android.service.room.MqMessageDatabase instance;
    @org.jetbrains.annotations.NotNull()
    public static final info.mqtt.android.service.room.MqMessageDatabase.Companion Companion = null;
    
    public MqMessageDatabase() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public abstract info.mqtt.android.service.room.MqMessageDao persistenceDao();
    
    @org.jetbrains.annotations.NotNull()
    public abstract info.mqtt.android.service.room.PingDao pingDao();
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String storeArrived(@org.jetbrains.annotations.NotNull()
    java.lang.String clientHandle, @org.jetbrains.annotations.NotNull()
    java.lang.String topic, @org.jetbrains.annotations.NotNull()
    org.eclipse.paho.client.mqttv3.MqttMessage message) {
        return null;
    }
    
    public final boolean discardArrived(@org.jetbrains.annotations.NotNull()
    java.lang.String clientHandle, @org.jetbrains.annotations.NotNull()
    java.lang.String id) {
        return false;
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0002J\u0018\u0010\f\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u000bR\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\r"}, d2 = {"Linfo/mqtt/android/service/room/MqMessageDatabase$Companion;", "", "()V", "MQ_DB_VERSION", "", "instance", "Linfo/mqtt/android/service/room/MqMessageDatabase;", "buildDatabase", "context", "Landroid/content/Context;", "storageName", "", "getDatabase", "serviceLibrary_debug"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
        
        @kotlin.jvm.Synchronized()
        @org.jetbrains.annotations.NotNull()
        public final synchronized info.mqtt.android.service.room.MqMessageDatabase getDatabase(@org.jetbrains.annotations.NotNull()
        android.content.Context context, @org.jetbrains.annotations.NotNull()
        java.lang.String storageName) {
            return null;
        }
        
        private final info.mqtt.android.service.room.MqMessageDatabase buildDatabase(android.content.Context context, java.lang.String storageName) {
            return null;
        }
    }
}