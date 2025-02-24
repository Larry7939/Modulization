//Kotlin DSL 플러그인 적용 → Kotlin DSL을 사용하면 Groovy 대신 Kotlin을 사용하여 빌드 스크립트를 작성할 수 있으며, 타입 안정성과 IDE 지원(자동완성 등)을 향상시킨다.
plugins {
    `kotlin-dsl`
}

//프로젝트의 그룹 ID 설정 → 빌드 산출물 식별 시 사용되며, 모듈 간의 네이밍 규칙 및 패키징에 영향을 준다.
group = "com.multi.module.buildlogic"


dependencies {
//    빌드 스크립트가 컴파일될 때 필요한 의존성들을 정의한다.
//    -> compileOnly 설정을 사용하여, 이 의존성들은 빌드 타임에만 필요하고 최종 산출물에는 포함되지 않는다.
    compileOnly(libs.android.gradlePlugin)
//  Android 빌드 도구에서 공통적으로 사용하는 라이브러리를 컴파일 시 의존성으로 추가한다.
    compileOnly(libs.android.tools.common)
//  Kotlin Gradle Plugin을 컴파일 타임 의존성으로 추가하여, 빌드 스크립트 내에서 Kotlin 관련 기능을 사용할 수 있도록 한다.
    compileOnly(libs.kotlin.gradlePlugin)
//    Kotlin Symbol Processing(KSP) Gradle 플러그인을 컴파일 시 의존성으로 추가
    compileOnly(libs.ksp.gradlePlugin)
}