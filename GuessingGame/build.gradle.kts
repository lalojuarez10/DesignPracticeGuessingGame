plugins {
  java
  jacoco
  pmd
}

repositories {
	mavenCentral()
}

dependencies {
  testCompile("org.junit.jupiter:junit-jupiter-api:5.2.0")
	testRuntime("org.junit.jupiter:junit-jupiter-engine:5.2.0")
	testRuntime("org.junit.platform:junit-platform-console:1.2.0")
        testCompile("org.mockito:mockito-core:1.10.19")
}

tasks {
    val treatWarningsAsError =
            listOf("-Xlint:unchecked", "-Xlint:deprecation", "-Werror")

    getByName<JavaCompile>("compileJava") {
        options.compilerArgs = treatWarningsAsError
    }

    getByName<JavaCompile>("compileTestJava") {
        options.compilerArgs = treatWarningsAsError
    }
 
    getByName<JacocoReport>("jacocoTestReport") {
      afterEvaluate {
        classDirectories.setFrom(files(classDirectories.files.map {
          fileTree(it) { exclude("**/main/**") }
        }))
      }  
      } 
}
 
sourceSets {
  main {
      java.srcDirs("src")
  }
  test {
    java.srcDirs("test")
  }
}

val test by tasks.getting(Test::class) {
	useJUnitPlatform {}
}

pmd {
    ruleSets = listOf()
    ruleSetFiles = files("./conf/pmd/ruleset.xml")
    toolVersion = "6.22.0"
}

defaultTasks("clean", "test", "jacocoTestReport", "pmdMain")
