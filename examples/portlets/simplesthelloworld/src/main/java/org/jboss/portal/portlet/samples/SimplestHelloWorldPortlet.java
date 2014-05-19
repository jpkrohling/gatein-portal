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

import java.io.IOException;
import java.io.PrintWriter;

import javax.portlet.GenericPortlet;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.portlet.PortletException;
import javax.portlet.UnavailableException;
import javax.portlet.ActionRequest;
import javax.portlet.PortletPreferences;
import javax.portlet.PortletSecurityException;
import javax.portlet.ActionResponse;


public class SimplestHelloWorldPortlet extends GenericPortlet {
    protected void doView(RenderRequest request, RenderResponse response) throws PortletException, IOException
    {
        response.setContentType("text/html");
        PrintWriter writer = response.getWriter();
        PortletPreferences prefs = request.getPreferences();
        String color = prefs.getValue("color", "not-defined");
        writer.write("<div style='color:" + color + "'>Portlet Preference value: " + color + "</div>");
        writer.close();
    }

    protected void doEdit(RenderRequest request, RenderResponse response) throws PortletException, IOException
    {
        response.setContentType("text/html");
        PortletPreferences prefs = request.getPreferences();
        String currentColor = prefs.getValue("color", "");
        String[] possibleColors = { "black", "blue", "yellow", "green", "red", "orange" };
        PrintWriter writer = response.getWriter();
        writer.write("<div>Portlet Preferences</div>");
        writer.write("<form action='" + response.createActionURL() + "' method='POST'>");
        writer.write("Select a color: ");
        writer.write("<select name='color'>");
        for (String c : possibleColors) {
            writer.write("<option" + (c.equals(currentColor) ? " selected" : "") + ">" + c + "</option>");
        }
        writer.write("</select>");
        writer.write("<input type='submit' value='Save'/>");
        writer.write("</form>");
        writer.close();
    }

    public void processAction(ActionRequest request, ActionResponse response) throws PortletException, IOException
    {
        String selectedColor = request.getParameter("color");
        PortletPreferences prefs = request.getPreferences();
        String currentColor = prefs.getValue("color", "");
        prefs.setValue("color", selectedColor);
        prefs.store();
    }
}
