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

## 네비게이션 목적치 추가하기

```xml
<?xml version="1.0" encoding="utf-8"?>
<navigation xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    xmlns:tools="http://schemas.android.com/tools"
    android:id="@+id/navigation_graph"
    app:startDestination="@id/mainFragment">

    <fragment
        android:id="@+id/mainFragment"
        android:name="com.lilcode.example.jetpacknavigationdemo.ui.main.MainFragment"
        android:label="main_fragment"
        tools:layout="@layout/main_fragment" />
</navigation>
```

## 그래프에 액션 추가

- 두 번째 fragment 를 추가 및 디자인
- 이후 그래프에서 home fragment -> second fragment 로 가는 액션 추가
- design 상에서 추가 하는 것이 편리

```xml
<?xml version="1.0" encoding="utf-8"?>
<navigation xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    xmlns:tools="http://schemas.android.com/tools"
    android:id="@+id/navigation_graph"
    app:startDestination="@id/mainFragment">

    <fragment
        android:id="@+id/mainFragment"
        android:name="com.lilcode.example.jetpacknavigationdemo.ui.main.MainFragment"
        android:label="main_fragment"
        tools:layout="@layout/main_fragment" >
        <action
            android:id="@+id/mainToSecond"
            app:destination="@id/secondFragment" />
    </fragment>
    <fragment
        android:id="@+id/secondFragment"
        android:name="com.lilcode.example.jetpacknavigationdemo.SecondFragment"
        android:label="fragment_second"
        tools:layout="@layout/fragment_second" />
</navigation>
```

## OnFragmentInteractionListener 구현하기

```kotlin
class MainActivity : AppCompatActivity(), SecondFragment.OnFragmentInteractionListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_activity)
    }

    override fun onFragmentInteraction(uri: Uri) {
        
    }
}
```

## 액션 실행하기

```kotlin
    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)

        binding.mainButton.setOnClickListener {
            Navigation.findNavController(it).navigate(R.id.mainToSecond)
        }

        // 또는
        binding.mainButton.setOnClickListener(Navigation.createNavigateOnClickListener(R.id.mainToSecond, null))
    }
```