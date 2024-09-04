<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ taglib prefix="fn" uri="jakarta.tags.functions" %>
<%@ taglib prefix="fmt" uri="jakarta.tags.fmt" %>
<html lang="pt-br">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>${product.name} - Efisp</title>
    <link href="https://cdn.jsdelivr.net/npm/daisyui@4.12.10/dist/full.min.css" rel="stylesheet" type="text/css" />
</head>
<body>
    <jsp:include page="../components/navbar.jsp"/>

    <main class="container mx-auto p-6 md:p-12">
        <div class="flex flex-col md:flex-row gap-12">
            <div class="w-full md:w-1/2">
                <img class="rounded-lg w-full object-cover"
                     src="https://www.kabum.com.br/_next/image?url=https%3A%2F%2Fimages.kabum.com.br%2Fprodutos%2Ffotos%2F522531%2Fplaca-de-video-rtx-4060-asus-dual-o8g-evo-nvidia-geforce-8gb-gddr6-g-sync-ray-tracing-90yv0jc7-m0na00_1711036187_g.jpg&w=640&q=100"
                     alt="Placa de vídeo RTX 4060 ASUS">
            </div>

            <div class="w-full md:w-1/2">
                <h1 class="text-4xl font-bold mb-4 text-gray-200">Placa de vídeo RTX 4060 ASUS Dual 8G EVO OC NVIDIA GeForce, 8GB GDDR6,
                    G-SYNC, RayTracing - 90YV0JC7-M0NA00</h1>
                <p class="text-gray-400 mb-6">A placa de vídeo RTX 4060 ASUS oferece desempenho avançado para gamers e criadores
                    de conteúdo, com suporte para Ray Tracing, G-SYNC e muito mais.</p>

                <div class="flex flex-col gap-4">
                    <span class="text-2xl font-bold text-secondary">R$ 2.099,99</span>
                    <span class="text-sm text-gray-400">À vista no Pix e Boleto</span>
                </div>

                <div class="mt-8">
                    <form action="product-details" method="post">
                        <input type="hidden" name="product-id" value="product-id">
                        <button type="submit" class="btn btn-primary w-full">Adicionar ao Carrinho</button>
                    </form>
                </div>

                <div class="mt-12">
                    <h2 class="text-2xl font-semibold mb-4">Especificações do Produto</h2>
                    <ul class="list-disc pl-5 space-y-2">
                        <li>Memória: 8GB GDDR6</li>
                        <li>Interface de Memória: 128-bit</li>
                        <li>Conectores de Energia: 1 x 8-pin</li>
                        <li>Saídas de Vídeo: 3 x DisplayPort, 1 x HDMI</li>
                        <li>Resfriamento: Ventoinha dupla</li>
                        <li>Compatível com G-SYNC e Ray Tracing</li>
                    </ul>
                </div>
            </div>
        </div>
    </main>
    <script src="https://cdn.tailwindcss.com"></script>
</body>
</html>
