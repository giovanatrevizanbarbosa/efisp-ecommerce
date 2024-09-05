<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ taglib prefix="fn" uri="jakarta.tags.functions" %>
<%@ taglib prefix="fmt" uri="jakarta.tags.fmt" %>

<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">

    <link href="https://cdn.jsdelivr.net/npm/daisyui@4.12.10/dist/full.min.css" rel="stylesheet" type="text/css" />
    <title>Home - E-fisp</title>
</head>
<body>
    <jsp:include page="../components/navbar.jsp"/>
    <main>
        <h1 class="text-3xl font-bold my-12 text-center">Produtos em Destaque</h1>
        <c:choose>
            <c:when test="${fn:length(products) > 0}">
                 <div class="flex flex-wrap justify-center gap-8">
                    <c:forEach var="product" items="${products}" varStatus="index">
                        <section class="card card-compact bg-base-200 w-80 shadow-xl">
                            <a href="${pageContext.request.contextPath}/product-details">
                                <figure>
                                    <img class="rounded-t-lg w-full object-cover"
                                         src="${product.photo()}"
                                         alt="${product.name()}" />
                                </figure>
                                <div class="card-body">
                                    <h2 class="card-title line-clamp-2">${product.name()}</h2>
                                    <div class="card-actions flex justify-between items-center mt-4">
                                        <span class="text-xl font-semibold text-secondary">${product.price()}</span>
                                        <c:if test="${admin == null}">
                                        <a href="${pageContext.request.contextPath}/add-item?id=${product.id()}"
                                           class="btn btn-primary">Adicionar no carrinho</a>
                                        </c:if>
                                    </div>
                                </div>
                            </a>
                        </section>
                    </c:forEach>
                 </div>
            </c:when>
            <c:otherwise>
                    <div class="flex flex-col items-center justify-center h-5/6">
                        <img class="w-64" alt="Resources not found" src="${pageContext.request.contextPath}/images/no-results.png">
                        <p class="text-center text-xl mt-8">Erro ao buscar produtos.</p>
                    </div>
            </c:otherwise>
        </c:choose>
        </div>
    </main>
    <script src="https://cdn.tailwindcss.com"></script>
</body>
</html>
