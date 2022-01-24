import org.jetbrains.kotlin.gradle.tasks.KotlinCompile
import org.gradle.kotlin.dsl.flyway

plugins {
	id("org.springframework.boot") version "2.6.0-SNAPSHOT"
	id("io.spring.dependency-management") version "1.0.11.RELEASE"
	kotlin("jvm") version "1.5.31"
	kotlin("plugin.spring") version "1.5.31"
	id("com.expediagroup.graphql") version "5.1.0"
	id("org.flywaydb.flyway") version "8.0.1"
}

group = "com.keyskey"
version = "0.0.1-SNAPSHOT"
java.sourceCompatibility = JavaVersion.VERSION_11

configurations {
	compileOnly {
		extendsFrom(configurations.annotationProcessor.get())
	}
}

repositories {
	mavenCentral()
	maven { url = uri("https://repo.spring.io/milestone") }
	maven { url = uri("https://repo.spring.io/snapshot") }
}

dependencies {
	implementation("mysql:mysql-connector-java:8.0.25")
	implementation("org.ktorm:ktorm-core:3.4.1")
	implementation("org.ktorm:ktorm-support-mysql:3.4.1")
	implementation("org.springframework.boot:spring-boot-starter-jdbc:2.5.5")
	implementation("org.jetbrains.kotlin:kotlin-reflect")
	implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8")
	implementation("com.expediagroup", "graphql-kotlin-spring-server", "5.1.0")
	implementation("org.springframework.boot:spring-boot-starter:2.5.5")
	implementation("org.valiktor:valiktor-spring-boot-starter:0.12.0")
	implementation("com.graphql-java:graphql-java-extended-scalars:17.0")
	developmentOnly("org.springframework.boot:spring-boot-devtools:2.5.5")
	annotationProcessor("org.springframework.boot:spring-boot-configuration-processor:2.5.5")
	testImplementation("org.springframework.boot:spring-boot-starter-test:2.5.5")
}

tasks.withType<KotlinCompile> {
	kotlinOptions {
		freeCompilerArgs = listOf("-Xjsr305=strict")
		jvmTarget = "11"
	}
}

tasks.withType<Test> {
	useJUnitPlatform()
}

flyway {
	url = "jdbc:mysql://${System.getenv("MYSQL_HOST")}:${System.getenv("MYSQL_PORT")}/ktknowledge_db?autoReconnect=true&useSSL=false"
	user = System.getenv("MYSQL_USER")
	password = System.getenv("MYSQL_PASSWORD")
}
