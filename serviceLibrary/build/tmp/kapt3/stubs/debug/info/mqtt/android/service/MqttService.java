package info.mqtt.android.service;

/**
 * The android service which interfaces with an MQTT client implementation
 *
 * The main API of MqttService is intended to pretty much mirror the
 * IMqttAsyncClient with appropriate adjustments for the Android environment.<br></br>
 * These adjustments usually consist of adding two parameters to each method :-
 *
 *  * invocationContext - a string passed from the application to identify the
 * context of the operation (mainly included for support of the javascript API
 * implementation)
 *  * activityToken - a string passed from the Activity to relate back to a
 * callback method or other context-specific data
 *
 * To support multiple client connections, the bulk of the MQTT work is
 * delegated to MqttConnection objects. These are identified by "client
 * handle" strings, which is how the Activity, and the higher-level APIs refer
 * to them.
 *
 * Activities using this service are expected to start it and bind to it using
 * the BIND_AUTO_CREATE flag. The life cycle of this service is based on this
 * approach.
 *
 * Operations are highly asynchronous - in most cases results are returned to
 * the Activity by broadcasting one (or occasionally more) appropriate Intents,
 * which the Activity is expected to register a listener for.<br></br>
 * The Intents have an Action of
 * [ MqttServiceConstants.CALLBACK_TO_ACTIVITY][MqttServiceConstants.CALLBACK_TO_ACTIVITY] which allows the Activity to
 * register a listener with an appropriate IntentFilter.<br></br>
 * Further data is provided by "Extra Data" in the Intent, as follows :-
 *
 * <table border="1" summary="">
 * <tr>
 * <th align="left">Name</th>
 * <th align="left">Data Type</th>
 * <th align="left">Value</th>
 * <th align="left">Operations used for</th>
 * </tr> *
 * <tr>
 * <td align="left" valign="top">
 * [ MqttServiceConstants.CALLBACK_CLIENT_HANDLE][MqttServiceConstants.CALLBACK_CLIENT_HANDLE]</td>
 * <td align="left" valign="top">String</td>
 * <td align="left" valign="top">The clientHandle identifying the client which
 * initiated this operation</td>
 * <td align="left" valign="top">All operations</td>
 * </tr> *
 * <tr>
 * <td align="left" valign="top">[ MqttServiceConstants.CALLBACK_STATUS][MqttServiceConstants.CALLBACK_STATUS]</td>
 * <td align="left" valign="top">Serializable</td>
 * <td align="left" valign="top">An [Status] value indicating success or
 * otherwise of the operation</td>
 * <td align="left" valign="top">All operations</td>
 * </tr> *
 * <tr>
 * <td align="left" valign="top">
 * [ MqttServiceConstants.CALLBACK_ACTIVITY_TOKEN][MqttServiceConstants.CALLBACK_ACTIVITY_TOKEN]</td>
 * <td align="left" valign="top">String</td>
 * <td align="left" valign="top">the activityToken passed into the operation</td>
 * <td align="left" valign="top">All operations</td>
 * </tr> *
 * <tr>
 * <td align="left" valign="top">
 * [ MqttServiceConstants.CALLBACK_INVOCATION_CONTEXT][MqttServiceConstants.CALLBACK_INVOCATION_CONTEXT]</td>
 * <td align="left" valign="top">String</td>
 * <td align="left" valign="top">the invocationContext passed into the operation
 * </td> *
 * <td align="left" valign="top">All operations</td>
 * </tr> *
 * <tr>
 * <td align="left" valign="top">[ MqttServiceConstants.CALLBACK_ACTION][MqttServiceConstants.CALLBACK_ACTION]</td>
 * <td align="left" valign="top">String</td>
 * <td align="left" valign="top">one of
 * <table summary="">
 * <tr>
 * <td align="left" valign="top"> [ MqttServiceConstants.SEND_ACTION][MqttServiceConstants.SEND_ACTION]</td>
 * </tr> *
 * <tr>
 * <td align="left" valign="top">
 * [ MqttServiceConstants.UNSUBSCRIBE_ACTION][MqttServiceConstants.UNSUBSCRIBE_ACTION]</td>
 * </tr> *
 * <tr>
 * <td align="left" valign="top"> [ MqttServiceConstants.SUBSCRIBE_ACTION][MqttServiceConstants.SUBSCRIBE_ACTION]</td>
 * </tr> *
 * <tr>
 * <td align="left" valign="top"> [ MqttServiceConstants.DISCONNECT_ACTION][MqttServiceConstants.DISCONNECT_ACTION]</td>
 * </tr> *
 * <tr>
 * <td align="left" valign="top"> [ MqttServiceConstants.CONNECT_ACTION][MqttServiceConstants.CONNECT_ACTION]</td>
 * </tr> *
 * <tr>
 * <td align="left" valign="top">
 * [ MqttServiceConstants.MESSAGE_ARRIVED_ACTION][MqttServiceConstants.MESSAGE_ARRIVED_ACTION]</td>
 * </tr> *
 * <tr>
 * <td align="left" valign="top">
 * [ MqttServiceConstants.MESSAGE_DELIVERED_ACTION][MqttServiceConstants.MESSAGE_DELIVERED_ACTION]</td>
 * </tr> *
 * <tr>
 * <td align="left" valign="top">
 * [ MqttServiceConstants.ON_CONNECTION_LOST_ACTION][MqttServiceConstants.ON_CONNECTION_LOST_ACTION]</td>
 * </tr> *
 * </table> *
 * </td> *
 * <td align="left" valign="top">All operations</td>
 * </tr> *
 * <tr>
 * <td align="left" valign="top">
 * [ MqttServiceConstants.CALLBACK_ERROR_MESSAGE][MqttServiceConstants.CALLBACK_ERROR_MESSAGE]
 * </td> * <td align="left" valign="top">String</td>
 * <td align="left" valign="top">A suitable error message (taken from the
 * relevant exception where possible)</td>
 * <td align="left" valign="top">All failing operations</td>
 * </tr> *
 * <tr>
 * <td align="left" valign="top">
 * [ MqttServiceConstants.CALLBACK_ERROR_NUMBER][MqttServiceConstants.CALLBACK_ERROR_NUMBER]
 * </td> * <td align="left" valign="top">int</td>
 * <td align="left" valign="top">A suitable error code (taken from the relevant
 * exception where possible)</td>
 * <td align="left" valign="top">All failing operations</td>
 * </tr> *
 * <tr>
 * <td align="left" valign="top">
 * [ MqttServiceConstants.CALLBACK_EXCEPTION_STACK][MqttServiceConstants.CALLBACK_EXCEPTION_STACK]</td>
 * <td align="left" valign="top">String</td>
 * <td align="left" valign="top">The stacktrace of the failing call</td>
 * <td align="left" valign="top">The Connection Lost event</td>
 * </tr> *
 * <tr>
 * <td align="left" valign="top">
 * [ MqttServiceConstants.CALLBACK_MESSAGE_ID][MqttServiceConstants.CALLBACK_MESSAGE_ID]</td>
 * <td align="left" valign="top">String</td>
 * <td align="left" valign="top">The identifier for the message in the message
 * store, used by the Activity to acknowledge the arrival of the message, so
 * that the service may remove it from the store</td>
 * <td align="left" valign="top">The Message Arrived event</td>
 * </tr> *
 * <tr>
 * <td align="left" valign="top">
 * [ MqttServiceConstants.CALLBACK_DESTINATION_NAME][MqttServiceConstants.CALLBACK_DESTINATION_NAME]
 * </td> * <td align="left" valign="top">String</td>
 * <td align="left" valign="top">The topic on which the message was received</td>
 * <td align="left" valign="top">The Message Arrived event</td>
 * </tr> *
 * <tr>
 * <td align="left" valign="top">
 * [ MqttServiceConstants.CALLBACK_MESSAGE_PARCEL][MqttServiceConstants.CALLBACK_MESSAGE_PARCEL]</td>
 * <td align="left" valign="top">Parcelable</td>
 * <td align="left" valign="top">The new message encapsulated in Android
 * Parcelable format as a [ParcelableMqttMessage]</td>
 * <td align="left" valign="top">The Message Arrived event</td>
 * </tr> *
 * </table> *
 */
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\u00ec\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0015\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u00012\u00020\u0002:\u0001}B\u0005\u00a2\u0006\u0002\u0010\u0003J\u0016\u0010\"\u001a\u00020#2\u0006\u0010$\u001a\u00020\u00062\u0006\u0010%\u001a\u00020\u0006J\u001e\u0010&\u001a\u00020\'2\u0006\u0010$\u001a\u00020\u00062\u0006\u0010(\u001a\u00020#2\u0006\u0010)\u001a\u00020\fJ\u000e\u0010*\u001a\u00020\'2\u0006\u0010$\u001a\u00020\u0006J\"\u0010+\u001a\u00020\'2\u0012\u0010,\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\'0-H\u0086@\u00a2\u0006\u0002\u0010.J\"\u0010/\u001a\u00020\'2\u0006\u0010$\u001a\u00020\u00062\b\u00100\u001a\u0004\u0018\u0001012\b\u00102\u001a\u0004\u0018\u000103J\u0016\u00104\u001a\u00020\'2\u0006\u0010$\u001a\u00020\u00062\u0006\u00105\u001a\u000206J(\u00107\u001a\u00020\'2\u0006\u0010$\u001a\u00020\u00062\u0006\u00108\u001a\u0002092\b\u0010:\u001a\u0004\u0018\u00010\u00062\u0006\u00102\u001a\u000203J\"\u00107\u001a\u00020\'2\u0006\u0010$\u001a\u00020\u00062\b\u0010:\u001a\u0004\u0018\u00010\u00062\b\u00102\u001a\u0004\u0018\u000103J\u0016\u0010;\u001a\u00020<2\u0006\u0010$\u001a\u00020\u00062\u0006\u00105\u001a\u000206J\u000e\u0010=\u001a\u0002062\u0006\u0010$\u001a\u00020\u0006J<\u0010>\u001a\u00020\u00062\u0006\u0010?\u001a\u00020\u00062\u0006\u0010@\u001a\u00020\u00062\u0006\u0010A\u001a\u00020\u00062\b\u0010B\u001a\u0004\u0018\u00010C2\b\b\u0002\u0010D\u001a\u00020\u000e2\b\b\u0002\u0010E\u001a\u000206J\u0010\u0010F\u001a\u00020\u00072\u0006\u0010$\u001a\u00020\u0006H\u0002J\u000e\u0010G\u001a\u0002062\u0006\u0010$\u001a\u00020\u0006J\u0019\u0010H\u001a\b\u0012\u0004\u0012\u00020J0I2\u0006\u0010$\u001a\u00020\u0006\u00a2\u0006\u0002\u0010KJ\u000e\u0010L\u001a\u00020\u000e2\u0006\u0010$\u001a\u00020\u0006J\u0010\u0010M\u001a\u00020\u000e2\u0006\u0010$\u001a\u00020\u0006H\u0002J\u0010\u0010N\u001a\u00020\u000e2\u0006\u0010O\u001a\u00020PH\u0002J\u000e\u0010Q\u001a\u00020\u000e2\u0006\u0010O\u001a\u00020PJ\b\u0010R\u001a\u00020\'H\u0002J\u0012\u0010S\u001a\u0004\u0018\u00010T2\u0006\u0010U\u001a\u00020VH\u0016J\b\u0010W\u001a\u00020\'H\u0016J\b\u0010X\u001a\u00020\'H\u0016J\"\u0010Y\u001a\u0002062\b\u0010U\u001a\u0004\u0018\u00010V2\u0006\u0010Z\u001a\u0002062\u0006\u0010[\u001a\u000206H\u0016JD\u0010\\\u001a\u0004\u0018\u00010J2\u0006\u0010$\u001a\u00020\u00062\u0006\u0010]\u001a\u00020\u00062\u0006\u0010^\u001a\u00020_2\u0006\u0010`\u001a\u00020a2\u0006\u0010b\u001a\u00020\u000e2\b\u0010:\u001a\u0004\u0018\u00010\u00062\b\u00102\u001a\u0004\u0018\u000103J2\u0010\\\u001a\u0004\u0018\u00010J2\u0006\u0010$\u001a\u00020\u00062\u0006\u0010]\u001a\u00020\u00062\u0006\u0010c\u001a\u00020<2\b\u0010:\u001a\u0004\u0018\u00010\u00062\u0006\u00102\u001a\u000203J\u000e\u0010d\u001a\u00020\'2\u0006\u0010O\u001a\u00020PJ\b\u0010e\u001a\u00020\'H\u0002J\u0018\u0010f\u001a\u00020\'2\u0006\u0010$\u001a\u00020\u00062\b\u0010g\u001a\u0004\u0018\u00010hJ\u0010\u0010i\u001a\u00020\'2\b\u0010!\u001a\u0004\u0018\u00010\u0006J\b\u0010j\u001a\u00020\'H\u0002JS\u0010k\u001a\u00020\'2\u0006\u0010$\u001a\u00020\u00062\f\u0010l\u001a\b\u0012\u0004\u0012\u00020\u00060I2\f\u0010`\u001a\b\u0012\u0004\u0012\u00020a0I2\b\u0010:\u001a\u0004\u0018\u00010\u00062\b\u00102\u001a\u0004\u0018\u0001032\u000e\u0010m\u001a\n\u0012\u0004\u0012\u00020n\u0018\u00010I\u00a2\u0006\u0002\u0010oJ=\u0010k\u001a\u00020\'2\u0006\u0010$\u001a\u00020\u00062\f\u0010]\u001a\b\u0012\u0004\u0012\u00020\u00060I2\b\u0010`\u001a\u0004\u0018\u00010p2\b\u0010:\u001a\u0004\u0018\u00010\u00062\u0006\u00102\u001a\u000203\u00a2\u0006\u0002\u0010qJ0\u0010k\u001a\u00020\'2\u0006\u0010$\u001a\u00020\u00062\u0006\u0010]\u001a\u00020\u00062\u0006\u0010`\u001a\u00020a2\b\u0010:\u001a\u0004\u0018\u00010\u00062\u0006\u00102\u001a\u000203J\u001a\u0010r\u001a\u00020\'2\u0006\u0010s\u001a\u00020\u00062\b\u0010c\u001a\u0004\u0018\u00010\u0006H\u0002J\u0012\u0010t\u001a\u00020\'2\b\u0010c\u001a\u0004\u0018\u00010\u0006H\u0016J\u0012\u0010u\u001a\u00020\'2\b\u0010c\u001a\u0004\u0018\u00010\u0006H\u0016J\"\u0010v\u001a\u00020\'2\b\u0010c\u001a\u0004\u0018\u00010\u00062\u000e\u0010w\u001a\n\u0018\u00010xj\u0004\u0018\u0001`yH\u0016J\b\u0010z\u001a\u00020\'H\u0002J5\u0010{\u001a\u00020\'2\u0006\u0010$\u001a\u00020\u00062\f\u0010]\u001a\b\u0012\u0004\u0012\u00020\u00060I2\b\u0010:\u001a\u0004\u0018\u00010\u00062\b\u00102\u001a\u0004\u0018\u000103\u00a2\u0006\u0002\u0010|J(\u0010{\u001a\u00020\'2\u0006\u0010$\u001a\u00020\u00062\u0006\u0010]\u001a\u00020\u00062\b\u0010:\u001a\u0004\u0018\u00010\u00062\u0006\u00102\u001a\u000203R \u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005X\u0080\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0014\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001a\u0010\u000f\u001a\u00020\u000eX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u001a\u0010\u0013\u001a\u00020\u0014X\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\u0010\u0010\u0019\u001a\u0004\u0018\u00010\u001aX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u001b\u001a\b\u0018\u00010\u001cR\u00020\u0000X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u001d\u001a\u0004\u0018\u00010\u001eX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u001f\u001a\u0004\u0018\u00010 X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010!\u001a\u0004\u0018\u00010\u0006X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006~"}, d2 = {"Linfo/mqtt/android/service/MqttService;", "Landroid/app/Service;", "Linfo/mqtt/android/service/MqttTraceHandler;", "()V", "connections", "", "", "Linfo/mqtt/android/service/MqttConnection;", "getConnections$serviceLibrary_debug", "()Ljava/util/Map;", "flow", "Lkotlinx/coroutines/flow/MutableSharedFlow;", "Landroid/os/Bundle;", "isForegroundStarted", "", "isTraceEnabled", "()Z", "setTraceEnabled", "(Z)V", "messageDatabase", "Linfo/mqtt/android/service/room/MqMessageDatabase;", "getMessageDatabase", "()Linfo/mqtt/android/service/room/MqMessageDatabase;", "setMessageDatabase", "(Linfo/mqtt/android/service/room/MqMessageDatabase;)V", "mqttServiceBinder", "Linfo/mqtt/android/service/MqttServiceBinder;", "networkConnectionMonitor", "Linfo/mqtt/android/service/MqttService$NetworkConnectionIntentReceiver;", "serviceJob", "Lkotlinx/coroutines/Job;", "serviceScope", "Lkotlinx/coroutines/CoroutineScope;", "traceCallbackId", "acknowledgeMessageArrival", "Linfo/mqtt/android/service/Status;", "clientHandle", "id", "callbackToActivity", "", "status", "dataBundle", "close", "collect", "block", "Lkotlin/Function1;", "(Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "connect", "connectOptions", "Lorg/eclipse/paho/client/mqttv3/MqttConnectOptions;", "activityToken", "Lorg/eclipse/paho/client/mqttv3/IMqttToken;", "deleteBufferedMessage", "bufferIndex", "", "disconnect", "quiesceTimeout", "", "invocationContext", "getBufferedMessage", "Lorg/eclipse/paho/client/mqttv3/MqttMessage;", "getBufferedMessageCount", "getClient", "serverURI", "clientId", "contextId", "persistence", "Lorg/eclipse/paho/client/mqttv3/MqttClientPersistence;", "pingLogging", "keepPingRecords", "getConnection", "getInFlightMessageCount", "getPendingDeliveryTokens", "", "Lorg/eclipse/paho/client/mqttv3/IMqttDeliveryToken;", "(Ljava/lang/String;)[Lorg/eclipse/paho/client/mqttv3/IMqttDeliveryToken;", "isConnected", "isConnectionAvailable", "isInternetAvailable", "context", "Landroid/content/Context;", "isOnline", "notifyClientsOffline", "onBind", "Landroid/os/IBinder;", "intent", "Landroid/content/Intent;", "onCreate", "onDestroy", "onStartCommand", "flags", "startId", "publish", "topic", "payload", "", "qos", "Linfo/mqtt/android/service/QoS;", "retained", "message", "reconnect", "registerBroadcastReceivers", "setBufferOpts", "bufferOpts", "Lorg/eclipse/paho/client/mqttv3/DisconnectedBufferOptions;", "setTraceCallbackId", "stopService", "subscribe", "topicFilters", "messageListeners", "Lorg/eclipse/paho/client/mqttv3/IMqttMessageListener;", "(Ljava/lang/String;[Ljava/lang/String;[Linfo/mqtt/android/service/QoS;Ljava/lang/String;Lorg/eclipse/paho/client/mqttv3/IMqttToken;[Lorg/eclipse/paho/client/mqttv3/IMqttMessageListener;)V", "", "(Ljava/lang/String;[Ljava/lang/String;[ILjava/lang/String;Lorg/eclipse/paho/client/mqttv3/IMqttToken;)V", "traceCallback", "severity", "traceDebug", "traceError", "traceException", "e", "Ljava/lang/Exception;", "Lkotlin/Exception;", "unregisterBroadcastReceivers", "unsubscribe", "(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Lorg/eclipse/paho/client/mqttv3/IMqttToken;)V", "NetworkConnectionIntentReceiver", "serviceLibrary_debug"})
@android.annotation.SuppressLint(value = {"Registered"})
public final class MqttService extends android.app.Service implements info.mqtt.android.service.MqttTraceHandler {
    @org.jetbrains.annotations.NotNull()
    private final java.util.Map<java.lang.String, info.mqtt.android.service.MqttConnection> connections = null;
    public info.mqtt.android.service.room.MqMessageDatabase messageDatabase;
    @org.jetbrains.annotations.Nullable()
    private java.lang.String traceCallbackId;
    private boolean isForegroundStarted = false;
    private boolean isTraceEnabled = false;
    @org.jetbrains.annotations.Nullable()
    private info.mqtt.android.service.MqttService.NetworkConnectionIntentReceiver networkConnectionMonitor;
    @org.jetbrains.annotations.Nullable()
    private info.mqtt.android.service.MqttServiceBinder mqttServiceBinder;
    @org.jetbrains.annotations.Nullable()
    private kotlinx.coroutines.Job serviceJob;
    @org.jetbrains.annotations.Nullable()
    private kotlinx.coroutines.CoroutineScope serviceScope;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.MutableSharedFlow<android.os.Bundle> flow = null;
    
    public MqttService() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.Map<java.lang.String, info.mqtt.android.service.MqttConnection> getConnections$serviceLibrary_debug() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final info.mqtt.android.service.room.MqMessageDatabase getMessageDatabase() {
        return null;
    }
    
    public final void setMessageDatabase(@org.jetbrains.annotations.NotNull()
    info.mqtt.android.service.room.MqMessageDatabase p0) {
    }
    
    public final boolean isTraceEnabled() {
        return false;
    }
    
    public final void setTraceEnabled(boolean p0) {
    }
    
    @java.lang.Override()
    public void onCreate() {
    }
    
    @java.lang.Override()
    public void onDestroy() {
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.Nullable()
    public android.os.IBinder onBind(@org.jetbrains.annotations.NotNull()
    android.content.Intent intent) {
        return null;
    }
    
    @java.lang.Override()
    public int onStartCommand(@org.jetbrains.annotations.Nullable()
    android.content.Intent intent, int flags, int startId) {
        return 0;
    }
    
    /**
     * pass data back to the Activity, by flow
     *
     * @param clientHandle source of the data
     * @param status       OK or Error
     * @param dataBundle   the data to be passed
     */
    public final void callbackToActivity(@org.jetbrains.annotations.NotNull()
    java.lang.String clientHandle, @org.jetbrains.annotations.NotNull()
    info.mqtt.android.service.Status status, @org.jetbrains.annotations.NotNull()
    android.os.Bundle dataBundle) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object collect(@org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function1<? super android.os.Bundle, kotlin.Unit> block, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion) {
        return null;
    }
    
    /**
     * Get an MqttConnection object to represent a connection to a server
     *
     * @param serverURI   specifies the protocol, host name and port to be used to connect to an MQTT server
     * @param clientId    specifies the name by which this connection should be identified to the server
     * @param contextId   specifies the app context info to make a difference between apps
     * @param persistence specifies the persistence layer to be used with this client
     * @return a string to be used by the Activity as a "handle" for this MqttConnection
     */
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getClient(@org.jetbrains.annotations.NotNull()
    java.lang.String serverURI, @org.jetbrains.annotations.NotNull()
    java.lang.String clientId, @org.jetbrains.annotations.NotNull()
    java.lang.String contextId, @org.jetbrains.annotations.Nullable()
    org.eclipse.paho.client.mqttv3.MqttClientPersistence persistence, boolean pingLogging, int keepPingRecords) {
        return null;
    }
    
    /**
     * Connect to the MQTT server specified by a particular client
     *
     * @param clientHandle   identifies the MqttConnection to use
     * @param connectOptions the MQTT connection options to be used
     * @param activityToken  arbitrary identifier to be passed back to the Activity
     */
    @kotlin.jvm.Throws(exceptionClasses = {org.eclipse.paho.client.mqttv3.MqttException.class})
    public final void connect(@org.jetbrains.annotations.NotNull()
    java.lang.String clientHandle, @org.jetbrains.annotations.Nullable()
    org.eclipse.paho.client.mqttv3.MqttConnectOptions connectOptions, @org.jetbrains.annotations.Nullable()
    org.eclipse.paho.client.mqttv3.IMqttToken activityToken) throws org.eclipse.paho.client.mqttv3.MqttException {
    }
    
    public final void reconnect(@org.jetbrains.annotations.NotNull()
    android.content.Context context) {
    }
    
    /**
     * Close connection from a particular client
     *
     * @param clientHandle identifies the MqttConnection to use
     */
    public final void close(@org.jetbrains.annotations.NotNull()
    java.lang.String clientHandle) {
    }
    
    /**
     * Stop service, removing the notification if needed
     */
    private final void stopService() {
    }
    
    /**
     * Disconnect from the server
     *
     * @param clientHandle      identifies the MqttConnection to use
     * @param invocationContext arbitrary data to be passed back to the application
     * @param activityToken     arbitrary identifier to be passed back to the Activity
     */
    public final void disconnect(@org.jetbrains.annotations.NotNull()
    java.lang.String clientHandle, @org.jetbrains.annotations.Nullable()
    java.lang.String invocationContext, @org.jetbrains.annotations.Nullable()
    org.eclipse.paho.client.mqttv3.IMqttToken activityToken) {
    }
    
    /**
     * Disconnect from the server
     *
     * @param clientHandle      identifies the MqttConnection to use
     * @param quiesceTimeout    in milliseconds
     * @param invocationContext arbitrary data to be passed back to the application
     * @param activityToken     arbitrary identifier to be passed back to the Activity
     */
    public final void disconnect(@org.jetbrains.annotations.NotNull()
    java.lang.String clientHandle, long quiesceTimeout, @org.jetbrains.annotations.Nullable()
    java.lang.String invocationContext, @org.jetbrains.annotations.NotNull()
    org.eclipse.paho.client.mqttv3.IMqttToken activityToken) {
    }
    
    /**
     * Get the status of a specific client
     *
     * @param clientHandle identifies the MqttConnection to use
     * @return true if the specified client is connected to an MQTT server
     */
    public final boolean isConnected(@org.jetbrains.annotations.NotNull()
    java.lang.String clientHandle) {
        return false;
    }
    
    /**
     * Publish a message to a topic
     *
     * @param clientHandle      identifies the MqttConnection to use
     * @param topic             the topic to which to publish
     * @param payload           the content of the message to publish
     * @param qos               the quality of service requested
     * @param retained          whether the MQTT server should retain this message
     * @param invocationContext arbitrary data to be passed back to the application
     * @param activityToken     arbitrary identifier to be passed back to the Activity
     * @return token for tracking the operation
     */
    @org.jetbrains.annotations.Nullable()
    public final org.eclipse.paho.client.mqttv3.IMqttDeliveryToken publish(@org.jetbrains.annotations.NotNull()
    java.lang.String clientHandle, @org.jetbrains.annotations.NotNull()
    java.lang.String topic, @org.jetbrains.annotations.NotNull()
    byte[] payload, @org.jetbrains.annotations.NotNull()
    info.mqtt.android.service.QoS qos, boolean retained, @org.jetbrains.annotations.Nullable()
    java.lang.String invocationContext, @org.jetbrains.annotations.Nullable()
    org.eclipse.paho.client.mqttv3.IMqttToken activityToken) {
        return null;
    }
    
    /**
     * Publish a message to a topic
     *
     * @param clientHandle      identifies the MqttConnection to use
     * @param topic             the topic to which to publish
     * @param message           the message to publish
     * @param invocationContext arbitrary data to be passed back to the application
     * @param activityToken     arbitrary identifier to be passed back to the Activity
     * @return token for tracking the operation
     */
    @org.jetbrains.annotations.Nullable()
    public final org.eclipse.paho.client.mqttv3.IMqttDeliveryToken publish(@org.jetbrains.annotations.NotNull()
    java.lang.String clientHandle, @org.jetbrains.annotations.NotNull()
    java.lang.String topic, @org.jetbrains.annotations.NotNull()
    org.eclipse.paho.client.mqttv3.MqttMessage message, @org.jetbrains.annotations.Nullable()
    java.lang.String invocationContext, @org.jetbrains.annotations.NotNull()
    org.eclipse.paho.client.mqttv3.IMqttToken activityToken) {
        return null;
    }
    
    /**
     * Subscribe to a topic
     *
     * @param clientHandle      identifies the MqttConnection to use
     * @param topic             a possibly wildcarded topic name
     * @param qos               requested quality of service for the topic
     * @param invocationContext arbitrary data to be passed back to the application
     * @param activityToken     arbitrary identifier to be passed back to the Activity
     */
    public final void subscribe(@org.jetbrains.annotations.NotNull()
    java.lang.String clientHandle, @org.jetbrains.annotations.NotNull()
    java.lang.String topic, @org.jetbrains.annotations.NotNull()
    info.mqtt.android.service.QoS qos, @org.jetbrains.annotations.Nullable()
    java.lang.String invocationContext, @org.jetbrains.annotations.NotNull()
    org.eclipse.paho.client.mqttv3.IMqttToken activityToken) {
    }
    
    /**
     * Subscribe to one or more topics
     *
     * @param clientHandle      identifies the MqttConnection to use
     * @param topic             a list of possibly wildcarded topic names
     * @param qos               requested quality of service for each topic
     * @param invocationContext arbitrary data to be passed back to the application
     * @param activityToken     arbitrary identifier to be passed back to the Activity
     */
    public final void subscribe(@org.jetbrains.annotations.NotNull()
    java.lang.String clientHandle, @org.jetbrains.annotations.NotNull()
    java.lang.String[] topic, @org.jetbrains.annotations.Nullable()
    int[] qos, @org.jetbrains.annotations.Nullable()
    java.lang.String invocationContext, @org.jetbrains.annotations.NotNull()
    org.eclipse.paho.client.mqttv3.IMqttToken activityToken) {
    }
    
    /**
     * Subscribe using topic filters
     *
     * @param clientHandle      identifies the MqttConnection to use
     * @param topicFilters      a list of possibly wildcarded topicfilters
     * @param qos               requested quality of service for each topic
     * @param invocationContext arbitrary data to be passed back to the application
     * @param activityToken     arbitrary identifier to be passed back to the Activity
     * @param messageListeners  a callback to handle incoming messages
     */
    public final void subscribe(@org.jetbrains.annotations.NotNull()
    java.lang.String clientHandle, @org.jetbrains.annotations.NotNull()
    java.lang.String[] topicFilters, @org.jetbrains.annotations.NotNull()
    info.mqtt.android.service.QoS[] qos, @org.jetbrains.annotations.Nullable()
    java.lang.String invocationContext, @org.jetbrains.annotations.Nullable()
    org.eclipse.paho.client.mqttv3.IMqttToken activityToken, @org.jetbrains.annotations.Nullable()
    org.eclipse.paho.client.mqttv3.IMqttMessageListener[] messageListeners) {
    }
    
    /**
     * Unsubscribe from a topic
     *
     * @param clientHandle      identifies the MqttConnection
     * @param topic             a possibly wildcarded topic name
     * @param invocationContext arbitrary data to be passed back to the application
     * @param activityToken     arbitrary identifier to be passed back to the Activity
     */
    public final void unsubscribe(@org.jetbrains.annotations.NotNull()
    java.lang.String clientHandle, @org.jetbrains.annotations.NotNull()
    java.lang.String topic, @org.jetbrains.annotations.Nullable()
    java.lang.String invocationContext, @org.jetbrains.annotations.NotNull()
    org.eclipse.paho.client.mqttv3.IMqttToken activityToken) {
    }
    
    /**
     * Unsubscribe from one or more topics
     *
     * @param clientHandle      identifies the MqttConnection
     * @param topic             a list of possibly wildcarded topic names
     * @param invocationContext arbitrary data to be passed back to the application
     * @param activityToken     arbitrary identifier to be passed back to the Activity
     */
    public final void unsubscribe(@org.jetbrains.annotations.NotNull()
    java.lang.String clientHandle, @org.jetbrains.annotations.NotNull()
    java.lang.String[] topic, @org.jetbrains.annotations.Nullable()
    java.lang.String invocationContext, @org.jetbrains.annotations.Nullable()
    org.eclipse.paho.client.mqttv3.IMqttToken activityToken) {
    }
    
    /**
     * Get tokens for all outstanding deliveries for a client
     *
     * @param clientHandle identifies the MqttConnection
     * @return an array (possibly empty) of tokens
     */
    @org.jetbrains.annotations.NotNull()
    public final org.eclipse.paho.client.mqttv3.IMqttDeliveryToken[] getPendingDeliveryTokens(@org.jetbrains.annotations.NotNull()
    java.lang.String clientHandle) {
        return null;
    }
    
    /**
     * Get the MqttConnection identified by this client handle
     *
     * @param clientHandle identifies the MqttConnection
     * @return the MqttConnection identified by this handle
     */
    private final info.mqtt.android.service.MqttConnection getConnection(java.lang.String clientHandle) {
        return null;
    }
    
    private final boolean isConnectionAvailable(java.lang.String clientHandle) {
        return false;
    }
    
    /**
     * Called by the Activity when a message has been passed back to the application
     *
     * @param clientHandle identifier for the client which received the message
     * @param id           identifier for the MQTT message
     * @return [Status]
     */
    @org.jetbrains.annotations.NotNull()
    public final info.mqtt.android.service.Status acknowledgeMessageArrival(@org.jetbrains.annotations.NotNull()
    java.lang.String clientHandle, @org.jetbrains.annotations.NotNull()
    java.lang.String id) {
        return null;
    }
    
    /**
     * Identify the callbackId to be passed when making tracing calls back into the Activity
     *
     * @param traceCallbackId identifier to the callback into the Activity
     */
    public final void setTraceCallbackId(@org.jetbrains.annotations.Nullable()
    java.lang.String traceCallbackId) {
    }
    
    /**
     * Trace debugging information
     *
     * @param message the text to be traced
     */
    @java.lang.Override()
    public void traceDebug(@org.jetbrains.annotations.Nullable()
    java.lang.String message) {
    }
    
    /**
     * Trace error information
     *
     * @param message the text to be traced
     */
    @java.lang.Override()
    public void traceError(@org.jetbrains.annotations.Nullable()
    java.lang.String message) {
    }
    
    private final void traceCallback(java.lang.String severity, java.lang.String message) {
    }
    
    /**
     * trace exceptions
     *
     * @param message the text to be traced
     * @param e       the exception
     */
    @java.lang.Override()
    public void traceException(@org.jetbrains.annotations.Nullable()
    java.lang.String message, @org.jetbrains.annotations.Nullable()
    java.lang.Exception e) {
    }
    
    private final void registerBroadcastReceivers() {
    }
    
    private final void unregisterBroadcastReceivers() {
    }
    
    public final boolean isOnline(@org.jetbrains.annotations.NotNull()
    android.content.Context context) {
        return false;
    }
    
    private final void notifyClientsOffline() {
    }
    
    @kotlin.Suppress(names = {"DEPRECATION"})
    private final boolean isInternetAvailable(android.content.Context context) {
        return false;
    }
    
    /**
     * Sets the DisconnectedBufferOptions for this client
     */
    public final void setBufferOpts(@org.jetbrains.annotations.NotNull()
    java.lang.String clientHandle, @org.jetbrains.annotations.Nullable()
    org.eclipse.paho.client.mqttv3.DisconnectedBufferOptions bufferOpts) {
    }
    
    public final int getBufferedMessageCount(@org.jetbrains.annotations.NotNull()
    java.lang.String clientHandle) {
        return 0;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final org.eclipse.paho.client.mqttv3.MqttMessage getBufferedMessage(@org.jetbrains.annotations.NotNull()
    java.lang.String clientHandle, int bufferIndex) {
        return null;
    }
    
    public final void deleteBufferedMessage(@org.jetbrains.annotations.NotNull()
    java.lang.String clientHandle, int bufferIndex) {
    }
    
    public final int getInFlightMessageCount(@org.jetbrains.annotations.NotNull()
    java.lang.String clientHandle) {
        return 0;
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0082\u0004\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0018\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0017\u00a8\u0006\t"}, d2 = {"Linfo/mqtt/android/service/MqttService$NetworkConnectionIntentReceiver;", "Landroid/content/BroadcastReceiver;", "(Linfo/mqtt/android/service/MqttService;)V", "onReceive", "", "context", "Landroid/content/Context;", "intent", "Landroid/content/Intent;", "serviceLibrary_debug"})
    final class NetworkConnectionIntentReceiver extends android.content.BroadcastReceiver {
        
        public NetworkConnectionIntentReceiver() {
            super();
        }
        
        @java.lang.Override()
        @android.annotation.SuppressLint(value = {"Wakelock"})
        public void onReceive(@org.jetbrains.annotations.NotNull()
        android.content.Context context, @org.jetbrains.annotations.NotNull()
        android.content.Intent intent) {
        }
    }
}