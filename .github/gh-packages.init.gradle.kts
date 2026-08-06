// CI-only: add a GitHub Packages Maven repository to any project that applies
// maven-publish, so the mingwX64 skiko artifacts can be published without
// touching skiko's own publishing configuration. Credentials come from the
// GITHUB_ACTOR / GITHUB_TOKEN environment; the URL from -PgithubPackagesUrl.
gradle.allprojects {
    pluginManager.withPlugin("maven-publish") {
        extensions.configure(org.gradle.api.publish.PublishingExtension::class.java) {
            repositories.maven {
                name = "GitHubPackages"
                setUrl(providers.gradleProperty("githubPackagesUrl").get())
                credentials {
                    username = System.getenv("GITHUB_ACTOR")
                    password = System.getenv("GITHUB_TOKEN")
                }
            }
            // Self-hosted Reposilite — lets consumers resolve the fork without
            // GitHub Packages authentication. Only added when CI provides creds.
            if (System.getenv("BITSYCORE_MAVEN_USER") != null) {
                repositories.maven {
                    name = "Bitsycore"
                    setUrl("https://maven.bitsycore.com/releases")
                    credentials {
                        username = System.getenv("BITSYCORE_MAVEN_USER")
                        password = System.getenv("BITSYCORE_MAVEN_TOKEN")
                    }
                }
            }
        }
    }
}
