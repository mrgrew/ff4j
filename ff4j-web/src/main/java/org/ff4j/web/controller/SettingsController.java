package org.ff4j.web.controller;

/*-
 * #%L
 * ff4j-web
 * %%
 * Copyright (C) 2013 - 2024 FF4J
 * %%
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
 * #L%
 */

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.ff4j.FF4j;
import org.ff4j.utils.Util;
import org.ff4j.web.bean.WebConstants;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.WebContext;

import java.io.IOException;

import static org.ff4j.web.bean.WebConstants.KEY_AUDITENABLE;
import static org.ff4j.web.bean.WebConstants.TOGGLE_AUDIT;

/**
 * Controller for main class
 *
 * @author Cedrick LUNVEN (@clunven)
 */
public class SettingsController extends AbstractController {
	
    /** Logger for this class. */
    public static final Logger LOGGER = LoggerFactory.getLogger(SettingsController.class);
    
	/** View name. */
	private static final String VIEW_SETTINGS = "settings";
	
	/** {@inheritDoc} */
	public SettingsController(FF4j ff4j, TemplateEngine te) {
		super(ff4j, VIEW_SETTINGS, te);
	}
	
	/** {@inheritDoc} */
    public void post(HttpServletRequest req, HttpServletResponse res, WebContext ctx)
    throws IOException {
        LOGGER.warn("Nothing implemented as POST");
    }
    
    /** {@inheritDoc} */
    public void get(HttpServletRequest req, HttpServletResponse res, WebContext ctx)
	throws IOException {
		ctx.setVariable(KEY_TITLE, "Settings");
		String operation = req.getParameter(WebConstants.OPERATION);
        String msgType = "success";
        String msg = null;
        if (Util.hasLength(operation) && TOGGLE_AUDIT.equalsIgnoreCase(operation)) {
            if (getFf4j().isEnableAudit()) {
                getFf4j().audit(false);
                msg = "Audit is now DISABLED";
                LOGGER.info("Audit has been disabled");
            } else {
                getFf4j().audit(true);
                msg = "Audit is now ENABLED";
                LOGGER.info("Audit has been enabled");
            }
        }
        ctx.setVariable(KEY_AUDITENABLE, getFf4j().isEnableAudit());
        ctx.setVariable("msgType", msgType);
        ctx.setVariable("msgInfo", msg);
	}

}
