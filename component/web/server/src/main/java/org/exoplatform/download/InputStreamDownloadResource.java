/**
 * Copyright (C) 2009 eXo Platform SAS.
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

package org.exoplatform.download;

import java.io.InputStream;

/**
 * Created by The eXo Platform SARL
 * Author : Tuan Nguyen
 *          tuan08@users.sourceforge.net
 * Dec 26, 2005
 *
 * @deprecated It is better to avoid using this download resource
 */
public class InputStreamDownloadResource extends DownloadResource {
    private InputStream is_;

    public InputStreamDownloadResource(InputStream is, String resourceMimeType) {
        this(null, is, resourceMimeType);
    }

    public InputStreamDownloadResource(String downloadType, InputStream is, String resourceMimeType) {
        super(downloadType, resourceMimeType);
        is_ = is;
    }

    public InputStream getInputStream() {
        return is_;
    }
}