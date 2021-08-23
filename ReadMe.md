# Jetpack 네비게이션 데모앱

## 네비게이션 그래프 리소스 파일 추가

```xml
<?xml version="1.0" encoding="utf-8"?>
<navigation xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    android:id="@+id/navigation_graph">

</navigation>
```

## 네비게이션 호스트 선언 

- 메인 엑티비티 내부에 

```xml
    <androidx.fragment.app.FragmentContainerView
        android:id="@+id/fragmentContainerView"
        android:name="androidx.navigation.fragment.NavHostFragment"
        android:layout_width="match_parent"
        android:layout_height="match_parent"
        app:defaultNavHost="true"
        app:navGraph="@navigation/navigation_graph" />
```

- 를 추가 했다.
- 이후 메인 액티비티 코드 상에서 main_frame 로드 부분을 삭제함 (네비게이션을 통해 이동시킬 것임.)