package org.holy.security.component.token;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import javax.servlet.http.HttpServletRequest;
import java.util.Objects;

/**
 * <p>
 *
 * @author holy
 * @date 2019/4/16
 * @version 1.0.0
 */
@Component
public class TokenManager {

	@Autowired
	private JwtConfig jwtConfig;

	/**
	 * 从 request-header 获取 token
	 * <p>
	 * @param request
	 * @return
	 */
	public String getTokenFromRequest(HttpServletRequest request) {
		String token = request.getHeader(jwtConfig.getHeaderName());
		if (null == token || 0 == token.trim().length() || !token.startsWith(jwtConfig.getTokenPrefix())) {
			throw new IllegalArgumentException("用户状态异常");
		}
		return token;
	}

}
