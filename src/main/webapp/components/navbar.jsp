<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<div class="navbar bg-base-300">
    <div class="navbar-start">
        <a href="home" class="btn btn-ghost text-xl">E-fisp</a>
    </div>
    <c:if test="${fn:contains(pageContext.request.requestURI, '/pages/home.jsp') && admin == null}">
        <div class="navbar-center dropdown dropdown-hover">
            <div tabindex="0" role="button" class="btn m-1">Departamentos</div>
            <ul tabindex="0" class="dropdown-content menu bg-base-100 rounded-box z-[1] w-52 p-2 shadow">
                <c:choose>
                    <c:when test="${fn:length(departments) > 0}">
                        <c:forEach var="department" items="${departments}" varStatus="index">
                            <li><a href="${pageContext.request.contextPath}/home?department=${department.name()}">${department.name()}</a></li>
                        </c:forEach>
                    </c:when>
                    <c:otherwise>
                        <li><a>Nenhum departamento registrado no momento.</a></li>
                    </c:otherwise>
                </c:choose>
            </ul>
        </div>
    </c:if>

    <c:if test="${admin != null}">
        <div class="navbar-center gap-5">
            <a href="add-product" class="btn btn-primary">Adicionar Produto</a>
            <a href="add-department" class="btn btn-primary">Adicionar Departamento</a>
            <a href="add-brand" class="btn btn-primary">Adicionar Marca</a>
            <a href="add-title" class="btn btn-primary">Adicionar Cargo</a>
            <a href="add-adm" class="btn btn-primary">Adicionar Admin</a>
        </div>
    </c:if>

    <div class="navbar-end flex items-center gap-2">
        <form action="home" method="get" class="input input-bordered flex items-center gap-2 min-w-28 m-0">
            <input type="text" name="search" placeholder="Pesquisar" class="grow" value="${search}"/>
            <svg xmlns="http://www.w3.org/2000/svg" viewBox="0 0 16 16" fill="currentColor" class="h-4 w-4 opacity-70">
                <path fill-rule="evenodd"
                      d="M9.965 11.026a5 5 0 1 1 1.06-1.06l2.755 2.754a.75.75 0 1 1-1.06 1.06l-2.755-2.754ZM10.5 7a3.5 3.5 0 1 1-7 0 3.5 3.5 0 0 1 7 0Z"
                      clip-rule="evenodd" />
            </svg>
        </form>
        <c:if test="${admin == null}">
            <div class="dropdown dropdown-end">
                <div tabindex="0" role="button" class="btn btn-ghost btn-circle">
                    <div class="indicator">
                        <svg xmlns="http://www.w3.org/2000/svg" class="h-5 w-5" fill="none" viewBox="0 0 24 24"
                             stroke="currentColor">
                            <path stroke-linecap="round" stroke-linejoin="round" stroke-width="2"
                                  d="M3 3h2l.4 2M7 13h10l4-8H5.4M7 13L5.4 5M7 13l-2.293 2.293c-.63.63-.184 1.707.707 1.707H17m0 0a2 2 0 100 4 2 2 0 000-4zm-8 2a2 2 0 11-4 0 2 2 0 014 0z"></path>
                        </svg>
                        <c:if test="${admin == null}">
                            <c:choose>
                                <c:when test="${not empty cart.totalItems()}">
                                    <span class="badge badge-sm indicator-item">${cart.totalItems()}</span>
                                </c:when>
                                <c:otherwise>
                                    <span class="badge badge-sm indicator-item">0</span>
                                </c:otherwise>
                            </c:choose>
                        </c:if>
                    </div>
                </div>
                <div tabindex="0" class="card card-compact dropdown-content bg-base-200 z-[1] mt-3 w-52 shadow">
                    <div class="card-body">
                        <c:choose>
                            <c:when test="${not empty cart.totalItems()}">
                                <span class="text-lg font-bold">${cart.totalItems()} itens</span>
                                <span class="text-info">Subtotal: ${String.format('R$ %.2f', cart.totalPrice())}</span>
                            </c:when>
                            <c:otherwise>
                                <span class="text-lg font-bold">Ainda não há itens</span>
                                <span class="text-info">Subtotal: R$ 0</span>
                            </c:otherwise>
                        </c:choose>

                        <div class="card-actions">
                            <a href="cart" class="btn btn-primary btn-block">Ver carrinho</a>
                        </div>
                    </div>
                </div>
            </div>
        </c:if>

        <div class="dropdown dropdown-end">
            <div tabindex="0" role="button" class="btn btn-ghost btn-circle avatar placeholder">
                <div class="bg-neutral text-neutral-content w-12 rounded-full">
                    <span class="text-xl">${fn:toUpperCase(fn:substring(user.name(), 0, 1))}</span>
                </div>
            </div>
            <c:if test="${user == null}">
                <ul tabindex="0" class="menu menu-sm dropdown-content bg-base-200 rounded-box z-[1] mt-3 w-52 p-2 shadow">
                    <li><a href="${pageContext.request.contextPath}/login">Entrar</a></li>
                    <li><a href="${pageContext.request.contextPath}/register">Registrar</a></li>
                </ul>
            </c:if>
            <c:if test="${user != null}">
                <ul tabindex="0" class="menu menu-sm dropdown-content bg-base-200 rounded-box z-[1] mt-3 w-52 p-2 shadow">
                    <li><a href="${pageContext.request.contextPath}/profile" class="justify-between">Perfil</a></li>
                    <li><a href="${pageContext.request.contextPath}/logout">Sair</a></li>
                </ul>
            </c:if>

        </div>
    </div>
</div>