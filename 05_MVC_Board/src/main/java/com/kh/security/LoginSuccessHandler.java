package com.kh.security;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

import com.kh.mvc.model.vo.Member;

public class LoginSuccessHandler implements AuthenticationSuccessHandler
{

	@Override
	public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
			Authentication authentication) throws IOException, ServletException
	{
		
		HttpSession session = request.getSession();
//		UserDetails userD = (UserDetails)
		
		List<String> roleList = new ArrayList<>();
		// TODO Auto-generated method stub
		authentication.getAuthorities().forEach(auth -> {
			System.out.println("auth : " + auth);
			// auth : ROLE_MEMBER
			// auth : ROLE_ADMIN
			roleList.add(auth.getAuthority());
		});
		
		
		if(authentication.getPrincipal() instanceof Member)
		{
			Member member = (Member)authentication.getPrincipal();
			session.setAttribute("userInfo", member);
		}
		
		
		try
		{
			if (roleList.contains("ROLE_MEMBER"))
			{
				
				response.sendRedirect("/board/list");
				return;
			}
			if (roleList.contains("ROLE_ADMIN"))
			{
				response.sendRedirect("/user/admin");
				return;
			}
			
			response.sendRedirect("/user/login");
		}
		catch (IOException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
