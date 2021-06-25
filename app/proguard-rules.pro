# Add project specific ProGuard rules here.
# By default, the flags in this file are appended to flags specified
# in /home/mohit/Android/Sdk/tools/proguard/proguard-android.txt
# You can edit the include path and order by changing the proguardFiles
# directive in build.gradle.
#
# For more details, see
#   http://developer.android.com/guide/developing/tools/proguard.html

# Add any project specific keep options here:

# If your project uses WebView with JS, uncomment the following
# and specify the fully qualified class name to the JavaScript interface
# class:
#-keepclassmembers class fqcn.of.javascript.interface.for.webview {
#   public *;
#}
-keepattributes *Annotation*
-keepclassmembers class ** {
    @org.greenrobot.eventbus.Subscribe <methods>;
}
-keep enum org.greenrobot.eventbus.ThreadMode { *; }

##---------------Begin: proguard configuration for Gson  ----------
# Gson uses generic type information stored in a class file when working with fields. Proguard
# removes such information by default, so configure it to keep all of it.
-keepattributes Signature
#preserve JSON structures
-keep class com.boltCore.android.jsonStructures.** {*; }
-keep class com.revos.bolt.android.jsonStructures.** {*; }
# Prevent proguard from stripping interface information from TypeAdapterFactory,
# JsonSerializer, JsonDeserializer instances (so they can be used in @JsonAdapter)
-keep class * implements com.google.gson.TypeAdapterFactory
-keep class * implements com.google.gson.JsonSerializer
-keep class * implements com.google.gson.JsonDeserializer

##---------------End: proguard configuration for Gson  ----------

-dontwarn okio.**
-dontwarn javax.annotation.**
-dontwarn retrofit2.Platform$Java8
-dontwarn com.squareup.okhttp.**

##--------------configuration to remove logging -----------------
-assumenosideeffects class android.util.Log {
    public static boolean isLoggable(java.lang.String, int);
    public static int v(...);
    public static int i(...);
    public static int w(...);
    public static int d(...);
    public static int e(...);
}

##--joda time proguard rules-----------------------------------
-dontwarn org.joda.convert.**
-dontwarn org.joda.time.**
-keep class org.joda.time.** { *; }
-keep interface org.joda.time.** { *; }

##-------------ignoring warnings for google places library-------
-ignorewarnings

##------------------------proguard for apollo generated files-------
-keep class com.revos.bolt.scripts.** {*;}

##------------------------proguard rules for dfu--------------------
-keep class no.nordicsemi.android.dfu.** { *; }

##------------------------proguard for TBIT-------------------------
-keep class com.tbit.** {*;}

##------------------------proguard for pretty time------------------
-keep class org.ocpsoft.prettytime.i18n.**
