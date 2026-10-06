package info.mqtt.android;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000l\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0003\u0018\u00002\u00020\u0001:\u0002&\'B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u0012\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012H\u0016J\u0010\u0010\u0013\u001a\u00020\u00102\u0006\u0010\u0014\u001a\u00020\u0015H\u0016J\u0018\u0010\u0016\u001a\u00020\u00102\u0006\u0010\u0017\u001a\u00020\u00062\u0006\u0010\u0018\u001a\u00020\u0019H\u0016J\u0010\u0010\u001a\u001a\u0004\u0018\u00010\f2\u0006\u0010\u001b\u001a\u00020\u001cJ\u0012\u0010\u001d\u001a\u00020\u00102\b\u0010\u001e\u001a\u0004\u0018\u00010\u0006H\u0002J \u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\u00062\u0006\u0010\"\u001a\u00020#2\b\u0010$\u001a\u0004\u0018\u00010%R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\bX\u0082\u000e\u00a2\u0006\u0002\n\u0000R2\u0010\n\u001a&\u0012\f\u0012\n \r*\u0004\u0018\u00010\f0\f \r*\u0012\u0012\f\u0012\n \r*\u0004\u0018\u00010\f0\f\u0018\u00010\u000e0\u000bX\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006("}, d2 = {"Linfo/mqtt/android/MqttReceiver;", "Lorg/eclipse/paho/client/mqttv3/MqttCallback;", "mqttClient", "Lorg/eclipse/paho/client/mqttv3/IMqttAsyncClient;", "(Lorg/eclipse/paho/client/mqttv3/IMqttAsyncClient;)V", "clientId", "", "connected", "", "isReportConnectionLoss", "receivedMessages", "", "Linfo/mqtt/android/MqttReceiver$ReceivedMessage;", "kotlin.jvm.PlatformType", "", "connectionLost", "", "cause", "", "deliveryComplete", "arg0", "Lorg/eclipse/paho/client/mqttv3/IMqttDeliveryToken;", "messageArrived", "topic", "message", "Lorg/eclipse/paho/client/mqttv3/MqttMessage;", "receiveNext", "waitMilliseconds", "", "report", "text", "validateReceipt", "Linfo/mqtt/android/MqttReceiver$ValidateResult;", "sendTopic", "expectedQos", "", "sentBytes", "", "ReceivedMessage", "ValidateResult", "serviceLibrary_debugAndroidTest"})
public final class MqttReceiver implements org.eclipse.paho.client.mqttv3.MqttCallback {
    private boolean isReportConnectionLoss = true;
    private boolean connected = false;
    @org.jetbrains.annotations.NotNull()
    private java.lang.String clientId;
    private final java.util.List<info.mqtt.android.MqttReceiver.ReceivedMessage> receivedMessages = null;
    
    public MqttReceiver(@org.jetbrains.annotations.NotNull()
    org.eclipse.paho.client.mqttv3.IMqttAsyncClient mqttClient) {
        super();
    }
    
    @kotlin.jvm.Throws(exceptionClasses = {java.lang.InterruptedException.class})
    @org.jetbrains.annotations.Nullable()
    public final info.mqtt.android.MqttReceiver.ReceivedMessage receiveNext(long waitMilliseconds) throws java.lang.InterruptedException {
        return null;
    }
    
    @kotlin.jvm.Throws(exceptionClasses = {java.lang.InterruptedException.class})
    @org.jetbrains.annotations.NotNull()
    public final info.mqtt.android.MqttReceiver.ValidateResult validateReceipt(@org.jetbrains.annotations.NotNull()
    java.lang.String sendTopic, int expectedQos, @org.jetbrains.annotations.Nullable()
    byte[] sentBytes) throws java.lang.InterruptedException {
        return null;
    }
    
    @java.lang.Override()
    public void connectionLost(@org.jetbrains.annotations.Nullable()
    java.lang.Throwable cause) {
    }
    
    @java.lang.Override()
    public void deliveryComplete(@org.jetbrains.annotations.NotNull()
    org.eclipse.paho.client.mqttv3.IMqttDeliveryToken arg0) {
    }
    
    @java.lang.Override()
    public void messageArrived(@org.jetbrains.annotations.NotNull()
    java.lang.String topic, @org.jetbrains.annotations.NotNull()
    org.eclipse.paho.client.mqttv3.MqttMessage message) {
    }
    
    private final void report(java.lang.String text) {
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006J\t\u0010\u000f\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u0010\u001a\u00020\u0005H\u00c6\u0003J\u001d\u0010\u0011\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005H\u00c6\u0001J\u0013\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010\u0015\u001a\u00020\u0016H\u00d6\u0001J\t\u0010\u0017\u001a\u00020\u0003H\u00d6\u0001R\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000e\u00a8\u0006\u0018"}, d2 = {"Linfo/mqtt/android/MqttReceiver$ReceivedMessage;", "", "topic", "", "message", "Lorg/eclipse/paho/client/mqttv3/MqttMessage;", "(Ljava/lang/String;Lorg/eclipse/paho/client/mqttv3/MqttMessage;)V", "getMessage", "()Lorg/eclipse/paho/client/mqttv3/MqttMessage;", "setMessage", "(Lorg/eclipse/paho/client/mqttv3/MqttMessage;)V", "getTopic", "()Ljava/lang/String;", "setTopic", "(Ljava/lang/String;)V", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "serviceLibrary_debugAndroidTest"})
    public static final class ReceivedMessage {
        @org.jetbrains.annotations.NotNull()
        private java.lang.String topic;
        @org.jetbrains.annotations.NotNull()
        private org.eclipse.paho.client.mqttv3.MqttMessage message;
        
        public ReceivedMessage(@org.jetbrains.annotations.NotNull()
        java.lang.String topic, @org.jetbrains.annotations.NotNull()
        org.eclipse.paho.client.mqttv3.MqttMessage message) {
            super();
        }
        
        @org.jetbrains.annotations.NotNull()
        public final java.lang.String getTopic() {
            return null;
        }
        
        public final void setTopic(@org.jetbrains.annotations.NotNull()
        java.lang.String p0) {
        }
        
        @org.jetbrains.annotations.NotNull()
        public final org.eclipse.paho.client.mqttv3.MqttMessage getMessage() {
            return null;
        }
        
        public final void setMessage(@org.jetbrains.annotations.NotNull()
        org.eclipse.paho.client.mqttv3.MqttMessage p0) {
        }
        
        @org.jetbrains.annotations.NotNull()
        public final java.lang.String component1() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final org.eclipse.paho.client.mqttv3.MqttMessage component2() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final info.mqtt.android.MqttReceiver.ReceivedMessage copy(@org.jetbrains.annotations.NotNull()
        java.lang.String topic, @org.jetbrains.annotations.NotNull()
        org.eclipse.paho.client.mqttv3.MqttMessage message) {
            return null;
        }
        
        @java.lang.Override()
        public boolean equals(@org.jetbrains.annotations.Nullable()
        java.lang.Object other) {
            return false;
        }
        
        @java.lang.Override()
        public int hashCode() {
            return 0;
        }
        
        @java.lang.Override()
        @org.jetbrains.annotations.NotNull()
        public java.lang.String toString() {
            return null;
        }
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\r\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006J\t\u0010\r\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u000e\u001a\u00020\u0005H\u00c6\u0003J\u001d\u0010\u000f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005H\u00c6\u0001J\u0013\u0010\u0010\u001a\u00020\u00032\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010\u0012\u001a\u00020\u0013H\u00d6\u0001J\t\u0010\u0014\u001a\u00020\u0005H\u00d6\u0001R\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f\u00a8\u0006\u0015"}, d2 = {"Linfo/mqtt/android/MqttReceiver$ValidateResult;", "", "ok", "", "message", "", "(ZLjava/lang/String;)V", "getMessage", "()Ljava/lang/String;", "setMessage", "(Ljava/lang/String;)V", "getOk", "()Z", "component1", "component2", "copy", "equals", "other", "hashCode", "", "toString", "serviceLibrary_debugAndroidTest"})
    public static final class ValidateResult {
        private final boolean ok = false;
        @org.jetbrains.annotations.NotNull()
        private java.lang.String message;
        
        public ValidateResult(boolean ok, @org.jetbrains.annotations.NotNull()
        java.lang.String message) {
            super();
        }
        
        public final boolean getOk() {
            return false;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final java.lang.String getMessage() {
            return null;
        }
        
        public final void setMessage(@org.jetbrains.annotations.NotNull()
        java.lang.String p0) {
        }
        
        public final boolean component1() {
            return false;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final java.lang.String component2() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final info.mqtt.android.MqttReceiver.ValidateResult copy(boolean ok, @org.jetbrains.annotations.NotNull()
        java.lang.String message) {
            return null;
        }
        
        @java.lang.Override()
        public boolean equals(@org.jetbrains.annotations.Nullable()
        java.lang.Object other) {
            return false;
        }
        
        @java.lang.Override()
        public int hashCode() {
            return 0;
        }
        
        @java.lang.Override()
        @org.jetbrains.annotations.NotNull()
        public java.lang.String toString() {
            return null;
        }
    }
}