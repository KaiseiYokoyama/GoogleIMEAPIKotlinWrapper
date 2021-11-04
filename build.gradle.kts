plugins {
    kotlin("jvm") version "1.5.0"
    id("maven-publish")
}

group = "com.github.kaiseiyokoyama"
version = "0.1"

repositories {
    mavenCentral()
}

dependencies {
    implementation(kotlin("stdlib"))
    implementation("org.jetbrains.kotlinx:kotlinx-serialization-json:1.2.1")
    implementation("org.jetbrains.kotlinx:kotlinx-serialization-protobuf:1.2.1")
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.5.2")
    implementation("org.jsoup:jsoup:1.14.2")

    testImplementation("org.junit.jupiter:junit-jupiter:5.5.2")
}

tasks {
    test {
        // JUnit platform を使う設定
        useJUnitPlatform()

        testLogging {
            // テスト時の標準出力と標準エラー出力を表示する
            showStandardStreams = true
        }
    }
}

afterEvaluate {
    publishing {
        publications {
            create<MavenPublication>("release") {
                groupId = group.toString()
                artifactId = "gime"
                version = "1.10"

                from(components["kotlin"])
            }
        }
    }
}