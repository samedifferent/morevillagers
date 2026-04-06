plugins {
    id("java")
    id("idea")
    id("java-library")
}

version = "${project.property("mod_version")}+${project.property("minecraft_version")}"
group = "${project.property("maven_group")}"

base {
    archivesName = "${project.property("archives_base_name")}"
}

java {
    toolchain.languageVersion = JavaLanguageVersion.of(25)
}

repositories {
    mavenCentral()
}

tasks {

    processResources {
        val expandProps = mapOf(
            "modVersion" to project.property("mod_version") as String,
            "minecraftVersion" to project.property("minecraft_version") as String,
        )

        filesMatching(
            listOf(
                "pack.mcmeta",
                "fabric.mod.json",
                "META-INF/mods.toml",
                "META-INF/neoforge.mods.toml"
            )
        ) {
            expand(expandProps)
        }

        inputs.properties(expandProps)
    }
}