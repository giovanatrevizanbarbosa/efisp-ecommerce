<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="pt-br">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">

    <link href="https://cdn.jsdelivr.net/npm/daisyui@4.12.10/dist/full.min.css" rel="stylesheet" type="text/css" />

    <title>Cadastro - E-fisp</title>
</head>
<body>
    <main class="hero bg-base-200 min-h-screen">
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
                    </div>
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
                    </div>
                    <div class="form-control">
                        <label class="label">
                            <span class="label-text">Confirmação de Senha</span>
                        </label>
                        <input type="password" name="confirm-password" placeholder="confirme sua senha" class="input input-bordered"
                               required />
                    </div>
                    <div class="form-control mt-6 space-y-2">
                        <button type="submit" class="btn btn-primary">Cadastrar</button>
                        <a href="${pageContext.request.contextPath}/login" class="btn btn-outline btn-info">Já tenho uma conta</a>
                    </div>
                </form>
            </div>
        </div>
    </main>

    <script src="https://cdn.tailwindcss.com"></script>
</body>
</html>
