<%-- 
    Document   : recaptcha
    Created on : 2016/05/28, 15:04:01
    Author     : gest
--%>
<%@ page 
    import="net.tanesha.recaptcha.ReCaptcha"
    import="net.tanesha.recaptcha.ReCaptchaFactory"
%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    final String siteKey = "6Ldh7yATAAAAAFXQSTDIvh6WOkkP0TXRcB12KZR9";
    final String secretKey = "6Ldh7yATAAAAALd1so7aukMFOHkahuwbIWd9t-9D";
    ReCaptcha c = ReCaptchaFactory.newReCaptcha(siteKey, secretKey, false);
%>
<!DOCTYPE html>
