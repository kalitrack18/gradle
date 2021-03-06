/*
 * Copyright 2018 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.gradle.integtests.fixtures.executer


import org.gradle.test.fixtures.file.TestFile
import org.gradle.util.GradleVersion

class LocallyBuiltGradleDistribution extends DefaultGradleDistribution {
    LocallyBuiltGradleDistribution(String version) {
        super(GradleVersion.version(version), getGradleHome(version), null)
    }

    private static TestFile getGradleHome(String version) {
        return getDistributionsDir().file("gradle-${version}")
    }

    static boolean isLocallyBuiltVersion(String version) {
        return version.contains("-commit-")
    }

    static File getToolingApiJar(String version) {
        return getDistributionsDir().file("gradle-tooling-api-${version}.jar")
    }

    static private TestFile getDistributionsDir() {
        // See BuildCommitDistribution.kt
        new TestFile(IntegrationTestBuildContext.TEST_DIR.file("build/distributions").getAbsoluteFile())
    }
}
