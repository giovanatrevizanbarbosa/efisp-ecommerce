<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ taglib prefix="fn" uri="jakarta.tags.functions" %>
<%@ taglib prefix="fmt" uri="jakarta.tags.fmt" %>

<html lang="pt-br">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">

  <link href="https://cdn.jsdelivr.net/npm/daisyui@4.12.10/dist/full.min.css" rel="stylesheet" type="text/css" />

  <title>Cadastro de Produto - E-fisp</title>
</head>
<body>
<jsp:include page="../components/navbar.jsp"/>
<main class="hero bg-base-200 min-h-screen">
  <c:if test="${result == 'notRegistered'}">
    <div role="alert" class="alert alert-error fixed top-4 left-1/2 transform -translate-x-1/2 w-fit z-50 mb-40">
      <span>Não foi possível cadastrar o produto. Verifique os dados e tente novamente.</span>
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
    <div class="card bg-base-100 w-full max-w-sm shrink-0 shadow-2xl">
      <form action="add-product" method="post" class="card-body">
        <div class="form-control">
          <label class="label">
            <span class="label-text">Nome</span>
          </label>
          <input type="text" name="name" placeholder="nome" class="input input-bordered" required />
          <span id="error-name" class="text-error hidden"></span>
        </div>
        <div class="form-control">
          <label class="label">
            <span class="label-text">Descrição</span>
          </label>
          <input type="text" name="description" placeholder="descrição" class="input input-bordered" required />
          <span id="error-description" class="text-error hidden"></span>
        </div>
        <div class="form-control">
          <label class="label">
            <span class="label-text">Preço</span>
          </label>
          <input type="number" name="price" placeholder="preço" class="input input-bordered" required />
          <span id="error-price" class="text-error hidden"></span>
        </div>
        <div class="form-control">
          <label class="label">
            <span class="label-text">Quantidade</span>
          </label>
          <input type="number" name="quantity" placeholder="quantidade" class="input input-bordered" required />
          <span id="error-quantity" class="text-error hidden"></span>
        </div>
        <div class="form-control">
          <label class="label">
            <span class="label-text">Departamento</span>
          </label>
          <select name="department" class="select select-bordered">
            <c:forEach var="department" items="${departments}">
              <option value="${department.id()}">${department.name()}</option>
            </c:forEach>
          </select>
        </div>
        <div class="form-control">
          <label class="label">
            <span class="label-text">Marca</span>
          </label>
          <select name="brand" class="select select-bordered">
            <c:forEach var="brand" items="${brands}">
              <option value="${brand.id()}">${brand.name()}</option>
            </c:forEach>
          </select>
        </div>

        <div class="form-control">
          <label class="label">
            <span class="label-text">Imagem</span>
          </label>
          <input type="file" name="photo" id="photo" class="file-input file-input-bordered w-full" />
          <span id="error-image" class="text-error hidden"></span>
        </div>

        <div class="form-control mt-6 space-y-2">
          <button type="submit" class="btn btn-primary">Criar</button>
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
