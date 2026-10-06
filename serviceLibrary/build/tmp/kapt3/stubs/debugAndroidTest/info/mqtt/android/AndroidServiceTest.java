package info.mqtt.android;

@org.junit.runner.RunWith(value = androidx.test.ext.junit.runners.AndroidJUnit4.class)
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0013\b\u0007\u0018\u0000 %2\u00020\u0001:\u0002%&B\u0005\u00a2\u0006\u0002\u0010\u0002J\u001c\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014H\u0016J\u0010\u0010\u0015\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012H\u0016J\b\u0010\u0016\u001a\u00020\u0010H\u0007J\b\u0010\u0017\u001a\u00020\u0010H\u0007J\b\u0010\u0018\u001a\u00020\u0010H\u0007J\b\u0010\u0019\u001a\u00020\u0010H\u0007J\b\u0010\u001a\u001a\u00020\u0010H\u0007J\u0006\u0010\u001b\u001a\u00020\u0010J\b\u0010\u001c\u001a\u00020\u0010H\u0007J\b\u0010\u001d\u001a\u00020\u0010H\u0007J\b\u0010\u001e\u001a\u00020\u0010H\u0007J\b\u0010\u001f\u001a\u00020\u0010H\u0007J\b\u0010 \u001a\u00020\u0010H\u0007J\b\u0010!\u001a\u00020\u0010H\u0007J\b\u0010\"\u001a\u00020\u0010H\u0007J\b\u0010#\u001a\u00020\u0010H\u0007J\b\u0010$\u001a\u00020\u0010H\u0007R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082.\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001c\u0010\u0007\u001a\u00020\b8GX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u000e\u0010\r\u001a\u00020\u000eX\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\'"}, d2 = {"Linfo/mqtt/android/AndroidServiceTest;", "Lorg/eclipse/paho/client/mqttv3/IMqttActionListener;", "()V", "keyStorePwd", "", "mqttSSLServerURI", "mqttServerURI", "nameRule", "Lorg/junit/rules/TestName;", "getNameRule", "()Lorg/junit/rules/TestName;", "setNameRule", "(Lorg/junit/rules/TestName;)V", "waitForCompletionTime", "", "onFailure", "", "asyncActionToken", "Lorg/eclipse/paho/client/mqttv3/IMqttToken;", "exception", "", "onSuccess", "setUp", "testCleanSession", "testCleanStart", "testConnect", "testHAConnect", "testIsConnected", "testLargeMessage", "testMultipleClients", "testNonDurableSubs", "testPubSub", "testQoSPreserved", "testRemoteConnect", "testRetainedMessage", "testSSLConnect", "testSSLPubSub", "Companion", "MqttConnectCallback", "serviceLibrary_debugAndroidTest"})
public final class AndroidServiceTest implements org.eclipse.paho.client.mqttv3.IMqttActionListener {
    @org.jetbrains.annotations.NotNull()
    private org.junit.rules.TestName nameRule;
    @org.jetbrains.annotations.Nullable()
    private java.lang.String mqttServerURI;
    @org.jetbrains.annotations.Nullable()
    private java.lang.String mqttSSLServerURI;
    private long waitForCompletionTime = 700L;
    private java.lang.String keyStorePwd;
    private static final java.lang.String classSimpleName = null;
    @org.jetbrains.annotations.NotNull()
    public static final info.mqtt.android.AndroidServiceTest.Companion Companion = null;
    
    public AndroidServiceTest() {
        super();
    }
    
    @org.junit.Rule()
    @org.jetbrains.annotations.NotNull()
    public final org.junit.rules.TestName getNameRule() {
        return null;
    }
    
    public final void setNameRule(@org.jetbrains.annotations.NotNull()
    org.junit.rules.TestName p0) {
    }
    
    @org.junit.Before()
    public final void setUp() {
    }
    
    /**
     * Tests that a client can be constructed and that it can connect to and disconnect from the service
     */
    @org.junit.Test()
    public final void testConnect() {
    }
    
    /**
     * Tests that a client connection with cleanSession=False receives the session Present Flag in
     * a subsequent connection.
     *
     * 1. Connect with CleanSession=True to ensure that state is cleared.
     * 2. Connect with CleanSession=False and ensure that sessionPresent is false.
     * 3. Connect with CleanSession=False and ensure that sessionPresent is true.
     */
    @org.junit.Test()
    public final void testCleanSession() {
    }
    
    /**
     * Tests isConnected() returns false after a disconnect() call.
     */
    @kotlin.jvm.Throws(exceptionClasses = {java.lang.Exception.class})
    public final void testIsConnected() throws java.lang.Exception {
    }
    
    /**
     * Test connection using a remote host name for the local host.
     */
    @org.junit.Test()
    public final void testRemoteConnect() {
    }
    
    /**
     * Test client pubSub using very large messages
     */
    @org.junit.Test()
    public final void testLargeMessage() {
    }
    
    /**
     * Multiple publishers and subscribers.
     */
    @org.junit.Test()
    @kotlin.Suppress(names = {})
    public final void testMultipleClients() {
    }
    
    /**
     * Test that QOS values are preserved between MQTT publishers and subscribers.
     */
    @org.junit.Test()
    @org.junit.Ignore(value = "testQoSPreserved exception=Timed out waiting for a response from the server")
    public final void testQoSPreserved() {
    }
    
    @org.junit.Test()
    @org.junit.Ignore(value = "Trust anchor for certification path not found")
    public final void testNonDurableSubs() {
    }
    
    /**
     * Test the behaviour of the cleanStart flag, used to clean up before
     * re-connecting.
     */
    @org.junit.Test()
    public final void testCleanStart() {
    }
    
    @org.junit.Test()
    public final void testPubSub() {
    }
    
    @org.junit.Test()
    public final void testHAConnect() {
    }
    
    @org.junit.Test()
    public final void testRetainedMessage() {
    }
    
    /**
     * Tests that a client can be constructed and that it can connect to and
     * disconnect from the service via SSL
     */
    @org.junit.Ignore(value = "java.security.cert.CertPathValidatorException: Trust anchor for certification path not found")
    @org.junit.Test()
    public final void testSSLConnect() {
    }
    
    /**
     * An SSL connection with server cert authentication, simple pub/sub of an message
     */
    @org.junit.Test()
    @org.junit.Ignore(value = "Trust anchor for certification path not found")
    public final void testSSLPubSub() {
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
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u0016\u0010\u0003\u001a\n \u0005*\u0004\u0018\u00010\u00040\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0006"}, d2 = {"Linfo/mqtt/android/AndroidServiceTest$Companion;", "", "()V", "classSimpleName", "", "kotlin.jvm.PlatformType", "serviceLibrary_debugAndroidTest"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0002\b\u0082\u0004\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u001c\u0010\b\u001a\u00020\t2\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0016J\u0010\u0010\f\u001a\u00020\t2\u0006\u0010\u0005\u001a\u00020\u0004H\u0016R\"\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004@BX\u0086\u000e\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007\u00a8\u0006\r"}, d2 = {"Linfo/mqtt/android/AndroidServiceTest$MqttConnectCallback;", "Lorg/eclipse/paho/client/mqttv3/IMqttActionListener;", "(Linfo/mqtt/android/AndroidServiceTest;)V", "<set-?>", "Lorg/eclipse/paho/client/mqttv3/IMqttToken;", "asyncActionToken", "getAsyncActionToken", "()Lorg/eclipse/paho/client/mqttv3/IMqttToken;", "onFailure", "", "exception", "", "onSuccess", "serviceLibrary_debugAndroidTest"})
    final class MqttConnectCallback implements org.eclipse.paho.client.mqttv3.IMqttActionListener {
        @org.jetbrains.annotations.Nullable()
        private org.eclipse.paho.client.mqttv3.IMqttToken asyncActionToken;
        
        public MqttConnectCallback() {
            super();
        }
        
        @org.jetbrains.annotations.Nullable()
        public final org.eclipse.paho.client.mqttv3.IMqttToken getAsyncActionToken() {
            return null;
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