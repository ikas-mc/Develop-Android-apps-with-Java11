# Develop Android apps with Java 11

java

```java
     var page = MainFragment.newInstance();
     var fragmentManager = getSupportFragmentManager();

     var data = new Bundle();
     data.putString("key", "hello java 11");
     page.setArguments(data);

```

build.gradle

```groovy
compileOptions {
        //1. java 11
    sourceCompatibility JavaVersion.VERSION_11
    targetCompatibility JavaVersion.VERSION_11
}
```

```groovy
dependencies {
    //2. fix sdk
    compileOnly files("${android.sdkDirectory.path}/platforms/${android.compileSdkVersion}/android.jar")
}
```