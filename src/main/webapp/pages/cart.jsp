<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ taglib prefix="fn" uri="jakarta.tags.functions" %>
<%@ taglib prefix="fmt" uri="jakarta.tags.fmt" %>
<html lang="pt-br">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">

    <link href="https://cdn.jsdelivr.net/npm/daisyui@4.12.10/dist/full.min.css" rel="stylesheet" type="text/css" />

    <title>Carrinho - Efisp</title>
</head>
<body>
    <jsp:include page="../components/navbar.jsp"/>

    <main class="m-4 sm:m-8 sm:mx-auto max-w-4xl p-4 sm:p-8">
        <div class="breadcrumbs text-sm">
            <ul>
                <li><a href="${pageContext.request.contextPath}/home">Home</a></li>
                <li>Carrinho</li>
            </ul>
        </div>
        <h1 class="text-2xl sm:text-3xl font-bold mb-4">Carrinho</h1>
        <div class="divider mb-6"></div>
        <div>
            <ul class="space-y-4">
                <li
                        class="flex flex-col sm:flex-row justify-between items-center p-4 hover:bg-base-300 border rounded-md border-hidden">
                    <div class="flex flex-col items-center sm:items-start w-full sm:w-auto mb-4 sm:mb-0">
                        <img
                                src="https://www.kabum.com.br/_next/image?url=https%3A%2F%2Fimages.kabum.com.br%2Fprodutos%2Ffotos%2F522531%2Fplaca-de-video-rtx-4060-asus-dual-o8g-evo-nvidia-geforce-8gb-gddr6-g-sync-ray-tracing-90yv0jc7-m0na00_1711036187_g.jpg&w=640&q=100"
                                alt="Produto" class="w-20 h-20 object-cover rounded-md mb-4 sm:mb-0">
                        <div class="text-center sm:text-left">
                            <h2 class="text-lg font-semibold">Placa de vídeo RTX 4060 ASUS</h2>
                            <p class="text-gray-400">R$ 50,00</p>
                        </div>
                    </div>
                    <div class="flex flex-col sm:flex-row items-center w-full sm:w-auto space-y-2 sm:space-y-0 sm:space-x-4">
                        <select name="quantity" id="quantity-1" class="input input-bordered w-24">
                            <option value="1">1</option>
                            <option value="2">2</option>
                            <option value="3">3</option>
                            <option value="4">4</option>
                            <option value="5">5</option>
                        </select>
                        <form action="remove-item" method="post">
                            <input type="hidden" name="item-id" value="item1-id">
                            <button type="submit" class="btn btn btn-sm btn-ghost text-red-600">Remover</button>
                        </form>
                    </div>
                </li>
                <li
                        class="flex flex-col sm:flex-row justify-between items-center p-4 hover:bg-base-300 border rounded-md border-hidden">
                    <div class="flex flex-col items-center sm:items-start w-full sm:w-auto mb-4 sm:mb-0">
                        <img
                                src="https://www.kabum.com.br/_next/image?url=https%3A%2F%2Fimages.kabum.com.br%2Fprodutos%2Ffotos%2F522531%2Fplaca-de-video-rtx-4060-asus-dual-o8g-evo-nvidia-geforce-8gb-gddr6-g-sync-ray-tracing-90yv0jc7-m0na00_1711036187_g.jpg&w=640&q=100"
                                alt="Produto" class="w-20 h-20 object-cover rounded-md mb-4 sm:mb-0">
                        <div class="text-center sm:text-left">
                            <h2 class="text-lg font-semibold">Placa de vídeo RTX 4060 ASUS</h2>
                            <p class="text-gray-400">R$ 50,00</p>
                        </div>
                    </div>
                    <div class="flex flex-col sm:flex-row items-center w-full sm:w-auto space-y-2 sm:space-y-0 sm:space-x-4">
                        <select name="quantity" id="quantity-1" class="input input-bordered w-24">
                            <option value="1">1</option>
                            <option value="2">2</option>
                            <option value="3">3</option>
                            <option value="4">4</option>
                            <option value="5">5</option>
                        </select>
                        <form action="remove-item" method="post">
                            <input type="hidden" name="item-id" value="item1-id">
                            <button type="submit" class="btn btn btn-sm btn-ghost text-red-600">Remover</button>
                        </form>
                    </div>
                </li>
            </ul>
        </div>

        <div class="mt-8">
            <div class="divider mb-6"></div>
            <form action="cart" method="post" class="space-y-4">
                <h2 class="text-xl font-semibold">Detalhes do pedido</h2>
                <div class="flex justify-between">
                    <p>Subtotal</p>
                    <p>R$ 99,90</p>
                </div>
                <div class="flex justify-between">
                    <p>Frete</p>
                    <p>R$ 10,00</p>
                </div>
                <div class="flex justify-between font-bold text-xl">
                    <p>Pedido total:</p>
                    <p>R$ 109,90</p>
                </div>

                <button type="submit" class="btn btn-primary w-full">Fechar Pedido</button>
            </form>
        </div>
    </main>

    <jsp:include page="../components/footer.jsp"/>

<script src="https://cdn.tailwindcss.com"></script>
</body>

</html>