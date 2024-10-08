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
    <title>Perfil - E-fisp</title>
</head>
<body>
    <jsp:include page="../components/navbar.jsp"/>

    <main class="flex flex-col items-center m-8 md:mt-16">
        <h1 class="text-3xl font-bold mb-12">Meu Perfil</h1>

        <div class="card bg-base-100 w-full max-w-lg shadow-xl mb-8">
            <div class="card-body">
                <form action="profile" method="post" class="space-y-6">
                    <div class="change-profile">
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
                                   readonly
                                    />
                        </div>
                        <div class="form-control mb-4">
                            <label class="label">
                                <span class="label-text">Nova Senha</span>
                            </label>
                            <input type="password" name="new-password" placeholder="Nova senha"
                                   class="input flex items-center w-full bg-base-300 pointer-events-none"
                                   readonly
                                    />
                        </div>
                        <div class="form-control mb-4">
                            <label class="label">
                                <span class="label-text">Confirmar Nova Senha</span>
                            </label>
                            <input type="password" name="confirm-new-password" placeholder="Confirmar nova senha"
                                   class="input flex items-center w-full bg-base-300 pointer-events-none"
                                   readonly/>
                        </div>
                    </div>

                <c:if test="${admin == null}" >
                    <div class="form-control mt-6">
                        <button type="button"
                                onclick="toggleEdit(this)"
                                class="btn btn-primary w-full">Editar Informações</button>
                        <button type="submit" id="submitEdit"
                                class="btn btn-success mt-4 status-reseter-button hidden">Salvar</button>
                    </div>
                </c:if>
                </form>
            </div>
        </div>

        <c:if test="${admin == null}" >
            <div class="collapse bg-base-200">
                <input type="checkbox" />
                <div class="collapse-title text-2xl font-semibold text-center">Histórico de Compras</div>
                <div class="collapse-content flex gap-5">

                                <c:forEach var="order" items="${orders}">
                                    <c:forEach var="item" items="${order.items()}">
                                    <div class="w-full max-w-xs">
                                        <div class="w-full max-w-lg shadow-xl mb-8">
                                    <section class="card card-compact bg-base-200 shadow-xl">
                                        <a href="#">
                                            <figure>
                                                <img class="rounded-t-lg w-full object-cover"
                                                     src="${item.product.getPhoto()}"
                                                     alt="${item.product.getName()}" />
                                            </figure>
                                            <div class="card-body">
                                                <h2 class="card-title line-clamp-2">${item.product.getName()}</h2>
                                                <div class="card-actions flex justify-between items-center mt-4">
                                                    <span class="text-xl font-semibold text-secondary">${String.format('R$ %.2f', item.product.getPrice())}</span>
                                                </div>
                                            </div>
                                        </a>
                                    </section>
                                        </div>
                                    </div>
                                    </c:forEach>
                                </c:forEach>

                </div>
            </div>
        </c:if>
    </main>
    <script src="./scripts/toggleEdit.js"></script>
    <script src="https://cdn.tailwindcss.com"></script>
</body>
</html>
