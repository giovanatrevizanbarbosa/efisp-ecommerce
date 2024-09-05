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
    <title>Cadastro - E-fisp</title>
</head>
<body>
    <main class="hero bg-base-200 min-h-screen">
        <c:if test="${result == 'notRegistered'}">
            <div role="alert" class="alert alert-error fixed top-4 left-1/2 transform -translate-x-1/2 w-fit z-50 mb-40">
                <span>Não foi possível cadastrar o usuário. Verifique os dados e tente novamente.</span>
                <div>
                    <button class="btn btn-ghost message-alert-button">
                        <svg xmlns="http://www.w3.org/2000/svg" fill="none" viewBox="0 0 24 24" stroke-width="1.5" stroke="currentColor" class="size-6">
                            <path stroke-linecap="round" stroke-linejoin="round" d="m9.75 9.75 4.5 4.5m0-4.5-4.5 4.5M21 12a9 9 0 1 1-18 0 9 9 0 0 1 18 0Z" />
                        </svg>
                    </button>
                </div>
            </div>
        </c:if>
        <div class="hero-content flex-col lg:flex-row">
            <div class="text-center lg:text-left max-w-3xl">
                <h1 class="text-5xl font-bold">Crie sua conta no Efisp</h1>
                <p class="py-6 mx-12 lg:m-0">
                    Complete o formulário para se cadastrar e começar a explorar
                    nossos produtos. Se já tem uma conta, você pode
                    <a href="${pageContext.request.contextPath}/login" class="link link-primary">fazer login aqui</a>.
                </p>
            </div>
            <div class="card bg-base-100 w-full max-w-sm shrink-0 shadow-2xl">
                <form action="register" method="post" class="card-body">
                    <div class="form-control">
                        <label class="label">
                            <span class="label-text">Nome</span>
                        </label>
                        <input type="text" name="name" placeholder="nome" class="input input-bordered" required />
                        <span id="error-name" class="text-error hidden"></span>
                    </div>
                    <div class="form-control">
                        <label class="label">
                            <span class="label-text">Email</span>
                        </label>
                        <input type="email" name="email" placeholder="email" class="input input-bordered" required />
                        <span id="error-email" class="text-error hidden"></span>
                    </div>
                    <div class="form-control">
                        <label class="label">
                            <span class="label-text">Senha</span>
                        </label>
                        <input type="password" name="password" placeholder="senha" class="input input-bordered" required />
                        <span id="error-password" class="text-error hidden"></span>
                    </div>
                    <div class="form-control">
                        <label class="label">
                            <span class="label-text">Confirmação de Senha</span>
                        </label>
                        <input type="password" name="confirmPassword" placeholder="confirme sua senha" class="input input-bordered"
                               required />
                        <span id="error-confirmPassword" class="text-error hidden"></span>
                    </div>
                    <div class="form-control mt-6 space-y-2">
                        <button type="submit" class="btn btn-primary">Cadastrar</button>
                        <a href="${pageContext.request.contextPath}/login" class="btn btn-outline btn-info">Já tenho uma conta</a>
                    </div>
                </form>
            </div>
        </div>
    </main>

    <script defer src="./scripts/timeAlert.js"></script>
    <script defer src="./scripts/validateUserRegister.js"></script>
    <script src="https://cdn.tailwindcss.com"></script>
</body>
</html>
