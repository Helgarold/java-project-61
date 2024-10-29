plugins {
    java
    application
    checkstyle
}

group = "hexlet.code"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(platform("org.junit:junit-bom:5.10.0"))
    testImplementation("org.junit.jupiter:junit-jupiter")
    checkstyle("org.checkstyle:checkstyle:10.19")
}

tasks.getByName<JavaExec>("run") {
    standardInput = System.`in`
}

tasks.test {
    useJUnitPlatform()
}

application {
    mainClass.set("hexlet.code.App")
}

checkstyle {
    toolVersion = "10.19" // Убедитесь, что версия корректна
    configFile = file("config/checkstyle/checkstyle.xml")
}

tasks.withType<Checkstyle>().configureEach {
    reports {
        xml.required = false
        html.required = true
        html.stylesheet = resources.text.fromFile("config/checkstyle/checkstyle.xsl")
    }
}

// Конфигурация checkstyleMain
tasks.named<Checkstyle>("checkstyleMain") {
    source = fileTree("src/main/java") // Укажите директорию с исходным кодом
    include("<strong>/*.java") // Включите все Java-файлы
}