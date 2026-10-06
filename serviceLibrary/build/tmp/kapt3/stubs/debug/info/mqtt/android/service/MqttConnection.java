package info.mqtt.android.service;

/**
 * MqttConnection holds a MqttAsyncClient {host,port,clientId} instance to perform
 * MQTT operations to MQTT broker.
 *
 * Most of the major API here is intended to implement the most general forms of
 * the methods in IMqttAsyncClient, with slight adjustments for the Android
 * environment<br></br>
 * These adjustments usually consist of adding two parameters to each method :-
 *
 * * invocationContext - a string passed from the application to identify the
 * context of the operation (mainly included for support of the javascript API
 * implementation)
 * * activityToken - a string passed from the Activity to relate back to a
 * callback method or other context-specific data
 *
 * Operations are very much asynchronous, so success and failure are notified by
 * packing the relevant data into Intent objects which are broadcast back to the
 * Activity via the MqttService.callbackToActivity() method.
 *
 * Constructor - create an MqttConnection to communicate with MQTT server
 *
 * @param service      our "parent" service - we make callbacks to it
 * @param serverURI    the URI of the MQTT server to which we will connect
 * @param clientId     the name by which we will identify ourselves to the MQTT
 * server
 * @param persistence  the persistence class to use to store in-flight message. If
 * null then the default persistence mechanism is used
 * @param clientHandle the "handle" by which the activity will identify us
 */
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\u00ca\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\t\n\u0002\u0010\u0003\n\u0002\b\u0007\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0015\n\u0002\b\u0006\b\u0000\u0018\u0000 u2\u00020\u0001:\u0002uvB?\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\u0006\u0010\t\u001a\u00020\u0005\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\f\u001a\u00020\r\u00a2\u0006\u0002\u0010\u000eJ\b\u0010:\u001a\u00020;H\u0002J\u0006\u0010<\u001a\u00020;J$\u0010=\u001a\u00020;2\b\u0010>\u001a\u0004\u0018\u00010\u001c2\b\u0010?\u001a\u0004\u0018\u00010\u00052\b\u0010@\u001a\u0004\u0018\u000103J\u0018\u0010A\u001a\u00020;2\u0006\u0010B\u001a\u00020\u000b2\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0012\u0010C\u001a\u00020;2\b\u0010D\u001a\u0004\u0018\u00010EH\u0016J\u000e\u0010F\u001a\u00020;2\u0006\u0010G\u001a\u00020\rJ\b\u0010H\u001a\u00020;H\u0002J\u0010\u0010I\u001a\u00020;2\u0006\u0010J\u001a\u00020\'H\u0016J \u0010K\u001a\u00020;2\u0006\u0010L\u001a\u00020M2\b\u0010?\u001a\u0004\u0018\u00010\u00052\u0006\u0010@\u001a\u000203J\u001a\u0010K\u001a\u00020;2\b\u0010?\u001a\u0004\u0018\u00010\u00052\b\u0010@\u001a\u0004\u0018\u000103J\u0010\u0010N\u001a\u00020;2\u0006\u0010O\u001a\u00020PH\u0002J\u0010\u0010Q\u001a\u00020;2\u0006\u0010O\u001a\u00020PH\u0002J\u000e\u0010R\u001a\u00020*2\u0006\u0010G\u001a\u00020\rJ\u001c\u0010S\u001a\u00020;2\u0006\u0010O\u001a\u00020P2\n\u0010T\u001a\u00060Uj\u0002`VH\u0002J\u0018\u0010W\u001a\u00020;2\u0006\u0010X\u001a\u00020\u00052\u0006\u0010Y\u001a\u00020*H\u0016J$\u0010Z\u001a\u00020P2\b\u0010[\u001a\u0004\u0018\u00010\u00052\b\u0010X\u001a\u0004\u0018\u00010\u00052\u0006\u0010Y\u001a\u00020*H\u0002J\u0006\u0010\\\u001a\u00020;J\u0012\u0010]\u001a\u0004\u0018\u00010P2\u0006\u0010J\u001a\u00020\'H\u0002J<\u0010^\u001a\u0004\u0018\u00010\'2\u0006\u0010X\u001a\u00020\u00052\b\u0010_\u001a\u0004\u0018\u00010`2\u0006\u0010a\u001a\u00020b2\u0006\u0010c\u001a\u00020\u000b2\b\u0010?\u001a\u0004\u0018\u00010\u00052\u0006\u0010@\u001a\u000203J*\u0010^\u001a\u0004\u0018\u00010\'2\u0006\u0010X\u001a\u00020\u00052\u0006\u0010Y\u001a\u00020*2\b\u0010?\u001a\u0004\u0018\u00010\u00052\u0006\u0010@\u001a\u000203J\u000e\u0010B\u001a\u00020;2\u0006\u0010d\u001a\u00020eJ\b\u0010f\u001a\u00020;H\u0002J\u0010\u0010g\u001a\u00020;2\b\u0010h\u001a\u0004\u0018\u00010\u001fJ\u0010\u0010i\u001a\u00020;2\u0006\u0010$\u001a\u00020\u000bH\u0002J4\u0010j\u001a\u00020;2\u0006\u0010X\u001a\u00020\u00052\u0006\u0010k\u001a\u00020*2\b\u0010J\u001a\u0004\u0018\u00010\'2\b\u0010?\u001a\u0004\u0018\u00010\u00052\u0006\u0010@\u001a\u000203H\u0002JI\u0010l\u001a\u00020;2\f\u0010m\u001a\b\u0012\u0004\u0012\u00020\u00050/2\f\u0010a\u001a\b\u0012\u0004\u0012\u00020b0/2\b\u0010?\u001a\u0004\u0018\u00010\u00052\u0006\u0010@\u001a\u0002032\u000e\u0010n\u001a\n\u0012\u0004\u0012\u00020o\u0018\u00010/\u00a2\u0006\u0002\u0010pJ5\u0010l\u001a\u00020;2\f\u0010X\u001a\b\u0012\u0004\u0012\u00020\u00050/2\b\u0010a\u001a\u0004\u0018\u00010q2\b\u0010?\u001a\u0004\u0018\u00010\u00052\u0006\u0010@\u001a\u000203\u00a2\u0006\u0002\u0010rJ(\u0010l\u001a\u00020;2\u0006\u0010X\u001a\u00020\u00052\u0006\u0010a\u001a\u00020b2\b\u0010?\u001a\u0004\u0018\u00010\u00052\u0006\u0010@\u001a\u000203J+\u0010s\u001a\u00020;2\f\u0010X\u001a\b\u0012\u0004\u0012\u00020\u00050/2\b\u0010?\u001a\u0004\u0018\u00010\u00052\u0006\u0010@\u001a\u000203\u00a2\u0006\u0002\u0010tJ \u0010s\u001a\u00020;2\u0006\u0010X\u001a\u00020\u00052\b\u0010?\u001a\u0004\u0018\u00010\u00052\u0006\u0010@\u001a\u000203R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0011\u0010\u0011\u001a\u00020\r8F\u00a2\u0006\u0006\u001a\u0004\b\u0012\u0010\u0013R\u000e\u0010\u0014\u001a\u00020\u000bX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001a\u0010\t\u001a\u00020\u0005X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\u001a\u0010\u0006\u001a\u00020\u0005X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u0016\"\u0004\b\u001a\u0010\u0018R\u0010\u0010\u001b\u001a\u0004\u0018\u00010\u001cX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u000bX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u001e\u001a\u0004\u0018\u00010\u001fX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0011\u0010 \u001a\u00020\r8F\u00a2\u0006\u0006\u001a\u0004\b!\u0010\u0013R\u0011\u0010\"\u001a\u00020\u000b8F\u00a2\u0006\u0006\u001a\u0004\b\"\u0010#R\u000e\u0010$\u001a\u00020\u000bX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001c\u0010%\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010\'\u0012\u0004\u0012\u00020\u00050&X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001c\u0010(\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010\'\u0012\u0004\u0012\u00020\u00050&X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001c\u0010)\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010\'\u0012\u0004\u0012\u00020*0&X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001c\u0010+\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010\'\u0012\u0004\u0012\u00020\u00050&X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010,\u001a\u0004\u0018\u00010-X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0017\u0010.\u001a\b\u0012\u0004\u0012\u00020\'0/8F\u00a2\u0006\u0006\u001a\u0004\b0\u00101R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u00102\u001a\u0004\u0018\u000103X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b4\u0010\u0016\"\u0004\b5\u0010\u0018R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u00106\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u00107\u001a\b\u0018\u000108R\u000209X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006w"}, d2 = {"Linfo/mqtt/android/service/MqttConnection;", "Lorg/eclipse/paho/client/mqttv3/MqttCallbackExtended;", "service", "Linfo/mqtt/android/service/MqttService;", "serverURI", "", "clientId", "persistence", "Lorg/eclipse/paho/client/mqttv3/MqttClientPersistence;", "clientHandle", "pingLogging", "", "keepPingRecords", "", "(Linfo/mqtt/android/service/MqttService;Ljava/lang/String;Ljava/lang/String;Lorg/eclipse/paho/client/mqttv3/MqttClientPersistence;Ljava/lang/String;ZI)V", "alarmPingSender", "Linfo/mqtt/android/service/ping/AlarmPingSender;", "bufferedMessageCount", "getBufferedMessageCount", "()I", "cleanSession", "getClientHandle", "()Ljava/lang/String;", "setClientHandle", "(Ljava/lang/String;)V", "getClientId", "setClientId", "connectOptions", "Lorg/eclipse/paho/client/mqttv3/MqttConnectOptions;", "disconnected", "disconnectedBufferOptions", "Lorg/eclipse/paho/client/mqttv3/DisconnectedBufferOptions;", "inFlightMessageCount", "getInFlightMessageCount", "isConnected", "()Z", "isConnecting", "mapActivityTokens", "", "Lorg/eclipse/paho/client/mqttv3/IMqttDeliveryToken;", "mapInvocationContexts", "mapSentMessages", "Lorg/eclipse/paho/client/mqttv3/MqttMessage;", "mapTopics", "myClient", "Lorg/eclipse/paho/client/mqttv3/MqttAsyncClient;", "pendingDeliveryTokens", "", "getPendingDeliveryTokens", "()[Lorg/eclipse/paho/client/mqttv3/IMqttDeliveryToken;", "reconnectActivityToken", "Lorg/eclipse/paho/client/mqttv3/IMqttToken;", "getServerURI", "setServerURI", "wakeLockTag", "wakelock", "Landroid/os/PowerManager$WakeLock;", "Landroid/os/PowerManager;", "acquireWakeLock", "", "close", "connect", "options", "invocationContext", "activityToken", "connectComplete", "reconnect", "connectionLost", "why", "", "deleteBufferedMessage", "bufferIndex", "deliverBacklog", "deliveryComplete", "messageToken", "disconnect", "quiesceTimeout", "", "doAfterConnectFail", "resultBundle", "Landroid/os/Bundle;", "doAfterConnectSuccess", "getBufferedMessage", "handleException", "e", "Ljava/lang/Exception;", "Lkotlin/Exception;", "messageArrived", "topic", "message", "messageToBundle", "messageId", "offline", "popSendDetails", "publish", "payload", "", "qos", "Linfo/mqtt/android/service/QoS;", "retained", "context", "Landroid/content/Context;", "releaseWakeLock", "setBufferOpts", "bufferOpts", "setConnectingState", "storeSendDetailsInMemory", "msg", "subscribe", "topicFilters", "messageListeners", "Lorg/eclipse/paho/client/mqttv3/IMqttMessageListener;", "([Ljava/lang/String;[Linfo/mqtt/android/service/QoS;Ljava/lang/String;Lorg/eclipse/paho/client/mqttv3/IMqttToken;[Lorg/eclipse/paho/client/mqttv3/IMqttMessageListener;)V", "", "([Ljava/lang/String;[ILjava/lang/String;Lorg/eclipse/paho/client/mqttv3/IMqttToken;)V", "unsubscribe", "([Ljava/lang/String;Ljava/lang/String;Lorg/eclipse/paho/client/mqttv3/IMqttToken;)V", "Companion", "MqttConnectionListener", "serviceLibrary_debug"})
public final class MqttConnection implements org.eclipse.paho.client.mqttv3.MqttCallbackExtended {
    @org.jetbrains.annotations.NotNull()
    private final info.mqtt.android.service.MqttService service = null;
    @org.jetbrains.annotations.NotNull()
    private java.lang.String serverURI;
    @org.jetbrains.annotations.NotNull()
    private java.lang.String clientId;
    @org.jetbrains.annotations.Nullable()
    private org.eclipse.paho.client.mqttv3.MqttClientPersistence persistence;
    @org.jetbrains.annotations.NotNull()
    private java.lang.String clientHandle;
    private final boolean pingLogging = false;
    private final int keepPingRecords = 0;
    @org.jetbrains.annotations.NotNull()
    private final java.util.Map<org.eclipse.paho.client.mqttv3.IMqttDeliveryToken, java.lang.String> mapTopics = null;
    @org.jetbrains.annotations.NotNull()
    private final java.util.Map<org.eclipse.paho.client.mqttv3.IMqttDeliveryToken, org.eclipse.paho.client.mqttv3.MqttMessage> mapSentMessages = null;
    @org.jetbrains.annotations.NotNull()
    private final java.util.Map<org.eclipse.paho.client.mqttv3.IMqttDeliveryToken, java.lang.String> mapActivityTokens = null;
    @org.jetbrains.annotations.NotNull()
    private final java.util.Map<org.eclipse.paho.client.mqttv3.IMqttDeliveryToken, java.lang.String> mapInvocationContexts = null;
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String wakeLockTag = null;
    @org.jetbrains.annotations.Nullable()
    private org.eclipse.paho.client.mqttv3.MqttConnectOptions connectOptions;
    @org.jetbrains.annotations.Nullable()
    private org.eclipse.paho.client.mqttv3.IMqttToken reconnectActivityToken;
    @org.jetbrains.annotations.Nullable()
    private org.eclipse.paho.client.mqttv3.MqttAsyncClient myClient;
    @org.jetbrains.annotations.Nullable()
    private info.mqtt.android.service.ping.AlarmPingSender alarmPingSender;
    @kotlin.jvm.Volatile()
    private volatile boolean disconnected = true;
    private boolean cleanSession = true;
    @kotlin.jvm.Volatile()
    private volatile boolean isConnecting = false;
    @org.jetbrains.annotations.Nullable()
    private android.os.PowerManager.WakeLock wakelock;
    @org.jetbrains.annotations.Nullable()
    private org.eclipse.paho.client.mqttv3.DisconnectedBufferOptions disconnectedBufferOptions;
    @org.jetbrains.annotations.NotNull()
    private static final java.lang.String TEMP = "MqttConnection";
    @org.jetbrains.annotations.NotNull()
    private static final java.lang.String NOT_CONNECTED = "not connected";
    @org.jetbrains.annotations.NotNull()
    public static final info.mqtt.android.service.MqttConnection.Companion Companion = null;
    
    public MqttConnection(@org.jetbrains.annotations.NotNull()
    info.mqtt.android.service.MqttService service, @org.jetbrains.annotations.NotNull()
    java.lang.String serverURI, @org.jetbrains.annotations.NotNull()
    java.lang.String clientId, @org.jetbrains.annotations.Nullable()
    org.eclipse.paho.client.mqttv3.MqttClientPersistence persistence, @org.jetbrains.annotations.NotNull()
    java.lang.String clientHandle, boolean pingLogging, int keepPingRecords) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getServerURI() {
        return null;
    }
    
    public final void setServerURI(@org.jetbrains.annotations.NotNull()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getClientId() {
        return null;
    }
    
    public final void setClientId(@org.jetbrains.annotations.NotNull()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getClientHandle() {
        return null;
    }
    
    public final void setClientHandle(@org.jetbrains.annotations.NotNull()
    java.lang.String p0) {
    }
    
    /**
     * Connect to the server specified when we were instantiated
     *
     * @param options           timeout, etc
     * @param invocationContext arbitrary data to be passed back to the application
     * @param activityToken     arbitrary identifier to be passed back to the Activity
     */
    public final void connect(@org.jetbrains.annotations.Nullable()
    org.eclipse.paho.client.mqttv3.MqttConnectOptions options, @org.jetbrains.annotations.Nullable()
    java.lang.String invocationContext, @org.jetbrains.annotations.Nullable()
    org.eclipse.paho.client.mqttv3.IMqttToken activityToken) {
    }
    
    private final void doAfterConnectSuccess(android.os.Bundle resultBundle) {
    }
    
    @java.lang.Override()
    public void connectComplete(boolean reconnect, @org.jetbrains.annotations.NotNull()
    java.lang.String serverURI) {
    }
    
    private final void doAfterConnectFail(android.os.Bundle resultBundle) {
    }
    
    private final void handleException(android.os.Bundle resultBundle, java.lang.Exception e) {
    }
    
    /**
     * Attempt to deliver any outstanding messages we've received but which the
     * application hasn't acknowledged. If "cleanSession" was specified, we'll
     * have already purged any such messages from our messageStore.
     */
    private final void deliverBacklog() {
    }
    
    /**
     * Create a bundle containing all relevant data pertaining to a message
     *
     * @param messageId the message's identifier in the messageStore, so that a
     * callback can be made to remove it once delivered
     * @param topic     the topic on which the message was delivered
     * @param message   the message itself
     * @return the bundle
     */
    private final android.os.Bundle messageToBundle(java.lang.String messageId, java.lang.String topic, org.eclipse.paho.client.mqttv3.MqttMessage message) {
        return null;
    }
    
    /**
     * Close connection from the server
     */
    public final void close() {
    }
    
    /**
     * Disconnect from the server
     *
     * @param quiesceTimeout    in milliseconds
     * @param invocationContext arbitrary data to be passed back to the application
     * @param activityToken     arbitrary string to be passed back to the activity
     */
    public final void disconnect(long quiesceTimeout, @org.jetbrains.annotations.Nullable()
    java.lang.String invocationContext, @org.jetbrains.annotations.NotNull()
    org.eclipse.paho.client.mqttv3.IMqttToken activityToken) {
    }
    
    /**
     * Disconnect from the server
     *
     * @param invocationContext arbitrary data to be passed back to the application
     * @param activityToken     arbitrary string to be passed back to the activity
     */
    public final void disconnect(@org.jetbrains.annotations.Nullable()
    java.lang.String invocationContext, @org.jetbrains.annotations.Nullable()
    org.eclipse.paho.client.mqttv3.IMqttToken activityToken) {
    }
    
    public final boolean isConnected() {
        return false;
    }
    
    /**
     * Publish a message on a topic
     *
     * @param topic             the topic on which to publish - represented as a string, not
     * an MqttTopic object
     * @param payload           the content of the message to publish
     * @param qos               the quality of service requested
     * @param retained          whether the MQTT server should retain this message
     * @param invocationContext arbitrary data to be passed back to the application
     * @param activityToken     arbitrary string to be passed back to the activity
     * @return token for tracking the operation
     */
    @org.jetbrains.annotations.Nullable()
    public final org.eclipse.paho.client.mqttv3.IMqttDeliveryToken publish(@org.jetbrains.annotations.NotNull()
    java.lang.String topic, @org.jetbrains.annotations.Nullable()
    byte[] payload, @org.jetbrains.annotations.NotNull()
    info.mqtt.android.service.QoS qos, boolean retained, @org.jetbrains.annotations.Nullable()
    java.lang.String invocationContext, @org.jetbrains.annotations.NotNull()
    org.eclipse.paho.client.mqttv3.IMqttToken activityToken) {
        return null;
    }
    
    /**
     * Publish a message on a topic
     *
     * @param topic             the topic on which to publish - represented as a string, not
     * an MqttTopic object
     * @param message           the message to publish
     * @param invocationContext arbitrary data to be passed back to the application
     * @param activityToken     arbitrary string to be passed back to the activity
     * @return token for tracking the operation
     */
    @org.jetbrains.annotations.Nullable()
    public final org.eclipse.paho.client.mqttv3.IMqttDeliveryToken publish(@org.jetbrains.annotations.NotNull()
    java.lang.String topic, @org.jetbrains.annotations.NotNull()
    org.eclipse.paho.client.mqttv3.MqttMessage message, @org.jetbrains.annotations.Nullable()
    java.lang.String invocationContext, @org.jetbrains.annotations.NotNull()
    org.eclipse.paho.client.mqttv3.IMqttToken activityToken) {
        return null;
    }
    
    /**
     * Subscribe to a topic
     *
     * @param topic             a possibly wildcard topic name
     * @param qos               requested quality of service for the topic
     * @param invocationContext arbitrary data to be passed back to the application
     * @param activityToken     arbitrary identifier to be passed back to the Activity
     */
    public final void subscribe(@org.jetbrains.annotations.NotNull()
    java.lang.String topic, @org.jetbrains.annotations.NotNull()
    info.mqtt.android.service.QoS qos, @org.jetbrains.annotations.Nullable()
    java.lang.String invocationContext, @org.jetbrains.annotations.NotNull()
    org.eclipse.paho.client.mqttv3.IMqttToken activityToken) {
    }
    
    /**
     * Subscribe to one or more topics
     *
     * @param topic             a list of possibly wildcard topic names
     * @param qos               requested quality of service for each topic
     * @param invocationContext arbitrary data to be passed back to the application
     * @param activityToken     arbitrary identifier to be passed back to the Activity
     */
    public final void subscribe(@org.jetbrains.annotations.NotNull()
    java.lang.String[] topic, @org.jetbrains.annotations.Nullable()
    int[] qos, @org.jetbrains.annotations.Nullable()
    java.lang.String invocationContext, @org.jetbrains.annotations.NotNull()
    org.eclipse.paho.client.mqttv3.IMqttToken activityToken) {
    }
    
    public final void subscribe(@org.jetbrains.annotations.NotNull()
    java.lang.String[] topicFilters, @org.jetbrains.annotations.NotNull()
    info.mqtt.android.service.QoS[] qos, @org.jetbrains.annotations.Nullable()
    java.lang.String invocationContext, @org.jetbrains.annotations.NotNull()
    org.eclipse.paho.client.mqttv3.IMqttToken activityToken, @org.jetbrains.annotations.Nullable()
    org.eclipse.paho.client.mqttv3.IMqttMessageListener[] messageListeners) {
    }
    
    /**
     * Unsubscribe from a topic
     *
     * @param topic             a possibly wildcard topic name
     * @param invocationContext arbitrary data to be passed back to the application
     * @param activityToken     arbitrary identifier to be passed back to the Activity
     */
    public final void unsubscribe(@org.jetbrains.annotations.NotNull()
    java.lang.String topic, @org.jetbrains.annotations.Nullable()
    java.lang.String invocationContext, @org.jetbrains.annotations.NotNull()
    org.eclipse.paho.client.mqttv3.IMqttToken activityToken) {
    }
    
    /**
     * Unsubscribe from one or more topics
     *
     * @param topic             a list of possibly wildcard topic names
     * @param invocationContext arbitrary data to be passed back to the application
     * @param activityToken     arbitrary identifier to be passed back to the Activity
     */
    public final void unsubscribe(@org.jetbrains.annotations.NotNull()
    java.lang.String[] topic, @org.jetbrains.annotations.Nullable()
    java.lang.String invocationContext, @org.jetbrains.annotations.NotNull()
    org.eclipse.paho.client.mqttv3.IMqttToken activityToken) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final org.eclipse.paho.client.mqttv3.IMqttDeliveryToken[] getPendingDeliveryTokens() {
        return null;
    }
    
    /**
     * Callback for connectionLost
     *
     * @param why the exception causing the break in communications
     */
    @java.lang.Override()
    public void connectionLost(@org.jetbrains.annotations.Nullable()
    java.lang.Throwable why) {
    }
    
    /**
     * Callback to indicate a message has been delivered (the exact meaning of
     * "has been delivered" is dependent on the QOS value)
     *
     * @param messageToken the message token provided when the message was originally sent
     */
    @java.lang.Override()
    public void deliveryComplete(@org.jetbrains.annotations.NotNull()
    org.eclipse.paho.client.mqttv3.IMqttDeliveryToken messageToken) {
    }
    
    /**
     * Callback when a message is received
     *
     * @param topic   the topic on which the message was received
     * @param message the message itself
     */
    @java.lang.Override()
    public void messageArrived(@org.jetbrains.annotations.NotNull()
    java.lang.String topic, @org.jetbrains.annotations.NotNull()
    org.eclipse.paho.client.mqttv3.MqttMessage message) {
    }
    
    /**
     * Removed store details of sent messages in "deliveryComplete"
     * callbacks from the mqttClient
     */
    @kotlin.jvm.Synchronized()
    private final synchronized android.os.Bundle popSendDetails(org.eclipse.paho.client.mqttv3.IMqttDeliveryToken messageToken) {
        return null;
    }
    
    /**
     * Store details of sent messages so we can handle "deliveryComplete" callbacks from the mqttClient
     */
    @kotlin.jvm.Synchronized()
    private final synchronized void storeSendDetailsInMemory(java.lang.String topic, org.eclipse.paho.client.mqttv3.MqttMessage msg, org.eclipse.paho.client.mqttv3.IMqttDeliveryToken messageToken, java.lang.String invocationContext, org.eclipse.paho.client.mqttv3.IMqttToken activityToken) {
    }
    
    /**
     * Acquires a partial wake lock for this client
     */
    private final void acquireWakeLock() {
    }
    
    /**
     * Releases the currently held wake lock for this client
     */
    private final void releaseWakeLock() {
    }
    
    /**
     * Receive notification that we are offline<br></br>
     * if cleanSession is true, we need to regard this as a disconnection
     */
    public final void offline() {
    }
    
    /**
     * Reconnect<br></br>
     * Only appropriate if cleanSession is false and we were connected.
     * Declare as synchronized to avoid multiple calls to this method to send connect
     * multiple times
     */
    @kotlin.jvm.Synchronized()
    public final synchronized void reconnect(@org.jetbrains.annotations.NotNull()
    android.content.Context context) {
    }
    
    @kotlin.jvm.Synchronized()
    private final synchronized void setConnectingState(boolean isConnecting) {
    }
    
    /**
     * Sets the DisconnectedBufferOptions for this client
     */
    public final void setBufferOpts(@org.jetbrains.annotations.Nullable()
    org.eclipse.paho.client.mqttv3.DisconnectedBufferOptions bufferOpts) {
    }
    
    public final int getBufferedMessageCount() {
        return 0;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final org.eclipse.paho.client.mqttv3.MqttMessage getBufferedMessage(int bufferIndex) {
        return null;
    }
    
    public final void deleteBufferedMessage(int bufferIndex) {
    }
    
    public final int getInFlightMessageCount() {
        return 0;
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0006"}, d2 = {"Linfo/mqtt/android/service/MqttConnection$Companion;", "", "()V", "NOT_CONNECTED", "", "TEMP", "serviceLibrary_debug"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
    }
    
    /**
     * General-purpose IMqttActionListener for the Client context
     *
     *
     * Simply handles the basic success/failure cases for operations which don't return results
     */
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0002\b\u0092\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u001c\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\b\u0010\t\u001a\u0004\u0018\u00010\nH\u0016J\u0010\u0010\u000b\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\f"}, d2 = {"Linfo/mqtt/android/service/MqttConnection$MqttConnectionListener;", "Lorg/eclipse/paho/client/mqttv3/IMqttActionListener;", "resultBundle", "Landroid/os/Bundle;", "(Linfo/mqtt/android/service/MqttConnection;Landroid/os/Bundle;)V", "onFailure", "", "asyncActionToken", "Lorg/eclipse/paho/client/mqttv3/IMqttToken;", "exception", "", "onSuccess", "serviceLibrary_debug"})
    class MqttConnectionListener implements org.eclipse.paho.client.mqttv3.IMqttActionListener {
        @org.jetbrains.annotations.NotNull()
        private final android.os.Bundle resultBundle = null;
        
        public MqttConnectionListener(@org.jetbrains.annotations.NotNull()
        android.os.Bundle resultBundle) {
            super();
        }
        
        @java.lang.Override()
        public void onSuccess(@org.jetbrains.annotations.NotNull()
        org.eclipse.paho.client.mqttv3.IMqttToken asyncActionToken) {
        }
        
        @java.lang.Override()
        public void onFailure(@org.jetbrains.annotations.Nullable()
        org.eclipse.paho.client.mqttv3.IMqttToken asyncActionToken, @org.jetbrains.annotations.Nullable()
        java.lang.Throwable exception) {
        }
    }
}