<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ taglib prefix="fn" uri="jakarta.tags.functions" %>
<%@ taglib prefix="fmt" uri="jakarta.tags.fmt" %>
<html lang="pt-br">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">

    <link href="https://cdn.jsdelivr.net/npm/daisyui@4.12.10/dist/full.min.css" rel="stylesheet" type="text/css" />
    <link href="${pageContext.request.contextPath}/images/logo.png" rel="icon" type="image/x-icon">
    <title>Carrinho - Efisp</title>
</head>
<body>
    <jsp:include page="../components/navbar.jsp"/>

    <main class="m-4 sm:m-8 sm:mx-auto max-w-4xl p-4 sm:p-8">
        <div class="breadcrumbs text-sm">
            <ul>
                <li><a href="home">Home</a></li>
                <li>Carrinho</li>
            </ul>
        </div>
        <h1 class="text-2xl sm:text-3xl font-bold mb-4">Carrinho</h1>
        <div class="divider mb-6"></div>
        <div>
            <ul class="space-y-4">
                <c:forEach var="cartItem" items="${cartItems}" varStatus="index">
                    <li
                            class="flex flex-col sm:flex-row justify-between items-center p-4 hover:bg-base-300 border rounded-md border-hidden">
                        <div class="flex flex-col items-center sm:items-start w-full sm:w-auto mb-4 sm:mb-0">
                            <img src="${cartItem.productDTO().photo()}"
                                    alt="Produto" class="w-20 h-20 object-cover rounded-md mb-4 sm:mb-0">
                            <div class="text-center sm:text-left">
                                <h2 class="text-lg font-semibold">${cartItem.productDTO().name()}</h2>
                                <p class="text-gray-400">R$ ${cartItem.productDTO().price()}</p>
                            </div>
                        </div>
                        <div class="flex flex-col sm:flex-row items-center w-full sm:w-auto space-y-2 sm:space-y-0 sm:space-x-4">
                            <form action="remove-item" method="post">
                                <input type="hidden" name="itemId" value="${cartItem.id()}">
                                <button type="submit" class="btn btn btn-sm btn-ghost text-red-600">Remover</button>
                            </form>
                        </div>
                    </li>
                </c:forEach>
            </ul>
        </div>

        <div class="mt-8">
            <div class="divider mb-6"></div>
            <form action="checkout" method="get" class="space-y-4">
                <h2 class="text-xl font-semibold">Detalhes do pedido</h2>
                <div class="flex justify-between">
                    <p>Subtotal</p>
                    <p>R$ ${subtotal}</p>
                </div>
                <div class="flex justify-between">
                    <p>Frete</p>
                    <p>R$ ${shipping}</p>
                </div>
                <div class="flex justify-between font-bold text-xl">
                    <p>Pedido total:</p>
                    <p>R$ ${total}</p>
                </div>

                <c:choose>
                    <c:when test="${fn:length(cartItems) > 0}">
                        <input type="hidden" name="cartItems" value="${cartItems}">
                        <button type="submit" class="btn btn-primary w-full">Fechar Pedido</button>
                    </c:when>
                    <c:otherwise>
                        <div class="flex flex-col items-center justify-center">
                            <p class="text-center text-xl mt-8">Seu carrinho ainda está vazio. Adicione mais itens nele!</p>
                        </div>
                    </c:otherwise>
                </c:choose>
            </form>
        </div>
    </main>
<script src="https://cdn.tailwindcss.com"></script>
</body>

</html>