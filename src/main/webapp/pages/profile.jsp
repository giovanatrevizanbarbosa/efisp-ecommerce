<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ taglib prefix="fn" uri="jakarta.tags.functions" %>
<%@ taglib prefix="fmt" uri="jakarta.tags.fmt" %>
<html lang="pt-br">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">

    <link href="https://cdn.jsdelivr.net/npm/daisyui@4.12.10/dist/full.min.css" rel="stylesheet" type="text/css" />

    <title>Perfil - E-fisp</title>
</head>
<body>
    <jsp:include page="../components/navbar.jsp"/>

    <main class="flex flex-col items-center m-8 md:mt-16">
        <h1 class="text-3xl font-bold mb-12">Meu Perfil</h1>

        <div class="card bg-base-100 w-full max-w-lg shadow-xl mb-8">
            <div class="card-body">
                <form action="profile" method="post" class="space-y-6">
                    <div>
                        <h2 class="text-2xl font-semibold mb-4">Informações do Perfil</h2>
                        <div class="form-control mb-4">
                            <label class="label">
                                <span class="label-text">Nome</span>
                            </label>
                            <input type="text" name="name"
                                   class="input flex items-center w-full bg-base-300 pointer-events-none"
                                   value="${user.name()}" required />
                        </div>
                        <div class="form-control mb-4">
                            <label class="label">
                                <span class="label-text">Email</span>
                            </label>
                            <input type="email" name="email" placeholder="Seu email"
                                   class="input flex items-center w-full bg-base-300 pointer-events-none"
                                   value="${user.email()}" required />
                        </div>
                    </div>

                    <button type="button" id="editPasswordBtn"
                            onclick="togglePasswordEdit()"
                            class="btn btn-outline w-full hidden">Alterar Senha</button>

                    <div class="change-password hidden">
                        <h2 class="text-2xl font-semibold mb-4">Alterar Senha</h2>
                        <div class="form-control mb-4">
                            <label class="label">
                                <span class="label-text">Senha Atual</span>
                            </label>
                            <input type="password" name="current-password" placeholder="Senha atual"
                                   class="input flex items-center w-full bg-base-300 pointer-events-none"
                                    />
                        </div>
                        <div class="form-control mb-4">
                            <label class="label">
                                <span class="label-text">Nova Senha</span>
                            </label>
                            <input type="password" name="new-password" placeholder="Nova senha"
                                   class="input flex items-center w-full bg-base-300 pointer-events-none"
                                    />
                        </div>
                        <div class="form-control mb-4">
                            <label class="label">
                                <span class="label-text">Confirmar Nova Senha</span>
                            </label>
                            <input type="password" name="confirm-new-password" placeholder="Confirmar nova senha"
                                   class="input flex items-center w-full bg-base-300 pointer-events-none"  />
                        </div>
                    </div>

                    <div class="form-control mt-6">
                        <button type="button"
                                onclick="toggleEdit(this)"
                                class="btn btn-primary w-full">Editar Informações</button>
                        <button type="submit" id="submitEdit"
                                class="btn btn-success mt-4 status-reseter-button hidden">Salvar</button>
                    </div>
                </form>
            </div>
        </div>

        <div class="w-full max-w-7xl">
            <h2 class="text-2xl font-semibold mb-4 text-left">Histórico de Compras</h2>
            <div class="grid grid-cols-1 sm:grid-cols-2 lg:grid-cols-3 gap-8">
                <section class="card card-compact bg-base-200 shadow-xl">
                    <a href="#">
                        <figure>
                            <img class="rounded-t-lg w-full object-cover"
                                 src="https://www.kabum.com.br/_next/image?url=https%3A%2F%2Fimages.kabum.com.br%2Fprodutos%2Ffotos%2F522531%2Fplaca-de-video-rtx-4060-asus-dual-o8g-evo-nvidia-geforce-8gb-gddr6-g-sync-ray-tracing-90yv0jc7-m0na00_1711036187_g.jpg&w=640&q=100"
                                 alt="Placa de vídeo RTX 4060 ASUS Dual 8G EVO OC" />
                        </figure>
                        <div class="card-body">
                            <h2 class="card-title line-clamp-2">Placa de vídeo RTX 4060 ASUS Dual 8G EVO OC NVIDIA GeForce</h2>
                            <div class="card-actions flex justify-between items-center mt-4">
                                <span class="text-xl font-semibold text-secondary">R$ 2.099,99</span>
                            </div>
                        </div>
                    </a>
                </section>

            </div>
        </div>
    </main>
    <script src="./scripts/toggleEdit.js"></script>
    <script src="https://cdn.tailwindcss.com"></script>
</body>
</html>
