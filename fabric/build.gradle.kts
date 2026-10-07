plugins {
    id("net.fabricmc.fabric-loom")
    id("multiloader-loader")
}

version = "fabric-${project.property("mod_version")}+${project.property("minecraft_version")}"

base {
    archivesName = "${project.property("archives_base_name")}"
}

repositories {
    maven("https://maven.shedaniel.me/")
    maven("https://maven.terraformersmc.com/releases")
}

fabricApi {
    configureDataGeneration {
        client = true
        outputDirectory = rootDir.resolve("generated")
    }
}

dependencies {
    minecraft("com.mojang:minecraft:${project.property("minecraft_version")}")

    api("net.fabricmc.fabric-api:fabric-api:${project.property("fabric_api_version")}")
    api(include("me.shedaniel.cloth:cloth-config-fabric:${project.property("cloth_fabric_version")}") {
        exclude(group = "net.fabricmc.fabric-api")
    })
    implementation("com.terraformersmc:modmenu:${project.property("modmenu_version")}") {
        exclude(module = "fabric-api")
    }
}

loom {
    runConfigs.all {
        ideConfigGenerated(true)
    }
}
