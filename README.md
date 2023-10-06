# SPermissions

<p align="center">
    <!-- Build and test -->
    <img src="https://github.com/smith8h/SPermissions/actions/workflows/build.yml/badge.svg" alt="Builds and tests"/>
    <!-- Latest release -->
    <img src="https://img.shields.io/github/v/release/smith8h/SPermissions?include_prereleases&amp;label=latest%20release" alt="Latest release"/>
    <!-- JitPack release -->
    <a href="https://jitpack.io/#smith8h/SPermissions">
        <img src="https://jitpack.io/v/smith8h/SPermissions.svg" />
    </a>
    <!-- Stability -->
    <img src="https://img.shields.io/badge/stability-stable-green.svg" alt="stability" />
    <!-- minSDK -->
    <img src="https://img.shields.io/badge/minSDK-21-f39f37" alt="minsdk" />
    <!-- stable version -->
    <img src="https://img.shields.io/badge/stable_version-1.1-blue" alt="stable"/>
    <!-- repo size -->
    <img src="https://img.shields.io/github/repo-size/smith8h/spermissions" alt="size"/>
</p>
<br/>

Simple & fast codes to request a grant permission for Android library.

# Setup
> **Step 1.** Add the JitPack repository to your build file.</br>
Add it in your root build.gradle at the end of repositories:
```gradle
allprojects {
    repositories {
	...
	maven { url 'https://jitpack.io' }
    }
}
```
> **Step 2.** Add the dependency:
```gradle
dependencies {
    implementation 'com.github.smith8h:SPermissions:1.1'
}
```

# Documentation
• Create a `SPermissions` object:
```java
    SPermissions sp = SPermissions.with(activty);
```
• check if app has permission/s and request if not
```java
    // when one permission 
    if (sp.hasPermission(Manifest.permission.ACCESS_FINE_LOCATION)) {
        // do work when granted
    } else {
        // request (default request code is 700)
        sp.requestPermision(Manifest.permission.ACCESS_FINE_LOCATION);
        
        // if want to use custom request code
        int reqCode = 44;
        sp.requestPermision(Manifest.permission.ACCESS_FINE_LOCATION, reqCode);
    }
    
    
    
    // when more than one at once
    String[] perms = {
        Manifest.permission.ACCESS_FINE_LOCATION,
        Manifest.permission.READ_CONTACTS,
        Manifest.permission.WRITE_EXTERNAL_STORAGE
    }
    if (sp.hasPermissions(perms)) {
        // do work when granted
    } else {
        // request (default request code is 700)
        sp.requestPermisions(perms);
        
        // if want to use custom request code
        int reqCode = 44;
        sp.requestPermisions(perms, reqCode);
        // or
        sp.requestPermisions(new String[] {
            Manifest.permission.ACCESS_FINE_LOCATION,
            Manifest.permission.READ_CONTACTS,
            Manifest.permission.WRITE_EXTERNAL_STORAGE
        }, reqCode);
    }
```
• get grant result override `onRequestPermissionsResult`
```java
    @Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] resultCodes) {
        super.onRequestPermissionsResult(requestCode, permissions, resultCodes);
        
        if (requestCode == SPermissions.REQUEST_CODE) { // 700
            if (sp.hasPermission(SPermissions.READ_CONTACTS)) {
                // do work
            } else {
                // do other work
            }
        }
    }

```
# Donations
> If you would like to support this project's further development, the creator of this projects or the continuous maintenance of the project **feel free to donate**.
Your donation is highly appreciated. Thank you!
<br/>

You can **choose what you want to donate**, all donations are awesome!</br>
<br/>

[<img src="https://raw.githubusercontent.com/smith8h/smith8h/7e74b5cf5502aef174981d7f6d02a448ff2b0965/PayPal.svg"
alt='Donate with PayPal'
height="80"/>](https://www.paypal.me/husseinshakir)
[<img src="https://raw.githubusercontent.com/smith8h/smith8h/7e74b5cf5502aef174981d7f6d02a448ff2b0965/BMC.svg"
alt='Donate with PayPal'
height="80"/>](https://www.buymeacoffee.com/HusseinShakir)
<br/>

<p align="center">
  <img src="https://raw.githubusercontent.com/smith8h/smith8h/main/20221103_150053.png" style="width: 38%;"/>
  <br><b>With :heart:</b>
</p>
