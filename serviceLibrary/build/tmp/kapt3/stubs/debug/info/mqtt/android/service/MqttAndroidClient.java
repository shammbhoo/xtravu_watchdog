package info.mqtt.android.service;

/**
 * Enables an android application to communicate with an MQTT server using non-blocking methods.
 *
 * Implementation of the MQTT asynchronous client interface [IMqttAsyncClient] , using the MQTT
 * android service to actually interface with MQTT server. It provides android applications a simple programming interface to all features of the
 * MQTT version 3.1
 * specification including:
 *
 * * connect
 * * publish
 * * subscribe
 * * unsubscribe
 * * disconnect
 */
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\u00e4\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u0012\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0015\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000e\u0018\u0000 \u0085\u00012\u00020\u0001:\u0004\u0085\u0001\u0086\u0001BG\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n\u0012\b\b\u0002\u0010\u000b\u001a\u00020\f\u0012\b\b\u0002\u0010\r\u001a\u00020\u000e\u00a2\u0006\u0002\u0010\u000fJ\u000e\u0010,\u001a\u00020\f2\u0006\u0010-\u001a\u00020\u0005J\u000e\u0010.\u001a\u00020/2\u0006\u00100\u001a\u00020\u0012J\b\u00101\u001a\u00020/H\u0016J\b\u00102\u001a\u00020/H\u0002J\b\u00103\u001a\u00020\u001cH\u0016J\u001c\u00103\u001a\u00020\u001c2\b\u00104\u001a\u0004\u0018\u0001052\b\u00100\u001a\u0004\u0018\u000106H\u0016J\u0010\u00103\u001a\u00020\u001c2\u0006\u00107\u001a\u00020\u0015H\u0016J$\u00103\u001a\u00020\u001c2\u0006\u00107\u001a\u00020\u00152\b\u00104\u001a\u0004\u0018\u0001052\b\u00100\u001a\u0004\u0018\u000106H\u0016J\u0012\u00108\u001a\u00020/2\b\u00109\u001a\u0004\u0018\u00010:H\u0002J\u0012\u0010;\u001a\u00020/2\b\u00109\u001a\u0004\u0018\u00010:H\u0002J\u0012\u0010<\u001a\u00020/2\b\u00109\u001a\u0004\u0018\u00010:H\u0002J\u0010\u0010=\u001a\u00020/2\u0006\u0010>\u001a\u00020\u000eH\u0016J\b\u0010?\u001a\u00020\u001cH\u0016J\u001c\u0010?\u001a\u00020\u001c2\b\u00104\u001a\u0004\u0018\u0001052\b\u00100\u001a\u0004\u0018\u000106H\u0016J\u0010\u0010?\u001a\u00020\u001c2\u0006\u0010@\u001a\u00020AH\u0016J\"\u0010?\u001a\u00020\u001c2\u0006\u0010@\u001a\u00020A2\b\u00104\u001a\u0004\u0018\u0001052\u0006\u00100\u001a\u000206H\u0016J\b\u0010B\u001a\u00020/H\u0016J\u0010\u0010B\u001a\u00020/2\u0006\u0010C\u001a\u00020AH\u0016J\u0018\u0010B\u001a\u00020/2\u0006\u0010@\u001a\u00020A2\u0006\u0010C\u001a\u00020AH\u0016J\u0010\u0010D\u001a\u00020/2\u0006\u00109\u001a\u00020:H\u0002J\u0018\u0010E\u001a\u00020/2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0002J\u0010\u0010F\u001a\u00020G2\u0006\u0010>\u001a\u00020\u000eH\u0016J\b\u0010H\u001a\u00020\u000eH\u0016J\b\u0010I\u001a\u00020\u0005H\u0016J\b\u0010J\u001a\u00020\u000eH\u0016J\u0012\u0010K\u001a\u0004\u0018\u00010\u001c2\u0006\u00109\u001a\u00020:H\u0002J\u0013\u0010L\u001a\b\u0012\u0004\u0012\u00020N0MH\u0016\u00a2\u0006\u0002\u0010OJ\u0018\u0010P\u001a\u00020Q2\b\u0010R\u001a\u0004\u0018\u00010S2\u0006\u0010T\u001a\u00020\u0005J\b\u0010U\u001a\u00020\u0005H\u0016J\b\u0010V\u001a\u00020\fH\u0016J\u0012\u0010W\u001a\u00020/2\b\u00109\u001a\u0004\u0018\u00010:H\u0002J\u0018\u0010X\u001a\u00020/2\u0006\u0010-\u001a\u00020\u000e2\u0006\u0010Y\u001a\u00020\u000eH\u0016J\u0010\u0010Z\u001a\u00020/2\u0006\u00109\u001a\u00020:H\u0002J\u0010\u0010[\u001a\u00020/2\u0006\u00109\u001a\u00020:H\u0002J(\u0010\\\u001a\u00020N2\u0006\u0010]\u001a\u00020\u00052\u0006\u0010^\u001a\u00020_2\u0006\u0010Y\u001a\u00020\u000e2\u0006\u0010`\u001a\u00020\fH\u0016J<\u0010\\\u001a\u00020N2\u0006\u0010]\u001a\u00020\u00052\u0006\u0010^\u001a\u00020_2\u0006\u0010Y\u001a\u00020\u000e2\u0006\u0010`\u001a\u00020\f2\b\u00104\u001a\u0004\u0018\u0001052\b\u00100\u001a\u0004\u0018\u000106H\u0016J\u0018\u0010\\\u001a\u00020N2\u0006\u0010]\u001a\u00020\u00052\u0006\u0010a\u001a\u00020GH\u0016J,\u0010\\\u001a\u00020N2\u0006\u0010]\u001a\u00020\u00052\u0006\u0010a\u001a\u00020G2\b\u00104\u001a\u0004\u0018\u0001052\b\u00100\u001a\u0004\u0018\u000106H\u0016J\b\u0010b\u001a\u00020/H\u0016J\u0006\u0010c\u001a\u00020/J\u000e\u0010d\u001a\u00020/2\u0006\u00100\u001a\u00020\u0012J\u0010\u0010e\u001a\u00020\f2\u0006\u0010f\u001a\u00020NH\u0016J\u0012\u0010g\u001a\u0004\u0018\u00010\u001c2\u0006\u00109\u001a\u00020:H\u0002J\u0010\u0010h\u001a\u00020/2\u0006\u00109\u001a\u00020:H\u0002J\u0010\u0010i\u001a\u00020/2\u0006\u0010j\u001a\u00020kH\u0016J\u0010\u0010l\u001a\u00020/2\u0006\u00100\u001a\u00020\u0012H\u0016J\u0010\u0010m\u001a\u00020/2\u0006\u0010n\u001a\u00020\fH\u0016J\u0010\u0010o\u001a\u00020/2\b\u0010)\u001a\u0004\u0018\u00010*J\u000e\u0010p\u001a\u00020/2\u0006\u0010+\u001a\u00020\fJ\u001a\u0010q\u001a\u00020/2\b\u0010f\u001a\u0004\u0018\u00010\u001c2\u0006\u00109\u001a\u00020:H\u0002J\u0012\u0010r\u001a\u00020/2\b\u0010f\u001a\u0004\u0018\u00010\u001cH\u0002J#\u0010s\u001a\u00020\u001c2\f\u0010]\u001a\b\u0012\u0004\u0012\u00020\u00050M2\u0006\u0010Y\u001a\u00020tH\u0016\u00a2\u0006\u0002\u0010uJ7\u0010s\u001a\u00020\u001c2\f\u0010]\u001a\b\u0012\u0004\u0012\u00020\u00050M2\u0006\u0010Y\u001a\u00020t2\b\u00104\u001a\u0004\u0018\u0001052\b\u00100\u001a\u0004\u0018\u000106H\u0016\u00a2\u0006\u0002\u0010vJE\u0010s\u001a\u00020\u001c2\f\u0010w\u001a\b\u0012\u0004\u0012\u00020\u00050M2\u0006\u0010Y\u001a\u00020t2\b\u00104\u001a\u0004\u0018\u0001052\b\u00100\u001a\u0004\u0018\u0001062\f\u0010x\u001a\b\u0012\u0004\u0012\u00020y0MH\u0016\u00a2\u0006\u0002\u0010zJ1\u0010s\u001a\u00020\u001c2\f\u0010w\u001a\b\u0012\u0004\u0012\u00020\u00050M2\u0006\u0010Y\u001a\u00020t2\f\u0010x\u001a\b\u0012\u0004\u0012\u00020y0MH\u0016\u00a2\u0006\u0002\u0010{J\u0018\u0010s\u001a\u00020\u001c2\u0006\u0010]\u001a\u00020\u00052\u0006\u0010Y\u001a\u00020\u000eH\u0016J,\u0010s\u001a\u00020\u001c2\u0006\u0010]\u001a\u00020\u00052\u0006\u0010Y\u001a\u00020\u000e2\b\u00104\u001a\u0004\u0018\u0001052\b\u00100\u001a\u0004\u0018\u000106H\u0016J4\u0010s\u001a\u00020\u001c2\u0006\u0010|\u001a\u00020\u00052\u0006\u0010Y\u001a\u00020\u000e2\b\u00104\u001a\u0004\u0018\u0001052\b\u00100\u001a\u0004\u0018\u0001062\u0006\u0010}\u001a\u00020yH\u0016J \u0010s\u001a\u00020\u001c2\u0006\u0010|\u001a\u00020\u00052\u0006\u0010Y\u001a\u00020\u000e2\u0006\u0010}\u001a\u00020yH\u0016J\u0010\u0010~\u001a\u00020/2\u0006\u00109\u001a\u00020:H\u0002J\u0012\u0010\u007f\u001a\u00020/2\b\u00109\u001a\u0004\u0018\u00010:H\u0002J\u0011\u0010\u0080\u0001\u001a\u00020/2\u0006\u00109\u001a\u00020:H\u0002J\u0007\u0010\u0081\u0001\u001a\u00020/J\u001d\u0010\u0082\u0001\u001a\u00020\u001c2\f\u0010]\u001a\b\u0012\u0004\u0012\u00020\u00050MH\u0016\u00a2\u0006\u0003\u0010\u0083\u0001J1\u0010\u0082\u0001\u001a\u00020\u001c2\f\u0010]\u001a\b\u0012\u0004\u0012\u00020\u00050M2\b\u00104\u001a\u0004\u0018\u0001052\b\u00100\u001a\u0004\u0018\u000106H\u0016\u00a2\u0006\u0003\u0010\u0084\u0001J\u0011\u0010\u0082\u0001\u001a\u00020\u001c2\u0006\u0010]\u001a\u00020\u0005H\u0016J%\u0010\u0082\u0001\u001a\u00020\u001c2\u0006\u0010]\u001a\u00020\u00052\b\u00104\u001a\u0004\u0018\u0001052\b\u00100\u001a\u0004\u0018\u000106H\u0016R\u001e\u0010\u0010\u001a\u0012\u0012\u0004\u0012\u00020\u00120\u0011j\b\u0012\u0004\u0012\u00020\u0012`\u0013X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u0015X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0016\u001a\u0004\u0018\u00010\u0005X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0017\u001a\u0004\u0018\u00010\u0018X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0019\u001a\u0004\u0018\u00010\u001aX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u001b\u001a\u0004\u0018\u00010\u001cX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001eR\u000e\u0010\r\u001a\u00020\u000eX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020\bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010 \u001a\u0004\u0018\u00010!X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\"\u001a\u00020#X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010$\u001a\u00020\fX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0012\u0010%\u001a\u00060&R\u00020\u0000X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\'\u001a\b\u0012\u0004\u0012\u00020\u001c0(X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010)\u001a\u0004\u0018\u00010*X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010+\u001a\u00020\fX\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0087\u0001"}, d2 = {"Linfo/mqtt/android/service/MqttAndroidClient;", "Lorg/eclipse/paho/client/mqttv3/IMqttAsyncClient;", "context", "Landroid/content/Context;", "serverURI", "", "clientId", "ackType", "Linfo/mqtt/android/service/Ack;", "persistence", "Lorg/eclipse/paho/client/mqttv3/MqttClientPersistence;", "pingLogging", "", "keepPingRecords", "", "(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;Linfo/mqtt/android/service/Ack;Lorg/eclipse/paho/client/mqttv3/MqttClientPersistence;ZI)V", "callbacksList", "Ljava/util/ArrayList;", "Lorg/eclipse/paho/client/mqttv3/MqttCallback;", "Lkotlin/collections/ArrayList;", "clientConnectOptions", "Lorg/eclipse/paho/client/mqttv3/MqttConnectOptions;", "clientHandle", "clientJob", "Lkotlinx/coroutines/Job;", "clientScope", "Lkotlinx/coroutines/CoroutineScope;", "connectToken", "Lorg/eclipse/paho/client/mqttv3/IMqttToken;", "getContext", "()Landroid/content/Context;", "messageAck", "mqttService", "Linfo/mqtt/android/service/MqttService;", "receiverRegistered", "Ljava/util/concurrent/atomic/AtomicBoolean;", "serviceBound", "serviceConnection", "Linfo/mqtt/android/service/MqttAndroidClient$MyServiceConnection;", "tokenList", "", "traceCallback", "Linfo/mqtt/android/service/MqttTraceHandler;", "traceEnabled", "acknowledgeMessage", "messageId", "addCallback", "", "callback", "close", "collect", "connect", "userContext", "", "Lorg/eclipse/paho/client/mqttv3/IMqttActionListener;", "options", "connectAction", "data", "Landroid/os/Bundle;", "connectExtendedAction", "connectionLostAction", "deleteBufferedMessage", "bufferIndex", "disconnect", "quiesceTimeout", "", "disconnectForcibly", "disconnectTimeout", "disconnected", "doConnect", "getBufferedMessage", "Lorg/eclipse/paho/client/mqttv3/MqttMessage;", "getBufferedMessageCount", "getClientId", "getInFlightMessageCount", "getMqttToken", "getPendingDeliveryTokens", "", "Lorg/eclipse/paho/client/mqttv3/IMqttDeliveryToken;", "()[Lorg/eclipse/paho/client/mqttv3/IMqttDeliveryToken;", "getSSLSocketFactory", "Ljavax/net/ssl/SSLSocketFactory;", "keyStore", "Ljava/io/InputStream;", "password", "getServerURI", "isConnected", "messageArrivedAction", "messageArrivedComplete", "qos", "messageDeliveredAction", "onReceive", "publish", "topic", "payload", "", "retained", "message", "reconnect", "registerResources", "removeCallback", "removeMessage", "token", "removeMqttToken", "sendAction", "setBufferOpts", "bufferOpts", "Lorg/eclipse/paho/client/mqttv3/DisconnectedBufferOptions;", "setCallback", "setManualAcks", "manualAcks", "setTraceCallback", "setTraceEnabled", "simpleAction", "storeToken", "subscribe", "", "([Ljava/lang/String;[I)Lorg/eclipse/paho/client/mqttv3/IMqttToken;", "([Ljava/lang/String;[ILjava/lang/Object;Lorg/eclipse/paho/client/mqttv3/IMqttActionListener;)Lorg/eclipse/paho/client/mqttv3/IMqttToken;", "topicFilters", "messageListeners", "Lorg/eclipse/paho/client/mqttv3/IMqttMessageListener;", "([Ljava/lang/String;[ILjava/lang/Object;Lorg/eclipse/paho/client/mqttv3/IMqttActionListener;[Lorg/eclipse/paho/client/mqttv3/IMqttMessageListener;)Lorg/eclipse/paho/client/mqttv3/IMqttToken;", "([Ljava/lang/String;[I[Lorg/eclipse/paho/client/mqttv3/IMqttMessageListener;)Lorg/eclipse/paho/client/mqttv3/IMqttToken;", "topicFilter", "messageListener", "subscribeAction", "traceAction", "unSubscribeAction", "unregisterResources", "unsubscribe", "([Ljava/lang/String;)Lorg/eclipse/paho/client/mqttv3/IMqttToken;", "([Ljava/lang/String;Ljava/lang/Object;Lorg/eclipse/paho/client/mqttv3/IMqttActionListener;)Lorg/eclipse/paho/client/mqttv3/IMqttToken;", "Companion", "MyServiceConnection", "serviceLibrary_debug"})
public final class MqttAndroidClient implements org.eclipse.paho.client.mqttv3.IMqttAsyncClient {
    @org.jetbrains.annotations.NotNull()
    private final android.content.Context context = null;
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String serverURI = null;
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String clientId = null;
    @org.jetbrains.annotations.Nullable()
    private org.eclipse.paho.client.mqttv3.MqttClientPersistence persistence;
    private final boolean pingLogging = false;
    private final int keepPingRecords = 0;
    @org.jetbrains.annotations.NotNull()
    private final info.mqtt.android.service.MqttAndroidClient.MyServiceConnection serviceConnection = null;
    @org.jetbrains.annotations.NotNull()
    private final java.util.List<org.eclipse.paho.client.mqttv3.IMqttToken> tokenList = null;
    @org.jetbrains.annotations.NotNull()
    private final info.mqtt.android.service.Ack messageAck = null;
    @org.jetbrains.annotations.Nullable()
    private info.mqtt.android.service.MqttService mqttService;
    @org.jetbrains.annotations.Nullable()
    private java.lang.String clientHandle;
    @org.jetbrains.annotations.Nullable()
    private org.eclipse.paho.client.mqttv3.MqttConnectOptions clientConnectOptions;
    @org.jetbrains.annotations.Nullable()
    private org.eclipse.paho.client.mqttv3.IMqttToken connectToken;
    @org.jetbrains.annotations.NotNull()
    private java.util.ArrayList<org.eclipse.paho.client.mqttv3.MqttCallback> callbacksList;
    @org.jetbrains.annotations.Nullable()
    private info.mqtt.android.service.MqttTraceHandler traceCallback;
    private boolean traceEnabled = false;
    @kotlin.jvm.Volatile()
    @org.jetbrains.annotations.NotNull()
    private volatile java.util.concurrent.atomic.AtomicBoolean receiverRegistered;
    @kotlin.jvm.Volatile()
    private volatile boolean serviceBound = false;
    @org.jetbrains.annotations.Nullable()
    private kotlinx.coroutines.Job clientJob;
    @org.jetbrains.annotations.Nullable()
    private kotlinx.coroutines.CoroutineScope clientScope;
    private static final java.lang.String SERVICE_NAME = null;
    @org.jetbrains.annotations.NotNull()
    public static final info.mqtt.android.service.MqttAndroidClient.Companion Companion = null;
    
    public MqttAndroidClient(@org.jetbrains.annotations.NotNull()
    android.content.Context context, @org.jetbrains.annotations.NotNull()
    java.lang.String serverURI, @org.jetbrains.annotations.NotNull()
    java.lang.String clientId, @org.jetbrains.annotations.NotNull()
    info.mqtt.android.service.Ack ackType, @org.jetbrains.annotations.Nullable()
    org.eclipse.paho.client.mqttv3.MqttClientPersistence persistence, boolean pingLogging, int keepPingRecords) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final android.content.Context getContext() {
        return null;
    }
    
    /**
     * Determines if this client is currently connected to the server.
     *
     * @return `true` if connected, `false` otherwise.
     */
    @java.lang.Override()
    public boolean isConnected() {
        return false;
    }
    
    /**
     * Returns the client ID used by this client.
     *
     * All clients connected to the same server or server farm must have a
     * unique ID.
     *
     * @return the client ID used by this client.
     */
    @java.lang.Override()
    @org.jetbrains.annotations.NotNull()
    public java.lang.String getClientId() {
        return null;
    }
    
    /**
     * Returns the URI address of the server used by this client.
     *
     *
     * The format of the returned String is the same as that used on the
     * constructor.
     *
     *
     * @return the server's address, as a URI String.
     */
    @java.lang.Override()
    @org.jetbrains.annotations.NotNull()
    public java.lang.String getServerURI() {
        return null;
    }
    
    /**
     * Close the client. Releases all resource associated with the client. After
     * the client has been closed it cannot be reused. For instance attempts to
     * connect will fail.
     */
    @java.lang.Override()
    public void close() {
    }
    
    /**
     * Connects to an MQTT server using the default options.
     *
     * The default options are specified in [MqttConnectOptions] class.
     *
     * @return token used to track and wait for the connect to complete. The token will be passed to the callback methods if a callback is set.
     * @see .connect
     */
    @java.lang.Override()
    @org.jetbrains.annotations.NotNull()
    public org.eclipse.paho.client.mqttv3.IMqttToken connect() {
        return null;
    }
    
    /**
     * Connects to an MQTT server using the provided connect options.
     *
     * The connection will be established using the options specified in the [MqttConnectOptions] parameter.
     *
     * @param options a set of connection parameters that override the defaults.
     * @return token used to track and wait for the connect to complete. The token will be passed to any callback that has been set.
     * @see .connect
     */
    @java.lang.Override()
    @org.jetbrains.annotations.NotNull()
    public org.eclipse.paho.client.mqttv3.IMqttToken connect(@org.jetbrains.annotations.NotNull()
    org.eclipse.paho.client.mqttv3.MqttConnectOptions options) {
        return null;
    }
    
    /**
     * Connects to an MQTT server using the default options.
     *
     * The default options are specified in [MqttConnectOptions] class.
     *
     * @param userContext optional object used to pass context to the callback. Use null if not required.
     * @param callback    optional listener that will be notified when the connect completes. Use null if not required.
     * @return token used to track and wait for the connect to complete. The token will be passed to any callback that has been set.
     * @see .connect
     */
    @java.lang.Override()
    @org.jetbrains.annotations.NotNull()
    public org.eclipse.paho.client.mqttv3.IMqttToken connect(@org.jetbrains.annotations.Nullable()
    java.lang.Object userContext, @org.jetbrains.annotations.Nullable()
    org.eclipse.paho.client.mqttv3.IMqttActionListener callback) {
        return null;
    }
    
    /**
     * Connects to an MQTT server using the specified options.
     *
     * The server to connect to is specified on the constructor. It is recommended to call [.setCallback] prior to
     * connecting in order that messages destined for the client can be accepted as soon as the client is connected.
     *
     * The method returns control before the connect completes. Completion can be tracked by:
     *
     * * Waiting on the returned token [IMqttToken.waitForCompletion]
     * or
     * * Passing in a callback [IMqttActionListener]
     *
     * @param options     a set of connection parameters that override the defaults.
     * @param userContext optional object for used to pass context to the callback. Use null if not required.
     * @param callback    optional listener that will be notified when the connect completes. Use null if not required.
     * @return token used to track and wait for the connect to complete. The token will be passed to any callback that has been set.
     */
    @java.lang.Override()
    @org.jetbrains.annotations.NotNull()
    public org.eclipse.paho.client.mqttv3.IMqttToken connect(@org.jetbrains.annotations.NotNull()
    org.eclipse.paho.client.mqttv3.MqttConnectOptions options, @org.jetbrains.annotations.Nullable()
    java.lang.Object userContext, @org.jetbrains.annotations.Nullable()
    org.eclipse.paho.client.mqttv3.IMqttActionListener callback) {
        return null;
    }
    
    private final void collect() {
    }
    
    /**
     * Actually do the mqtt connect operation
     */
    private final void doConnect(boolean pingLogging, int keepPingRecords) {
    }
    
    /**
     * Disconnects from the server.
     *
     * An attempt is made to quiesce the client allowing outstanding work to
     * complete before disconnecting. It will wait for a maximum of 30 seconds
     * for work to quiesce before disconnecting. This method must not be called from inside [MqttCallback] methods.
     *
     * @return token used to track and wait for disconnect to complete. The token will be passed to any callback that has been set.
     * @see .disconnect
     */
    @java.lang.Override()
    @org.jetbrains.annotations.NotNull()
    public org.eclipse.paho.client.mqttv3.IMqttToken disconnect() {
        return null;
    }
    
    /**
     * Disconnects from the server.
     *
     * An attempt is made to quiesce the client allowing outstanding work to
     * complete before disconnecting. It will wait for a maximum of the
     * specified quiesce time for work to complete before disconnecting. This
     * method must not be called from inside [MqttCallback] methods.
     *
     * @param quiesceTimeout the amount of time in milliseconds to allow for existing work
     * to finish before disconnecting. A value of zero or less means the client will not quiesce.
     * @return token used to track and wait for disconnect to complete. The token will be passed to the callback methods if a callback is set.
     * @see .disconnect
     */
    @java.lang.Override()
    @org.jetbrains.annotations.NotNull()
    public org.eclipse.paho.client.mqttv3.IMqttToken disconnect(long quiesceTimeout) {
        return null;
    }
    
    /**
     * Disconnects from the server.
     *
     * An attempt is made to quiesce the client allowing outstanding work to complete before disconnecting. It will wait for a maximum of 30 seconds
     * for work to quiesce before disconnecting. This method must not be called from inside [MqttCallback] methods.
     *
     * @param userContext optional object used to pass context to the callback. Use null if not required.
     * @param callback    optional listener that will be notified when the disconnect completes. Use null if not required.
     * @return token used to track and wait for the disconnect to complete. The token will be passed to any callback that has been set.
     * @see .disconnect
     */
    @java.lang.Override()
    @org.jetbrains.annotations.NotNull()
    public org.eclipse.paho.client.mqttv3.IMqttToken disconnect(@org.jetbrains.annotations.Nullable()
    java.lang.Object userContext, @org.jetbrains.annotations.Nullable()
    org.eclipse.paho.client.mqttv3.IMqttActionListener callback) {
        return null;
    }
    
    /**
     * Disconnects from the server.
     *
     * The client will wait for [MqttCallback] methods to complete. It
     * will then wait for up to the quiesce timeout to allow for work which has
     * already been initiated to complete. For instance when a QoS 2 message has
     * started flowing to the server but the QoS 2 flow has not completed.It
     * prevents new messages being accepted and does not send any messages that
     * have been accepted but not yet started delivery across the network to the
     * server. When work has completed or after the quiesce timeout, the client
     * will disconnect from the server. If the cleanSession flag was set to false and next time it is also set to false in the connection, the
     * messages made in QoS 1 or 2 which were not previously delivered will be delivered this time.
     *
     * This method must not be called from inside [MqttCallback] methods.
     *
     * The method returns control before the disconnect completes. Completion can be tracked by:
     *
     * * Waiting on the returned token [IMqttToken.waitForCompletion]
     * or
     * * Passing in a callback [IMqttActionListener]
     *
     * @param quiesceTimeout the amount of time in milliseconds to allow for existing work
     * to finish before disconnecting. A value of zero or less means the client will not quiesce.
     * @param userContext    optional object used to pass context to the callback. Use null if not required.
     * @param callback       optional listener that will be notified when the disconnect completes. Use null if not required.
     * @return token used to track and wait for the disconnect to complete. The token will be passed to any callback that has been set.
     */
    @java.lang.Override()
    @org.jetbrains.annotations.NotNull()
    public org.eclipse.paho.client.mqttv3.IMqttToken disconnect(long quiesceTimeout, @org.jetbrains.annotations.Nullable()
    java.lang.Object userContext, @org.jetbrains.annotations.NotNull()
    org.eclipse.paho.client.mqttv3.IMqttActionListener callback) {
        return null;
    }
    
    /**
     * Publishes a message to a topic on the server.
     * A convenience method, which will create a new [MqttMessage] object
     * with a byte array payload and the specified QoS, and then publish it.
     *
     * @param topic    to deliver the message to, for example "finance\/stock\/ibm".
     * @param payload  the byte array to use as the payload
     * @param qos      the Quality of Service to deliver the message at. Valid values are 0, 1 or 2.
     * @param retained whether or not this message should be retained by the server.
     * @return token used to track and wait for the publish to complete. The token will be passed to any callback that has been set.
     * @throws IllegalArgumentException if value of QoS is not 0, 1 or 2.
     * @see .publish
     */
    @java.lang.Override()
    @org.jetbrains.annotations.NotNull()
    public org.eclipse.paho.client.mqttv3.IMqttDeliveryToken publish(@org.jetbrains.annotations.NotNull()
    java.lang.String topic, @org.jetbrains.annotations.NotNull()
    byte[] payload, int qos, boolean retained) {
        return null;
    }
    
    /**
     * Publishes a message to a topic on the server. Takes an
     * [MqttMessage] message and delivers it to the server at the
     * requested quality of service.
     *
     * @param topic   to deliver the message to, for example "finance/stock/ibm".
     * @param message to deliver to the server
     * @return token used to track and wait for the publish to complete. The token will be passed to any callback that has been set.
     * @throws IllegalArgumentException if value of QoS is not 0, 1 or 2.
     * @see .publish
     */
    @java.lang.Override()
    @org.jetbrains.annotations.NotNull()
    public org.eclipse.paho.client.mqttv3.IMqttDeliveryToken publish(@org.jetbrains.annotations.NotNull()
    java.lang.String topic, @org.jetbrains.annotations.NotNull()
    org.eclipse.paho.client.mqttv3.MqttMessage message) {
        return null;
    }
    
    /**
     * Publishes a message to a topic on the server.
     *
     * A convenience method, which will create a new [MqttMessage] object
     * with a byte array payload, the specified QoS and retained, then publish it.
     *
     * @param topic       to deliver the message to, for example "finance/stock/ibm".
     * @param payload     the byte array to use as the payload
     * @param qos         the Quality of Service to deliver the message at. Valid values
     * are 0, 1 or 2.
     * @param retained    whether or not this message should be retained by the server.
     * @param userContext optional object used to pass context to the callback. Use null if not required.
     * @param callback    optional listener that will be notified when message delivery
     * has completed to the requested quality of service
     * @return token used to track and wait for the publish to complete. The token will be passed to any callback that has been set.
     * @throws IllegalArgumentException if value of QoS is not 0, 1 or 2.
     * @see .publish
     */
    @java.lang.Override()
    @org.jetbrains.annotations.NotNull()
    public org.eclipse.paho.client.mqttv3.IMqttDeliveryToken publish(@org.jetbrains.annotations.NotNull()
    java.lang.String topic, @org.jetbrains.annotations.NotNull()
    byte[] payload, int qos, boolean retained, @org.jetbrains.annotations.Nullable()
    java.lang.Object userContext, @org.jetbrains.annotations.Nullable()
    org.eclipse.paho.client.mqttv3.IMqttActionListener callback) {
        return null;
    }
    
    /**
     * Publishes a message to a topic on the server.
     *
     * Once this method has returned cleanly, the message has been accepted for
     * publication by the client and will be delivered on a background thread.
     * In the event the connection fails or the client stops, Messages will be
     * delivered to the requested quality of service once the connection is
     * re-established to the server on condition that:
     *
     * * The connection is re-established with the same clientID
     * * The original connection was made with (@link MqttConnectOptions#setCleanSession(boolean)} set to false
     * * The connection is re-established with (@link MqttConnectOptions#setCleanSession(boolean)} set to false
     * * Depending when the failure occurs QoS 0 messages may not be delivered.
     *
     * When building an application, the design of the topic tree should take
     * into account the following principles of topic name syntax and semantics:
     *
     * * A topic must be at least one character long.
     * * Topic names are case sensitive. For example, *ACCOUNTS* and
     * *Accounts* are two different topics.
     * * Topic names can include the space character. For example,
     * *Accounts
     * payable* is a valid topic.
     * * A leading "/" creates a distinct topic. For example,
     * finance* is different from *finance*.
     * matches "+/+" and "/+", but not "+".
     * * Do not include the null character (Unicode *\x0000*) in any topic.
     *
     * The following principles apply to the construction and content of a topic
     * tree:
     *
     * * The length is limited to 64k but within that there are no limits to
     * the number of levels in a topic tree.
     * * There can be any number of root nodes; that is, there can be any
     * number of topic trees.
     *
     * The method returns control before the publish completes. Completion can
     * be tracked by:
     *
     * * Setting an [IMqttAsyncClient.setCallback] where
     * the [MqttCallback.deliveryComplete] method will
     * be called.
     * * Waiting on the returned token [MqttToken.waitForCompletion]
     * or
     * * Passing in a callback [IMqttActionListener] to this method
     *
     * @param topic to deliver the message to, for example "finance/stock/ibm".
     * @param message to deliver to the server
     * @param userContext optional object used to pass context to the callback. Use null if not required.
     * @param callback optional listener that will be notified when message delivery has completed to the requested quality of service
     * @ return token used to track and wait for the publish to complete. The token will be passed to callback methods if set.
     * @throws IllegalArgumentException if value of QoS is not 0, 1 or 2.
     * @see MqttMessage
     */
    @java.lang.Override()
    @org.jetbrains.annotations.NotNull()
    public org.eclipse.paho.client.mqttv3.IMqttDeliveryToken publish(@org.jetbrains.annotations.NotNull()
    java.lang.String topic, @org.jetbrains.annotations.NotNull()
    org.eclipse.paho.client.mqttv3.MqttMessage message, @org.jetbrains.annotations.Nullable()
    java.lang.Object userContext, @org.jetbrains.annotations.Nullable()
    org.eclipse.paho.client.mqttv3.IMqttActionListener callback) {
        return null;
    }
    
    /**
     * Subscribe to a topic, which may include wildcards.
     *
     * @param topic the topic to subscribe to, which can include wildcards.
     * @param qos   the maximum quality of service at which to subscribe. Messages
     * published at a lower quality of service will be received at the published QoS. Messages published at a higher quality of
     * service will be received using the QoS specified on the subscription.
     * @return token used to track and wait for the subscribe to complete. The token will be passed to callback methods if set.
     * @see .subscribe
     */
    @java.lang.Override()
    @org.jetbrains.annotations.NotNull()
    public org.eclipse.paho.client.mqttv3.IMqttToken subscribe(@org.jetbrains.annotations.NotNull()
    java.lang.String topic, int qos) {
        return null;
    }
    
    /**
     * Subscribe to multiple topics, each topic may include wildcards.
     *
     * Provides an optimized way to subscribe to multiple topics compared to
     * subscribing to each one individually.
     *
     * @param topic one or more topics to subscribe to, which can include
     * wildcards
     * @param qos   the maximum quality of service at which to subscribe. Messages
     * published at a lower quality of service will be received at the published QoS. Messages published at a higher quality of
     * service will be received using the QoS specified on the subscription.
     * @return token used to track and wait for the subscription to complete. The token will be passed to callback methods if set.
     * @see .subscribe
     */
    @java.lang.Override()
    @org.jetbrains.annotations.NotNull()
    public org.eclipse.paho.client.mqttv3.IMqttToken subscribe(@org.jetbrains.annotations.NotNull()
    java.lang.String[] topic, @org.jetbrains.annotations.NotNull()
    int[] qos) {
        return null;
    }
    
    /**
     * Subscribe to a topic, which may include wildcards.
     *
     * @param topic       the topic to subscribe to, which can include wildcards.
     * @param qos         the maximum quality of service at which to subscribe. Messages
     * published at a lower quality of service will be received at the published QoS. Messages published at a higher quality of
     * service will be received using the QoS specified on the subscription.
     * @param userContext optional object used to pass context to the callback. Use null if not required.
     * @param callback    optional listener that will be notified when subscribe has completed
     * @return token used to track and wait for the subscribe to complete. The token will be passed to callback methods if set.
     * @see .subscribe
     */
    @java.lang.Override()
    @org.jetbrains.annotations.NotNull()
    public org.eclipse.paho.client.mqttv3.IMqttToken subscribe(@org.jetbrains.annotations.NotNull()
    java.lang.String topic, int qos, @org.jetbrains.annotations.Nullable()
    java.lang.Object userContext, @org.jetbrains.annotations.Nullable()
    org.eclipse.paho.client.mqttv3.IMqttActionListener callback) {
        return null;
    }
    
    /**
     * Subscribes to multiple topics, each topic may include wildcards.
     *
     * Provides an optimized way to subscribe to multiple topics compared to subscribing to each one individually.
     *
     * The [.setCallback] method should be called before this method, otherwise any received messages will be discarded.
     *
     * If (@link MqttConnectOptions#setCleanSession(boolean)} was set to true,
     * when connecting to the server, the subscription remains in place until
     * either:
     *
     * * The client disconnects
     * * An unsubscribe method is called to unsubscribe the topic
     *
     * If (@link MqttConnectOptions#setCleanSession(boolean)} was set to false,
     * when connecting to the server, the subscription remains in place
     * until either:
     *
     * * An unsubscribe method is called to unsubscribe the topic
     * * The next time the client connects with cleanSession set to true
     *
     * With cleanSession set to false the MQTT server will store messages
     * on behalf of the client when the client is not connected. The next time
     * the client connects with the **same client ID** the server will
     * deliver the stored messages to the client.
     *
     * The "topic filter" string is used when subscription may contain special
     * characters, which allows you to subscribe to multiple topics at once.
     * <dl>
     * <dt>Topic level separator</dt>
     * <dd>The forward slash (/) is used to separate each level within a topic
     * tree and provide a hierarchical structure to the topic space. The use of
     * the topic level separator is significant when the two wildcard characters
     * are encountered in topics specified by subscribers.</dd>
     *   </dl> *
     *
     * <dt>Multi-level wildcard</dt>
     * <dd>
     *   </dd> *
     *
     * The number sign (#) is a wildcard character that matches any number of
     * levels within a topic. For example, if you subscribe to <span><span class="filepath">finance/stock/ibm/#</span></span>, you receive messages
     * on these topics:
     *
     * * <pre>finance/stock/ibm</pre>
     * * <pre>finance/stock/ibm/closingprice</pre>
     * * <pre>finance/stock/ibm/currentprice</pre>
     *
     * The multi-level wildcard can represent zero or more levels. Therefore,
     * *finance/#* can also match the singular *finance*, where
     * *#* represents zero levels. The topic level separator is
     * meaningless in this context, because there are no levels to separate.
     *
     * The <span>multi-level</span> wildcard can be specified only on its own or
     * next to the topic level separator character. Therefore, *#* and
     * *finance/#* are both valid, but *finance#* is not valid.
     * <span>The multi-level wildcard must be the last character used within the
     * topic tree. For example, *finance/#* is valid but
     * *finance/#/closingprice* is not valid.</span>
     *
     * <dt>Single-level wildcard</dt>
     * <dd>
     *   </dd> *
     *
     * The plus sign (+) is a wildcard character that matches only one topic
     * level. For example, *finance/stock/+* matches
     * *finance/stock/ibm* and *finance/stock/xyz*, but not
     * *finance/stock/ibm/closingprice*. Also, because the single-level
     * wildcard matches only a single level, *finance/+* does not match
     * *finance*.
     *
     * Use the single-level wildcard at any level in the topic tree, and in
     * conjunction with the multilevel wildcard. Specify the single-level
     * wildcard next to the topic level separator, except when it is specified
     * on its own. Therefore, *+* and *finance/+* are both valid,
     * but *finance+* is not valid. <span>The single-level wildcard can
     * be used at the end of the topic tree or within the topic tree. For
     * example, *finance/+* and *finance/+/ibm* are both
     * valid.</span>
     *
     * The method returns control before the subscribe completes. Completion can
     * be tracked by:
     *
     * * Waiting on the supplied token [MqttToken.waitForCompletion]
     * or
     * * Passing in a callback [IMqttActionListener] to this method
     *
     * @param topic       one or more topics to subscribe to, which can include
     * wildcards
     * @param qos         the maximum quality of service to subscribe each topic
     * at.Messages published at a lower quality of service will be received at the published QoS. Messages published at a higher
     * quality of service will be received using the QoS specified on the subscription.
     * @param userContext optional object used to pass context to the callback. Use null if not required.
     * @param callback    optional listener that will be notified when subscribe has completed
     * @return token used to track and wait for the subscribe to complete. The token will be passed to callback methods if set.
     * @throws IllegalArgumentException if the two supplied arrays are not the same size.
     */
    @java.lang.Override()
    @org.jetbrains.annotations.NotNull()
    public org.eclipse.paho.client.mqttv3.IMqttToken subscribe(@org.jetbrains.annotations.NotNull()
    java.lang.String[] topic, @org.jetbrains.annotations.NotNull()
    int[] qos, @org.jetbrains.annotations.Nullable()
    java.lang.Object userContext, @org.jetbrains.annotations.Nullable()
    org.eclipse.paho.client.mqttv3.IMqttActionListener callback) {
        return null;
    }
    
    /**
     * Subscribe to a topic, which may include wildcards.
     *
     * @param topicFilter     the topic to subscribe to, which can include wildcards.
     * @param qos             the maximum quality of service at which to subscribe. Messages
     * published at a lower quality of service will be received at the published
     * QoS.  Messages published at a higher quality of service will be received using the QoS specified on the subscribe.
     * @param userContext     optional object used to pass context to the callback. Use null if not required.
     * @param callback        optional listener that will be notified when subscribe has completed
     * @param messageListener a callback to handle incoming messages
     * @return token used to track and wait for the subscribe to complete. The token will be passed to callback methods if set.
     * @see .subscribe
     */
    @java.lang.Override()
    @org.jetbrains.annotations.NotNull()
    public org.eclipse.paho.client.mqttv3.IMqttToken subscribe(@org.jetbrains.annotations.NotNull()
    java.lang.String topicFilter, int qos, @org.jetbrains.annotations.Nullable()
    java.lang.Object userContext, @org.jetbrains.annotations.Nullable()
    org.eclipse.paho.client.mqttv3.IMqttActionListener callback, @org.jetbrains.annotations.NotNull()
    org.eclipse.paho.client.mqttv3.IMqttMessageListener messageListener) {
        return null;
    }
    
    /**
     * Subscribe to a topic, which may include wildcards.
     *
     * @param topicFilter     the topic to subscribe to, which can include wildcards.
     * @param qos             the maximum quality of service at which to subscribe. Messages
     * published at a lower quality of service will be received at the published
     * QoS.  Messages published at a higher quality of service will be received using the QoS specified on the subscribe.
     * @param messageListener a callback to handle incoming messages
     * @return token used to track and wait for the subscribe to complete. The token will be passed to callback methods if set.
     * @see .subscribe
     */
    @java.lang.Override()
    @org.jetbrains.annotations.NotNull()
    public org.eclipse.paho.client.mqttv3.IMqttToken subscribe(@org.jetbrains.annotations.NotNull()
    java.lang.String topicFilter, int qos, @org.jetbrains.annotations.NotNull()
    org.eclipse.paho.client.mqttv3.IMqttMessageListener messageListener) {
        return null;
    }
    
    /**
     * Subscribe to multiple topics, each of which may include wildcards.
     *
     * Provides an optimized way to subscribe to multiple topics compared to
     * subscribing to each one individually.
     *
     * @param topicFilters     one or more topics to subscribe to, which can include wildcards
     * @param qos              the maximum quality of service at which to subscribe. Messages
     * published at a lower quality of service will be received at the published
     * QoS.  Messages published at a higher quality of service will be received using the QoS specified on the subscribe.
     * @param messageListeners an array of callbacks to handle incoming messages
     * @return token used to track and wait for the subscribe to complete. The token will be passed to callback methods if set.
     * @see .subscribe
     */
    @java.lang.Override()
    @org.jetbrains.annotations.NotNull()
    public org.eclipse.paho.client.mqttv3.IMqttToken subscribe(@org.jetbrains.annotations.NotNull()
    java.lang.String[] topicFilters, @org.jetbrains.annotations.NotNull()
    int[] qos, @org.jetbrains.annotations.NotNull()
    org.eclipse.paho.client.mqttv3.IMqttMessageListener[] messageListeners) {
        return null;
    }
    
    /**
     * Subscribe to multiple topics, each of which may include wildcards.
     *
     * Provides an optimized way to subscribe to multiple topics compared to
     * subscribing to each one individually.
     *
     * @param topicFilters     one or more topics to subscribe to, which can include wildcards
     * @param qos              the maximum quality of service at which to subscribe. Messages published at a lower quality of service will be
     * received at the published
     * QoS.  Messages published at a higher quality of service will be received using the QoS specified on the subscribe.
     * @param userContext      optional object used to pass context to the callback. Use null if not required.
     * @param callback         optional listener that will be notified when subscribe has completed
     * @param messageListeners an array of callbacks to handle incoming messages
     * @return token used to track and wait for the subscribe to complete. The token will be passed to callback methods if set.
     * @see .subscribe
     */
    @java.lang.Override()
    @org.jetbrains.annotations.NotNull()
    public org.eclipse.paho.client.mqttv3.IMqttToken subscribe(@org.jetbrains.annotations.NotNull()
    java.lang.String[] topicFilters, @org.jetbrains.annotations.NotNull()
    int[] qos, @org.jetbrains.annotations.Nullable()
    java.lang.Object userContext, @org.jetbrains.annotations.Nullable()
    org.eclipse.paho.client.mqttv3.IMqttActionListener callback, @org.jetbrains.annotations.NotNull()
    org.eclipse.paho.client.mqttv3.IMqttMessageListener[] messageListeners) {
        return null;
    }
    
    /**
     * Requests the server unsubscribe the client from a topic.
     *
     * @param topic the topic to unsubscribe from. It must match a topic specified on an earlier subscribe.
     * @return token used to track and wait for the unsubscribe to complete. The token will be passed to callback methods if set.
     * @see .unsubscribe
     */
    @java.lang.Override()
    @org.jetbrains.annotations.NotNull()
    public org.eclipse.paho.client.mqttv3.IMqttToken unsubscribe(@org.jetbrains.annotations.NotNull()
    java.lang.String topic) {
        return null;
    }
    
    /**
     * Requests the server to unsubscribe the client from one or more topics.
     *
     * @param topic one or more topics to unsubscribe from. Each topic must match one specified on an earlier subscription.
     * @return token used to track and wait for the unsubscribe to complete. The token will be passed to callback methods if set.
     * @see .unsubscribe
     */
    @java.lang.Override()
    @org.jetbrains.annotations.NotNull()
    public org.eclipse.paho.client.mqttv3.IMqttToken unsubscribe(@org.jetbrains.annotations.NotNull()
    java.lang.String[] topic) {
        return null;
    }
    
    /**
     * Requests the server to unsubscribe the client from a topics.
     *
     * @param topic       the topic to unsubscribe from. It must match a topic specified on an earlier subscribe.
     * @param userContext optional object used to pass context to the callback. Use null if not required.
     * @param callback    optional listener that will be notified when unsubscribe has completed
     * @return token used to track and wait for the unsubscribe to complete. The token will be passed to callback methods if set.
     * @see .unsubscribe
     */
    @java.lang.Override()
    @org.jetbrains.annotations.NotNull()
    public org.eclipse.paho.client.mqttv3.IMqttToken unsubscribe(@org.jetbrains.annotations.NotNull()
    java.lang.String topic, @org.jetbrains.annotations.Nullable()
    java.lang.Object userContext, @org.jetbrains.annotations.Nullable()
    org.eclipse.paho.client.mqttv3.IMqttActionListener callback) {
        return null;
    }
    
    /**
     * Requests the server to unsubscribe the client from one or more topics.
     *
     * Unsubcribing is the opposite of subscribing. When the server receives the
     * unsubscribe request it looks to see if it can find a matching
     * subscription for the client and then removes it. After this point the
     * server will send no more messages to the client for this subscription.
     *
     * The topic(s) specified on the unsubscribe must match the topic(s)
     * specified in the original subscribe request for the unsubscribe to
     * succeed
     *
     * The method returns control before the unsubscribe completes. Completion
     * can be tracked by:
     *
     * * Waiting on the returned token [MqttToken.waitForCompletion]
     * or
     * * Passing in a callback [IMqttActionListener] to this method
     *
     * @param topic       one or more topics to unsubscribe from. Each topic must match one specified on an earlier subscription.
     * @param userContext optional object used to pass context to the callback. Use null if not required.
     * @param callback    optional listener that will be notified when unsubscribe has completed
     * @return token used to track and wait for the unsubscribe to complete. The token will be passed to callback methods if set.
     */
    @java.lang.Override()
    @org.jetbrains.annotations.NotNull()
    public org.eclipse.paho.client.mqttv3.IMqttToken unsubscribe(@org.jetbrains.annotations.NotNull()
    java.lang.String[] topic, @org.jetbrains.annotations.Nullable()
    java.lang.Object userContext, @org.jetbrains.annotations.Nullable()
    org.eclipse.paho.client.mqttv3.IMqttActionListener callback) {
        return null;
    }
    
    @java.lang.Override()
    @kotlin.jvm.Throws(exceptionClasses = {org.eclipse.paho.client.mqttv3.MqttException.class})
    public boolean removeMessage(@org.jetbrains.annotations.NotNull()
    org.eclipse.paho.client.mqttv3.IMqttDeliveryToken token) throws org.eclipse.paho.client.mqttv3.MqttException {
        return false;
    }
    
    /**
     * Returns the delivery tokens for any outstanding publish operations.
     *
     * If a client has been restarted and there are messages that were in the
     * process of being delivered when the client stopped, this method returns a
     * token for each in-flight message to enable the delivery to be tracked.
     * Alternately the [MqttCallback.deliveryComplete]
     * callback can be used to track the delivery of outstanding messages.
     *
     * If a client connects with cleanSession true then there will be no
     * delivery tokens as the cleanSession option deletes all earlier state. For
     * state to be remembered the client must connect with cleanSession set to
     * false
     *
     * @return zero or more delivery tokens
     */
    @java.lang.Override()
    @org.jetbrains.annotations.NotNull()
    public org.eclipse.paho.client.mqttv3.IMqttDeliveryToken[] getPendingDeliveryTokens() {
        return null;
    }
    
    /**
     * Sets a callback listener to use for events that happen asynchronously.
     *
     * There are a number of events that the listener will be notified about.
     * These include:
     *
     * * A new message has arrived and is ready to be processed
     * * The connection to the server has been lost
     * * Delivery of a message to the server has completed
     *
     * Other events that track the progress of an individual operation such as
     * connect and subscribe can be tracked using the [MqttToken] returned
     * from each non-blocking method or using setting a
     * [IMqttActionListener] on the non-blocking method.
     *
     * @param callback which will be invoked for certain asynchronous events
     * @see MqttCallback
     */
    @java.lang.Override()
    public void setCallback(@org.jetbrains.annotations.NotNull()
    org.eclipse.paho.client.mqttv3.MqttCallback callback) {
    }
    
    /**
     * Adds a callback listener to use for events that happen asynchronously.
     *
     * There are a number of events that the listener will be notified about.
     * These include:
     *
     * * A new message has arrived and is ready to be processed
     * * The connection to the server has been lost
     * * Delivery of a message to the server has completed
     *
     * Other events that track the progress of an individual operation such as
     * connect and subscribe can be tracked using the [MqttToken] returned
     * from each non-blocking method or using setting a
     * [IMqttActionListener] on the non-blocking method.
     *
     * @param callback which will be invoked for certain asynchronous events
     * @see MqttCallback
     */
    public final void addCallback(@org.jetbrains.annotations.NotNull()
    org.eclipse.paho.client.mqttv3.MqttCallback callback) {
    }
    
    public final void removeCallback(@org.jetbrains.annotations.NotNull()
    org.eclipse.paho.client.mqttv3.MqttCallback callback) {
    }
    
    /**
     * identify the callback to be invoked when making tracing calls back into
     * the Activity
     *
     * @param traceCallback handler
     */
    public final void setTraceCallback(@org.jetbrains.annotations.Nullable()
    info.mqtt.android.service.MqttTraceHandler traceCallback) {
    }
    
    /**
     * turn tracing on and off
     *
     * @param traceEnabled set `true` to enable trace, otherwise, set
     * `false` to disable trace
     */
    public final void setTraceEnabled(boolean traceEnabled) {
    }
    
    /**
     * Process incoming Intent objects representing the results of operations
     * and asynchronous activities such as message received
     *
     * **Note:** This is only a public method because the Android APIs require such.<br></br>
     * This method should not be explicitly invoked.
     */
    private final void onReceive(android.os.Bundle data) {
    }
    
    /**
     * Acknowledges a message received on the
     * [MqttCallback.messageArrived]
     *
     * @param messageId the messageId received from the MqttMessage (To access this
     * field you need to cast [MqttMessage] to
     * [ParcelableMqttMessage])
     * @return whether or not the message was successfully acknowledged
     */
    public final boolean acknowledgeMessage(@org.jetbrains.annotations.NotNull()
    java.lang.String messageId) {
        return false;
    }
    
    @java.lang.Override()
    @kotlin.jvm.Throws(exceptionClasses = {org.eclipse.paho.client.mqttv3.MqttException.class})
    public void messageArrivedComplete(int messageId, int qos) throws org.eclipse.paho.client.mqttv3.MqttException {
    }
    
    @java.lang.Override()
    public void setManualAcks(boolean manualAcks) {
    }
    
    @java.lang.Override()
    @kotlin.jvm.Throws(exceptionClasses = {org.eclipse.paho.client.mqttv3.MqttException.class})
    public void reconnect() throws org.eclipse.paho.client.mqttv3.MqttException {
    }
    
    /**
     * Process the results of a connection
     */
    private final void connectAction(android.os.Bundle data) {
    }
    
    /**
     * Process a notification that we have disconnected
     */
    private final void disconnected(android.os.Bundle data) {
    }
    
    /**
     * Process a Connection Lost notification
     */
    private final void connectionLostAction(android.os.Bundle data) {
    }
    
    private final void connectExtendedAction(android.os.Bundle data) {
    }
    
    /**
     * Common processing for many notifications
     *
     * @param token the token associated with the action being undertake
     * @param data  the result data
     */
    private final void simpleAction(org.eclipse.paho.client.mqttv3.IMqttToken token, android.os.Bundle data) {
    }
    
    /**
     * Process notification of a publish(send) operation
     */
    private final void sendAction(android.os.Bundle data) {
    }
    
    /**
     * Process notification of a subscribe operation
     */
    private final void subscribeAction(android.os.Bundle data) {
    }
    
    /**
     * Process notification of an unsubscribe operation
     */
    private final void unSubscribeAction(android.os.Bundle data) {
    }
    
    /**
     * Process notification of a published message having been delivered
     */
    private final void messageDeliveredAction(android.os.Bundle data) {
    }
    
    /**
     * Process notification of a message's arrival
     */
    private final void messageArrivedAction(android.os.Bundle data) {
    }
    
    /**
     * Process trace action - pass trace data back to the callback
     */
    private final void traceAction(android.os.Bundle data) {
    }
    
    /**
     * @param token identifying an operation
     */
    @kotlin.jvm.Synchronized()
    private final synchronized void storeToken(org.eclipse.paho.client.mqttv3.IMqttToken token) {
    }
    
    /**
     * Get a token identified by a string, and remove it from our map
     *
     * @return the token
     */
    @kotlin.jvm.Synchronized()
    private final synchronized org.eclipse.paho.client.mqttv3.IMqttToken removeMqttToken(android.os.Bundle data) {
        return null;
    }
    
    /**
     * Get a token identified by a string, and remove it from our map
     *
     * @return the token
     */
    @kotlin.jvm.Synchronized()
    private final synchronized org.eclipse.paho.client.mqttv3.IMqttToken getMqttToken(android.os.Bundle data) {
        return null;
    }
    
    /**
     * Sets the DisconnectedBufferOptions for this client
     *
     * @param bufferOpts the DisconnectedBufferOptions
     */
    @java.lang.Override()
    public void setBufferOpts(@org.jetbrains.annotations.NotNull()
    org.eclipse.paho.client.mqttv3.DisconnectedBufferOptions bufferOpts) {
    }
    
    @java.lang.Override()
    public int getBufferedMessageCount() {
        return 0;
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.NotNull()
    public org.eclipse.paho.client.mqttv3.MqttMessage getBufferedMessage(int bufferIndex) {
        return null;
    }
    
    @java.lang.Override()
    public void deleteBufferedMessage(int bufferIndex) {
    }
    
    @java.lang.Override()
    public int getInFlightMessageCount() {
        return 0;
    }
    
    /**
     * Get the SSLSocketFactory using SSL key store and password
     * A convenience method, which will help user to create a SSLSocketFactory
     * object
     *
     * @param keyStore the SSL key store which is generated by some SSL key tool,
     * such as keytool in Java JDK
     * @param password the password of the key store which is set when the key store
     * is generated
     * @return SSLSocketFactory used to connect to the server with SSL
     * authentication
     * @throws MqttSecurityException if there was any error when getting the SSLSocketFactory
     */
    @kotlin.jvm.Throws(exceptionClasses = {org.eclipse.paho.client.mqttv3.MqttSecurityException.class})
    @org.jetbrains.annotations.NotNull()
    public final javax.net.ssl.SSLSocketFactory getSSLSocketFactory(@org.jetbrains.annotations.Nullable()
    java.io.InputStream keyStore, @org.jetbrains.annotations.NotNull()
    java.lang.String password) throws org.eclipse.paho.client.mqttv3.MqttSecurityException {
        return null;
    }
    
    @java.lang.Override()
    @kotlin.jvm.Throws(exceptionClasses = {org.eclipse.paho.client.mqttv3.MqttException.class})
    public void disconnectForcibly() throws org.eclipse.paho.client.mqttv3.MqttException {
    }
    
    @java.lang.Override()
    @kotlin.jvm.Throws(exceptionClasses = {org.eclipse.paho.client.mqttv3.MqttException.class})
    public void disconnectForcibly(long disconnectTimeout) throws org.eclipse.paho.client.mqttv3.MqttException {
    }
    
    @java.lang.Override()
    @kotlin.jvm.Throws(exceptionClasses = {org.eclipse.paho.client.mqttv3.MqttException.class})
    public void disconnectForcibly(long quiesceTimeout, long disconnectTimeout) throws org.eclipse.paho.client.mqttv3.MqttException {
    }
    
    /**
     * Unregister receiver which receives intent from MqttService avoids
     * IntentReceiver leaks.
     */
    public final void unregisterResources() {
    }
    
    /**
     * Register receiver to receiver intent from MqttService. Call this method when activity is hidden and become to show again.
     */
    public final void registerResources() {
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u0016\u0010\u0003\u001a\n \u0005*\u0004\u0018\u00010\u00040\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0006"}, d2 = {"Linfo/mqtt/android/service/MqttAndroidClient$Companion;", "", "()V", "SERVICE_NAME", "", "kotlin.jvm.PlatformType", "serviceLibrary_debug"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
    }
    
    /**
     * ServiceConnection to process when we bind to our service
     */
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0082\u0004\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0018\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0016J\u0010\u0010\t\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016\u00a8\u0006\n"}, d2 = {"Linfo/mqtt/android/service/MqttAndroidClient$MyServiceConnection;", "Landroid/content/ServiceConnection;", "(Linfo/mqtt/android/service/MqttAndroidClient;)V", "onServiceConnected", "", "name", "Landroid/content/ComponentName;", "binder", "Landroid/os/IBinder;", "onServiceDisconnected", "serviceLibrary_debug"})
    final class MyServiceConnection implements android.content.ServiceConnection {
        
        public MyServiceConnection() {
            super();
        }
        
        @java.lang.Override()
        public void onServiceConnected(@org.jetbrains.annotations.NotNull()
        android.content.ComponentName name, @org.jetbrains.annotations.NotNull()
        android.os.IBinder binder) {
        }
        
        @java.lang.Override()
        public void onServiceDisconnected(@org.jetbrains.annotations.NotNull()
        android.content.ComponentName name) {
        }
    }
}