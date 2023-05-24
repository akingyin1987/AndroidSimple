//enableFeaturePreview("VERSION_CATALOGS")
pluginManagement {
    repositories {
        google()
      //  mavenCentral()
       // gradlePluginPortal()
        maven { setUrl( "https://maven.aliyun.com/repository/public/") }
    }
}
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
       // mavenCentral()
        maven { setUrl( "https://maven.aliyun.com/repository/public/") }
        mavenCentral()
    }
}
rootProject.name = "AndroidSimple"
include (":app")
