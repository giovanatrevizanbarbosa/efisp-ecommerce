<%--
  Created by IntelliJ IDEA.
  User: Windows
  Date: 28/08/2024
  Time: 17:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ taglib prefix="fn" uri="jakarta.tags.functions" %>
<%@ taglib prefix="fmt" uri="jakarta.tags.fmt" %>
<html lang="pt-br">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link href="https://cdn.jsdelivr.net/npm/daisyui@4.12.10/dist/full.min.css" rel="stylesheet" type="text/css" />
    <title>Checkout - E-fisp</title>
</head>
<body>
    <jsp:include page="../components/navbar.jsp"/>

    <main class="m-12 max-w-4xl mx-auto p-8">
        <div class="breadcrumbs text-sm">
            <ul>
                <li><a href="${pageContext.request.contextPath}/home">Home</a></li>
                <li><a href="${pageContext.request.contextPath}/cart">Carrinho</a></li>
                <li>Checkout</li>
            </ul>
        </div>
        <h1 class="text-3xl font-bold mb-4">Detalhes do Pedido</h1>
        <div class="divider mb-6"></div>

        <form action="checkout" method="post" class="space-y-6">
            <section class="bg-base-200 p-6 rounded-lg shadow-md">
                <h2 class="text-xl font-semibold mb-4">1. Endereço de Entrega</h2>
                <div class="space-y-4">
                    <div class="form-control">
                        <label class="label">
                            <span class="label-text">Nome do Destinatário</span>
                        </label>
                        <input type="text" name="full-name" class="input input-bordered w-full" placeholder="Nome" required />
                    </div>
                    <div class="form-control">
                        <label class="label">
                            <span class="label-text">Endereço</span>
                        </label>
                        <input type="text" name="address" class="input input-bordered w-full" placeholder="Endereço" required />
                    </div>
                    <div class="form-control">
                        <label class="label">
                            <span class="label-text">Cidade</span>
                        </label>
                        <input type="text" name="city" class="input input-bordered w-full" placeholder="Cidade" required />
                    </div>
                    <div class="form-control">
                        <label class="label">
                            <span class="label-text">CEP</span>
                        </label>
                        <input type="text" name="zipcode" class="input input-bordered w-full" placeholder="CEP" required />
                    </div>
                </div>
            </section>

            <section class="bg-base-200 p-6 rounded-lg shadow-md">
                <h2 class="text-xl font-semibold mb-4">2. Método de Pagamento</h2>
                <div class="form-control">
                    <label class="label">
                        <span class="label-text">Selecione um método de pagamento</span>
                    </label>
                    <select name="payment-method" class="select select-bordered w-full" required>
                        <option value="credit-card">Cartão de Crédito</option>
                        <option value="debit-card">Cartão de Débito</option>
                        <option value="boleto">Boleto Bancário</option>
                        <option value="pix" selected>PIX</option>
                    </select>
                </div>
            </section>

            <section class="bg-base-200 p-6 rounded-lg shadow-md">
                <h2 class="text-xl font-semibold mb-4">3. Revisar Itens</h2>
                <ul class="space-y-4">
                    <li class="flex justify-between items-center">
                        <div class="flex items-center space-x-4">
                            <img
                                    src="https://www.kabum.com.br/_next/image?url=https%3A%2F%2Fimages.kabum.com.br%2Fprodutos%2Ffotos%2F522531%2Fplaca-de-video-rtx-4060-asus-dual-o8g-evo-nvidia-geforce-8gb-gddr6-g-sync-ray-tracing-90yv0jc7-m0na00_1711036187_g.jpg&w=640&q=100"
                                    alt="Produto" class="w-20 h-20 object-cover rounded-md">
                            <div>
                                <h2 class="text-lg font-semibold">Placa de vídeo RTX 4060 ASUS</h2>
                                <p class="text-gray-400">R$ 50,00</p>
                            </div>
                        </div>
                        <p>2 unidade(s)</p>
                    </li>
                    <li class="flex justify-between items-center">
                        <div class="flex items-center space-x-4">
                            <img
                                    src="https://www.kabum.com.br/_next/image?url=https%3A%2F%2Fimages.kabum.com.br%2Fprodutos%2Ffotos%2F522531%2Fplaca-de-video-rtx-4060-asus-dual-o8g-evo-nvidia-geforce-8gb-gddr6-g-sync-ray-tracing-90yv0jc7-m0na00_1711036187_g.jpg&w=640&q=100"
                                    alt="Produto" class="w-20 h-20 object-cover rounded-md">
                            <div>
                                <h2 class="text-lg font-semibold">Placa de vídeo RTX 4060 ASUS</h2>
                                <p class="text-gray-400">R$ 50,00</p>
                            </div>
                        </div>
                        <p>1 unidade(s)</p>
                    </li>
                </ul>

                <div class="divider"></div>

                <div class="space-y-4">
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
                </div>

                <button type="submit" class="btn btn-primary w-full mt-4">Confirmar Pedido</button>
            </section>
        </form>
    </main>
    <script src="https://cdn.tailwindcss.com"></script>
</body>
</html>
