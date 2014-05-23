/******************************************************************************
 * JBoss, a division of Red Hat                                               *
 * Copyright 2008, Red Hat Middleware, LLC, and individual                    *
 * contributors as indicated by the @authors tag. See the                     *
 * copyright.txt in the distribution for a full listing of                    *
 * individual contributors.                                                   *
 *                                                                            *
 * This is free software; you can redistribute it and/or modify it            *
 * under the terms of the GNU Lesser General Public License as                *
 * published by the Free Software Foundation; either version 2.1 of           *
 * the License, or (at your option) any later version.                        *
 *                                                                            *
 * This software is distributed in the hope that it will be useful,           *
 * but WITHOUT ANY WARRANTY; without even the implied warranty of             *
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU           *
 * Lesser General Public License for more details.                            *
 *                                                                            *
 * You should have received a copy of the GNU Lesser General Public           *
 * License along with this software; if not, write to the Free                *
 * Software Foundation, Inc., 51 Franklin St, Fifth Floor, Boston, MA         *
 * 02110-1301 USA, or see the FSF site: http://www.fsf.org.                   *
 ******************************************************************************/
package org.jboss.portal.portlet.samples;

import org.exoplatform.container.PortalContainer;
import org.exoplatform.services.organization.OrganizationService;
import org.exoplatform.services.organization.User;

import java.io.IOException;
import java.io.PrintWriter;
import java.security.Principal;

import javax.portlet.GenericPortlet;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;


public class SimplestHelloWorldPortlet extends GenericPortlet {
    public void doView(RenderRequest request, RenderResponse response) throws IOException {
        PrintWriter writer = response.getWriter();

        Principal principal = request.getUserPrincipal();
        if (null != principal) {
            System.out.println("Principal for this request: " + principal.getName());
            writer.write("Hello " + principal.getName() +"!<br/>");
            OrganizationService organizationService = PortalContainer.getInstance().getComponentInstanceOfType(OrganizationService.class);
            try {
                User user = organizationService.getUserHandler().findUserByName(principal.getName());
                writer.write("User's display name: " + user.getDisplayName() + "<br/>");
                writer.write("User's last login time: " + user.getLastLoginTime() + "<br/>");
            } catch (Exception e) {
                System.out.println("Got an exception while retrieving the user by name");
            }
        } else {
            System.out.println("Principal is null");
            writer.write("Hello world!");
        }

        writer.close();
    }
}
