<%@page import="java.time.LocalDate"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ taglib prefix="fn" uri="jakarta.tags.fmt" %>
<footer class="footer footer-center bg-base-300 text-base-content p-4 absolute bottom-0">
    <aside>
        <p>Copyright © ${LocalDate.now().year} - All rights reserved by E-Fisp</p>
    </aside>
</footer>