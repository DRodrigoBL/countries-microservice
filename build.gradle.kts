import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

buildscript {
    repositories {
        jcenter()
    }
}

plugins {
    id("org.springframework.boot") version "2.2.0.RELEASE" apply false
    id("io.spring.dependency-management") version "1.0.8.RELEASE" apply false

    kotlin("jvm") version "1.4.10" apply false
    kotlin("plugin.spring") version "1.4.10" apply false

    id("io.gitlab.arturbosch.detekt").version("1.15.0-RC1")
}

allprojects {
    group = "com.rappi.restaurants"
    version = "1.0.0"

    tasks.withType<JavaCompile> {
        sourceCompatibility = "1.8"
        targetCompatibility = "1.8"
    }

    tasks.withType<KotlinCompile> {
        kotlinOptions {
            freeCompilerArgs = listOf("-Xjsr305=strict")
            jvmTarget = "1.8"
            incremental = false
        }
    }

    tasks.withType<io.gitlab.arturbosch.detekt.Detekt>().configureEach {
        this.jvmTarget = "1.8"
    }
}

subprojects {
    repositories {
        jcenter()
    }

    apply {
        plugin("io.spring.dependency-management")
        plugin("io.gitlab.arturbosch.detekt")
    }

    dependencies {
        detektPlugins("io.gitlab.arturbosch.detekt:detekt-formatting:1.15.0-RC1")
    }

    detekt {
        toolVersion = "1.15.0-RC1"
        input = files("src/main/kotlin", "src/main/java")
        failFast = false
        ignoreFailures = true
        buildUponDefaultConfig = true
        config = files("config/detekt/detekt.yml")
        reports {
            xml {
                enabled = true
                destination = file("build/reports/detekt.xml")
            }
            html {
                enabled = true
                destination = file("build/reports/detekt.html")
            }
            txt {
                enabled = true
                destination = file("build/reports/detekt.txt")
            }
        }
    }
}
