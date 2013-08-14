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

import org.jboss.as.ee.structure.DeploymentType;
import org.jboss.as.server.deployment.DeploymentUnit;

/**
 * Capedwarf web deployment unit processor.
 *
 * @author <a href="mailto:ales.justin@jboss.org">Ales Justin</a>
 */
public abstract class CapedwarfWebDeploymentUnitProcessor extends CapedwarfDeploymentUnitProcessor {
    @Override
    protected boolean proceed(DeploymentUnit unit) {
        return (CapedwarfDeploymentMarker.getDeploymentType(unit) == DeploymentType.WAR);
    }

    static DeploymentUnit getTopDeploymentUnit(DeploymentUnit unit) {
        while (unit.getParent() != null) {
            unit = unit.getParent();
        }
        return unit;
    }
}