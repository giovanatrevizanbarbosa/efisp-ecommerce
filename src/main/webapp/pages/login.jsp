<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="pt-br">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">

    <link href="https://cdn.jsdelivr.net/npm/daisyui@4.12.10/dist/full.min.css" rel="stylesheet" type="text/css" />

    <title>Login - Efisp</title>
</head>
<body>
    <main class="hero bg-base-200 min-h-screen">
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

    <script src="https://cdn.tailwindcss.com"></script>
</body>
</html>
