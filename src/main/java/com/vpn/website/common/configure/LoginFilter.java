package com.vpn.website.common.configure;

import com.alibaba.fastjson.JSONObject;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * @author Administrator
 */
@WebFilter(urlPatterns = {"/building/leaseListByEmployee","/building/leaseList", "/building/addBuilding",
        "/building/update", "/outlets/addOutlets", "/outlets/outletsListAdmin", "/outlets/outletsListByEmployee",
        "/outlets/updateOutlets", "/land/addLand", "/land/landListByEmployee", "/land/landListAdmin",
        "/land/updateLand"}, filterName = "loginFilter")
public class LoginFilter implements Filter {

    public static final String CHECK_TOKEN_URL = "https://qttzzj.com/companyHome/auth/vertifyToken";

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter( ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest httpRequest = (HttpServletRequest)servletRequest;
        HttpServletResponse httpResponse = (HttpServletResponse)servletResponse;
        HttpURLConnection connection = null;
        PrintWriter out = null;
        String token = httpRequest.getHeader("Authorization");
        if(null == token) {
            response(httpResponse);
        }
        try {
                URL url = new URL(CHECK_TOKEN_URL);
                connection = (HttpURLConnection) url.openConnection();
                connection.setRequestMethod("POST");
                connection.setDoOutput(true);
                connection.setDoInput(true);
                connection.setUseCaches(false);
                connection.setRequestProperty("accept", "*/*");
                connection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
                connection.setRequestProperty("connection", "Keep-Alive");
                connection.connect();
                out = new PrintWriter(connection.getOutputStream());
                String params = "checkCharacter=1&token="+token;
                out.write(params);
                out.flush();
                int responseCode = connection.getResponseCode();
                if (responseCode == HttpURLConnection.HTTP_OK) {
                    InputStream inputStream = connection.getInputStream();
                    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream, "UTF-8"));
                    StringBuffer sb = new StringBuffer();
                    String strRead = null;
                    while ((strRead = bufferedReader.readLine()) != null) {
                        sb.append(strRead);
                    }
                    String msg = sb.toString();
                    JSONObject jsonObject = JSONObject.parseObject(msg);
                    String code = jsonObject.getString("code");
                    if ("0".equals(code)) {
                        if(null != jsonObject.getString("character")) {
                            HttpSession httpSession = httpRequest.getSession();
                            httpSession.setAttribute("username", jsonObject.getJSONObject("character").get("name"));
                            httpSession.setAttribute("userId", jsonObject.getJSONObject("character").get("id"));
                        }
                        filterChain.doFilter(servletRequest,servletResponse);
                    }else {
                        response(httpResponse);
                    }

                }
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                if (out != null) {
                    out.close();
                }
                if (connection != null) {
                    connection.disconnect();
                }
               response(httpResponse);
            }
    }

    @Override
    public void destroy() {

    }

    private HttpServletResponse response(HttpServletResponse httpResponse) throws IOException {
        PrintWriter writer = httpResponse.getWriter();
        httpResponse.setStatus(200);
        httpResponse.setHeader("Content-type","text/html;charset=UTF-8");
        httpResponse.setCharacterEncoding("UTF-8");
        httpResponse.setContentType("application/json");
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("code", -11);
        jsonObject.put("data", "");
        jsonObject.put("msg","no auth");
        writer.write(jsonObject.toString());
        writer.close();
        return httpResponse;
    }

    public static Cookie getCookie(HttpServletRequest httpRequest,String name) {
        Cookie[] cookies = httpRequest.getCookies();
        if (cookies==null||cookies.length<1) {
            return null;
        }
        Cookie cookie = null;
        for (Cookie c : cookies) {
            if (name.equals(c.getName())) {
                cookie = c;
                break;
            }
        }
        return cookie;
    }

    public static String getCookieValue(HttpServletRequest httpRequest, String name) {
        Cookie cookie = getCookie(httpRequest, name);
        if(cookie != null){
            return cookie.getValue();
        }
        return null;
    }


}
