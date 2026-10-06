package info.mqtt.android.service.ping;

/**
 * Default ping sender implementation on Android. It is based on AlarmManager.
 *
 * This class implements the [MqttPingSender] ping interface
 * allowing applications to send ping packet to server every keep alive interval.
 *
 * @see MqttPingSender
 */
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0004\b\u0000\u0018\u0000 \u00162\u00020\u0001:\u0001\u0016B!\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u00a2\u0006\u0002\u0010\bJ\u0010\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0016J\u0010\u0010\u0011\u001a\u00020\u000e2\u0006\u0010\u0012\u001a\u00020\u0013H\u0016J\b\u0010\u0014\u001a\u00020\u000eH\u0016J\b\u0010\u0015\u001a\u00020\u000eH\u0016R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u000e\u0010\u000b\u001a\u00020\fX\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0017"}, d2 = {"Linfo/mqtt/android/service/ping/AlarmPingSender;", "Lorg/eclipse/paho/client/mqttv3/MqttPingSender;", "service", "Linfo/mqtt/android/service/MqttService;", "pingLogging", "", "keepPingRecords", "", "(Linfo/mqtt/android/service/MqttService;ZI)V", "getService", "()Linfo/mqtt/android/service/MqttService;", "workManager", "Landroidx/work/WorkManager;", "init", "", "comms", "Lorg/eclipse/paho/client/mqttv3/internal/ClientComms;", "schedule", "delayInMilliseconds", "", "start", "stop", "Companion", "serviceLibrary_debug"})
public final class AlarmPingSender implements org.eclipse.paho.client.mqttv3.MqttPingSender {
    @org.jetbrains.annotations.NotNull()
    private final info.mqtt.android.service.MqttService service = null;
    private final boolean pingLogging = false;
    private final int keepPingRecords = 0;
    @org.jetbrains.annotations.NotNull()
    private final androidx.work.WorkManager workManager = null;
    @org.jetbrains.annotations.NotNull()
    private static final java.lang.String PING_JOB = "PING_JOB";
    @org.jetbrains.annotations.Nullable()
    private static org.eclipse.paho.client.mqttv3.internal.ClientComms clientComms;
    @org.jetbrains.annotations.Nullable()
    private static info.mqtt.android.service.room.MqMessageDatabase messageDatabase;
    @android.annotation.SuppressLint(value = {"ConstantLocale"})
    @org.jetbrains.annotations.NotNull()
    private static final java.text.SimpleDateFormat sdf = null;
    @org.jetbrains.annotations.NotNull()
    public static final info.mqtt.android.service.ping.AlarmPingSender.Companion Companion = null;
    
    public AlarmPingSender(@org.jetbrains.annotations.NotNull()
    info.mqtt.android.service.MqttService service, boolean pingLogging, int keepPingRecords) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final info.mqtt.android.service.MqttService getService() {
        return null;
    }
    
    @java.lang.Override()
    public void init(@org.jetbrains.annotations.NotNull()
    org.eclipse.paho.client.mqttv3.internal.ClientComms comms) {
    }
    
    @java.lang.Override()
    public void start() {
    }
    
    @java.lang.Override()
    public void stop() {
    }
    
    @java.lang.Override()
    public void schedule(long delayInMilliseconds) {
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u001c\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0080\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001c\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0080\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u0016\u0010\u0011\u001a\u00020\u00128\u0000X\u0081\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014\u00a8\u0006\u0015"}, d2 = {"Linfo/mqtt/android/service/ping/AlarmPingSender$Companion;", "", "()V", "PING_JOB", "", "clientComms", "Lorg/eclipse/paho/client/mqttv3/internal/ClientComms;", "getClientComms$serviceLibrary_debug", "()Lorg/eclipse/paho/client/mqttv3/internal/ClientComms;", "setClientComms$serviceLibrary_debug", "(Lorg/eclipse/paho/client/mqttv3/internal/ClientComms;)V", "messageDatabase", "Linfo/mqtt/android/service/room/MqMessageDatabase;", "getMessageDatabase$serviceLibrary_debug", "()Linfo/mqtt/android/service/room/MqMessageDatabase;", "setMessageDatabase$serviceLibrary_debug", "(Linfo/mqtt/android/service/room/MqMessageDatabase;)V", "sdf", "Ljava/text/SimpleDateFormat;", "getSdf$serviceLibrary_debug", "()Ljava/text/SimpleDateFormat;", "serviceLibrary_debug"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
        
        @org.jetbrains.annotations.Nullable()
        public final org.eclipse.paho.client.mqttv3.internal.ClientComms getClientComms$serviceLibrary_debug() {
            return null;
        }
        
        public final void setClientComms$serviceLibrary_debug(@org.jetbrains.annotations.Nullable()
        org.eclipse.paho.client.mqttv3.internal.ClientComms p0) {
        }
        
        @org.jetbrains.annotations.Nullable()
        public final info.mqtt.android.service.room.MqMessageDatabase getMessageDatabase$serviceLibrary_debug() {
            return null;
        }
        
        public final void setMessageDatabase$serviceLibrary_debug(@org.jetbrains.annotations.Nullable()
        info.mqtt.android.service.room.MqMessageDatabase p0) {
        }
        
        @org.jetbrains.annotations.NotNull()
        public final java.text.SimpleDateFormat getSdf$serviceLibrary_debug() {
            return null;
        }
    }
}