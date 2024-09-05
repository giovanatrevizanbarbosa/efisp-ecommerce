package efisp.efispecommerce.servlets.filters;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebFilter(urlPatterns = {"/add-adm", "/add-product", "/add-brand", "/add-title", "/add-department"},
        filterName = "AdminAuthorization")
public class AdminValidationFilter implements Filter {
        @Override
        public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
            HttpServletRequest httpRequest = (HttpServletRequest) request;
            HttpSession session = httpRequest.getSession(false);

            if(session == null || session.getAttribute("admin") == null ) {
                HttpServletResponse httpResponse = (HttpServletResponse)response;
                httpResponse.sendRedirect(httpRequest.getContextPath() + "/login");
            } else {
                chain.doFilter(request, response);
            }
        }
}