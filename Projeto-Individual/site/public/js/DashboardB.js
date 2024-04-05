/* Pega os dados dos posts do bd*/
function pegarDadosPost() {
  fetch("/batalhas/listarB")
    .then(function (resposta) {
      console.log("ESTOU NO THEN DO entrar()!")

      if (resposta.ok) {
        console.log(resposta);
        resposta.json().then(json => {
          console.log(json);
          console.log(JSON.stringify(json))
          sessionStorage.BATALHAS = JSON.stringify(json.batalha)
        });
      } else {
        return false;
      }

    }).catch(
      function (erro) {
        res.status(500).json(erro.sqlMessage);

      })

  setTimeout(pegarDadosBatalhas, 1000);
  setTimeout(pegarTodosOsDadosBatalhas, 2000);
  setTimeout(pegarTotalUsuario, 2500);
}



/* Cria um laço de repetição para publicar item por item*/
function carregarFeed() {
  fetch("/feed/listar")
    .then(function (resposta) {
      if (resposta.ok) {
        resposta.json().then(function (resposta) {
          for (contador = 0; contador < resposta.length; contador++) {
            var post = resposta[contador];
            var feed = document.getElementById('div_feedHistory');

            if (post.imagemPost == '') {
              feed.innerHTML += `
                  <div class="post" id="post">
                  <div class="titulo" id="nomeBatalha">
                  ${post.nomeBatalha} </div>
                  <div class="texto" id="textoPostado">${post.conteudo}
                  </div>
                  </div>
                  `;
            } else {
              feed.innerHTML += `
                  <div class="post" id="post">
                  <div class="titulo" id="nomeBatalha">
                  ${post.nomeBatalha} </div>
                  <div class="texto" id="textoPostado">${post.conteudo}
                  </div>
                  <img
                      src="../paginaInicialIns/Imagens/${post.imagemPost}" id="imagemPostada">
              </div>
                  `;
            }
          }
        })
      }
    })
}







/*Pegar dados das batalhas */
function pegarDadosBatalhas() {
  fetch("/batalha/listarB")
    .then(function (resposta2) {
      if (resposta2.ok) {
        console.log(resposta2);
        resposta2.json().then(json => {
          console.log(json);
          console.log(JSON.stringify(json));
          sessionStorage.IMAGEMBATALHAS_BATALHAS = json.imagem;
          setTimeout(carregarImagemBatalhas, 100)
        });
      } else {
        return false;
      }

    }).catch(
      function (erro) {
        res.status(500).json(erro.sqlMessage);

      })
}





function carregarImagemBatalhas() {
  fetch("/batalha/listarB")
    .then(function (resposta2) {
      if (resposta2.ok) {
        resposta2.json().then(function (resposta2) {
          console.log("Dados recebidos das imagens", JSON.stringify(resposta2));

          for (contador = 0; contador < resposta2.length; contador++) {
            var batalhas = resposta2[contador];
            console.log(batalhas);
            var esquerdaPagina = document.getElementById('div_esquerdaPagina');

            esquerdaPagina.innerHTML += `
              <img src="../paginaInicialIns/Imagens/${batalhas.imagem}" id="divimg" onclick="abrirPerfilBatalha('${batalhas.imagem}')">
                  `;

          }
        })
      }
    })
}




/*Pegar todos os dados das batalhas */
var listaIdBatalha = [];
var listaNomeBatalhas = [];
var listaSiglasBatalhas = [];
var listaApresentadorBatalhas = [];
var listaEmailBatalhas = [];
var listaTelefoneBatalhas = [];
var listaImagemBatalhas = [];



function pegarTodosOsDadosBatalhas() {
  fetch("/batalha/buscarTodosBatalha")
    .then(function (resultado) {
      console.log("ESTOU NO THEN DO entrar 5555()!");

      if (resultado.ok) {
        resultado.json()
          .then(json => {
            console.log(json);
            sessionStorage.IDBATALHAS_BATALHAS = json.idBatalha;
            sessionStorage.NOMEBATALHA_BATALHAS = json.nomeBatalha;
            sessionStorage.SIGLAS_BATALHAS = json.siglas;
            sessionStorage.APRESENTADOR1_BATALHAS = json.apresentador1;
            sessionStorage.EMAILBATALHA_BATALHAS = json.emailBatalha;
            sessionStorage.TELEFONEBATALHA_BATALHAS = json.telefoneBatalha;
            sessionStorage.IMAGEM_BATALHAS = json.imagem;
            for (contador = 0; contador < json.length; contador++) {
              var batalhas = json[contador];
              listaIdBatalha.push(batalhas.idBatalha)
              listaNomeBatalhas.push(batalhas.nomeBatalha);
              listaSiglasBatalhas.push(batalhas.siglas);
              listaApresentadorBatalhas.push(batalhas.apresentador1);
              listaEmailBatalhas.push(batalhas.emailBatalha);
              listaTelefoneBatalhas.push(batalhas.telefoneBatalha);
              listaImagemBatalhas.push(batalhas.imagem);
            }
            setTimeout(mostrarResultadoPesquisa, 100)

          })
      } else {
        return false;
      }
    }).catch(
      function (erro) {
        res.status(500).json(erro.sqlMessage)
      }
    )
}













/*Enviar os pots pro banco*/
function publicarPost() {

  var textoPost = input_textoPost.value;
  var imagemPostEnviar = input_imagemPost.value.replace(`C:\\fakepath\\`, "");
  var fkBatalhaP = sessionStorage.IDBATALHA_BATALHAS;


  fetch("/feed/publicarP", {
    method: "POST",
    headers: {
      "Content-Type": "application/json"
    },
    body: JSON.stringify({
      textoPostServer: textoPost,
      imagemPostServer: imagemPostEnviar,
      idServer: fkBatalhaP,
    }),
  })
    .then((req) => {
      window.location = "../Dashboard/DashboardB.html"
    })
    .catch((err) => {
      console.log(err);
    })

}






/*Pegar os dados do ranck */
function pegarTotalUsuario() {
  var rankingLateralDiv = document.getElementById('rankingLateral2');
  rankingLateralDiv.innerHTML += ``;

  fetch("/usuario/totalUsuario")
    .then(function (resposta) {
      if (resposta.ok) {
        resposta.json().then(function (resposta) {
          rankingLateralDiv.innerHTML += `${resposta.totalSeguidores}`;
          setTimeout(pegarDadosRack1, 100)

        })
      }
    })


  rankingLateralDiv.innerHTML += `A batalha mais seguida é `
  setTimeout(pegarDadosRack, 100)
}


function pegarDadosRack() {
  var guardarRack = "";

  var rankDasBatalha1Div = document.getElementById('rankDasBatalha1');
  fetch("/rack/listarR")
    .then(function (resposta) {
      if (resposta.ok) {
        resposta.json().then(function (resposta) {
          guardarRack = `<div>A Batalha Mais Seguida</div>`
          for (contador = 0; contador < resposta.length; contador++) {
            var rackb = resposta[contador];

            guardarRack += `
            <div class="colocao">
            ${rackb.nomeBatalha}
            <div id="contagemSeguidores">${rackb.seguidor}</div>
            </div>
            `;
          }
          guardarRack.innerHTML += `</div>`
          rankDasBatalha1Div.innerHTML += guardarRack
          setTimeout(pegarDadosRack1, 100)

        })
      }
    })

}



function pegarDadosRack1() {
  var guardarRack = "";
  var fkBatalhaRB = 1000;
  fetch("/rack/listarRB",
    {
      method: "POST",
      headers: {
        "Content-Type": "application/json"
      },
      body: JSON.stringify({
        fkBatalhaRBServer: fkBatalhaRB,
      })
    })
    .then(function (resposta) {
      if (resposta.ok) {
        resposta.json().then(function (resposta) {
          var rankDasBatalha2Div = document.getElementById('rankDasBatalha2');
          guardarRack = `
                      <div>Batalha Da Aldeia</div>`;

          for (contador = 0; contador < resposta.length; contador++) {
            var rankb = resposta[contador];

            guardarRack += `
                          <div class="colocao">
                            ${rankb.nomeMc}
                            <div id="contagemSeguidores">${rankb.qtdPonto}</div>
                            </div>
                          `;
          }
          guardarRack.innerHTML += `</div>`
          rankDasBatalha2Div.innerHTML += guardarRack
          setTimeout(pegarDadosRack2, 100)

        })
      }
    })

}


function pegarDadosRack2() {
  var guardarRack = "";
  var fkBatalhaRB = 1001
  fetch("/rack/listarRB",
    {
      method: "POST",
      headers: {
        "Content-Type": "application/json"
      },
      body: JSON.stringify({
        fkBatalhaRBServer: fkBatalhaRB,
      })
    })
    .then(function (resposta) {
      if (resposta.ok) {
        resposta.json().then(function (resposta) {
          var rankDasBatalha3Div = document.getElementById('rankDasBatalha3');
          guardarRack = `
      <div>Batalha Do Coliseu</div>`;

          for (contador = 0; contador < resposta.length; contador++) {
            var rankb = resposta[contador];

            guardarRack += `
          <div class="colocao">
            ${rankb.nomeMc}
            <div id="contagemSeguidores">${rankb.qtdPonto}</div>
            </div>
          `;
          }
          guardarRack.innerHTML += `</div>`
          rankDasBatalha3Div.innerHTML += guardarRack
          setTimeout(pegarDadosRack3, 100)

        })
      }
    })

}

function pegarDadosRack3() {
  var guardarRack = "";
  var fkBatalhaRB = 1004

  fetch("/rack/listarRB",
    {
      method: "POST",
      headers: {
        "Content-Type": "application/json"
      },
      body: JSON.stringify({
        fkBatalhaRBServer: fkBatalhaRB,
      })
    })
    .then(function (resposta) {
      if (resposta.ok) {
        resposta.json().then(function (resposta) {
          var rankDasBatalha4Div = document.getElementById('rankDasBatalha4');
          guardarRack = `
      <div>Batalha Da Linear</div>`;

          for (contador = 0; contador < resposta.length; contador++) {
            var rankb = resposta[contador];

            guardarRack += `
          <div class="colocao">
            ${rankb.nomeMc}
            <div id="contagemSeguidores">${rankb.qtdPonto}</div>
            </div>
          `;
          }
          guardarRack.innerHTML += `</div>`
          rankDasBatalha4Div.innerHTML += guardarRack
          setTimeout(pegarDadosRack4, 100)

        })
      }
    })
}

function pegarDadosRack4() {
  var guardarRack = "";
  var fkBatalhaRB = 1005

  fetch("/rack/listarRB",
    {
      method: "POST",
      headers: {
        "Content-Type": "application/json"
      },
      body: JSON.stringify({
        fkBatalhaRBServer: fkBatalhaRB,
      })
    })
    .then(function (resposta) {
      if (resposta.ok) {
        resposta.json().then(function (resposta) {
          var rankDasBatalha5Div = document.getElementById('rankDasBatalha5');
          guardarRack = `
      <div>Batalha Da Norte</div>`;

          for (contador = 0; contador < resposta.length; contador++) {
            var rankb = resposta[contador];

            guardarRack += `
          <div class="colocao">
            ${rankb.nomeMc}
            <div id="contagemSeguidores">${rankb.qtdPonto}</div>
            </div>
          `;
          }
          guardarRack.innerHTML += `</div>`
          rankDasBatalha5Div.innerHTML += guardarRack

        })
      }
    })
}

function addRank() {
  
  telaFeed.style.display = "none";
  telaPerfilBatalha.style.display = "none";
  telaAddPost.style.display = "none";
  header.style.display = "none";
  pesquisa.style.display = "none";
  mostrarResultadoBatalhas.style.display = "none";
  telaRankDiv.style.display = "flex";


  var guardarRack = `<div class="titulo">Você ainda não tem um rank<br><br><br></div>
  <button onclick='criarRank()'>+</button>`;
  var batalhaSeguida = document.getElementById('div_idBatalha').innerText;
  var rankDasBatalha6Div = document.getElementById('rankDasBatalha6');

  fetch("/rack/verificarRank", {
    method: "POST",
    headers: {
      "Content-Type": "application/json"
    },
    body: JSON.stringify({
      batalhaSeguidaServer: batalhaSeguida,
    }),
  }).then(function (resposta) {
    if (resposta.ok) {
      resposta.json().then(function (resposta) {
        console.log("Dados recebidos: ", JSON.stringify(resposta));
        if (resposta.length > 0) {
          guardarRack = "";

          for (contador = 0; contador < resposta.length; contador++) {
            var rankb = resposta[contador];

            guardarRack += `
                  <div class="colocao">
                    ${rankb.nomeMc}
                    <div id="contagemSeguidores">${rankb.qtdPonto}</div>
                    </div>
                  `;
          }
          guardarRack.innerHTML += `
          </div>`

          rankDasBatalha6Div.innerHTML = guardarRack
          rankDasBatalha6Div.innerHTML += `<button class="button" onclick='apagarRank()'>Apagar Rack</button>`
        }
      });
    }
  })
  rankDasBatalha6Div.innerHTML = guardarRack
}



function apagarRank(){
  var guardarRack = "";
  var batalhaSeguida = document.getElementById('div_idBatalha').innerText;
  var rankDasBatalha6Div = document.getElementById('rankDasBatalha6');

  fetch("/rack/apagarRank", {
    method: "POST",
    headers: {
      "Content-Type": "application/json"
    },
    body: JSON.stringify({
      batalhaSeguidaServer: batalhaSeguida,
    }),
  }).then(function (resposta) {
    if (resposta.ok) {
      resposta.json().then(function (resposta) {
        console.log("Dados recebidos: ", JSON.stringify(resposta));
        if (resposta.length > 0) {
          guardarRack = "";

          for (contador = 0; contador < resposta.length; contador++) {
            var rankb = resposta[contador];

            guardarRack += `
                  <div class="colocao">
                    ${rankb.nomeMc}
                    <div id="contagemSeguidores">${rankb.qtdPonto}</div>
                    </div>
                  `;
          }
          guardarRack.innerHTML += `
          </div>`

          rankDasBatalha6Div.innerHTML = guardarRack
          rankDasBatalha6Div.innerHTML += `<button class="button" onclick='apagarRank()'>Apagar Rack</button>`
        }
      });
    }
  })
  rankDasBatalha6Div.innerHTML = guardarRack
window.location = "../Dashboard/DashboardB.html"
}

function criarRank(){
  criarRankDiv.style.display = "block";
}

function enviarRank(){
  var nomeMc1 = input_nomeMc1.value;
  var nomeMc2 = input_nomeMc2.value;
  var nomeMc3 = input_nomeMc3.value;
  var nomeMc4 = input_nomeMc4.value;
  var nomeMc5 = input_nomeMc5.value;

  var pontos1 = input_pontos1.value;
  var pontos2 = input_pontos2.value;
  var pontos3 = input_pontos3.value;
  var pontos4 = input_pontos4.value;
  var pontos5 = input_pontos5.value;
  var batalhaSeguida = document.getElementById('div_idBatalha').innerText;

  fetch("/rack/cadastrarRank", {
    method: "POST",
    headers: {
        "Content-Type": 'application/json',
    },
    body: JSON.stringify({
      nomeMc1Server: nomeMc1,
      nomeMc2Server: nomeMc2,
      nomeMc3Server: nomeMc3,
      nomeMc4Server: nomeMc4,
      nomeMc5Server: nomeMc5,
      pontos1Server: pontos1,
      pontos2Server: pontos2,
      pontos3Server: pontos3,
      pontos4Server: pontos4,
      pontos5Server: pontos5,
      batalhaSeguidaServer: batalhaSeguida,
    })
})
window.location = "../Dashboard/DashboardB.html"
}








/*Pego os valores das divs*/

var telaInicial = document.getElementById('div_telaInicial');
var telaPerfil = document.getElementById('div_telaPerfil');
var telaFormAjuda = document.getElementById('div_tela_form_ajuda');
var header = document.getElementById('div_header');
var pesquisa = document.getElementById('div_pesquisa');
var telaPerfilBatalha = document.getElementById('div_telaPerfilBatalha');
var telaFeed = document.getElementById('div_feed2');
var telaAddPost = document.getElementById('div_telaAddPost');
var mostrarResultadoBatalhas = document.getElementById('div_mostrarResultadoBatalhas');
var telaRankDiv = document.getElementById('telaRank');
var criarRankDiv = document.getElementById('criarRank');




var idBatalha = sessionStorage.IDBATALHA_BATALHAS;
var batalhaSeguida = document.getElementById('div_idBatalha')
batalhaSeguida.innerHTML = `${idBatalha}`;
var nomeBatalha = document.getElementById('nomeBatalha');
nomeBatalha.innerHTML = sessionStorage.NOMEBATALHA_BATALHAS;
var imagemBatalhaPerfil = document.getElementById('div_imagemBatalhaPerfil');
var imagemBatalhaPerfil2 = sessionStorage.IMAGEM_BATALHAS;
imagemBatalhaPerfil.src = `../paginaInicialIns/Imagens/${imagemBatalhaPerfil2}`;
var nomeBatalha2 = document.getElementById('nomeBatalha2');
nomeBatalha2.innerHTML = sessionStorage.NOMEBATALHA_BATALHAS;
var siglasBatalha = document.getElementById('siglasBatalha');
siglasBatalha.innerHTML = sessionStorage.SIGLAS_BATALHAS;
var apresentador1 = document.getElementById('apresentador1');
apresentador1.innerHTML = sessionStorage.APRESENTADOR1_BATALHAS;
var emailBatalha = document.getElementById('emailBatalha');
emailBatalha.innerHTML = sessionStorage.EMAILBATALHA_BATALHAS;
var telefoneBatalha = document.getElementById('telefoneBatalha');
telefoneBatalha.innerHTML = sessionStorage.TELEFONEBATALHA_BATALHAS;
var senhaBatalha = document.getElementById('senhaBatalha');
senhaBatalha.innerHTML = sessionStorage.SENHABATALHA_BATALHAS;







window.addEventListener("scroll", function () {
  var header = document.getElementById("div_header");
  if (window.scrollY > 50) {
    header.style.position = "fixed";
  } else {
    header.style.position = "absolute";
  }
});





function editarDado1() {
  var editar1 = document.getElementById('input_nomeBatalha');
  editar1.style.display = "flex";
}


function editarDado2() {
  var editar2 = document.getElementById('input_siglasBatalha');
  editar2.style.display = "flex";
}

function editarDado3() {
  var editar3 = document.getElementById('input_apresentador1Batalha');
  editar3.style.display = "flex";
}

function editarDado4() {
  var editar4 = document.getElementById('input_emailBatalha');
  editar4.style.display = "flex";
}

function editarDado5() {
  var editar3 = document.getElementById('input_telefoneBatalha');
  editar3.style.display = "flex";
}

function editarDado6() {
  var editar4 = document.getElementById('input_senhaBatalha');
  editar4.style.display = "flex";
}


function abrirPerfil() {
  telaPerfil.style.display = "flex";
  setTimeout(abrirPerfil2, 500)
}

function abrirPerfil2() {
  telaPerfil.style.opacity = "1";
}


function fecharPerfil() {
  telaPerfil.style.opacity = "0";
  setTimeout(fecharPerfil2, 500)
}

function fecharPerfil2() {
  telaPerfil.style.display = "none";
}




function sairPerfil() {
  window.location = "../paginaInicialIns/paginaInicialIns.html"
}


function abrirAjuda() {
  telaFormAjuda.style.display = "block"
  setTimeout(abrirAjuda2, 500);
}

function abrirAjuda2() {
  telaFormAjuda.style.opacity = "1";
}

function fecharAjuda() {
  telaFormAjuda.style.opacity = "0";
  setTimeout(fecharAjuda2, 500)
}

function fecharAjuda2() {
  telaFormAjuda.style.display = "none"
}

function abrirPesquisa() {
  header.style.display = "none";
  telaAddPost.style.display = "none";
  telaFeed.style.display = "none";
  mostrarResultadoBatalhas.style.display = "flex";
  pesquisa.style.display = "flex";
  telaRankDiv.style.display = "none";
}




function abrirHome() {
  telaFeed.style.display = "flex";
  telaPerfilBatalha.style.display = "none";
  telaAddPost.style.display = "none";
  header.style.display = "flex";
  pesquisa.style.display = "none";
  telaRankDiv.style.display = "none";
  mostrarResultadoBatalhas.style.display = "none";

}




function abrirPerfilBatalha(nomeImagemBatalha) {
  var nomeBatalhaDiv = document.getElementById('div_nomeBatlha');
  var fotoPerfilDiv = document.getElementById('div_fotoPerfil');
  var apresentador1Div = document.getElementById('div_apresentador1');
  var idBatalhaDiv = document.getElementById('div_idBatalha');



  abriuPerfilBatalha = "true";
  telaPerfilBatalha.style.display = "flex";
  telaFeed.style.display = "none";
  mostrarResultadoBatalhas.style.display = "none";
  telaRankDiv.style.display = "none";

  var nomeImagemBatalhaPNG = nomeImagemBatalha;


  if (nomeImagemBatalhaPNG == 'batalha_da_aldeia.png' || nomeImagemBatalhaPNG == 'Batalha Da Aldeia') {
    idBatalhaDiv.innerHTML = listaIdBatalha[0];
    nomeBatalhaDiv.innerHTML = listaNomeBatalhas[0];
    fotoPerfilDiv.src = `../paginaInicialIns/Imagens/${listaImagemBatalhas[0]}`;
    apresentador1Div.innerHTML = `${listaApresentadorBatalhas[0]}`

  } else if (nomeImagemBatalhaPNG == 'batalha_do_coliseu.png' || nomeImagemBatalhaPNG == 'Batalha Do Coliseu') {
    idBatalhaDiv.innerHTML = listaIdBatalha[1];
    nomeBatalhaDiv.innerHTML = listaNomeBatalhas[1];
    fotoPerfilDiv.src = `../paginaInicialIns/Imagens/${listaImagemBatalhas[1]}`;
    apresentador1Div.innerHTML = `${listaApresentadorBatalhas[1]}`

  } else if (nomeImagemBatalhaPNG == 'batalha_da_brasilandia.png' || nomeImagemBatalhaPNG == 'Batalha Da Brasilândia') {
    idBatalhaDiv.innerHTML = listaIdBatalha[2];
    nomeBatalhaDiv.innerHTML = listaNomeBatalhas[2];
    fotoPerfilDiv.src = `../paginaInicialIns/Imagens/${listaImagemBatalhas[2]}`;
    apresentador1Div.innerHTML = `${listaApresentadorBatalhas[2]}`

  } else if (nomeImagemBatalhaPNG == 'batalha_da_leste.png' || nomeImagemBatalhaPNG == 'Batalha Da Leste') {
    idBatalhaDiv.innerHTML = listaIdBatalha[3];
    nomeBatalhaDiv.innerHTML = listaNomeBatalhas[3];
    fotoPerfilDiv.src = `../paginaInicialIns/Imagens/${listaImagemBatalhas[3]}`;
    apresentador1Div.innerHTML = `${listaApresentadorBatalhas[3]}`

  } else if (nomeImagemBatalhaPNG == 'batalha_da_linear.png' || nomeImagemBatalhaPNG == 'Batalha Da Linear') {
    idBatalhaDiv.innerHTML = listaIdBatalha[4];
    nomeBatalhaDiv.innerHTML = listaNomeBatalhas[4];
    fotoPerfilDiv.src = `../paginaInicialIns/Imagens/${listaImagemBatalhas[4]}`;
    apresentador1Div.innerHTML = `${listaApresentadorBatalhas[4]}`

  } else if (nomeImagemBatalhaPNG == 'batalha_da_norte.png' || nomeImagemBatalhaPNG == 'Batalha Da Norte') {
    idBatalhaDiv.innerHTML = listaIdBatalha[5];
    nomeBatalhaDiv.innerHTML = listaNomeBatalhas[5];
    fotoPerfilDiv.src = `../paginaInicialIns/Imagens/${listaImagemBatalhas[5]}`;
    apresentador1Div.innerHTML = `${listaApresentadorBatalhas[5]}`

  } else if (nomeImagemBatalhaPNG == 'batalha_do_ana_rosa.png' || nomeImagemBatalhaPNG == 'Batalha Do Ana Rosa') {
    idBatalhaDiv.innerHTML = listaIdBatalha[6];
    nomeBatalhaDiv.innerHTML = listaNomeBatalhas[6];
    fotoPerfilDiv.src = `../paginaInicialIns/Imagens/${listaImagemBatalhas[6]}`;
    apresentador1Div.innerHTML = `${listaApresentadorBatalhas[6]}`

  } else if (nomeImagemBatalhaPNG == 'batalha_do_tanque.png' || nomeImagemBatalhaPNG == 'Batalha Do Tanque') {
    idBatalhaDiv.innerHTML = listaIdBatalha[7];
    nomeBatalhaDiv.innerHTML = listaNomeBatalhas[7];
    fotoPerfilDiv.src = `../paginaInicialIns/Imagens/${listaImagemBatalhas[7]}`;
    apresentador1Div.innerHTML = `${listaApresentadorBatalhas[7]}`

  } else if (nomeImagemBatalhaPNG == 'batalha_321tempo.png' || nomeImagemBatalhaPNG == 'Batalha 321 Tempo') {
    idBatalhaDiv.innerHTML = listaIdBatalha[8];
    nomeBatalhaDiv.innerHTML = listaNomeBatalhas[8];
    fotoPerfilDiv.src = `../paginaInicialIns/Imagens/${listaImagemBatalhas[8]}`;
    apresentador1Div.innerHTML = `${listaApresentadorBatalhas[8]}`

  } else if (nomeImagemBatalhaPNG == 'batalha_do_estudante.png' || nomeImagemBatalhaPNG == 'Batalha Do Estudante') {
    idBatalhaDiv.innerHTML = listaIdBatalha[9];
    nomeBatalhaDiv.innerHTML = listaNomeBatalhas[9];
    fotoPerfilDiv.src = `../paginaInicialIns/Imagens/${listaImagemBatalhas[9]}`;
    apresentador1Div.innerHTML = `${listaApresentadorBatalhas[9]}`

  } else if (nomeImagemBatalhaPNG == 'batalha_nacional.png' || nomeImagemBatalhaPNG == 'Batalha Do Nacional') {
    idBatalhaDiv.innerHTML = listaIdBatalha[10];
    nomeBatalhaDiv.innerHTML = listaNomeBatalhas[10];
    fotoPerfilDiv.src = `../paginaInicialIns/Imagens/${listaImagemBatalhas[10]}`;
    apresentador1Div.innerHTML = `${listaApresentadorBatalhas[10]}`

  }
  setTimeout(carregarQtdSeguidores, 10);
  setTimeout(verificarSeguidor, 1000);
}




function btnAdicionarPost() {
  pesquisa.style.display = "none";
  header.style.display = "none";
  telaAddPost.style.display = "flex";
  telaRankDiv.style.display = "none";
  mostrarResultadoBatalhas.style.display = "none";
}






/*Pesquisa batalha*/



var listaNomeBatalha = [];

function pesquisarBatalhaFuncao() {
  var pesquisaBatalha = input_pesquisaBatalha.value.toLowerCase();
  fetch("/batalha/buscarBatalha", {
    method: "POST",
    headers: {
      "Content-Type": "application/json"
    },
    body: JSON.stringify({
      pesquisaBatalhaServer: pesquisaBatalha,
    })
  }).then(function (resposta) {
    console.log("ESTOU NO THEN DO entrar 2222()!");

    if (resposta.ok) {
      resposta.json()
        .then(json => {
          console.log(json);
          sessionStorage.NOMEBATALHA_BATALHAS = json.nomeBatalha;
          console.log(resposta + "aqui maca" + nomeBatalha)
          for (contador = 0; contador < json.length; contador++) {
            var batalhasP = json[contador];
            listaNomeBatalha.push(batalhasP.nomeBatalha)
          }
          setTimeout(mostrarResultadoPesquisa, 100)
        })
    } else {
      return false;
    }
  }).catch(
    function (erro) {
      res.status(500).json(erro.sqlMessage)
    }
  )


}


function mostrarResultadoPesquisa() {
  var mostrarResultadoBatalhas = document.getElementById('div_mostrarResultadoBatalhas');
  mostrarResultadoBatalhas.innerHTML = ""
  mostrarResultadoBatalhas.innerHTML += `<div class="headerPesquisa" id="div_pesquisa"> 
  <img src="../paginaInicialIns/Imagens/lupa.png" >
  <input id="input_pesquisaBatalha"  placeholder="Pesquise aqui">
  <button onclick="pesquisarBatalhaFuncao()">Pesquisar</button>`;

  for (var contador = 0; contador < listaNomeBatalha.length; contador++) {
    mostrarResultadoBatalhas.innerHTML += `
      <div class="resultadoBatalha" onclick="abrirPerfilBatalha('${listaNomeBatalha[contador]}')">
    ${listaNomeBatalha[contador]}
</div>
  `;

  }
}




/*Seguidor*/
function seguir() {
  var btnSeguir = document.getElementById('btnSeguir').innerText;
  var batalhaSeguida = document.getElementById('div_idBatalha').innerText;


  if (btnSeguir == "Seguir") {
    fetch("/seguidor/seguir", {
      method: "POST",
      headers: {
        "Content-Type": "application/json"
      },
      body: JSON.stringify({
        idBatalhaServer: idBatalha,
        batalhaSeguidaServer: batalhaSeguida,
      }),
    }).then(function (resposta) {
      console.log("resposta: ", resposta);
      if (resposta.ok) {
        document.getElementById('btnSeguir').innerText = "Deixar de Seguir";
      }
    })
  } else {
    fetch("/seguidor/deixarSeguir", {
      method: "POST",
      headers: {
        "Content-Type": "application/json"
      },
      body: JSON.stringify({
        idBatalhaServer: idBatalha,
        batalhaSeguidaServer: batalhaSeguida
      }),
    }).then(function (resposta) {
      console.log("resposta: ", resposta);
      if (resposta.ok) {
        document.getElementById('btnSeguir').innerText = "Seguir";
      }
    })
  }
}




function carregarQtdSeguidores() {
  var nomeBatalha = document.getElementById('div_nomeBatlha').innerText;
  var mostrarQtdSeguidores = document.getElementById('div_mostrarQtdSeguidores');
  mostrarQtdSeguidores.innerHTML = `0`;
  fetch("/seguidor/seguidores", {
    method: "POST",
    headers: {
      "Content-Type": "application/json"
    },
    body: JSON.stringify({
      nomeBatalhaServer: nomeBatalha,
    }),
  }).then(function (resposta) {
    if (resposta.ok) {
      resposta.json().then(function (resposta) {
        console.log("Dados recebidos: ", JSON.stringify(resposta));

        var qtd = 0;
        for (var contador = 0; contador < resposta.length; contador++) {
          qtd++
        }
        mostrarQtdSeguidores.innerHTML = `${qtd}`

      });
    }
  })
}

function verificarSeguidor() {
  var batalhaSeguida = document.getElementById('div_idBatalha').innerText;
  document.getElementById('btnSeguir').innerText = "Seguir";
  fetch("/seguidor/verificarSeguidor", {
    method: "POST",
    headers: {
      "Content-Type": "application/json"
    },
    body: JSON.stringify({
      idBatalhaServer: idBatalha,
      batalhaSeguidaServer: batalhaSeguida,
    }),
  }).then(function (resposta) {
    if (resposta.ok) {
      resposta.json().then(function (resposta) {
        console.log("Dados recebidos: ", JSON.stringify(resposta));
        var seguindoOuNao = resposta[0];

        if (seguindoOuNao.seguindo == 1) {
          document.getElementById('btnSeguir').innerText = "Deixar de Seguir";
        } else {
          document.getElementById('btnSeguir').innerText = "Seguir";
        }

      });
    }
  })
  setTimeout(FeedPerfil, 200)
}

function FeedPerfil() {
  var nomeBatalha = document.getElementById('div_nomeBatlha').innerText;
  fetch("/feed/feedPerfil", {
    method: "POST",
    headers: {
      "Content-Type": "application/json"
    },
    body: JSON.stringify({
      nomeBatalhaServer: nomeBatalha,
    }),
  }).then(function (resposta) {
    if (resposta.ok) {
      resposta.json().then(function (resposta) {
        console.log("Dados recebidos: ", JSON.stringify(resposta));
        for (contador = 0; contador < resposta.length; contador++) {
          var post = resposta[contador];
          var feed = document.getElementById('div_feedPerfil');

          if (post.imagemPost == '') {
            feed.innerHTML += `
                      <div class="post" id="post">
                      <div class="titulo" id="nomeBatalha">
                      ${post.nomeBatalha} </div>
                      <div class="texto" id="textoPostado">${post.conteudo}
                      </div>
                      </div>
                      `;
          } else {
            feed.innerHTML += `
                      <div class="post" id="post">
                      <div class="titulo" id="nomeBatalha">
                      ${post.nomeBatalha} </div>
                      <div class="texto" id="textoPostado">${post.conteudo}
                      </div>
                      <img
                          src="../paginaInicialIns/Imagens/${post.imagemPost}" id="imagemPostada">
                  </div>
                      `;
          };
        }
      })
    }
  })
}




