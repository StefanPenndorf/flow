/**
 *    Copyright 2000-2023 Vaadin Ltd
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.vaadin.gradle

import com.vaadin.flow.server.Constants
import com.vaadin.flow.server.frontend.FrontendUtils
import org.gradle.api.Project
import org.gradle.api.tasks.OutputDirectory
import org.gradle.api.tasks.OutputFile
import java.io.File

/**
 * Declaratively defines the outputs of the [VaadinPrepareFrontendTask]:
 * package.json, vite.config.ts, and other files generated by Vaadin, as well
 * as the files in the frontend directory. Being used for caching the results
 * of vaadinPrepareFrontend task to not run it again if inputs are the same.
 */
public class PrepareFrontendOutputProperties public constructor(project: Project) {

    private val project: Project

    private val extension: VaadinFlowPluginExtension

    init {
        this.project = project
        extension = VaadinFlowPluginExtension.get(project)
    }

    @OutputFile
    public fun getPackageJson(): File {
        return File(project.projectDir, Constants.PACKAGE_JSON)
    }

    @OutputFile
    public fun getPackageLockJson(): File {
        return File(project.projectDir, Constants.PACKAGE_LOCK_JSON)
    }

    @OutputFile
    public fun getPackageLockYaml(): File {
        return File(project.projectDir, Constants.PACKAGE_LOCK_YAML)
    }

    @OutputFile
    public fun getViteConfig(): File {
        return File(project.projectDir, FrontendUtils.VITE_CONFIG)
    }

    @OutputFile
    public fun getViteGeneratedConfig(): File {
        return File(project.projectDir, FrontendUtils.VITE_GENERATED_CONFIG)
    }

    @OutputFile
    public fun getTsConfig(): File {
        return File(project.projectDir, "tsconfig.json")
    }

    @OutputFile
    public fun getTsDefinition(): File {
        return File(project.projectDir, "types.d.ts")
    }

    @OutputDirectory
    public fun getFrontendDirectory(): File {
        return extension.frontendDirectory
    }

    @OutputDirectory
    public fun getGeneratedTsFolder(): File {
        return extension.generatedTsFolder
    }

    @OutputDirectory
    public fun getResourceOutputDirectory(): File {
        return extension.resourceOutputDirectory
    }
}