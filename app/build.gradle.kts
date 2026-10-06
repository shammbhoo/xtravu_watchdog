plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.jetbrains.kotlin.android)
    alias(libs.plugins.kotlin.kapt)

    id("kotlin-parcelize")

    // Make sure that you have the Google services Gradle plugin
    alias(libs.plugins.google.gms.services)
    // Add the Crashlytics Gradle plugin
    alias(libs.plugins.firebase.crashlytics)
}

android {
    namespace = "com.mob.xtravuwatchdog"
    compileSdk = 35

    defaultConfig {
        applicationId = "com.mob.xtravuwatchdog"
        minSdk = 26
        targetSdk = 35
        versionCode = 3
        versionName = "1.0.2"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"

    }


    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
            signingConfig = signingConfigs.getByName("debug")
        }
    }


    // Flavor dimension setup if needed
    flavorDimensions("default")
    productFlavors {
        create("xtravu") {
            dimension = "default"
            // Configure specific settings for TV devices
        }
    }



    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8 // Or JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_1_8 // Or JavaVersion.VERSION_11
    }

    kotlinOptions {
        jvmTarget = "1.8" // Align with Java compatibility
    }
    sourceSets {
        getByName("main") {
            res {
                srcDirs("src/main/res", "src/main/res/layout", "src/main/res/font",
                    "src/main/res/anim"
                )
            }
            assets {
                srcDirs("src/main/assets", "src/main/assets/html")
            }
        }
    }
    buildFeatures {
        dataBinding=true
        viewBinding=true
    }

}

dependencies {

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.material)
    //room library
    implementation(libs.room.runtime) // Room runtime dependency
    implementation(libs.room.ktx)
    implementation(libs.androidx.lifecycle.viewmodel.android)
    implementation(project(":serviceLibrary")) // Add Room KTX dependency for Coroutines support
    kapt(libs.room.compiler) // Room annotation processor
    implementation(libs.androidx.lifecycle.viewmodel.ktx)
    //glide
    implementation(libs.github.bumptech.glide)
    annotationProcessor(libs.github.bumptech.glide.annotation.processor)

    //exoplayer
    implementation(libs.android.exoplayer.core)
    implementation(libs.android.exoplayer.ui)
    implementation(libs.android.exoplayer)


    implementation(libs.android.exoplayer.smoothstreaming)

    //gson
    implementation(libs.google.gson)
    implementation (libs.android.intuit.sdp)



    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)


    // timber
    implementation(libs.timber)


    // nanohttpd for embededserver
    implementation (libs.org.nanohttpd)

    //retrofit
    implementation(libs.squareup.retrofit2)
    implementation(libs.squareup.retrofit2.converter.gson)
    implementation(libs.squareup.okhttp3)
    implementation(libs.squareup.okhttp3.logging.interceptor)
    implementation (libs.com.jakewharton.retrofit.retrofit2.kotlin.coroutines.adapter)

    // qr code generation
    implementation (libs.com.google.zxing.core)
    implementation (libs.com.journeyapps.zxing.android.embedded) // For displaying QR code in ImageView

    implementation (libs.androidx.work.runtime.ktx)

    // Import the BoM for the Firebase platform
    implementation(libs.firebase.bom)

    // Add the dependencies for the Crashlytics and Analytics libraries
    // When using the BoM, you don't specify versions in Firebase library dependencies
    implementation(platform("com.google.firebase:firebase-bom:32.2.3"))
    implementation("com.google.firebase:firebase-analytics")
    implementation("com.google.firebase:firebase-crashlytics")

    implementation("androidx.work:work-runtime-ktx:2.8.1")
    implementation ("org.apache.poi:poi-ooxml:5.2.3")

}