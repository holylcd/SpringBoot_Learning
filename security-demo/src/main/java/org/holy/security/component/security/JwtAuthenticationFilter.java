package org.holy.security.component.security;

import lombok.extern.slf4j.Slf4j;
import org.holy.security.component.token.JwtPrincipal;
import org.holy.security.component.token.JwtProvider;
import org.holy.security.component.token.TokenManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.http.MediaType;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;

/**
 * 验证 token，注入用户主体id
 */
@Slf4j
@Component
public class JwtAuthenticationFilter extends OncePerRequestFilter {

	@Autowired
	private JwtProvider jwtProvider;

	@Autowired
	private RedisTemplate<String, String> redisTemplate;
	
	@Autowired
	private TokenManager tokenManager;

	@Override
	protected void doFilterInternal(HttpServletRequest request,
                                    HttpServletResponse response,
                                    FilterChain filterChain)
			throws IOException, ServletException {

		String token = tokenManager.getTokenFromRequest(request);

		JwtPrincipal principal = jwtProvider.parseJwt(token);

		Long userId = principal.getUserId();

		// Boolean exist = redisTemplate.hasKey("xxxxx:xxxx:xxx" + userId);
		Boolean exist = true;

		if (exist) {
			UserPrincipal userPrincipal = new UserPrincipal(
					null,
					userId,
					null,
					null,
					false,
					false,
					false,
					false
			);
			UsernamePasswordAuthenticationToken authentication =
					new UsernamePasswordAuthenticationToken(
							userPrincipal,
							token
					);

			SecurityContextHolder.getContext().setAuthentication(authentication);

			filterChain.doFilter(request, response);

		} else {

			response.setContentType(MediaType.APPLICATION_JSON_UTF8_VALUE);

			PrintWriter out = response.getWriter();

			HashMap<String, Object> body = new HashMap<>(4);
			body.put("code", 403);
			body.put("msg", "用户信息异常");
			
			out.print(body);
		}

	}

	@Override
	protected boolean shouldNotFilter(HttpServletRequest request) throws ServletException {

		/*String path = request.getServletPath();

		boolean isReleaseURI = false;

		for(String rURI : RELEASE_URI){
			isReleaseURI = antPathMatcher.match(rURI, path);
			if(isReleaseURI){
				break;
			}
		}

		return isReleaseURI;*/
		return false;
	}

}
