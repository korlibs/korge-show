import com.soywiz.korge.gradle.*

buildscript {
	val korgePluginVersion: String by project

	repositories {
		mavenLocal()
		mavenCentral()
		google()
		maven { url = uri("https://plugins.gradle.org/m2/") }
	}
	dependencies {
		classpath("com.soywiz.korlibs.korge.plugins:korge-gradle-plugin:$korgePluginVersion")
	}
}

apply<KorgeGradlePlugin>()

korge {
	id = "com.sample.demo"

// To enable all targets at once

	//targetAll()

// To enable targets based on properties/environment variables
	//targetDefault()

// To selectively enable targets
	
	targetJvm()
	targetJs()
	//targetDesktop()
	//targetIos()
	//targetAndroidIndirect() // targetAndroidDirect()
	//targetAndroidDirect()
}

fun sourceSetDependsOn(base: String, vararg dependencies: String) {
	for (suffix in listOf("Main", "Test")) {
		for (dependency in dependencies) {
			kotlin.sourceSets.maybeCreate("$base$suffix").dependsOn(kotlin.sourceSets.maybeCreate("$dependency$suffix"))
		}
	}
}

sourceSetDependsOn("nonJvm", "common")
sourceSetDependsOn("nonJs", "common")

sourceSetDependsOn("js", "nonJvm")
sourceSetDependsOn("jvm", "nonJs")
