
API WEB em Clojure para cálculo da posição dos trastes de instrumentos de corda.
# 🎸 Calculadora de Trastes - Clojure API

Projeto desenvolvido para a disciplina de Programação Funcional com Clojure do Instituto Mauá de Tecnologia.

## 📖 Sobre o Projeto

A aplicação consiste em uma API WEB para cálculo da posição dos trastes de instrumentos de corda com afinação temperada, como:

- Violão
- Guitarra
- Baixo
- Viola
- Instrumentos artesanais de luthieria

O sistema recebe o tamanho da escala do instrumento em milímetros e retorna:

- Distância do traste até a pestana
- Distância do traste até o rastilho
- Espaçamento entre os trastes

---

## 🎯 Objetivo

O projeto foi desenvolvido em parceria com o luthier José Valderrama, com o objetivo de integrar a calculadora ao site oficial da oficina.

Além da utilidade prática para construção de instrumentos, a ferramenta também busca:

- Atrair futuros alunos para o curso de luthieria
- Demonstrar conceitos acústicos aplicados
- Valorizar a construção artesanal de instrumentos

---

## 🛠️ Tecnologias Utilizadas

### Backend
- Clojure
- Ring
- Compojure

### Frontend
- HTML5
- CSS3
- JavaScript

---

## 📐 Fórmula Utilizada

A posição dos trastes é calculada pela fórmula da afinação temperada:

```math
d_n = L * (1 - 1 / 2^(n/12))
