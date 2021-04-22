# BECA-MOBILE-03-ANDROID---SQUAD-2

Onboarding Mobile Challenge

Bem-vindo ao time!

Esse desafio busca orientar os desenvolvedores Android, recém-chegados, a respeitodaquilo que enxergamos como boas práticas de desenvolvimento de software, no clienteItaú. O desafio consiste em criar um aplicativo que se comunique via REST API, naplataforma CoinAPI(https://docs.coinapi.io/). É necessário que o app liste criptomoedas eque possibilite ver detalhes do volume transacionado de cada moeda, assim comoadicionar moedas como favoritas.

Fluxo principal - Listagem de moedas


Fluxo principal -Listagem de moedas


Fluxo alternativo -Tratativa dos erros (HTTP Errors)
1.  400Bad Request --There is something wrong with your request
2.  401Unauthorized --Your API key is wrong
3.  403 Forbidden --Your API key doesn't have enough privileges to access this resource
4.  429 Too many requests --You have exceeded your API key rate limits
5.  550 No data --You requested specific single item that we don't have at this


Para que esse desafio seja bem-sucedido, devemos seguir os seguintes padrões:
•Arquitetura MVVM;
•Testes unitários em JUnit, Roboletrice / ou Mockk;
•Tratativa dos erros de API;
•Acessibilidade, utilizar https://guia-wcag.com/para referência;
•Reaproveitamento dos objetos visuais;
•Modularização.


As características funcionais e não funcionais do app consistem em:

•Lista de moedas com scrollinginfinito;
•Adicionar uma moeda aos favoritos;
•Visualizaçãopor hora, mês e ano do volume transacionado de cada moeda;
•Controle de estado (se a moeda foi adicionada aos favoritos ou não);
•Indicar como moeda favorita logo na telade listagem das moedas;
•A tela de listagem de favoritos deve ser um modulo a parte assim como a tela dedetalhes (Só pode haver uma tela de detalhes para ser usada no SuperAppe nodetalhamento de moedas favoritas);
•Deve existir uma tela padrão para erro com a opção de “tentar novamente”;
•O design deve ser o mais próximo possível do proposto acima.


Considerações:
•O aplicativo irá consistir em um SuperAppe um módulo principal que irálistar asmoedas favoritas;
•Para funções e/ou componentes visuais em comuns entre SuperAppemóduloprincipal deverá ser construído um segundo modulo “Commons” que serácompartilhado entre SuperAppe modulo principal;
•Para favoritos deverá ser utilizado algum meio de persistência local comoSharedPreferencesou SQLite(não salvando toda resposta da API, apenas chave valor paramarcar uma moeda como favorito).

Bom trabalho!
