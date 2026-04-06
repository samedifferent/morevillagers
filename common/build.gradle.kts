plugins {
    id("net.fabricmc.fabric-loom")
    id("multiloader-common")
}

base {
    archivesName = "${project.property("archives_base_name")}-common"
}

dependencies {
    minecraft("com.mojang:minecraft:${project.property("minecraft_version")}")

    compileOnly("net.fabricmc:fabric-loader:${project.property("fabric_loader_version")}")
}

val commonJava: Configuration by configurations.creating {
    isCanBeResolved = false
    isCanBeConsumed = true
}

val commonResources: Configuration by configurations.creating {
    isCanBeResolved = false
    isCanBeConsumed = true
}

artifacts {
    afterEvaluate {
        val mainSourceSet = sourceSets.main.get()
        mainSourceSet.java.sourceDirectories.files.forEach {
            add(commonJava.name, it)
        }
        mainSourceSet.resources.sourceDirectories.files.forEach {
            add(commonResources.name, it)
        }
    }
}