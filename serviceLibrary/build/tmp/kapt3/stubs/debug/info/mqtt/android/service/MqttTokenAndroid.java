package info.mqtt.android.service;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000l\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0015\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0010\t\n\u0000\b\u0010\u0018\u00002\u00020\u0001B3\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\u0010\b\u0002\u0010\b\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\t\u00a2\u0006\u0002\u0010\u000bJ\n\u0010\u0016\u001a\u0004\u0018\u00010\u0007H\u0016J\b\u0010\u0017\u001a\u00020\u0018H\u0016J\n\u0010\u0019\u001a\u0004\u0018\u00010\u0010H\u0016J\b\u0010\u001a\u001a\u00020\u001bH\u0016J\b\u0010\u001c\u001a\u00020\u001dH\u0016J\b\u0010\u001e\u001a\u00020\u001fH\u0016J\b\u0010 \u001a\u00020\u000eH\u0016J\u0015\u0010!\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\tH\u0016\u00a2\u0006\u0002\u0010\"J\n\u0010#\u001a\u0004\u0018\u00010\u0005H\u0016J\b\u0010\r\u001a\u00020\u000eH\u0016J\u0006\u0010$\u001a\u00020%J\u000e\u0010&\u001a\u00020%2\u0006\u0010\'\u001a\u00020\u0014J\u0010\u0010(\u001a\u00020%2\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\u0010\u0010)\u001a\u00020%2\b\u0010\f\u001a\u0004\u0018\u00010\u0001J\u0010\u0010*\u001a\u00020%2\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\b\u0010+\u001a\u00020%H\u0016J\u0010\u0010+\u001a\u00020%2\u0006\u0010,\u001a\u00020-H\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\u0001X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0014X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0018\u0010\b\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\tX\u0082\u0004\u00a2\u0006\u0004\n\u0002\u0010\u0015R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006."}, d2 = {"Linfo/mqtt/android/service/MqttTokenAndroid;", "Lorg/eclipse/paho/client/mqttv3/IMqttToken;", "client", "Linfo/mqtt/android/service/MqttAndroidClient;", "userContext", "", "listener", "Lorg/eclipse/paho/client/mqttv3/IMqttActionListener;", "topics", "", "", "(Linfo/mqtt/android/service/MqttAndroidClient;Ljava/lang/Object;Lorg/eclipse/paho/client/mqttv3/IMqttActionListener;[Ljava/lang/String;)V", "delegate", "isComplete", "", "lastException", "Lorg/eclipse/paho/client/mqttv3/MqttException;", "lock", "Ljava/lang/Object;", "pendingException", "", "[Ljava/lang/String;", "getActionCallback", "getClient", "Lorg/eclipse/paho/client/mqttv3/IMqttAsyncClient;", "getException", "getGrantedQos", "", "getMessageId", "", "getResponse", "Lorg/eclipse/paho/client/mqttv3/internal/wire/MqttWireMessage;", "getSessionPresent", "getTopics", "()[Ljava/lang/String;", "getUserContext", "notifyComplete", "", "notifyFailure", "throwable", "setActionCallback", "setDelegate", "setUserContext", "waitForCompletion", "timeout", "", "serviceLibrary_debug"})
public class MqttTokenAndroid implements org.eclipse.paho.client.mqttv3.IMqttToken {
    @org.jetbrains.annotations.NotNull()
    private final info.mqtt.android.service.MqttAndroidClient client = null;
    @org.jetbrains.annotations.Nullable()
    private java.lang.Object userContext;
    @org.jetbrains.annotations.Nullable()
    private org.eclipse.paho.client.mqttv3.IMqttActionListener listener;
    @org.jetbrains.annotations.Nullable()
    private final java.lang.String[] topics = null;
    @kotlin.jvm.Volatile()
    private volatile boolean isComplete = false;
    @kotlin.jvm.Volatile()
    @org.jetbrains.annotations.Nullable()
    private volatile org.eclipse.paho.client.mqttv3.MqttException lastException;
    @org.jetbrains.annotations.NotNull()
    private final java.lang.Object lock = null;
    @org.jetbrains.annotations.Nullable()
    private org.eclipse.paho.client.mqttv3.IMqttToken delegate;
    @org.jetbrains.annotations.Nullable()
    private java.lang.Throwable pendingException;
    
    public MqttTokenAndroid(@org.jetbrains.annotations.NotNull()
    info.mqtt.android.service.MqttAndroidClient client, @org.jetbrains.annotations.Nullable()
    java.lang.Object userContext, @org.jetbrains.annotations.Nullable()
    org.eclipse.paho.client.mqttv3.IMqttActionListener listener, @org.jetbrains.annotations.Nullable()
    java.lang.String[] topics) {
        super();
    }
    
    @java.lang.Override()
    @kotlin.jvm.Throws(exceptionClasses = {org.eclipse.paho.client.mqttv3.MqttException.class})
    public void waitForCompletion() throws org.eclipse.paho.client.mqttv3.MqttException {
    }
    
    @java.lang.Override()
    @kotlin.jvm.Throws(exceptionClasses = {org.eclipse.paho.client.mqttv3.MqttException.class})
    public void waitForCompletion(long timeout) throws org.eclipse.paho.client.mqttv3.MqttException {
    }
    
    public final void notifyComplete() {
    }
    
    public final void notifyFailure(@org.jetbrains.annotations.NotNull()
    java.lang.Throwable throwable) {
    }
    
    @java.lang.Override()
    public boolean isComplete() {
        return false;
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.Nullable()
    public org.eclipse.paho.client.mqttv3.MqttException getException() {
        return null;
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.NotNull()
    public org.eclipse.paho.client.mqttv3.IMqttAsyncClient getClient() {
        return null;
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.Nullable()
    public org.eclipse.paho.client.mqttv3.IMqttActionListener getActionCallback() {
        return null;
    }
    
    @java.lang.Override()
    public void setActionCallback(@org.jetbrains.annotations.NotNull()
    org.eclipse.paho.client.mqttv3.IMqttActionListener listener) {
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.Nullable()
    public java.lang.String[] getTopics() {
        return null;
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.Nullable()
    public java.lang.Object getUserContext() {
        return null;
    }
    
    @java.lang.Override()
    public void setUserContext(@org.jetbrains.annotations.NotNull()
    java.lang.Object userContext) {
    }
    
    public final void setDelegate(@org.jetbrains.annotations.Nullable()
    org.eclipse.paho.client.mqttv3.IMqttToken delegate) {
    }
    
    @java.lang.Override()
    public int getMessageId() {
        return 0;
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.NotNull()
    public org.eclipse.paho.client.mqttv3.internal.wire.MqttWireMessage getResponse() {
        return null;
    }
    
    @java.lang.Override()
    public boolean getSessionPresent() {
        return false;
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.NotNull()
    public int[] getGrantedQos() {
        return null;
    }
}