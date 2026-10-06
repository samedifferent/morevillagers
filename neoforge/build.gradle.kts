plugins {
    id("multiloader-loader")
    id("net.neoforged.gradle.userdev") version "7.1.39"
}

version = "neoforge-${project.property("mod_version")}+${project.property("minecraft_version")}"

base {
    archivesName = "${project.property("archives_base_name")}"
}

dependencies {
    implementation("net.neoforged:neoforge:${project.property("neoforged_version")}")
}

sourceSets.main {
    resources {
        srcDir(rootDir.resolve("generated"))
    }
}

runs {
    configureEach {
        modSource(sourceSets.main.get())
    }

    named("serverData") {
        programArguments("--mod", "morevillagers")
        programArguments("--all")
        programArguments("--output", rootDir.resolve("generated").absolutePath)
    }
}
