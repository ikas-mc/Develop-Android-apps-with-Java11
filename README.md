# Develop Android apps with Java 11
AGP 7.0.0  
Use Java 11 source code in your project  
https://developer.android.com/studio/releases/gradle-plugin#jdk-11
https://developer.android.com/studio/releases/gradle-plugin#java-11


========= Deprecated =========
### code sample

```java
var page = MainFragment.newInstance();
var fragmentManager = getSupportFragmentManager();

var data = new Bundle();
data.putString("key", "hello java 11");
page.setArguments(data);

```

### project config

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

```groovy
apply plugin: 'idea'
idea {
    module {
        //3. fix viewBinding for idea
        sourceDirs += file("${module.project.buildDir}/generated/data_binding_base_class_source_out/debug/out")
    }
}
```

### more
supported java language features
```
//TODO ...
```
more:
https://jakewharton.com/androids-java-9-10-11-and-12-support/
