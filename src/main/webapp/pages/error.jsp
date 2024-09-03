<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="pt-br">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">

    <link href="https://cdn.jsdelivr.net/npm/daisyui@4.12.10/dist/full.min.css" rel="stylesheet" type="text/css" />

    <title>Error 404 - Efisp</title>
</head>
<body>
<main class="grid min-h-full place-items-center px-6 py-24 sm:py-32 lg:px-8">
    <div class="text-center">
        <p class="text-4xl text-primary">404</p>
        <h1 class="mt-4 text-3xl font-bold tracking-tight text-gray-200 sm:text-5xl">Página não encontrada</h1>
        <p class="mt-6 text-base leading-7 text-gray-400">Oops, não conseguimos encontrar a página que procura.</p>
        <div class="mt-10 flex items-center justify-center gap-x-6">
            <a href="${pageContext.request.contextPath}/home" class="btn btn-primary">Voltar para Home</a>
            <a href="${pageContext.request.contextPath}/login" class="btn btn-outline btn-info">Login <span>&rarr;</span></a>
        </div>
    </div>
</main>

<script src="https://cdn.tailwindcss.com"></script>
</body>
</html>