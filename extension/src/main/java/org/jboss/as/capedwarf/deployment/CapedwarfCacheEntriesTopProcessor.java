/*
 * JBoss, Home of Professional Open Source.
 * Copyright 2012, Red Hat, Inc., and individual contributors
 * as indicated by the @author tags. See the copyright.txt file in the
 * distribution for a full listing of individual contributors.
 *
 * This is free software; you can redistribute it and/or modify it
 * under the terms of the GNU Lesser General Public License as
 * published by the Free Software Foundation; either version 2.1 of
 * the License, or (at your option) any later version.
 *
 * This software is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
 * Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public
 * License along with this software; if not, write to the Free
 * Software Foundation, Inc., 51 Franklin St, Fifth Floor, Boston, MA
 * 02110-1301 USA, or see the FSF site: http://www.fsf.org.
 */

package org.jboss.as.capedwarf.deployment;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.jboss.as.capedwarf.services.CacheConfig;
import org.jboss.as.capedwarf.services.CacheConfigs;
import org.jboss.as.capedwarf.services.CacheName;
import org.jboss.as.server.deployment.DeploymentPhaseContext;
import org.jboss.as.server.deployment.DeploymentUnit;
import org.jboss.as.server.deployment.DeploymentUnitProcessingException;

/**
 * Define cache configs and its classes.
 *
 * @author <a href="mailto:ales.justin@jboss.org">Ales Justin</a>
 */
public class CapedwarfCacheEntriesTopProcessor extends CapedwarfTopDeploymentUnitProcessor {
    protected void doDeploy(DeploymentPhaseContext phaseContext) throws DeploymentUnitProcessingException {
        Map<CacheName, CacheConfig> configs = new ConcurrentHashMap<>();

        configs.put(CacheName.DEFAULT, CacheConfigs.createDefaultConfig());
        configs.put(CacheName.SEARCH, CacheConfigs.createSearchConfig());
        configs.put(CacheName.PROSPECTIVE_SEARCH, CacheConfigs.createProspectiveSearchConfig());
        configs.put(CacheName.TASKS, CacheConfigs.createTasksConfig());
        configs.put(CacheName.LOGS, CacheConfigs.createLogsConfig());
        configs.put(CacheName.CHANNEL, CacheConfigs.createChannelConfig());

        final DeploymentUnit unit = phaseContext.getDeploymentUnit();
        unit.putAttachment(CapedwarfAttachments.CONFIGS, configs);
    }
}
