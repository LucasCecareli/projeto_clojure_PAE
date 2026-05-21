async function calcularTrastes() {

  // ELEMENTOS DA TELA
  const escala = document.getElementById("escala").value;

  const tabela = document.getElementById("tabela-trastes");

  const mensagem = document.getElementById("mensagem");

  const resumo = document.getElementById("resumo");

  const botao = document.getElementById("botao-calcular");


  // LIMPA RESULTADOS ANTERIORES
  tabela.innerHTML = "";

  mensagem.innerHTML = "";

  resumo.innerHTML = "";


  // VALIDAÇÃO
  if (!escala || escala <= 0) {

    mensagem.innerHTML =
      "Informe uma escala válida em milímetros.";

    return;
  }


  try {

    // ESTADO DE LOADING
    botao.classList.add("loading");

    botao.disabled = true;

    botao.innerText = "CALCULANDO...";


    // REQUISIÇÃO PARA API
    const resposta =
      await fetch(`/api/trastes?escala=${escala}`);


    // VERIFICA ERRO DA API
    if (!resposta.ok) {

      throw new Error(
        "Erro ao calcular os trastes."
      );
    }


    // CONVERTE JSON
    const dados = await resposta.json();

    await new Promise(resolve => setTimeout(resolve, 700));


    // RESUMO
    resumo.innerHTML = `
      <p>
        <strong>Escala:</strong>
        ${escala} mm
      </p>

      <p>
        <strong>Fórmula:</strong>
        d = L × (1 - 1 / 2^(n/12))
      </p>

      <p>
        <strong>Total:</strong>
        ${dados.length} trastes calculados
      </p>
    `;


    // CRIA LINHAS DA TABELA
    dados.forEach((traste) => {

      tabela.innerHTML += `
        <tr>

          <td>
            ${traste.traste}
          </td>

          <td>
            ${traste.espacamento_mm}
          </td>

          <td>
            ${traste.distancia_rastilho_mm}
          </td>

          <td>
            ${traste.distancia_pestana_mm}
          </td>

        </tr>
      `;
    });

  } catch (erro) {

    console.error(erro);

    mensagem.innerHTML =
      "Não foi possível calcular. Verifique se o servidor está rodando.";

  } finally {

    // REMOVE LOADING
    botao.classList.remove("loading");

    botao.disabled = false;

    botao.innerText = "CALCULAR";
  }
}