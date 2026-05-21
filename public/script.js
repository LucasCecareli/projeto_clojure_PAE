async function calcularTrastes() {
  const escala = document.getElementById("escala").value;
  const tabela = document.getElementById("tabela-trastes");

  if (!escala || escala <= 0) {
    alert("Informe uma escala válida em milímetros.");
    return;
  }

  tabela.innerHTML = "";

 const resposta = await fetch(`/api/trastes?escala=${escala}`);
  const dados = await resposta.json();

  dados.forEach((traste) => {
    tabela.innerHTML += `
      <tr>
        <td>${traste.traste}</td>
        <td>${traste.espacamento_mm}</td>
        <td>${traste.distancia_rastilho_mm}</td>
        <td>${traste.distancia_pestana_mm}</td>
      </tr>
    `;
  });
}