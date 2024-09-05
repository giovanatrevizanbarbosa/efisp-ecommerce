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
    <title>Login - E-fisp</title>
</head>
<body>
    <main class="hero bg-base-200 min-h-screen">
        <c:choose>
            <c:when test="${result == 'loginError'}">
                <div role="alert" class="alert alert-error fixed top-4 left-1/2 transform -translate-x-1/2 w-fit z-50 mb-40">
                    <span>Não foi possível efetuar login! Verifique os dados e tente novamente.</span>
                    <div>
                        <button class="btn btn-ghost message-alert-button">
                            <svg xmlns="http://www.w3.org/2000/svg" fill="none" viewBox="0 0 24 24" stroke-width="1.5" stroke="currentColor" class="size-6">
                                <path stroke-linecap="round" stroke-linejoin="round" d="m9.75 9.75 4.5 4.5m0-4.5-4.5 4.5M21 12a9 9 0 1 1-18 0 9 9 0 0 1 18 0Z" />
                            </svg>
                        </button>
                    </div>
                </div>
            </c:when>
            <c:when test="${result == 'registered'}">
                <div role="alert" class="alert alert-success fixed top-4 left-1/2 transform -translate-x-1/2 w-fit z-50 mb-40">
                    <span>Usuário cadastrado com sucesso! Efetue login para acessar ao site.</span>
                    <div>
                        <button class="btn btn-ghost message-alert-button">
                            <svg xmlns="http://www.w3.org/2000/svg" fill="none" viewBox="0 0 24 24" stroke-width="1.5" stroke="currentColor" class="size-6">
                                <path stroke-linecap="round" stroke-linejoin="round" d="M9 12.75 11.25 15 15 9.75M21 12a9 9 0 1 1-18 0 9 9 0 0 1 18 0Z" />
                            </svg>
                        </button>
                    </div>
                </div>
            </c:when>
        </c:choose>

        <div class="hero-content flex-col lg:flex-row-reverse">
            <div class="text-center lg:text-left max-w-3xl">
                <h1 class="text-5xl font-bold">Acesso ao Efisp</h1>
                <p class="py-6 mx-12 lg:m-0">
                    <strong>Bem-vindo ao E-fisp</strong>! Navegue pelos nossos produtos, adicione ao carrinho e finalize suas compras. E não se preocupe com o nome, é
                    só uma zoeira com o "IFISP" que sabemos que não existe! 😇
                </p>
            </div>
            <div class="card bg-base-100 w-full max-w-sm shrink-0 shadow-2xl">
                <form action="login" method="post" class="card-body">
                    <div class="form-control">
                        <label class="label">
                            <span class="label-text">Email</span>
                        </label>
                        <input type="email" name="email" placeholder="email" class="input input-bordered" required />
                    </div>
                    <div class="form-control">
                        <label class="label">
                            <span class="label-text">Senha</span>
                        </label>
                        <input type="password" name="password" placeholder="senha" class="input input-bordered" required />
                        <label class="label">
                            <a href="#" class="label-text-alt link link-hover">Esqueceu a senha?</a>
                        </label>
                    </div>
                    <div class="form-control mt-6 space-y-2">
                        <button type="submit" class="btn btn-primary">Entrar</button>
                        <a href="${pageContext.request.contextPath}/register" class="btn btn-outline btn-info">Cadastrar</a>
                    </div>
                </form>
            </div>
        </div>
    </main>

    <script defer src="./scripts/timeAlert.js"></script>
    <script defer src="./scripts/validateUserLogin.js"></script>
    <script src="https://cdn.tailwindcss.com"></script>
</body>
</html>
