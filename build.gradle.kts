plugins {
	kotlin("jvm") version "1.9.25"
	kotlin("plugin.spring") version "1.9.25"
	id("org.springframework.boot") version "3.4.4"
	id("io.spring.dependency-management") version "1.1.7"
	jacoco
	id("info.solidsoft.pitest") version "1.15.0" // Remplacez par la dernière version stable
}

group = "com.projet1"
version = "0.0.1-SNAPSHOT"

java {
	toolchain {
		languageVersion = JavaLanguageVersion.of(21)
	}
}

repositories {
	mavenCentral()
}

dependencies {
	implementation("org.springframework.boot:spring-boot-starter")
	implementation("org.jetbrains.kotlin:kotlin-reflect")
	testImplementation("org.springframework.boot:spring-boot-starter-test")
	testImplementation("org.jetbrains.kotlin:kotlin-test-junit5")
	testImplementation("io.kotest:kotest-runner-junit5:5.9.1")
	testImplementation("io.kotest:kotest-assertions-core:5.9.1")
	testRuntimeOnly("org.junit.platform:junit-platform-launcher")
	testImplementation("io.kotest:kotest-property:5.9.1")
	testImplementation("io.mockk:mockk:1.13.5")
}

kotlin {
	compilerOptions {
		freeCompilerArgs.addAll("-Xjsr305=strict")
	}
}

tasks.withType<Test> {
	useJUnitPlatform()
}

jacoco {
    toolVersion = "0.8.10" // Assurez-vous d'utiliser une version compatible
}

tasks.jacocoTestReport {
    dependsOn(tasks.test) // Exécute les tests avant de générer le rapport

    reports {
        xml.required.set(true) // Génère un rapport XML (utile pour CI/CD)
        html.required.set(true) // Génère un rapport HTML (facile à lire)
    }
}

tasks.jacocoTestCoverageVerification {
    dependsOn(tasks.jacocoTestReport)

    violationRules {
        rule {
            limit {
                minimum = "0.8".toBigDecimal() // Définit un seuil minimum de 80% de couverture
            }
        }
    }
}

pitest {
	junit5PluginVersion.set("1.1.0")
	jvmArgs.set(listOf("-target", "21")) // Indique à PITest d'utiliser Java 21
	targetClasses.set(listOf("com.projet1.*"))
	targetTests.set(listOf("com.projet1.*"))
	mutators.set(listOf("DEFAULTS"))
	threads.set(4)
	outputFormats.set(listOf("HTML", "XML"))
	timestampedReports.set(false)
}