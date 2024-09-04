<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<div class="navbar bg-base-300">
    <div class="navbar-start dropdown dropdown-hover">
        <div tabindex="0" role="button" class="btn m-1">Departamentos</div>
        <ul tabindex="0" class="dropdown-content menu bg-base-100 rounded-box z-[1] w-52 p-2 shadow">
            <c:choose>
                <c:when test="${fn:length(departamentos) > 0}">
                    <c:forEach var="item" items="${departamentos}" varStatus="index">
                        <li><a href="${pageContext.request.contextPath}/departamentos/${item.id}">item.name</a></li>
                    </c:forEach>
                </c:when>
                <c:otherwise>
                    <li><a>Nenhum departamento registrado no momento.</a></li>
                </c:otherwise>
            </c:choose>
        </ul>
    </div>
    <div class="navbar-center">
        <a href="home" class="btn btn-ghost text-xl">E-fisp</a>
    </div>
    <div class="navbar-end flex items-center gap-2">
        <form action="home" method="get" class="input input-bordered flex items-center gap-2 min-w-28 m-0">
            <input type="text" name="search" placeholder="Pesquisar" class="grow" />
            <svg xmlns="http://www.w3.org/2000/svg" viewBox="0 0 16 16" fill="currentColor" class="h-4 w-4 opacity-70">
                <path fill-rule="evenodd"
                      d="M9.965 11.026a5 5 0 1 1 1.06-1.06l2.755 2.754a.75.75 0 1 1-1.06 1.06l-2.755-2.754ZM10.5 7a3.5 3.5 0 1 1-7 0 3.5 3.5 0 0 1 7 0Z"
                      clip-rule="evenodd" />
            </svg>
        </form>
        <div class="dropdown dropdown-end">
            <div tabindex="0" role="button" class="btn btn-ghost btn-circle">
                <div class="indicator">
                    <svg xmlns="http://www.w3.org/2000/svg" class="h-5 w-5" fill="none" viewBox="0 0 24 24"
                         stroke="currentColor">
                        <path stroke-linecap="round" stroke-linejoin="round" stroke-width="2"
                              d="M3 3h2l.4 2M7 13h10l4-8H5.4M7 13L5.4 5M7 13l-2.293 2.293c-.63.63-.184 1.707.707 1.707H17m0 0a2 2 0 100 4 2 2 0 000-4zm-8 2a2 2 0 11-4 0 2 2 0 014 0z" />
                    </svg>
                    <span class="badge badge-sm indicator-item">8</span>
                </div>
            </div>
            <div tabindex="0" class="card card-compact dropdown-content bg-base-200 z-[1] mt-3 w-52 shadow">
                <div class="card-body">
                    <span class="text-lg font-bold">${cart.quantity} itens</span>
                    <span class="text-info">Subtotal: R$ ${cart.subtotal}</span>
                    <div class="card-actions">
                        <a href="cart" class="btn btn-primary btn-block">Ver carrinho</a>
                    </div>
                </div>
            </div>
        </div>
        <div class="dropdown dropdown-end">
            <div tabindex="0" role="button" class="btn btn-ghost btn-circle avatar placeholder">
                <div class="bg-neutral text-neutral-content w-12 rounded-full">
                    <span class="text-xl">${fn:toUpperCase(fn:substring(user.username, 0, 1))}</span>
                </div>
            </div>
            <ul tabindex="0" class="menu menu-sm dropdown-content bg-base-200 rounded-box z-[1] mt-3 w-52 p-2 shadow">
                <li><a href="${pageContext.request.contextPath}/profile" class="justify-between">Perfil</a></li>
                <li><a href="${pageContext.request.contextPath}/history">Histórico</a></li>
                <li><a href="${pageContext.request.contextPath}/login">Sair</a></li>
            </ul>
        </div>
    </div>
</div>