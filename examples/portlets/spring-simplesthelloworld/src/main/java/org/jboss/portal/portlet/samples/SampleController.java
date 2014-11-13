/*
* JBoss, a division of Red Hat
* Copyright 2014, Red Hat Middleware, LLC, and individual
* contributors as indicated by the @authors tag. See the
* copyright.txt in the distribution for a full listing of
* individual contributors.
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
package org.jboss.portal.portlet.samples;

import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.portlet.ModelAndView;
import org.springframework.web.portlet.context.PortletRequestAttributes;
import org.springframework.web.portlet.mvc.AbstractController;

/**
 *
 * @author Juraci Paixão Kröhling <juraci at kroehling.de>
 */
public class SampleController extends AbstractController {

    @Override
    public ModelAndView handleRenderRequestInternal(RenderRequest request, RenderResponse response) {
        RequestAttributes attributes = RequestContextHolder.currentRequestAttributes();
        String message = "It's not a PortletRequestAttributes nor ServletRequestAttributes";

        if (attributes instanceof PortletRequestAttributes) {
            message = "We have a PortletRequestAttributes";
        }

        if (attributes instanceof ServletRequestAttributes) {
            message = "We have a ServletRequestAttributes";
        }

        ModelAndView mav = new ModelAndView("sample");
        mav.addObject("message", message);
        return mav;
    }
}
