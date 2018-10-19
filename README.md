[![](https://jitpack.io/v/kassatka-onlnie/android-api.svg)](https://jitpack.io/#kassatka-online/android-api)


## ���������� ���������� � ������� 


� build.gradle ������� �������� ������ �� ����������� jitpack:


```
allprojects {
    repositories {
        maven { url "https://jitpack.io" }
    }
}
```

� ������ `build.gradle` �������� ����������� � ������� ������ ������:


```
implementation 'com.github.kassatka-online:android-api:' + apiLatestVersion
```

���, apiLatestVersion ���������� � ������ ext ���� �� build.gradle �����. ����� ���������� ������� minSdkVersion �������:


```
defaultConfig {
	minSdkVersion 22
	
	...

}
```

� ���� ������� ����������� ��� ��������� ����������, ��������� � ��., ����������� ��� ������ � ������������� �� �����-��������� ��������.