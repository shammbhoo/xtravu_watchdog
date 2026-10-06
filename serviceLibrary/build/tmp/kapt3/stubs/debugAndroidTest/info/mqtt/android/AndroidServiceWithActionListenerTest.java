package info.mqtt.android;

@org.junit.runner.RunWith(value = androidx.test.ext.junit.runners.AndroidJUnit4.class)
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u000e\b\u0007\u0018\u0000 $2\u00020\u0001:\u0002#$B\u0005\u00a2\u0006\u0002\u0010\u0002J\b\u0010\u0016\u001a\u00020\u0017H\u0007J\b\u0010\u0018\u001a\u00020\u0017H\u0007J\b\u0010\u0019\u001a\u00020\u0017H\u0007J\b\u0010\u001a\u001a\u00020\u0017H\u0007J\b\u0010\u001b\u001a\u00020\u0017H\u0007J\b\u0010\u001c\u001a\u00020\u0017H\u0007J\b\u0010\u001d\u001a\u00020\u0017H\u0007J\b\u0010\u001e\u001a\u00020\u0017H\u0007J\b\u0010\u001f\u001a\u00020\u0017H\u0007J\b\u0010 \u001a\u00020\u0017H\u0007J\b\u0010!\u001a\u00020\u0017H\u0007J\b\u0010\"\u001a\u00020\u0017H\u0007R\u0018\u0010\u0003\u001a\n \u0005*\u0004\u0018\u00010\u00040\u0004X\u0082\u0004\u00a2\u0006\u0004\n\u0002\b\u0006R\u000e\u0010\u0007\u001a\u00020\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001c\u0010\t\u001a\u00020\n8GX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0013\u0010\u0010\u001a\u00020\u00118G\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u000e\u0010\u0014\u001a\u00020\u0015X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006%"}, d2 = {"Linfo/mqtt/android/AndroidServiceWithActionListenerTest;", "", "()V", "classCanonicalName", "", "kotlin.jvm.PlatformType", "classCanonicalName$1", "keyStorePwd", "mqttSSLServerURI", "nameRule", "Lorg/junit/rules/TestName;", "getNameRule", "()Lorg/junit/rules/TestName;", "setNameRule", "(Lorg/junit/rules/TestName;)V", "serverURI", "serviceRule", "Landroidx/test/rule/ServiceTestRule;", "getServiceRule", "()Landroidx/test/rule/ServiceTestRule;", "waitForCompletionTime", "", "setUp", "", "testConnect", "testHAConnect", "testLargeMessage", "testMultipleClients", "testNonDurableSubs", "testPubSub", "testQoSPreserved", "testRemoteConnect", "testRetainedMessage", "testSSLConnect", "testSSLPubSub", "ActionListener", "Companion", "serviceLibrary_debugAndroidTest"})
public final class AndroidServiceWithActionListenerTest {
    @org.jetbrains.annotations.NotNull()
    private org.junit.rules.TestName nameRule;
    private final java.lang.String classCanonicalName$1 = null;
    @org.jetbrains.annotations.Nullable()
    private java.lang.String serverURI;
    @org.jetbrains.annotations.Nullable()
    private java.lang.String mqttSSLServerURI;
    private long waitForCompletionTime = 0L;
    @org.jetbrains.annotations.NotNull()
    private java.lang.String keyStorePwd = "";
    @org.jetbrains.annotations.NotNull()
    private final androidx.test.rule.ServiceTestRule serviceRule = null;
    private static final java.lang.String classCanonicalName = null;
    private static final java.lang.String TAG = null;
    @org.jetbrains.annotations.NotNull()
    public static final info.mqtt.android.AndroidServiceWithActionListenerTest.Companion Companion = null;
    
    public AndroidServiceWithActionListenerTest() {
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
    
    @org.junit.Rule()
    @org.jetbrains.annotations.NotNull()
    public final androidx.test.rule.ServiceTestRule getServiceRule() {
        return null;
    }
    
    @org.junit.Before()
    @kotlin.jvm.Throws(exceptionClasses = {java.util.concurrent.TimeoutException.class})
    public final void setUp() throws java.util.concurrent.TimeoutException {
    }
    
    @org.junit.Test()
    public final void testConnect() {
    }
    
    @org.junit.Test()
    public final void testRemoteConnect() {
    }
    
    @org.junit.Test()
    public final void testLargeMessage() {
    }
    
    @org.junit.Test()
    public final void testMultipleClients() {
    }
    
    @org.junit.Test()
    @org.junit.Ignore(value = "Received invalid payload")
    public final void testNonDurableSubs() {
    }
    
    @org.junit.Test()
    @kotlin.Suppress(names = {})
    public final void testQoSPreserved() {
    }
    
    @org.junit.Test()
    public final void testHAConnect() {
    }
    
    @org.junit.Test()
    public final void testPubSub() {
    }
    
    @org.junit.Test()
    public final void testRetainedMessage() {
    }
    
    /**
     * Tests that a client can be constructed and that it can connect to and disconnect from the service via SSL
     */
    @org.junit.Ignore(value = "Trust anchor for certification path not found")
    @org.junit.Test()
    public final void testSSLConnect() {
    }
    
    /**
     * An SSL connection with server cert authentication, simple pub/sub of an message
     */
    @org.junit.Ignore(value = "Trust anchor for certification path not found")
    @org.junit.Test()
    public final void testSSLPubSub() {
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0002\b\u0082\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u00a2\u0006\u0002\u0010\u0004J\u001c\u0010\u0007\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0016J\u0010\u0010\r\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006\u00a8\u0006\u000e"}, d2 = {"Linfo/mqtt/android/AndroidServiceWithActionListenerTest$ActionListener;", "Lorg/eclipse/paho/client/mqttv3/IMqttActionListener;", "mqttClient", "Linfo/mqtt/android/service/MqttAndroidClient;", "(Linfo/mqtt/android/AndroidServiceWithActionListenerTest;Linfo/mqtt/android/service/MqttAndroidClient;)V", "getMqttClient", "()Linfo/mqtt/android/service/MqttAndroidClient;", "onFailure", "", "token", "Lorg/eclipse/paho/client/mqttv3/IMqttToken;", "exception", "", "onSuccess", "serviceLibrary_debugAndroidTest"})
    final class ActionListener implements org.eclipse.paho.client.mqttv3.IMqttActionListener {
        @org.jetbrains.annotations.Nullable()
        private final info.mqtt.android.service.MqttAndroidClient mqttClient = null;
        
        public ActionListener(@org.jetbrains.annotations.Nullable()
        info.mqtt.android.service.MqttAndroidClient mqttClient) {
            super();
        }
        
        @org.jetbrains.annotations.Nullable()
        public final info.mqtt.android.service.MqttAndroidClient getMqttClient() {
            return null;
        }
        
        @java.lang.Override()
        public void onFailure(@org.jetbrains.annotations.Nullable()
        org.eclipse.paho.client.mqttv3.IMqttToken token, @org.jetbrains.annotations.Nullable()
        java.lang.Throwable exception) {
        }
        
        @java.lang.Override()
        public void onSuccess(@org.jetbrains.annotations.NotNull()
        org.eclipse.paho.client.mqttv3.IMqttToken token) {
        }
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u0016\u0010\u0003\u001a\n \u0005*\u0004\u0018\u00010\u00040\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0016\u0010\u0006\u001a\n \u0005*\u0004\u0018\u00010\u00040\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0007"}, d2 = {"Linfo/mqtt/android/AndroidServiceWithActionListenerTest$Companion;", "", "()V", "TAG", "", "kotlin.jvm.PlatformType", "classCanonicalName", "serviceLibrary_debugAndroidTest"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
    }
}