/*
 * Copyright 2017 MovingBlocks
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
package org.terasology.surajworld;

import org.terasology.core.world.generator.facetProviders.SeaLevelProvider;
import org.terasology.engine.SimpleUri;
import org.terasology.registry.In;
import org.terasology.world.generation.BaseFacetedWorldGenerator;
import org.terasology.world.generation.WorldBuilder;
import org.terasology.world.generator.RegisterWorldGenerator;
import org.terasology.world.generator.plugin.WorldGeneratorPluginLibrary;


@RegisterWorldGenerator(id = "SurajWorld", displayName = "Suraj World")
public class SurajWorldGenerator extends BaseFacetedWorldGenerator {
    @In
    private WorldGeneratorPluginLibrary worldGeneratorPluginLibrary;

    public SurajWorldGenerator(SimpleUri uri) {
        super(uri);
    }

    @Override
    protected WorldBuilder createWorld() {
        return new WorldBuilder(worldGeneratorPluginLibrary)
                .addProvider(new SurfaceProvider())
                .addProvider(new SeaLevelProvider(0))
                .addProvider(new MountainsProvider())
                .addProvider(new HouseProvider())
                .addProvider(new FrozenLakesProvider())
                .addRasterizer(new HouseRasterizer())
                .addRasterizer(new FrozenLakesRasterizer())
                .addRasterizer(new SurajWorldRasterizer())
                .addProvider(new CaveFacetProvider())
                .addProvider(new CaveToDensityProvider())
                .addRasterizer(new CaveRasterizer())
                .addProvider(new FloraProvider())
                .addRasterizer(new FloraRasterizer())
                .addRasterizer(new BushRasterizer())
                .addProvider(new BushProvider())
                .addProvider(new GrassProvider())
                .addRasterizer(new GrassRasterizer());

    }

}