package info.mqtt.android;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0000\u0018\u0000 \u001a2\u00020\u0001:\u0001\u001aB\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u0010\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0006H\u0002J\u0010\u0010\u0016\u001a\u00020\u00062\u0006\u0010\u0015\u001a\u00020\u0006H\u0002J\u0012\u0010\u0017\u001a\u0004\u0018\u00010\u00182\u0006\u0010\u0019\u001a\u00020\u0006H\u0002R\u0011\u0010\u0005\u001a\u00020\u00068F\u00a2\u0006\u0006\u001a\u0004\b\u0007\u0010\bR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0011\u0010\u000b\u001a\u00020\u00068F\u00a2\u0006\u0006\u001a\u0004\b\f\u0010\bR\u0011\u0010\r\u001a\u00020\u00068F\u00a2\u0006\u0006\u001a\u0004\b\u000e\u0010\bR\u0011\u0010\u000f\u001a\u00020\u00108F\u00a2\u0006\u0006\u001a\u0004\b\u0011\u0010\u0012\u00a8\u0006\u001b"}, d2 = {"Linfo/mqtt/android/TestProperties;", "", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "clientKeyStorePassword", "", "getClientKeyStorePassword", "()Ljava/lang/String;", "properties", "Ljava/util/Properties;", "serverSSLURI", "getServerSSLURI", "serverURI", "getServerURI", "waitForCompletionTime", "", "getWaitForCompletionTime", "()J", "getIntProperty", "", "key", "getProperty", "getPropertyFileAsStream", "Ljava/io/InputStream;", "fileName", "Companion", "serviceLibrary_debugAndroidTest"})
public final class TestProperties {
    @org.jetbrains.annotations.NotNull()
    private final android.content.Context context = null;
    @org.jetbrains.annotations.NotNull()
    private final java.util.Properties properties = null;
    @org.jetbrains.annotations.NotNull()
    private static final java.lang.String KEY_SERVER_URI = "SERVER_URI";
    @org.jetbrains.annotations.NotNull()
    private static final java.lang.String KEY_CLIENT_KEY_STORE_PASSWORD = "CLIENT_KEY_STORE_PASSWORD";
    @org.jetbrains.annotations.NotNull()
    private static final java.lang.String KEY_SERVER_SSL_URI = "SERVER_SSL_URI";
    @org.jetbrains.annotations.NotNull()
    private static final java.lang.String KEY_WAIT_FOR_COMPLETION_TIME = "WAIT_FOR_COMPLETION_TIME";
    @org.jetbrains.annotations.NotNull()
    public static final info.mqtt.android.TestProperties.Companion Companion = null;
    
    public TestProperties(@org.jetbrains.annotations.NotNull()
    android.content.Context context) {
        super();
    }
    
    @kotlin.jvm.Throws(exceptionClasses = {java.io.IOException.class})
    private final java.io.InputStream getPropertyFileAsStream(java.lang.String fileName) throws java.io.IOException {
        return null;
    }
    
    private final java.lang.String getProperty(java.lang.String key) {
        return null;
    }
    
    private final int getIntProperty(java.lang.String key) {
        return 0;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getClientKeyStorePassword() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getServerSSLURI() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getServerURI() {
        return null;
    }
    
    public final long getWaitForCompletionTime() {
        return 0L;
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082D\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082D\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0082D\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0082D\u00a2\u0006\u0002\n\u0000\u00a8\u0006\b"}, d2 = {"Linfo/mqtt/android/TestProperties$Companion;", "", "()V", "KEY_CLIENT_KEY_STORE_PASSWORD", "", "KEY_SERVER_SSL_URI", "KEY_SERVER_URI", "KEY_WAIT_FOR_COMPLETION_TIME", "serviceLibrary_debugAndroidTest"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
    }
}