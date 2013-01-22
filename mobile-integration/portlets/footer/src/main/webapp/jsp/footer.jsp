<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<portlet:defineObjects/>

<%-- Action to change the language--%>
<c:set var="CHANGE_LANGUAGE_ACTION" value="if(document.getElementById('UIMaskWorkspace')) ajaxGet(eXo.env.server.createPortalURL('UIPortal', 'ChangeLanguage', true));"/>
<%-- The current language name in the current locale --%>
<c:set var="localeDisplayLanguage" value="${renderRequest.getLocale().getDisplayLanguage()}"/>
<%-- The resourceBundle used to retrieve locale string values --%>
<c:set var="resourceBundle" value="${portletConfig.getResourceBundle(renderRequest.locale)}"/>
<%-- Map of alternativeSite url and names --%>
<c:set var="alternativeSites" value="${renderRequest.getAttribute(\"alternativeSites\")}"/>

<div class="gtnResponsiveFooterPortlet">
<div class="collapsibleRow">
  <div class="options">
    <ul>
      <c:forEach var="alternativeSites" items="${alternativeSites}">
        <li class="alternativeSite">
          <a href="${alternativeSites.value}">${alternativeSites.key}</a>
        </li>
      </c:forEach>
      <li class="language">
        <a href="#" onclick="${CHANGE_LANGUAGE_ACTION}">${localeDisplayLanguage}</a>
        <div class="downCaret"></div>
      </li>
    </ul>
    <div class="clear"></div>
  </div>
  <div class="copyright" id="<portlet:namespace/>_copyright">
  	<p>${resourceBundle.getString("copyrightText")}</p>
  </div>
  </div>
  <div class="clear"/>
</div>
