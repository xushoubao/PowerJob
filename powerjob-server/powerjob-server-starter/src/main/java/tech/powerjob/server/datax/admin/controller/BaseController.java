package tech.powerjob.server.datax.admin.controller;


import com.baomidou.mybatisplus.extension.api.ApiController;
import tech.powerjob.server.datax.admin.util.JwtTokenUtils;

import javax.servlet.http.HttpServletRequest;
import java.util.Enumeration;

/**
 * base controller
 */
public class BaseController extends ApiController {

    public static final String STRING_BLANK = "";

    public Integer getCurrentUserId(HttpServletRequest request) {
        Enumeration<String> auth = request.getHeaders(JwtTokenUtils.TOKEN_HEADER);
        String token = auth.nextElement().replace(JwtTokenUtils.TOKEN_PREFIX, STRING_BLANK);
        return JwtTokenUtils.getUserId(token);
    }
}