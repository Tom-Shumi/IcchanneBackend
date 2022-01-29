import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
	id("org.springframework.boot") version "2.6.2"
	id("io.spring.dependency-management") version "1.0.11.RELEASE"
	war
	kotlin("jvm") version "1.6.10"
	kotlin("plugin.spring") version "1.6.10"
}

group = "jp.ne.icchannel.backend"
version = "0.0.1-SNAPSHOT"
java.sourceCompatibility = JavaVersion.VERSION_11

configurations {
	compileOnly {
		extendsFrom(configurations.annotationProcessor.get())
	}
}

repositories {
	mavenCentral()
}

dependencies {
	implementation("org.springframework.boot:spring-boot-starter-data-redis")
//	implementation("org.springframework.boot:spring-boot-starter-jdbc")
	implementation("org.springframework.boot:spring-boot-starter-security")
	implementation("org.springframework.boot:spring-boot-starter-web")
	implementation("com.fasterxml.jackson.module:jackson-module-kotlin")
	implementation("org.jetbrains.kotlin:kotlin-reflect")
	implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8")
//	implementation("org.mybatis.spring.boot:mybatis-spring-boot-starter:2.2.1")
	implementation("org.springframework.session:spring-session-data-redis")
	implementation ("org.springframework.boot:spring-boot-starter-aop")
	implementation("org.springframework.session:spring-session-data-redis")
	implementation("com.graphql-java-kickstart:graphql-spring-boot-starter:12.0.0")
	implementation("com.graphql-java-kickstart:altair-spring-boot-starter:11.1.0")
	implementation("com.graphql-java:graphql-spring-boot-starter:5.0.2")
	implementation("org.elasticsearch:elasticsearch:7.10.2")
	implementation("org.elasticsearch.client:elasticsearch-rest-high-level-client:7.10.2")
	implementation ("io.lettuce:lettuce-core:6.1.1.RELEASE")
	implementation ("com.google.code.gson:gson:2.8.6")

	compileOnly("org.projectlombok:lombok")
	developmentOnly("org.springframework.boot:spring-boot-devtools")
//	implementation("mysql:mysql-connector-java")
	implementation("org.slf4j:slf4j-api")
	annotationProcessor("org.projectlombok:lombok")
	implementation("org.springframework.boot:spring-boot-starter-tomcat")
	testImplementation("org.springframework.boot:spring-boot-starter-test")
	testImplementation("org.springframework.security:spring-security-test")
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

tasks.bootWar {
	launchScript()
}