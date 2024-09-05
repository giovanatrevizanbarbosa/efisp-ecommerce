<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ taglib prefix="fn" uri="jakarta.tags.functions" %>
<%@ taglib prefix="fmt" uri="jakarta.tags.fmt" %>
<html lang="pt-br">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>${product.name()} - Efisp</title>
    <link href="https://cdn.jsdelivr.net/npm/daisyui@4.12.10/dist/full.min.css" rel="stylesheet" type="text/css" />
    <link href="${pageContext.request.contextPath}/images/logo.png" rel="icon" type="image/x-icon">
</head>
<body>
    <jsp:include page="../components/navbar.jsp"/>

    <main class="container mx-auto p-6 md:p-12">
        <div class="flex flex-col md:flex-row gap-12">
            <div class="w-full md:w-1/2">
                <img class="rounded-lg w-full object-cover"
                     src="${product.photo()}"
                     alt="Placa de vídeo RTX 4060 ASUS">
            </div>

            <div class="w-full md:w-1/2">
                <h1 class="text-4xl font-bold mb-4 text-gray-200">${product.name()}</h1>
                <p class="text-gray-400 mb-6">${product.description()}</p>

                <div class="flex flex-col gap-4">
                    <span class="text-2xl font-bold text-secondary">${String.format('R$ %.2f', product.price())}</span>
                    <span class="text-sm text-gray-400">À vista no Pix e Boleto</span>
                </div>

                <c:if test="${admin == null}">
                    <div class="mt-8">
                        <input type="hidden" name="product-id" value="product-id">
                        <a href="${pageContext.request.contextPath}/add-item?id=${product.id()}"
                           class="btn btn-primary w-full">Adicionar ao Carrinho</a>
                    </div>
                </c:if>

                <div class="mt-12">
                    <h2 class="text-2xl font-semibold mb-4">Especificações do Produto</h2>
                    <ul class="list-disc pl-5 space-y-2">
                        <li>Marca: ${product.brand()}</li>
                        <li>Em estoque: ${product.stock()}</li>
                    </ul>
                </div>
            </div>
        </div>
    </main>
    <script src="https://cdn.tailwindcss.com"></script>
</body>
</html>
