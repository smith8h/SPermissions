# SPermissions

<p align="center">
    <!-- Latest release -->
    <img src="https://img.shields.io/github/v/release/smith8h/SPermissions?include_prereleases&amp;label=latest%20release" alt="Latest release"/>
    <!-- Build and test -->
    <img src="https://github.com/smith8h/SPermissions/actions/workflows/build.yml/badge.svg" alt="Builds and tests"/>
    <!-- JitPack release -->
    <a href="https://jitpack.io/#smith8h/SPermissions">
        <img src="https://jitpack.io/v/smith8h/SPermissions.svg" />
    </a>
    <!-- Stability -->
    <img src="https://img.shields.io/badge/stability-stable-green.svg" alt="stability" />
    <!-- minSDK -->
    <img src="https://img.shields.io/badge/minSDK-21-f39f37" alt="minsdk" />
    <!-- stable version -->
    <img src="https://img.shields.io/badge/stable_version-2.0-blue" alt="stable"/>
    <!-- repo size -->
    <img src="https://img.shields.io/github/repo-size/smith8h/spermissions" alt="size"/>
</p>

</br>

Beautiful custom android dialogs ( alert, multiselect checkbox, singleselect radiobutton, string list items, loading, progress, input and custom sdialog ).

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
    implementation 'com.github.smith8h:SPermissions:1.0'
}
```

# Documentation
• Create a `SPermissions` object:
```java
    SPermissions sp = SPermissions.with(context);
```
• check if app has permission/s and request if not
```java
    // when one permission 
    if (sp.hasPermission(SPermissions.ACCESS_FINE_LOCATION)) {
        // do work when granted
    } else {
        // request (default request code is 700)
        sp.requestPermision(SPermissions.ACCESS_FINE_LOCATION);
        
        // if want to use custom request code
        int reqCode = 44;
        sp.requestPermision(SPermissions.ACCESS_FINE_LOCATION, reqCode);
    }
    
    
    
    // when more than one at once
    String[] perms = {
        SPermissions.ACCESS_FINE_LOCATION,
        SPermissions.READ_CONTACTS,
        Manifest.permission.WRITE_EXTERNAL_STORAGE
    }
    if (sp.hasPermissions(perms)) {
        // do work when granted
    } else {
        // request (default request code is 700)
        sp.requestPermisions(perms);
        
        // if want to use custom request code
        int reqCode = 44;
        sp.requestPermisions(reqCode, perms);
        // or
        sp.requestPermisions(reqCode,
            SPermissions.ACCESS_FINE_LOCATION,
            SPermissions.READ_CONTACTS,
            Manifest.permission.WRITE_EXTERNAL_STORAGE
        );
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

[![PayPal](https://img.shields.io/badge/PayPal-00457C?style=for-the-badge&logo=paypal&logoColor=white)](https://www.paypal.me/husseinshakir)

<br/>

<p align="center">
  <img src="https://raw.githubusercontent.com/smith8h/smith8h/main/20221103_150053.png" style="width: 38%;"/>
  <br><b>With :heart:</b>
</p>
