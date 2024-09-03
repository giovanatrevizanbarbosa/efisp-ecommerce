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
    <jsp:include page="./components/navbar.jsp"/>

    <main class="flex flex-col items-center m-8 md:mt-16">
        <h1 class="text-3xl font-bold mb-12">Produtos em Destaque</h1>
        <div class="flex flex-wrap justify-center gap-8">
            <section class="card card-compact bg-base-200 w-80 shadow-xl">
                <a href="${pageContext.request.contextPath}/productDetails?id=${product.id}">
                    <figure>
                        <img class="rounded-t-lg w-full object-cover"
                             src="https://www.kabum.com.br/_next/image?url=https%3A%2F%2Fimages.kabum.com.br%2Fprodutos%2Ffotos%2F522531%2Fplaca-de-video-rtx-4060-asus-dual-o8g-evo-nvidia-geforce-8gb-gddr6-g-sync-ray-tracing-90yv0jc7-m0na00_1711036187_g.jpg&w=640&q=100"
                             alt="${product.name}" />
                    </figure>
                    <div class="card-body">
                        <h2 class="card-title line-clamp-2">Placa de vídeo RTX 4060 ASUS Dual 8G EVO OC NVIDIA GeForce, 8GB GDDR6,
                            G-SYNC, RayTracing - 90YV0JC7-M0NA00</h2>
                        <div class="card-actions flex justify-between items-center mt-4">
                            <span class="text-xl font-semibold text-secondary">R$ 2.099,99</span>
                            <a href="cart" class="btn btn-primary">Adicionar no carrinho</a>
                        </div>
                    </div>
                </a>
            </section>
        </div>
    </main>

    <jsp:include page="./components/footer.jsp"/>

    <script src="https://cdn.tailwindcss.com"></script>
</body>
</html>
