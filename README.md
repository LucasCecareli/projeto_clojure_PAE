# Calculadora de Trastes

Aplicação web desenvolvida em **Clojure** para calcular automaticamente o posicionamento dos trastes de instrumentos de corda, utilizando a fórmula matemática padrão da luthieria.

O projeto possui:

- Backend funcional em Clojure
- API REST
- Frontend responsivo
- Integração entre frontend e backend
- Interface inspirada em aplicações premium de luthieria

---

# Tecnologias Utilizadas

## Backend
- Clojure
- Ring
- Compojure
- Cheshire

## Frontend
- HTML5
- CSS3
- JavaScript

## Ferramentas
- VS Code
- Git
- GitHub
- Live Server

---

# 📐 Fórmula Utilizada

O cálculo dos trastes é realizado através da fórmula:

```math
d = L × (1 - 1 / 2^(n/12))
```

# Funcionalidades

Cálculo automático de 24 trastes  
Integração frontend + backend  
API REST em Clojure  
Interface moderna e responsiva  
Exibição:
- Espaçamento entre trastes
- Distância até o rastilho
- Distância até a pestana

---

# 📂 Estrutura do Projeto

```bash
projeto_clojure_PAE/
│
├── public/
│   ├── .img/
│   │   └── logo.png
│   │
│   ├── index.html
│   ├── style.css
│   └── script.js
│
├── src/
│   └── calculadora_trastes/
│       ├── core.clj
│       └── server.clj
│
├── deps.edn
└── README.md
```

---

# ⚙️ Como Executar o Projeto

## 1. Clone o repositório

```bash
git clone https://github.com/LucasCecareli/projeto_clojure_PAE.git
```

---

## 2. Entre na pasta

```bash
cd projeto_clojure_PAE
```

---

## 3. Execute o backend

```bash
clj -M:run
```

O servidor iniciará em:

```txt
http://localhost:3000
```

---

## 4. Execute o frontend

Abra o arquivo:

```txt
public/index.html
```

com o **Live Server** do VS Code.

A aplicação será aberta em:

```txt
http://127.0.0.1:5500/public/index.html
```

# 👨‍💻 Autor

## Lucas Cecareli
## Ewerton da Cruz

Projeto desenvolvido para a disciplina de:

**Programação Funcional com Linguagem Clojure**

Instituto Mauá de Tecnologia

---

# 📄 Licença

Projeto acadêmico desenvolvido para fins educacionais.
