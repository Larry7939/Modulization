
// Gradle의 의존성 해결(Dependency Resolution) 관련 설정을 담당하는 블록으로,
// 프로젝트에서 필요한 라이브러리나 플러그인을 찾는 방법과 저장소(repository) 등을 지정한다.
dependencyResolutionManagement {

//    의존성 검색에 사용할 저장소를 지정하는 부분
//    → google(): Google의 Maven 저장소를 사용
//    → mavenCentral(): Maven Central 저장소를 사용
//    이 두 저장소에서 의존성(라이브러리)을 다운로드할 수 있도록 설정한다.
    repositories {
        google()
        mavenCentral()
    }

//    버전 카탈로그(Version Catalog)를 설정하는 부분
//    → create("libs"): 이름이 "libs"인 버전 카탈로그를 생성한다.
//    → from(files("../gradle/libs.versions.toml")): 외부 파일(libs.versions.toml)에서 의존성 버전 정보를 가져온다.
//    → 이를 통해 여러 모듈에서 동일한 의존성 버전을 중앙에서 관리할 수 있다.
    versionCatalogs {
        create("libs") {
            from(files("../gradle/libs.versions.toml"))
        }
    }
}
//루트 프로젝트의 이름을 "build-logic"으로 지정
rootProject.name = "build-logic"
//서브 프로젝트(모듈) 중 하나인 "convention" 모듈을 현재 빌드에 포함시킨다.
include(":convention")