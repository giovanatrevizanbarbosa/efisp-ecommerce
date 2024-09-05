<h1 align="center">
    <a href="#">E-fisp 🛒</a>
</h1>

<div align="center">
   <p>E-commerce de informática desenvolvido em Java e JSP utilizando Test-Driven Development (TDD).</p>

   ![Version Badge](https://img.shields.io/badge/version-1.0-blue)
   ![Web OK Badge](https://img.shields.io/badge/web-OK-brightgreen)
   ![Java Badge](https://img.shields.io/badge/Language-Java-red)
</div>

## 🚀 DESCRIÇÃO

O **E-fisp** é um e-commerce de informática que permite aos usuários navegar por produtos, adicionar itens ao carrinho e finalizar compras com um checkout simplificado. O sistema foi desenvolvido utilizando Test-Driven Development (TDD).

Este projeto faz parte do trabalho final da disciplina de Desenvolvimento Orientado a Objetos (DEOO).

## ✅ FEATURES

- [x] Login e registro de usuários
- [x] Navegação por departamentos
- [x] Filtros de produtos
- [x] Carrinho de compras
- [x] Finalização de pedidos
- [x] Perfil de usuário
- [x] Histórico de compras
- [x] Gerenciamento de produtos pelo Admin

## 🎦 DEMONSTRAÇÃO DA APLICAÇÃO

### Imagens

#### Página de Login
![Login](https://github.com/user-attachments/assets/75f0e635-1dad-42a1-9b4c-c27ecc79f999)

#### Página de Cadastro
![Register](https://github.com/user-attachments/assets/fb2b7443-12fa-4398-a499-1eecf2ba59c7)

#### Página Inicial
![Home](https://github.com/user-attachments/assets/ed330958-527c-40b7-a802-4bfd32b69f81)

#### Carrinho de Compras
![Cart](https://i.imgur.com/jC9pVQM.png)

#### Confirmação de Compra
![Checkout1](https://i.imgur.com/jpc4o8f.png)
![Checkout2](https://i.imgur.com/qBpvRAP.png)

#### Perfil do Usuário
![Profile](https://i.imgur.com/xndhXPs.png)
![History](https://i.imgur.com/OEaFREw.png)

#### Detalhes do Produto
![ProductDetails](https://github.com/user-attachments/assets/c6fea241-ecd2-4596-8ccb-96c829c98bc4)

## ⚠️ PRÉ-REQUISITOS

Para rodar o projeto, você vai precisar ter instalado em sua máquina as seguintes ferramentas:

- Java 21
- Apache Tomcat 10

### ⚙️ CONFIGURAÇÃO DO AMBIENTE

1. Clone este repositório:
   ```bash
   git clone https://github.com/giovanatrevizanbarbosa/efisp-ecommerce.git

2. Agora, vamos ajustar algumas coisas. No IntelliJ, abra o Menu e vá para **Project Structure**.
3. Em **Project**, tenha certeza de que o **SDK** e o nível da **Linguagem Java** estejam condizentes.
4. Em **Modules**, adicione o **módulo Web**.
5. Ainda em **Modules**, ajuste os caminhos para o **arquivo web.xml** e para a **pasta webapp**.
6. Agora, em **Libraries**, apenas verifique se todas as bibliotecas do pom.xml estão presentes.
7. Em **Artifacts**, adicione o artefato de **Web Application: Exploded>From modules**, a partir do Modulo Web que fizemos anteriormente.
8. Agora só aplicar.
9. Vamos para a **configuração do servidor Apache Tomcat** agora. Se você ainda não tiver ele baixado, **faça o download em [Apache Tomcat 10](https://tomcat.apache.org/download-10.cgi)**.
10. Na aba de **configurações de execução**, vá em **Edit Configurations**.
11. Adicione o **Tomcat>Local**.
12. Nas **configurações do server**, ajuste o **caminho** para a pasta do Apache Tomcat que você fez o download.
13. Na aba de **Deployment**, adicione o **artefato do projeto**.
14. Aplique as edições e pronto, agora você pode rodar o projeto corretamente.

## 💻 TECNOLOGIAS

- Java
- JavaScript
- Servlet
- JSP
- CSV
- TailwindCSS
- DaisyUI

## 📊 METODOLOGIA DE DESENVOLVIMENTO

![Foto do Trello](https://i.imgur.com/7RDTuLR.png)
*Quadro do Trello utilizado para gerenciamento de tarefas e planejamento do projeto.*

## 👥 DESENVOLVEDORES

- [Cauã Rufino de Sá](https://github.com/CauaDeSa)
- [Giovana Trevizan Barbosa](https://github.com/giovanatrevizanbarbosa)
- [Igor Filipi Cardoso](https://github.com/IgorFilipiCardoso)
- [Natan Salvador Ligabo](https://github.com/natansalvadorligabo)

## 🔑 LICENÇA

Distribuído sob a licença [Apache 2.0](https://github.com/giovanatrevizanbarbosa/efisp-ecommerce/blob/master/LICENSE).
