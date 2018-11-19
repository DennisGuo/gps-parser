# GPS-PARSER

This repo is forked from [https://github.com/eantoranz/gps-parser](https://github.com/eantoranz/gps-parser).

## what changed ?

- build with gradle.
- add static function to get gprmc format data.
- add speed and direction property.

## usage 

gradle.build

```gradle
repositories {
    maven { url "https://jitpack.io" }
}
dependencies{
    compile 'com.github.dennisguo:gps-parser:master-SNAPSHOT'
}
```

java
```java
String msg = "$GPRMC,053728.000,A,3959.5238,N,11622.3053,E,0.0,0.0,191118,5.9,W,A*18";
GPRMC gprmc = GPRMCReader.read(msg);
// gprmc: lat,lng,speed,direction,time
```